package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;

import java.math.BigDecimal;

public class YearYield {
    private Long year;

    /** 籽粒长 */
    @Excel(name = "籽粒长")
    private BigDecimal grainLength;

    /** 籽粒宽 */
    @Excel(name = "籽粒宽")
    private BigDecimal grainWidth;

    /** 穗长 */
    @Excel(name = "穗长")
    private BigDecimal earLength;

    /** 穗宽 */
    @Excel(name = "穗宽")
    private BigDecimal earDiameter;

    /** 穗行数 */
    @Excel(name = "穗行数")
    private BigDecimal kernelRowNumber;

    /** 行粒数 */
    @Excel(name = "行粒数")
    private BigDecimal kernelNumbersPerRow;

    /** 百粒重 */
    @Excel(name = "百粒重")
    private BigDecimal grainWeight;

    /** 小区标准产量 */
    @Excel(name = "小区标准产量")
    private BigDecimal yield;

    /** 穗粒数 */
    @Excel(name = "穗粒数")
    private Long kernelNumbersPerEar;

    /** 穗粒重 */
    @Excel(name = "穗粒重")
    private BigDecimal earKernelWeight;

    /** 籽粒含水量 */
    @Excel(name = "籽粒含水量")
    private BigDecimal grainWaterContent;

    /** 出籽率 */
    @Excel(name = "出籽率")
    private BigDecimal kernelPercentage;

    public YearYield() {
    }

    public YearYield(Long year, BigDecimal grainLength, BigDecimal grainWidth, BigDecimal earLength, BigDecimal earDiameter, BigDecimal kernelRowNumber, BigDecimal kernelNumbersPerRow, BigDecimal grainWeight, BigDecimal yield, Long kernelNumbersPerEar, BigDecimal earKernelWeight, BigDecimal grainWaterContent, BigDecimal kernelPercentage) {
        this.year = year;
        this.grainLength = grainLength;
        this.grainWidth = grainWidth;
        this.earLength = earLength;
        this.earDiameter = earDiameter;
        this.kernelRowNumber = kernelRowNumber;
        this.kernelNumbersPerRow = kernelNumbersPerRow;
        this.grainWeight = grainWeight;
        this.yield = yield;
        this.kernelNumbersPerEar = kernelNumbersPerEar;
        this.earKernelWeight = earKernelWeight;
        this.grainWaterContent = grainWaterContent;
        this.kernelPercentage = kernelPercentage;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public BigDecimal getGrainLength() {
        return grainLength;
    }

    public void setGrainLength(BigDecimal grainLength) {
        this.grainLength = grainLength;
    }

    public BigDecimal getGrainWidth() {
        return grainWidth;
    }

    public void setGrainWidth(BigDecimal grainWidth) {
        this.grainWidth = grainWidth;
    }

    public BigDecimal getEarLength() {
        return earLength;
    }

    public void setEarLength(BigDecimal earLength) {
        this.earLength = earLength;
    }

    public BigDecimal getEarDiameter() {
        return earDiameter;
    }

    public void setEarDiameter(BigDecimal earDiameter) {
        this.earDiameter = earDiameter;
    }

    public BigDecimal getKernelRowNumber() {
        return kernelRowNumber;
    }

    public void setKernelRowNumber(BigDecimal kernelRowNumber) {
        this.kernelRowNumber = kernelRowNumber;
    }

    public BigDecimal getKernelNumbersPerRow() {
        return kernelNumbersPerRow;
    }

    public void setKernelNumbersPerRow(BigDecimal kernelNumbersPerRow) {
        this.kernelNumbersPerRow = kernelNumbersPerRow;
    }

    public BigDecimal getGrainWeight() {
        return grainWeight;
    }

    public void setGrainWeight(BigDecimal grainWeight) {
        this.grainWeight = grainWeight;
    }

    public BigDecimal getYield() {
        return yield;
    }

    public void setYield(BigDecimal yield) {
        this.yield = yield;
    }

    public Long getKernelNumbersPerEar() {
        return kernelNumbersPerEar;
    }

    public void setKernelNumbersPerEar(Long kernelNumbersPerEar) {
        this.kernelNumbersPerEar = kernelNumbersPerEar;
    }

    public BigDecimal getEarKernelWeight() {
        return earKernelWeight;
    }

    public void setEarKernelWeight(BigDecimal earKernelWeight) {
        this.earKernelWeight = earKernelWeight;
    }

    public BigDecimal getGrainWaterContent() {
        return grainWaterContent;
    }

    public void setGrainWaterContent(BigDecimal grainWaterContent) {
        this.grainWaterContent = grainWaterContent;
    }

    public BigDecimal getKernelPercentage() {
        return kernelPercentage;
    }

    public void setKernelPercentage(BigDecimal kernelPercentage) {
        this.kernelPercentage = kernelPercentage;
    }
}
