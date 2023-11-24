package com.ruoyi.zeamap.domain;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * variant查询条件类
 *
 * @author 刘洋、邵雯
 * @date 2023-3-2
 */
public class VariantSelectCondition {

    /** $column.columnComment */
    private String type;

    /** $column.columnComment */
    private String chr;

    /** $column.columnComment */
    private Long posi_min;

    /** $column.columnComment */
    private Long posi_max;

    /** $column.columnComment */
    private Double maf_min;

    /** $column.columnComment */
    private Double maf_max;

    /** $column.columnComment */
    private String impacts;

    /** $column.columnComment */
    private String consequences;

    /** $column.columnComment */
    private String accession;

    /** $column.columnComment */
    private String version;

    /** $column.columnComment */
    private String alias;

    /** $column.columnComment */
    private String description;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChr() {
        return chr;
    }

    public void setChr(String chr) {
        this.chr = chr;
    }

    public Long getPosi_min() {
        return posi_min;
    }

    public void setPosi_min(Long posi_min) {
        this.posi_min = posi_min;
    }

    public Long getPosi_max() {
        return posi_max;
    }

    public void setPosi_max(Long posi_max) {
        this.posi_max = posi_max;
    }

    public Double getMaf_min() {
        return maf_min;
    }

    public void setMaf_min(Double maf_min) {
        this.maf_min = maf_min;
    }

    public Double getMaf_max() {
        return maf_max;
    }

    public void setMaf_max(Double maf_max) {
        this.maf_max = maf_max;
    }

    public String getImpacts() {
        return impacts;
    }

    public void setImpacts(String impacts) {
        this.impacts = impacts;
    }

    public String getConsequences() {
        return consequences;
    }

    public void setConsequences(String consequences) {
        this.consequences = consequences;
    }

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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("type", getType())
                .append("chr", getChr())
                .append("posi_min", getPosi_min())
                .append("posi_max", getPosi_max())
                .append("maf_min", getMaf_min())
                .append("maf_max", getMaf_max())
                .append("impacts", getImpacts())
                .append("consequences", getConsequences())
                .append("accession", getAccession())
                .append("version", getVersion())
                .append("alisa", getAlias())
                .append("description", getDescription()).toString();
    }
}
