package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.ImportFeature;
import com.ruoyi.zeamap.service.IImportFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * ImportfeatureController
 * 
 * @author ruoyi
 * @date 2023-03-22
 */
@RestController
@RequestMapping("/zeamap/ImportFeature")
public class ImportFeatureController extends BaseController
{
    @Autowired
    private IImportFeatureService importFeatureService;

    /**
     * 查询Importfeature列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Importfeature:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImportFeature importFeature)
    {
        startPage();
        List<ImportFeature> list = importFeatureService.selectImportFeatureList(importFeature);
        return getDataTable(list);
    }

    /**
     * 导出Importfeature列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Importfeature:export')")
    @Log(title = "Importfeature", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImportFeature importFeature)
    {
        List<ImportFeature> list = importFeatureService.selectImportFeatureList(importFeature);
        ExcelUtil<ImportFeature> util = new ExcelUtil<ImportFeature>(ImportFeature.class);
        util.exportExcel(response, list, "Importfeature数据");
    }

    /**
     * 获取Importfeature详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Importfeature:query')")
    @GetMapping(value = "/{featureId}")
    public AjaxResult getInfo(@PathVariable("featureId") Long featureId)
    {
        return AjaxResult.success(importFeatureService.selectImportFeatureByFeatureId(featureId));
    }

    /**
     * 新增Importfeature
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Importfeature:add')")
    @Log(title = "Importfeature", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ImportFeature importFeature)
    {
        return toAjax(importFeatureService.insertImportFeature(importFeature));
    }

    /**
     * 修改Importfeature
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Importfeature:edit')")
    @Log(title = "Importfeature", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ImportFeature importFeature)
    {
        return toAjax(importFeatureService.updateImportFeature(importFeature));
    }

    /**
     * 删除Importfeature
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Importfeature:remove')")
    @Log(title = "Importfeature", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{featureIds}")
    public AjaxResult remove(@PathVariable Long[] featureIds)
    {
        return toAjax(importFeatureService.deleteImportFeatureByFeatureIds(featureIds));
    }
}
