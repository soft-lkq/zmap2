package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.persistence.Table;

/**
 * importdb对象 db
 * 
 * @author ruoyi
 * @date 2023-05-26
 */
@Table(name = "db")
public class ImportDb extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long dbId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String description;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String urlprefix;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String url;

    public void setDbId(Long dbId) 
    {
        this.dbId = dbId;
    }

    public Long getDbId() 
    {
        return dbId;
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
    public void setUrlprefix(String urlprefix) 
    {
        this.urlprefix = urlprefix;
    }

    public String getUrlprefix() 
    {
        return urlprefix;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dbId", getDbId())
            .append("name", getName())
            .append("description", getDescription())
            .append("urlprefix", getUrlprefix())
            .append("url", getUrl())
            .toString();
    }
}
