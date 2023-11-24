package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.ImportFeatureloc;
import com.ruoyi.zeamap.service.IImportFeaturelocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * ImportFeaturelocController
 * 
 * @author ruoyi
 * @date 2023-03-30
 */
@RestController
@RequestMapping("/zeamap/ImportFeatureloc")
public class ImportFeaturelocController extends BaseController
{
    @Autowired
    private IImportFeaturelocService importFeaturelocService;

    /**
     * 查询ImportFeatureloc列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:featureloc:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImportFeatureloc importFeatureloc)
    {
        startPage();
        List<ImportFeatureloc> list = importFeaturelocService.selectImportFeaturelocList(importFeatureloc);
        return getDataTable(list);
    }

    /**
     * 导出ImportFeatureloc列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:featureloc:export')")
    @Log(title = "ImportFeatureloc", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImportFeatureloc importFeatureloc)
    {
        List<ImportFeatureloc> list = importFeaturelocService.selectImportFeaturelocList(importFeatureloc);
        ExcelUtil<ImportFeatureloc> util = new ExcelUtil<ImportFeatureloc>(ImportFeatureloc.class);
        util.exportExcel(response, list, "ImportFeatureloc数据");
    }

    /**
     * 获取ImportFeatureloc详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:featureloc:query')")
    @GetMapping(value = "/{featurelocId}")
    public AjaxResult getInfo(@PathVariable("featurelocId") String featurelocId)
    {
        return AjaxResult.success(importFeaturelocService.selectImportFeaturelocByFeaturelocId(featurelocId));
    }

    /**
     * 新增ImportFeatureloc
     */
    @PreAuthorize("@ss.hasPermi('zeamap:featureloc:add')")
    @Log(title = "ImportFeatureloc", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ImportFeatureloc importFeatureloc)
    {
        return toAjax(importFeaturelocService.insertImportFeatureloc(importFeatureloc));
    }

    /**
     * 修改ImportFeatureloc
     */
    @PreAuthorize("@ss.hasPermi('zeamap:featureloc:edit')")
    @Log(title = "ImportFeatureloc", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ImportFeatureloc importFeatureloc)
    {
        return toAjax(importFeaturelocService.updateImportFeatureloc(importFeatureloc));
    }

    /**
     * 删除ImportFeatureloc
     */
    @PreAuthorize("@ss.hasPermi('zeamap:featureloc:remove')")
    @Log(title = "ImportFeatureloc", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{featurelocIds}")
    public AjaxResult remove(@PathVariable String[] featurelocIds)
    {
        return toAjax(importFeaturelocService.deleteImportFeaturelocByFeaturelocIds(featurelocIds));
    }
}
