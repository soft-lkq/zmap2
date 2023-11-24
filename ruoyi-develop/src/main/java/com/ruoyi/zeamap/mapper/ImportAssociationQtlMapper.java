package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.ImportAssociationQtl;

/**
 * ImportAqtlMapper接口
 * 
 * @author ruoyi
 * @date 2023-03-18
 */
public interface ImportAssociationQtlMapper 
{
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
     * 删除ImportAqtl
     * 
     * @param associationQtlId ImportAqtl主键
     * @return 结果
     */
    public int deleteImportAssociationQtlByAssociationQtlId(Long associationQtlId);

    /**
     * 批量删除ImportAqtl
     * 
     * @param associationQtlIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImportAssociationQtlByAssociationQtlIds(Long[] associationQtlIds);
}
