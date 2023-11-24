package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;

import java.util.List;

/**
 * 【请填写功能名称】对象 phePosi
 *
 * @author 温镜蓉
 * @date 2023-06-26
 */
public class PhePosi
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private List<Phewas> phewas;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String position;

    public List<Phewas> getPhewas() {
        return phewas;
    }

    public void setPhewas(List<Phewas> phewas) {
        this.phewas = phewas;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "PhePosi{" +
                "phewas=" + phewas +
                ", position='" + position + '\'' +
                '}';
    }
}
