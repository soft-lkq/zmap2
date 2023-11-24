package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.ImportMutable;

/**
 * ImportMutableMapper接口
 * 
 * @author ruoyi
 * @date 2023-03-15
 */
public interface ImportMutableMapper 
{
    /**
     * 查询ImportMutable
     * 
     * @param mutableId ImportMutable主键
     * @return ImportMutable
     */
    public ImportMutable selectImportMutableByMutableId(Long mutableId);

    /**
     * 查询ImportMutable列表
     * 
     * @param importMutable ImportMutable
     * @return ImportMutable集合
     */
    public List<ImportMutable> selectImportMutableList(ImportMutable importMutable);

    /**
     * 新增ImportMutable
     * 
     * @param importMutable ImportMutable
     * @return 结果
     */
    public int insertImportMutable(ImportMutable importMutable);

    /**
     * 修改ImportMutable
     * 
     * @param importMutable ImportMutable
     * @return 结果
     */
    public int updateImportMutable(ImportMutable importMutable);

    /**
     * 删除ImportMutable
     * 
     * @param mutableId ImportMutable主键
     * @return 结果
     */
    public int deleteImportMutableByMutableId(Long mutableId);

    /**
     * 批量删除ImportMutable
     * 
     * @param mutableIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImportMutableByMutableIds(Long[] mutableIds);
}
