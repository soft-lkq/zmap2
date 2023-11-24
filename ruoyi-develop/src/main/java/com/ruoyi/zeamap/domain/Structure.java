package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * Structure对象 structure
 * 
 * @author ruoyi
 * @date 2023-03-27
 */
public class Structure extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String group;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sample;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String k1;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String k2;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String k3;

    public void setGroup(String group) 
    {
        this.group = group;
    }

    public String getGroup() 
    {
        return group;
    }
    public void setSample(String sample) 
    {
        this.sample = sample;
    }

    public String getSample() 
    {
        return sample;
    }
    public void setK1(String k1) 
    {
        this.k1 = k1;
    }

    public String getK1() 
    {
        return k1;
    }
    public void setK2(String k2) 
    {
        this.k2 = k2;
    }

    public String getK2() 
    {
        return k2;
    }
    public void setK3(String k3) 
    {
        this.k3 = k3;
    }

    public String getK3() 
    {
        return k3;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("group", getGroup())
            .append("sample", getSample())
            .append("k1", getK1())
            .append("k2", getK2())
            .append("k3", getK3())
            .toString();
    }
}
