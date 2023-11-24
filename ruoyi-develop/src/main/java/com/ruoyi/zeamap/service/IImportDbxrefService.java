package com.ruoyi.zeamap.service;

import java.util.List;
import com.ruoyi.zeamap.domain.ImportDbxref;

/**
 * 1Service接口
 * 
 * @author ruoyi
 * @date 2023-03-14
 */
public interface IImportDbxrefService 
{

    //导入
    public String importDbxrefData(List<ImportDbxref> importDbxrefList, Boolean isUpdateSupport, String operName);


    /**
     * 查询1
     * 
     * @param dbxrefId 1主键
     * @return 1
     */
    public ImportDbxref selectImportDbxrefByDbxrefId(Long dbxrefId);

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
     * 批量删除1
     * 
     * @param dbxrefIds 需要删除的1主键集合
     * @return 结果
     */
    public int deleteImportDbxrefByDbxrefIds(Long[] dbxrefIds);

    /**
     * 删除1信息
     * 
     * @param dbxrefId 1主键
     * @return 结果
     */
    public int deleteImportDbxrefByDbxrefId(Long dbxrefId);
}
