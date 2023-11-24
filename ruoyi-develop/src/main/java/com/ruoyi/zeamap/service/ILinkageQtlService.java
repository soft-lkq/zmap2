package com.ruoyi.zeamap.service;

import com.ruoyi.zeamap.domain.LinkageQtl;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-03-06
 */
public interface ILinkageQtlService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param linkageQtlId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public LinkageQtl selectLinkageQtlByLinkageQtlId(Long linkageQtlId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param linkageQtl 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<LinkageQtl> selectLinkageQtlList(LinkageQtl linkageQtl);

    /**
     * 新增【请填写功能名称】
     * 
     * @param linkageQtl 【请填写功能名称】
     * @return 结果
     */
    public int insertLinkageQtl(LinkageQtl linkageQtl);

    /**
     * 修改【请填写功能名称】
     * 
     * @param linkageQtl 【请填写功能名称】
     * @return 结果
     */
    public int updateLinkageQtl(LinkageQtl linkageQtl);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param linkageQtlIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteLinkageQtlByLinkageQtlIds(Long[] linkageQtlIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param linkageQtlId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteLinkageQtlByLinkageQtlId(Long linkageQtlId);

    /**
     * 由此开始
     * @Author 刘洋
     * @Date 2023/3/11
     * Search Qtl模块 Linkage Mapping的内容
     */

    //查找dbxref表里面的accession
    public List<String> selectaccession();

    //查找dbxref表里面的version,version是reference的下级
    public List<String> selectversion(String accession);

    //查找Trait Category
    public List<String> selecttraitcategory();

    //查找Trait Id
    public List<String> selecttraitid(String trait_id);

    //查找chr
    public List<String> selectchr();
    //查找linkagemap
    public List<String> selectlinkagemap();

    //大查询
    public List<LinkageQtl> selectlinkage_qtl(String accession, String version,String omics,String xot_uid, String linkageMap,  String chr,long start, long end,Double lod_min, Double lod_max);

}
