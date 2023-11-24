package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.persistence.Table;

/**
 * 1对象 xot
 * 
 * @author ruoyi
 * @date 2023-03-15
 */
@Table(name = "xot")
public class ImportXot extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "主键")
    private Long xotId;

    /** $column.columnComment */
    @Excel(name = "组学大分类")
    private String omics;

    /** $column.columnComment */
    @Excel(name = "性状")
    private String category;

    /** $column.columnComment */
    @Excel(name = "小分类")
    private String type;

    /** $column.columnComment */
    @Excel(name = "分类全名")
    private String name;

    /** $column.columnComment */
    @Excel(name = "性状命名")
    private String xotUid;

    /** $column.columnComment */
    @Excel(name = "analysis主键")
    private Long analysisId;

    /** $column.columnComment */
    @Excel(name = "交叉参考id")
    private String crossrefid;

    /** $column.columnComment */
    @Excel(name = "交叉参考连接")
    private String crossreflink;

    /** $column.columnComment */
    @Excel(name = "描述")
    private String description;

    /** $column.columnComment */
    @Excel(name = "测量细节")
    private String mesuredetail;

    /** $column.columnComment */
    @Excel(name = "表型细节")
    private String traitdetail;

    public void setXotId(Long xotId) 
    {
        this.xotId = xotId;
    }

    public Long getXotId() 
    {
        return xotId;
    }
    public void setOmics(String omics) 
    {
        this.omics = omics;
    }

    public String getOmics() 
    {
        return omics;
    }
    public void setCategory(String category) 
    {
        this.category = category;
    }

    public String getCategory() 
    {
        return category;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setXotUid(String xotUid) 
    {
        this.xotUid = xotUid;
    }

    public String getXotUid() 
    {
        return xotUid;
    }
    public void setAnalysisId(Long analysisId) 
    {
        this.analysisId = analysisId;
    }

    public Long getAnalysisId() 
    {
        return analysisId;
    }
    public void setCrossrefid(String crossrefid) 
    {
        this.crossrefid = crossrefid;
    }

    public String getCrossrefid() 
    {
        return crossrefid;
    }
    public void setCrossreflink(String crossreflink) 
    {
        this.crossreflink = crossreflink;
    }

    public String getCrossreflink() 
    {
        return crossreflink;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setMesuredetail(String mesuredetail) 
    {
        this.mesuredetail = mesuredetail;
    }

    public String getMesuredetail() 
    {
        return mesuredetail;
    }
    public void setTraitdetail(String traitdetail) 
    {
        this.traitdetail = traitdetail;
    }

    public String getTraitdetail() 
    {
        return traitdetail;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("xotId", getXotId())
            .append("omics", getOmics())
            .append("category", getCategory())
            .append("type", getType())
            .append("name", getName())
            .append("xotUid", getXotUid())
            .append("analysisId", getAnalysisId())
            .append("crossrefid", getCrossrefid())
            .append("crossreflink", getCrossreflink())
            .append("description", getDescription())
            .append("mesuredetail", getMesuredetail())
            .append("traitdetail", getTraitdetail())
            .toString();
    }
}
