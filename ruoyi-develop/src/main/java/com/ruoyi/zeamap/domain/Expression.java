package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 基因表达量查询对象 expression
 *
 * @author ruoyi
 * @date 2022-11-19
 */
public class Expression extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long expressionId;

    public Tissue getTissue() {
        return tissue;
    }

    public void setTissue(Tissue tissue) {
        this.tissue = tissue;
    }

    /** 组织高亮值 */
    @Excel(name = "组织高亮值")
    private Double expressionValue;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String expressionUnit;

    /** 与dbxref的version关联 */
    @Excel(name = "与dbxref的version关联")
    private Long analysisId;

    private Analysis analysis;

    /** 环境表的id */
    @Excel(name = "环境表的id")
    private Long environmentId;

    private Environment environment;


    /** 基因ID feature 表的uniquename */
    @Excel(name = "基因ID feature 表的uniquename")
    private Long featureId;

    private Feature feature;

    /** Gene IDs 多个（未有数据先不做） */
    @Excel(name = "Gene IDs 多个", readConverterExp = "未=有数据先不做")
    private Long germplasmId;

    private Germplasm germplasm;

    /** 组织表的id  */
    @Excel(name = "组织表的id ")
    private Long tissueId;

    /**对应的组织*/
    private Tissue tissue;


    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;


    public Analysis getAnalysis() {
        return analysis;
    }

    public void setAnalysis(Analysis analysis) {
        this.analysis = analysis;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public Germplasm getGermplasm() {
        return germplasm;
    }

    public void setGermplasm(Germplasm germplasm) {
        this.germplasm = germplasm;
    }

    public void setExpressionId(Long expressionId)
    {
        this.expressionId = expressionId;
    }

    public Long getExpressionId()
    {
        return expressionId;
    }
    public void setExpressionValue(Double expressionValue)
    {
        this.expressionValue = expressionValue;
    }

    public Double getExpressionValue()
    {
        return expressionValue;
    }
    public void setExpressionUnit(String expressionUnit)
    {
        this.expressionUnit = expressionUnit;
    }

    public String getExpressionUnit()
    {
        return expressionUnit;
    }
    public void setAnalysisId(Long analysisId)
    {
        this.analysisId = analysisId;
    }

    public Long getAnalysisId()
    {
        return analysisId;
    }
    public void setEnvironmentId(Long environmentId)
    {
        this.environmentId = environmentId;
    }

    public Long getEnvironmentId()
    {
        return environmentId;
    }
    public void setFeatureId(Long featureId)
    {
        this.featureId = featureId;
    }

    public Long getFeatureId()
    {
        return featureId;
    }
    public void setGermplasmId(Long germplasmId)
    {
        this.germplasmId = germplasmId;
    }

    public Long getGermplasmId()
    {
        return germplasmId;
    }
    public void setTissueId(Long tissueId)
    {
        this.tissueId = tissueId;
    }

    public Long getTissueId()
    {
        return tissueId;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("expressionId", getExpressionId())
                .append("expressionValue", getExpressionValue())
                .append("expressionUnit", getExpressionUnit())
                .append("analysisId", getAnalysisId())
                .append("environmentId", getEnvironmentId())
                .append("featureId", getFeatureId())
                .append("germplasmId", getGermplasmId())
                .append("tissueId", getTissueId())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("analysis", getAnalysis())
                .append("environment", getEnvironment())
                .append("feature", getFeature())
                .append("germplasm", getGermplasm())
                .append("tissue", getTissue())
                .toString();
    }
}
