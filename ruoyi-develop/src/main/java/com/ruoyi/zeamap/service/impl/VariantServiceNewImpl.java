package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.zeamap.domain.Gene;
import com.ruoyi.zeamap.domain.GeneCriteria;
import com.ruoyi.zeamap.domain.TraitAndGroup;
import com.ruoyi.zeamap.domain.Transcript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.VariantMapperNew;
import com.ruoyi.zeamap.service.IVariantServiceNew;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-05-06
 */
@Service
public class VariantServiceNewImpl implements IVariantServiceNew
{
    @Autowired
    private VariantMapperNew variantMapper;

    /**
     * 直接/模糊查询variant列表的VID并取前20条
     *
     * @param VID
     * @return 的VID的list
     */
    public List<String> select(String VID) {
        return variantMapper.select(VID);
    }

    /**
     * 根据搜索框的VID去viriant表里找对应的chr
     *
     * @param VID
     * @return variant表的chr
     */
    public String selectChr(String VID) {
        return variantMapper.selectChr(VID);
    }

    /**
     * 根据搜索框的VID去viriant表里找对应的position
     *
     * @param VID
     * @return variant表的position
     */
    public String selectPosition(String VID) {
        return variantMapper.selectPosition(VID);
    }

    /**
     * 根据GeneCriteria去feature,feature_loc表里找对应的gene
     *
     * @param geneCriteria
     * @return gene的list
     */
    public List<Gene> selectGenes(GeneCriteria geneCriteria) {
        return variantMapper.selectGenes(geneCriteria);
    }

    /**
     * 根据feature_id去feature,feature_loc表里找对应的transcript
     *
     * @param feature_id gene对应的feature_id
     * @return transcript的list
     */
    public List<Transcript> selectTranscripts(String feature_id) {
        return variantMapper.selectTranscripts(feature_id);
    }

    /**
     * 去xot表里找trait和trait_group
     *
     * @return xot表的trait和trait_group
     */
    public List<TraitAndGroup> selectTraitAndGroup() {
        return variantMapper.selectTraitAndGroup();
    }








//    /**
//     * 查询【请填写功能名称】
//     *
//     * @param variantId 【请填写功能名称】主键
//     * @return 【请填写功能名称】
//     */
//    @Override
//    public Variant selectVariantByVariantId(String variantId)
//    {
//        return variantMapperNew.selectVariantByVariantId(variantId);
//    }
//
//    /**
//     * 查询【请填写功能名称】列表
//     *
//     * @param variant 【请填写功能名称】
//     * @return 【请填写功能名称】
//     */
//    @Override
//    public List<Variant> selectVariantList(Variant variant)
//    {
//        return variantMapperNew.selectVariantList(variant);
//    }
//
//    /**
//     * 新增【请填写功能名称】
//     *
//     * @param variant 【请填写功能名称】
//     * @return 结果
//     */
//    @Override
//    public int insertVariant(Variant variant)
//    {
//        return variantMapperNew.insertVariant(variant);
//    }
//
//    /**
//     * 修改【请填写功能名称】
//     *
//     * @param variant 【请填写功能名称】
//     * @return 结果
//     */
//    @Override
//    public int updateVariant(Variant variant)
//    {
//        return variantMapperNew.updateVariant(variant);
//    }
//
//    /**
//     * 批量删除【请填写功能名称】
//     *
//     * @param variantIds 需要删除的【请填写功能名称】主键
//     * @return 结果
//     */
//    @Override
//    public int deleteVariantByVariantIds(String[] variantIds)
//    {
//        return variantMapperNew.deleteVariantByVariantIds(variantIds);
//    }
//
//    /**
//     * 删除【请填写功能名称】信息
//     *
//     * @param variantId 【请填写功能名称】主键
//     * @return 结果
//     */
//    @Override
//    public int deleteVariantByVariantId(String variantId)
//    {
//        return variantMapperNew.deleteVariantByVariantId(variantId);
//    }
}
