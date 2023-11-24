package com.ruoyi.zeamap.service;

import java.util.List;

import com.ruoyi.zeamap.domain.ImportVariant;
import com.ruoyi.zeamap.domain.ImportVariantInfo;

/**
 * ImportInfoService接口
 * 
 * @author ruoyi
 * @date 2023-03-18
 */
public interface IImportVariantInfoService 
{

    public String importVariantInfoData(List<ImportVariantInfo> importList, Boolean isUpdateSupport, String operName);


    /**
     * 查询ImportInfo
     * 
     * @param variantinfoId ImportInfo主键
     * @return ImportInfo
     */
    public ImportVariantInfo selectImportVariantInfoByVariantinfoId(String variantinfoId);

    /**
     * 查询ImportInfo列表
     * 
     * @param importVariantInfo ImportInfo
     * @return ImportInfo集合
     */
    public List<ImportVariantInfo> selectImportVariantInfoList(ImportVariantInfo importVariantInfo);

    /**
     * 新增ImportInfo
     * 
     * @param importVariantInfo ImportInfo
     * @return 结果
     */
    public int insertImportVariantInfo(ImportVariantInfo importVariantInfo);

    /**
     * 修改ImportInfo
     * 
     * @param importVariantInfo ImportInfo
     * @return 结果
     */
    public int updateImportVariantInfo(ImportVariantInfo importVariantInfo);

    /**
     * 批量删除ImportInfo
     * 
     * @param variantinfoIds 需要删除的ImportInfo主键集合
     * @return 结果
     */
    public int deleteImportVariantInfoByVariantinfoIds(String[] variantinfoIds);

    /**
     * 删除ImportInfo信息
     * 
     * @param variantinfoId ImportInfo主键
     * @return 结果
     */
    public int deleteImportVariantInfoByVariantinfoId(String variantinfoId);
}
