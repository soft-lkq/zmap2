package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.Subgroup;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
public interface SubgroupMapper 
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
     * 删除【请填写功能名称】
     * 
     * @param subgroupId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSubgroupBySubgroupId(Long subgroupId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param subgroupIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSubgroupBySubgroupIds(Long[] subgroupIds);
}
