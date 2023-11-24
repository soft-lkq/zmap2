package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.ImportCvterm;

/**
 * ImportCvtermMapper接口
 * 
 * @author ruoyi
 * @date 2023-03-30
 */
public interface ImportCvtermMapper 
{
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
     * 删除ImportCvterm
     * 
     * @param cvtermId ImportCvterm主键
     * @return 结果
     */
    public int deleteImportCvtermByCvtermId(String cvtermId);

    /**
     * 批量删除ImportCvterm
     * 
     * @param cvtermIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImportCvtermByCvtermIds(String[] cvtermIds);
}
