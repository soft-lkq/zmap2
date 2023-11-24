package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Author:刘洋
 * 2023/3/17
 * 查询AssociationQtl条件类
 */

public class AssociationQtlSelectCondition {
    private String accession;
    private String version;
    private String omics;
    private String xot_uid;
    private String chr;
    private long start;
    private long end;
    private double log_min;
    private double log_max;

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


    public String getChr() {
        return chr;
    }

    public void setChr(String chr) {
        this.chr = chr;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public double getLog_min() {
        return log_min;
    }

    public void setLog_min(double log_min) {
        this.log_min = log_min;
    }

    public double getLog_max() {
        return log_max;
    }

    public void setLog_max(double log_max) {
        this.log_max = log_max;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("accession", getAccession())
                .append("version", getVersion())
                .append("omics", getOmics())
                .append("xot_uid", getXot_uid())
                .append("chr", getChr())
                .append("start",getStart())
                .append("end",getEnd())
                .append("log_min", getLog_min())
                .append("log_max", getLog_max()).toString();
    }
}
