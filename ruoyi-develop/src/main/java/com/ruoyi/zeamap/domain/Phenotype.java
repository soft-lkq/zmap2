package com.ruoyi.zeamap.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * phenotype对象 phenotype
 * 
 * @author wj
 * @date 2023-10-16
 */
public class Phenotype extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  系谱内部码 */
    private Long code;

    /** 系谱 */
    @Excel(name = "系谱")
    private String pedigree;

    /** 新来源 */
    @Excel(name = "新来源")
    private String newsource;

    /** 旧来源 */
    @Excel(name = "旧来源")
    private String pastsource;

    /** 年份 */
    @Excel(name = "年份")
    private Long year;

    /** 地点 */
    @Excel(name = "地点")
    private String location;

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

    /** 株高 */
    @Excel(name = "株高")
    private BigDecimal height;

    /** 穗位 */
    @Excel(name = "穗位")
    private BigDecimal earheight;

    /** 雄穗分枝数 */
    @Excel(name = "雄穗分枝数")
    private Long malespikes;

    /** 雄花主轴长度 */
    @Excel(name = "雄花主轴长度")
    private BigDecimal spindlelength;

    /** 穗上叶长 */
    @Excel(name = "穗上叶长")
    private BigDecimal leaflength;

    /** 穗上叶宽 */
    @Excel(name = "穗上叶宽")
    private BigDecimal leafwidth;

    /** 茎粗 */
    @Excel(name = "茎粗")
    private BigDecimal stemdiameter;

    /** 倒伏倒折率之和 */
    @Excel(name = "倒伏倒折率之和")
    private BigDecimal rates;

    /** 锈病 */
    @Excel(name = "锈病")
    private Long rust;

    /** 茎腐病 */
    @Excel(name = "茎腐病")
    private BigDecimal stemrot;

    /** 粗缩 */
    @Excel(name = "粗缩")
    private BigDecimal roughdwarf;

    /** 空杆 */
    @Excel(name = "空杆")
    private BigDecimal hollow;

    /** 株数 */
    @Excel(name = "株数")
    private Long plantsnum;

    /** 黑粉 */
    @Excel(name = "黑粉")
    private Long blackpowder;

    /** 果穗表现 */
    @Excel(name = "果穗表现")
    private String expression;

    /** 穗长 */
    @Excel(name = "穗长")
    private BigDecimal spikelength;

    /** 穗宽 */
    @Excel(name = "穗宽")
    private BigDecimal spikewidth;

    /** 穗行数 */
    @Excel(name = "穗行数")
    private BigDecimal row;

    /** 行粒数 */
    @Excel(name = "行粒数")
    private BigDecimal kernels;

    /** 轴色 */
    @Excel(name = "轴色")
    private String 
axiscolor;

    /** 百粒重 */
    @Excel(name = "百粒重")
    private BigDecimal grainweight;

    /** 籽粒长 */
    @Excel(name = "籽粒长")
    private BigDecimal 
grainlength;

    /** 籽粒宽 */
    @Excel(name = "籽粒宽")
    private BigDecimal 
grainwidth;

    /** 小区标准产量 */
    @Excel(name = "小区标准产量")
    private BigDecimal yield;

    /** 出籽率 */
    @Excel(name = "出籽率")
    private BigDecimal seedyield;

    public void setCode(Long code) 
    {
        this.code = code;
    }

    public Long getCode() 
    {
        return code;
    }
    public void setPedigree(String pedigree) 
    {
        this.pedigree = pedigree;
    }

    public String getPedigree() 
    {
        return pedigree;
    }
    public void setNewsource(String newsource) 
    {
        this.newsource = newsource;
    }

    public String getNewsource() 
    {
        return newsource;
    }
    public void setPastsource(String pastsource) 
    {
        this.pastsource = pastsource;
    }

    public String getPastsource() 
    {
        return pastsource;
    }
    public void setYear(Long year) 
    {
        this.year = year;
    }

    public Long getYear() 
    {
        return year;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setSilking(Date silking) 
    {
        this.silking = silking;
    }

    public Date getSilking() 
    {
        return silking;
    }
    public void setDispersal(Date dispersal) 
    {
        this.dispersal = dispersal;
    }

    public Date getDispersal() 
    {
        return dispersal;
    }
    public void setMature(Date mature) 
    {
        this.mature = mature;
    }

    public Date getMature() 
    {
        return mature;
    }
    public void setHeight(BigDecimal height) 
    {
        this.height = height;
    }

    public BigDecimal getHeight() 
    {
        return height;
    }
    public void setEarheight(BigDecimal earheight) 
    {
        this.earheight = earheight;
    }

    public BigDecimal getEarheight() 
    {
        return earheight;
    }
    public void setMalespikes(Long malespikes) 
    {
        this.malespikes = malespikes;
    }

    public Long getMalespikes() 
    {
        return malespikes;
    }
    public void setSpindlelength(BigDecimal spindlelength) 
    {
        this.spindlelength = spindlelength;
    }

    public BigDecimal getSpindlelength() 
    {
        return spindlelength;
    }
    public void setLeaflength(BigDecimal leaflength) 
    {
        this.leaflength = leaflength;
    }

    public BigDecimal getLeaflength() 
    {
        return leaflength;
    }
    public void setLeafwidth(BigDecimal leafwidth) 
    {
        this.leafwidth = leafwidth;
    }

    public BigDecimal getLeafwidth() 
    {
        return leafwidth;
    }
    public void setStemdiameter(BigDecimal stemdiameter) 
    {
        this.stemdiameter = stemdiameter;
    }

    public BigDecimal getStemdiameter() 
    {
        return stemdiameter;
    }
    public void setRates(BigDecimal rates) 
    {
        this.rates = rates;
    }

    public BigDecimal getRates() 
    {
        return rates;
    }
    public void setRust(Long rust) 
    {
        this.rust = rust;
    }

    public Long getRust() 
    {
        return rust;
    }
    public void setStemrot(BigDecimal stemrot) 
    {
        this.stemrot = stemrot;
    }

    public BigDecimal getStemrot() 
    {
        return stemrot;
    }
    public void setRoughdwarf(BigDecimal roughdwarf) 
    {
        this.roughdwarf = roughdwarf;
    }

    public BigDecimal getRoughdwarf() 
    {
        return roughdwarf;
    }
    public void setHollow(BigDecimal hollow) 
    {
        this.hollow = hollow;
    }

    public BigDecimal getHollow() 
    {
        return hollow;
    }
    public void setPlantsnum(Long plantsnum) 
    {
        this.plantsnum = plantsnum;
    }

    public Long getPlantsnum() 
    {
        return plantsnum;
    }
    public void setBlackpowder(Long blackpowder) 
    {
        this.blackpowder = blackpowder;
    }

    public Long getBlackpowder() 
    {
        return blackpowder;
    }
    public void setExpression(String expression) 
    {
        this.expression = expression;
    }

    public String getExpression() 
    {
        return expression;
    }
    public void setSpikelength(BigDecimal spikelength) 
    {
        this.spikelength = spikelength;
    }

    public BigDecimal getSpikelength() 
    {
        return spikelength;
    }
    public void setSpikewidth(BigDecimal spikewidth) 
    {
        this.spikewidth = spikewidth;
    }

    public BigDecimal getSpikewidth() 
    {
        return spikewidth;
    }
    public void setRow(BigDecimal row) 
    {
        this.row = row;
    }

    public BigDecimal getRow() 
    {
        return row;
    }
    public void setKernels(BigDecimal kernels) 
    {
        this.kernels = kernels;
    }

    public BigDecimal getKernels() 
    {
        return kernels;
    }
    public void setaxiscolor(String axiscolor)
    {
        this.axiscolor = axiscolor;
    }

    public String getaxiscolor()
    {
        return axiscolor;
    }
    public void setGrainweight(BigDecimal grainweight) 
    {
        this.grainweight = grainweight;
    }

    public BigDecimal getGrainweight() 
    {
        return grainweight;
    }
    public void setgrainlength(BigDecimal grainlength)
    {
        this.grainlength = grainlength;
    }

    public BigDecimal getgrainlength()
    {
        return grainlength;
    }
    public void setgrainwidth(BigDecimal grainwidth)
    {
        this.grainwidth = grainwidth;
    }

    public BigDecimal getgrainwidth()
    {
        return grainwidth;
    }
    public void setYield(BigDecimal yield) 
    {
        this.yield = yield;
    }

    public BigDecimal getYield() 
    {
        return yield;
    }
    public void setSeedyield(BigDecimal seedyield) 
    {
        this.seedyield = seedyield;
    }

    public BigDecimal getSeedyield() 
    {
        return seedyield;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("code", getCode())
            .append("pedigree", getPedigree())
            .append("newsource", getNewsource())
            .append("pastsource", getPastsource())
            .append("year", getYear())
            .append("location", getLocation())
            .append("silking", getSilking())
            .append("dispersal", getDispersal())
            .append("mature", getMature())
            .append("height", getHeight())
            .append("earheight", getEarheight())
            .append("malespikes", getMalespikes())
            .append("spindlelength", getSpindlelength())
            .append("leaflength", getLeaflength())
            .append("leafwidth", getLeafwidth())
            .append("stemdiameter", getStemdiameter())
            .append("rates", getRates())
            .append("rust", getRust())
            .append("stemrot", getStemrot())
            .append("roughdwarf", getRoughdwarf())
            .append("hollow", getHollow())
            .append("plantsnum", getPlantsnum())
            .append("blackpowder", getBlackpowder())
            .append("expression", getExpression())
            .append("spikelength", getSpikelength())
            .append("spikewidth", getSpikewidth())
            .append("row", getRow())
            .append("kernels", getKernels())
            .append("axiscolor", getaxiscolor())
            .append("grainweight", getGrainweight())
            .append("grainlength", getgrainlength())
            .append("grainwidth", getgrainwidth())
            .append("yield", getYield())
            .append("seedyield", getSeedyield())
            .toString();
    }
}
