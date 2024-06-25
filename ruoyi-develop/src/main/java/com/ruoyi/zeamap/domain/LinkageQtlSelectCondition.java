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
        private String traitTypeName;
        private String traitName;

    public String getTraitTypeName() {
        return traitTypeName;
    }

    public void setTraitTypeName(String traitTypeName) {
        this.traitTypeName = traitTypeName;
    }

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

    public String getTraitName() {
        return traitName;
    }

    public void setTraitName(String traitName) {
        this.traitName = traitName;
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
                .append("traitTypeName", getTraitTypeName())
                .append("traitName", getTraitName())
                .append("linkageMap",getLinkageMap())
                .append("chr", getChr())
                .append("start",getStart())
                .append("end",getEnd())
                .append("lod_min", getLod_min())
                .append("lod_max", getLod_max()).toString();
    }
}
