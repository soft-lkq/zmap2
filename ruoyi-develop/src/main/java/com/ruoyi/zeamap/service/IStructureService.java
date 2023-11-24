package com.ruoyi.zeamap.service;

import java.util.List;
import com.ruoyi.zeamap.domain.Structure;

/**
 * StructureService接口
 * 
 * @author ruoyi
 * @date 2023-03-27
 */
public interface IStructureService 
{
    /**
     * 查询Structure
     * 
     * @param group Structure主键
     * @return Structure
     */
    public Structure selectStructureByGroup(String group);

    /**
     * 查询Structure列表
     * 
     * @param structure Structure
     * @return Structure集合
     */
    public List<Structure> selectStructureList(Structure structure);

    /**
     * 新增Structure
     * 
     * @param structure Structure
     * @return 结果
     */
    public int insertStructure(Structure structure);

    /**
     * 修改Structure
     * 
     * @param structure Structure
     * @return 结果
     */
    public int updateStructure(Structure structure);

    /**
     * 批量删除Structure
     * 
     * @param groups 需要删除的Structure主键集合
     * @return 结果
     */
    public int deleteStructureByGroups(String[] groups);

    /**
     * 删除Structure信息
     * 
     * @param group Structure主键
     * @return 结果
     */
    public int deleteStructureByGroup(String group);
}
