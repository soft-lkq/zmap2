package com.ruoyi.zeamap.service;

import java.util.List;
import com.ruoyi.zeamap.domain.VariantInfo;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2022-10-30
 */
public interface IVariantInfoService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param variantinfoId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public VariantInfo selectVariantInfoByVariantinfoId(Long variantinfoId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param variantInfo 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<VariantInfo> selectVariantInfoList(VariantInfo variantInfo);

    /**
     * 新增【请填写功能名称】
     * 
     * @param variantInfo 【请填写功能名称】
     * @return 结果
     */
    public int insertVariantInfo(VariantInfo variantInfo);

    /**
     * 修改【请填写功能名称】
     * 
     * @param variantInfo 【请填写功能名称】
     * @return 结果
     */
    public int updateVariantInfo(VariantInfo variantInfo);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param variantinfoIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteVariantInfoByVariantinfoIds(Long[] variantinfoIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param variantinfoId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteVariantInfoByVariantinfoId(Long variantinfoId);


    /**
     * variantInfoService接口
     * 变异详情页
     * @author 刘洋、邵雯
     * @date 2023-3-2
     */
    public String selectSummaryByVID(String VID);

    public String selectPieplotsByVID(String VID);

    public String selectAnnotationsByVID(String VID);

    public String selectInformationByVID(String VID);

}
