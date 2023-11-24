package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;

import java.util.List;

/**
 * 【请填写功能名称】对象 gene
 *
 * @author 温镜蓉
 * @date 2023-06-24
 */
public class Gene
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String feature_id1;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String chrom;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private int end;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String gene_id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String gene_name;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String gene_type;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private int start;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String strand;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private List<Transcript> transcripts;

    public String getFeature_id1() {
        return feature_id1;
    }

    public void setFeature_id1(String feature_id1) {
        this.feature_id1 = feature_id1;
    }

    public String getChrom() {
        return chrom;
    }

    public void setChrom(String chrom) {
        this.chrom = chrom;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getGene_id() {
        return gene_id;
    }

    public void setGene_id(String gene_id) {
        this.gene_id = gene_id;
    }

    public String getGene_name() {
        return gene_name;
    }

    public void setGene_name(String gene_name) {
        this.gene_name = gene_name;
    }

    public String getGene_type() {
        return gene_type;
    }

    public void setGene_type(String gene_type) {
        this.gene_type = gene_type;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getStrand() {
        return strand;
    }

    public void setStrand(String strand) {
        this.strand = strand;
    }

    public List<Transcript> getTranscripts() {
        return transcripts;
    }

    public void setTranscripts(List<Transcript> transcripts) {
        this.transcripts = transcripts;
    }

    @Override
    public String toString() {
        return "Gene{" +
                "feature_id='" + feature_id1 + '\'' +
                ", chrom='" + chrom + '\'' +
                ", end='" + end + '\'' +
                ", gene_id='" + gene_id + '\'' +
                ", gene_name='" + gene_name + '\'' +
                ", gene_type='" + gene_type + '\'' +
                ", start='" + start + '\'' +
                ", strand='" + strand + '\'' +
                ", transcripts=" + transcripts +
                '}';
    }
}
