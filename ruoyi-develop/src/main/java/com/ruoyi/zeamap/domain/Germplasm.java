package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 germplasm
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
public class Germplasm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long germplasmId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String genus;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String species;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String commonName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String comment;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long groupId;

    private Subgroup subgroup;

    public Subgroup getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(Subgroup subgroup) {
        this.subgroup = subgroup;
    }

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long populationId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long latitude;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long longtitude;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String ngbId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String origin;

    public void setGermplasmId(Long germplasmId) 
    {
        this.germplasmId = germplasmId;
    }

    public Long getGermplasmId() 
    {
        return germplasmId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setGenus(String genus) 
    {
        this.genus = genus;
    }

    public String getGenus() 
    {
        return genus;
    }
    public void setSpecies(String species) 
    {
        this.species = species;
    }

    public String getSpecies() 
    {
        return species;
    }
    public void setCommonName(String commonName) 
    {
        this.commonName = commonName;
    }

    public String getCommonName() 
    {
        return commonName;
    }
    public void setComment(String comment) 
    {
        this.comment = comment;
    }

    public String getComment() 
    {
        return comment;
    }
    public void setGroupId(Long groupId) 
    {
        this.groupId = groupId;
    }

    public Long getGroupId() 
    {
        return groupId;
    }
    public void setPopulationId(Long populationId) 
    {
        this.populationId = populationId;
    }

    public Long getPopulationId() 
    {
        return populationId;
    }
    public void setLatitude(Long latitude) 
    {
        this.latitude = latitude;
    }

    public Long getLatitude() 
    {
        return latitude;
    }
    public void setLongtitude(Long longtitude) 
    {
        this.longtitude = longtitude;
    }

    public Long getLongtitude() 
    {
        return longtitude;
    }
    public void setNgbId(String ngbId) 
    {
        this.ngbId = ngbId;
    }

    public String getNgbId() 
    {
        return ngbId;
    }
    public void setOrigin(String origin) 
    {
        this.origin = origin;
    }

    public String getOrigin() 
    {
        return origin;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("germplasmId", getGermplasmId())
            .append("name", getName())
            .append("genus", getGenus())
            .append("species", getSpecies())
            .append("commonName", getCommonName())
            .append("comment", getComment())
            .append("groupId", getGroupId())
            .append("populationId", getPopulationId())
            .append("latitude", getLatitude())
            .append("longtitude", getLongtitude())
            .append("ngbId", getNgbId())
            .append("origin", getOrigin())
                .append("subgroup",getSubgroup())
            .toString();
    }
}
