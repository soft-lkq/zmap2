package com.ruoyi.zeamap.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.StructureMapper;
import com.ruoyi.zeamap.domain.Structure;
import com.ruoyi.zeamap.service.IStructureService;

/**
 * StructureService业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-27
 */
@Service
public class StructureServiceImpl implements IStructureService 
{
    @Autowired
    private StructureMapper structureMapper;

    /**
     * 查询Structure
     * 
     * @param group Structure主键
     * @return Structure
     */
    @Override
    public Structure selectStructureByGroup(String group)
    {
        return structureMapper.selectStructureByGroup(group);
    }

    /**
     * 查询Structure列表
     * 
     * @param structure Structure
     * @return Structure
     */
    @Override
    public List<Structure> selectStructureList(Structure structure)
    {
        return structureMapper.selectStructureList(structure);
    }

    /**
     * 新增Structure
     * 
     * @param structure Structure
     * @return 结果
     */
    @Override
    public int insertStructure(Structure structure)
    {
        return structureMapper.insertStructure(structure);
    }

    /**
     * 修改Structure
     * 
     * @param structure Structure
     * @return 结果
     */
    @Override
    public int updateStructure(Structure structure)
    {
        return structureMapper.updateStructure(structure);
    }

    /**
     * 批量删除Structure
     * 
     * @param groups 需要删除的Structure主键
     * @return 结果
     */
    @Override
    public int deleteStructureByGroups(String[] groups)
    {
        return structureMapper.deleteStructureByGroups(groups);
    }

    /**
     * 删除Structure信息
     * 
     * @param group Structure主键
     * @return 结果
     */
    @Override
    public int deleteStructureByGroup(String group)
    {
        return structureMapper.deleteStructureByGroup(group);
    }
}
