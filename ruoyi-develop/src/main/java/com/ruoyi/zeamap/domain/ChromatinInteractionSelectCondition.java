package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Author:刘洋
 * 2023/4/13
 * 查询ChromatinInteraction条件类
 */
public class ChromatinInteractionSelectCondition {
    private String accession;
    private String version;
    private String description;
    private String chrA;
    private long startA;
    private long endA;
    private String chrB;
    private long startB;
    private long endB;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChrA() {
        return chrA;
    }

    public void setChrA(String chrA) {
        this.chrA = chrA;
    }

    public long getStartA() {
        return startA;
    }

    public void setStartA(long startA) {
        this.startA = startA;
    }

    public long getEndA() {
        return endA;
    }

    public void setEndA(long endA) {
        this.endA = endA;
    }

    public String getChrB() {
        return chrB;
    }

    public void setChrB(String chrB) {
        this.chrB = chrB;
    }

    public long getStartB() {
        return startB;
    }

    public void setStartB(long startB) {
        this.startB = startB;
    }

    public long getEndB() {
        return endB;
    }

    public void setEndB(long endB) {
        this.endB = endB;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("accession", getAccession())
                .append("version", getVersion())
                .append("description", getDescription())
                .append("chrA", getChrA())
                .append("startA",getStartA())
                .append("endA",getEndA())
                .append("chrB", getChrB())
                .append("startB",getStartB())
                .append("endB",getEndB()).toString();
    }
}
