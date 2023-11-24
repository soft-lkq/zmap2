package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.ImportDbxref;

/**
 * 1Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-14
 */
public interface ImportDbxrefMapper 
{
    /**
     * 查询1
     *
     * @param dbxrefId 1主键
     * @return 1
     */
    public  ImportDbxref selectImportDbxrefByDbxrefId(Long dbxrefId);

    /**
     * 查询1列表
     * 
     * @param importDbxref 1
     * @return 1集合
     */
    public List<ImportDbxref> selectImportDbxrefList(ImportDbxref importDbxref);

    /**
     * 新增1
     * 
     * @param importDbxref 1
     * @return 结果
     */
    public int insertImportDbxref(ImportDbxref importDbxref);

    /**
     * 修改1
     * 
     * @param importDbxref 1
     * @return 结果
     */
    public int updateImportDbxref(ImportDbxref importDbxref);

    /**
     * 删除1
     * 
     * @param dbxrefId 1主键
     * @return 结果
     */
    public int deleteImportDbxrefByDbxrefId(Long dbxrefId);

    /**
     * 批量删除1
     * 
     * @param dbxrefIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImportDbxrefByDbxrefIds(Long[] dbxrefIds);
}
