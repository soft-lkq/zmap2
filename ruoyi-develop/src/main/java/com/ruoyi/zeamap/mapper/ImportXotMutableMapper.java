package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.ImportXotMutable;

/**
 * ImportXot_mutableMapper接口
 * 
 * @author ruoyi
 * @date 2023-03-15
 */
public interface ImportXotMutableMapper 
{
    /**
     * 查询ImportXot_mutable
     * 
     * @param xotMutableId ImportXot_mutable主键
     * @return ImportXot_mutable
     */
    public ImportXotMutable selectImportXotMutableByXotMutableId(Long xotMutableId);

    /**
     * 查询ImportXot_mutable列表
     * 
     * @param importXotMutable ImportXot_mutable
     * @return ImportXot_mutable集合
     */
    public List<ImportXotMutable> selectImportXotMutableList(ImportXotMutable importXotMutable);

    /**
     * 新增ImportXot_mutable
     * 
     * @param importXotMutable ImportXot_mutable
     * @return 结果
     */
    public int insertImportXotMutable(ImportXotMutable importXotMutable);

    /**
     * 修改ImportXot_mutable
     * 
     * @param importXotMutable ImportXot_mutable
     * @return 结果
     */
    public int updateImportXotMutable(ImportXotMutable importXotMutable);

    /**
     * 删除ImportXot_mutable
     * 
     * @param xotMutableId ImportXot_mutable主键
     * @return 结果
     */
    public int deleteImportXotMutableByXotMutableId(Long xotMutableId);

    /**
     * 批量删除ImportXot_mutable
     * 
     * @param xotMutableIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImportXotMutableByXotMutableIds(Long[] xotMutableIds);
}
