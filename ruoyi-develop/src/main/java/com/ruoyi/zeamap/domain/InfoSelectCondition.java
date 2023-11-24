package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 对象 InfoSelectCondition
 * 用来辅助 tfbd_info 查询、下载
 *
 * @author 邵雯
 * @date 2023-03-10
 */
public class InfoSelectCondition extends BaseEntity {
    /**
     * REF
     */
    @Excel(name = "${REF}")
    public String accession;

    /**
     * Version
     */
    @Excel(name = "${Version}")
    public String version;

    /**
     * Analysis
     */
    @Excel(name = "${Analysis}")
    public String analysis_name;

    /**
     * TF ID
     */
    @Excel(name = "${TF ID}")
    public String info_name;

    /**
     * TF Name
     */
    @Excel(name = "${TF Name}")
    public String info_simplename;

    /**
     * TF Family
     */
    @Excel(name = "${TF Family}")
    public String info_family;

    /**
     * Target Gene
     */
    @Excel(name = "${Target Gene}")
    public String target_gene;

    /**
     * P-value
     */
    @Excel(name = "${P-value}")
    public Double p_value;
    //Maximum Cofidence P-value是tfbd_target中p_value的最大值


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAccession() {
        return accession;
    }

    public void setAccession(String accession) {
        this.accession = accession;
    }

    public String getAnalysis_name() {
        return analysis_name;
    }

    public void setAnalysis_name(String analysis_name) {
        this.analysis_name = analysis_name;
    }

    public String getInfo_name() {
        return info_name;
    }

    public void setInfo_name(String info_name) {
        this.info_name = info_name;
    }

    public String getInfo_simplename() {
        return info_simplename;
    }

    public void setInfo_simplename(String info_simplename) {
        this.info_simplename = info_simplename;
    }

    public String getInfo_family() {
        return info_family;
    }

    public void setInfo_family(String info_family) {
        this.info_family = info_family;
    }

    public String getTarget_gene() {
        return target_gene;
    }

    public void setTarget_gene(String target_gene) {
        this.target_gene = target_gene;
    }

    public Double getP_value() {
        return p_value;
    }

    public void setP_value(Double p_value) {
        this.p_value = p_value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("accession", getAccession())
                .append("version", getVersion())
                .append("analysis_name", getAnalysis_name())
                .append("info_name", getInfo_name())
                .append("info_simplename", getInfo_simplename())
                .append("info_family", getInfo_family())
                .append("target_gene", getTarget_gene())
                .append("p_value", getP_value())
                .toString();
    }

    public InfoSelectCondition() {
    }

    public InfoSelectCondition(String accession, String version, String analysis_name, String info_name, String info_simplename, String info_family, String target_gene, Double p_value) {
        this.accession = accession;
        this.version = version;
        this.analysis_name = analysis_name;
        this.info_name = info_name;
        this.info_simplename = info_simplename;
        this.info_family = info_family;
        this.target_gene = target_gene;
        this.p_value = p_value;
    }
}
