package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 对象 evolution
 *
 * @author 邵雯
 * @date 2023-04-12
 */
public class Evolution extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * evolution表 主键
     */
    private Long evolutionId;

    /**
     * chro
     */
    @Excel(name = "${chro}")
    private String chro;

    /**
     * start
     */
    @Excel(name = "${start}")
    private Double start;

    /**
     * end
     */
    @Excel(name = "${end}")
    private Double end;

    /**
     * value
     */
    @Excel(name = "${value}")
    private Double value;

    /**
     * tag
     */
    @Excel(name = "${tag}")
    private String tag;

    /**
     * evolutionType表 主键
     */
    @Excel(name = "${evolutionTypeId}")
    private Long evolutionTypeId;

    /**
     * dbxref表 主键
     */
    @Excel(name = "${dbxrefId}")
    private Long dbxrefId;

    public void setEvolutionId(Long evolutionId) {
        this.evolutionId = evolutionId;
    }

    public Long getEvolutionId() {
        return evolutionId;
    }

    public void setChro(String chro) {
        this.chro = chro;
    }

    public String getChro() {
        return chro;
    }

    public void setStart(Double start) {
        this.start = start;
    }

    public Double getStart() {
        return start;
    }

    public void setEnd(Double end) {
        this.end = end;
    }

    public Double getEnd() {
        return end;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setEvolutionTypeId(Long evolutionTypeId) {
        this.evolutionTypeId = evolutionTypeId;
    }

    public Long getEvolutionTypeId() {
        return evolutionTypeId;
    }

    public void setDbxrefId(Long dbxrefId) {
        this.dbxrefId = dbxrefId;
    }

    public Long getDbxrefId() {
        return dbxrefId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("evolutionId", getEvolutionId())
                .append("chro", getChro())
                .append("start", getStart())
                .append("end", getEnd())
                .append("value", getValue())
                .append("tag", getTag())
                .append("evolutionTypeId", getEvolutionTypeId())
                .append("dbxrefId", getDbxrefId())
                .toString();
    }
}
