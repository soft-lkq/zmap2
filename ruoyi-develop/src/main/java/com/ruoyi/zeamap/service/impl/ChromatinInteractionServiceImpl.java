package com.ruoyi.zeamap.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.ChromatinInteractionMapper;
import com.ruoyi.zeamap.domain.ChromatinInteraction;
import com.ruoyi.zeamap.service.IChromatinInteractionService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@Service
public class ChromatinInteractionServiceImpl implements IChromatinInteractionService 
{
    @Autowired
    private ChromatinInteractionMapper chromatinInteractionMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param chromatinInteractionId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public ChromatinInteraction selectChromatinInteractionByChromatinInteractionId(Long chromatinInteractionId)
    {
        return chromatinInteractionMapper.selectChromatinInteractionByChromatinInteractionId(chromatinInteractionId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param chromatinInteraction 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ChromatinInteraction> selectChromatinInteractionList(ChromatinInteraction chromatinInteraction)
    {
        return chromatinInteractionMapper.selectChromatinInteractionList(chromatinInteraction);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param chromatinInteraction 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertChromatinInteraction(ChromatinInteraction chromatinInteraction)
    {
        return chromatinInteractionMapper.insertChromatinInteraction(chromatinInteraction);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param chromatinInteraction 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateChromatinInteraction(ChromatinInteraction chromatinInteraction)
    {
        return chromatinInteractionMapper.updateChromatinInteraction(chromatinInteraction);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param chromatinInteractionIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteChromatinInteractionByChromatinInteractionIds(Long[] chromatinInteractionIds)
    {
        return chromatinInteractionMapper.deleteChromatinInteractionByChromatinInteractionIds(chromatinInteractionIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param chromatinInteractionId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteChromatinInteractionByChromatinInteractionId(Long chromatinInteractionId)
    {
        return chromatinInteractionMapper.deleteChromatinInteractionByChromatinInteractionId(chromatinInteractionId);
    }

    /*
     *Date: 2023/4/13
     * @Author 刘洋
     */

    //查找dbxref表里面的accession
    public List<String> selectaccession()
    {
        return chromatinInteractionMapper.selectaccession();
    }

    //查找dbxref表里面的version,version是reference的下级
    public List<String> selectversion(String accession)
    {
        return chromatinInteractionMapper.selectversion(accession);
    }

    //查找Analysis的description
    public List<String> selectanalysis(String accession, String version)
    {
        return chromatinInteractionMapper.selectanalysis(accession,version);
    }

    //查找chrA
    public List<String> selectchrA()
    {
        return chromatinInteractionMapper.selectchrA();
    }

    //查找chrB
    public List<String> selectchrB()
    {
        return chromatinInteractionMapper.selectchrB();
    }

    //大查询
    public List<ChromatinInteraction> selectchromatin_interaction(String accession,String version,String description,String chrA,long startA,long endA,String chrB,long startB,long endB)
    {
        return chromatinInteractionMapper.selectchromatin_interaction(accession, version, description, chrA, startA, endA, chrB, startB, endB);
    }
}
