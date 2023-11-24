package com.ruoyi.sidebarTree.service.impl;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.sidebarTree.domain.PhenotypeFile;
import com.ruoyi.sidebarTree.domain.vo.PhenotypeDetailVO;
import com.ruoyi.sidebarTree.domain.vo.PhenotypeFileVO;
import com.ruoyi.sidebarTree.mapper.*;
import com.ruoyi.sidebarTree.service.IPhenotypeFileService;
import com.ruoyi.sidebarTree.utils.AsyncUtil;
import com.ruoyi.sidebarTree.utils.CsvUtils;
import com.ruoyi.sidebarTree.utils.FileUtil;
import com.ruoyi.sidebarTree.utils.InfoUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.ruoyi.common.utils.PageUtils.startPage;
import static com.ruoyi.common.utils.SecurityUtils.getLoginUser;
import static com.ruoyi.common.utils.SecurityUtils.getUserId;
import static com.ruoyi.common.utils.Threads.sleep;


/**
 * 表型文件Service业务层处理
 *
 * @author ruoyi
 * @date 2023-07-02
 */
@Service
public class PhenotypeFileServiceImpl implements IPhenotypeFileService
{
    @Autowired
    private PhenotypeFileMapper phenotypeFileMapper;



    @Autowired
    private FileUtil fileUtil;

    @Autowired
    private InfoUtil infoUtil;

    @Autowired
    private AsyncUtil asyncUtil;


    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisCache redisCache;

    /**
     * 查询表型文件
     *
     * @param fileId 表型文件主键
     * @return 表型文件
     */
    @Override
    public PhenotypeFile selectPhenotypeFileByFileId(Long fileId)
    {
        return phenotypeFileMapper.selectPhenotypeFileByFileId(fileId);
    }

    /**
     * 查询表型文件列表
     *
     * @param phenotypeFile 表型文件
     * @return 表型文件
     */
    @Override
    public List<PhenotypeFile> selectPhenotypeFileList(PhenotypeFile phenotypeFile)
    {
        return phenotypeFileMapper.selectPhenotypeFileList(phenotypeFile);
    }

    @Override
    public Long selectPhenotypeFileListCount(PhenotypeFile phenotypeFile)
    {
        return (long) phenotypeFileMapper.selectPhenotypeFileListCountList(phenotypeFile).size();
    }

    @Override
    public List<PhenotypeFileVO> selectPhenotypeFileVOList(PhenotypeFile phenotypeFile)
    {
        List<PhenotypeFile> phenotypeFileList = phenotypeFileMapper.selectPhenotypeFileList(phenotypeFile);
        if(StringUtils.isEmpty(phenotypeFile.getTableName())) {
            //不查历史记录时只保留同tablename最新的文件信息
            phenotypeFileList.sort(Comparator.comparing(PhenotypeFile::getFileId));
            HashMap<String, PhenotypeFile> phenotypeFileMap = new HashMap<>();
            for (PhenotypeFile file : phenotypeFileList) {
                phenotypeFileMap.put(file.getTableName(), file);
            }
            phenotypeFileList.clear();
            for (Map.Entry<String, PhenotypeFile> entry : phenotypeFileMap.entrySet()) {
                phenotypeFileList.add(entry.getValue());
            }
            phenotypeFileList.sort(Comparator.comparing(PhenotypeFile::getFileId));
        }
        ArrayList<PhenotypeFileVO> phenotypeFileVOList = new ArrayList<>();
        for (PhenotypeFile file : phenotypeFileList) {

            phenotypeFileVOList.add(new PhenotypeFileVO(file.getFileId(),file.getFileName(),
                    file.getTableName(),file.getTreeId(),
                    "","",file.getStatus(),file.getYear().substring(0,4),file.getLocation(),file.getUrl(),file.getCreateBy(),file.getCreateTime(),file.getUpdateBy(),file.getUpdateTime(),file.getRemark()));
        }
        return phenotypeFileVOList;
    }

    @Override
    public long selectPhenotypeFileListCountByTableName(String tableName) {
        return phenotypeFileMapper.selectPhenotypeFileListCountByTableName(tableName);
    }

    /**
     * 上传新文件
     */
    @Transactional
    @Override
    public String uploadFile(Long treeId, MultipartFile file, int fileStatus, String remark, String fileName) throws ServiceException, IOException {
        Long userId = getUserId();
        if (file!=null){
            //获取原文件名
            String filename = file.getOriginalFilename();
            if (filename !=null){
                //获取文件地址
                String filePath = fileUtil.getFileUrl(filename,treeId);
                //xlsx转csv
                //获取后缀名
                String suffixName = filename.substring(filename.lastIndexOf("."));
                if (suffixName.equals(".xlsx")) {
                    FileUtil.save(file,filePath);
                    String newFilePath = filePath.substring(0,filePath.length() - 5) + ".csv";
                    CsvUtils.xlsx2Csv(filePath,newFilePath);
                    File delFile = new File(filePath);
                    if(delFile.exists()){
                        delFile.delete();
                    }
                    filePath = newFilePath;
                    filename = filename.substring(0,filename.length() - 5) + ".csv";
                 }else if(!suffixName.equals(".csv")){
                    throw new ServiceException("文件格式错误");
                }else{
                    //1.保存文件
                    boolean save = FileUtil.save(file, filePath);
                    if (!save) throw new ServiceException("文件保存失败");
                }
                PhenotypeFile phenotypeFile = new PhenotypeFile();
                phenotypeFile.setFileName(fileName);
                phenotypeFile.setTableName("phenotype_" + fileName + "_" + RandomStringUtils.randomNumeric(6));
                phenotypeFile.setUrl(filePath);
                phenotypeFile.setRemark(remark);
                phenotypeFile.setStatus(fileStatus);
                phenotypeFile.setTreeId(treeId);
                phenotypeFile.setCreateBy(getUserId().toString());
                phenotypeFileMapper.insertPhenotypeFile(phenotypeFile);
                return phenotypeFile.getTableName();
            } else return null;
        } else return null;
    }

    /**
     * 修改表型文件信息 （只能修改status,remark;其他数据全都为生成，不可修改）
     *
     * @param phenotypeFile 表型文件
     * @return 结果
     */
    @Override
    public int updatePhenotypeFile(PhenotypeFile phenotypeFile)
    {
        PhenotypeFile existFile = phenotypeFileMapper.selectPhenotypeFileByFileId(phenotypeFile.getFileId());
        if(ObjectUtils.isEmpty(existFile)){
            throw new ServiceException("文件不存在");
        }
        String userId = getUserId().toString();
        if(!(existFile.getCreateBy().equals(userId)||userId.equals("1"))){
            throw new ServiceException("只能修改自己上传的文件");
        }
        if(ObjectUtils.isEmpty(phenotypeFile.getStatus())&&ObjectUtils.isEmpty(phenotypeFile.getRemark())
                ||!ObjectUtils.isEmpty(phenotypeFile.getTreeId())
                ||!ObjectUtils.isEmpty(phenotypeFile.getSpeciesId())
                ||!ObjectUtils.isEmpty(phenotypeFile.getPopulationId())
                ||!ObjectUtils.isEmpty(phenotypeFile.getYear())
//                ||!StringUtils.isEmpty(phenotypeFile.getFileName())
                ||!StringUtils.isEmpty(phenotypeFile.getTableName())
                ||!StringUtils.isEmpty(phenotypeFile.getLocation())
                ||!StringUtils.isEmpty(phenotypeFile.getUrl())
                ||!StringUtils.isEmpty(phenotypeFile.getCreateBy())){
        throw new RuntimeException("只能修改status,remark,且不为空");
    }
        phenotypeFile.setUpdateBy(getUserId().toString());
        phenotypeFile.setUpdateTime(DateUtils.getNowDate());
        return phenotypeFileMapper.updatePhenotypeFile(phenotypeFile);
    }

    /**
     * 批量删除表型文件信息
     *
     * @param fileIds 需要删除的表型文件主键
     * @return 结果
     */
    @Override
    public int deletePhenotypeFileByFileIds(Long[] fileIds)
    {
        HashSet<String> tableNameSet = new HashSet<>();
        for (Long fileId : fileIds) {
            //所有同表名全删
            PhenotypeFile existFile = phenotypeFileMapper.selectPhenotypeFileByFileId(fileId);
            if(ObjectUtils.isEmpty(existFile)){
                throw new ServiceException("文件不存在");
            }
            String userId = getUserId().toString();

            if(!(existFile.getCreateBy().equals(userId)||userId.equals("1"))){
                throw new ServiceException("只能修改自己上传的文件");
            }
            tableNameSet.add(existFile.getTableName());
        }
        return 1;
    }

    /**
     * 删除表型文件信息
     *
     * @param fileId 表型文件主键
     * @return 结果
     */
    @Override
    public int deletePhenotypeFileByFileId(Long fileId)
    {
        PhenotypeFile existFile = phenotypeFileMapper.selectPhenotypeFileByFileId(fileId);
        if(ObjectUtils.isEmpty(existFile)){
            throw new ServiceException("文件不存在");
        }
        if(existFile.getCreateBy().equals(getUserId().toString())){
            throw new ServiceException("只能修改自己上传的文件");
        }
        return phenotypeFileMapper.deletePhenotypeFileByTableName(existFile.getTableName());
    }

    @Override
    public int selectTableCount(Long fileId) {
        PhenotypeFile phenotypeFile = phenotypeFileMapper.selectPhenotypeFileByFileId(fileId);
        return phenotypeFileMapper.selectTableCount(phenotypeFile.getTableName());
    }




    @Override
    public List getAreaData() {
        List<Map<String, Object>> areaName = phenotypeFileMapper.getAreaName();
        return areaName;
    }

    /**
     * 在表型文件表里根据FileId查TableName
     *
     * @param fileId
     * @return tableName
     */
    public String selectTableNameByFileId(String fileId) {
        return phenotypeFileMapper.selectTableNameByFileId(fileId);
    }

    /**
     * 是否存在该表
     */
    public Integer ifHaveTable(String tableName) {
        return phenotypeFileMapper.ifHaveTable(tableName);
    }



    /**
     * 在表型文件表里根据FileId查FileName
     *
     * @param fileId
     * @return fileName
     */
    public String selectFileNameByFileId(String fileId) {
        return phenotypeFileMapper.selectFileNameByFileId(fileId);
    }

    /**
     * 更新表型表
     */

    @CacheEvict(value = "selectDetailByFileId",key = "#fileId")
    @Override
    public void updatePhenoTypeFile(Long fileId, Long phenotypeId,HashMap<String, String> map) {
        PhenotypeFile phenotypeFile = phenotypeFileMapper.selectPhenotypeFileByFileId(fileId);
        if (!getUserId().toString().equals(phenotypeFile.getCreateBy())) throw new ServiceException("只能修改自己上传的文件");
        String tableName = phenotypeFile.getTableName();
        System.out.println("tableName::"+tableName);
        System.out.println("phenotypeId::"+phenotypeId);
        for(Map.Entry<String,String> m:map.entrySet()) {
            String key = m.getKey();
            key = "`" + key + "`";
            phenotypeFileMapper.updatePhenotypeFileColum(tableName,phenotypeId, m.getValue(),key);
        }
        String time= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        phenotypeFileMapper.updatePhenotypeFileColum(tableName,phenotypeId,time,"update_time");
        phenotypeFileMapper.updatePhenotypeFileColum(tableName,phenotypeId,getUserId().toString(),"update_by");
    }



    @Override
    public String exportFile(String tableName) {
        String url = phenotypeFileMapper.selectExportFileUrlByTableName("'" + tableName + "'");
        PhenotypeFile phenotypeFile = phenotypeFileMapper.selectLatestPhenotypeFileByTableName(tableName);
        if(ObjectUtils.isEmpty(phenotypeFile))
            throw new ServiceException("该表不存在");
        List<Long> collect = getLoginUser().getUser().getRoles().stream().mapToLong(SysRole::getRoleId).boxed().collect(Collectors.toList());
        if(!collect.contains(1L) && !collect.contains(5L)){
            if(!phenotypeFile.getCreateBy().equals(getUserId().toString()))
                throw new ServiceException("无权限");
        }
        if (StringUtils.isEmpty(url) || !Files.exists(Paths.get(url))){
            return null;
        }else{
            return url;
        }
    }




    public PhenotypeFile havePermission(String tableName) {
        Long userId = getUserId();
        PhenotypeFile phenotypeFile = phenotypeFileMapper.selectLatestPhenotypeFileByTableName(tableName);
        if (!userId.toString().equals(phenotypeFile.getCreateBy()) && userId != 1) throw new ServiceException("无权限,只有文件的创建用户和管理员可以操作");
        else return phenotypeFile;
    }

    public String getTableNameByFileId(String fileId) {
        return phenotypeFileMapper.getTableNameByFileId(fileId);
    }





    @Override
    public long selectTableLineCountByFileId(Long fileId) {
        return phenotypeFileMapper.selectTableCount(phenotypeFileMapper.getTableNameByFileId(String.valueOf(fileId)));
    }
}
