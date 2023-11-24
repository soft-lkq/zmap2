package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.ImportXotMutable;
import com.ruoyi.zeamap.service.IImportXotMutableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * ImportXot_mutableController
 * 
 * @author ruoyi
 * @date 2023-03-15
 */
@RestController
@RequestMapping("/zeamap/ImportXot_mutable")
public class ImportXotMutableController extends BaseController
{
    @Autowired
    private IImportXotMutableService importXotMutableService;

    /**
     * 查询ImportXot_mutable列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportXot_mutable:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImportXotMutable importXotMutable)
    {
        startPage();
        List<ImportXotMutable> list = importXotMutableService.selectImportXotMutableList(importXotMutable);
        return getDataTable(list);
    }

    /**
     * 导出ImportXot_mutable列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportXot_mutable:export')")
    @Log(title = "ImportXot_mutable", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImportXotMutable importXotMutable)
    {
        List<ImportXotMutable> list = importXotMutableService.selectImportXotMutableList(importXotMutable);
        ExcelUtil<ImportXotMutable> util = new ExcelUtil<ImportXotMutable>(ImportXotMutable.class);
        util.exportExcel(response, list, "ImportXot_mutable数据");
    }

    /**
     * 获取ImportXot_mutable详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportXot_mutable:query')")
    @GetMapping(value = "/{xotMutableId}")
    public AjaxResult getInfo(@PathVariable("xotMutableId") Long xotMutableId)
    {
        return AjaxResult.success(importXotMutableService.selectImportXotMutableByXotMutableId(xotMutableId));
    }

    /**
     * 新增ImportXot_mutable
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportXot_mutable:add')")
    @Log(title = "ImportXot_mutable", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ImportXotMutable importXotMutable)
    {
        return toAjax(importXotMutableService.insertImportXotMutable(importXotMutable));
    }

    /**
     * 修改ImportXot_mutable
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportXot_mutable:edit')")
    @Log(title = "ImportXot_mutable", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ImportXotMutable importXotMutable)
    {
        return toAjax(importXotMutableService.updateImportXotMutable(importXotMutable));
    }

    /**
     * 删除ImportXot_mutable
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportXot_mutable:remove')")
    @Log(title = "ImportXot_mutable", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{xotMutableIds}")
    public AjaxResult remove(@PathVariable Long[] xotMutableIds)
    {
        return toAjax(importXotMutableService.deleteImportXotMutableByXotMutableIds(xotMutableIds));
    }
}
