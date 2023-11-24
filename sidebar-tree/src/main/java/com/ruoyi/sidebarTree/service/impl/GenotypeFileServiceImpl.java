package com.ruoyi.sidebarTree.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.ServerException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.sidebarTree.pythonCode.PythonUse;
import com.ruoyi.sidebarTree.utils.FileUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.ruoyi.sidebarTree.mapper.GenotypeFileMapper;
import com.ruoyi.sidebarTree.domain.GenotypeFile;
import com.ruoyi.sidebarTree.service.IGenotypeFileService;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import static com.ruoyi.common.utils.PageUtils.startPage;
import static com.ruoyi.common.utils.SecurityUtils.getLoginUser;
import static com.ruoyi.common.utils.SecurityUtils.getUserId;
import static com.ruoyi.common.utils.Threads.sleep;

/**
 * 基因型文件Service业务层处理
 *
 * @author ruoyi
 * @date 2023-07-06
 */
@Service
public class GenotypeFileServiceImpl implements IGenotypeFileService
{
    @Autowired
    private GenotypeFileMapper genotypeFileMapper;


    @Autowired
    private FileUtil fileUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private PlatformTransactionManager txManager;

    @Autowired
    @Lazy
    private PythonUse pythonUse;

    /**
     * 查询基因型文件
     *
     * @param fileId 基因型文件主键
     * @return 基因型文件
     */
    @Override
    public GenotypeFile selectGenotypeFileByFileId(Long fileId)
    {
        return genotypeFileMapper.selectGenotypeFileByFileId(fileId);
    }

    /**
     * 查询基因型文件列表
     *
     * @param genotypeFile 基因型文件
     * @return 基因型文件
     */
    @Override
    public List<GenotypeFile> selectGenotypeFileList(GenotypeFile genotypeFile)
    {
        List<GenotypeFile> genotypeFileList = genotypeFileMapper.selectGenotypeFileList(genotypeFile);
        if(StringUtils.isEmpty(genotypeFile.getTableName())){
            //只留最新的
            genotypeFileList.sort(Comparator.comparing(GenotypeFile::getFileId));
            HashMap<String, GenotypeFile> genotypeFileHashMap = new HashMap<>();
            for (GenotypeFile file : genotypeFileList) {
                genotypeFileHashMap.put(file.getTableName(),file);
            }
            genotypeFileList.clear();
            genotypeFileList.addAll(genotypeFileHashMap.values());
            genotypeFileList.sort(Comparator.comparing(GenotypeFile::getFileId));
        }
        return genotypeFileList;
    }

    @Override
    public long selectGenotypeFileListCountByTableName(String tableName) {
        return genotypeFileMapper.selectGenotypeFileListCountByTableName(tableName);
    }

    @Override
    public Long selectGenotypeFileListCount(GenotypeFile genotypeFile)
    {
        return (long)genotypeFileMapper.selectGenotypeFileStringList(genotypeFile).length;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void uploadFile(Long treeId, MultipartFile file, int fileStatus, String remark, String fileName) throws IOException {
        //500行拆sql，600列拆表
        if(file != null){
            //获取原文件名
            String filename = file.getOriginalFilename();
            //获取后缀名
            String suffixName = filename.substring(filename.lastIndexOf("."));
            if (!suffixName.equals(".vcf")) throw new ServiceException("上传的文件不是vcf");
            String filePath = fileUtil.getFileUrl(filename,treeId);
            GenotypeFile genotypeFile = new GenotypeFile();
            genotypeFile.setFileName(fileName);
            genotypeFile.setTableName("genotype_" + fileName + "_" + RandomStringUtils.randomNumeric(6));
            genotypeFile.setUrl(filePath);
            genotypeFile.setRemark(remark);
            genotypeFile.setStatus((long) fileStatus);
            genotypeFile.setTreeId(treeId);
            genotypeFile.setCreateBy(getUserId().toString());
            // 1. 保存文件
            boolean save = FileUtil.save(file, filePath);
            if (!save) throw new ServiceException("文件保存失败");


                    genotypeFileMapper.insertGenotypeFile(genotypeFile);

                }


        }






    //固定列索引
    private Integer[] createFixedTableColumIndex(String[] headers){
        Integer[] index = new Integer[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
        for (int i = 0; i < headers.length; i++) {
            if(headers[i].equalsIgnoreCase("#CHROM")){
                index[0] = i;
            }else if(headers[i].equalsIgnoreCase("POS")){
                index[1] = i;
            }else if(headers[i].equalsIgnoreCase("ID")){
                index[2] = i;
            }else if(headers[i].equalsIgnoreCase("REF")){
                index[3] = i;
            }else if(headers[i].equalsIgnoreCase("ALT")){
                index[4] = i;
            }else if(headers[i].equalsIgnoreCase("QUAL")){
                index[5] = i;
            }else if(headers[i].equalsIgnoreCase("FILTER")){
                index[6] = i;
            }else if(headers[i].equalsIgnoreCase("INFO")){
                index[7] = i;
            }else if(headers[i].equalsIgnoreCase("FORMAT")) {
                index[8] = i;
            }
            if(!Arrays.asList(index).contains(-1)){
                return index;
            }
        }
        if(!Arrays.asList(index).contains(-1)){
            return index;
        }
        throw new ServiceException("固定列信息不全");
    }

    /**
     * 修改基因型文件
     *
     * @param genotypeFile 基因型文件
     * @return 结果
     */
    @Override
    public int updateGenotypeFile(GenotypeFile genotypeFile)
    {
        genotypeFile.setUpdateTime(DateUtils.getNowDate());
        return genotypeFileMapper.updateGenotypeFile(genotypeFile);
    }

    /**
     * 批量删除基因型文件
     *
     * @param fileIds 需要删除的基因型文件主键
     * @return 结果
     */
    @Override
    public int deleteGenotypeFileByFileIds(Long[] fileIds)
    {
        HashMap<String, Integer> tableNameMap = new HashMap<>();
        for (Long fileId : fileIds) {
            GenotypeFile genotypeFile = genotypeFileMapper.selectGenotypeFileByFileId(fileId);
            tableNameMap.put(genotypeFile.getTableName(),genotypeFile.getTableNum());
        }
        return 1;
    }

    /**
     * 删除基因型文件信息
     *
     * @param fileId 基因型文件主键
     * @return 结果
     */
    @Override
    public int deleteGenotypeFileByFileId(Long fileId)
    {
        return genotypeFileMapper.deleteGenotypeFileByFileId(fileId);
    }

    @Override
    @Transactional
    public String updateGenoTypeFile(Long fileId, Long genotypeId, HashMap<String, String> infoMap) {
        GenotypeFile genotypeFile = genotypeFileMapper.selectGenotypeFileByFileId(fileId);
        String tableName = genotypeFile.getTableName();
        ArrayList<List<String>> columnLists = new ArrayList<>();
        List<String> infoColumnList = genotypeFileMapper.selectAllSortedColumnByTableName(tableName);
        columnLists.add(infoColumnList);

        //更新sql语句list
        ArrayList<StringBuilder> updateSqlBuilderList = new ArrayList<>();
        for (int i = -1; i < columnLists.size() - 1; i++) {
            StringBuilder updateSqlBuilder = new StringBuilder("update " + tableName + (i == -1 ? "" : "_" + i) + " set ");
            updateSqlBuilderList.add(updateSqlBuilder);
        }
        //遍历放信息
        //判断该表是否有更新
        boolean[] isUpdate = new boolean[columnLists.size()];
        infoMap.forEach((key,value) -> {
            //如果是固定列信息，转列名
            if(key.equalsIgnoreCase("#CHROM"))
                key = "chrom";
            else if(key.equalsIgnoreCase("POS"))
                key = "position";
            else if(key.equalsIgnoreCase("ID"))
                key = "id";
            else if(key.equalsIgnoreCase("REF"))
                key = "ref";
            else if(key.equalsIgnoreCase("ALT"))
                key = "alt";
            else if(key.equalsIgnoreCase("QUAL"))
                key = "qual";
            else if(key.equalsIgnoreCase("FILTER"))
                key = "filter";
            else if(key.equalsIgnoreCase("INFO"))
                key = "info";
            else if(key.equalsIgnoreCase("FORMAT"))
                key = "format";
            //判断该放进哪个表,未知列直接跳过
            for (int i = 0; i < columnLists.size(); i++) {
                if(columnLists.get(i).contains(key)){
                    //放进该表
                    updateSqlBuilderList.get(i).append("`").append(key).append("` = ").append("'").append(value).append("'").append(",");
                    isUpdate[i] = true;
                }
            }
        });
        return tableName;
    }

    @Async
    @Override
    public void waitUpdate(String tableName) throws IOException {
        Object o = redisTemplate.opsForValue().get("exportGenoTypeFile:" + tableName);
        if (!ObjectUtils.isEmpty(o)){
            return;
        }
        redisTemplate.opsForValue().setIfAbsent("exportGenoTypeFile:" + tableName,1,60, TimeUnit.MINUTES);
        exportData(tableName);
    }

    @Override
    public List<String> selectTableColumnByFileId(Long fileId) {
        GenotypeFile genotypeFile = genotypeFileMapper.selectGenotypeFileByFileId(fileId);
        String tableName = genotypeFile.getTableName();
        List<String> columnList = genotypeFileMapper.selectAllSortedColumnByTableName(tableName);
        for (int i = 0; i < genotypeFile.getTableNum(); i++) {
            //拿每个分表的列名
            List<String> geneMapList = genotypeFileMapper.selectAllSortedColumnByTableName(tableName + "_" + i);
            columnList.addAll(geneMapList);
        }
        //fixme 暂时只要100列
        if(columnList.size() > 100){
            columnList = columnList.subList(0,100);
        }
        return columnList;
    }

    @Override
    public List<LinkedHashMap<String,String>> selectDetailByFileId(Long fileId,boolean startPage) {
        GenotypeFile genotypeFile = genotypeFileMapper.selectGenotypeFileByFileId(fileId);
        String tableName = genotypeFile.getTableName();
        if(startPage)
            startPage();
        List<LinkedHashMap<String, String>> result = flattenResult(genotypeFileMapper.selectDetailByTableName(tableName));
        for (int i = 0; i < genotypeFile.getTableNum(); i++) {
            //拿每个分表的列名
            if(startPage)
                startPage();
            List<LinkedHashMap<String,String>> geneMapList = flattenResult(genotypeFileMapper.selectDetailByTableName(tableName + "_" + i));
            for (int j = 0; j < result.size(); j++) {
                result.get(j).remove("create_by");
                result.get(j).remove("create_time");
                result.get(j).remove("update_by");
                result.get(j).remove("update_time");
                result.get(j).putAll(geneMapList.get(j));
            }
        }
        //fixme 暂时只返100列
        for (int i = 0; i < result.size(); i++) {
            LinkedHashMap<String, String> stringStringLinkedHashMap = result.get(i);
            LinkedHashMap<String, String> newMap = new LinkedHashMap<>();
            int count = 0;
            for (String key : stringStringLinkedHashMap.keySet()) {
                if(count >= 100) break;
                newMap.put(key,stringStringLinkedHashMap.get(key));
                count++;
            }
            result.set(i,newMap);
        }


        return result;
    }

    @Override
    public TableDataInfo selectHistoryDetailByFileId(Long fileId, int pageNum, int pageSize) throws IOException {
        GenotypeFile genotypeFile = genotypeFileMapper.selectGenotypeFileByFileId(fileId);
        //按目录读文件拿数据
        CsvReader csvReader = new CsvReader(genotypeFile.getUrl(), '\t', StandardCharsets.UTF_8);
        if(!csvReader.readHeaders()) throw new ServiceException("空表头");
        String[] headers = csvReader.getHeaders();
        if (headers[0].equals("#CHROM")) headers[0] = "CHROM";
        //拿数据
        List<LinkedHashMap<String, String>> result = new ArrayList<>();
        int lineCount = 0;
        while(csvReader.readRecord()){
            if(lineCount < (pageNum - 1) * pageSize){
                lineCount++;
                continue;
            }
            if(lineCount >= pageNum * pageSize) {
                lineCount++;
                break;
            }
            LinkedHashMap<String, String> map = new LinkedHashMap<>();
            for (int i = 0; i < headers.length; i++) {
                map.put(headers[i],csvReader.get(i));
            }
            result.add(map);
            lineCount ++;
        }
        while (csvReader.readRecord()){
            lineCount++;
        }
        //设置总行数
        TableDataInfo tableDataInfo = new TableDataInfo();
        tableDataInfo.setCode(HttpStatus.SUCCESS);
        tableDataInfo.setMsg("查询成功");
        tableDataInfo.setTotal(lineCount);
        tableDataInfo.setRows(result);
        return tableDataInfo;


    }

    @Override
    public long selectGenotypeDataCountByfileId(Long fileId) {
        return genotypeFileMapper.selectTableLineCountByTableName(genotypeFileMapper.selectGenotypeFileByFileId(fileId).getTableName());
    }

    public String exportFile(String tableName) {
        String url = genotypeFileMapper.selectExportFileUrlByTableName("'" + tableName + "'");
        GenotypeFile genotypeFile = genotypeFileMapper.selectLatestGenotypeFileByTableName(tableName);
        if(ObjectUtils.isEmpty(genotypeFile))
            throw new ServiceException("该表不存在");
        List<Long> collect = getLoginUser().getUser().getRoles().stream().mapToLong(SysRole::getRoleId).boxed().collect(Collectors.toList());
        if(!collect.contains(1L) && !collect.contains(5L)){
            if(!genotypeFile.getCreateBy().equals(getUserId().toString()))
                throw new ServiceException("无权限");
        }
        if (StringUtils.isEmpty(url) || !Files.exists(Paths.get(url))){
            return null;
        }else{
            return url;
        }
    }

    @Async
    @Override
    public void exportData(String tableName) throws IOException {
        while (!ObjectUtils.isEmpty(redisTemplate.opsForValue().get("exportGenoTypeFileExecution:" + tableName))){
            sleep(1000);
        }
        //任务队列中取出
        redisTemplate.delete("exportGenoTypeFile:" + tableName);
        //放入执行队列
        redisTemplate.opsForValue().setIfAbsent("exportGenoTypeFileExecution:" + tableName,1,60, TimeUnit.MINUTES);
        try{
            String url = genotypeFileMapper.selectExportFileUrlByTableName("'" + tableName + "'");
            if(!StringUtils.isEmpty(url) && Files.exists(Paths.get(url))){
                Files.delete(Paths.get(url));
            }
            genotypeFileMapper.deleteExportFileByTableName(tableName);
            System.out.println("开始导出");
            GenotypeFile genotypeFile = genotypeFileMapper.selectLatestGenotypeFileByTableName(tableName);
            if(ObjectUtils.isEmpty(genotypeFile))
                throw new ServiceException("该表不存在");
            //拿数据
            List<LinkedHashMap<String, String>> detailMapList = selectDetailByFileId(genotypeFile.getFileId(),false);
            //获取列名
            List<String> columnList = genotypeFileMapper.selectAllSortedColumnByTableName(tableName);
            columnList.remove("genotype_id");
            columnList.remove("create_by");
            columnList.remove("create_time");
            columnList.remove("update_by");
            columnList.remove("update_time");
            columnList.remove("remark");
            for (int i = 0; i < genotypeFile.getTableNum(); i++) {
                columnList.addAll(genotypeFileMapper.selectAllSortedColumnByTableName(tableName + "_" + i));
                columnList.remove("genotype_id");
            }
            //创建vcf
            String path = fileUtil.getFileUrl(genotypeFile.getFileName() + ".vcf",genotypeFile.getTreeId());
            new File(path).createNewFile();
            //写入列名，之前先把列名暂时换掉
            List<String> dataColumn = new ArrayList<>(columnList);
            for (int i = 0; i < dataColumn.size(); i++) {
                if (dataColumn.get(i).equals("chrom")) dataColumn.set(i,"#CHROM ");
                if (dataColumn.get(i).equals("position")) dataColumn.set(i,"POS");
                dataColumn.set(i,dataColumn.get(i).toUpperCase());
            }
            CsvWriter csvWriter = new CsvWriter(path, '\t', StandardCharsets.UTF_8);
            //关闭字段校验
            csvWriter.setUseTextQualifier(false);
            //写入数据
            csvWriter.writeRecord(dataColumn.toArray(new String[0]));
            for (LinkedHashMap<String, String> detailMap : detailMapList) {
                ArrayList<String> valueList = new ArrayList<>();
                for (String column : columnList) {
                    if (detailMap.get(column) != null)
                        valueList.add(((Object)detailMap.get(column)).toString());
                    else
                        valueList.add("");

                }
                csvWriter.writeRecord(valueList.toArray(new String[0]));
            }
            csvWriter.close();
            //放进文件表
            GenotypeFile updFile = new GenotypeFile();
            updFile.setTableName(tableName);
            updFile.setTreeId(-1L);
            updFile.setUrl(path);
            genotypeFileMapper.insertGenotypeFile(updFile);
        }catch (Exception e){
            throw e;
        }finally {
            //执行队列中取出
            redisTemplate.delete("exportGenoTypeFileExecution:" + tableName);
        }
    }

    /**
     * 展平结果
     *
     * @param result 结果
     * @return {@link List}<{@link LinkedHashMap}<{@link String}, {@link String}>>
     */
    @Override
    public List<LinkedHashMap<String, String>> flattenResult(List<LinkedHashMap<String, Object>> result) {
        List<LinkedHashMap<String, String>> flattenedResult = new ArrayList<>();
        for (LinkedHashMap<String, Object> row : result) {
            LinkedHashMap<String, String> flattenedRow = new LinkedHashMap<>();
            flattenNestedMap(row, flattenedRow, null);
            flattenedResult.add(flattenedRow);
        }
        return flattenedResult;
    }

    @Override
    public void flattenNestedMap(Map<String, Object> original, Map<String, String> flattened, String prefix) {
        for (Map.Entry<String, Object> entry : original.entrySet()) {
            String newKey = prefix != null ? prefix + "." + entry.getKey() : entry.getKey();
            if (entry.getValue() instanceof Map) {
                @SuppressWarnings("unchecked")
                Map<String, Object> nestedMap = (Map<String, Object>) entry.getValue();
                flattenNestedMap(nestedMap, flattened, newKey);
            } else {
                flattened.put(newKey, entry.getValue().toString());
            }
        }
    }

    @Override
    public String selectTableNameByFileId(Long fileId) {
        GenotypeFile genotypeFile = genotypeFileMapper.selectGenotypeFileByFileId(fileId);
        if(ObjectUtils.isEmpty(genotypeFile))
            throw new ServiceException("该文件不存在");
        return genotypeFile.getTableName();
    }

    @Async
    @Override
    public void excutePCA(String tableName){
        GenotypeFile genotypeFile = genotypeFileMapper.selectLatestGenotypeFileByTableName(tableName);
        pythonUse.usePCA(String.valueOf(genotypeFile.getFileId()));
    }

    //异步执行，将上传的vcf转为csv另外存储
    @Async
    @Override
    public void trans2CSV(String tableName){
        GenotypeFile genotypeFile = genotypeFileMapper.selectLatestGenotypeFileByTableName(tableName);
        String url = genotypeFile.getUrl();
        System.out.println("调用transToCSV将vcf转换为csv.........");
        System.out.println("参数vcf路径为："+ url);
        pythonUse.transToCSV(url);
    }

    /**
     * 在基因型文件表里根据FileId查FileName
     *
     * @param fileId
     * @return fileName
     */
    public String selectFileNameByFileId(String fileId) {
        return genotypeFileMapper.selectFileNameByFileId(fileId);
    }

    @Override
    public String getImgUrl(Long fileId) {
        //构造地址，查验是否存在
        String url = "directory/prefix_" + fileId;
        if (Files.exists(Paths.get(url))) {
            return url;
        } else {
            throw new ServiceException("图片不存在");
        }
    }

    @Override
    public List<Long[]> getChromDensity(String tableName) {
        //预设值1M
        int intervalSize = 1000000;
        List<Map> maps = genotypeFileMapper.selectChromDensityByTableName(tableName, intervalSize);
        ArrayList<Long[]> result = new ArrayList<>();
        for (Map<String,Object> map : maps) {
            Long[] obj = {Long.parseLong(((String) map.get("chrom")).replace("chr", "")), (Long) map.get("interval"), (Long) map.get("count")};
            result.add(obj);
        }
        return result;
    }

    @Override
    public List<String> getMaterialListByTableName(String tableName) {
        List<String> columnList = new ArrayList<>();
        GenotypeFile genotypeFile = genotypeFileMapper.selectLatestGenotypeFileByTableName(tableName);
        if (ObjectUtils.isEmpty(genotypeFile)) throw new ServiceException("该表不存在");
        for (int i = 0; i < genotypeFile.getTableNum(); i++) {
            //拿每个分表的列名
            List<String> geneMapList = genotypeFileMapper.selectAllSortedColumnByTableName(tableName + "_" + i);
            columnList.addAll(geneMapList);
        }
        columnList.remove("genotype_id");
        return columnList;
    }

    @Override
    public List<Map> getChromRatioAndMaxPos(String tableName) {
        GenotypeFile genotypeFile = genotypeFileMapper.selectLatestGenotypeFileByTableName(tableName);
        if (ObjectUtils.isEmpty(genotypeFile)) throw new ServiceException("该表不存在");
        List<Map> maps = genotypeFileMapper.selectChromRatioByTableName(tableName);
        return maps;
    }

    @Override
    public List<LinkedHashMap> getMaterialInfo(String tableName, String materialName, String chrom, long start, long end) {
        GenotypeFile genotypeFile = genotypeFileMapper.selectLatestGenotypeFileByTableName(tableName);
        if (ObjectUtils.isEmpty(genotypeFile)) throw new ServiceException("该表不存在");
        for (int i = 0; i < genotypeFile.getTableNum(); i++) {
            //拿每个分表的列名
            List<String> geneMapList = genotypeFileMapper.selectAllSortedColumnByTableName(tableName + "_" + i);
            if(geneMapList.contains(materialName)){
                //找到列，开始查数据
                List<LinkedHashMap> basicInfo = genotypeFileMapper.selectBasicInfoByTableName(tableName, chrom, start, end);
                Map<String,Map> materialInfo = genotypeFileMapper.selectMaterialInfo(tableName + "_" + i, materialName);
                for (LinkedHashMap map : basicInfo) {
                    String origin = (String)materialInfo.get(map.get("genotype_id")).get("material");
                    map.put("original",origin);
                    if(origin.equals("0/0"))
                        map.put("processed", map.get("ref") + "/" + map.get("ref"));
                    else if(origin.equals("0/1"))
                        map.put("processed", map.get("ref") + "/" + map.get("alt"));
                    else if(origin.equals("1/1"))
                        map.put("processed", map.get("alt") + "/" + map.get("alt"));
                    else
                        map.put("processed", "NA");
                }
                return basicInfo;
            }
        }
        throw new ServiceException("该材料不存在");
    }

    @Override
    public List<List<Integer>> getHeatMap(String tableName, String[] materialName, String chrom, long start, long end) {
        List<List<Integer>> result = new ArrayList<>();
        GenotypeFile genotypeFile = genotypeFileMapper.selectLatestGenotypeFileByTableName(tableName);
        if (ObjectUtils.isEmpty(genotypeFile)) throw new ServiceException("该表不存在");
        //查基本数据
        List<LinkedHashMap> basicInfoList = genotypeFileMapper.selectBasicInfoByTableName(tableName, chrom, start, end);
        //数据索引
        ArrayList<List<String>> indexList = new ArrayList<>();
        for (int i = 0; i < genotypeFile.getTableNum(); i++) {
            ArrayList<String> containList = new ArrayList<>();
            //拿每个分表的列名
            List<String> geneMapList = genotypeFileMapper.selectAllSortedColumnByTableName(tableName + "_" + i);
            for (String s : materialName) {
                if (geneMapList.contains(s)) {
                    //找到列,放进索引
                    containList.add(s);
                }
            }
            indexList.add(containList);
        }
        //查数据
        Map<Long, Map> materialDataMap = new HashMap<>();
        for (int i = 0; i < indexList.size(); i++) {
            if(indexList.get(i).isEmpty()) continue;
            StringBuilder columParamBuilder = new StringBuilder();
            for (String contain : indexList.get(i)) {
                columParamBuilder.append("`").append(contain).append("`,");
            }
            String columParam = columParamBuilder.deleteCharAt(columParamBuilder.length() - 1).toString();
            Map<Long,Map> maps = genotypeFileMapper.selectHeatMapInfoByTableName(tableName + "_" + i, columParam);
            if(materialDataMap.isEmpty()) materialDataMap.putAll(maps);
            else{
                for (Long integer : maps.keySet()) {
                    materialDataMap.get(integer).putAll(maps.get(integer));
                }
            }
        }
        for (int i = 0; i < basicInfoList.size(); i++) {
            Map materialData = materialDataMap.get(basicInfoList.get(i).get("genotype_id"));
            materialData.remove("genotype_id");
            for (int j = 0; j < materialName.length; j++) {
                ArrayList<Integer> row = new ArrayList<>();
                row.add(i + 1);
                row.add(j + 1);
                String info = (String) materialData.get(materialName[j]);
                if(info.equals("0/0"))
                    row.add(0);
                else if(info.equals("0/1"))
                    row.add(1);
                else if(info.equals("1/1"))
                    row.add(2);
                else
                    row.add(-1);
                result.add(row);
            }
        }
        return result;
    }
}
