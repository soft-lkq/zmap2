package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;
/**
 * @Author:刘洋
 * 2023/3/17
 * 查询LinkageMarker条件类
 */
public class LinkageMarkerSelectCondition {
    private String accession;
    private String version;
    private String omics;
    private String xot_uid;
    private String linkageMap;
    private long lg;
    private double cm_min;
    private double cm_max;

    public String getAccession() {
        return accession;
    }

    public void setAccession(String accession) {
        this.accession = accession;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOmics() {
        return omics;
    }

    public void setOmics(String omics) {
        this.omics = omics;
    }

    public String getXot_uid() {
        return xot_uid;
    }

    public void setXot_uid(String xot_uid) {
        this.xot_uid = xot_uid;
    }

    public String getLinkageMap() {
        return linkageMap;
    }

    public void setLinkageMap(String linkageMap) {
        this.linkageMap = linkageMap;
    }

    public long getLg() {
        return lg;
    }

    public void setLg(long lg) {
        this.lg = lg;
    }

    public double getCm_min() {
        return cm_min;
    }

    public void setCm_min(double cm_min) {
        this.cm_min = cm_min;
    }

    public double getCm_max() {
        return cm_max;
    }

    public void setCm_max(double cm_max) {
        this.cm_max = cm_max;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("accession", getAccession())
                .append("version", getVersion())
                .append("omics", getOmics())
                .append("xot_uid", getXot_uid())
                .append("linkageMap",getLinkageMap())
                .append("lg",getLg())
                .append("cm_min", getCm_min())
                .append("cm_max", getCm_max()).toString();
    }
}
