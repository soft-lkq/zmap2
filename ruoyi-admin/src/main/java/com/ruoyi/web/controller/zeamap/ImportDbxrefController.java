package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.ImportDbxref;
import com.ruoyi.zeamap.service.IImportDbxrefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 1Controller
 * 
 * @author ruoyi
 * @date 2023-03-14
 */
@RestController
@RequestMapping("/zeamap/ImportDbxref")
public class ImportDbxrefController extends BaseController
{
    @Autowired
    private IImportDbxrefService importDbxrefService;

    /**
     * 查询1列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportDbxref:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImportDbxref importDbxref)
    {
        startPage();
        List<ImportDbxref> list = importDbxrefService.selectImportDbxrefList(importDbxref);
        return getDataTable(list);
    }

    /**
     * 导出1列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportDbxref:export')")
    @Log(title = "1", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImportDbxref importDbxref)
    {
        List<ImportDbxref> list = importDbxrefService.selectImportDbxrefList(importDbxref);
        ExcelUtil<ImportDbxref> util = new ExcelUtil<ImportDbxref>(ImportDbxref.class);
        util.exportExcel(response, list, "1数据");
    }

    /**
     * 获取1详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportDbxref:query')")
    @GetMapping(value = "/{dbxrefId}")
    public AjaxResult getInfo(@PathVariable("dbxrefId") Long dbxrefId)
    {
        return AjaxResult.success(importDbxrefService.selectImportDbxrefByDbxrefId(dbxrefId));
    }

    /**
     * 新增1
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportDbxref:add')")
    @Log(title = "1", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ImportDbxref importDbxref)
    {
        return toAjax(importDbxrefService.insertImportDbxref(importDbxref));
    }

    /**
     * 修改1
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportDbxref:edit')")
    @Log(title = "1", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ImportDbxref importDbxref)
    {
        return toAjax(importDbxrefService.updateImportDbxref(importDbxref));
    }

    /**
     * 删除1
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportDbxref:remove')")
    @Log(title = "1", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{dbxrefIds}")
    public AjaxResult remove(@PathVariable Long[] dbxrefIds)
    {
        return toAjax(importDbxrefService.deleteImportDbxrefByDbxrefIds(dbxrefIds));
    }
}
