package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.persistence.Table;

/**
 * ImportCv对象 cv
 * 
 * @author ruoyi
 * @date 2023-03-30
 */
@Table(name = "cv")
public class ImportCv extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "主键")
    private String cvId;

    /** $column.columnComment */
    @Excel(name = "本体名称")
    private String name;

    /** $column.columnComment */
    @Excel(name = "定义")
    private String definition;

    public void setCvId(String cvId) 
    {
        this.cvId = cvId;
    }

    public String getCvId() 
    {
        return cvId;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cvId", getCvId())
            .append("name", getName())
            .append("definition", getDefinition())
            .toString();
    }
}
