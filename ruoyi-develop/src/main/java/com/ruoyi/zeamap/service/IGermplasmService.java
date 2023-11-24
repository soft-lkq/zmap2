package com.ruoyi.zeamap.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.zeamap.domain.Germplasm;

/**
 * 产品详情Service接口
 * 
 * @author ruoyi
 * @date 2023-03-14
 */
public interface IGermplasmService 
{
    //导入
    public String importGermplasmData(List<Germplasm> importG, Boolean isUpdateSupport, String operName);

    //name筛选
    public List<Germplasm> selectGermplasmByName(String name);

    //根据population_id查询详情
    public List<Germplasm> selectGermplasmListFromPid(Long population_id);

    //根据name查询id
    public Long selectPopulationId(String name);

    public Map<String,List<String>> SelectorSubGroupGermplasm();


    /**
     * 查询产品详情
     * 
     * @param germplasmId 产品详情主键
     * @return 产品详情
     */
    public Germplasm selectGermplasmByGermplasmId(Long germplasmId);

    /**
     * 查询产品详情列表
     * 
     * @param germplasm 产品详情
     * @return 产品详情集合
     */
    public List<Germplasm> selectGermplasmList(Germplasm germplasm);

    /**
     * 新增产品详情
     * 
     * @param germplasm 产品详情
     * @return 结果
     */
    public int insertGermplasm(Germplasm germplasm);

    /**
     * 修改产品详情
     * 
     * @param germplasm 产品详情
     * @return 结果
     */
    public int updateGermplasm(Germplasm germplasm);

    /**
     * 批量删除产品详情
     * 
     * @param germplasmIds 需要删除的产品详情主键集合
     * @return 结果
     */
    public int deleteGermplasmByGermplasmIds(Long[] germplasmIds);

    /**
     * 删除产品详情信息
     * 
     * @param germplasmId 产品详情主键
     * @return 结果
     */
    public int deleteGermplasmByGermplasmId(Long germplasmId);
}
