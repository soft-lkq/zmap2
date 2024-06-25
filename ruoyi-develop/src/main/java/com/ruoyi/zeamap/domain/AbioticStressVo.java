package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;

import java.math.BigDecimal;

public class AbioticStressVo {

    @Excel(name = "系谱")
    private String pedigree;

    /**
     * 来源1
     */
    @Excel(name = "来源1")
    private String pedigreeSource1;

    /**
     * 来源2
     */
    @Excel(name = "来源2")
    private String pedigreeSource2;

    /** 年份 */
    @Excel(name = "年份")
    private Long year;

    /** 地点 */
    @Excel(name = "地点")
    private String location;
    /** 根倒伏 */
    @Excel(name = "根倒伏")
    private String rootLodging;

    /** 抗倒性 */
    @Excel(name = "抗倒性")
    private String lodgingResistance;

    /** 茎倒伏 */
    @Excel(name = "茎倒伏")
    private BigDecimal stemLodging;

    /** 死苗率1 */
    @Excel(name = "死苗率1")
    private BigDecimal seedlingDeathPercent1;

    /** 死苗数1 */
    @Excel(name = "死苗数1")
    private Long deadSeedlingNumber1;

    /** 死苗率2 */
    @Excel(name = "死苗率2")
    private BigDecimal seedlingDeathPercent2;

    /** 死苗数2 */
    @Excel(name = "死苗数2")
    private Long deadSeedlingNumber2;

    /** 死苗率3 */
    @Excel(name = "死苗率3")
    private BigDecimal seedlingDeathPercent3;

    /** 死苗数3 */
    @Excel(name = "死苗数3")
    private Long deadSeedlingNumber3;

    /** 鉴定药品 */
    @Excel(name = "鉴定药品")
    private String treatName;

    /** 畸形苗率% */
    @Excel(name = "畸形苗率%")
    private BigDecimal deformedSeedlingPercent;

    /** 畸形苗数 */
    @Excel(name = "畸形苗数")
    private Long deformedSeedlingNumber;


    public AbioticStressVo() {
    }

    public String getPedigree() {
        return pedigree;
    }

    public void setPedigree(String pedigree) {
        this.pedigree = pedigree;
    }

    public String getPedigreeSource1() {
        return pedigreeSource1;
    }

    public void setPedigreeSource1(String pedigreeSource1) {
        this.pedigreeSource1 = pedigreeSource1;
    }

    public String getPedigreeSource2() {
        return pedigreeSource2;
    }

    public void setPedigreeSource2(String pedigreeSource2) {
        this.pedigreeSource2 = pedigreeSource2;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRootLodging() {
        return rootLodging;
    }

    public void setRootLodging(String rootLodging) {
        this.rootLodging = rootLodging;
    }

    public String getLodgingResistance() {
        return lodgingResistance;
    }

    public void setLodgingResistance(String lodgingResistance) {
        this.lodgingResistance = lodgingResistance;
    }

    public BigDecimal getStemLodging() {
        return stemLodging;
    }

    public void setStemLodging(BigDecimal stemLodging) {
        this.stemLodging = stemLodging;
    }

    public BigDecimal getSeedlingDeathPercent1() {
        return seedlingDeathPercent1;
    }

    public void setSeedlingDeathPercent1(BigDecimal seedlingDeathPercent1) {
        this.seedlingDeathPercent1 = seedlingDeathPercent1;
    }

    public Long getDeadSeedlingNumber1() {
        return deadSeedlingNumber1;
    }

    public void setDeadSeedlingNumber1(Long deadSeedlingNumber1) {
        this.deadSeedlingNumber1 = deadSeedlingNumber1;
    }

    public BigDecimal getSeedlingDeathPercent2() {
        return seedlingDeathPercent2;
    }

    public void setSeedlingDeathPercent2(BigDecimal seedlingDeathPercent2) {
        this.seedlingDeathPercent2 = seedlingDeathPercent2;
    }

    public Long getDeadSeedlingNumber2() {
        return deadSeedlingNumber2;
    }

    public void setDeadSeedlingNumber2(Long deadSeedlingNumber2) {
        this.deadSeedlingNumber2 = deadSeedlingNumber2;
    }

    public BigDecimal getSeedlingDeathPercent3() {
        return seedlingDeathPercent3;
    }

    public void setSeedlingDeathPercent3(BigDecimal seedlingDeathPercent3) {
        this.seedlingDeathPercent3 = seedlingDeathPercent3;
    }

    public Long getDeadSeedlingNumber3() {
        return deadSeedlingNumber3;
    }

    public void setDeadSeedlingNumber3(Long deadSeedlingNumber3) {
        this.deadSeedlingNumber3 = deadSeedlingNumber3;
    }

    public String getTreatName() {
        return treatName;
    }

    public void setTreatName(String treatName) {
        this.treatName = treatName;
    }

    public BigDecimal getDeformedSeedlingPercent() {
        return deformedSeedlingPercent;
    }

    public void setDeformedSeedlingPercent(BigDecimal deformedSeedlingPercent) {
        this.deformedSeedlingPercent = deformedSeedlingPercent;
    }

    public Long getDeformedSeedlingNumber() {
        return deformedSeedlingNumber;
    }

    public void setDeformedSeedlingNumber(Long deformedSeedlingNumber) {
        this.deformedSeedlingNumber = deformedSeedlingNumber;
    }

    public AbioticStressVo(String pedigree, String pedigreeSource1, String pedigreeSource2, Long year, String location, String rootLodging, String lodgingResistance, BigDecimal stemLodging, BigDecimal seedlingDeathPercent1, Long deadSeedlingNumber1, BigDecimal seedlingDeathPercent2, Long deadSeedlingNumber2, BigDecimal seedlingDeathPercent3, Long deadSeedlingNumber3, String treatName, BigDecimal deformedSeedlingPercent, Long deformedSeedlingNumber) {
        this.pedigree = pedigree;
        this.pedigreeSource1 = pedigreeSource1;
        this.pedigreeSource2 = pedigreeSource2;
        this.year = year;
        this.location = location;
        this.rootLodging = rootLodging;
        this.lodgingResistance = lodgingResistance;
        this.stemLodging = stemLodging;
        this.seedlingDeathPercent1 = seedlingDeathPercent1;
        this.deadSeedlingNumber1 = deadSeedlingNumber1;
        this.seedlingDeathPercent2 = seedlingDeathPercent2;
        this.deadSeedlingNumber2 = deadSeedlingNumber2;
        this.seedlingDeathPercent3 = seedlingDeathPercent3;
        this.deadSeedlingNumber3 = deadSeedlingNumber3;
        this.treatName = treatName;
        this.deformedSeedlingPercent = deformedSeedlingPercent;
        this.deformedSeedlingNumber = deformedSeedlingNumber;
    }
}
