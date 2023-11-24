package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.zeamap.domain.EvolSelectCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.EvolutionMapper;
import com.ruoyi.zeamap.domain.Evolution;
import com.ruoyi.zeamap.service.IEvolutionService;

/**
 * 【Evolution 查询、下载】Service业务层处理
 * 
 * @author 邵雯
 * @date 2023-04-12
 */
@Service
public class EvolutionServiceImpl implements IEvolutionService 
{
    @Autowired
    private EvolutionMapper evolutionMapper;

    /**
     * 查询【Evolution】
     * 
     * @param evolutionId 【Evolution】主键
     * @return 【Evolution】
     */
    @Override
    public Evolution selectEvolutionByEvolutionId(Long evolutionId)
    {
        return evolutionMapper.selectEvolutionByEvolutionId(evolutionId);
    }

    /**
     * 查询【Evolution】列表
     * 
     * @param evolution 【Evolution】
     * @return 【Evolution】
     */
    @Override
    public List<Evolution> selectEvolutionList(Evolution evolution)
    {
        return evolutionMapper.selectEvolutionList(evolution);
    }

    /**
     * 新增【Evolution】
     * 
     * @param evolution 【Evolution】
     * @return 结果
     */
    @Override
    public int insertEvolution(Evolution evolution)
    {
        return evolutionMapper.insertEvolution(evolution);
    }

    /**
     * 修改【Evolution】
     * 
     * @param evolution 【Evolution】
     * @return 结果
     */
    @Override
    public int updateEvolution(Evolution evolution)
    {
        return evolutionMapper.updateEvolution(evolution);
    }

    /**
     * 批量删除【Evolution】
     * 
     * @param evolutionIds 需要删除的【Evolution】主键
     * @return 结果
     */
    @Override
    public int deleteEvolutionByEvolutionIds(Long[] evolutionIds)
    {
        return evolutionMapper.deleteEvolutionByEvolutionIds(evolutionIds);
    }

    /**
     * 删除【Evolution】信息
     * 
     * @param evolutionId 【Evolution】主键
     * @return 结果
     */
    @Override
    public int deleteEvolutionByEvolutionId(Long evolutionId)
    {
        return evolutionMapper.deleteEvolutionByEvolutionId(evolutionId);
    }

    //查询Reference
    @Override
    public List<String> selectReference() {
        return evolutionMapper.selectReference();
    }

    //查询Version
    @Override
    public List<String> selectVersion(String accession) {
        return evolutionMapper.selectVersion(accession);
    }

    //查询Indicator
    @Override
    public List<String> selectIndicator() {
        return evolutionMapper.selectIndicator();
    }

    //查询selectiontype
    @Override
    public List<String> selectselectiontype(String indicator) {
        return evolutionMapper.selectselectiontype(indicator);
    }

    //查询popcompared
    @Override
    public List<String> selectpopcompared(String indicator) {
        return evolutionMapper.selectpopcompared(indicator);
    }

    //查询chr
    @Override
    public List<String> selectchr(){
        return evolutionMapper.selectchr();
    }

    //大查询
    @Override
    public List<EvolSelectCondition> selectevol(String ref, String version, String indicator, String select,
                                                String compare_pop, String chro, Double start, Double end){
        return evolutionMapper.selectevol(ref,version,indicator,select,compare_pop,chro,start,end);
    }

}
