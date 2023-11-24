package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * import对象 xot_germplasm
 * 
 * @author ruoyi
 * @date 2023-04-11
 */
public class ImportXotGermplasm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "主键")
    private Long xotGermplasmId;

    /** $column.columnComment */
    @Excel(name = "分类")
    private String type;

    /** $column.columnComment */
    @Excel(name = "值")
    private String value;

    /** $column.columnComment */
    @Excel(name = "germplasm主键")
    private Long germplasmId;

    /** $column.columnComment */
    @Excel(name = "xot主键")
    private Long xotId;

    public void setXotGermplasmId(Long xotGermplasmId) 
    {
        this.xotGermplasmId = xotGermplasmId;
    }

    public Long getXotGermplasmId() 
    {
        return xotGermplasmId;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setValue(String value) 
    {
        this.value = value;
    }

    public String getValue() 
    {
        return value;
    }
    public void setGermplasmId(Long germplasmId) 
    {
        this.germplasmId = germplasmId;
    }

    public Long getGermplasmId() 
    {
        return germplasmId;
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
            .append("xotGermplasmId", getXotGermplasmId())
            .append("type", getType())
            .append("value", getValue())
            .append("germplasmId", getGermplasmId())
            .append("xotId", getXotId())
            .toString();
    }
}
