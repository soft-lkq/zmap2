package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.persistence.Table;

/**
 * ImportMutable对象 mutable
 * 
 * @author ruoyi
 * @date 2023-03-15
 */
@Table(name = "mutable")
public class ImportMutable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @Excel(name = "主键")
    private Long mutableId;

    /** $column.columnComment */
    @Excel(name = "分类")
    private String mutableClass;

    /** $column.columnComment */
    @Excel(name = "条件")
    private String mutableCondition;

    /** $column.columnComment */
    @Excel(name = "描述")
    private String mutableDesc;

    public void setMutableId(Long mutableId) 
    {
        this.mutableId = mutableId;
    }

    public Long getMutableId() 
    {
        return mutableId;
    }
    public void setMutableClass(String mutableClass) 
    {
        this.mutableClass = mutableClass;
    }

    public String getMutableClass() 
    {
        return mutableClass;
    }
    public void setMutableCondition(String mutableCondition) 
    {
        this.mutableCondition = mutableCondition;
    }

    public String getMutableCondition() 
    {
        return mutableCondition;
    }
    public void setMutableDesc(String mutableDesc) 
    {
        this.mutableDesc = mutableDesc;
    }

    public String getMutableDesc() 
    {
        return mutableDesc;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mutableId", getMutableId())
            .append("mutableClass", getMutableClass())
            .append("mutableCondition", getMutableCondition())
            .append("mutableDesc", getMutableDesc())
            .toString();
    }
}
