package com.ruoyi.zeamap.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.SubgroupMapper;
import com.ruoyi.zeamap.domain.Subgroup;
import com.ruoyi.zeamap.service.ISubgroupService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
@Service
public class SubgroupServiceImpl implements ISubgroupService 
{
    @Autowired
    private SubgroupMapper subgroupMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param subgroupId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Subgroup selectSubgroupBySubgroupId(Long subgroupId)
    {
        return subgroupMapper.selectSubgroupBySubgroupId(subgroupId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param subgroup 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Subgroup> selectSubgroupList(Subgroup subgroup)
    {
        return subgroupMapper.selectSubgroupList(subgroup);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param subgroup 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSubgroup(Subgroup subgroup)
    {
        return subgroupMapper.insertSubgroup(subgroup);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param subgroup 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSubgroup(Subgroup subgroup)
    {
        return subgroupMapper.updateSubgroup(subgroup);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param subgroupIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSubgroupBySubgroupIds(Long[] subgroupIds)
    {
        return subgroupMapper.deleteSubgroupBySubgroupIds(subgroupIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param subgroupId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSubgroupBySubgroupId(Long subgroupId)
    {
        return subgroupMapper.deleteSubgroupBySubgroupId(subgroupId);
    }
}
