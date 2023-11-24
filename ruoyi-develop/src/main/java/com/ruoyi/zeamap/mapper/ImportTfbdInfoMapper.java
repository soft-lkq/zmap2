package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.ImportTfbdInfo;

/**
 * ImportMapper接口
 * 
 * @author ruoyi
 * @date 2023-04-06
 */
public interface ImportTfbdInfoMapper 
{
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
     * 删除Import
     * 
     * @param tfbdId Import主键
     * @return 结果
     */
    public int deleteImportTfbdInfoByTfbdId(Long tfbdId);

    /**
     * 批量删除Import
     * 
     * @param tfbdIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImportTfbdInfoByTfbdIds(Long[] tfbdIds);
}
