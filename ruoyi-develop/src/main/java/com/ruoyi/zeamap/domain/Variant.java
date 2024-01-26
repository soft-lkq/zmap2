package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * variant对象 variant
 *
 * @author ruoyi
 * @date 2022-10-30
 */
public class Variant extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String variantId;

    /** $column.columnComment */
    @Excel(name = "Variant ID")
    private String vid;

    /** $column.columnComment */
    @Excel(name = "Type")
    private String type;

    /** $column.columnComment */
    @Excel(name = "Chr")
    private String chr;

    /** $column.columnComment */
    @Excel(name = "Posi")
    private Long posi;

    /** $column.columnComment */
    @Excel(name = "Ref")
    private String Ref;

    @Excel(name = "Allele")
    private String Allele;

    @Excel(name = "AleTypeNum")
    private String AleTypeNum;

    @Excel(name = "refRate")
    private String refRate;

    @Excel(name = "alleleRate")
    private String alleleRate;


    public String getImpacts() {
        return impacts;
    }

    public void setImpacts(String impacts) {
        this.impacts = impacts;
    }

    /** $column.columnComment */
    @Excel(name = "Consequences")
    private String consequences;

    /** $column.columnComment */
    @Excel(name = "impacts")
    private String impacts;


    /** $column.columnComment */
    //暂时不需要导出
    // @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long analysisId;

    public void setVariantId(String variantId)
    {
        this.variantId = variantId;
    }

    public String getVariantId()
    {
        return variantId;
    }
    public void setVid(String vid)
    {
        this.vid = vid;
    }

    public String getVid()
    {
        return vid;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getRef() {
        return Ref;
    }

    public void setRef(String ref) {
        Ref = ref;
    }

    public String getAllele() {
        return Allele;
    }

    public void setAllele(String allele) {
        Allele = allele;
    }

    public String getAleTypeNum() {
        return AleTypeNum;
    }

    public void setAleTypeNum(String aleTypeNum) {
        AleTypeNum = aleTypeNum;
    }

    public String getRefRate() {
        return refRate;
    }

    public void setRefRate(String refRate) {
        this.refRate = refRate;
    }

    public String getAlleleRate() {
        return alleleRate;
    }

    public void setAlleleRate(String alleleRate) {
        this.alleleRate = alleleRate;
    }

    public String getType()
    {
        return type;
    }
    public void setChr(String chr)
    {
        this.chr = chr;
    }

    public String getChr()
    {
        return chr;
    }
    public void setPosi(Long posi)
    {
        this.posi = posi;
    }

    public Long getPosi()
    {
        return posi;
    }

    public void setConsequences(String consequences)
    {
        this.consequences = consequences;
    }

    public String getConsequences()
    {
        return consequences;
    }
    public void setAnalysisId(Long analysisId)
    {
        this.analysisId = analysisId;
    }

    public Long getAnalysisId()
    {
        return analysisId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("variantId", getVariantId())
            .append("vid", getVid())
            .append("type", getType())
            .append("chr", getChr())
            .append("posi", getPosi())
            .append("consequences", getConsequences())
            .append("analysisId", getAnalysisId())
            .toString();
    }
}
