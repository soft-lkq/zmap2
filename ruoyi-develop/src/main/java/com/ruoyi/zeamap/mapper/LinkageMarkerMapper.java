package com.ruoyi.zeamap.mapper;

import java.util.List;

import com.ruoyi.zeamap.domain.AssociationQtl;
import com.ruoyi.zeamap.domain.LinkageMarker;
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
public interface LinkageMarkerMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param linkageMarkerId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public LinkageMarker selectLinkageMarkerByLinkageMarkerId(Long linkageMarkerId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param linkageMarker 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<LinkageMarker> selectLinkageMarkerList(LinkageMarker linkageMarker);

    /**
     * 新增【请填写功能名称】
     * 
     * @param linkageMarker 【请填写功能名称】
     * @return 结果
     */
    public int insertLinkageMarker(LinkageMarker linkageMarker);

    /**
     * 修改【请填写功能名称】
     * 
     * @param linkageMarker 【请填写功能名称】
     * @return 结果
     */
    public int updateLinkageMarker(LinkageMarker linkageMarker);

    /**
     * 删除【请填写功能名称】
     * 
     * @param linkageMarkerId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteLinkageMarkerByLinkageMarkerId(Long linkageMarkerId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param linkageMarkerIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLinkageMarkerByLinkageMarkerIds(Long[] linkageMarkerIds);

    /**
     * 由此开始
     * @Author 刘洋
     * @Date 2023/3/11
     * Search Marker模块 Linkage Mapping的内容
     */

    //查找dbxref表里面的accession
    public List<String> selectaccession();

    //查找dbxref表里面的version,version是reference的下级
    public List<String> selectversion(String accession);

    //查找Trait Category
    public List<String> selecttraitcategory();

    //查找Trait Id
    public List<String> selecttraitid(String trait_id);

    //查找linkagemap
    public List<String> selectlinkagemap();

    //查找Variant Type
    public List<String> selectvarianttype();

    //查找LG(Linkage Group)
    public List<String> selectlg();
    //大查询
    public List<LinkageMarker> selectlinkage_marker(@Param("accession") String accession, @Param("version") String version, @Param("omics") String omics, @Param("xot_uid") String xot_uid, @Param("linkagemap") String linageMap, @Param("lg") long lg, @Param("cm_min") Double cm_min, @Param("cm_max") Double cm_max);

}
