package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;

public class BxRateVo {
    /**
     * 黑粉
     */
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
     * 大斑病txt
     */
    @Excel(name = "大斑病txt")
    private String northernLeafBlight;

    /**
     * 综合抗性
     */
    @Excel(name = "综合抗性")
    private String comprehensiveResistance;

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

    public String getNorthernLeafBlight() {
        return northernLeafBlight;
    }

    public void setNorthernLeafBlight(String northernLeafBlight) {
        this.northernLeafBlight = northernLeafBlight;
    }

    public String getComprehensiveResistance() {
        return comprehensiveResistance;
    }

    public void setComprehensiveResistance(String comprehensiveResistance) {
        this.comprehensiveResistance = comprehensiveResistance;
    }

    public BxRateVo(Long ustilagoMaydis, Long maizeEarRot, Long maizeSheathBlight, Long southernCornRust, Long leafSpotDisease, Long maizeBorer, String northernLeafBlight, String comprehensiveResistance) {
        this.ustilagoMaydis = ustilagoMaydis;
        this.maizeEarRot = maizeEarRot;
        this.maizeSheathBlight = maizeSheathBlight;
        this.southernCornRust = southernCornRust;
        this.leafSpotDisease = leafSpotDisease;
        this.maizeBorer = maizeBorer;
        this.northernLeafBlight = northernLeafBlight;
        this.comprehensiveResistance = comprehensiveResistance;
    }

    public BxRateVo() {
    }
}
