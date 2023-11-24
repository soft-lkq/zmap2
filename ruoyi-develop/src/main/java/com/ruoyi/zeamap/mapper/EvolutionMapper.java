package com.ruoyi.zeamap.mapper;

import com.ruoyi.zeamap.domain.EvolSelectCondition;
import com.ruoyi.zeamap.domain.Evolution;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 【Evolution查询，下载】Mapper接口
 *
 * @author 邵雯
 * @date 2023-04-12
 */
public interface EvolutionMapper {
    /**
     * 查询 Evolution 通过 evolutionId
     *
     * @param evolutionId Evolution主键
     * @return Evolution
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
     * 新增【Evolution】单条数据
     *
     * @param evolution 【Evolution】
     * @return 结果
     */
    public int insertEvolution(Evolution evolution);

    /**
     * 修改【Evolution】单条数据
     *
     * @param evolution 【Evolution】
     * @return 结果
     */
    public int updateEvolution(Evolution evolution);

    /**
     * 删除【Evolution】单条数据
     *
     * @param evolutionId 【Evolution】主键
     * @return 结果
     */
    public int deleteEvolutionByEvolutionId(Long evolutionId);

    /**
     * 批量删除【Evolution】
     *
     * @param evolutionIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEvolutionByEvolutionIds(Long[] evolutionIds);

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

    //查询chr
    public List<String> selectchr();

    //大查询
    public List<EvolSelectCondition> selectevol(@Param("ref") String ref, @Param("version") String version, @Param("indicator") String indicator, @Param("select") String select,
                                                @Param("compare_pop") String compare_pop, @Param("chro") String chro, @Param("start") Double start, @Param("end") Double end);
}
