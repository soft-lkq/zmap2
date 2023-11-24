package com.ruoyi.zeamap.domain;

public class GeVo {
    private Long year;
    private String location;
    private String trait;

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

    public String getTrait() {
        return trait;
    }

    public void setTrait(String trait) {
        this.trait = trait;
    }

    public GeVo() {
    }

    public GeVo(Long year, String location, String trait) {
        this.year = year;
        this.location = location;
        this.trait = trait;
    }
}
