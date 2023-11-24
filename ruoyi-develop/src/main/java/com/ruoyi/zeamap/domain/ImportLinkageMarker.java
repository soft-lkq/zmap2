package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.persistence.Table;

/**
 * Import对象 linkage_marker
 * 
 * @author ruoyi
 * @date 2023-03-21
 */
@Table(name = "linkage_marker")
public class ImportLinkageMarker extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @Excel(name = "主键")
    private Long linkageMarkerId;

    /** $column.columnComment */
    @Excel(name = "分组")
    private String linkageGroup;

    /** $column.columnComment */
    @Excel(name = "数值")
    private String linkageCm;

    /** $column.columnComment */
    @Excel(name = "dbxref主键")
    private Long dbxrefId;

    /** $column.columnComment */
    @Excel(name = "association_qtl主键")
    private Long qtlId;

    /** $column.columnComment */
    @Excel(name = "variant主键")
    private Long variantId;

    public void setLinkageMarkerId(Long linkageMarkerId) 
    {
        this.linkageMarkerId = linkageMarkerId;
    }

    public Long getLinkageMarkerId() 
    {
        return linkageMarkerId;
    }
    public void setLinkageGroup(String linkageGroup) 
    {
        this.linkageGroup = linkageGroup;
    }

    public String getLinkageGroup() 
    {
        return linkageGroup;
    }
    public void setLinkageCm(String linkageCm) 
    {
        this.linkageCm = linkageCm;
    }

    public String getLinkageCm() 
    {
        return linkageCm;
    }
    public void setDbxrefId(Long dbxrefId) 
    {
        this.dbxrefId = dbxrefId;
    }

    public Long getDbxrefId() 
    {
        return dbxrefId;
    }
    public void setQtlId(Long qtlId) 
    {
        this.qtlId = qtlId;
    }

    public Long getQtlId() 
    {
        return qtlId;
    }
    public void setVariantId(Long variantId) 
    {
        this.variantId = variantId;
    }

    public Long getVariantId() 
    {
        return variantId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("linkageMarkerId", getLinkageMarkerId())
            .append("linkageGroup", getLinkageGroup())
            .append("linkageCm", getLinkageCm())
            .append("dbxrefId", getDbxrefId())
            .append("qtlId", getQtlId())
            .append("variantId", getVariantId())
            .toString();
    }
}
