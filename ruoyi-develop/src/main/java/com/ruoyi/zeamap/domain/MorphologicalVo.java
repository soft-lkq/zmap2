package com.ruoyi.zeamap.domain;

/**
 * @program: ruoyi
 * @description:
 * @author: wj
 **/
public class MorphologicalVo {
    private double height;
    private double stemDiameter;
    private double earHeight;
    private double leafLength;
    private double leafWidth;
    private double maleSpikes;
    private double spindleLength;

    @Override
    public String toString() {
        return "MorphologicalVo{" +
                "height=" + height +
                ", stemDiameter=" + stemDiameter +
                ", earHeight=" + earHeight +
                ", leafLength=" + leafLength +
                ", leafWidth=" + leafWidth +
                ", maleSpikes=" + maleSpikes +
                ", spindleLength=" + spindleLength +
                '}';
    }

    public MorphologicalVo() {
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getStemDiameter() {
        return stemDiameter;
    }

    public void setStemDiameter(double stemDiameter) {
        this.stemDiameter = stemDiameter;
    }

    public double getEarHeight() {
        return earHeight;
    }

    public void setEarHeight(double earHeight) {
        this.earHeight = earHeight;
    }

    public double getLeafLength() {
        return leafLength;
    }

    public void setLeafLength(double leafLength) {
        this.leafLength = leafLength;
    }

    public double getLeafWidth() {
        return leafWidth;
    }

    public void setLeafWidth(double leafWidth) {
        this.leafWidth = leafWidth;
    }

    public double getMaleSpikes() {
        return maleSpikes;
    }

    public void setMaleSpikes(double maleSpikes) {
        this.maleSpikes = maleSpikes;
    }

    public double getSpindleLength() {
        return spindleLength;
    }

    public void setSpindleLength(double spindleLength) {
        this.spindleLength = spindleLength;
    }

    public MorphologicalVo(double height, double stemDiameter, double earHeight, double leafLength, double leafWidth, double maleSpikes, double spindleLength) {
        this.height = height;
        this.stemDiameter = stemDiameter;
        this.earHeight = earHeight;
        this.leafLength = leafLength;
        this.leafWidth = leafWidth;
        this.maleSpikes = maleSpikes;
        this.spindleLength = spindleLength;
    }
}
