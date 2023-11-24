package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * Pca对象 pca
 * 
 * @author ruoyi
 * @date 2023-03-27
 */
public class Pca extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sample;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String pc1;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String pc2;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String pc3;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String pop;

    public void setSample(String sample) 
    {
        this.sample = sample;
    }

    public String getSample() 
    {
        return sample;
    }
    public void setPc1(String pc1) 
    {
        this.pc1 = pc1;
    }

    public String getPc1() 
    {
        return pc1;
    }
    public void setPc2(String pc2) 
    {
        this.pc2 = pc2;
    }

    public String getPc2() 
    {
        return pc2;
    }
    public void setPc3(String pc3) 
    {
        this.pc3 = pc3;
    }

    public String getPc3() 
    {
        return pc3;
    }
    public void setPop(String pop) 
    {
        this.pop = pop;
    }

    public String getPop() 
    {
        return pop;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sample", getSample())
            .append("pc1", getPc1())
            .append("pc2", getPc2())
            .append("pc3", getPc3())
            .append("pop", getPop())
            .toString();
    }
}
