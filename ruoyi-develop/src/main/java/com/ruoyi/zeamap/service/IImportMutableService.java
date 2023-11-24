package com.ruoyi.zeamap.service;

import java.util.List;

import com.ruoyi.zeamap.domain.ImportDbxref;
import com.ruoyi.zeamap.domain.ImportMutable;

/**
 * ImportMutableService接口
 * 
 * @author ruoyi
 * @date 2023-03-15
 */
public interface IImportMutableService 
{

    //导入
    public String importMutableData(List<ImportMutable> importMutableList, Boolean isUpdateSupport, String operName);
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
     * 批量删除ImportMutable
     * 
     * @param mutableIds 需要删除的ImportMutable主键集合
     * @return 结果
     */
    public int deleteImportMutableByMutableIds(Long[] mutableIds);

    /**
     * 删除ImportMutable信息
     * 
     * @param mutableId ImportMutable主键
     * @return 结果
     */
    public int deleteImportMutableByMutableId(Long mutableId);
}
