package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.zeamap.domain.AssociationMarker;
import com.ruoyi.zeamap.mapper.AssociationMarkerMapper;
import com.ruoyi.zeamap.service.IAssociationMarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-06
 */
@Service
public class AssociationMarkerServiceImpl implements IAssociationMarkerService
{
    @Autowired
    private AssociationMarkerMapper associationMarkerMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param associationMarkerId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public AssociationMarker selectAssociationMarkerByAssociationMarkerId(Long associationMarkerId)
    {
        return associationMarkerMapper.selectAssociationMarkerByAssociationMarkerId(associationMarkerId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param associationMarker 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<AssociationMarker> selectAssociationMarkerList(AssociationMarker associationMarker)
    {
        return associationMarkerMapper.selectAssociationMarkerList(associationMarker);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param associationMarker 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertAssociationMarker(AssociationMarker associationMarker)
    {
        return associationMarkerMapper.insertAssociationMarker(associationMarker);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param associationMarker 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateAssociationMarker(AssociationMarker associationMarker)
    {
        return associationMarkerMapper.updateAssociationMarker(associationMarker);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param associationMarkerIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAssociationMarkerByAssociationMarkerIds(Long[] associationMarkerIds)
    {
        return associationMarkerMapper.deleteAssociationMarkerByAssociationMarkerIds(associationMarkerIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param associationMarkerId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAssociationMarkerByAssociationMarkerId(Long associationMarkerId)
    {
        return associationMarkerMapper.deleteAssociationMarkerByAssociationMarkerId(associationMarkerId);
    }

    /**
     * 由此开始
     * @Author 刘洋
     * @Date 2023/3/11
     * Search Marker模块 Association Mapping的内容
     */

    //查找dbxref表里面的accession
    @Override
    public List<String> selectaccession(){
        return associationMarkerMapper.selectaccession();
    }

    //查找dbxref表里面的version,version是reference的下级
    @Override
    public List<String> selectversion(String accession){
        return associationMarkerMapper.selectversion(accession);
    }

    //查找Trait Category
    @Override
    public List<String> selecttraitcategory()
    {
        return associationMarkerMapper.selecttraitcategory();
    }

    //查找Trait Id
    @Override
    public List<String> selecttraitid(String trait_id){
        return associationMarkerMapper.selecttraitid(trait_id);
    }

    //查找chr
    @Override
    public List<String> selectchr(){
        return associationMarkerMapper.selectchr();
    }

    //查找variant Type
    @Override
    public List<String> selecttype(){return associationMarkerMapper.selecttype();}

    //大查询
    @Override
    public List<AssociationMarker> selectassociation_marker(String accession, String version, String omics, String xot_uid,  String chr, long start, long end, String variantType, Double log_min, Double log_max, Double effect_min, Double effect_max, Double pip_min, Double pip_max) {
        return associationMarkerMapper.selectassociation_marker(accession, version,omics, xot_uid,  chr,start,end, variantType, log_min,log_max, effect_min, effect_max, pip_min, pip_max);

    }


}
