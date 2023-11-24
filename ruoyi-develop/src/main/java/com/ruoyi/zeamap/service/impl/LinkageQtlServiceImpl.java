package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.zeamap.domain.LinkageQtl;
import com.ruoyi.zeamap.mapper.LinkageQtlMapper;
import com.ruoyi.zeamap.service.ILinkageQtlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-06
 */
@Service
public class LinkageQtlServiceImpl implements ILinkageQtlService
{
    @Autowired
    private LinkageQtlMapper linkageQtlMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param linkageQtlId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public LinkageQtl selectLinkageQtlByLinkageQtlId(Long linkageQtlId)
    {
        return linkageQtlMapper.selectLinkageQtlByLinkageQtlId(linkageQtlId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param linkageQtl 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<LinkageQtl> selectLinkageQtlList(LinkageQtl linkageQtl)
    {
        return linkageQtlMapper.selectLinkageQtlList(linkageQtl);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param linkageQtl 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertLinkageQtl(LinkageQtl linkageQtl)
    {
        return linkageQtlMapper.insertLinkageQtl(linkageQtl);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param linkageQtl 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateLinkageQtl(LinkageQtl linkageQtl)
    {
        return linkageQtlMapper.updateLinkageQtl(linkageQtl);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param linkageQtlIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteLinkageQtlByLinkageQtlIds(Long[] linkageQtlIds)
    {
        return linkageQtlMapper.deleteLinkageQtlByLinkageQtlIds(linkageQtlIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param linkageQtlId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteLinkageQtlByLinkageQtlId(Long linkageQtlId)
    {
        return linkageQtlMapper.deleteLinkageQtlByLinkageQtlId(linkageQtlId);
    }

    /**
     * 由此开始
     * @Author 刘洋
     * @Date 2023/3/11
     * Search Qtl模块 Linkage Mapping的内容
     */

    //查找dbxref表里面的accession
    @Override
    public List<String> selectaccession(){
        return linkageQtlMapper.selectaccession();
    }

    //查找dbxref表里面的version,version是reference的下级
    @Override
    public List<String> selectversion(String accession){
        return linkageQtlMapper.selectversion(accession);
    }

    //查找Trait Category
    public List<String> selecttraitcategory()
    {
        return linkageQtlMapper.selecttraitcategory();
    }

    //查找Trait Id
    public List<String> selecttraitid(String trait_id){
        return linkageQtlMapper.selecttraitid(trait_id);
    }

    //查找chr
    public List<String> selectchr(){
        return linkageQtlMapper.selectchr();
    }
    //查找linkagemap
    public List<String> selectlinkagemap(){
        return linkageQtlMapper.selectlinkagemap();
    }
    //大查询
    public List<LinkageQtl> selectlinkage_qtl(String accession, String version,String omics,String xot_uid, String linkageMap, String chr,long start, long end,Double lod_min, Double lod_max){
        return linkageQtlMapper.selectlinkage_qtl(accession,version,omics,xot_uid,linkageMap,chr,start,end,lod_min,lod_max);
    }

}
