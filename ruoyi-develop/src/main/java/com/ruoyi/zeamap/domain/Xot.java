package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * xot对象 xot
 * 
 * @author ruoyi
 * @date 2023-01-08
 */
public class Xot extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long xotId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String omics;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String category;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String type;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** 暂时未做 */
    @Excel(name = "暂时未做")
    private String xotUid;

    /** 关联analyssis表 */
    @Excel(name = "关联analyssis表")
    private Long analysisId;




    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String crossrefid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String crossreflink;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String description;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String mesuredetail;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String traitdetail;

    private Analysis analysis;



    //返回数据添加的额外字段
    private String location;

    private String traitDateLoc;

    private String year;

    private String tissue;


    public Analysis getAnalysis() {
        return analysis;
    }

    public void setAnalysis(Analysis analysis) {
        this.analysis = analysis;
    }

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTraitDateLoc() {
        return traitDateLoc;
    }

    public void setTraitDateLoc(String traitDateLoc) {
        this.traitDateLoc = traitDateLoc;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTissue() {
        return tissue;
    }

    public void setTissue(String tissue) {
        this.tissue = tissue;
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

    public String getCrossrefid() {
        return crossrefid;
    }

    public void setCrossrefid(String crossrefid) {
        this.crossrefid = crossrefid;
    }

    public String getCrossreflink() {
        return crossreflink;
    }

    public void setCrossreflink(String crossreflink) {
        this.crossreflink = crossreflink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMesuredetail() {
        return mesuredetail;
    }

    public void setMesuredetail(String mesuredetail) {
        this.mesuredetail = mesuredetail;
    }

    public String getTraitdetail() {
        return traitdetail;
    }

    public void setTraitdetail(String traitdetail) {
        this.traitdetail = traitdetail;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("xotId", getXotId())
                .append("omics", getOmics())
                .append("category", getCategory())
                .append("type", getType())
                .append("name", getName())
                .append("xotUid", getXotUid())
                .append("analysisId", getAnalysisId())
                .append("analysis", getAnalysis())
                //后来表更改添加的字段
                .append("crossrefid", getCrossrefid())
                .append("crossreflink", getCrossreflink())
                .append("description", getDescription())
                .append("mesuredetail", getMesuredetail())
                .append("traitdetail", getTraitdetail())

                .append("location",getLocation())
                .append("traitDateLoc",getTraitDateLoc())
                .append("year",getYear())
                .append("tissue",getTissue())
                .toString();
    }
}

