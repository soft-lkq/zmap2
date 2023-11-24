package com.ruoyi.zeamap.mapper;

import com.ruoyi.zeamap.domain.TagvSelectCondition;
import com.ruoyi.zeamap.domain.Tagvariant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 【Tagvariant 查询，下载】Mapper接口
 *
 * @author 邵雯
 * @date 2023-04-29
 */
public interface TagvariantMapper {
    /**
     * 查询【Tagvariant】 通过 TagvariantId
     *
     * @param tagvariantId 【Tagvariant】主键
     * @return 【Tagvariant】
     */
    public Tagvariant selectTagvariantByTagvariantId(Long tagvariantId);

    /**
     * 查询【Tagvariant】列表
     *
     * @param tagvariant 【Tagvariant】
     * @return 【Tagvariant】集合
     */
    public List<Tagvariant> selectTagvariantList(Tagvariant tagvariant);

    /**
     * 新增【Tagvariant】单条数据
     *
     * @param tagvariant 【Tagvariant】
     * @return 结果
     */
    public int insertTagvariant(Tagvariant tagvariant);

    /**
     * 修改【Tagvariant】
     *
     * @param tagvariant 【Tagvariant】
     * @return 结果
     */
    public int updateTagvariant(Tagvariant tagvariant);

    /**
     * 删除【Tagvariant】
     *
     * @param tagvariantId 【Tagvariant】主键
     * @return 结果
     */
    public int deleteTagvariantByTagvariantId(Long tagvariantId);

    /**
     * 批量删除【Tagvariant】
     *
     * @param tagvariantIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTagvariantByTagvariantIds(Long[] tagvariantIds);

    //查询Reference
    public List<String> selectReference();

    //查询Version
    public List<String> selectVersion(String accession);

    //查询selectPopulation
    public List<String> selectPopulation();

    //查询selectAnalysis
    List<String> selectAnalysis();

    //查询Region --> chr
    public List<String> selectChr();

    //大查询
    public List<TagvSelectCondition> selectTagvariant(@Param("accession") String accession, @Param("version") String version, @Param("population") String population, @Param("description") String description,
                                                      @Param("chr") String chr, @Param("start") Long start, @Param("end") Long end);

}
