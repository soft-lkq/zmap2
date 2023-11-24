package com.ruoyi.zeamap.service;

import com.ruoyi.zeamap.domain.TagvSelectCondition;
import com.ruoyi.zeamap.domain.Tagvariant;

import java.util.List;

/**
 * 【Tagvariant 查询，下载】Service接口
 *
 * @author 邵雯
 * @date 2023-04-29
 */
public interface ITagvariantService {
    /**
     * 查询【Tagvariant】
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
     * 新增【Tagvariant】
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
     * 批量删除【Tagvariant】
     *
     * @param tagvariantIds 需要删除的【Tagvariant】主键集合
     * @return 结果
     */
    public int deleteTagvariantByTagvariantIds(Long[] tagvariantIds);

    /**
     * 删除【Tagvariant】信息
     *
     * @param tagvariantId 【Tagvariant】主键
     * @return 结果
     */
    public int deleteTagvariantByTagvariantId(Long tagvariantId);


    //查询Reference
    public List<String> selectReference();

    //查询Version
    public List<String> selectVersion(String accession);

    //查询selectPopulation
    public List<String> selectPopulation();

    //查询selectAnalysis
    public List<String> selectAnalysis();

    //查询Region --> chr
    public List<String> selectChr();

    //大查询
    public List<TagvSelectCondition> selectTagvariant(String accession, String version, String population, String description, String chr, Long start, Long end);


}
