package com.ruoyi.zeamap.service.impl;

import com.ruoyi.zeamap.domain.TagvSelectCondition;
import com.ruoyi.zeamap.domain.Tagvariant;
import com.ruoyi.zeamap.mapper.TagvariantMapper;
import com.ruoyi.zeamap.service.ITagvariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【Tagvariant 查询，下载】Service业务层处理
 *
 * @author 邵雯
 * @date 2023-04-29
 */
@Service
public class TagvariantServiceImpl implements ITagvariantService {
    @Autowired
    private TagvariantMapper tagvariantMapper;

    /**
     * 查询【Tagvariant】
     *
     * @param tagvariantId 【Tagvariant】主键
     * @return 【Tagvariant】
     */
    @Override
    public Tagvariant selectTagvariantByTagvariantId(Long tagvariantId) {
        return tagvariantMapper.selectTagvariantByTagvariantId(tagvariantId);
    }

    /**
     * 查询【Tagvariant】列表
     *
     * @param tagvariant 【Tagvariant】
     * @return 【Tagvariant】
     */
    @Override
    public List<Tagvariant> selectTagvariantList(Tagvariant tagvariant) {
        return tagvariantMapper.selectTagvariantList(tagvariant);
    }

    /**
     * 新增【Tagvariant】
     *
     * @param tagvariant 【Tagvariant】
     * @return 结果
     */
    @Override
    public int insertTagvariant(Tagvariant tagvariant) {
        return tagvariantMapper.insertTagvariant(tagvariant);
    }

    /**
     * 修改【Tagvariant】
     *
     * @param tagvariant 【Tagvariant】
     * @return 结果
     */
    @Override
    public int updateTagvariant(Tagvariant tagvariant) {
        return tagvariantMapper.updateTagvariant(tagvariant);
    }

    /**
     * 批量删除【Tagvariant】
     *
     * @param tagvariantIds 需要删除的【Tagvariant】主键
     * @return 结果
     */
    @Override
    public int deleteTagvariantByTagvariantIds(Long[] tagvariantIds) {
        return tagvariantMapper.deleteTagvariantByTagvariantIds(tagvariantIds);
    }

    /**
     * 删除【Tagvariant】信息
     *
     * @param tagvariantId 【Tagvariant】主键
     * @return 结果
     */
    @Override
    public int deleteTagvariantByTagvariantId(Long tagvariantId) {
        return tagvariantMapper.deleteTagvariantByTagvariantId(tagvariantId);
    }


    //查询Reference
    @Override
    public List<String> selectReference() {
        return tagvariantMapper.selectReference();
    }

    //查询Version
    @Override
    public List<String> selectVersion(String accession) {
        return tagvariantMapper.selectVersion(accession);
    }

    //查询Population
    @Override
    public List<String> selectPopulation() {
        return tagvariantMapper.selectPopulation();
    }

    //查询Analysis
    @Override
    public List<String> selectAnalysis() {
        return tagvariantMapper.selectAnalysis();
    }

    //查询Region 即 查询chr
    @Override
    public List<String> selectChr() {
        return tagvariantMapper.selectChr();
    }

    //大查询
    @Override
    public List<TagvSelectCondition> selectTagvariant(String accession, String version, String population, String description, String chr, Long start, Long end) {
        return tagvariantMapper.selectTagvariant(accession, version, population, description, chr, start, end);
    }

}
