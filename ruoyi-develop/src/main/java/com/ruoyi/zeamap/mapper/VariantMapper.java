package com.ruoyi.zeamap.mapper;

import java.util.List;

import com.ruoyi.zeamap.domain.Variant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
/**
 * variantMapper接口
 *
 * @author ruoyi
 * @date 2022-10-30
 */
public interface VariantMapper {
    /**
     * 查询variant
     *
     * @param variantId variant主键
     * @return variant
     */
    public Variant selectVariantByVariantId(String variantId);

    /**
     * 查询variant列表
     *
     * @param variant variant
     * @return variant集合
     */
    public List<Variant> selectVariantList(Variant variant);

    /**
     * 新增variant
     *
     * @param variant variant
     * @return 结果
     */
    public int insertVariant(Variant variant);

    /**
     * 修改variant
     *
     * @param variant variant
     * @return 结果
     */
    public int updateVariant(Variant variant);

    /**
     * 删除variant
     *
     * @param variantId variant主键
     * @return 结果
     */
    public int deleteVariantByVariantId(String variantId);

    /**
     * 批量删除variant
     *
     * @param variantIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVariantByVariantIds(String[] variantIds);

    /**
     * variantMapper接口
     *
     * @author 刘洋、邵雯
     * @date 2023-3-2
     */

    //查询Reference
    public List<String> selectReference();

    //查询Version
    public List<String> selectVersion(String accession);

    //查询Population
    public List<String> selectPopulation();

    //查询Analysis里面的description
    public List<String> selectAnalysis();

    //查询VariantClass
    public List<String> selectVariantClass();


    //查询Region下拉框里面的chr
    public List<String> selectChr();

    //查询Region下拉框里面的Posi
    public List<String> selectPosi();

    //Annotation下拉框 查询 impacts + consequences
    public List<String> selectImpacts();

    public List<String> selectConsequences();

    //大查询
    public List<Variant> selectVariant(@Param("type") String type, @Param("chr") String chr, @Param("posi_min") Long posi_min, @Param("posi_max") Long posi_max,@Param("maf_min") Double maf_min, @Param("maf_max") Double maf_max, @Param("impacts") String impacts, @Param("consequences") String consequences, @Param("accession") String accession, @Param("version") String version, @Param("alias") String alias, @Param("description") String description);
}