package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品对象 population
 * 
 * @author ruoyi
 * @date 2023-03-14
 */
public class Population extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @Excel(name = "主键")
    private Long populationId;

    /** $column.columnComment */
    @Excel(name = "群体名称")
    private String name;

    /** $column.columnComment */
    @Excel(name = "群体描述")
    private String description;

    /** $column.columnComment */
    @Excel(name = "图片地址")
    private String image;

    /** $column.columnComment */
    @Excel(name = "群体别名")
    private String alias;

    public void setPopulationId(Long populationId) 
    {
        this.populationId = populationId;
    }

    public Long getPopulationId() 
    {
        return populationId;
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
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }
    public void setAlias(String alias) 
    {
        this.alias = alias;
    }

    public String getAlias() 
    {
        return alias;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("populationId", getPopulationId())
            .append("name", getName())
            .append("description", getDescription())
            .append("image", getImage())
            .append("alias", getAlias())
            .toString();
    }
}
