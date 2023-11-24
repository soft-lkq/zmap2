package com.ruoyi.zeamap.service;

import com.ruoyi.zeamap.domain.Analysis;

import java.util.List;

/**
 * 【analysis查询、下载】Service接口
 *
 * @author 邵雯
 * @date 2023-03-10
 */
public interface IAnalysisService {
    /**
     * 查询【Analysis】
     *
     * @param analysisId 【Analysis】主键
     * @return 【Analysis】
     */
    public Analysis selectAnalysisByAnalysisId(Long analysisId);

    /**
     * 查询【Analysis】列表
     *
     * @param analysis 【Analysis】
     * @return 【Analysis】集合
     */
    public List<Analysis> selectAnalysisList(Analysis analysis);

    /**
     * 新增【Analysis】单条数据
     *
     * @param analysis 【Analysis】
     * @return 结果
     */
    public int insertAnalysis(Analysis analysis);

    /**
     * 修改【Analysis】单条数据
     *
     * @param analysis 【Analysis】
     * @return 结果
     */
    public int updateAnalysis(Analysis analysis);

    /**
     * 批量删除【Analysis】
     *
     * @param analysisIds 需要删除的【Analysis】主键集合
     * @return 结果
     */
    public int deleteAnalysisByAnalysisIds(Long[] analysisIds);

    /**
     * 删除【Analysis】单条信息
     *
     * @param analysisId 【Analysis】主键
     * @return 结果
     */
    public int deleteAnalysisByAnalysisId(Long analysisId);


    //查询 Omica
    public List<String> selectOmics();

    //查询 AnalysisID
    public List<String> selectAnalysisID();

    //查询 Analysis
    public List<Analysis> selectAnalysis(String name, String omics, String description);

    //通过Name查询Analysis 下载用
    public Analysis selectAnalysisByName(String name);
}
