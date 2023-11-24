package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import javax.persistence.Table;

/**
 * ImportAqtl对象 association_qtl
 * 
 * @author ruoyi
 * @date 2023-03-18
 */
@Table(name = "association_qtl")
public class ImportAssociationQtl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @Excel(name = "主键")
    private Long associationQtlId;

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
    @Excel(name = "QTL标识名")
    private Long qtlUid;

    /** $column.columnComment */
    @Excel(name = "数值")
    private String log;

    /** $column.columnComment */
    @Excel(name = "dbxref表主键")
    private Long dbxrefId;

    /** $column.columnComment */
    @Excel(name = "性状id，值为xot表中xot_uid")
    private Long traitId;

    public void setAssociationQtlId(Long associationQtlId) 
    {
        this.associationQtlId = associationQtlId;
    }

    public Long getAssociationQtlId() 
    {
        return associationQtlId;
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
    public void setLog(String log) 
    {
        this.log = log;
    }

    public String getLog() 
    {
        return log;
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
            .append("associationQtlId", getAssociationQtlId())
            .append("chr", getChr())
            .append("start", getStart())
            .append("end", getEnd())
            .append("qtlUid", getQtlUid())
            .append("log", getLog())
            .append("dbxrefId", getDbxrefId())
            .append("traitId", getTraitId())
            .toString();
    }
}
