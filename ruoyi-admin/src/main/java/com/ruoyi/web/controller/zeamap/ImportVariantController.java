package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.ImportVariant;
import com.ruoyi.zeamap.service.IImportVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * ImportVariantController
 * 
 * @author ruoyi
 * @date 2023-03-16
 */
@RestController
@RequestMapping("/zeamap/ImportVariant")
public class ImportVariantController extends BaseController
{
    @Autowired
    private IImportVariantService importVariantService;

    /**
     * 查询ImportVariant列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportVariant:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImportVariant importVariant)
    {
        startPage();
        List<ImportVariant> list = importVariantService.selectImportVariantList(importVariant);
        return getDataTable(list);
    }

    /**
     * 导出ImportVariant列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportVariant:export')")
    @Log(title = "ImportVariant", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImportVariant importVariant)
    {
        List<ImportVariant> list = importVariantService.selectImportVariantList(importVariant);
        ExcelUtil<ImportVariant> util = new ExcelUtil<ImportVariant>(ImportVariant.class);
        util.exportExcel(response, list, "ImportVariant数据");
    }

    /**
     * 获取ImportVariant详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportVariant:query')")
    @GetMapping(value = "/{variantId}")
    public AjaxResult getInfo(@PathVariable("variantId") String variantId)
    {
        return AjaxResult.success(importVariantService.selectImportVariantByVariantId(variantId));
    }

    /**
     * 新增ImportVariant
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportVariant:add')")
    @Log(title = "ImportVariant", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ImportVariant importVariant)
    {
        return toAjax(importVariantService.insertImportVariant(importVariant));
    }

    /**
     * 修改ImportVariant
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportVariant:edit')")
    @Log(title = "ImportVariant", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ImportVariant importVariant)
    {
        return toAjax(importVariantService.updateImportVariant(importVariant));
    }

    /**
     * 删除ImportVariant
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportVariant:remove')")
    @Log(title = "ImportVariant", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{variantIds}")
    public AjaxResult remove(@PathVariable String[] variantIds)
    {
        return toAjax(importVariantService.deleteImportVariantByVariantIds(variantIds));
    }
}
