package com.ruoyi.zeamap.mapper;

import com.ruoyi.zeamap.domain.Analysis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 【analysisi查询、下载】Mapper接口
 *
 * @author 邵雯
 * @date 2023-03-10
 */
public interface AnalysisMapper {
    /**
     * 查询 Analysis通过analysisId
     *
     * @param analysisId Analysis主键
     * @return 结果
     */
    public Analysis selectAnalysisByAnalysisId(Long analysisId);

    /**
     * 查询 Analysis 列表
     *
     * @param analysis Analysis
     * @return 结果
     */
    public List<Analysis> selectAnalysisList(Analysis analysis);

    /**
     * 新增 Analysis数据
     *
     * @param analysis Analysis
     * @return 结果
     */
    public int insertAnalysis(Analysis analysis);

    /**
     * 修改 Analysis 数据
     *
     * @param analysis Analysis
     * @return 结果
     */
    public int updateAnalysis(Analysis analysis);

    /**
     * 删除 Analysis单挑数据
     *
     * @param analysisId Analysis主键
     * @return 结果
     */
    public int deleteAnalysisByAnalysisId(Long analysisId);

    /**
     * 批量删除 Analysis数据
     *
     * @param analysisIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAnalysisByAnalysisIds(Long[] analysisIds);

    //查询 Omica
    public List<String> selectOmics();

    //查询 AnalysisID
    public List<String> selectAnalysisID();

    //查询 Analysis
    public List<Analysis> selectAnalysis(@Param("name") String name, @Param("omics") String omics, @Param("description") String description);

    //通过Name查询Analysis 下载用
    public Analysis selectAnalysisByName(String name);

}
