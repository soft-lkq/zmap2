package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.persistence.Table;

/**
 * Import对象 tfbd_target
 * 
 * @author ruoyi
 * @date 2023-04-09
 */
@Table(name = "tfbd_target")
public class ImportTfbdTarget extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "主键")
    private Long tfbdTargetId;

    /** $column.columnComment */
    @Excel(name = "转录因子绑定的目标基因")
    private String targetGene;

    /** $column.columnComment */
    @Excel(name = "数值")
    private Long pValue;

    /** $column.columnComment */
    @Excel(name = "tfbd_info主键")
    private Long tfbdNameId;

    public void setTfbdTargetId(Long tfbdTargetId) 
    {
        this.tfbdTargetId = tfbdTargetId;
    }

    public Long getTfbdTargetId() 
    {
        return tfbdTargetId;
    }
    public void setTargetGene(String targetGene) 
    {
        this.targetGene = targetGene;
    }

    public String getTargetGene() 
    {
        return targetGene;
    }
    public void setpValue(Long pValue) 
    {
        this.pValue = pValue;
    }

    public Long getpValue() 
    {
        return pValue;
    }
    public void setTfbdNameId(Long tfbdNameId) 
    {
        this.tfbdNameId = tfbdNameId;
    }

    public Long getTfbdNameId() 
    {
        return tfbdNameId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("tfbdTargetId", getTfbdTargetId())
            .append("targetGene", getTargetGene())
            .append("pValue", getpValue())
            .append("tfbdNameId", getTfbdNameId())
            .toString();
    }
}
