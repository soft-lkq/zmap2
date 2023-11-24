package com.ruoyi.zeamap.service.impl;

import com.ruoyi.zeamap.domain.*;
import com.ruoyi.zeamap.mapper.ExpressionMapper;
import com.ruoyi.zeamap.mapper.FeatureMapper;
import com.ruoyi.zeamap.mapper.TissueMapper;
import com.ruoyi.zeamap.service.IFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-15
 */
@Service
public class FeatureServiceImpl implements IFeatureService
{
    @Autowired
    private FeatureMapper featureMapper;
    private TissueMapper tissueMapper;
    private ExpressionMapper expressionMapper;

    /**
     * 在feature表里查询uniqueName
     *
     * @return uniqueName的list
     */
    public List<String> selectUniqueName(){
        return featureMapper.selectUniqueName();
    }

    /**
     * 在cvterm表里查询Name
     *
     * @return Name的list
     */
    public List<String> selectName() {
        return featureMapper.selectName();
    }

    /**
     * 通过queryCriteria的五个条件查询featureId集合,再通过featureId集合在feature和featureloc和dbxref表里查询queryResult
     *
     * @param queryCriteria
     * @return queryResult的list
     */
    public List<QueryResult> selectQueryResult(QueryCriteria queryCriteria){
        return featureMapper.selectQueryResult(queryCriteria);
    }

    /**
     * 通过featureId集合在feature和featureloc和dbxref表里查询queryResult并下载
     *
     * @param feature_id
     * @return queryResult
     */
    public QueryResult download(String feature_id){
        return featureMapper.download(feature_id);
    }

    /**
     * 通过featureId在feature,cvterm,dbxref,featureloc,feature_dbxref和cv表里查询skipResult
     *
     * @param feature_id
     * @return Summary
     */
    public SkipResult selectSummary(String feature_id){
        return featureMapper.selectSummary(feature_id);
    }

    /**
     * 通过featureId在feature,cvterm,dbxref,featureloc,feature_dbxref和cv表里查询functionAnnotation
     *
     * @param feature_id
     * @return functionAnnotation的list
     */
    public List<FunctionAnnotation> selectFunctionAnnotation(String feature_id) {
        return featureMapper.selectFunctionAnnotation(feature_id);
    }

    /**
     * 通过featureId在feature表里查询sequences
     *
     * @param feature_id
     * @return String
     */
    public String selectSequences(String feature_id) {
        return featureMapper.selectSequences(feature_id);
    }

 /**侯永杰
     *  通过unquename 查找id
     * @param
     * @return
     */
    @Override
    public Long selectId(String uniquename) {

        return featureMapper.selectByUniquename(uniquename);
    }

    @Override
    public Map<String, String> selectByUniquenameToExpression(String uniquename) {
        Long featureId = selectId(uniquename);//查找id
        if (featureId == null) {
            return null;
        }

        List<Tissue> res = tissueMapper.selectMapTissue(featureId);//查找组织然后转化
        Map<String, String> tissueMap = res.stream().distinct().collect(Collectors.toMap(item -> item.getTissueDesc(), item -> item.getTissueSvgclass()));
        return tissueMap;
    }


    public Map<String,Double> selectByUniquenameToTissue(String unquename) {
        Long featureId = selectId(unquename);

        if (featureId == null) {
            return null;
        }
        List<Expression> res = expressionMapper.selectMapExpression(featureId);

        Map<String, Double> expressMap = res.stream().collect(Collectors.toMap(item -> (item.getTissue().getTissueDesc()), item -> item.getExpressionValue()));

        return expressMap;
    }

}
