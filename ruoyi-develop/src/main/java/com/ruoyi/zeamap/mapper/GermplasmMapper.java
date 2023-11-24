package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.Germplasm;
import org.apache.ibatis.annotations.Mapper;

/**
 * 产品详情Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-14
 */
@Mapper
public interface GermplasmMapper 
{
    public List<Germplasm> selectGermplasmByName(String name);

    public List<Germplasm> selectGermplasmListFromPid(Long populationId);

    public Long selectPopulationId(String name);


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
     * 删除产品详情
     * 
     * @param germplasmId 产品详情主键
     * @return 结果
     */
    public int deleteGermplasmByGermplasmId(Long germplasmId);

    /**
     * 批量删除产品详情
     * 
     * @param germplasmIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGermplasmByGermplasmIds(Long[] germplasmIds);

    public List<Germplasm> SelectorSubGroupGermplasm();
}
