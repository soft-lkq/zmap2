package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.Population;

/**
 * 产品Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-14
 */
public interface PopulationMapper 
{
    public Long selectPopulationidByName(String name);

    /**
     * 查询产品
     * 
     * @param populationId 产品主键
     * @return 产品
     */
    public Population selectPopulationByPopulationId(Long populationId);


    /**
     * 查询产品列表
     * 
     * @param population 产品
     * @return 产品集合
     */
    public List<Population> selectPopulationList(Population population);

    /**
     * 新增产品
     * 
     * @param population 产品
     * @return 结果
     */
    public int insertPopulation(Population population);

    /**
     * 修改产品
     * 
     * @param population 产品
     * @return 结果
     */
    public int updatePopulation(Population population);

    /**
     * 删除产品
     * 
     * @param populationId 产品主键
     * @return 结果
     */
    public int deletePopulationByPopulationId(Long populationId);

    /**
     * 批量删除产品
     * 
     * @param populationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePopulationByPopulationIds(Long[] populationIds);
}
