package com.ruoyi.zeamap.service;

import java.util.List;

import com.ruoyi.zeamap.domain.AssociationMarker;
import com.ruoyi.zeamap.domain.AssociationQtl;


/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-03-06
 */
public interface IAssociationQtlService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param associationQtlId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public AssociationQtl selectAssociationQtlByAssociationQtlId(Long associationQtlId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param associationQtl 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<AssociationQtl> selectAssociationQtlList(AssociationQtl associationQtl);

    /**
     * 新增【请填写功能名称】
     * 
     * @param associationQtl 【请填写功能名称】
     * @return 结果
     */
    public int insertAssociationQtl(AssociationQtl associationQtl);

    /**
     * 修改【请填写功能名称】
     * 
     * @param associationQtl 【请填写功能名称】
     * @return 结果
     */
    public int updateAssociationQtl(AssociationQtl associationQtl);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param associationQtlIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteAssociationQtlByAssociationQtlIds(Long[] associationQtlIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param associationQtlId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteAssociationQtlByAssociationQtlId(Long associationQtlId);


    /**
     * 由此开始
     * @Author 刘洋
     * @Date 2023/3/11
     * Search Qtl模块 Association Mapping的内容
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
    //大查询
    public List<AssociationQtl> selectassociation_qtl(String accession, String version, String omics, String xot_uid,  String chr, long start, long end, Double log_min, Double log_max);

   }
