package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * db对象 db
 * 
 * @author ruoyi
 * @date 2023-04-10
 */
public class Db extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "主键")
    private Long dbId;

    /** $column.columnComment */
    @Excel(name = "数据来源")
    private String name;

    /** $column.columnComment */
    @Excel(name = "描述信息")
    private String description;

    /** $column.columnComment */
    @Excel(name = "url前缀")
    private String urlprefix;

    /** $column.columnComment */
    @Excel(name = "网址")
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
        return "Db{" +
                "dbId=" + dbId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", urlprefix='" + urlprefix + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
