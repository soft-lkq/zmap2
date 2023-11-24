package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.persistence.Table;

/**
 * 基因表达量查询对象 expression
 * 
 * @author ruoyi
 * @date 2023-03-22
 */
@Table(name = "expression")
public class ImportExpression extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @Excel(name = "主键")
    private Long expressionId;

    /** 组织高亮值 */
    @Excel(name = "表达量值")
    private String expressionValue;

    /** $column.columnComment */
    @Excel(name = "单位")
    private String expressionUnit;

    /** 与dbxref的version关联 */
    @Excel(name = "analysis主键")
    private Long analysisId;

    /** 环境表的id */
    @Excel(name = "environment主键")
    private Long environmentId;

    /** 基因ID feature 表的uniquename */
    @Excel(name = "feature主键")
    private Long featureId;

    /** Gene IDs 多个（未有数据先不做） */
    @Excel(name = "germplasm主键")
    private Long germplasmId;

    /** 组织表的id  */
    @Excel(name = "tissue主键")
    private Long tissueId;

    /** 状态（0正常 1停用） */
    private String status;

    public void setExpressionId(Long expressionId) 
    {
        this.expressionId = expressionId;
    }

    public Long getExpressionId() 
    {
        return expressionId;
    }
    public void setExpressionValue(String expressionValue) 
    {
        this.expressionValue = expressionValue;
    }

    public String getExpressionValue() 
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
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
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
            .toString();
    }
}
