package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;

/**
 * 【请填写功能名称】对象 phewas
 *
 * @author 温镜蓉
 * @date 2023-05-24
 */
public class Phewas
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String build = "B73V4";

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String chromosome;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String description = "";

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private int id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String log_pvalue;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String pmid = "";

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String position;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String ref_allele;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String ref_allele_freq;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String score_test_stat = "";

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String study = "";

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String tech = "";

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String trait;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String trait_group;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String trait_label;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String viriant;

    public String getBuild() {
        return build;
    }
    public void setBuild(String build) {
        this.build = build;
    }
    public String getChromosome() {
        return chromosome;
    }
    public void setChromosome(String chromosome) {
        this.chromosome = chromosome;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLog_pvalue() {
        return log_pvalue;
    }
    public void setLog_pvalue(String log_pvalue) {
        this.log_pvalue = log_pvalue;
    }
    public String getPmid() {
        return pmid;
    }
    public void setPmid(String pmid) {
        this.pmid = pmid;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getRef_allele() {
        return ref_allele;
    }
    public void setRef_allele(String ref_allele) {
        this.ref_allele = ref_allele;
    }
    public String getRef_allele_freq() {
        return ref_allele_freq;
    }
    public void setRef_allele_freq(String ref_allele_freq) {
        this.ref_allele_freq = ref_allele_freq;
    }
    public String getScore_test_stat() {
        return score_test_stat;
    }
    public void setScore_test_stat(String score_test_stat) {
        this.score_test_stat = score_test_stat;
    }
    public String getStudy() {
        return study;
    }
    public void setStudy(String study) {
        this.study = study;
    }
    public String getTech() {
        return tech;
    }
    public void setTech(String tech) {
        this.tech = tech;
    }
    public String getTrait() {
        return trait;
    }
    public void setTrait(String trait) {
        this.trait = trait;
    }
    public String getTrait_group() {
        return trait_group;
    }
    public void setTrait_group(String trait_group) {
        this.trait_group = trait_group;
    }
    public String getTrait_label() {
        return trait_label;
    }
    public void setTrait_label(String trait_label) {
        this.trait_label = trait_label;
    }
    public String getViriant() {
        return viriant;
    }
    public void setViriant(String viriant) {
        this.viriant = viriant;
    }

    @Override
    public String toString() {
        return "Phewas{" +
                "build='" + build + '\'' +
                ", chromosome='" + chromosome + '\'' +
                ", description='" + description + '\'' +
                ", id='" + id + '\'' +
                ", log_pvalue='" + log_pvalue + '\'' +
                ", pmid='" + pmid + '\'' +
                ", position='" + position + '\'' +
                ", ref_allele='" + ref_allele + '\'' +
                ", ref_allele_freq='" + ref_allele_freq + '\'' +
                ", score_test_stat='" + score_test_stat + '\'' +
                ", study='" + study + '\'' +
                ", tech='" + tech + '\'' +
                ", trait='" + trait + '\'' +
                ", trait_group='" + trait_group + '\'' +
                ", trait_label='" + trait_label + '\'' +
                ", viriant='" + viriant + '\'' +
                '}';
    }
}
