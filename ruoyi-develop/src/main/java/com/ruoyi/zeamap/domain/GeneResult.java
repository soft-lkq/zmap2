package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;

import java.util.List;

/**
 * 【请填写功能名称】对象 geneResult
 *
 * @author 温镜蓉
 * @date 2023-06-24
 */
public class GeneResult
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private int code = 200;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private List<Gene> genes;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String meta = "";

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Gene> getGenes() {
        return genes;
    }

    public void setGenes(List<Gene> genes) {
        this.genes = genes;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        return "GeneResult{" +
                "code='" + code + '\'' +
                ", genes=" + genes +
                ", meta='" + meta + '\'' +
                '}';
    }
}
