package com.ruoyi.zeamap.service;

import java.util.List;

import com.ruoyi.zeamap.domain.ImportCv;
import com.ruoyi.zeamap.domain.ImportCvterm;

/**
 * ImportCvtermService接口
 * 
 * @author ruoyi
 * @date 2023-03-30
 */
public interface IImportCvtermService 
{

    //导入
    public String importCvtermData(List<ImportCvterm> importList, Boolean isUpdateSupport, String operName);

    /**
     * 查询ImportCvterm
     * 
     * @param cvtermId ImportCvterm主键
     * @return ImportCvterm
     */
    public ImportCvterm selectImportCvtermByCvtermId(String cvtermId);

    /**
     * 查询ImportCvterm列表
     * 
     * @param importCvterm ImportCvterm
     * @return ImportCvterm集合
     */
    public List<ImportCvterm> selectImportCvtermList(ImportCvterm importCvterm);

    /**
     * 新增ImportCvterm
     * 
     * @param importCvterm ImportCvterm
     * @return 结果
     */
    public int insertImportCvterm(ImportCvterm importCvterm);

    /**
     * 修改ImportCvterm
     * 
     * @param importCvterm ImportCvterm
     * @return 结果
     */
    public int updateImportCvterm(ImportCvterm importCvterm);

    /**
     * 批量删除ImportCvterm
     * 
     * @param cvtermIds 需要删除的ImportCvterm主键集合
     * @return 结果
     */
    public int deleteImportCvtermByCvtermIds(String[] cvtermIds);

    /**
     * 删除ImportCvterm信息
     * 
     * @param cvtermId ImportCvterm主键
     * @return 结果
     */
    public int deleteImportCvtermByCvtermId(String cvtermId);
}
