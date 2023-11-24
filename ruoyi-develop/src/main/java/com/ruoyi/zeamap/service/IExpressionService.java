package com.ruoyi.zeamap.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.zeamap.domain.Expression;
import com.ruoyi.zeamap.vo.ExpressionVo;
import org.apache.ibatis.annotations.Param;

/**
 * 基因表达量查询Service接口
 * 
 * @author ruoyi
 * @date 2022-11-19
 */
public interface IExpressionService 
{
    /**
     * 查询基因表达量查询
     * 
     * @param expressionId 基因表达量查询主键
     * @return 基因表达量查询
     */
    public Expression selectExpressionByExpressionId(Long expressionId);

    /**
     * 查询基因表达量查询列表
     * 
     * @param expression 基因表达量查询
     * @return 基因表达量查询集合
     */
    public List<Expression> selectExpressionList(Expression expression);

    /**
     * 新增基因表达量查询
     * 
     * @param expression 基因表达量查询
     * @return 结果
     */
    public int insertExpression(Expression expression);

    /**
     * 修改基因表达量查询
     * 
     * @param expression 基因表达量查询
     * @return 结果
     */
    public int updateExpression(Expression expression);

    /**
     * 批量删除基因表达量查询
     * 
     * @param expressionIds 需要删除的基因表达量查询主键集合
     * @return 结果
     */
    public int deleteExpressionByExpressionIds(Long[] expressionIds);

    /**
     * 删除基因表达量查询信息
     * 
     * @param expressionId 基因表达量查询主键
     * @return 结果
     */
    public int deleteExpressionByExpressionId(Long expressionId);

    List<Expression> selectmultiExpressionList(ExpressionVo expressionVo);

    Map<String, List<String>> selectDownMenuAllData();

    List<String> findAllReference();

    List<String> findAllVersion(String reference);

    List<Long> selectGeneId(String reference,String version);

    public Long selectDbxrefId(@Param("reference") String reference, @Param("version") String version,@Param("db_id")Long db_id);

    public Long selectAnalysisId(String description);

    public Long selectEnvironmentId(String condition);

    public Long selectGermplasmId(String name);

    public Long[] selectTissueIdByDesc(@Param("selects") String[] selects);

    public List<Expression> selectAllFromTissue(@Param("dbxref_id") Long dbxref_id, @Param("analysis_id") Long analysis_id, @Param("environment_id") Long environment_id,@Param("germplasm_id")Long germplasm_id, @Param("geneId") Long[] geneId, @Param("tissue_id")Long[] tissue_id);

    public List<Expression> selectAllFromGermplasm(@Param("dbxref_id") Long dbxref_id, @Param("analysis_id") Long analysis_id, @Param("environment_id") Long environment_id,@Param("tissue_id")Long tissue_id,@Param("germplasmIds")Long[] germplasm_id, @Param("geneId") Long[] geneId);

    public List<Expression> selectAllFromEnvironment(@Param("dbxref_id") Long dbxref_id, @Param("analysis_id") Long analysis_id,@Param("tissue_id") Long tissue_id,@Param("germplasm_id")Long germplasm_id,@Param("environmentIds") Long[] environment_id,@Param("geneId") Long[] geneId);

    public Long[] selectFeatureIdByPopulation(Long population_id);

    public Long selectTissueIdByPosition(String position);

    public Long selectPopulationId(String alias);

    public Long[] selectGermplasmIds(@Param("names") String[] names);

    public Long[] selectEnvironmentIds(String[] desc);

    public Long[] selectGeneId(Long[] g1,Long[] g2);

    public Long[] selectFeatureIdsByGene(@Param("geneIds")String[] geneIds);

    public Long selectDbid(String accession);

}
