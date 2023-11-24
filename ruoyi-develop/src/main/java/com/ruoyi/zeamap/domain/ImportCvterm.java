package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.persistence.Table;

/**
 * ImportCvterm对象 cvterm
 * 
 * @author ruoyi
 * @date 2023-03-30
 */
@Table(name = "cvterm")
public class ImportCvterm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "主键")
    private String cvtermId;

    /** $column.columnComment */
    @Excel(name = "名称")
    private String name;

    /** $column.columnComment */
    @Excel(name = "定义")
    private String definition;

    /** $column.columnComment */
    @Excel(name = "是否过时")
    private String isObsolete;

    /** $column.columnComment */
    @Excel(name = "是否是关系类型")
    private String isRelationshiptype;

    /** $column.columnComment */
    @Excel(name = "cv表主键")
    private String cvId;

    /** $column.columnComment */
    @Excel(name = "dbxref表主键")
    private String dbxrefId;

    public void setCvtermId(String cvtermId) 
    {
        this.cvtermId = cvtermId;
    }

    public String getCvtermId() 
    {
        return cvtermId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setDefinition(String definition) 
    {
        this.definition = definition;
    }

    public String getDefinition() 
    {
        return definition;
    }
    public void setIsObsolete(String isObsolete) 
    {
        this.isObsolete = isObsolete;
    }

    public String getIsObsolete() 
    {
        return isObsolete;
    }
    public void setIsRelationshiptype(String isRelationshiptype) 
    {
        this.isRelationshiptype = isRelationshiptype;
    }

    public String getIsRelationshiptype() 
    {
        return isRelationshiptype;
    }
    public void setCvId(String cvId) 
    {
        this.cvId = cvId;
    }

    public String getCvId() 
    {
        return cvId;
    }
    public void setDbxrefId(String dbxrefId) 
    {
        this.dbxrefId = dbxrefId;
    }

    public String getDbxrefId() 
    {
        return dbxrefId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cvtermId", getCvtermId())
            .append("name", getName())
            .append("definition", getDefinition())
            .append("isObsolete", getIsObsolete())
            .append("isRelationshiptype", getIsRelationshiptype())
            .append("cvId", getCvId())
            .append("dbxrefId", getDbxrefId())
            .toString();
    }
}
