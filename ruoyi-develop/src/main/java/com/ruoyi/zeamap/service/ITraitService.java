package com.ruoyi.zeamap.service;


import com.ruoyi.zeamap.domain.Trait;

import java.util.List;


/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-07-03
 */
public interface ITraitService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param traitId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Trait selectTraitByTraitId(Long traitId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param trait 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Trait> selectTraitList(Trait trait);

    /**
     * 新增【请填写功能名称】
     *
     * @param trait 【请填写功能名称】
     * @return 结果
     */
    public int insertTrait(Trait trait);

    /**
     * 修改【请填写功能名称】
     *
     * @param trait 【请填写功能名称】
     * @return 结果
     */
    public int updateTrait(Trait trait);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param traitIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteTraitByTraitIds(Long[] traitIds);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param traitId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTraitByTraitId(Long traitId);

    List<Trait> getTraitByType(Long typeId);


    //1.6 大查询 模糊匹配 根据性状名称模糊匹配
    public List<Trait> selectTrait(String trait_name);

    //1.6
    public Integer checkTraitName(String trait_name);
}
