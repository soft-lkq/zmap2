package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 queryCriteria
 *
 * @author 温镜蓉
 * @date 2023-03-15
 */
public class QueryCriteria extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
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
    private String start;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String end;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String commonname;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String description;

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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getCommonname() {
        return commonname;
    }

    public void setCommonname(String commonname) {
        this.commonname = commonname;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("accession", getAccession())
                .append("version", getVersion())
                .append("uniquename", getUniquename())
                .append("start",getStart())
                .append("end",getEnd())
                .append("name",getName())
                .append("commonname",getCommonname())
                .append("description",getDescription())
                .toString();
    }
}
