package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 对象 association_marker
 *
 * @author 刘洋
 * @date 2023-03-18
 */

public class AssociationMarker extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long associationMarkerId;

    @Excel(name = "QTL ID")
    //不是表里原有的 是qtl表里的
    private String qtlUid;

    @Excel(name = "REF")
    private String accession;

    @Excel(name = "Version")
    private String version;

    @Excel(name = "Region:chr")
    private String chr;

    @Excel(name = "Region:posi")
    private Long posi;

    @Excel(name = "Trait Category")
    private String omics;

    @Excel(name = "Trait ID")
    private String xot_uid;



    @Excel(name = "Variant Type")
    private String type;

    @Excel(name = "Variant ID")
    private String vid;

    @Excel(name = "Leading-log10(P)")
    private String log;

    @Excel(name = "Effect Size")
    private Double effectiveSize;

    @Excel(name = "PIP")
    private Double pip;

    private Long dbxrefId;

    private Long qtlId;

    private Long variantId;

    public Long getAssociationMarkerId() {
        return associationMarkerId;
    }

    public void setAssociationMarkerId(Long associationMarkerId) {
        this.associationMarkerId = associationMarkerId;
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

    public String getChr() {
        return chr;
    }

    public void setChr(String chr) {
        this.chr = chr;
    }

    public Long getPosi() {
        return posi;
    }

    public void setPosi(Long posi) {
        this.posi = posi;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public Double getEffectiveSize() {
        return effectiveSize;
    }

    public void setEffectiveSize(Double effectiveSize) {
        this.effectiveSize = effectiveSize;
    }

    public Double getPip() {
        return pip;
    }

    public void setPip(Double pip) {
        this.pip = pip;
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
                .append("associationMarkerId", getAssociationMarkerId())
                .append("accession", getAccession())
                .append("version", getVersion())
                .append("chr", getChr())
                .append("posi", getPosi())
                .append("omics", getOmics())
                .append("xot_uid", getXot_uid())
                .append("type", getType())
                .append("log", getLog())
                .append("effectiveSize", getEffectiveSize())
                .append("pip", getPip())
                .append("dbxrefId", getDbxrefId())
                .append("qtlId", getQtlId())
                .append("variantId", getVariantId())
                .append("qtlUid",getQtlUid())
                .append("vid",getVid())
                .toString();
    }
}
