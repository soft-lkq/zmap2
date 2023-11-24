package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.ImportMutable;
import com.ruoyi.zeamap.service.IImportMutableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * ImportMutableController
 * 
 * @author ruoyi
 * @date 2023-03-15
 */
@RestController
@RequestMapping("/zeamap/ImportMutable")
public class ImportMutableController extends BaseController
{
    @Autowired
    private IImportMutableService importMutableService;

    /**
     * 查询ImportMutable列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportMutable:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImportMutable importMutable)
    {
        startPage();
        List<ImportMutable> list = importMutableService.selectImportMutableList(importMutable);
        return getDataTable(list);
    }

    /**
     * 导出ImportMutable列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportMutable:export')")
    @Log(title = "ImportMutable", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImportMutable importMutable)
    {
        List<ImportMutable> list = importMutableService.selectImportMutableList(importMutable);
        ExcelUtil<ImportMutable> util = new ExcelUtil<ImportMutable>(ImportMutable.class);
        util.exportExcel(response, list, "ImportMutable数据");
    }

    /**
     * 获取ImportMutable详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportMutable:query')")
    @GetMapping(value = "/{mutableId}")
    public AjaxResult getInfo(@PathVariable("mutableId") Long mutableId)
    {
        return AjaxResult.success(importMutableService.selectImportMutableByMutableId(mutableId));
    }

    /**
     * 新增ImportMutable
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportMutable:add')")
    @Log(title = "ImportMutable", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ImportMutable importMutable)
    {
        return toAjax(importMutableService.insertImportMutable(importMutable));
    }

    /**
     * 修改ImportMutable
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportMutable:edit')")
    @Log(title = "ImportMutable", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ImportMutable importMutable)
    {
        return toAjax(importMutableService.updateImportMutable(importMutable));
    }

    /**
     * 删除ImportMutable
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportMutable:remove')")
    @Log(title = "ImportMutable", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{mutableIds}")
    public AjaxResult remove(@PathVariable Long[] mutableIds)
    {
        return toAjax(importMutableService.deleteImportMutableByMutableIds(mutableIds));
    }
}
