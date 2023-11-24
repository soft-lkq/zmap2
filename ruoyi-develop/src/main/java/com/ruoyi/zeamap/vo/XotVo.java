package com.ruoyi.zeamap.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @program: ruoyi
 * @description: 5.4 返回数据
 * @author: Tinaliasd
 **/
public class XotVo {
    private Long xotId;

    private String uid;

    private String category;

    private String type;

    private String analysis;

    private String name;

    private String location;

    private String traitDateLoc;

    private String year;

    private String tissue;




    public Long getXotId() {
        return xotId;
    }

    public void setXotId(Long xotId) {
        this.xotId = xotId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("xotId", getXotId())
                .append("uid", getUid())
                .append("category", getCategory())
                .append("type", getType())
                .append("name", getName())
                .append("analysis", getAnalysis())
                .append("name", getName())
                .append("location",getLocation())
                .append("traitDateLoc",getTraitDateLoc())
                .append("year",getYear())
                .append("tissue",getTissue())
                .toString();
    }

    public XotVo(Long xotId, String uid, String category, String type, String analysis, String name, String location, String traitDateLoc, String year, String tissue) {
        this.xotId = xotId;
        this.uid = uid;
        this.category = category;
        this.type = type;
        this.analysis = analysis;
        this.name = name;
        this.location = location;
        this.traitDateLoc = traitDateLoc;
        this.year = year;
        this.tissue = tissue;
    }

    public XotVo() {
    }
}

