package com.ruoyi.zeamap.service;

import java.util.List;

import com.ruoyi.zeamap.domain.ImportAnalysis;
import com.ruoyi.zeamap.domain.ImportAssociationQtl;

/**
 * ImportAqtlService接口
 * 
 * @author ruoyi
 * @date 2023-03-18
 */
public interface IImportAssociationQtlService 
{
    public String importAssociationQtlData(List<ImportAssociationQtl> importList, Boolean isUpdateSupport, String operName);


    /**
     * 查询ImportAqtl
     * 
     * @param associationQtlId ImportAqtl主键
     * @return ImportAqtl
     */
    public ImportAssociationQtl selectImportAssociationQtlByAssociationQtlId(Long associationQtlId);

    /**
     * 查询ImportAqtl列表
     * 
     * @param importAssociationQtl ImportAqtl
     * @return ImportAqtl集合
     */
    public List<ImportAssociationQtl> selectImportAssociationQtlList(ImportAssociationQtl importAssociationQtl);

    /**
     * 新增ImportAqtl
     * 
     * @param importAssociationQtl ImportAqtl
     * @return 结果
     */
    public int insertImportAssociationQtl(ImportAssociationQtl importAssociationQtl);

    /**
     * 修改ImportAqtl
     * 
     * @param importAssociationQtl ImportAqtl
     * @return 结果
     */
    public int updateImportAssociationQtl(ImportAssociationQtl importAssociationQtl);

    /**
     * 批量删除ImportAqtl
     * 
     * @param associationQtlIds 需要删除的ImportAqtl主键集合
     * @return 结果
     */
    public int deleteImportAssociationQtlByAssociationQtlIds(Long[] associationQtlIds);

    /**
     * 删除ImportAqtl信息
     * 
     * @param associationQtlId ImportAqtl主键
     * @return 结果
     */
    public int deleteImportAssociationQtlByAssociationQtlId(Long associationQtlId);
}
