package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.Tissue;

/**
 * 组织Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-19
 */
public interface TissueMapper 
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
     * 删除组织
     * 
     * @param tissueId 组织主键
     * @return 结果
     */
    public int deleteTissueByTissueId(Long tissueId);

    /**
     * 批量删除组织
     * 
     * @param tissueIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTissueByTissueIds(Long[] tissueIds);

    public List<Tissue> selectMapTissue(Long feature_id);

    public List<Tissue> selectMultiSelectorClassDesc();
}
