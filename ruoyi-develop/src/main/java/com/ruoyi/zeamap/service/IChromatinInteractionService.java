package com.ruoyi.zeamap.service;

import java.util.List;
import com.ruoyi.zeamap.domain.ChromatinInteraction;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
public interface IChromatinInteractionService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param chromatinInteractionId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public ChromatinInteraction selectChromatinInteractionByChromatinInteractionId(Long chromatinInteractionId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param chromatinInteraction 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ChromatinInteraction> selectChromatinInteractionList(ChromatinInteraction chromatinInteraction);

    /**
     * 新增【请填写功能名称】
     * 
     * @param chromatinInteraction 【请填写功能名称】
     * @return 结果
     */
    public int insertChromatinInteraction(ChromatinInteraction chromatinInteraction);

    /**
     * 修改【请填写功能名称】
     * 
     * @param chromatinInteraction 【请填写功能名称】
     * @return 结果
     */
    public int updateChromatinInteraction(ChromatinInteraction chromatinInteraction);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param chromatinInteractionIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteChromatinInteractionByChromatinInteractionIds(Long[] chromatinInteractionIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param chromatinInteractionId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteChromatinInteractionByChromatinInteractionId(Long chromatinInteractionId);

    /*
     *Date: 2023/4/13
     * @Author 刘洋
     */

    //查找dbxref表里面的accession
    public List<String> selectaccession();

    //查找dbxref表里面的version,version是reference的下级
    public List<String> selectversion(String accession);

    //查找Analysis的description
    public List<String> selectanalysis( String accession, String version);

    //查找chrA
    public List<String> selectchrA();

    //查找chrB
    public List<String> selectchrB();

    //大查询
    public List<ChromatinInteraction> selectchromatin_interaction(String accession,String version,String description,String chrA,long startA,long endA,String chrB,long startB,long endB);

}
