package com.ruoyi.zeamap.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.persistence.Table;

/**
 * 1对象 dbxref
 * 
 * @author ruoyi
 * @date 2023-03-14
 */
@Table(name = "dbxref")
public class ImportDbxref extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "dbxrefId")
    private Long dbxrefId;

    /** Reference */
    @Excel(name = "基因组名称")
    private String accession;

    /** $column.columnComment */
    @Excel(name = "基因组版本")
    private String version;

    /** $column.columnComment */
    @Excel(name = "描述信息")
    private String description;

    /** $column.columnComment */
    @Excel(name = "db表主键")
    private Long dbId;

    public void setDbxrefId(Long dbxrefId) 
    {
        this.dbxrefId = dbxrefId;
    }

    public Long getDbxrefId() 
    {
        return dbxrefId;
    }
    public void setAccession(String accession) 
    {
        this.accession = accession;
    }

    public String getAccession() 
    {
        return accession;
    }
    public void setVersion(String version) 
    {
        this.version = version;
    }

    public String getVersion() 
    {
        return version;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setDbId(Long dbId) 
    {
        this.dbId = dbId;
    }

    public Long getDbId() 
    {
        return dbId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dbxrefId", getDbxrefId())
            .append("accession", getAccession())
            .append("version", getVersion())
            .append("description", getDescription())
            .append("dbId", getDbId())
            .toString();
    }
}
