package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;

public class YearAgr {
    private Long year;
    /**
     * 田评
     */
    @Excel(name = "田评")
    private String fieldEvaluation;

    /**
     * 田评2
     */
    @Excel(name = "田评2")
    private String fieldEvaluation2;

    /**
     * 室评
     */
    @Excel(name = "室评")
    private String laboratoryEvaluation;

    /**
     * 室评2
     */
    @Excel(name = "室评2")
    private String laboratoryEvaluation2;

    /**
     * 沾光
     */
    @Excel(name = "沾光")
    private String benefitial;

    /**
     * 空杆数
     */
    @Excel(name = "空杆数")
    private Long emptyStalkNumber;

    /**
     * 入选株数
     */
    @Excel(name = "入选株数")
    private Long selectedPlantNumber;

    /**
     * 株数
     */
    @Excel(name = "株数")
    private Long plantNumber;

    /**
     * 保绿度
     */
    @Excel(name = "保绿度")
    private String leafStayGreen;

    /**
     * 授粉计划1
     */
    @Excel(name = "授粉计划1")
    private String pollinationPlan1;

    /**
     * 授粉计划2
     */
    @Excel(name = "授粉计划2")
    private String pollinationPlan2;

    /**
     * 双穗数
     */
    @Excel(name = "双穗数")
    private Long doubleEarNumber;

    /**
     * 翌年处理意见
     */
    @Excel(name = "翌年处理意见")
    private String decisionStrip;

    /**
     * 决策来源
     */
    @Excel(name = "决策来源")
    private String decisionSource;

    /**
     * 位点差
     */
    @Excel(name = "位点差")
    private String siteDiscrepancy;

    /**
     * 测试种1
     */
    @Excel(name = "测试种1")
    private String tests1;

    /**
     * 测试种2
     */
    @Excel(name = "测试种2")
    private String tests2;

    /**
     * 散粉吐丝间隔
     */
    @Excel(name = "散粉吐丝间隔")
    private Long antherTasselInterval;

    public YearAgr() {
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getFieldEvaluation() {
        return fieldEvaluation;
    }

    public void setFieldEvaluation(String fieldEvaluation) {
        this.fieldEvaluation = fieldEvaluation;
    }

    public String getFieldEvaluation2() {
        return fieldEvaluation2;
    }

    public void setFieldEvaluation2(String fieldEvaluation2) {
        this.fieldEvaluation2 = fieldEvaluation2;
    }

    public String getLaboratoryEvaluation() {
        return laboratoryEvaluation;
    }

    public void setLaboratoryEvaluation(String laboratoryEvaluation) {
        this.laboratoryEvaluation = laboratoryEvaluation;
    }

    public String getLaboratoryEvaluation2() {
        return laboratoryEvaluation2;
    }

    public void setLaboratoryEvaluation2(String laboratoryEvaluation2) {
        this.laboratoryEvaluation2 = laboratoryEvaluation2;
    }

    public String getBenefitial() {
        return benefitial;
    }

    public void setBenefitial(String benefitial) {
        this.benefitial = benefitial;
    }

    public Long getEmptyStalkNumber() {
        return emptyStalkNumber;
    }

    public void setEmptyStalkNumber(Long emptyStalkNumber) {
        this.emptyStalkNumber = emptyStalkNumber;
    }

    public Long getSelectedPlantNumber() {
        return selectedPlantNumber;
    }

    public void setSelectedPlantNumber(Long selectedPlantNumber) {
        this.selectedPlantNumber = selectedPlantNumber;
    }

    public Long getPlantNumber() {
        return plantNumber;
    }

    public void setPlantNumber(Long plantNumber) {
        this.plantNumber = plantNumber;
    }

    public String getLeafStayGreen() {
        return leafStayGreen;
    }

    public void setLeafStayGreen(String leafStayGreen) {
        this.leafStayGreen = leafStayGreen;
    }

    public String getPollinationPlan1() {
        return pollinationPlan1;
    }

    public void setPollinationPlan1(String pollinationPlan1) {
        this.pollinationPlan1 = pollinationPlan1;
    }

    public String getPollinationPlan2() {
        return pollinationPlan2;
    }

    public void setPollinationPlan2(String pollinationPlan2) {
        this.pollinationPlan2 = pollinationPlan2;
    }

    public Long getDoubleEarNumber() {
        return doubleEarNumber;
    }

    public void setDoubleEarNumber(Long doubleEarNumber) {
        this.doubleEarNumber = doubleEarNumber;
    }

    public String getDecisionStrip() {
        return decisionStrip;
    }

    public void setDecisionStrip(String decisionStrip) {
        this.decisionStrip = decisionStrip;
    }

    public String getDecisionSource() {
        return decisionSource;
    }

    public void setDecisionSource(String decisionSource) {
        this.decisionSource = decisionSource;
    }

    public String getSiteDiscrepancy() {
        return siteDiscrepancy;
    }

    public void setSiteDiscrepancy(String siteDiscrepancy) {
        this.siteDiscrepancy = siteDiscrepancy;
    }

    public String getTests1() {
        return tests1;
    }

    public void setTests1(String tests1) {
        this.tests1 = tests1;
    }

    public String getTests2() {
        return tests2;
    }

    public void setTests2(String tests2) {
        this.tests2 = tests2;
    }

    public Long getAntherTasselInterval() {
        return antherTasselInterval;
    }

    public void setAntherTasselInterval(Long antherTasselInterval) {
        this.antherTasselInterval = antherTasselInterval;
    }

    public YearAgr(Long year, String fieldEvaluation, String fieldEvaluation2, String laboratoryEvaluation, String laboratoryEvaluation2, String benefitial, Long emptyStalkNumber, Long selectedPlantNumber, Long plantNumber, String leafStayGreen, String pollinationPlan1, String pollinationPlan2, Long doubleEarNumber, String decisionStrip, String decisionSource, String siteDiscrepancy, String tests1, String tests2, Long antherTasselInterval) {
        this.year = year;
        this.fieldEvaluation = fieldEvaluation;
        this.fieldEvaluation2 = fieldEvaluation2;
        this.laboratoryEvaluation = laboratoryEvaluation;
        this.laboratoryEvaluation2 = laboratoryEvaluation2;
        this.benefitial = benefitial;
        this.emptyStalkNumber = emptyStalkNumber;
        this.selectedPlantNumber = selectedPlantNumber;
        this.plantNumber = plantNumber;
        this.leafStayGreen = leafStayGreen;
        this.pollinationPlan1 = pollinationPlan1;
        this.pollinationPlan2 = pollinationPlan2;
        this.doubleEarNumber = doubleEarNumber;
        this.decisionStrip = decisionStrip;
        this.decisionSource = decisionSource;
        this.siteDiscrepancy = siteDiscrepancy;
        this.tests1 = tests1;
        this.tests2 = tests2;
        this.antherTasselInterval = antherTasselInterval;
    }
}
