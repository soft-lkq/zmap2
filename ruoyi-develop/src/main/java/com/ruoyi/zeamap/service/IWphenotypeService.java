package com.ruoyi.zeamap.service;

import com.ruoyi.zeamap.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 表型Service接口
 * 
 * @author ruoyi
 * @date 2024-03-19
 */
public interface IWphenotypeService 
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
     * 批量删除表型
     * 
     * @param pedids 需要删除的表型主键集合
     * @return 结果
     */
    public int deleteWphenotypeByPedids(Long[] pedids);

    /**
     * 删除表型信息
     * 
     * @param pedid 表型主键
     * @return 结果
     */
    public int deleteWphenotypeByPedid(Long pedid);

    //year查询
    public List<Wphenotype> selectPhenotypeByYear(List<Long> years);

    //根据地点查询
    public List<Wphenotype> selectPhenotypeByLocations(List<String> locations);

    //name查询
    public List<Wphenotype> selectPhenotypeByname(String pedigree);

    //All
    public List<Wphenotype> selectAllPhenotype();

    //条件查询
    public List<Map<String,String>> selectBy(@Param("pedigrees")List<String> pedigrees, @Param("years")List<Long> years, @Param("locations")List<String> locations);
    public List<String> searchTrait(@Param("pedigrees")List<String> pedigrees, @Param("years")List<Long> years, @Param("locations")List<String> locations,@Param("traits")List<String> traits);
    public List<SearchVo> selectWithTrait(@Param("pedigrees")List<String> pedigrees, @Param("years")List<Long> years, @Param("locations")List<String> locations,@Param("traits")List<String> traits);    public List<SearchVo> resultWith(List<SearchVo> searchVos,List<String> strings);


    //判断
    public boolean isTrait(List<String> traits);

    //多选接口
    public List<Long> selectAllYear();
    public List<String> selectAllTrait();
    public List<String> selectAllLocation();

    //条件查询Morphological
    public MorphologicalVo[] selectMorphologicalByname(@Param("pedigree")String pedigree);
    //平均Morphological
    public MorphologicalVo meanMorphological(MorphologicalVo[] morphologicalVos);
    //所有Mor
    public MorphologicalVo[] selectAllMorphological();

    //条件查询Agronomical
    public AgronomicalVo[] selectAgronomicalByname(@Param("pedigree")String pedigree);

    //查询所有Agronomical
    public AgronomicalVo[] selectAllAgronomical();

    //平均AgronomicalVo
    public AgronomicalVo meanAgronomicalVo(AgronomicalVo[] agronomicalVos);

    //查询表型日期
    public BxDateVo[] selectBxDate(@Param("pedigree")String pedigree);

    //查询所有表型日期
    public BxDateVo[] selectAllDate();

    //平均日期
    public  BxDateVo meanDate(BxDateVo[] bxDateVos);

    //查询患病率
    public BxRateVo[] selectBxRateByName(@Param("pedigree")String pedigree);

    //查询所有患病率
    public BxRateVo[] selectAllRate();

    //平均率
    public BxRateVo MeanRate(BxRateVo[] bxRateVos);

    //yield
    public Yield[] selectYieldByName(@Param("pedigree")String pedigree);
    public Yield[] selectAllYield();
    public Yield MeanYield(Yield[] yields);



    //查询所给的trait
    public List<Map<String,String>> selectTrait(@Param("traits") List<String> traits);

    //查询初始
    public List<TraitVo> selectTVo();
    //赋值
    public List<TraitVo> resultTrait(List<TraitVo> traitVos,List<String> strings);

    //根据name查询指定的trait
    public List<TraitVo> selectTVoByName(@Param("pedigree") String pedigree,@Param("trait") String trait);

    //根据name查询指定trait
    public List<String> selectTraitByName(@Param("pedigree") String pedigree,@Param("trait") String trait);

    public List<String> selectTraitGroup(String trait);
    public List<GeVo> selectGe(String trait);
    public List<GeVo> resultGeVo(List<GeVo> geVoList,List<String> strings);

    //traitByName
    public List<Map<String,String>> selectTraitsByName(@Param("pedigree") String pedigree,@Param("traits") List<String> traits);

    //ByName查询各个年份地点的trait
    public List<String> selectTraitGroupByName(@Param("pedigree") String pedigree,@Param("trait") String trait);
    public List<GeVo> selectGeByName(@Param("pedigree") String pedigree,@Param("trait") String trait);

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

    //统计表型数据类型数量
    public int countBx(String traitName);

    //统计数据行数
    public int countData();

    public List<Map<String,String>> sort(List<Map<String,String>> maps);

    public List<String> selectAllpedigree();

    //多选查询表型
    public List<Map<String,String>>findBxServe(@Param("pedigrees")List<String> pedigrees, @Param("years")List<Long> years, @Param("locations")List<String> locations,@Param("traits")List<String> traits);
}
