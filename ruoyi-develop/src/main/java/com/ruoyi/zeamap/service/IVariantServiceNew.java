package com.ruoyi.zeamap.service;

import com.ruoyi.zeamap.domain.Gene;
import com.ruoyi.zeamap.domain.GeneCriteria;
import com.ruoyi.zeamap.domain.TraitAndGroup;
import com.ruoyi.zeamap.domain.Transcript;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-05-06
 */
public interface IVariantServiceNew
{

    /**
     * 直接/模糊查询variant列表的VID并取前20条
     *
     * @param VID
     * @return VID的list
     */
    public List<String> select(String VID);

    /**
     * 根据搜索框的VID去viriant表里找对应的chr
     *
     * @param VID
     * @return variant表的chr
     */
    public String selectChr(String VID);

    /**
     * 根据搜索框的VID去viriant表里找对应的position
     *
     * @param VID
     * @return variant表的position
     */
    public String selectPosition(String VID);

    /**
     * 根据GeneCriteria去feature,feature_loc表里找对应的gene
     *
     * @param geneCriteria
     * @return gene的list
     */
    public List<Gene> selectGenes(GeneCriteria geneCriteria);

    /**
     * 根据feature_id去feature,feature_loc表里找对应的transcript
     *
     * @param feature_id gene对应的feature_id
     * @return transcript的list
     */
    public List<Transcript> selectTranscripts(String feature_id);

    /**
     * 去xot表里找trait和trait_group
     *
     * @return xot表的trait和trait_group
     */
    public List<TraitAndGroup> selectTraitAndGroup();











//    /**
//     * 查询【请填写功能名称】
//     *
//     * @param variantId 【请填写功能名称】主键
//     * @return 【请填写功能名称】
//     */
//    public Variant selectVariantByVariantId(String variantId);
//
//    /**
//     * 查询【请填写功能名称】列表
//     *
//     * @param variant 【请填写功能名称】
//     * @return 【请填写功能名称】集合
//     */
//    public List<Variant> selectVariantList(Variant variant);
//
//    /**
//     * 新增【请填写功能名称】
//     *
//     * @param variant 【请填写功能名称】
//     * @return 结果
//     */
//    public int insertVariant(Variant variant);
//
//    /**
//     * 修改【请填写功能名称】
//     *
//     * @param variant 【请填写功能名称】
//     * @return 结果
//     */
//    public int updateVariant(Variant variant);
//
//    /**
//     * 批量删除【请填写功能名称】
//     *
//     * @param variantIds 需要删除的【请填写功能名称】主键集合
//     * @return 结果
//     */
//    public int deleteVariantByVariantIds(String[] variantIds);
//
//    /**
//     * 删除【请填写功能名称】信息
//     *
//     * @param variantId 【请填写功能名称】主键
//     * @return 结果
//     */
//    public int deleteVariantByVariantId(String variantId);
}
