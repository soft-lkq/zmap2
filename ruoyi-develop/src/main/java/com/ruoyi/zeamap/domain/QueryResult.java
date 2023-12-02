package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 queryResult
 *
 * @author 温镜蓉
 * @date 2023-03-15
 */
public class QueryResult
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String featureId;
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String accession;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String version;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String uniquename;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String commonname;

    /** $column.columnComment */
    @Excel(name = "Name")
    private String name;


    /** $column.columnComment */
    @Excel(name = "CHROM")
    private String chrom;

    /** $column.columnComment */
    @Excel(name = "Start")
    private String start;

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

    public String getUniquename() {
        return uniquename;
    }

    public void setUniquename(String uniquename) {
        this.uniquename = uniquename;
    }

    public String getCommonname() {
        return commonname;
    }

    public void setCommonname(String commonname) {
        this.commonname = commonname;
    }

    /** $column.columnComment */
    @Excel(name = "End")
    private String end;

    /** $column.columnComment */
    @Excel(name = "Strand",readConverterExp = "1=+,-1=-")
    private String strand;

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getChrom() {
        return chrom;
    }

    public void setChrom(String chrom) {
        this.chrom = chrom;
    }
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }
    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
    public String getStrand() {
        return strand;
    }

    public void setStrand(String strand) {
        this.strand = strand;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("featureId", getFeatureId())
                .append("name", getName())
                .append("chromosome", getChrom())
                .append("start", getStart())
                .append("end", getEnd())
                .append("strand", getStrand())
                .toString();
    }
}
