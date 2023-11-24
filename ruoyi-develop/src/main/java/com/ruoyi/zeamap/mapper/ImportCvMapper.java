package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.ImportCv;

/**
 * ImportCvMapper接口
 * 
 * @author ruoyi
 * @date 2023-03-30
 */
public interface ImportCvMapper 
{
    /**
     * 查询ImportCv
     * 
     * @param cvId ImportCv主键
     * @return ImportCv
     */
    public ImportCv selectImportCvByCvId(String cvId);

    /**
     * 查询ImportCv列表
     * 
     * @param importCv ImportCv
     * @return ImportCv集合
     */
    public List<ImportCv> selectImportCvList(ImportCv importCv);

    /**
     * 新增ImportCv
     * 
     * @param importCv ImportCv
     * @return 结果
     */
    public int insertImportCv(ImportCv importCv);

    /**
     * 修改ImportCv
     * 
     * @param importCv ImportCv
     * @return 结果
     */
    public int updateImportCv(ImportCv importCv);

    /**
     * 删除ImportCv
     * 
     * @param cvId ImportCv主键
     * @return 结果
     */
    public int deleteImportCvByCvId(String cvId);

    /**
     * 批量删除ImportCv
     * 
     * @param cvIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImportCvByCvIds(String[] cvIds);
}
