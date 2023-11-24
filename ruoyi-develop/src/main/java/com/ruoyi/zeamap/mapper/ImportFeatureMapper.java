package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.ImportFeature;

/**
 * ImportfeatureMapper接口
 * 
 * @author ruoyi
 * @date 2023-03-22
 */
public interface ImportFeatureMapper 
{
    /**
     * 查询Importfeature
     * 
     * @param featureId Importfeature主键
     * @return Importfeature
     */
    public ImportFeature selectImportFeatureByFeatureId(Long featureId);

    /**
     * 查询Importfeature列表
     * 
     * @param importFeature Importfeature
     * @return Importfeature集合
     */
    public List<ImportFeature> selectImportFeatureList(ImportFeature importFeature);

    /**
     * 新增Importfeature
     * 
     * @param importFeature Importfeature
     * @return 结果
     */
    public int insertImportFeature(ImportFeature importFeature);

    /**
     * 修改Importfeature
     * 
     * @param importFeature Importfeature
     * @return 结果
     */
    public int updateImportFeature(ImportFeature importFeature);

    /**
     * 删除Importfeature
     * 
     * @param featureId Importfeature主键
     * @return 结果
     */
    public int deleteImportFeatureByFeatureId(Long featureId);

    /**
     * 批量删除Importfeature
     * 
     * @param featureIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImportFeatureByFeatureIds(Long[] featureIds);
}
