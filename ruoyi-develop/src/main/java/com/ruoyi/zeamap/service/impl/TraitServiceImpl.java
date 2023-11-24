package com.ruoyi.zeamap.service.impl;


import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.zeamap.domain.AsTraitType;
import com.ruoyi.zeamap.domain.Trait;
import com.ruoyi.zeamap.mapper.AsTraitTypeMapper;
import com.ruoyi.zeamap.mapper.TraitMapper;
import com.ruoyi.zeamap.mapper.TraitTypeMapper;
import com.ruoyi.zeamap.service.ITraitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-07-03
 */
@Service
public class TraitServiceImpl implements ITraitService
{
    @Autowired
    private TraitMapper traitMapper;

    @Autowired
    private TraitTypeMapper traitTypeMapper;

    @Autowired
    private AsTraitTypeMapper asTraitTypeMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param traitId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Trait selectTraitByTraitId(Long traitId)
    {
        return traitMapper.selectTraitByTraitId(traitId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param trait 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Trait> selectTraitList(Trait trait)
    {
        return traitMapper.selectTraitList(trait);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param trait 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTrait(Trait trait)
    {
        trait.setCreateTime(DateUtils.getNowDate());
        trait.setCreateBy(SecurityUtils.getUserId().toString());
        trait.setUpdateTime(DateUtils.getNowDate());
        trait.setUpdateBy(SecurityUtils.getUserId().toString());
        return traitMapper.insertTrait(trait);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param trait 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTrait(Trait trait)
    {
        trait.setUpdateTime(DateUtils.getNowDate());
        trait.setUpdateBy(SecurityUtils.getUserId().toString());
        return traitMapper.updateTrait(trait);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param traitIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTraitByTraitIds(Long[] traitIds)
    {
        return traitMapper.deleteTraitByTraitIds(traitIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param traitId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTraitByTraitId(Long traitId)
    {
        return traitMapper.deleteTraitByTraitId(traitId);
    }



    public static double calculateMax(List<Double> values) {
        if (values.isEmpty()) {
            return (double) 0;
        }

        double max = values.get(0);
        for (double value : values) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static double calculateMin(List<Double> values) {
        if (values.isEmpty()) {
            return (double) 0;
        }

        double min = values.get(0);
        for (double value : values) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public static double calculateAverage(List<Double> values) {
        if (values.isEmpty()) {
            return (double) 0;
        }

        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.size();
    }



    @Override
    public List<Trait> getTraitByType(Long typeId) {
        List<Trait> result =new ArrayList<>();
        AsTraitType asTraitType =new AsTraitType();
        asTraitType.setTraitTypeId(typeId);
        List<AsTraitType> asTraitTypes = asTraitTypeMapper.selectAsTraitTypeList(asTraitType);
        for(AsTraitType as:asTraitTypes){
            String traitId = as.getTraitId();
            Trait trait = traitMapper.selectTraitByTraitId(Long.valueOf(traitId));
            result.add(trait);
        }
        return result;
    }

    //1.6 大查询 模糊匹配 根据性状名称模糊匹配
    @Override
    public List<Trait> selectTrait(String trait_name) {
        return traitMapper.selectTrait(trait_name);
    }

    //1.6
    public Integer checkTraitName(String trait_name){
        return traitMapper.checkTraitName(trait_name);
    }
}
