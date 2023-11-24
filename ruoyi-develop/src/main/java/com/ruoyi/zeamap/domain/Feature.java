package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 feature
 *
 * @author ruoyi
 * @date 2023-03-15
 */
public class Feature extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long featureId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String uniquename;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String residues;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String seqlen;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dbxrefId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long typeId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String commonname;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String status;

    public void setFeatureId(Long featureId)
    {
        this.featureId = featureId;
    }

    public Long getFeatureId()
    {
        return featureId;
    }
    public void setUniquename(String uniquename)
    {
        this.uniquename = uniquename;
    }

    public String getUniquename()
    {
        return uniquename;
    }
    public void setResidues(String residues)
    {
        this.residues = residues;
    }

    public String getResidues()
    {
        return residues;
    }
    public void setSeqlen(String seqlen)
    {
        this.seqlen = seqlen;
    }

    public String getSeqlen()
    {
        return seqlen;
    }
    public void setDbxrefId(Long dbxrefId)
    {
        this.dbxrefId = dbxrefId;
    }

    public Long getDbxrefId()
    {
        return dbxrefId;
    }
    public void setTypeId(Long typeId)
    {
        this.typeId = typeId;
    }

    public Long getTypeId()
    {
        return typeId;
    }
    public void setCommonname(String commonname)
    {
        this.commonname = commonname;
    }

    public String getCommonname()
    {
        return commonname;
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
            .append("featureId", getFeatureId())
            .append("uniquename", getUniquename())
            .append("residues", getResidues())
            .append("seqlen", getSeqlen())
            .append("dbxrefId", getDbxrefId())
            .append("typeId", getTypeId())
            .append("commonname", getCommonname())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
