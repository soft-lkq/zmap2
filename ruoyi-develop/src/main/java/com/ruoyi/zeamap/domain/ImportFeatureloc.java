package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.persistence.Table;

/**
 * ImportFeatureloc对象 featureloc
 * 
 * @author ruoyi
 * @date 2023-03-30
 */
@Table(name = "featureloc")
public class ImportFeatureloc extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "主键")
    private String featurelocId;

    /** $column.columnComment */
    @Excel(name = "最小位置")
    private String fmin;

    /** $column.columnComment */
    @Excel(name = "最大位置")
    private String fmax;

    /** $column.columnComment */
    @Excel(name = "+/-链")
    private String strand;

    /** $column.columnComment */
    @Excel(name = "feature主键")
    private String featureId;

    /** $column.columnComment */
    @Excel(name = "featureId")
    private String srcfeatureId;

    public void setFeaturelocId(String featurelocId) 
    {
        this.featurelocId = featurelocId;
    }

    public String getFeaturelocId() 
    {
        return featurelocId;
    }
    public void setFmin(String fmin) 
    {
        this.fmin = fmin;
    }

    public String getFmin() 
    {
        return fmin;
    }
    public void setFmax(String fmax) 
    {
        this.fmax = fmax;
    }

    public String getFmax() 
    {
        return fmax;
    }
    public void setStrand(String strand) 
    {
        this.strand = strand;
    }

    public String getStrand() 
    {
        return strand;
    }
    public void setFeatureId(String featureId) 
    {
        this.featureId = featureId;
    }

    public String getFeatureId() 
    {
        return featureId;
    }
    public void setSrcfeatureId(String srcfeatureId) 
    {
        this.srcfeatureId = srcfeatureId;
    }

    public String getSrcfeatureId() 
    {
        return srcfeatureId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("featurelocId", getFeaturelocId())
            .append("fmin", getFmin())
            .append("fmax", getFmax())
            .append("strand", getStrand())
            .append("featureId", getFeatureId())
            .append("srcfeatureId", getSrcfeatureId())
            .toString();
    }
}
