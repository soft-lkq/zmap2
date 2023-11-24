package com.ruoyi.sidebarTree.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 breed2
 *
 * @author ruoyi
 * @date 2023-09-10
 */
public class Breed2 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String materialName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String pdfpath;

    public String getGenofile() {
        return genofile;
    }

    public void setGenofile(String genofile) {
        this.genofile = genofile;
    }

    public String getCeyanfile() {
        return ceyanfile;
    }

    public void setCeyanfile(String ceyanfile) {
        this.ceyanfile = ceyanfile;
    }

    private String genofile;
    private String ceyanfile;

    //执行信息
    private String info;
    public void setInfo(String info)
    {
        this.info= info;
    }
    public String getInfo()
    {
        return info;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setMaterialName(String materialName)
    {
        this.materialName = materialName;
    }

    public String getMaterialName()
    {
        return materialName;
    }
    public void setPdfpath(String pdfpath)
    {
        this.pdfpath = pdfpath;
    }

    public String getPdfpath()
    {
        return pdfpath;
    }

    public Integer status ;



    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("materialName", getMaterialName())
            .append("pdfpath", getPdfpath())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
                .append("info",getInfo())
                .append("genofile",getGenofile())
                .append("ceyanfile",getCeyanfile())
            .toString();
    }
}
