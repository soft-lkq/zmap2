package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 对象 linkage_marker
 *
 * @author 刘洋
 * @date 2023-03-06
 */
public class LinkageMarker extends BaseEntity {
    private static final long serialVersionUID = 1L;


    private Long linkageMarkerId;

    @Excel(name = "QTL ID")
    //不是表里原有的 是qtl表里的
    private String qtlUid;

    @Excel(name = "REF")
    private String accession;

    @Excel(name = "Version")
    private String version;

    @Excel(name = "Trait Category")
    private String omics;

    @Excel(name = "Trait ID")
    private String xot_uid;

    @Excel(name = "Linkage Map")
    private String linkageMap;


    @Excel(name = "Centimorgan Region:LG")
    private Long linkageGroup;

    @Excel(name = "Centimorgan Region:CM")
    private Double linkageCm;

    private Long dbxrefId;

    private Long qtlId;

    private Long variantId;

    public Long getLinkageMarkerId() {
        return linkageMarkerId;
    }

    public void setLinkageMarkerId(Long linkageMarkerId) {
        this.linkageMarkerId = linkageMarkerId;
    }

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

    public String getOmics() {
        return omics;
    }

    public void setOmics(String omics) {
        this.omics = omics;
    }

    public String getXot_uid() {
        return xot_uid;
    }

    public void setXot_uid(String xot_uid) {
        this.xot_uid = xot_uid;
    }

    public String getLinkageMap() {
        return linkageMap;
    }

    public void setLinkageMap(String linkagemap) {
        this.linkageMap = linkagemap;
    }

    public Long getLinkageGroup() {
        return linkageGroup;
    }

    public void setLinkageGroup(Long linkageGroup) {
        this.linkageGroup = linkageGroup;
    }

    public Double getLinkageCm() {
        return linkageCm;
    }

    public void setLinkageCm(Double linkageCm) {
        this.linkageCm = linkageCm;
    }

    public Long getDbxrefId() {
        return dbxrefId;
    }

    public void setDbxrefId(Long dbxrefId) {
        this.dbxrefId = dbxrefId;
    }

    public Long getQtlId() {
        return qtlId;
    }

    public void setQtlId(Long qtlId) {
        this.qtlId = qtlId;
    }

    public Long getVariantId() {
        return variantId;
    }

    public void setVariantId(Long variantId) {
        this.variantId = variantId;
    }

    public String getQtlUid() {
        return qtlUid;
    }

    public void setQtlUid(String qtlUid) {
        this.qtlUid = qtlUid;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("linkageMarkerId", getLinkageMarkerId())
                .append("accession", getAccession())
                .append("version", getVersion())
                .append("omics", getOmics())
                .append("xot_uid", getXot_uid())
                .append("linkageMap", getLinkageMap())
                .append("linkageGroup", getLinkageGroup())
                .append("linkageCm", getLinkageCm())
                .append("dbxrefId", getDbxrefId())
                .append("qtlId", getQtlId())
                .append("variantId", getVariantId())
                .append("qtlUid", getQtlUid())
                .toString();
    }
}
