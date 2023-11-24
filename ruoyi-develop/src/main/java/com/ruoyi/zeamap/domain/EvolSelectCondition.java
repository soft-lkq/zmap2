package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 对象 EvolSelectCondition
 * 用来辅助 evolution 查询、下载
 *
 * @author 邵雯
 * @date 2023-04-13
 */
public class EvolSelectCondition extends BaseEntity {
    /**
     * REF //accession
     */
    @Excel(name = "${REF}")
    public String ref;

    /**
     * Version
     */
    @Excel(name = "${Version}")
    public String version;

    /**
     * Indicator
     */
    @Excel(name = "${Indicator}")
    public String indicator;

    /**
     * Analysis
     */
    @Excel(name = "${Analysis}")
    public String analysis_name;

    /**
     * Selection Type //select
     */
    @Excel(name = "${Selection Type}")
    public String select;

    /**
     * Pop Compared //compare_pop
     */
    @Excel(name = "${Pop Compared}")
    public String compare_pop;

    /**
     * Chr //chro
     */
    @Excel(name = "${Chr}")
    public String chro;

    /**
     * Start
     */
    @Excel(name = "${Start}")
    public Double start;

    /**
     * End
     */
    @Excel(name = "${End}")
    public Double end;

    /**
     * Value
     */
    @Excel(name = "${Value}")
    public Double value;

    /**
     * Select Tag //tag
     */
    @Excel(name = "${Select Tag}")
    public String tag;


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public String getAnalysis_name() {
        return analysis_name;
    }

    public void setAnalysis_name(String analysis_name) {
        this.analysis_name = analysis_name;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public String getChro() {
        return chro;
    }

    public void setChro(String chro) {
        this.chro = chro;
    }

    public Double getStart() {
        return start;
    }

    public void setStart(Double start) {
        this.start = start;
    }

    public Double getEnd() {
        return end;
    }

    public void setEnd(Double end) {
        this.end = end;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getCompare_pop() {
        return compare_pop;
    }

    public void setCompare_pop(String compare_pop) {
        this.compare_pop = compare_pop;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public EvolSelectCondition() {
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("version", getVersion())
                .append("ref", getRef())
                .append("indicator", getIndicator())
                .append("analysis_name", getAnalysis_name())
                .append("select", getSelect())
                .append("compare_pop", getCompare_pop())
                .append("chro", getChro())
                .append("start", getStart())
                .append("end", getEnd())
                .append("value", getValue())
                .append("tag",getTag())
                .toString();
    }

    public EvolSelectCondition(String ref, String version,String analysis_name, String incicator, String select, String compare_pop, String chro, Double start, Double end,Double value,String tag) {
        this.ref = ref;
        this.version = version;
        this.analysis_name=analysis_name;
        this.indicator = incicator;
        this.select = select;
        this.compare_pop = compare_pop;
        this.chro = chro;
        this.start = start;
        this.end = end;
        this.value=value;
        this.tag=tag;
    }
}
