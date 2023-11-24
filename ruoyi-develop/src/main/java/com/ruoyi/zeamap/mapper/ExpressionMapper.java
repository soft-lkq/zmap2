package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.Expression;
import com.ruoyi.zeamap.vo.ExpressionVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

/**
 * 基因表达量查询Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-19
 */
public interface ExpressionMapper 
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
     * 删除基因表达量查询
     * 
     * @param expressionId 基因表达量查询主键
     * @return 结果
     */
    public int deleteExpressionByExpressionId(Long expressionId);

    /**
     * 批量删除基因表达量查询
     * 
     * @param expressionIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteExpressionByExpressionIds(Long[] expressionIds);

    public List<Expression> selectMapExpression(Long featureId);

    public List<Expression> selectmultiExpressionListTissue(ExpressionVo expressionVo);
    public List<Expression> selectmultiExpressionListGermplasm(ExpressionVo expressionVo);
    public List<Expression> selectmultiExpressionListEnvironment(ExpressionVo expressionVo);


    public List<String> selectExpressionReference();


    public List<String> selectAnalysis();

    public List<String> selectExpressionGermplasm();

    public List<String> selectExpressionEnvironment();

    public List<String> selectExpressionTissue();

    public List<String> selectExpressionPopulation();

    public List<String> selectExpressionSubgroup();

    public List<Long> selectGeneId(@Param("reference") String reference,@Param("version") String version);

    public List<Long> selectrealId(Long dbxref_id);

    List<String> selectExpressionVersion(String reference);

    public List<Expression> selectAllFromTissue(@Param("dbxref_id") Long dbxref_id, @Param("analysis_id") Long analysis_id, @Param("environment_id") Long environment_id,@Param("germplasm_id")Long germplasm_id,@Param("geneId") Long[] geneId, @Param("selects")Long[] tissue_id);

    public List<Expression> selectAllFromGermplasm(@Param("dbxref_id") Long dbxref_id, @Param("analysis_id") Long analysis_id, @Param("environment_id") Long environment_id,@Param("tissue_id") Long tissue_id,@Param("germplasmIds")Long[] germplasm_id,@Param("geneId") Long[] geneId);

    public List<Expression> selectAllFromEnvironment(@Param("dbxref_id") Long dbxref_id, @Param("analysis_id") Long analysis_id,@Param("tissue_id") Long tissue_id,@Param("germplasm_id")Long germplasm_id,@Param("environmentIds") Long[] environment_id,@Param("geneId") Long[] geneId);

    public Long selectDbxrefId(@Param("reference") String reference,@Param("version") String version,@Param("db_id")Long db_id);

    public Long selectAnalysisId(String description);

    public Long selectEnvironmentId(String condition);

    public Long selectGermplasmId(String name);

    public Long[] selectTissueIdByDesc(@Param("selects") String[] selects);

    public Long[] selectFeatureIdByPopulation(Long population_id);

    public Long[] selectGermplasmIds(@Param("names") String[] names);

    public Long selectTissueIdByPosition(String position);

    public Long selectPopulationId(String alias);

    public Long[] selectEnvironmentIds(@Param("desc") String[] desc);

    public Long[] selectFeatureIdsByGene(@Param("geneIds")String[] geneIds);

    public Long selectDbid(String accession);


}
