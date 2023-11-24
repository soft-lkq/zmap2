package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;

import java.util.List;

/**
 * 【请填写功能名称】对象 searchResult
 *
 * @author 温镜蓉
 * @date 2023-05-06
 */
public class SearchResult {
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private int code = 200;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private List<String> data;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String meta = "top-20-options";

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public List<String> getData() {
        return data;
    }
    public void setData(List<String> data) {
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
        return "SearchResult{" +
                "code=" + code +
                ", data=" + data +
                ", meta='" + meta + '\'' +
                '}';
    }
}
