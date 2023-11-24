package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.ImportLinkageQtl;

/**
 * ImportLqtlMapper接口
 * 
 * @author ruoyi
 * @date 2023-03-20
 */
public interface ImportLinkageQtlMapper 
{
    /**
     * 查询ImportLqtl
     * 
     * @param linkageQtlId ImportLqtl主键
     * @return ImportLqtl
     */
    public ImportLinkageQtl selectImportLinkageQtlByLinkageQtlId(Long linkageQtlId);

    /**
     * 查询ImportLqtl列表
     * 
     * @param importLinkageQtl ImportLqtl
     * @return ImportLqtl集合
     */
    public List<ImportLinkageQtl> selectImportLinkageQtlList(ImportLinkageQtl importLinkageQtl);

    /**
     * 新增ImportLqtl
     * 
     * @param importLinkageQtl ImportLqtl
     * @return 结果
     */
    public int insertImportLinkageQtl(ImportLinkageQtl importLinkageQtl);

    /**
     * 修改ImportLqtl
     * 
     * @param importLinkageQtl ImportLqtl
     * @return 结果
     */
    public int updateImportLinkageQtl(ImportLinkageQtl importLinkageQtl);

    /**
     * 删除ImportLqtl
     * 
     * @param linkageQtlId ImportLqtl主键
     * @return 结果
     */
    public int deleteImportLinkageQtlByLinkageQtlId(Long linkageQtlId);

    /**
     * 批量删除ImportLqtl
     * 
     * @param linkageQtlIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImportLinkageQtlByLinkageQtlIds(Long[] linkageQtlIds);
}
