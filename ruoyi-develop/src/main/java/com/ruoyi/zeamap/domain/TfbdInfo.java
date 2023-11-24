package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 对象 tfbd_info
 *
 * @author 邵雯
 * @date 2023-03-07
 */
public class TfbdInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long tfbdId;

    /**
     * name
     */
    @Excel(name = "${name}")
    private String name;

    /**
     * family
     */
    @Excel(name = "${family}")
    private String family;

    /**
     * simplename
     */
    @Excel(name = "${simplename}")
    private String simplename;

    /**
     * genev4
     */
    @Excel(name = "${genev4}")
    private String genev4;

    /**
     * genev3
     */
    @Excel(name = "${genev3}")
    private String genev3;

    /**
     * tfClass
     */
    @Excel(name = "${tfClass}")
    private String tfClass;

    /**
     * enrichGo
     */
    @Excel(name = "${enrichGo}")
    private String enrichGo;

    /**
     * enrichMp
     */
    @Excel(name = "${enrichMp}")
    private String enrichMp;

    /**
     * AtID
     */
    @Excel(name = "${AtID}")
    private String AtID;

    /**
     * Atsimplename
     */
    @Excel(name = "${Atsimplename}")
    private String Atsimplename;

    /**
     * description
     */
    @Excel(name = "${description}")
    private String description;

    /**
     * phenotype
     */
    @Excel(name = "${phenotype}")
    private String phenotype;

    /**
     * analysisId
     */
    @Excel(name = "${analysisId}")
    private Long analysisId;

    public void setTfbdId(Long tfbdId) {
        this.tfbdId = tfbdId;
    }

    public Long getTfbdId() {
        return tfbdId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getFamily() {
        return family;
    }

    public void setSimplename(String simplename) {
        this.simplename = simplename;
    }

    public String getSimplename() {
        return simplename;
    }

    public void setGenev4(String genev4) {
        this.genev4 = genev4;
    }

    public String getGenev4() {
        return genev4;
    }

    public void setGenev3(String genev3) {
        this.genev3 = genev3;
    }

    public String getGenev3() {
        return genev3;
    }

    public void setTfClass(String tfClass) {
        this.tfClass = tfClass;
    }

    public String getTfClass() {
        return tfClass;
    }

    public void setEnrichGo(String enrichGo) {
        this.enrichGo = enrichGo;
    }

    public String getEnrichGo() {
        return enrichGo;
    }

    public void setEnrichMp(String enrichMp) {
        this.enrichMp = enrichMp;
    }

    public String getEnrichMp() {
        return enrichMp;
    }

    public void setAtID(String AtID) {
        this.AtID = AtID;
    }

    public String getAtID() {
        return AtID;
    }

    public void setAtsimplename(String Atsimplename) {
        this.Atsimplename = Atsimplename;
    }

    public String getAtsimplename() {
        return Atsimplename;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPhenotype(String phenotype) {
        this.phenotype = phenotype;
    }

    public String getPhenotype() {
        return phenotype;
    }

    public void setAnalysisId(Long analysisId) {
        this.analysisId = analysisId;
    }

    public Long getAnalysisId() {
        return analysisId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("tfbdId", getTfbdId())
                .append("name", getName())
                .append("family", getFamily())
                .append("simplename", getSimplename())
                .append("genev4", getGenev4())
                .append("genev3", getGenev3())
                .append("tfClass", getTfClass())
                .append("enrichGo", getEnrichGo())
                .append("enrichMp", getEnrichMp())
                .append("AtID", getAtID())
                .append("Atsimplename", getAtsimplename())
                .append("description", getDescription())
                .append("phenotype", getPhenotype())
                .append("analysisId", getAnalysisId())
                .toString();
    }
}
