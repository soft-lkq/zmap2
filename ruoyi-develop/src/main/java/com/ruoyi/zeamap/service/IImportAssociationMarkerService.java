package com.ruoyi.zeamap.service;

import java.util.List;
import com.ruoyi.zeamap.domain.ImportAssociationMarker;
import com.ruoyi.zeamap.domain.ImportAssociationQtl;

/**
 * ImportService接口
 * 
 * @author ruoyi
 * @date 2023-03-21
 */
public interface IImportAssociationMarkerService 
{
    public String importAssociationMarkerData(List<ImportAssociationMarker> importList, Boolean isUpdateSupport, String operName);

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
     * 批量删除Import
     * 
     * @param associationMarkerIds 需要删除的Import主键集合
     * @return 结果
     */
    public int deleteImportAssociationMarkerByAssociationMarkerIds(Long[] associationMarkerIds);

    /**
     * 删除Import信息
     * 
     * @param associationMarkerId Import主键
     * @return 结果
     */
    public int deleteImportAssociationMarkerByAssociationMarkerId(Long associationMarkerId);
}
