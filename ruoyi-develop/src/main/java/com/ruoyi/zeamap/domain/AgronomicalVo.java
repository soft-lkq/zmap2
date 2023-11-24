package com.ruoyi.zeamap.domain;

public class AgronomicalVo {
    private double spikeLength;
    private double spikeWidth;
    private double row;
    private double kernels;
    private double grainWeight;
    private double grainLength;
    private double grainWidth;
    private double yield;
    private double seedYield;

    @Override
    public String toString() {
        return "AgronomicalVo{" +
                "spikeLength=" + spikeLength +
                ", spikeWidth=" + spikeWidth +
                ", row=" + row +
                ", kernels=" + kernels +
                ", grainWeight=" + grainWeight +
                ", grainLength=" + grainLength +
                ", grainWidth=" + grainWidth +
                ", yield=" + yield +
                ", seedYield=" + seedYield +
                '}';
    }

    public double getSpikeLength() {
        return spikeLength;
    }

    public void setSpikeLength(double spikeLength) {
        this.spikeLength = spikeLength;
    }

    public double getSpikeWidth() {
        return spikeWidth;
    }

    public void setSpikeWidth(double spikeWidth) {
        this.spikeWidth = spikeWidth;
    }

    public double getRow() {
        return row;
    }

    public void setRow(double row) {
        this.row = row;
    }

    public double getKernels() {
        return kernels;
    }

    public void setKernels(double kernels) {
        this.kernels = kernels;
    }

    public double getGrainWeight() {
        return grainWeight;
    }

    public void setGrainWeight(double grainWeight) {
        this.grainWeight = grainWeight;
    }

    public double getGrainLength() {
        return grainLength;
    }

    public void setGrainLength(double grainLength) {
        this.grainLength = grainLength;
    }

    public double getGrainWidth() {
        return grainWidth;
    }

    public void setGrainWidth(double grainWidth) {
        this.grainWidth = grainWidth;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

    public double getSeedYield() {
        return seedYield;
    }

    public void setSeedYield(double seedYield) {
        this.seedYield = seedYield;
    }

    public AgronomicalVo() {
    }

    public AgronomicalVo(double spikeLength, double spikeWidth, double row, double kernels, double grainWeight, double grainLength, double grainWidth, double yield, double seedYield) {
        this.spikeLength = spikeLength;
        this.spikeWidth = spikeWidth;
        this.row = row;
        this.kernels = kernels;
        this.grainWeight = grainWeight;
        this.grainLength = grainLength;
        this.grainWidth = grainWidth;
        this.yield = yield;
        this.seedYield = seedYield;
    }
}
