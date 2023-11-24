package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * @Author:刘洋
 * 2023/3/17
 * 查询LinkageQtl条件类
 */
public class LinkageQtlSelectCondition {

        private String accession;
        private String version;
        private String omics;
        private String xot_uid;
        private String linkageMap;
        private String chr;
        private long Start;
        private long end;
        private double lod_min;
        private double lod_max;

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

    public String getChr() {
        return chr;
    }

    public void setChr(String chr) {
        this.chr = chr;
    }

    public long getStart() {
        return Start;
    }

    public void setStart(long start) {
        Start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public double getLod_min() {
        return lod_min;
    }

    public void setLod_min(double lod_min) {
        this.lod_min = lod_min;
    }

    public double getLod_max() {
        return lod_max;
    }

    public void setLod_max(double lod_max) {
        this.lod_max = lod_max;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("accession", getAccession())
                .append("version", getVersion())
                .append("omics", getOmics())
                .append("linkageMap",getLinkageMap())
                .append("xot_uid", getXot_uid())
                .append("chr", getChr())
                .append("start",getStart())
                .append("end",getEnd())
                .append("lod_min", getLod_min())
                .append("lod_max", getLod_max()).toString();
    }
}
