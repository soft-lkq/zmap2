package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;

import java.util.List;

/**
 * 【请填写功能名称】对象 transcript
 *
 * @author 温镜蓉
 * @date 2023-06-24
 */
public class Transcript
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String feature_id2;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String chrom;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private int end;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private List<Exon> exons;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private int start;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String strand;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String transcript_id;

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

    public String getTranscript_id() {
        return transcript_id;
    }

    public void setTranscript_id(String transcript_id) {
        this.transcript_id = transcript_id;
    }

    public List<Exon> getExons() {
        return exons;
    }

    public void setExons(List<Exon> exons) {
        this.exons = exons;
    }

    public String getFeature_id2() {
        return feature_id2;
    }

    public void setFeature_id2(String feature_id2) {
        this.feature_id2 = feature_id2;
    }

    @Override
    public String toString() {
        return "Transcript{" +
                "feature_id2='" + feature_id2 + '\'' +
                ", chrom='" + chrom + '\'' +
                ", end='" + end + '\'' +
                ", exons=" + exons +
                ", start='" + start + '\'' +
                ", strand='" + strand + '\'' +
                ", transcript_id='" + transcript_id + '\'' +
                '}';
    }
}
