package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.ImportSubgroup;

/**
 * ImportMapper接口
 * 
 * @author ruoyi
 * @date 2023-04-09
 */
public interface ImportSubgroupMapper 
{
    /**
     * 查询Import
     * 
     * @param subgroupId Import主键
     * @return Import
     */
    public ImportSubgroup selectImportSubgroupBySubgroupId(Long subgroupId);

    /**
     * 查询Import列表
     * 
     * @param importSubgroup Import
     * @return Import集合
     */
    public List<ImportSubgroup> selectImportSubgroupList(ImportSubgroup importSubgroup);

    /**
     * 新增Import
     * 
     * @param importSubgroup Import
     * @return 结果
     */
    public int insertImportSubgroup(ImportSubgroup importSubgroup);

    /**
     * 修改Import
     * 
     * @param importSubgroup Import
     * @return 结果
     */
    public int updateImportSubgroup(ImportSubgroup importSubgroup);

    /**
     * 删除Import
     * 
     * @param subgroupId Import主键
     * @return 结果
     */
    public int deleteImportSubgroupBySubgroupId(Long subgroupId);

    /**
     * 批量删除Import
     * 
     * @param subgroupIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImportSubgroupBySubgroupIds(Long[] subgroupIds);
}
