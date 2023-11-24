package com.ruoyi.zeamap.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.zeamap.domain.Tissue;

/**
 * 组织Service接口
 * 
 * @author ruoyi
 * @date 2022-11-19
 */
public interface ITissueService 
{
    /**
     * 查询组织
     * 
     * @param tissueId 组织主键
     * @return 组织
     */
    public Tissue selectTissueByTissueId(Long tissueId);

    /**
     * 查询组织列表
     * 
     * @param tissue 组织
     * @return 组织集合
     */
    public List<Tissue> selectTissueList(Tissue tissue);

    /**
     * 新增组织
     * 
     * @param tissue 组织
     * @return 结果
     */
    public int insertTissue(Tissue tissue);

    /**
     * 修改组织
     * 
     * @param tissue 组织
     * @return 结果
     */
    public int updateTissue(Tissue tissue);

    /**
     * 批量删除组织
     * 
     * @param tissueIds 需要删除的组织主键集合
     * @return 结果
     */
    public int deleteTissueByTissueIds(Long[] tissueIds);

    /**
     * 删除组织信息
     * 
     * @param tissueId 组织主键
     * @return 结果
     */
    public int deleteTissueByTissueId(Long tissueId);


    public Map<String,List<String>> SelectorClassDesc();

}
