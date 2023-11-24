package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.persistence.Table;

/**
 * ImportLqtl对象 linkage_qtl
 * 
 * @author ruoyi
 * @date 2023-03-20
 */
@Table(name = "linkage_qtl")
public class ImportLinkageQtl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @Excel(name = "主键")
    private Long linkageQtlId;

    /** $column.columnComment */
    @Excel(name = "染色体")
    private String chr;

    /** $column.columnComment */
    @Excel(name = "开始位置")
    private Long start;

    /** $column.columnComment */
    @Excel(name = "结束位置")
    private Long end;

    /** $column.columnComment */
    @Excel(name = "QTL标识名称")
    private Long qtlUid;

    /** $column.columnComment */
    @Excel(name = "QTL_MAP编号")
    private String linkagemap;

    /** $column.columnComment */
    @Excel(name = "lod")
    private String lod;

    /** $column.columnComment */
    @Excel(name = "dbxref表主键")
    private Long dbxrefId;

    /** $column.columnComment */
    @Excel(name = "性状id，值为xot中的xot_uid")
    private Long traitId;

    public void setLinkageQtlId(Long linkageQtlId) 
    {
        this.linkageQtlId = linkageQtlId;
    }

    public Long getLinkageQtlId() 
    {
        return linkageQtlId;
    }
    public void setChr(String chr) 
    {
        this.chr = chr;
    }

    public String getChr() 
    {
        return chr;
    }
    public void setStart(Long start) 
    {
        this.start = start;
    }

    public Long getStart() 
    {
        return start;
    }
    public void setEnd(Long end) 
    {
        this.end = end;
    }

    public Long getEnd() 
    {
        return end;
    }
    public void setQtlUid(Long qtlUid) 
    {
        this.qtlUid = qtlUid;
    }

    public Long getQtlUid() 
    {
        return qtlUid;
    }
    public void setLinkagemap(String linkagemap) 
    {
        this.linkagemap = linkagemap;
    }

    public String getLinkagemap() 
    {
        return linkagemap;
    }
    public void setLod(String lod) 
    {
        this.lod = lod;
    }

    public String getLod() 
    {
        return lod;
    }
    public void setDbxrefId(Long dbxrefId) 
    {
        this.dbxrefId = dbxrefId;
    }

    public Long getDbxrefId() 
    {
        return dbxrefId;
    }
    public void setTraitId(Long traitId) 
    {
        this.traitId = traitId;
    }

    public Long getTraitId() 
    {
        return traitId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("linkageQtlId", getLinkageQtlId())
            .append("chr", getChr())
            .append("start", getStart())
            .append("end", getEnd())
            .append("qtlUid", getQtlUid())
            .append("linkagemap", getLinkagemap())
            .append("lod", getLod())
            .append("dbxrefId", getDbxrefId())
            .append("traitId", getTraitId())
            .toString();
    }
}
