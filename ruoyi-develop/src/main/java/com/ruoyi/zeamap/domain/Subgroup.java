package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 subgroup
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
public class Subgroup extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long subgroupId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String description;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long populationId;

    public void setSubgroupId(Long subgroupId) 
    {
        this.subgroupId = subgroupId;
    }

    public Long getSubgroupId() 
    {
        return subgroupId;
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
    public void setPopulationId(Long populationId) 
    {
        this.populationId = populationId;
    }

    public Long getPopulationId() 
    {
        return populationId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("subgroupId", getSubgroupId())
            .append("name", getName())
            .append("description", getDescription())
            .append("populationId", getPopulationId())
            .toString();
    }
}
