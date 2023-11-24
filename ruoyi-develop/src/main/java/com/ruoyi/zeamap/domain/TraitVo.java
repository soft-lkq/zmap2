package com.ruoyi.zeamap.domain;

public class TraitVo {
    private String pedigree;
    private String newSource;
    private String pastSource;
    private String trait;

    public String getPedigree() {
        return pedigree;
    }

    public void setPedigree(String pedigree) {
        this.pedigree = pedigree;
    }

    public String getNewSource() {
        return newSource;
    }

    public void setNewSource(String newSource) {
        this.newSource = newSource;
    }

    public String getPastSource() {
        return pastSource;
    }

    public void setPastSource(String pastSource) {
        this.pastSource = pastSource;
    }

    public String getTrait() {
        return trait;
    }

    public void setTrait(String trait) {
        this.trait = trait;
    }

    public TraitVo(String pedigree, String newSource, String pastSource, String trait) {
        this.pedigree = pedigree;
        this.newSource = newSource;
        this.pastSource = pastSource;
        this.trait = trait;
    }

    public TraitVo() {
    }


}
