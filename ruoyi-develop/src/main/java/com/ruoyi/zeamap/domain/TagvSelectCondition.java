package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 对象 tagvariant
 *
 * @author 邵雯
 * @date 2023-04-29
 */
public class TagvSelectCondition extends BaseEntity {
    /**
     * tagvariant.tagvariant_id
     */
    private Long tagvariantId;

    /**
     * dbxref.accession
     */
    private String accession;


    /**
     * dbxref.version
     */
    private String version;


    /**
     * population.alias
     */
    private String population;

    /**
     * analysis.description
     */
    private String description;

    /**
     * tagvariant.VID
     */
    @Excel(name = "${VID}")
    private String vid;

    /**
     * tagvariant.chr
     */
    @Excel(name = "${Chr}")
    private String chr;

    /**
     * tagvariant.start
     */
    @Excel(name = "${Start}")
    private Long start;

    /**
     * tagvariant.end
     */
    @Excel(name = "${End}")
    private Long end;

    /**
     * tagvariant.ntag
     */
    @Excel(name = "${Ntag}")
    private Long ntag;

    /**
     * tagvariant.kbspan
     */
    @Excel(name = "${Span(kb)}")
    private Double kbspan;

    /**
     * tagvariant.tags
     */
    @Excel(name = "${Tags}")
    private String tags;

    /**
     * tagvariant.analysis_id
     */
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

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setTagvariantId(Long tagvariantId) {
        this.tagvariantId = tagvariantId;
    }

    public Long getTagvariantId() {
        return tagvariantId;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getVid() {
        return vid;
    }

    public void setChr(String chr) {
        this.chr = chr;
    }

    public String getChr() {
        return chr;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getStart() {
        return start;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public Long getEnd() {
        return end;
    }

    public void setNtag(Long ntag) {
        this.ntag = ntag;
    }

    public Long getNtag() {
        return ntag;
    }

    public void setKbspan(Double kbspan) {
        this.kbspan = kbspan;
    }

    public Double getKbspan() {
        return kbspan;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTags() {
        return tags;
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
                .append("tagvariantId", getTagvariantId())
                .append("accession", getAccession())
                .append("version", getVersion())
                .append("population", getPopulation())
                .append("description", getDescription())
                .append("vid", getVid())
                .append("chr", getChr())
                .append("start", getStart())
                .append("end", getEnd())
                .append("ntag", getNtag())
                .append("kbspan", getKbspan())
                .append("tags", getTags())
                .append("analysisId", getAnalysisId())
                .toString();
    }

    public TagvSelectCondition() {
    }

    public TagvSelectCondition(Long tagvariantId,  String vid, String chr, Long start, Long end, Long ntag, Double kbspan, String tags) {
        this.tagvariantId = tagvariantId;
        this.vid = vid;
        this.chr = chr;
        this.start = start;
        this.end = end;
        this.ntag = ntag;
        this.kbspan = kbspan;
        this.tags = tags;
    }
}
