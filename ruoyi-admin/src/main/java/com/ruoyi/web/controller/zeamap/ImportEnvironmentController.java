package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.ImportEnvironment;
import com.ruoyi.zeamap.service.IImportEnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * ImportEnvironmentController
 * 
 * @author ruoyi
 * @date 2023-04-09
 */
@RestController
@RequestMapping("/zeamap/ImportEnvironment")
public class ImportEnvironmentController extends BaseController
{
    @Autowired
    private IImportEnvironmentService importEnvironmentService;

    /**
     * 查询ImportEnvironment列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Import:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImportEnvironment importEnvironment)
    {
        startPage();
        List<ImportEnvironment> list = importEnvironmentService.selectImportEnvironmentList(importEnvironment);
        return getDataTable(list);
    }

    /**
     * 导出ImportEnvironment列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Import:export')")
    @Log(title = "ImportEnvironment", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImportEnvironment importEnvironment)
    {
        List<ImportEnvironment> list = importEnvironmentService.selectImportEnvironmentList(importEnvironment);
        ExcelUtil<ImportEnvironment> util = new ExcelUtil<ImportEnvironment>(ImportEnvironment.class);
        util.exportExcel(response, list, "ImportEnvironment数据");
    }

    /**
     * 获取ImportEnvironment详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Import:query')")
    @GetMapping(value = "/{environmentId}")
    public AjaxResult getInfo(@PathVariable("environmentId") Long environmentId)
    {
        return AjaxResult.success(importEnvironmentService.selectImportEnvironmentByEnvironmentId(environmentId));
    }

    /**
     * 新增ImportEnvironment
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Import:add')")
    @Log(title = "ImportEnvironment", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ImportEnvironment importEnvironment)
    {
        return toAjax(importEnvironmentService.insertImportEnvironment(importEnvironment));
    }

    /**
     * 修改ImportEnvironment
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Import:edit')")
    @Log(title = "ImportEnvironment", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ImportEnvironment importEnvironment)
    {
        return toAjax(importEnvironmentService.updateImportEnvironment(importEnvironment));
    }

    /**
     * 删除ImportEnvironment
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Import:remove')")
    @Log(title = "ImportEnvironment", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{environmentIds}")
    public AjaxResult remove(@PathVariable Long[] environmentIds)
    {
        return toAjax(importEnvironmentService.deleteImportEnvironmentByEnvironmentIds(environmentIds));
    }
}
