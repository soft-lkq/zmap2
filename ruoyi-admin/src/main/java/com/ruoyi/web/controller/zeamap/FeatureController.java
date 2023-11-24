package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.*;
import com.ruoyi.zeamap.service.IDbxrefService;
import com.ruoyi.zeamap.service.IFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.Map;


/**
 * featureController
 *
 * @author 温镜蓉
 * @date 2022-10-30
 */
@RestController
@RequestMapping("/system/feature")
public class FeatureController extends BaseController
{
    @Autowired
    private IFeatureService featureService;
    @Autowired
    private IDbxrefService dbxrefService;


    //=====查询条件1的前置需求=====
    /**
     * 在dbxref表里查询accession并过滤
     */
    @PreAuthorize("@ss.hasAnyRoles({'common','admin'})")
    @GetMapping("/selectAccession")
    public TableDataInfo selectAccession()
    {
        startPage();
        List<String> accession = dbxrefService.selectAccession();
        return getDataTable(accession);
    }
    /**
     * 通过accession在dbxref表里查询version
     */
    @PreAuthorize("@ss.hasAnyRoles({'common','admin'})")
    @GetMapping("/selectVersion")
    public TableDataInfo selectVersion(String accession)
    {
        startPage();
        List<String> list = dbxrefService.selectVersionByAccession(accession);
        return getDataTable(list);
    }


    //=====查询条件2的前置需求=====
    /**
     * 在feature表里查询uniqueName
     */
    @PreAuthorize("@ss.hasAnyRoles({'common','admin'})")
    @GetMapping("/selectUniqueName")
    public TableDataInfo selectUniqueName()
    {
        startPage();
        List<String> uniqueNames = featureService.selectUniqueName();
        return getDataTable(uniqueNames);
    }


    //=====查询条件3的前置需求=====
    /**
     * 在cvterm表里查询name
     */
    @PreAuthorize("@ss.hasAnyRoles({'common','admin'})")
    @GetMapping("/selectName")
    public TableDataInfo selectName()
    {
        startPage();
        List<String> Names = featureService.selectName();
        return getDataTable(Names);
    }


    //=====查询=====
    /**
     * 通过queryCriteria的五个条件查询featureId集合,再通过featureId集合在feature和featureloc和dbxref表里查询queryResult
     */
    @PreAuthorize("@ss.hasAnyRoles({'common','admin'})")
    @PostMapping("/enquiry")
    public TableDataInfo selectQueryResult(@RequestBody QueryCriteria queryCriteria)
    {
        startPage();
        List<QueryResult> queryResult = featureService.selectQueryResult(queryCriteria);
        return getDataTable(queryResult);
    }


    //=====下载=====
    /**
     * 通过featureId集合在feature和featureloc和dbxref表里查询queryResult并下载
     */
    @PreAuthorize("@ss.hasAnyRoles({'common','admin'})")
    @PostMapping("/download")
    public void download(HttpServletResponse response,@RequestBody List<String> featureId)
    {
        List<QueryResult> list = new LinkedList<>();
        for (String feature_id : featureId) {
            list.add(featureService.download(feature_id));
        }
        ExcelUtil<QueryResult> util = new ExcelUtil<QueryResult>(QueryResult.class);
        util.exportExcel(response,list,"原始数据");
    }


    //=====跳转=====
    /**
     * 通过featureId在feature,cvterm,dbxref,featureloc,feature_dbxref和cv表里查询skipResult
     */
    @PreAuthorize("@ss.hasAnyRoles({'common','admin'})")
    @GetMapping("/skipResult")
    public SkipResult skip(String featureId)
    {
        SkipResult skipResult = featureService.selectSummary(featureId);
        skipResult.setFunctionAnnotations(featureService.selectFunctionAnnotation(featureId));
        skipResult.setSequences(featureService.selectSequences(featureId));
        return skipResult;
    }

 /**侯永杰
     * 5.1的一个请求
     * @param uniquename
     * @return
     */
    @GetMapping("/uniquename1")
    public AjaxResult TissueDescSvg(@RequestParam String uniquename) {
        Map<String, String> DataMap = featureService.selectByUniquenameToExpression(uniquename);
        if (DataMap == null){//查询不到
            return AjaxResult.error("此基因在库中不存在");
        }
        return AjaxResult.success(DataMap);
    }

    @GetMapping("/uniquename2")
    public AjaxResult ExpressionTissue(@RequestParam String uniquename) {
        //这两个接口没有问题但是数据造起来太麻烦了,看以后数据咋样把,目前写死了
        Map<String, String> DataMap = featureService.selectByUniquenameToExpression(uniquename);
        if (DataMap == null){//查询不到
            return AjaxResult.error("此基因在库中不存在");
        }
        return AjaxResult.success(DataMap);

    }

}
