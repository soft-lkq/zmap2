package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.zeamap.domain.LinkageMarker;
import com.ruoyi.zeamap.mapper.LinkageMarkerMapper;
import com.ruoyi.zeamap.service.ILinkageMarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-06
 */
@Service
public class LinkageMarkerServiceImpl implements ILinkageMarkerService
{
    @Autowired
    private LinkageMarkerMapper linkageMarkerMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param linkageMarkerId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public LinkageMarker selectLinkageMarkerByLinkageMarkerId(Long linkageMarkerId)
    {
        return linkageMarkerMapper.selectLinkageMarkerByLinkageMarkerId(linkageMarkerId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param linkageMarker 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<LinkageMarker> selectLinkageMarkerList(LinkageMarker linkageMarker)
    {
        return linkageMarkerMapper.selectLinkageMarkerList(linkageMarker);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param linkageMarker 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertLinkageMarker(LinkageMarker linkageMarker)
    {
        return linkageMarkerMapper.insertLinkageMarker(linkageMarker);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param linkageMarker 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateLinkageMarker(LinkageMarker linkageMarker)
    {
        return linkageMarkerMapper.updateLinkageMarker(linkageMarker);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param linkageMarkerIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteLinkageMarkerByLinkageMarkerIds(Long[] linkageMarkerIds)
    {
        return linkageMarkerMapper.deleteLinkageMarkerByLinkageMarkerIds(linkageMarkerIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param linkageMarkerId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteLinkageMarkerByLinkageMarkerId(Long linkageMarkerId)
    {
        return linkageMarkerMapper.deleteLinkageMarkerByLinkageMarkerId(linkageMarkerId);
    }
    /**
     * 由此开始
     * @Author 刘洋
     * @Date 2023/3/11
     * Search Marker模块 Linkage Mapping的内容
     */

    //查找dbxref表里面的accession
    @Override
    public List<String> selectaccession(){
        return linkageMarkerMapper.selectaccession();
    }

    //查找dbxref表里面的version,version是reference的下级
    @Override
    public List<String> selectversion(String accession){
        return linkageMarkerMapper.selectversion(accession);
    }

    //查找Trait Category
    @Override
    public List<String> selecttraitcategory()
    {
        return linkageMarkerMapper.selecttraitcategory();
    }
    //查找Trait Id
    @Override
    public List<String> selecttraitid(String trait_id){
        return linkageMarkerMapper.selecttraitid(trait_id);
    }
    //查找linkagemap
    @Override
    public List<String> selectlinkagemap(){
        return linkageMarkerMapper.selectlinkagemap();
    }
    //查找variant Type
    @Override
    public List<String> selectvarianttype()
    {
        return linkageMarkerMapper.selectvarianttype();
    }


    //查找LG(Linkage Group)
    @Override
    public List<String> selectlg(){
        return linkageMarkerMapper.selectlg();
    }
    //大查询
    @Override
    public List<LinkageMarker> selectlinkage_marker(String accession, String version,String omics, String xot_uid, String linageMap, long lg, Double cm_min, Double cm_max)
    {
        return linkageMarkerMapper.selectlinkage_marker(accession,version,omics,xot_uid,linageMap,lg,cm_min,cm_max);
    }
}
