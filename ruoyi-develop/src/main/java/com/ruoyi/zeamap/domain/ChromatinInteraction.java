package com.ruoyi.zeamap.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @Author:刘洋 2023/4/13
 * ChromatinInteraction
 */
@AllArgsConstructor
@NoArgsConstructor
public class ChromatinInteraction extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long chromatinInteractionId;

    @Excel(name = "REF")
    private String accession;

    @Excel(name = "Version")
    private String version;

    @Excel(name = "Analysis")
    private String description;

    @Excel(name = "ChrA")
    private String chrA;

    @Excel(name = "StartA")
    private Long startA;

    @Excel(name = "EndA")
    private Long endA;

    @Excel(name = "ChrB")
    private String chrB;

    @Excel(name = "StartB")
    private Long startB;

    @Excel(name = "EndB")
    private Long endB;

    @Excel(name = "Contact_Counts")
    private Long contactCounts;

    @Excel(name = " P-value")
    private Double pValue;

    @Excel(name = "fdr1")
    private Double fdr1;

    @Excel(name = "fdr2")
    private Double fdr2;

    @Excel(name = "fdr3")
    private Double fdr3;

    @Excel(name = "fdr4")
    private Double fdr4;


    private Long analysisId;

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



    public void setChromatinInteractionId(Long chromatinInteractionId) {
        this.chromatinInteractionId = chromatinInteractionId;
    }

    public Long getChromatinInteractionId() {
        return chromatinInteractionId;
    }

    public void setChrA(String chrA) {
        this.chrA = chrA;
    }

    public String getChrA() {
        return chrA;
    }

    public void setStartA(Long startA) {
        this.startA = startA;
    }

    public Long getStartA() {
        return startA;
    }

    public void setEndA(Long endA) {
        this.endA = endA;
    }

    public Long getEndA() {
        return endA;
    }

    public void setChrB(String chrB) {
        this.chrB = chrB;
    }

    public String getChrB() {
        return chrB;
    }

    public void setStartB(Long startB) {
        this.startB = startB;
    }

    public Long getStartB() {
        return startB;
    }

    public void setEndB(Long endB) {
        this.endB = endB;
    }

    public Long getEndB() {
        return endB;
    }

    public void setContactCounts(Long contactCounts) {
        this.contactCounts = contactCounts;
    }

    public Long getContactCounts() {
        return contactCounts;
    }

    public void setpValue(Double pValue) {
        this.pValue = pValue;
    }

    public Double getpValue() {
        return pValue;
    }

    public void setFdr1(Double fdr1) {
        this.fdr1 = fdr1;
    }

    public Double getFdr1() {
        return fdr1;
    }

    public void setFdr2(Double fdr2) {
        this.fdr2 = fdr2;
    }

    public Double getFdr2() {
        return fdr2;
    }

    public void setFdr3(Double fdr3) {
        this.fdr3 = fdr3;
    }

    public Double getFdr3() {
        return fdr3;
    }

    public void setFdr4(Double fdr4) {
        this.fdr4 = fdr4;
    }

    public Double getFdr4() {
        return fdr4;
    }

    public void setAnalysisId(Long analysisId) {
        this.analysisId = analysisId;
    }

    public Long getAnalysisId() {
        return analysisId;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("accession", getAccession())
                .append("version", getVersion())
                .append("description", getDescription())
                .append("chromatinInteractionId", getChromatinInteractionId())
                .append("chrA", getChrA())
                .append("startA", getStartA())
                .append("endA", getEndA())
                .append("chrB", getChrB())
                .append("startB", getStartB())
                .append("endB", getEndB())
                .append("contactCounts", getContactCounts())
                .append("pValue", getpValue())
                .append("fdr1", getFdr1())
                .append("fdr2", getFdr2())
                .append("fdr3", getFdr3())
                .append("fdr4", getFdr4())
                .append("analysisId", getAnalysisId())
                .toString();
    }
}
