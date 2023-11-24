package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.List;

/**
 * 【请填写功能名称】对象 pointChart
 *
 * @author 温镜蓉
 * @date 2023-05-24
 */
public class PointChart
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private int code = 200;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private PhePosi data;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String meta = "single-variant-gwas";

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    public PhePosi getData() {
        return data;
    }

    public void setData(PhePosi data) {
        this.data = data;
    }

    public String getMeta() {
        return meta;
    }
    public void setMeta(String meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        return "PointChart{" +
                "code=" + code +
                ", data=" + data +
                ", meta='" + meta + '\'' +
                '}';
    }
}
