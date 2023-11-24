package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;

/**
 * 【请填写功能名称】对象 exon
 *
 * @author 温镜蓉
 * @date 2023-06-24
 */
public class Exon
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String chrom;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private int end;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String exon_id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private int start;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String strand;

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

    public String getExon_id() {
        return exon_id;
    }

    public void setExon_id(String exon_id) {
        this.exon_id = exon_id;
    }

    @Override
    public String toString() {
        return "Exon{" +
                "chrom='" + chrom + '\'' +
                ", end='" + end + '\'' +
                ", start='" + start + '\'' +
                ", strand='" + strand + '\'' +
                ", exon_id='" + exon_id + '\'' +
                '}';
    }
}
