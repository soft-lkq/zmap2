package com.ruoyi.zeamap.service;

import java.util.List;

import com.ruoyi.zeamap.domain.ImportDbxref;
import com.ruoyi.zeamap.domain.ImportLinkageQtl;

/**
 * ImportLqtlService接口
 * 
 * @author ruoyi
 * @date 2023-03-20
 */
public interface IImportLinkageQtlService 
{

    public String importLinkageQtlData(List<ImportLinkageQtl> importList, Boolean isUpdateSupport, String operName);




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
     * 批量删除ImportLqtl
     * 
     * @param linkageQtlIds 需要删除的ImportLqtl主键集合
     * @return 结果
     */
    public int deleteImportLinkageQtlByLinkageQtlIds(Long[] linkageQtlIds);

    /**
     * 删除ImportLqtl信息
     * 
     * @param linkageQtlId ImportLqtl主键
     * @return 结果
     */
    public int deleteImportLinkageQtlByLinkageQtlId(Long linkageQtlId);
}
