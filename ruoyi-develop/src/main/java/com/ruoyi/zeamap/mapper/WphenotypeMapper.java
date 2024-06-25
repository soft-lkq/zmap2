package com.ruoyi.zeamap.mapper;

import com.ruoyi.zeamap.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 表型Mapper接口
 * 
 * @author ruoyi
 * @date 2024-03-19
 */
public interface WphenotypeMapper 
{
    /**
     * 查询表型
     * 
     * @param pedid 表型主键
     * @return 表型
     */
    public Wphenotype selectWphenotypeByPedid(Long pedid);

    /**
     * 查询表型列表
     * 
     * @param wphenotype 表型
     * @return 表型集合
     */
    public List<Wphenotype> selectWphenotypeList(Wphenotype wphenotype);

    /**
     * 新增表型
     * 
     * @param wphenotype 表型
     * @return 结果
     */
    public int insertWphenotype(Wphenotype wphenotype);

    /**
     * 修改表型
     * 
     * @param wphenotype 表型
     * @return 结果
     */
    public int updateWphenotype(Wphenotype wphenotype);

    /**
     * 删除表型
     * 
     * @param pedid 表型主键
     * @return 结果
     */
    public int deleteWphenotypeByPedid(Long pedid);

    /**
     * 批量删除表型
     * 
     * @param pedids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWphenotypeByPedids(Long[] pedids);

    //year查询
    public List<Wphenotype> selectPhenotypeByYear(@Param("years") List<Long> years);

    //根据地点查询
    public List<Wphenotype> selectPhenotypeByLocations(@Param("locations") List<String> locations);

    //name查询
    public List<Wphenotype> selectPhenotypeByname(String pedigree);

    //条件查询Morphological
    public MorphologicalVo[] selectMorphologicalByname(@Param("pedigree")String pedigree);
    //所有Mor
    public MorphologicalVo[] selectAllMorphological();

    //条件查询Agr
    public AgronomicalVo[] selectAgrByName(@Param("pedigree")String pedigree);
    //查询所有Agr
    public AgronomicalVo[] selectAllAgr();

    //查询表型日期
    public BxDateVo[] selectBxDate(@Param("pedigree")String pedigree);
    //查询所有表型日期
    public BxDateVo[] selectAllDate();

    //yield
    public Yield[] selectYieldByName(@Param("pedigree")String pedigree);
    public Yield[] selectAllYield();

    //查询患病率
    public BxRateVo[] selectBxRateByName(@Param("pedigree")String pedigree);

    //查询所有患病率
    public BxRateVo[] selectAllRate();

    //All
    public List<Wphenotype> selectAllPhenotype();

    //查询所给的trait
    public List<Map<String,String>> selectTrait(@Param("traits") List<String> traits);
    //查询初始
    public List<TraitVo> selectTVo();

    //根据name查询指定的trait
    public List<TraitVo> selectTVoByName(@Param("pedigree") String pedigree,@Param("trait") String trait);
    //根据name查询指定trait
    public List<String> selectTraitByName(@Param("pedigree") String pedigree,@Param("trait") String trait);

    //traitByName
    public List<Map<String,String>> selectTraitsByName(@Param("pedigree") String pedigree,@Param("traits") List<String> traits);

    //查询各个年份地点的trait
    public List<String> selectTraitGroup(String trait);
    public List<GeVo> selectGe(String trait);

    //ByName查询各个年份地点的trait
    public List<String> selectTraitGroupByName(@Param("pedigree") String pedigree,@Param("trait") String trait);
    public List<GeVo> selectGeByName(@Param("pedigree") String pedigree,@Param("trait") String trait);

    //条件查询
    public List<Map<String,String>> selectBy(@Param("pedigrees")List<String> pedigrees, @Param("years")List<Long> years, @Param("locations")List<String> locations);
    public List<String> searchTrait(@Param("pedigrees")List<String> pedigrees, @Param("years")List<Long> years, @Param("locations")List<String> locations,@Param("traits")List<String> traits);
    public List<SearchVo> selectWithTrait(@Param("pedigrees")List<String> pedigrees, @Param("years")List<Long> years, @Param("locations")List<String> locations,@Param("traits")List<String> traits);

    //多选接口
    public List<Long> selectAllYear();
    public List<String> selectAllTrait();
    public List<String> selectAllLocation();
    public List<String> selectAllpedigree();

    //所有形态学数据
    public List<MorphologicalVo> selectAllMar();
    public List<AgronomicalVo> selectAllAgro();
    public List<AbioticStressVo> selectAllAbiotic();
    public List<BioticStressVo> selectAllBiotic();
    public List<Map<String,String>> selectAllYields();

    //年份分组查询形态学数据
    public List<YearMorVo> selectYearMor();
    public List<YearAgr> selectYearAgr();
    public List<YearAbiotic> selectYearAbiotic();
    public List<YearBiotic> selectYearBiotic();
    public List<YearYield> selectYearYield();

    //统计数据行数
    public int countData();

    //统计表型数据类型数量
    public int countBx(String traitName);


    public List<Map<String,String>>findBxServe(@Param("pedigrees")List<String> pedigrees, @Param("years")List<Long> years, @Param("locations")List<String> locations,@Param("traits")List<String> traits);
}
