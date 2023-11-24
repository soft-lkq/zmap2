package com.ruoyi.zeamap.mapper;

import java.util.List;

import com.ruoyi.zeamap.domain.AssociationMarker;
import com.ruoyi.zeamap.domain.AssociationQtl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-06
 */
@Mapper
public interface AssociationQtlMapper 
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
     * 删除【请填写功能名称】
     * 
     * @param associationQtlId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteAssociationQtlByAssociationQtlId(Long associationQtlId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param associationQtlIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAssociationQtlByAssociationQtlIds(Long[] associationQtlIds);

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
    public List<AssociationQtl> selectassociation_qtl(@Param("accession") String accession, @Param("version") String version, @Param("omics") String omics, @Param("xot_uid") String xot_uid, @Param("chr") String chr, @Param("start") long start, @Param("end") long end, @Param("log_min") Double log_min, @Param("log_max") Double log_max);

}
