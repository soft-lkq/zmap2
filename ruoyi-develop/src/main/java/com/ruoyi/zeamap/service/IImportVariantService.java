package com.ruoyi.zeamap.service;

import java.util.List;

import com.ruoyi.zeamap.domain.ImportDbxref;
import com.ruoyi.zeamap.domain.ImportVariant;

/**
 * ImportVariantService接口
 * 
 * @author ruoyi
 * @date 2023-03-16
 */
public interface IImportVariantService 
{

    public String importVariantData(List<ImportVariant> importList, Boolean isUpdateSupport, String operName);



    /**
     * 查询ImportVariant
     * 
     * @param variantId ImportVariant主键
     * @return ImportVariant
     */
    public ImportVariant selectImportVariantByVariantId(String variantId);

    /**
     * 查询ImportVariant列表
     * 
     * @param importVariant ImportVariant
     * @return ImportVariant集合
     */
    public List<ImportVariant> selectImportVariantList(ImportVariant importVariant);

    /**
     * 新增ImportVariant
     * 
     * @param importVariant ImportVariant
     * @return 结果
     */
    public int insertImportVariant(ImportVariant importVariant);

    /**
     * 修改ImportVariant
     * 
     * @param importVariant ImportVariant
     * @return 结果
     */
    public int updateImportVariant(ImportVariant importVariant);

    /**
     * 批量删除ImportVariant
     * 
     * @param variantIds 需要删除的ImportVariant主键集合
     * @return 结果
     */
    public int deleteImportVariantByVariantIds(String[] variantIds);

    /**
     * 删除ImportVariant信息
     * 
     * @param variantId ImportVariant主键
     * @return 结果
     */
    public int deleteImportVariantByVariantId(String variantId);
}
