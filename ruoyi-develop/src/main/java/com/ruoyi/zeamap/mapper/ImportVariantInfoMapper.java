package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.ImportVariantInfo;

/**
 * ImportInfoMapper接口
 * 
 * @author ruoyi
 * @date 2023-03-18
 */
public interface ImportVariantInfoMapper 
{


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
     * 删除ImportInfo
     * 
     * @param variantinfoId ImportInfo主键
     * @return 结果
     */
    public int deleteImportVariantInfoByVariantinfoId(String variantinfoId);

    /**
     * 批量删除ImportInfo
     * 
     * @param variantinfoIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImportVariantInfoByVariantinfoIds(String[] variantinfoIds);
}
