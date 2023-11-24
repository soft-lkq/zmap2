package com.ruoyi.zeamap.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.zeamap.domain.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.TissueMapper;
import com.ruoyi.zeamap.domain.Tissue;
import com.ruoyi.zeamap.service.ITissueService;

/**
 * 组织Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-19
 */
@Service
public class TissueServiceImpl implements ITissueService 
{
    @Autowired
    private TissueMapper tissueMapper;

    /**
     * 查询组织
     * 
     * @param tissueId 组织主键
     * @return 组织
     */
    @Override
    public Tissue selectTissueByTissueId(Long tissueId)
    {
        return tissueMapper.selectTissueByTissueId(tissueId);
    }

    /**
     * 查询组织列表
     * 
     * @param tissue 组织
     * @return 组织
     */
    @Override
    public List<Tissue> selectTissueList(Tissue tissue)
    {
        return tissueMapper.selectTissueList(tissue);
    }

    /**
     * 新增组织
     * 
     * @param tissue 组织
     * @return 结果
     */
    @Override
    public int insertTissue(Tissue tissue)
    {
        tissue.setCreateTime(DateUtils.getNowDate());
        return tissueMapper.insertTissue(tissue);
    }

    /**
     * 修改组织
     * 
     * @param tissue 组织
     * @return 结果
     */
    @Override
    public int updateTissue(Tissue tissue)
    {
        tissue.setUpdateTime(DateUtils.getNowDate());
        return tissueMapper.updateTissue(tissue);
    }

    /**
     * 批量删除组织
     * 
     * @param tissueIds 需要删除的组织主键
     * @return 结果
     */
    @Override
    public int deleteTissueByTissueIds(Long[] tissueIds)
    {
        return tissueMapper.deleteTissueByTissueIds(tissueIds);
    }

    /**
     * 删除组织信息
     * 
     * @param tissueId 组织主键
     * @return 结果
     */
    @Override
    public int deleteTissueByTissueId(Long tissueId)
    {
        return tissueMapper.deleteTissueByTissueId(tissueId);
    }

    @Override
    public Map<String, List<String>> SelectorClassDesc() {

        List<Tissue> tissues = tissueMapper.selectMultiSelectorClassDesc();

        Map<String, List<String>> t = new HashMap<>();

        //判断map 中有没有这个key的值,如果没有就新建一个,如果有就拿出来加到List中
        for (Tissue tissue:tissues) {
            if (t.get(tissue.getTissueClass())==null){
                List<String> envDesc = new ArrayList<>();

                envDesc.add(tissue.getTissueDesc());
                t.put(tissue.getTissueClass(), envDesc);
            }else{
                List<String> envDes = t.get(tissue.getTissueClass());
                envDes.add(tissue.getTissueDesc());
            }
        }
        return t;
    }
}
