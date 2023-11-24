package com.ruoyi.zeamap.service;

import java.util.List;
import com.ruoyi.zeamap.domain.Subgroup;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
public interface ISubgroupService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param subgroupId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Subgroup selectSubgroupBySubgroupId(Long subgroupId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param subgroup 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Subgroup> selectSubgroupList(Subgroup subgroup);

    /**
     * 新增【请填写功能名称】
     * 
     * @param subgroup 【请填写功能名称】
     * @return 结果
     */
    public int insertSubgroup(Subgroup subgroup);

    /**
     * 修改【请填写功能名称】
     * 
     * @param subgroup 【请填写功能名称】
     * @return 结果
     */
    public int updateSubgroup(Subgroup subgroup);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param subgroupIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteSubgroupBySubgroupIds(Long[] subgroupIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param subgroupId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSubgroupBySubgroupId(Long subgroupId);
}
