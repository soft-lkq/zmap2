package com.ruoyi.zeamap.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;

import java.util.Date;

public class BxDateVo {

    /** 抽雄期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "抽雄期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date daysToTassel;

    /** 出苗期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出苗期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date daysToSeedling;

    /** 成熟期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "成熟期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date daysToMaturity;

    /** 播种期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "播种期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date datePlanted;

    /** 生育期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生育期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date growthPeriod;

    /** 散粉期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "散粉期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date daysToAnther;

    /** 吐丝期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "吐丝期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date daysToSilk;

    /** 收获日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收获日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dateHarvested;


    public BxDateVo(Date daysToTassel, Date daysToSeedling, Date daysToMaturity, Date datePlanted, Date growthPeriod, Date daysToAnther, Date daysToSilk, Date dateHarvested) {
        this.daysToTassel = daysToTassel;
        this.daysToSeedling = daysToSeedling;
        this.daysToMaturity = daysToMaturity;
        this.datePlanted = datePlanted;
        this.growthPeriod = growthPeriod;
        this.daysToAnther = daysToAnther;
        this.daysToSilk = daysToSilk;
        this.dateHarvested = dateHarvested;
    }

    public BxDateVo() {
    }

    public Date getDaysToTassel() {
        return daysToTassel;
    }

    public void setDaysToTassel(Date daysToTassel) {
        this.daysToTassel = daysToTassel;
    }

    public Date getDaysToSeedling() {
        return daysToSeedling;
    }

    public void setDaysToSeedling(Date daysToSeedling) {
        this.daysToSeedling = daysToSeedling;
    }

    public Date getDaysToMaturity() {
        return daysToMaturity;
    }

    public void setDaysToMaturity(Date daysToMaturity) {
        this.daysToMaturity = daysToMaturity;
    }

    public Date getDatePlanted() {
        return datePlanted;
    }

    public void setDatePlanted(Date datePlanted) {
        this.datePlanted = datePlanted;
    }

    public Date getGrowthPeriod() {
        return growthPeriod;
    }

    public void setGrowthPeriod(Date growthPeriod) {
        this.growthPeriod = growthPeriod;
    }

    public Date getDaysToAnther() {
        return daysToAnther;
    }

    public void setDaysToAnther(Date daysToAnther) {
        this.daysToAnther = daysToAnther;
    }

    public Date getDaysToSilk() {
        return daysToSilk;
    }

    public void setDaysToSilk(Date daysToSilk) {
        this.daysToSilk = daysToSilk;
    }

    public Date getDateHarvested() {
        return dateHarvested;
    }

    public void setDateHarvested(Date dateHarvested) {
        this.dateHarvested = dateHarvested;
    }

}
