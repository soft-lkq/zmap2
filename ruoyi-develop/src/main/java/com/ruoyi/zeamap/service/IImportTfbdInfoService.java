package com.ruoyi.zeamap.service;

import java.util.List;
import com.ruoyi.zeamap.domain.ImportTfbdInfo;
import com.ruoyi.zeamap.domain.ImportTissue;

/**
 * ImportService接口
 * 
 * @author ruoyi
 * @date 2023-04-06
 */
public interface IImportTfbdInfoService 
{
    public String importTfbdInfoData(List<ImportTfbdInfo> importList, Boolean isUpdateSupport, String operName);


    /**
     * 查询Import
     * 
     * @param tfbdId Import主键
     * @return Import
     */
    public ImportTfbdInfo selectImportTfbdInfoByTfbdId(Long tfbdId);

    /**
     * 查询Import列表
     * 
     * @param importTfbdInfo Import
     * @return Import集合
     */
    public List<ImportTfbdInfo> selectImportTfbdInfoList(ImportTfbdInfo importTfbdInfo);

    /**
     * 新增Import
     * 
     * @param importTfbdInfo Import
     * @return 结果
     */
    public int insertImportTfbdInfo(ImportTfbdInfo importTfbdInfo);

    /**
     * 修改Import
     * 
     * @param importTfbdInfo Import
     * @return 结果
     */
    public int updateImportTfbdInfo(ImportTfbdInfo importTfbdInfo);

    /**
     * 批量删除Import
     * 
     * @param tfbdIds 需要删除的Import主键集合
     * @return 结果
     */
    public int deleteImportTfbdInfoByTfbdIds(Long[] tfbdIds);

    /**
     * 删除Import信息
     * 
     * @param tfbdId Import主键
     * @return 结果
     */
    public int deleteImportTfbdInfoByTfbdId(Long tfbdId);
}
