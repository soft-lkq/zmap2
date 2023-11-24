package com.ruoyi.zeamap.mapper;

import java.util.List;

import com.ruoyi.zeamap.domain.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

/**
 * PhenotypeMapper接口
 * 
 * @author wj
 * @date 2023-10-11
 */
public interface PhenotypeMapper 
{
    /**
     * 查询Phenotype
     * 
     * @param code Phenotype主键
     * @return Phenotype
     */
    public Phenotype selectPhenotypeByCode(Long code);

    /**
     * 查询Phenotype列表
     * 
     * @param phenotype Phenotype
     * @return Phenotype集合
     */
    public List<Phenotype> selectPhenotypeList(Phenotype phenotype);

    /**
     * 新增Phenotype
     * 
     * @param phenotype Phenotype
     * @return 结果
     */
    public int insertPhenotype(Phenotype phenotype);

    /**
     * 修改Phenotype
     * 
     * @param phenotype Phenotype
     * @return 结果
     */
    public int updatePhenotype(Phenotype phenotype);

    /**
     * 删除Phenotype
     * 
     * @param code Phenotype主键
     * @return 结果
     */
    public int deletePhenotypeByCode(Long code);

    /**
     * 批量删除Phenotype
     * 
     * @param codes 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePhenotypeByCodes(Long[] codes);

    //条件查询表型
    public List<Phenotype> selectPhenotypeByname(@Param("pedigree")String pedigree);

    //条件查询Morphological
    public MorphologicalVo[] selectMorphologicalByname(@Param("pedigree")String pedigree);

    //查询所有Morphological
    public MorphologicalVo[] selectAllMorphological();

    //条件查询Agronomical
    public AgronomicalVo[] selectAgronomicalByname(@Param("pedigree")String pedigree);

    //查询所有Agronomical
    public AgronomicalVo[] selectAllAgronomical();

    //查询表型日期
    public BxDateVo[] selectBxDate(@Param("pedigree")String pedigree);

    //查询所有表型日期
    public BxDateVo[] selectAllDate();

    //查询患病率
    public BxRateVo[] selectBxRateByName(@Param("pedigree")String pedigree);

    //查询所有患病率
    public BxRateVo[] selectAllRate();

    //根据年份查询表型
    public List<Phenotype> selectPhenotypeByYear(Long year);

    //根据地点查询
    public List<Phenotype> selectPhenotypeByLocation(String location);

    //All
    public List<Phenotype> selectAllPhenotype();

    //查询所给的trait
    public List<String> selectTrait(String trait);

    //查询初始
    public List<TraitVo> selectTVo();

    //查询各个年份地点的trait
    public List<String> selectTraitGroup(String trait);
    public List<GeVo> selectGe(String trait);

    //ByName查询各个年份地点的trait
    public List<String> selectTraitGroupByName(@Param("pedigree") String pedigree,@Param("trait") String trait);
    public List<GeVo> selectGeByName(@Param("pedigree") String pedigree,@Param("trait") String trait);

    //根据name查询指定的trait
    public List<TraitVo> selectTVoByName(@Param("pedigree") String pedigree,@Param("trait") String trait);

    //根据name查询指定trait
    public List<String> selectTraitByName(@Param("pedigree") String pedigree,@Param("trait") String trait);

    //所有形态学数据
    public List<MorphologicalVo> selectAllMar();

    //年份分组查询形态学数据
    public List<YearMorVo> selectYearMor();

    //统计表型数据类型数量
    public int countBx(String traitName);
}
