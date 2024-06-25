package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;

import java.math.BigDecimal;

/**
 * @program: ruoyi
 * @description:
 * @author: wj
 **/
public class MorphologicalVo{
    private Long pedid;

    /**
     * 系谱
     */
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

    /**
     * 年份
     */
    @Excel(name = "年份")
    private Long year;

    /**
     * 试验地点
     */
    @Excel(name = "试验地点")
    private String location;

    /**
     * 穗上叶长
     */
    @Excel(name = "穗上叶长")
    private BigDecimal leafLength;

    /**
     * 穗上叶宽
     */
    @Excel(name = "穗上叶宽")
    private BigDecimal leafWidth;

    /**
     * 株高
     */
    @Excel(name = "株高")
    private BigDecimal plantHeight;

    /**
     * 穗位
     */
    @Excel(name = "穗位")
    private BigDecimal earHeight;

    /**
     * 雄穗分枝数
     */
    @Excel(name = "雄穗分枝数")
    private BigDecimal tasselBranchNumber;

    /**
     * 根层
     */
    @Excel(name = "根层")
    private String rootLayer;

    /**
     * 成株叶片数
     */
    @Excel(name = "成株叶片数")
    private Long leafNumber1;

    /**
     * 茎粗
     */
    @Excel(name = "茎粗")
    private BigDecimal stemDiameter;


    /**
     * 花丝花青甙显色
     */
    @Excel(name = "花丝花青甙显色")
    private String silkColor;

    /**
     * 花药花青甙显色
     */
    @Excel(name = "花药花青甙显色")
    private String antherColor;



    /**
     * 穗轴颜色
     */
    @Excel(name = "穗轴颜色")
    private String rachisColor;

    /**
     * 籽粒颜色
     */
    @Excel(name = "籽粒颜色")
    private String grainColor;


    public MorphologicalVo() {
    }

    public Long getPedid() {
        return pedid;
    }

    public void setPedid(Long pedid) {
        this.pedid = pedid;
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

    public BigDecimal getLeafLength() {
        return leafLength;
    }

    public void setLeafLength(BigDecimal leafLength) {
        this.leafLength = leafLength;
    }

    public BigDecimal getLeafWidth() {
        return leafWidth;
    }

    public void setLeafWidth(BigDecimal leafWidth) {
        this.leafWidth = leafWidth;
    }

    public BigDecimal getPlantHeight() {
        return plantHeight;
    }

    public void setPlantHeight(BigDecimal plantHeight) {
        this.plantHeight = plantHeight;
    }

    public BigDecimal getEarHeight() {
        return earHeight;
    }

    public void setEarHeight(BigDecimal earHeight) {
        this.earHeight = earHeight;
    }

    public BigDecimal getTasselBranchNumber() {
        return tasselBranchNumber;
    }

    public void setTasselBranchNumber(BigDecimal tasselBranchNumber) {
        this.tasselBranchNumber = tasselBranchNumber;
    }

    public String getRootLayer() {
        return rootLayer;
    }

    public void setRootLayer(String rootLayer) {
        this.rootLayer = rootLayer;
    }

    public Long getLeafNumber1() {
        return leafNumber1;
    }

    public void setLeafNumber1(Long leafNumber1) {
        this.leafNumber1 = leafNumber1;
    }

    public BigDecimal getStemDiameter() {
        return stemDiameter;
    }

    public void setStemDiameter(BigDecimal stemDiameter) {
        this.stemDiameter = stemDiameter;
    }

    public String getSilkColor() {
        return silkColor;
    }

    public void setSilkColor(String silkColor) {
        this.silkColor = silkColor;
    }

    public String getAntherColor() {
        return antherColor;
    }

    public void setAntherColor(String antherColor) {
        this.antherColor = antherColor;
    }

    public String getRachisColor() {
        return rachisColor;
    }

    public void setRachisColor(String rachisColor) {
        this.rachisColor = rachisColor;
    }

    public String getGrainColor() {
        return grainColor;
    }

    public void setGrainColor(String grainColor) {
        this.grainColor = grainColor;
    }


    public MorphologicalVo(Long pedid, String pedigree, String pedigreeSource1, String pedigreeSource2, Long year, String location, BigDecimal leafLength, BigDecimal leafWidth, BigDecimal plantHeight, BigDecimal earHeight, BigDecimal tasselBranchNumber, String rootLayer, Long leafNumber1, BigDecimal stemDiameter, String silkColor, String antherColor, String rachisColor, String grainColor) {
        this.pedid = pedid;
        this.pedigree = pedigree;
        this.pedigreeSource1 = pedigreeSource1;
        this.pedigreeSource2 = pedigreeSource2;
        this.year = year;
        this.location = location;
        this.leafLength = leafLength;
        this.leafWidth = leafWidth;
        this.plantHeight = plantHeight;
        this.earHeight = earHeight;
        this.tasselBranchNumber = tasselBranchNumber;
        this.rootLayer = rootLayer;
        this.leafNumber1 = leafNumber1;
        this.stemDiameter = stemDiameter;
        this.silkColor = silkColor;
        this.antherColor = antherColor;
        this.rachisColor = rachisColor;
        this.grainColor = grainColor;
    }

    public MorphologicalVo(BigDecimal leafLength, BigDecimal leafWidth, BigDecimal plantHeight, BigDecimal earHeight, BigDecimal tasselBranchNumber, Long leafNumber1, BigDecimal stemDiameter) {
        this.leafLength = leafLength;
        this.leafWidth = leafWidth;
        this.plantHeight = plantHeight;
        this.earHeight = earHeight;
        this.tasselBranchNumber = tasselBranchNumber;
        this.leafNumber1 = leafNumber1;
        this.stemDiameter = stemDiameter;
    }
}