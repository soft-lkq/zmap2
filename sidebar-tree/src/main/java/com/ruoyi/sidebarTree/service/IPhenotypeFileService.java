package com.ruoyi.sidebarTree.service;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.sidebarTree.domain.PhenotypeFile;
import com.ruoyi.sidebarTree.domain.vo.PhenotypeDetailVO;
import com.ruoyi.sidebarTree.domain.vo.PhenotypeFileVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 表型文件Service接口
 *
 * @author ruoyi
 * @date 2023-07-02
 */
public interface IPhenotypeFileService {
    /**
     * 查询表型文件
     *
     * @param fileId 表型文件主键
     * @return 表型文件
     */
    public PhenotypeFile selectPhenotypeFileByFileId(Long fileId);

    /**
     * 查询表型文件列表
     *
     * @param phenotypeFile 表型文件
     * @return 表型文件集合
     */
    public List<PhenotypeFile> selectPhenotypeFileList(PhenotypeFile phenotypeFile);

    Long selectPhenotypeFileListCount(PhenotypeFile phenotypeFile);

    List<PhenotypeFileVO> selectPhenotypeFileVOList(PhenotypeFile phenotypeFile);

    /**
     * 修改表型文件
     *
     * @param phenotypeFile 表型文件
     * @return 结果
     */
    public int updatePhenotypeFile(PhenotypeFile phenotypeFile);

    /**
     * 批量删除表型文件
     *
     * @param fileIds 需要删除的表型文件主键集合
     * @return 结果
     */
    public int deletePhenotypeFileByFileIds(Long[] fileIds);

    /**
     * 删除表型文件信息
     *
     * @param fileId 表型文件主键
     * @return 结果
     */
    public int deletePhenotypeFileByFileId(Long fileId);

    String uploadFile(Long treeId, MultipartFile file, int fileStatus, String remark, String fileName) throws ServiceException, IOException;

    /**
     * 在表型文件表里根据FileId查TableName
     *
     * @param fileId
     * @return tableName
     */
    public String selectTableNameByFileId(String fileId);

    /**
     * 是否存在该表
     */
    public Integer ifHaveTable(String tableName);

    /**
     * 在表型表里查材料基本信息
     *
     * @param m Material对象
     * @return Material的list
     */


    /**
     * 在表型文件表里根据FileId查FileName
     *
     * @param fileId
     * @return fileName
     */
    public String selectFileNameByFileId(String fileId);



    List getAreaData();




    void updatePhenoTypeFile(Long fileId,Long phenotypeId, HashMap<String, String> map);



    String exportFile(String tableName);


     int selectTableCount(Long tableName);


    long selectTableLineCountByFileId(Long fileId);

    long selectPhenotypeFileListCountByTableName(String tableName);
}
