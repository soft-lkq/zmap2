package com.ruoyi.zeamap.domain;

public class GeVo {
    private String pedigree;
    private Long year;
    private String location;
    private String traits;

    public GeVo(String pedigree, Long year, String location, String traits) {
        this.pedigree = pedigree;
        this.year = year;
        this.location = location;
        this.traits = traits;
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

    public String getTrait() {
        return traits;
    }

    public void setTrait(String trait) {
        this.traits = trait;
    }

    public GeVo() {
    }

    public String getPedigree() {
        return pedigree;
    }

    public void setPedigree(String pedigree) {
        this.pedigree = pedigree;
    }
}
