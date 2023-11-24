package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.zeamap.mapper.VariantMapper;
import com.ruoyi.zeamap.service.IVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.domain.Variant;

/**
 * variantService业务层处理
 *
 * @author ruoyi
 * @date 2022-10-30
 */
@Service
public class VariantServiceImpl implements IVariantService {
    @Autowired
    private VariantMapper variantMapper;

    /**
     * 查询variant
     *
     * @param variantId variant主键
     * @return variant
     */
    @Override
    public Variant selectVariantByVariantId(String variantId) {
        return variantMapper.selectVariantByVariantId(variantId);
    }

    /**
     * 查询variant列表
     *
     * @param variant variant
     * @return variant
     */
    @Override
    public List<Variant> selectVariantList(Variant variant) {
        return variantMapper.selectVariantList(variant);
    }

    /**
     * 新增variant
     *
     * @param variant variant
     * @return 结果
     */
    @Override
    public int insertVariant(Variant variant) {
        return variantMapper.insertVariant(variant);
    }

    /**
     * 修改variant
     *
     * @param variant variant
     * @return 结果
     */
    @Override
    public int updateVariant(Variant variant) {
        return variantMapper.updateVariant(variant);
    }

    /**
     * 批量删除variant
     *
     * @param variantIds 需要删除的variant主键
     * @return 结果
     */
    @Override
    public int deleteVariantByVariantIds(String[] variantIds) {
        return variantMapper.deleteVariantByVariantIds(variantIds);
    }

    /**
     * 删除variant信息
     *
     * @param variantId variant主键
     * @return 结果
     */
    @Override
    public int deleteVariantByVariantId(String variantId) {
        return variantMapper.deleteVariantByVariantId(variantId);
    }

    /**
     * variantService业务层处理
     *
     * @author 刘洋、邵雯
     * @date 2023-3-2
     */
    //查询Reference
    @Override
    public List<String> selectReference() {
        return variantMapper.selectReference();
    }

    //查询Version
    @Override
    public List<String> selectVersion(String accession) {
        return variantMapper.selectVersion(accession);
    }

    //查询Population
    @Override
    public List<String> selectPopulation() {
        return variantMapper.selectPopulation();
    }

    //查询Analysis里面的description
    public List<String> selectAnalysis() {
        return variantMapper.selectAnalysis();
    }

    //查询VariantClass
    @Override
    public List<String> selectVariantClass() {
        return variantMapper.selectVariantClass();
    }


    //查询Region下拉框里面的chr
    @Override
    public List<String> selectChr() {
        return variantMapper.selectChr();
    }

    //查询Region下拉框里面的Posi
    @Override
    public List<String> selectPosi() {
        return variantMapper.selectPosi();
    }

    //Annotation 查询 impacts + consequences
    @Override
    public List<String> selectImpacts() {
        return variantMapper.selectImpacts();
    }

    //Annotation 查询 consequences
    @Override
    public List<String> selectConsequences() {
        return variantMapper.selectConsequences();
    }

    //大查询
    @Override
    public List<Variant> selectVariant(String type, String chr, Long posi_min,Long posi_max, Double maf_min, Double maf_max, String impacts, String consequences, String accession, String version, String alias, String description) {
        return variantMapper.selectVariant(type, chr, posi_min,posi_max, maf_min, maf_max, impacts, consequences, accession, version, alias, description);
    }


}
