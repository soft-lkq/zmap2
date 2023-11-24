package com.ruoyi.zeamap.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;

import java.util.Date;

public class BxDateVo {
    /** 吐丝期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "吐丝期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date silking;

    /** 散粉期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "散粉期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dispersal;

    /** 成熟期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "成熟期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date mature;

    public BxDateVo(Date silking, Date dispersal, Date mature) {
        this.silking = silking;
        this.dispersal = dispersal;
        this.mature = mature;
    }

    @Override
    public String toString() {
        return "BxDateVo{" +
                "silking=" + silking +
                ", dispersal=" + dispersal +
                ", mature=" + mature +
                '}';
    }

    public Date getSilking() {
        return silking;
    }

    public void setSilking(Date silking) {
        this.silking = silking;
    }

    public Date getDispersal() {
        return dispersal;
    }

    public void setDispersal(Date dispersal) {
        this.dispersal = dispersal;
    }

    public Date getMature() {
        return mature;
    }

    public void setMature(Date mature) {
        this.mature = mature;
    }

    public BxDateVo() {
    }
}
