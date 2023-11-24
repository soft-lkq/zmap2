package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.ImportCvterm;
import com.ruoyi.zeamap.service.IImportCvtermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * ImportCvtermController
 * 
 * @author ruoyi
 * @date 2023-03-30
 */
@RestController
@RequestMapping("/zeamap/ImportCvterm")
public class ImportCvtermController extends BaseController
{
    @Autowired
    private IImportCvtermService importCvtermService;

    /**
     * 查询ImportCvterm列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:cvterm:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImportCvterm importCvterm)
    {
        startPage();
        List<ImportCvterm> list = importCvtermService.selectImportCvtermList(importCvterm);
        return getDataTable(list);
    }

    /**
     * 导出ImportCvterm列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:cvterm:export')")
    @Log(title = "ImportCvterm", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImportCvterm importCvterm)
    {
        List<ImportCvterm> list = importCvtermService.selectImportCvtermList(importCvterm);
        ExcelUtil<ImportCvterm> util = new ExcelUtil<ImportCvterm>(ImportCvterm.class);
        util.exportExcel(response, list, "ImportCvterm数据");
    }

    /**
     * 获取ImportCvterm详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:cvterm:query')")
    @GetMapping(value = "/{cvtermId}")
    public AjaxResult getInfo(@PathVariable("cvtermId") String cvtermId)
    {
        return AjaxResult.success(importCvtermService.selectImportCvtermByCvtermId(cvtermId));
    }

    /**
     * 新增ImportCvterm
     */
    @PreAuthorize("@ss.hasPermi('zeamap:cvterm:add')")
    @Log(title = "ImportCvterm", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ImportCvterm importCvterm)
    {
        return toAjax(importCvtermService.insertImportCvterm(importCvterm));
    }

    /**
     * 修改ImportCvterm
     */
    @PreAuthorize("@ss.hasPermi('zeamap:cvterm:edit')")
    @Log(title = "ImportCvterm", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ImportCvterm importCvterm)
    {
        return toAjax(importCvtermService.updateImportCvterm(importCvterm));
    }

    /**
     * 删除ImportCvterm
     */
    @PreAuthorize("@ss.hasPermi('zeamap:cvterm:remove')")
    @Log(title = "ImportCvterm", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{cvtermIds}")
    public AjaxResult remove(@PathVariable String[] cvtermIds)
    {
        return toAjax(importCvtermService.deleteImportCvtermByCvtermIds(cvtermIds));
    }
}
