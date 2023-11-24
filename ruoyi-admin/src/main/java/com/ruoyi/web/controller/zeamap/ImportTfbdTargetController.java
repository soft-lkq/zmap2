package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.ImportTfbdTarget;
import com.ruoyi.zeamap.service.IImportTfbdTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * ImportController
 * 
 * @author ruoyi
 * @date 2023-04-09
 */
@RestController
@RequestMapping("/zeamap/ImportTfdbtarget")
public class ImportTfbdTargetController extends BaseController
{
    @Autowired
    private IImportTfbdTargetService importTfbdTargetService;

    /**
     * 查询Import列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:target:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImportTfbdTarget importTfbdTarget)
    {
        startPage();
        List<ImportTfbdTarget> list = importTfbdTargetService.selectImportTfbdTargetList(importTfbdTarget);
        return getDataTable(list);
    }

    /**
     * 导出Import列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:target:export')")
    @Log(title = "Import", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImportTfbdTarget importTfbdTarget)
    {
        List<ImportTfbdTarget> list = importTfbdTargetService.selectImportTfbdTargetList(importTfbdTarget);
        ExcelUtil<ImportTfbdTarget> util = new ExcelUtil<ImportTfbdTarget>(ImportTfbdTarget.class);
        util.exportExcel(response, list, "Import数据");
    }

    /**
     * 获取Import详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:target:query')")
    @GetMapping(value = "/{tfbdTargetId}")
    public AjaxResult getInfo(@PathVariable("tfbdTargetId") Long tfbdTargetId)
    {
        return AjaxResult.success(importTfbdTargetService.selectImportTfbdTargetByTfbdTargetId(tfbdTargetId));
    }

    /**
     * 新增Import
     */
    @PreAuthorize("@ss.hasPermi('zeamap:target:add')")
    @Log(title = "Import", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ImportTfbdTarget importTfbdTarget)
    {
        return toAjax(importTfbdTargetService.insertImportTfbdTarget(importTfbdTarget));
    }

    /**
     * 修改Import
     */
    @PreAuthorize("@ss.hasPermi('zeamap:target:edit')")
    @Log(title = "Import", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ImportTfbdTarget importTfbdTarget)
    {
        return toAjax(importTfbdTargetService.updateImportTfbdTarget(importTfbdTarget));
    }

    /**
     * 删除Import
     */
    @PreAuthorize("@ss.hasPermi('zeamap:target:remove')")
    @Log(title = "Import", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{tfbdTargetIds}")
    public AjaxResult remove(@PathVariable Long[] tfbdTargetIds)
    {
        return toAjax(importTfbdTargetService.deleteImportTfbdTargetByTfbdTargetIds(tfbdTargetIds));
    }
}
