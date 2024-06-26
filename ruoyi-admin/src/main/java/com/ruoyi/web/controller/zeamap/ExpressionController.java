package com.ruoyi.web.controller.zeamap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.zeamap.service.IDbxrefService;
import com.ruoyi.zeamap.vo.ExpressionVo;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.zeamap.domain.Expression;
import com.ruoyi.zeamap.service.IExpressionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 基因表达量查询Controller
 *
 * @author ruoyi
 * @date 2022-11-19
 */
@RestController
@RequestMapping("/zeamap/expression")
public class ExpressionController extends BaseController
{
    @Autowired
    private IExpressionService expressionService;

    @Autowired
    private IDbxrefService dbxrefService;
    /**
     * 查询基因表达量查询列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:expression:list')")
    @GetMapping("/list")
    public TableDataInfo list(Expression expression)
    {
        startPage();
        List<Expression> list = expressionService.selectExpressionList(expression);
        return getDataTable(list);
    }

    /**
     * 导出基因表达量查询列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:expression:export')")
    @Log(title = "基因表达量查询", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Expression expression)
    {
        List<Expression> list = expressionService.selectExpressionList(expression);
        ExcelUtil<Expression> util = new ExcelUtil<Expression>(Expression.class);
        util.exportExcel(response, list, "基因表达量查询数据");
    }

    /**
     * 获取基因表达量查询详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:expression:query')")
    @GetMapping(value = "/{expressionId}")
    public AjaxResult getInfo(@PathVariable("expressionId") Long expressionId)
    {
        return AjaxResult.success(expressionService.selectExpressionByExpressionId(expressionId));
    }

    /**
     * 新增基因表达量查询
     */
    @PreAuthorize("@ss.hasPermi('zeamap:expression:add')")
    @Log(title = "基因表达量查询", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Expression expression)
    {
        return toAjax(expressionService.insertExpression(expression));
    }

    /**
     * 修改基因表达量查询
     */
    @PreAuthorize("@ss.hasPermi('zeamap:expression:edit')")
    @Log(title = "基因表达量查询", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Expression expression)
    {
        return toAjax(expressionService.updateExpression(expression));
    }

    /**
     * 删除基因表达量查询
     */
    @PreAuthorize("@ss.hasPermi('zeamap:expression:remove')")
    @Log(title = "基因表达量查询", businessType = BusinessType.DELETE)
	@DeleteMapping("/{expressionIds}")
    public AjaxResult remove(@PathVariable Long[] expressionIds)
    {
        return toAjax(expressionService.deleteExpressionByExpressionIds(expressionIds));
    }


    @GetMapping("/mutil")
    //5.2 的接口
    @ResponseBody
    public AjaxResult multiExpression (@RequestBody ExpressionVo expressionVo)
    {
        List<Expression> list = expressionService.selectmultiExpressionList(expressionVo);
        return AjaxResult.success(list);
    }


    @GetMapping("/DownMenu")
    public AjaxResult DownMenu(){
        Map<String, List<String>> res = expressionService.selectDownMenuAllData();

        return AjaxResult.success(res);
    }

    @GetMapping("/reference")
    public AjaxResult Reference() {
        List<String> res = expressionService.findAllReference();
        return AjaxResult.success(res);
    }

    @GetMapping("/version")
    public AjaxResult version(String reference) {
        List<String> res = expressionService.findAllVersion(reference);
        return AjaxResult.success(res);
    }

    @GetMapping("/genes")
    @ResponseBody
    public AjaxResult genesId(String reference,String version){
        List<Long> list = expressionService.selectGeneId(reference,version);
        return AjaxResult.success(list);
    }

    @GetMapping("/tissue")
    @ResponseBody
    public TableDataInfo selectByTissue(String reference, String version,String analysis,String environment,String germplasm,String strGeneIds,String strSelects){
//        Long db_id = expressionService.selectDbid(reference);
        Long dbxref_id = expressionService.selectDbxrefId(reference,version);
//        if(dbxref_id==null){
//            return AjaxResult.success("数据错误");
//        }
        Long[] analysis_id = expressionService.selectAnalysisId(analysis);
        Long[] environment_id = expressionService.selectEnvironmentId(environment);
        String[] selects = strSelects.split(",");
        Long[] tissue_id = expressionService.selectTissueIdByDesc(selects);
        Long[] germplasm_id = expressionService.selectGermplasmId(germplasm);

        //处理输入字符串拆分为数组
        String[] geneIds = strGeneIds.split(",");
        if(geneIds.length==0){
            return getDataTable(null);
        }
        Long[] featureIds = expressionService.selectFeatureIdsByGene(geneIds);
        startPage();
        List<Expression> e = expressionService.selectAllFromTissue(dbxref_id,analysis_id,environment_id,germplasm_id,featureIds,tissue_id);
        return getDataTable(e);
    }

    @GetMapping("/tissueNopage")
    @ResponseBody
    public TableDataInfo selectByTissueNopage(String reference, String version,String analysis,String environment,String germplasm,String strGeneIds,String strSelects){
//        Long db_id = expressionService.selectDbid(reference);
        Long dbxref_id = expressionService.selectDbxrefId(reference,version);
//        if(dbxref_id==null){
//            return AjaxResult.success("数据错误");
//        }
        Long[] analysis_id = expressionService.selectAnalysisId(analysis);
        Long[] environment_id = expressionService.selectEnvironmentId(environment);
        String[] selects = strSelects.split(",");
        Long[] tissue_id = expressionService.selectTissueIdByDesc(selects);
        Long[] germplasm_id = expressionService.selectGermplasmId(germplasm);

        //处理输入字符串拆分为数组
        String[] geneIds = strGeneIds.split(",");
        if(geneIds.length==0){
            return getDataTable(null);
        }
        Long[] featureIds = expressionService.selectFeatureIdsByGene(geneIds);
        List<Expression> e = expressionService.selectAllFromTissue(dbxref_id,analysis_id,environment_id,germplasm_id,featureIds,tissue_id);
        return getDataTable(e);
    }


    @GetMapping("/germplasm")
    @ResponseBody
    public TableDataInfo selectByGermplasm(String reference,String version,String analysis,String environment,String tissue,String strSelects,String strGeneIds){

//        Long db_id = expressionService.selectDbid(reference);
        Long dbxref_id = expressionService.selectDbxrefId(reference,version);
//        if(dbxref_id==null){
//            return AjaxResult.success("数据错误");
//        }
        String[] geneIds = strGeneIds.split(",");
        if(geneIds.length==0){
            return getDataTable(null);
        }
        Long[] geneId = expressionService.selectFeatureIdsByGene(geneIds);
        Long[] analysis_id = expressionService.selectAnalysisId(analysis);
        Long[] tissue_id = expressionService.selectTissueIdByPosition(tissue);
        Long[] environment_id = expressionService.selectEnvironmentId(environment);
        String[] selects = strSelects.split(",");
        Long[] germplasmIds = expressionService.selectGermplasmIds(selects);
        startPage();
        List<Expression> e = expressionService.selectAllFromGermplasm(dbxref_id,analysis_id,environment_id,tissue_id,germplasmIds,geneId);
        return getDataTable(e);
    }

    @GetMapping("/germplasmNopage")
    @ResponseBody
    public TableDataInfo selectByGermplasmNopage(String reference,String version,String analysis,String environment,String tissue,String strSelects,String strGeneIds){

//        Long db_id = expressionService.selectDbid(reference);
        Long dbxref_id = expressionService.selectDbxrefId(reference,version);
//        if(dbxref_id==null){
//            return AjaxResult.success("数据错误");
//        }
        String[] geneIds = strGeneIds.split(",");
        if(geneIds.length==0){
            return getDataTable(null);
        }
        Long[] geneId = expressionService.selectFeatureIdsByGene(geneIds);
        Long[] analysis_id = expressionService.selectAnalysisId(analysis);
        Long[] tissue_id = expressionService.selectTissueIdByPosition(tissue);
        Long[] environment_id = expressionService.selectEnvironmentId(environment);
        String[] selects = strSelects.split(",");
        Long[] germplasmIds = expressionService.selectGermplasmIds(selects);
        List<Expression> e = expressionService.selectAllFromGermplasm(dbxref_id,analysis_id,environment_id,tissue_id,germplasmIds,geneId);
        return getDataTable(e);
    }



    @GetMapping("/environment")
    @ResponseBody
    public TableDataInfo selectByEnvironment(String reference,String version,String analysis,String germplasm,String tissue,String strSelects,String strGeneIds){

//        Long db_id = expressionService.selectDbid(reference);
        Long dbxref_id = expressionService.selectDbxrefId(reference,version);
//        if(dbxref_id==null){
//            return AjaxResult.success("数据错误");
//        }
        String[] geneIds = strGeneIds.split(",");
        if(geneIds.length==0){
            return getDataTable(null);
        }
        Long[] geneId = expressionService.selectFeatureIdsByGene(geneIds);
        Long[] analysis_id = expressionService.selectAnalysisId(analysis);
        Long[] tissue_id = expressionService.selectTissueIdByPosition(tissue);
        Long[] germplasm_id = expressionService.selectGermplasmId(germplasm);
        String[] selects = strSelects.split(",");
        Long[] environmentIds = expressionService.selectEnvironmentIds(selects);
        startPage();
        List<Expression> e = expressionService.selectAllFromEnvironment(dbxref_id,analysis_id,tissue_id,germplasm_id,environmentIds,geneId);
        return getDataTable(e);
    }

    @GetMapping("/environmentNopage")
    @ResponseBody
    public TableDataInfo selectByEnvironmentNopage(String reference,String version,String analysis,String germplasm,String tissue,String strSelects,String strGeneIds){

//        Long db_id = expressionService.selectDbid(reference);
        Long dbxref_id = expressionService.selectDbxrefId(reference,version);
//        if(dbxref_id==null){
//            return AjaxResult.success("数据错误");
//        }
        String[] geneIds = strGeneIds.split(",");
        if(geneIds.length==0){
            return getDataTable(null);
        }
        Long[] geneId = expressionService.selectFeatureIdsByGene(geneIds);
        Long[] analysis_id = expressionService.selectAnalysisId(analysis);
        Long[] tissue_id = expressionService.selectTissueIdByPosition(tissue);
        Long[] germplasm_id = expressionService.selectGermplasmId(germplasm);
        String[] selects = strSelects.split(",");
        Long[] environmentIds = expressionService.selectEnvironmentIds(selects);
        List<Expression> e = expressionService.selectAllFromEnvironment(dbxref_id,analysis_id,tissue_id,germplasm_id,environmentIds,geneId);
        return getDataTable(e);
    }

}
