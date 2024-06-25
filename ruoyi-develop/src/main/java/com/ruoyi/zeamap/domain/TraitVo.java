package com.ruoyi.zeamap.domain;

public class TraitVo {
    private String pedigree;
    private String pedigreesource1;
    private String pedigreesource2;
    private String trait;

    public String getPedigree() {
        return pedigree;
    }

    public void setPedigree(String pedigree) {
        this.pedigree = pedigree;
    }

    public String getPedigreesource1() {
        return pedigreesource1;
    }

    public void setPedigreesource1(String pedigreesource1) {
        this.pedigreesource1 = pedigreesource1;
    }

    public String getPedigreesource2() {
        return pedigreesource2;
    }

    public void setPedigreesource2(String pedigreesource2) {
        this.pedigreesource2 = pedigreesource2;
    }

    public String getTrait() {
        return trait;
    }

    public void setTrait(String trait) {
        this.trait = trait;
    }

    public TraitVo(String pedigree, String pedigreesource1, String pedigreesource2, String trait) {
        this.pedigree = pedigree;
        this.pedigreesource1 = pedigreesource1;
        this.pedigreesource2 = pedigreesource2;
        this.trait = trait;
    }

    public TraitVo() {
    }


}
