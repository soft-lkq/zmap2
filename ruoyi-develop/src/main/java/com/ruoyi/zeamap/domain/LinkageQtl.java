package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 对象 linkage_qtl
 *
 * @author 刘洋
 * @date 2023-03-06
 */
public class LinkageQtl extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Excel(name = "QTL ID")
    private String qtlUid;

    private Long linkageQtlId;

    @Excel(name = "REF")
    private String accession;

    @Excel(name = "Version")
    private String version;

    @Excel(name = "Region:chr")
    private String chr;

    @Excel(name = "Region:start")
    private Long start;

    @Excel(name = "Region:end")
    private Long end;

    @Excel(name = "Trait Category")
    private String omics;

    @Excel(name = "Trait ID")
    private String xot_uid;

    @Excel(name = "LOD")
    private String lod;

    @Excel(name = "Linkage Map")
    private String linkagemap;


    private Long dbxrefId;
    private Long traitId;

    public Long getLinkageQtlId() {
        return linkageQtlId;
    }

    public void setLinkageQtlId(Long linkageQtlId) {
        this.linkageQtlId = linkageQtlId;
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

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
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

    public String getLod() {
        return lod;
    }

    public void setLod(String lod) {
        this.lod = lod;
    }

    public String getLinkagemap() {
        return linkagemap;
    }

    public void setLinkagemap(String linkagemap) {
        this.linkagemap = linkagemap;
    }

    public String getQtlUid() {
        return qtlUid;
    }

    public void setQtlUid(String qtlUid) {
        this.qtlUid = qtlUid;
    }

    public Long getDbxrefId() {
        return dbxrefId;
    }

    public void setDbxrefId(Long dbxrefId) {
        this.dbxrefId = dbxrefId;
    }

    public Long getTraitId() {
        return traitId;
    }

    public void setTraitId(Long traitId) {
        this.traitId = traitId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("qtlUid", getQtlUid())
                .append("linkageQtlId", getLinkageQtlId())
                .append("accession", getAccession())
                .append("version", getVersion())
                .append("chr", getChr())
                .append("start", getStart())
                .append("end", getEnd())
                .append("omics", getOmics())
                .append("xot_uid", getXot_uid())
                .append("lod", getLod())
                .append("linkagemap", getLinkagemap())
                .append("dbxrefId", getDbxrefId())
                .append("traitId", getTraitId())
                .toString();
    }
}
