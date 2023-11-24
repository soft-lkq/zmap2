package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.ImportLinkageMarker;

/**
 * ImportMapper接口
 * 
 * @author ruoyi
 * @date 2023-03-21
 */
public interface ImportLinkageMarkerMapper 
{
    /**
     * 查询Import
     * 
     * @param linkageMarkerId Import主键
     * @return Import
     */
    public ImportLinkageMarker selectImportLinkageMarkerByLinkageMarkerId(Long linkageMarkerId);

    /**
     * 查询Import列表
     * 
     * @param importLinkageMarker Import
     * @return Import集合
     */
    public List<ImportLinkageMarker> selectImportLinkageMarkerList(ImportLinkageMarker importLinkageMarker);

    /**
     * 新增Import
     * 
     * @param importLinkageMarker Import
     * @return 结果
     */
    public int insertImportLinkageMarker(ImportLinkageMarker importLinkageMarker);

    /**
     * 修改Import
     * 
     * @param importLinkageMarker Import
     * @return 结果
     */
    public int updateImportLinkageMarker(ImportLinkageMarker importLinkageMarker);

    /**
     * 删除Import
     * 
     * @param linkageMarkerId Import主键
     * @return 结果
     */
    public int deleteImportLinkageMarkerByLinkageMarkerId(Long linkageMarkerId);

    /**
     * 批量删除Import
     * 
     * @param linkageMarkerIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImportLinkageMarkerByLinkageMarkerIds(Long[] linkageMarkerIds);
}
