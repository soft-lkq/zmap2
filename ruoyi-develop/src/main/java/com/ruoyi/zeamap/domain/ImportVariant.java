package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.persistence.Table;

/**
 * ImportVariant对象 variant
 * 
 * @author ruoyi
 * @date 2023-03-16
 */
@Table(name = "variant")
public class ImportVariant extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "主键")
    private String variantId;

    /** $column.columnComment */
    @Excel(name = "变异编号 ")
    private String vid;

    /** $column.columnComment */
    @Excel(name = "变异类型")
    private String type;

    /** $column.columnComment */
    @Excel(name = "变异染色体")
    private String chr;

    /** $column.columnComment */
    @Excel(name = "变异具体位置")
    private String posi;

    /** $column.columnComment */
    @Excel(name = "数值")
    private String genorate;

    /** $column.columnComment */
    @Excel(name = "变异基因型频率")
    private String maf;

    /** $column.columnComment */
    @Excel(name = "变异的注释类型")
    private String consequences;

    /** $column.columnComment */
    @Excel(name = "变异的影响程度")
    private String impacts;

    /** $column.columnComment */
    @Excel(name = "analysis主键")
    private String analysisId;

    public void setVariantId(String variantId) 
    {
        this.variantId = variantId;
    }

    public String getVariantId() 
    {
        return variantId;
    }
    public void setVid(String vid) 
    {
        this.vid = vid;
    }

    public String getVid() 
    {
        return vid;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setChr(String chr) 
    {
        this.chr = chr;
    }

    public String getChr() 
    {
        return chr;
    }
    public void setPosi(String posi) 
    {
        this.posi = posi;
    }

    public String getPosi() 
    {
        return posi;
    }
    public void setGenorate(String genorate) 
    {
        this.genorate = genorate;
    }

    public String getGenorate() 
    {
        return genorate;
    }
    public void setMaf(String maf) 
    {
        this.maf = maf;
    }

    public String getMaf() 
    {
        return maf;
    }
    public void setConsequences(String consequences) 
    {
        this.consequences = consequences;
    }

    public String getConsequences() 
    {
        return consequences;
    }
    public void setImpacts(String impacts) 
    {
        this.impacts = impacts;
    }

    public String getImpacts() 
    {
        return impacts;
    }
    public void setAnalysisId(String analysisId) 
    {
        this.analysisId = analysisId;
    }

    public String getAnalysisId() 
    {
        return analysisId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("variantId", getVariantId())
            .append("vid", getVid())
            .append("type", getType())
            .append("chr", getChr())
            .append("posi", getPosi())
            .append("genorate", getGenorate())
            .append("maf", getMaf())
            .append("consequences", getConsequences())
            .append("impacts", getImpacts())
            .append("analysisId", getAnalysisId())
            .toString();
    }
}
