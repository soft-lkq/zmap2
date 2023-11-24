package com.ruoyi.zeamap.service;

import java.util.List;

import com.ruoyi.zeamap.domain.ImportMutable;
import com.ruoyi.zeamap.domain.ImportXotMutable;

/**
 * ImportXot_mutableService接口
 * 
 * @author ruoyi
 * @date 2023-03-15
 */
public interface IImportXotMutableService 
{
    //导入
    public String importXotMutableData(List<ImportXotMutable> importList, Boolean isUpdateSupport, String operName);


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
     * 批量删除ImportXot_mutable
     * 
     * @param xotMutableIds 需要删除的ImportXot_mutable主键集合
     * @return 结果
     */
    public int deleteImportXotMutableByXotMutableIds(Long[] xotMutableIds);

    /**
     * 删除ImportXot_mutable信息
     * 
     * @param xotMutableId ImportXot_mutable主键
     * @return 结果
     */
    public int deleteImportXotMutableByXotMutableId(Long xotMutableId);
}
