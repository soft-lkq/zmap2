package com.ruoyi.zeamap.service.impl;

import com.ruoyi.zeamap.domain.Analysis;
import com.ruoyi.zeamap.mapper.AnalysisMapper;
import com.ruoyi.zeamap.service.IAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【Analysis查询、下载】Service业务层处理
 *
 * @author 邵雯
 * @date 2023-03-10
 */
@Service
public class AnalysisServiceImpl implements IAnalysisService {
    @Autowired
    private AnalysisMapper analysisMapper;

    /**
     * 查询【Analysis】
     *
     * @param analysisId 【Analysis】主键
     * @return 【Analysis】
     */
    @Override
    public Analysis selectAnalysisByAnalysisId(Long analysisId) {
        return analysisMapper.selectAnalysisByAnalysisId(analysisId);
    }

    /**
     * 查询【Analysis】列表
     *
     * @param analysis 【Analysis】
     * @return 【Analysis】
     */
    @Override
    public List<Analysis> selectAnalysisList(Analysis analysis) {
        return analysisMapper.selectAnalysisList(analysis);
    }

    /**
     * 新增【Analysis】
     *
     * @param analysis 【Analysis】
     * @return 结果
     */
    @Override
    public int insertAnalysis(Analysis analysis) {
        return analysisMapper.insertAnalysis(analysis);
    }

    /**
     * 修改【Analysis】
     *
     * @param analysis 【Analysis】
     * @return 结果
     */
    @Override
    public int updateAnalysis(Analysis analysis) {
        return analysisMapper.updateAnalysis(analysis);
    }

    /**
     * 批量删除【Analysis】
     *
     * @param analysisIds 需要删除的【Analysis】主键
     * @return 结果
     */
    @Override
    public int deleteAnalysisByAnalysisIds(Long[] analysisIds) {
        return analysisMapper.deleteAnalysisByAnalysisIds(analysisIds);
    }

    /**
     * 删除【Analysis】信息
     *
     * @param analysisId 【Analysis】主键
     * @return 结果
     */
    @Override
    public int deleteAnalysisByAnalysisId(Long analysisId) {
        return analysisMapper.deleteAnalysisByAnalysisId(analysisId);
    }

    //查询 Omica
    @Override
    public List<String> selectOmics() {
        return analysisMapper.selectOmics();
    }

    //查询 AnalysisID
    @Override
    public List<String> selectAnalysisID() {
        return analysisMapper.selectAnalysisID();
    }

    //查询 Analysis
    @Override
    public List<Analysis> selectAnalysis(String name, String omics, String description) {
        return analysisMapper.selectAnalysis(name, omics, description);
    }

    //通过Name查询Analysis 下载用
    @Override
    public Analysis selectAnalysisByName(String name) {
        return analysisMapper.selectAnalysisByName(name);
    }

    ;

}
