package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;

import java.math.BigDecimal;

public class YearAbiotic {

    private Long year;
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

    public YearAbiotic() {
    }

    public YearAbiotic(Long year, String rootLodging, String lodgingResistance, BigDecimal stemLodging, BigDecimal seedlingDeathPercent1, Long deadSeedlingNumber1, BigDecimal seedlingDeathPercent2, Long deadSeedlingNumber2, BigDecimal seedlingDeathPercent3, Long deadSeedlingNumber3, String treatName, BigDecimal deformedSeedlingPercent, Long deformedSeedlingNumber) {
        this.year = year;
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

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
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
}
