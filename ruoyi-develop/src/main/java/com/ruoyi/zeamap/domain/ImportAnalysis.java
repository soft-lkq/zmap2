package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.persistence.Table;

/**
 * ImportAnalysis对象 analysis
 * 
 * @author ruoyi
 * @date 2023-03-15
 */
@Table(name = "analysis")
public class ImportAnalysis extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @Excel(name = "主键")
    private Long analysisId;

    /** $column.columnComment */
    @Excel(name = "基因名称")
    private String name;

    /** $column.columnComment */
    @Excel(name = "描述")
    private String description;

    /** $column.columnComment */
    @Excel(name = "dbxref表主键")
    private Long dbxrefId;

    /** $column.columnComment */
    @Excel(name = "population表主键")
    private Long populationId;

    /** $column.columnComment */
    @Excel(name = "详情")
    private String detailed;

    /** $column.columnComment */
    @Excel(name = "方法")
    private String methods;

    /** $column.columnComment */
    @Excel(name = "组学")
    private String omics;

    /** $column.columnComment */
    @Excel(name = "参考")
    private String reference;

    public void setAnalysisId(Long analysisId) 
    {
        this.analysisId = analysisId;
    }

    public Long getAnalysisId() 
    {
        return analysisId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setDbxrefId(Long dbxrefId) 
    {
        this.dbxrefId = dbxrefId;
    }

    public Long getDbxrefId() 
    {
        return dbxrefId;
    }
    public void setPopulationId(Long populationId) 
    {
        this.populationId = populationId;
    }

    public Long getPopulationId() 
    {
        return populationId;
    }
    public void setDetailed(String detailed) 
    {
        this.detailed = detailed;
    }

    public String getDetailed() 
    {
        return detailed;
    }
    public void setMethods(String methods) 
    {
        this.methods = methods;
    }

    public String getMethods() 
    {
        return methods;
    }
    public void setOmics(String omics) 
    {
        this.omics = omics;
    }

    public String getOmics() 
    {
        return omics;
    }
    public void setReference(String reference) 
    {
        this.reference = reference;
    }

    public String getReference() 
    {
        return reference;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("analysisId", getAnalysisId())
            .append("name", getName())
            .append("description", getDescription())
            .append("dbxrefId", getDbxrefId())
            .append("populationId", getPopulationId())
            .append("detailed", getDetailed())
            .append("methods", getMethods())
            .append("omics", getOmics())
            .append("reference", getReference())
            .toString();
    }
}
