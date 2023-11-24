package com.ruoyi.zeamap.service.impl;

import java.util.*;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.zeamap.vo.ExpressionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.ExpressionMapper;
import com.ruoyi.zeamap.domain.Expression;
import com.ruoyi.zeamap.service.IExpressionService;

/**
 * 基因表达量查询Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-19
 */
@Service
public class ExpressionServiceImpl implements IExpressionService 
{
    @Autowired
    private ExpressionMapper expressionMapper;


    /**
     * 查询基因表达量查询
     * 
     * @param expressionId 基因表达量查询主键
     * @return 基因表达量查询
     */
    @Override
    public Expression selectExpressionByExpressionId(Long expressionId)
    {
        return expressionMapper.selectExpressionByExpressionId(expressionId);
    }

    /**
     * 查询基因表达量查询列表
     * 
     * @param expression 基因表达量查询
     * @return 基因表达量查询
     */
    @Override
    public List<Expression> selectExpressionList(Expression expression)
    {
        return expressionMapper.selectExpressionList(expression);
    }

    /**
     * 新增基因表达量查询
     * 
     * @param expression 基因表达量查询
     * @return 结果
     */
    @Override
    public int insertExpression(Expression expression)
    {
        expression.setCreateTime(DateUtils.getNowDate());
        return expressionMapper.insertExpression(expression);
    }

    /**
     * 修改基因表达量查询
     * 
     * @param expression 基因表达量查询
     * @return 结果
     */
    @Override
    public int updateExpression(Expression expression)
    {
        expression.setUpdateTime(DateUtils.getNowDate());
        return expressionMapper.updateExpression(expression);
    }

    /**
     * 批量删除基因表达量查询
     * 
     * @param expressionIds 需要删除的基因表达量查询主键
     * @return 结果
     */
    @Override
    public int deleteExpressionByExpressionIds(Long[] expressionIds)
    {
        return expressionMapper.deleteExpressionByExpressionIds(expressionIds);
    }

    /**
     * 删除基因表达量查询信息
     * 
     * @param expressionId 基因表达量查询主键
     * @return 结果
     */
    @Override
    public int deleteExpressionByExpressionId(Long expressionId)
    {
        return expressionMapper.deleteExpressionByExpressionId(expressionId);
    }
    @Override
    public List<Expression> selectmultiExpressionList(ExpressionVo expressionVo) {
        List<Expression> expressions = null;
        if(expressionVo.getFlag() == 1){
           expressions = expressionMapper.selectmultiExpressionListTissue(expressionVo);

        } else if (expressionVo.getFlag() == 2) {
           expressions = expressionMapper.selectmultiExpressionListGermplasm(expressionVo);

        }else{
            expressions = expressionMapper.selectmultiExpressionListEnvironment(expressionVo);
        }
        return expressions;
    }

    @Override
    public Map<String, List<String>> selectDownMenuAllData() {


        List<String> Analysis = expressionMapper.selectAnalysis();
        List<String> Germplasm = expressionMapper.selectExpressionGermplasm();
        List<String> Environment = expressionMapper.selectExpressionEnvironment();
        List<String> Tissue = expressionMapper.selectExpressionTissue();
        List<String> Population = expressionMapper.selectExpressionPopulation();
        List<String> Subgroup = expressionMapper.selectExpressionSubgroup();

        Map<String, List<String>> res = new HashMap<>();
        res.put("Analysis", Analysis);
        res.put("Germplasm", Germplasm);
        res.put("Environment", Environment);
        res.put("Tissue", Tissue);
        res.put("Population", Population);
        res.put("Subgroup", Subgroup);
        return res;
    }

    @Override
    public List<String> findAllReference() {
        List<String> references = expressionMapper.selectExpressionReference();
        return references;
    }

    @Override
    public List<String> findAllVersion(String reference) {
        List<String> versions = expressionMapper.selectExpressionVersion(reference);
        return versions;
    }

    @Override
    public List<Long> selectGeneId(String reference, String version) {
        List<Long> dbxref_ids = expressionMapper.selectGeneId(reference,version);
        List<Long> genesId = new ArrayList<Long>();
        for (Long dbxref_id: dbxref_ids) {
            List<Long> ds=expressionMapper.selectrealId(dbxref_id);
            genesId.addAll(ds);
        }
        return genesId;
    }

    @Override
    public Long selectDbxrefId(String reference, String version,Long db_id) {
        return expressionMapper.selectDbxrefId(reference,version,db_id);
    }

    @Override
    public Long selectAnalysisId(String description) {
        return expressionMapper.selectAnalysisId(description);
    }

    @Override
    public Long selectEnvironmentId(String condition) {
        return expressionMapper.selectEnvironmentId(condition);
    }

    @Override
    public Long selectGermplasmId(String name) {
        return expressionMapper.selectGermplasmId(name);
    }

    @Override
    public Long[] selectTissueIdByDesc(String[] selects) {
        return expressionMapper.selectTissueIdByDesc(selects);
    }

    @Override
    public List<Expression> selectAllFromTissue(Long dbxref_id, Long analysis_id, Long environment_id,Long germplasm_id, Long[] geneId, Long[] tissue_id) {
        return expressionMapper.selectAllFromTissue(dbxref_id,analysis_id,environment_id,germplasm_id,geneId,tissue_id);
    }

    @Override
    public List<Expression> selectAllFromGermplasm(Long dbxref_id, Long analysis_id, Long environment_id,Long tissue_id, Long[] germplasm_id, Long[] geneId) {
        return expressionMapper.selectAllFromGermplasm(dbxref_id,analysis_id,environment_id,tissue_id,germplasm_id,geneId);
    }

    @Override
    public List<Expression> selectAllFromEnvironment(Long dbxref_id, Long analysis_id, Long tissue_id, Long germplasm_id, Long[] environment_id, Long[] geneId) {
        return expressionMapper.selectAllFromEnvironment(dbxref_id,analysis_id,tissue_id,germplasm_id,environment_id,geneId);
    }

    @Override
    public Long[] selectFeatureIdByPopulation(Long population_id) {
        return expressionMapper.selectFeatureIdByPopulation(population_id);
    }

    @Override
    public Long selectTissueIdByPosition(String position) {
        return expressionMapper.selectTissueIdByPosition(position);
    }

    @Override
    public Long selectPopulationId(String alias) {
        return expressionMapper.selectPopulationId(alias);
    }

    @Override
    public Long[] selectGermplasmIds(String[] names) {
        return expressionMapper.selectGermplasmIds(names);
    }

    @Override
    public Long[] selectEnvironmentIds(String[] desc) {
        return expressionMapper.selectEnvironmentIds(desc);
    }

    @Override
    public Long[] selectGeneId(Long[] g1, Long[] g2) {
        Long[] geneid = new Long[50];
        int temp=0;
        for (Long value : g1) {
            for (Long aLong : g2) {
                if (Objects.equals(value, aLong)) {
                    geneid[temp] = aLong;
                    temp++;
                }
            }
        }
        return geneid;
    }

    @Override
    public Long[] selectFeatureIdsByGene(String[] geneIds) {
        return expressionMapper.selectFeatureIdsByGene(geneIds);
    }

    @Override
    public Long selectDbid(String accession) {
        return expressionMapper.selectDbid(accession);
    }

}
