package com.ruoyi.zeamap.service;

import com.ruoyi.zeamap.domain.FunctionAnnotation;
import com.ruoyi.zeamap.domain.QueryCriteria;
import com.ruoyi.zeamap.domain.QueryResult;
import com.ruoyi.zeamap.domain.SkipResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-03-15
 */
@Service
public interface IFeatureService
{

    /**
     * 在feature表里查询uniqueName
     *
     * @return uniqueName的list
     */
    public List<String> selectUniqueName();

    /**
     * 在cvterm表里查询Name
     *
     * @return Name的list
     */
    public List<String> selectName();

    /**
     * 通过queryCriteria的五个条件查询featureId集合,再通过featureId集合在feature和featureloc和dbxref表里查询queryResult
     *
     * @param queryCriteria
     * @return queryResult的list
     */
    public List<QueryResult> selectQueryResult(QueryCriteria queryCriteria);

    /**
     * 通过featureId集合在feature和featureloc和dbxref表里查询queryResult并下载
     *
     * @param feature_id
     * @return queryResult
     */
    public QueryResult download(String feature_id);

    /**
     * 通过featureId在feature,cvterm,dbxref,featureloc,feature_dbxref和cv表里查询skipResult
     *
     * @param feature_id
     * @return Summary
     */
    public SkipResult selectSummary(String feature_id);

    /**
     * 通过featureId在feature,cvterm,dbxref,featureloc,feature_dbxref和cv表里查询functionAnnotation
     *
     * @param feature_id
     * @return functionAnnotation的list
     */
    public List<FunctionAnnotation> selectFunctionAnnotation(String feature_id);

    /**
     * 通过featureId在feature表里查询sequences
     *
     * @param feature_id
     * @return String
     */
    public String selectSequences(String feature_id);

/**侯永杰
     * uniquename查找id ,首先判断有没有 然后再连表
     * @param uniquename
     * @return
     */
    public Long selectId(String uniquename);

    public Map<String, String> selectByUniquenameToExpression(String uniquename);

    public Map<String, Double> selectByUniquenameToTissue(String unquename);

}
