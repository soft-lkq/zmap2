package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.ImportAnalysis;
import com.ruoyi.zeamap.service.IImportAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * ImportAnalysisController
 * 
 * @author ruoyi
 * @date 2023-03-15
 */
@RestController
@RequestMapping("/zeamap/ImportAnalysis")
public class ImportAnalysisController extends BaseController
{
    @Autowired
    private IImportAnalysisService importAnalysisService;

    /**
     * 查询ImportAnalysis列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportAnalysis:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImportAnalysis importAnalysis)
    {
        startPage();
        List<ImportAnalysis> list = importAnalysisService.selectImportAnalysisList(importAnalysis);
        return getDataTable(list);
    }

    /**
     * 导出ImportAnalysis列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportAnalysis:export')")
    @Log(title = "ImportAnalysis", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImportAnalysis importAnalysis)
    {
        List<ImportAnalysis> list = importAnalysisService.selectImportAnalysisList(importAnalysis);
        ExcelUtil<ImportAnalysis> util = new ExcelUtil<ImportAnalysis>(ImportAnalysis.class);
        util.exportExcel(response, list, "ImportAnalysis数据");
    }

    /**
     * 获取ImportAnalysis详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportAnalysis:query')")
    @GetMapping(value = "/{analysisId}")
    public AjaxResult getInfo(@PathVariable("analysisId") Long analysisId)
    {
        return AjaxResult.success(importAnalysisService.selectImportAnalysisByAnalysisId(analysisId));
    }

    /**
     * 新增ImportAnalysis
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportAnalysis:add')")
    @Log(title = "ImportAnalysis", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ImportAnalysis importAnalysis)
    {
        return toAjax(importAnalysisService.insertImportAnalysis(importAnalysis));
    }

    /**
     * 修改ImportAnalysis
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportAnalysis:edit')")
    @Log(title = "ImportAnalysis", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ImportAnalysis importAnalysis)
    {
        return toAjax(importAnalysisService.updateImportAnalysis(importAnalysis));
    }

    /**
     * 删除ImportAnalysis
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportAnalysis:remove')")
    @Log(title = "ImportAnalysis", businessType = BusinessType.DELETE)
    @ResponseBody
	@DeleteMapping("/remove/{analysisIds}")
    public AjaxResult remove(@PathVariable Long[] analysisIds)
    {
        return toAjax(importAnalysisService.deleteImportAnalysisByAnalysisIds(analysisIds));
    }
}
