package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.Structure;

/**
 * StructureMapper接口
 * 
 * @author ruoyi
 * @date 2023-03-27
 */
public interface StructureMapper 
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
     * 删除Structure
     * 
     * @param group Structure主键
     * @return 结果
     */
    public int deleteStructureByGroup(String group);

    /**
     * 批量删除Structure
     * 
     * @param groups 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStructureByGroups(String[] groups);
}
