package com.ruoyi.zeamap.mapper;

import com.ruoyi.zeamap.domain.FunctionAnnotation;
import com.ruoyi.zeamap.domain.QueryCriteria;
import com.ruoyi.zeamap.domain.QueryResult;
import com.ruoyi.zeamap.domain.SkipResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeatureMapper
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
//侯永杰
public int deleteFeatureByFeatureIds(Long[] featureIds);

    public Long selectByUniquename(String uniquename);

}
