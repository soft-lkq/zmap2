package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 functionAnnotation
 *
 * @author 温镜蓉
 * @date 2023-03-15
 */
public class FunctionAnnotation {
    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String ontology;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String term;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String definition;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getOntology() {
        return ontology;
    }

    public void setOntology(String ontology) {
        this.ontology = ontology;
    }
    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("ontology", getOntology())
                .append("term", getTerm())
                .append("definition", getDefinition())
                .toString();
    }
}
