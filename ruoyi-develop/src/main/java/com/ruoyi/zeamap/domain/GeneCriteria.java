package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 geneCriteria
 *
 * @author 温镜蓉
 * @date 2023-06-24
 */
public class GeneCriteria extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String type_name = "gene";

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String dbxref_accession = "B73";

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String dbxref_version = "4.43.0";

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String start;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String end;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String chr;

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getDbxref_accession() {
        return dbxref_accession;
    }

    public void setDbxref_accession(String dbxref_accession) {
        this.dbxref_accession = dbxref_accession;
    }

    public String getDbxref_version() {
        return dbxref_version;
    }

    public void setDbxref_version(String dbxref_version) {
        this.dbxref_version = dbxref_version;
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

    public String getChr() {
        return chr;
    }

    public void setChr(String chr) {
        this.chr = chr;
    }

    @Override
    public String toString() {
        return "GeneCriteria{" +
                "type_name='" + type_name + '\'' +
                ", dbxref_accession='" + dbxref_accession + '\'' +
                ", dbxref_version='" + dbxref_version + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", chr='" + chr + '\'' +
                '}';
    }
}
