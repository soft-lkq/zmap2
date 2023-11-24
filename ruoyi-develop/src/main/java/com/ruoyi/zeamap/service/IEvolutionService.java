package com.ruoyi.zeamap.service;

import java.util.List;

import com.ruoyi.zeamap.domain.EvolSelectCondition;
import com.ruoyi.zeamap.domain.Evolution;
import com.ruoyi.zeamap.service.impl.EvolutionServiceImpl;

/**
 * 【Evolution 查询、下载】Service接口
 * 
 * @author 邵雯
 * @date 2023-04-12
 */
public interface IEvolutionService 
{
    /**
     * 查询【Evolution】
     * 
     * @param evolutionId 【Evolution】主键
     * @return 【Evolution】
     */
    public Evolution selectEvolutionByEvolutionId(Long evolutionId);

    /**
     * 查询【Evolution】列表
     * 
     * @param evolution 【Evolution】
     * @return 【Evolution】集合
     */
    public List<Evolution> selectEvolutionList(Evolution evolution);

    /**
     * 新增【Evolution】
     * 
     * @param evolution 【Evolution】
     * @return 结果
     */
    public int insertEvolution(Evolution evolution);

    /**
     * 修改【Evolution】
     * 
     * @param evolution 【Evolution】
     * @return 结果
     */
    public int updateEvolution(Evolution evolution);

    /**
     * 批量删除【Evolution】
     * 
     * @param evolutionIds 需要删除的【Evolution】主键集合
     * @return 结果
     */
    public int deleteEvolutionByEvolutionIds(Long[] evolutionIds);

    /**
     * 删除【Evolution】信息
     * 
     * @param evolutionId 【Evolution】主键
     * @return 结果
     */
    public int deleteEvolutionByEvolutionId(Long evolutionId);

    //查询Reference
    public List<String> selectReference();

    //查询Version
    public List<String> selectVersion(String accession);

    //查询Indicator
    public List<String> selectIndicator();

    //查询selectiontype
    public List<String> selectselectiontype(String indicator);

    //查询popcompared
    public List<String> selectpopcompared(String indicator);

    //查询selectchr
    public List<String> selectchr();

    //大查询
    public List<EvolSelectCondition> selectevol(String ref, String version, String indicator, String select,
                                                String compare_pop, String chro, Double start, Double end);
}
