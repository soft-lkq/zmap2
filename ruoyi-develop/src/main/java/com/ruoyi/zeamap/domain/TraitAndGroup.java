package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 traitAndGroup
 *
 * @author 温镜蓉
 * @date 2023-07-1
 */
public class TraitAndGroup extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String trait;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String trait_group;

    public String getTrait() {
        return trait;
    }

    public void setTrait(String trait) {
        this.trait = trait;
    }

    public String getTrait_group() {
        return trait_group;
    }

    public void setTrait_group(String trait_group) {
        this.trait_group = trait_group;
    }

    @Override
    public String toString() {
        return "TraitAndGroup{" +
                "trait='" + trait + '\'' +
                ", trait_group='" + trait_group + '\'' +
                '}';
    }
}
