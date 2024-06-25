package com.ruoyi.zeamap.domain;

public class SearchVo {
    private String pedId;
    private String pedigreeSource1;
    private String pedigreeSource2;
    private String pedigree;
    private Long year;
    private String location;
    private String trait;

    public SearchVo(String pedId, String pedigreeSource1, String pedigreeSource2, String pedigree, Long year, String location, String trait) {
        this.pedId = pedId;
        this.pedigreeSource1 = pedigreeSource1;
        this.pedigreeSource2 = pedigreeSource2;
        this.pedigree = pedigree;
        this.year = year;
        this.location = location;
        this.trait = trait;
    }

    public SearchVo() {
    }

    public String getPedId() {
        return pedId;
    }

    public void setPedId(String pedId) {
        this.pedId = pedId;
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

    public String getPedigree() {
        return pedigree;
    }

    public void setPedigree(String pedigree) {
        this.pedigree = pedigree;
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
        return trait;
    }

    public void setTrait(String trait) {
        this.trait = trait;
    }
}
