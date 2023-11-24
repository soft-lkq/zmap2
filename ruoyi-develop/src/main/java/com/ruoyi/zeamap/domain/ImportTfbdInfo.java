package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.persistence.Table;

/**
 * Import对象 tfbd_info
 * 
 * @author ruoyi
 * @date 2023-04-06
 */
@Table(name = "tfbd_info")
public class ImportTfbdInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @Excel(name = "主键")
    private Long tfbdId;

    /** $column.columnComment */
    @Excel(name = "转录因子名称")
    private String name;

    /** $column.columnComment */
    @Excel(name = "基因家族")
    private String family;

    /** $column.columnComment */
    @Excel(name = "简写名字")
    private String simplename;

    /** $column.columnComment */
    @Excel(name = "转录因子在B73v4里的名字")
    private String genev4;

    /** $column.columnComment */
    @Excel(name = "转录因子在B73v3里的名字")
    private String genev3;

    /** $column.columnComment */
    @Excel(name = "分类")
    private String tfClass;

    /** $column.columnComment */
    @Excel(name = "对基因的功能进行的go注释")
    private String enrichGo;

    /** $column.columnComment */
    @Excel(name = "注释信息")
    private String enrichMp;

    /** $column.columnComment */
    @Excel(name = "未知")
    private String atid;

    /** $column.columnComment */
    @Excel(name = "未知")
    private String atsimplename;

    /** $column.columnComment */
    @Excel(name = "描述")
    private String description;

    /** $column.columnComment */
    @Excel(name = "基因的表型")
    private String phenotype;

    /** $column.columnComment */
    @Excel(name = "analysis主键")
    private Long analysisId;

    public void setTfbdId(Long tfbdId) 
    {
        this.tfbdId = tfbdId;
    }

    public Long getTfbdId() 
    {
        return tfbdId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setFamily(String family) 
    {
        this.family = family;
    }

    public String getFamily() 
    {
        return family;
    }
    public void setSimplename(String simplename) 
    {
        this.simplename = simplename;
    }

    public String getSimplename() 
    {
        return simplename;
    }
    public void setGenev4(String genev4) 
    {
        this.genev4 = genev4;
    }

    public String getGenev4() 
    {
        return genev4;
    }
    public void setGenev3(String genev3) 
    {
        this.genev3 = genev3;
    }

    public String getGenev3() 
    {
        return genev3;
    }
    public void setTfClass(String tfClass) 
    {
        this.tfClass = tfClass;
    }

    public String getTfClass() 
    {
        return tfClass;
    }
    public void setEnrichGo(String enrichGo) 
    {
        this.enrichGo = enrichGo;
    }

    public String getEnrichGo() 
    {
        return enrichGo;
    }
    public void setEnrichMp(String enrichMp) 
    {
        this.enrichMp = enrichMp;
    }

    public String getEnrichMp() 
    {
        return enrichMp;
    }
    public void setAtid(String atid) 
    {
        this.atid = atid;
    }

    public String getAtid() 
    {
        return atid;
    }
    public void setAtsimplename(String atsimplename) 
    {
        this.atsimplename = atsimplename;
    }

    public String getAtsimplename() 
    {
        return atsimplename;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setPhenotype(String phenotype) 
    {
        this.phenotype = phenotype;
    }

    public String getPhenotype() 
    {
        return phenotype;
    }
    public void setAnalysisId(Long analysisId) 
    {
        this.analysisId = analysisId;
    }

    public Long getAnalysisId() 
    {
        return analysisId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("tfbdId", getTfbdId())
            .append("name", getName())
            .append("family", getFamily())
            .append("simplename", getSimplename())
            .append("genev4", getGenev4())
            .append("genev3", getGenev3())
            .append("tfClass", getTfClass())
            .append("enrichGo", getEnrichGo())
            .append("enrichMp", getEnrichMp())
            .append("atid", getAtid())
            .append("atsimplename", getAtsimplename())
            .append("description", getDescription())
            .append("phenotype", getPhenotype())
            .append("analysisId", getAnalysisId())
            .toString();
    }
}
