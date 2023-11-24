package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.persistence.Table;

/**
 * ImportEnvironment对象 environment
 * 
 * @author ruoyi
 * @date 2023-04-09
 */
@Table(name = "environment")
public class ImportEnvironment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @Excel(name = "主键")
    private Long environmentId;

    /** $column.columnComment */
    @Excel(name = "环境编号")
    private String name;

    /** $column.columnComment */
    @Excel(name = "环境分类")
    private String environmentClass;

    /** $column.columnComment */
    @Excel(name = "环境条件")
    private String environmentCondition;

    /** $column.columnComment */
    @Excel(name = "环境描述")
    private String environmentDesc;

    /** 状态（0正常 1停用） */
    private String status;

    public void setEnvironmentId(Long environmentId) 
    {
        this.environmentId = environmentId;
    }

    public Long getEnvironmentId() 
    {
        return environmentId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setEnvironmentClass(String environmentClass) 
    {
        this.environmentClass = environmentClass;
    }

    public String getEnvironmentClass() 
    {
        return environmentClass;
    }
    public void setEnvironmentCondition(String environmentCondition) 
    {
        this.environmentCondition = environmentCondition;
    }

    public String getEnvironmentCondition() 
    {
        return environmentCondition;
    }
    public void setEnvironmentDesc(String environmentDesc) 
    {
        this.environmentDesc = environmentDesc;
    }

    public String getEnvironmentDesc() 
    {
        return environmentDesc;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("environmentId", getEnvironmentId())
            .append("name", getName())
            .append("environmentClass", getEnvironmentClass())
            .append("environmentCondition", getEnvironmentCondition())
            .append("environmentDesc", getEnvironmentDesc())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
