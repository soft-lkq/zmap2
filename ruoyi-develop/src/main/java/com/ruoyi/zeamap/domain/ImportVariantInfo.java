package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.persistence.Table;

/**
 * ImportInfo对象 variant_info
 * 
 * @author ruoyi
 * @date 2023-03-18
 */
@Table(name = "variant_info")
public class ImportVariantInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @Excel(name = "主键")
    private String variantinfoId;

    /** $column.columnComment */
    @Excel(name = "标识编号")
    private String vid;

    /** $column.columnComment */
    @Excel(name = "注释")
    private String annotation;

    /** $column.columnComment */
    @Excel(name = "信息")
    private String information;

    /** $column.columnComment */
    @Excel(name = " ")
    private String pieplots;

    /** $column.columnComment */
    @Excel(name = "总结")
    private String summary;

    public void setVariantinfoId(String variantinfoId) 
    {
        this.variantinfoId = variantinfoId;
    }

    public String getVariantinfoId() 
    {
        return variantinfoId;
    }
    public void setVid(String vid) 
    {
        this.vid = vid;
    }

    public String getVid() 
    {
        return vid;
    }
    public void setAnnotation(String annotation) 
    {
        this.annotation = annotation;
    }

    public String getAnnotation() 
    {
        return annotation;
    }
    public void setInformation(String information) 
    {
        this.information = information;
    }

    public String getInformation() 
    {
        return information;
    }
    public void setPieplots(String pieplots) 
    {
        this.pieplots = pieplots;
    }

    public String getPieplots() 
    {
        return pieplots;
    }
    public void setSummary(String summary) 
    {
        this.summary = summary;
    }

    public String getSummary() 
    {
        return summary;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("variantinfoId", getVariantinfoId())
            .append("vid", getVid())
            .append("annotation", getAnnotation())
            .append("information", getInformation())
            .append("pieplots", getPieplots())
            .append("summary", getSummary())
            .toString();
    }
}
