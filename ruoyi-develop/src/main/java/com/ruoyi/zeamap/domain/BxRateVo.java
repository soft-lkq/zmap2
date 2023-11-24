package com.ruoyi.zeamap.domain;

public class BxRateVo {
    private double rates;
    private double stemrot;
    private double roughdwarf;

    public double getRates() {
        return rates;
    }

    public void setRates(double rates) {
        this.rates = rates;
    }

    public double getStemrot() {
        return stemrot;
    }

    public void setStemrot(double stemrot) {
        this.stemrot = stemrot;
    }

    public double getRoughdwarf() {
        return roughdwarf;
    }

    public void setRoughdwarf(double roughdwarf) {
        this.roughdwarf = roughdwarf;
    }

    public BxRateVo() {
    }

    public BxRateVo(double rates, double stemrot, double roughdwarf) {
        this.rates = rates;
        this.stemrot = stemrot;
        this.roughdwarf = roughdwarf;
    }
}
