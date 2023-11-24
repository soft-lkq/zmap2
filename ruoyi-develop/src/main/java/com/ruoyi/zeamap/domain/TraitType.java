package com.ruoyi.zeamap.domain;


import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 trait_type
 *
 * @author ruoyi
 * @date 2023-07-03
 */
public class TraitType extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 性状类型ID
     */
    private Long traitTypeId;

    /**
     * 性状类型名称
     */
    @Excel(name = "性状类型名称", sort = 1)
    private String traitTypeName;

    public void setTraitTypeId(Long traitTypeId) {
        this.traitTypeId = traitTypeId;
    }

    public Long getTraitTypeId() {
        return traitTypeId;
    }

    public void setTraitTypeName(String traitTypeName) {
        this.traitTypeName = traitTypeName;
    }

    public String getTraitTypeName() {
        return traitTypeName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("traitTypeId", getTraitTypeId())
                .append("traitTypeName", getTraitTypeName())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
