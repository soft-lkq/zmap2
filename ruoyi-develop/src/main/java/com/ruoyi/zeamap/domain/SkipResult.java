package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 【请填写功能名称】对象 skipResult
 *
 * @author 温镜蓉
 * @date 2023-03-15
 */
public class SkipResult {
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String featureName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String featureType;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String germplasm;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String featureAnnotationVersion;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String featureLocation;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String description;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private List<FunctionAnnotation> functionAnnotations;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String sequences;

    public String getFeatureName() {
        return featureName;
    }
    public String getFeatureType() {
        return featureType;
    }
    public String getGermplasm() {
        return germplasm;
    }
    public String getFeatureAnnotationVersion() {
        return featureAnnotationVersion;
    }
    public String getFeatureLocation() {
        return featureLocation;
    }
    public String getDescription() {
        return description;
    }
    public List<FunctionAnnotation> getFunctionAnnotations() {
        return functionAnnotations;
    }
    public String getSequences() {
        return sequences;
    }

    public void setsummary(String featureName) {
        this.featureName = featureName;
    }
    public void setFeatureType(String featureType) {
        this.featureType = featureType;
    }
    public void setGermplasm(String germplasm) {
        this.germplasm = germplasm;
    }
    public void setFeatureAnnotationVersion(String featureAnnotationVersion) {
        this.featureAnnotationVersion = featureAnnotationVersion;
    }
    public void setFeatureLocation(String featureLocation) {
        this.featureLocation = featureLocation;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setFunctionAnnotations(List<FunctionAnnotation> functionAnnotations) {
        this.functionAnnotations = functionAnnotations;
    }
    public void setSequences(String sequences) {
        this.sequences = sequences;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("featureName", getFeatureName())
                .append("featureType", getFeatureType())
                .append("germplasm", getGermplasm())
                .append("featureAnnotationVersion", getFeatureAnnotationVersion())
                .append("featureLocation", getFeatureLocation())
                .append("description", getDescription())
                .append("functionAnnotation", getFunctionAnnotations())
                .append("sequences", getSequences())
                .toString();
    }
}
