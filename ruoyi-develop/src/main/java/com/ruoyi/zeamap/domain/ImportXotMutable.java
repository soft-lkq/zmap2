package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.persistence.Table;

/**
 * ImportXot_mutable对象 xot_mutable
 * 
 * @author ruoyi
 * @date 2023-03-15
 */
@Table(name = "xot_mutable")
public class ImportXotMutable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "主键")
    private Long xotMutableId;

    /** $column.columnComment */
    @Excel(name = "mutable主键")
    private Long mutableId;

    /** $column.columnComment */
    @Excel(name = "xot主键")
    private Long xotId;

    public void setXotMutableId(Long xotMutableId) 
    {
        this.xotMutableId = xotMutableId;
    }

    public Long getXotMutableId() 
    {
        return xotMutableId;
    }
    public void setMutableId(Long mutableId) 
    {
        this.mutableId = mutableId;
    }

    public Long getMutableId() 
    {
        return mutableId;
    }
    public void setXotId(Long xotId) 
    {
        this.xotId = xotId;
    }

    public Long getXotId() 
    {
        return xotId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("xotMutableId", getXotMutableId())
            .append("mutableId", getMutableId())
            .append("xotId", getXotId())
            .toString();
    }
}
