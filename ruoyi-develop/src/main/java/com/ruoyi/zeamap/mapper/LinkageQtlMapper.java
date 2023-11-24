package com.ruoyi.zeamap.mapper;

import java.util.List;

import com.ruoyi.zeamap.domain.AssociationQtl;
import com.ruoyi.zeamap.domain.LinkageQtl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-06
 */
@Mapper
public interface LinkageQtlMapper 
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
     * 删除【请填写功能名称】
     * 
     * @param linkageQtlId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteLinkageQtlByLinkageQtlId(Long linkageQtlId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param linkageQtlIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLinkageQtlByLinkageQtlIds(Long[] linkageQtlIds);

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
    public List<LinkageQtl> selectlinkage_qtl(@Param("accession") String accession, @Param("version") String version, @Param("omics") String omics, @Param("xot_uid") String xot_uid, @Param("linkagemap") String linkageMap,@Param("chr") String chr, @Param("start") long start, @Param("end") long end, @Param("lod_min") Double log_min, @Param("lod_max") Double log_max);

}
