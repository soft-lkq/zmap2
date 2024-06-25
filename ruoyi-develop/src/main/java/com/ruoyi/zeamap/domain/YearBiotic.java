package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;

public class YearBiotic {
    private Long year;
    @Excel(name = "黑粉")
    private Long ustilagoMaydis;

    /**
     * 穗腐病
     */
    @Excel(name = "穗腐病")
    private Long maizeEarRot;

    /**
     * 纹枯病(级)
     */
    @Excel(name = "纹枯病(级)")
    private Long maizeSheathBlight;

    /**
     * 锈病
     */
    @Excel(name = "锈病")
    private Long southernCornRust;

    /**
     * 叶斑病(级)
     */
    @Excel(name = "叶斑病(级)")
    private Long leafSpotDisease;

    /**
     * 玉米螟
     */
    @Excel(name = "玉米螟")
    private Long maizeBorer;

    /**
     * 茎腐病
     */
    @Excel(name = "茎腐病")
    private String maizeStalkRot;

    /**
     * 粗缩
     */
    @Excel(name = "粗缩")
    private String maizeRoughDwarfDisease;

    /**
     * 锈病txt
     */
    @Excel(name = "锈病txt")
    private String southernCornRustTxt;

    /**
     * 大斑病txt
     */
    @Excel(name = "大斑病txt")
    private String northernLeafBlight;

    /**
     * 矮花叶病
     */
    @Excel(name = "矮花叶病")
    private String maizeDwarfMosaicDisease;

    /**
     * 白化病
     */
    @Excel(name = "白化病")
    private String maizeAlbinism;

    /**
     * 褐斑病
     */
    @Excel(name = "褐斑病")
    private String physodermaMaydis;

    /**
     * 灰斑病
     */
    @Excel(name = "灰斑病")
    private String grayLeafSpot;

    /**
     * 粒腐病
     */
    @Excel(name = "粒腐病")
    private String earKernelRot;

    /**
     * 小斑病
     */
    @Excel(name = "小斑病")
    private String southernLeafBlight;

    /**
     * 禾谷茎腐（%）
     */
    @Excel(name = "禾谷茎腐", readConverterExp = "%=")
    private String graminearumStalkRot;

    /**
     * 腐霉茎腐（%）
     */
    @Excel(name = "腐霉茎腐", readConverterExp = "%=")
    private String pythiumStalkRot;

    /**
     * 禾谷穗腐（级）
     */
    @Excel(name = "禾谷穗腐", readConverterExp = "级=")
    private String fGraminearum;

    /**
     * 拟轮枝穗腐（级）
     */
    @Excel(name = "拟轮枝穗腐", readConverterExp = "级=")
    private String fVerticillioides;

    /**
     * 蚜虫
     */
    @Excel(name = "蚜虫")
    private String aphis;

    /**
     * 抗虫性
     */
    @Excel(name = "抗虫性")
    private String borerResistance;

    /**
     * 接种处理
     */
    @Excel(name = "接种处理")
    private String treatmentsApplied;

    /**
     * 抗性性状1
     */
    @Excel(name = "抗性性状1")
    private String resistanceCharacters1;

    /**
     * 抗性性状2
     */
    @Excel(name = "抗性性状2")
    private String resistanceCharacters2;

    /**
     * 抗性性状3
     */
    @Excel(name = "抗性性状3")
    private String resistanceCharacters3;

    /**
     * 综合抗性
     */
    @Excel(name = "综合抗性")
    private String comprehensiveResistance;

    public YearBiotic() {
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getUstilagoMaydis() {
        return ustilagoMaydis;
    }

    public void setUstilagoMaydis(Long ustilagoMaydis) {
        this.ustilagoMaydis = ustilagoMaydis;
    }

    public Long getMaizeEarRot() {
        return maizeEarRot;
    }

    public void setMaizeEarRot(Long maizeEarRot) {
        this.maizeEarRot = maizeEarRot;
    }

    public Long getMaizeSheathBlight() {
        return maizeSheathBlight;
    }

    public void setMaizeSheathBlight(Long maizeSheathBlight) {
        this.maizeSheathBlight = maizeSheathBlight;
    }

    public Long getSouthernCornRust() {
        return southernCornRust;
    }

    public void setSouthernCornRust(Long southernCornRust) {
        this.southernCornRust = southernCornRust;
    }

    public Long getLeafSpotDisease() {
        return leafSpotDisease;
    }

    public void setLeafSpotDisease(Long leafSpotDisease) {
        this.leafSpotDisease = leafSpotDisease;
    }

    public Long getMaizeBorer() {
        return maizeBorer;
    }

    public void setMaizeBorer(Long maizeBorer) {
        this.maizeBorer = maizeBorer;
    }

    public String getMaizeStalkRot() {
        return maizeStalkRot;
    }

    public void setMaizeStalkRot(String maizeStalkRot) {
        this.maizeStalkRot = maizeStalkRot;
    }

    public String getMaizeRoughDwarfDisease() {
        return maizeRoughDwarfDisease;
    }

    public void setMaizeRoughDwarfDisease(String maizeRoughDwarfDisease) {
        this.maizeRoughDwarfDisease = maizeRoughDwarfDisease;
    }

    public String getSouthernCornRustTxt() {
        return southernCornRustTxt;
    }

    public void setSouthernCornRustTxt(String southernCornRustTxt) {
        this.southernCornRustTxt = southernCornRustTxt;
    }

    public String getNorthernLeafBlight() {
        return northernLeafBlight;
    }

    public void setNorthernLeafBlight(String northernLeafBlight) {
        this.northernLeafBlight = northernLeafBlight;
    }

    public String getMaizeDwarfMosaicDisease() {
        return maizeDwarfMosaicDisease;
    }

    public void setMaizeDwarfMosaicDisease(String maizeDwarfMosaicDisease) {
        this.maizeDwarfMosaicDisease = maizeDwarfMosaicDisease;
    }

    public String getMaizeAlbinism() {
        return maizeAlbinism;
    }

    public void setMaizeAlbinism(String maizeAlbinism) {
        this.maizeAlbinism = maizeAlbinism;
    }

    public String getPhysodermaMaydis() {
        return physodermaMaydis;
    }

    public void setPhysodermaMaydis(String physodermaMaydis) {
        this.physodermaMaydis = physodermaMaydis;
    }

    public String getGrayLeafSpot() {
        return grayLeafSpot;
    }

    public void setGrayLeafSpot(String grayLeafSpot) {
        this.grayLeafSpot = grayLeafSpot;
    }

    public String getEarKernelRot() {
        return earKernelRot;
    }

    public void setEarKernelRot(String earKernelRot) {
        this.earKernelRot = earKernelRot;
    }

    public String getSouthernLeafBlight() {
        return southernLeafBlight;
    }

    public void setSouthernLeafBlight(String southernLeafBlight) {
        this.southernLeafBlight = southernLeafBlight;
    }

    public String getGraminearumStalkRot() {
        return graminearumStalkRot;
    }

    public void setGraminearumStalkRot(String graminearumStalkRot) {
        this.graminearumStalkRot = graminearumStalkRot;
    }

    public String getPythiumStalkRot() {
        return pythiumStalkRot;
    }

    public void setPythiumStalkRot(String pythiumStalkRot) {
        this.pythiumStalkRot = pythiumStalkRot;
    }

    public String getfGraminearum() {
        return fGraminearum;
    }

    public void setfGraminearum(String fGraminearum) {
        this.fGraminearum = fGraminearum;
    }

    public String getfVerticillioides() {
        return fVerticillioides;
    }

    public void setfVerticillioides(String fVerticillioides) {
        this.fVerticillioides = fVerticillioides;
    }

    public String getAphis() {
        return aphis;
    }

    public void setAphis(String aphis) {
        this.aphis = aphis;
    }

    public String getBorerResistance() {
        return borerResistance;
    }

    public void setBorerResistance(String borerResistance) {
        this.borerResistance = borerResistance;
    }

    public String getTreatmentsApplied() {
        return treatmentsApplied;
    }

    public void setTreatmentsApplied(String treatmentsApplied) {
        this.treatmentsApplied = treatmentsApplied;
    }

    public String getResistanceCharacters1() {
        return resistanceCharacters1;
    }

    public void setResistanceCharacters1(String resistanceCharacters1) {
        this.resistanceCharacters1 = resistanceCharacters1;
    }

    public String getResistanceCharacters2() {
        return resistanceCharacters2;
    }

    public void setResistanceCharacters2(String resistanceCharacters2) {
        this.resistanceCharacters2 = resistanceCharacters2;
    }

    public String getResistanceCharacters3() {
        return resistanceCharacters3;
    }

    public void setResistanceCharacters3(String resistanceCharacters3) {
        this.resistanceCharacters3 = resistanceCharacters3;
    }

    public String getComprehensiveResistance() {
        return comprehensiveResistance;
    }

    public void setComprehensiveResistance(String comprehensiveResistance) {
        this.comprehensiveResistance = comprehensiveResistance;
    }

    public YearBiotic(Long year, Long ustilagoMaydis, Long maizeEarRot, Long maizeSheathBlight, Long southernCornRust, Long leafSpotDisease, Long maizeBorer, String maizeStalkRot, String maizeRoughDwarfDisease, String southernCornRustTxt, String northernLeafBlight, String maizeDwarfMosaicDisease, String maizeAlbinism, String physodermaMaydis, String grayLeafSpot, String earKernelRot, String southernLeafBlight, String graminearumStalkRot, String pythiumStalkRot, String fGraminearum, String fVerticillioides, String aphis, String borerResistance, String treatmentsApplied, String resistanceCharacters1, String resistanceCharacters2, String resistanceCharacters3, String comprehensiveResistance) {
        this.year = year;
        this.ustilagoMaydis = ustilagoMaydis;
        this.maizeEarRot = maizeEarRot;
        this.maizeSheathBlight = maizeSheathBlight;
        this.southernCornRust = southernCornRust;
        this.leafSpotDisease = leafSpotDisease;
        this.maizeBorer = maizeBorer;
        this.maizeStalkRot = maizeStalkRot;
        this.maizeRoughDwarfDisease = maizeRoughDwarfDisease;
        this.southernCornRustTxt = southernCornRustTxt;
        this.northernLeafBlight = northernLeafBlight;
        this.maizeDwarfMosaicDisease = maizeDwarfMosaicDisease;
        this.maizeAlbinism = maizeAlbinism;
        this.physodermaMaydis = physodermaMaydis;
        this.grayLeafSpot = grayLeafSpot;
        this.earKernelRot = earKernelRot;
        this.southernLeafBlight = southernLeafBlight;
        this.graminearumStalkRot = graminearumStalkRot;
        this.pythiumStalkRot = pythiumStalkRot;
        this.fGraminearum = fGraminearum;
        this.fVerticillioides = fVerticillioides;
        this.aphis = aphis;
        this.borerResistance = borerResistance;
        this.treatmentsApplied = treatmentsApplied;
        this.resistanceCharacters1 = resistanceCharacters1;
        this.resistanceCharacters2 = resistanceCharacters2;
        this.resistanceCharacters3 = resistanceCharacters3;
        this.comprehensiveResistance = comprehensiveResistance;
    }
}
