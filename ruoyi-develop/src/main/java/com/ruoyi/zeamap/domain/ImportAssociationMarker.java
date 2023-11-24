package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.persistence.Table;

/**
 * Import对象 association_marker
 * 
 * @author ruoyi
 * @date 2023-03-21
 */
@Table(name = "association_maker")
public class ImportAssociationMarker extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @Excel(name = "主键")
    private Long associationMarkerId;

    /** $column.columnComment */
    @Excel(name = "计算数值")
    private String log;

    /** $column.columnComment */
    @Excel(name = "数值")
    private String effectSize;

    /** $column.columnComment */
    @Excel(name = "数值")
    private String pip;

    /** $column.columnComment */
    @Excel(name = "dbxref主键")
    private Long dbxrefId;

    /** $column.columnComment */
    @Excel(name = "association_qtl主键")
    private Long qtlId;

    /** $column.columnComment */
    @Excel(name = "variant主键")
    private Long variantId;

    public void setAssociationMarkerId(Long associationMarkerId) 
    {
        this.associationMarkerId = associationMarkerId;
    }

    public Long getAssociationMarkerId() 
    {
        return associationMarkerId;
    }
    public void setLog(String log) 
    {
        this.log = log;
    }

    public String getLog() 
    {
        return log;
    }
    public void setEffectSize(String effectSize) 
    {
        this.effectSize = effectSize;
    }

    public String getEffectSize() 
    {
        return effectSize;
    }
    public void setPip(String pip) 
    {
        this.pip = pip;
    }

    public String getPip() 
    {
        return pip;
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
            .append("associationMarkerId", getAssociationMarkerId())
            .append("log", getLog())
            .append("effectSize", getEffectSize())
            .append("pip", getPip())
            .append("dbxrefId", getDbxrefId())
            .append("qtlId", getQtlId())
            .append("variantId", getVariantId())
            .toString();
    }
}
