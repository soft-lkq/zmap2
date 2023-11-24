package com.ruoyi.zeamap.service;

import java.util.List;

import com.ruoyi.zeamap.domain.ImportFeature;
import com.ruoyi.zeamap.domain.ImportFeatureloc;

/**
 * ImportFeaturelocService接口
 * 
 * @author ruoyi
 * @date 2023-03-30
 */
public interface IImportFeaturelocService 
{
    //导入
    public String importFeaturelocData(List<ImportFeatureloc> importList, Boolean isUpdateSupport, String operName);



    /**
     * 查询ImportFeatureloc
     * 
     * @param featurelocId ImportFeatureloc主键
     * @return ImportFeatureloc
     */
    public ImportFeatureloc selectImportFeaturelocByFeaturelocId(String featurelocId);

    /**
     * 查询ImportFeatureloc列表
     * 
     * @param importFeatureloc ImportFeatureloc
     * @return ImportFeatureloc集合
     */
    public List<ImportFeatureloc> selectImportFeaturelocList(ImportFeatureloc importFeatureloc);

    /**
     * 新增ImportFeatureloc
     * 
     * @param importFeatureloc ImportFeatureloc
     * @return 结果
     */
    public int insertImportFeatureloc(ImportFeatureloc importFeatureloc);

    /**
     * 修改ImportFeatureloc
     * 
     * @param importFeatureloc ImportFeatureloc
     * @return 结果
     */
    public int updateImportFeatureloc(ImportFeatureloc importFeatureloc);

    /**
     * 批量删除ImportFeatureloc
     * 
     * @param featurelocIds 需要删除的ImportFeatureloc主键集合
     * @return 结果
     */
    public int deleteImportFeaturelocByFeaturelocIds(String[] featurelocIds);

    /**
     * 删除ImportFeatureloc信息
     * 
     * @param featurelocId ImportFeatureloc主键
     * @return 结果
     */
    public int deleteImportFeaturelocByFeaturelocId(String featurelocId);
}
