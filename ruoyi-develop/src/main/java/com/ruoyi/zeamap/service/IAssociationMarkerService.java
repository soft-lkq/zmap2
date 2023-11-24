package com.ruoyi.zeamap.service;

import java.util.List;

import com.ruoyi.zeamap.domain.AssociationMarker;
import com.ruoyi.zeamap.domain.Variant;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-03-06
 */
public interface IAssociationMarkerService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param associationMarkerId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public AssociationMarker selectAssociationMarkerByAssociationMarkerId(Long associationMarkerId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param associationMarker 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<AssociationMarker> selectAssociationMarkerList(AssociationMarker associationMarker);

    /**
     * 新增【请填写功能名称】
     * 
     * @param associationMarker 【请填写功能名称】
     * @return 结果
     */
    public int insertAssociationMarker(AssociationMarker associationMarker);

    /**
     * 修改【请填写功能名称】
     * 
     * @param associationMarker 【请填写功能名称】
     * @return 结果
     */
    public int updateAssociationMarker(AssociationMarker associationMarker);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param associationMarkerIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteAssociationMarkerByAssociationMarkerIds(Long[] associationMarkerIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param associationMarkerId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteAssociationMarkerByAssociationMarkerId(Long associationMarkerId);

    /**
     * 由此开始
     * @Author 刘洋
     * @Date 2023/3/11
     * Search Marker模块 Association Mapping的内容
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

    //查找variant Type
    public List<String> selecttype();

    //大查询
    public List<AssociationMarker> selectassociation_marker(String accession, String version, String omics, String xot_uid,String chr, long start,long end,String variantType, Double log_min,Double log_max, Double effect_min, Double effect_max, Double pip_min, Double pip_max);



 }
