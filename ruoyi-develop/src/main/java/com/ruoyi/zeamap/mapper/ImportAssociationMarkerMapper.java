package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.ImportAssociationMarker;

/**
 * ImportMapper接口
 * 
 * @author ruoyi
 * @date 2023-03-21
 */
public interface ImportAssociationMarkerMapper 
{
    /**
     * 查询Import
     * 
     * @param associationMarkerId Import主键
     * @return Import
     */
    public ImportAssociationMarker selectImportAssociationMarkerByAssociationMarkerId(Long associationMarkerId);

    /**
     * 查询Import列表
     * 
     * @param importAssociationMarker Import
     * @return Import集合
     */
    public List<ImportAssociationMarker> selectImportAssociationMarkerList(ImportAssociationMarker importAssociationMarker);

    /**
     * 新增Import
     * 
     * @param importAssociationMarker Import
     * @return 结果
     */
    public int insertImportAssociationMarker(ImportAssociationMarker importAssociationMarker);

    /**
     * 修改Import
     * 
     * @param importAssociationMarker Import
     * @return 结果
     */
    public int updateImportAssociationMarker(ImportAssociationMarker importAssociationMarker);

    /**
     * 删除Import
     * 
     * @param associationMarkerId Import主键
     * @return 结果
     */
    public int deleteImportAssociationMarkerByAssociationMarkerId(Long associationMarkerId);

    /**
     * 批量删除Import
     * 
     * @param associationMarkerIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImportAssociationMarkerByAssociationMarkerIds(Long[] associationMarkerIds);
}
