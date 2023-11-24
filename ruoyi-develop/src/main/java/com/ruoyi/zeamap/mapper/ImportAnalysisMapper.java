package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.ImportAnalysis;

/**
 * ImportAnalysisMapper接口
 * 
 * @author ruoyi
 * @date 2023-03-15
 */
public interface ImportAnalysisMapper 
{
    /**
     * 查询ImportAnalysis
     * 
     * @param analysisId ImportAnalysis主键
     * @return ImportAnalysis
     */
    public ImportAnalysis selectImportAnalysisByAnalysisId(Long analysisId);

    /**
     * 查询ImportAnalysis列表
     * 
     * @param importAnalysis ImportAnalysis
     * @return ImportAnalysis集合
     */
    public List<ImportAnalysis> selectImportAnalysisList(ImportAnalysis importAnalysis);

    /**
     * 新增ImportAnalysis
     * 
     * @param importAnalysis ImportAnalysis
     * @return 结果
     */
    public int insertImportAnalysis(ImportAnalysis importAnalysis);

    /**
     * 修改ImportAnalysis
     * 
     * @param importAnalysis ImportAnalysis
     * @return 结果
     */
    public int updateImportAnalysis(ImportAnalysis importAnalysis);

    /**
     * 删除ImportAnalysis
     * 
     * @param analysisId ImportAnalysis主键
     * @return 结果
     */
    public int deleteImportAnalysisByAnalysisId(Long analysisId);

    /**
     * 批量删除ImportAnalysis
     * 
     * @param analysisIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImportAnalysisByAnalysisIds(Long[] analysisIds);
}
