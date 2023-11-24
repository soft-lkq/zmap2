package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.ImportDb;
import com.ruoyi.zeamap.service.IImportDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * importdbController
 * 
 * @author ruoyi
 * @date 2023-05-26
 */
@RestController
@RequestMapping("/zeamap/ImportDb")
public class ImportDbController extends BaseController
{
    @Autowired
    private IImportDbService importDbService;

    /**
     * 查询importdb列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportDb:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImportDb importDb)
    {
        startPage();
        List<ImportDb> list = importDbService.selectImportDbList(importDb);
        return getDataTable(list);
    }

    /**
     * 导出importdb列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportDb:export')")
    @Log(title = "importdb", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImportDb importDb)
    {
        List<ImportDb> list = importDbService.selectImportDbList(importDb);
        ExcelUtil<ImportDb> util = new ExcelUtil<ImportDb>(ImportDb.class);
        util.exportExcel(response, list, "importdb数据");
    }

    /**
     * 获取importdb详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportDb:query')")
    @GetMapping(value = "/{dbId}")
    public AjaxResult getInfo(@PathVariable("dbId") Long dbId)
    {
        return AjaxResult.success(importDbService.selectImportDbByDbId(dbId));
    }

    /**
     * 新增importdb
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportDb:add')")
    @Log(title = "importdb", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ImportDb importDb)
    {
        return toAjax(importDbService.insertImportDb(importDb));
    }

    /**
     * 修改importdb
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportDb:edit')")
    @Log(title = "importdb", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ImportDb importDb)
    {
        return toAjax(importDbService.updateImportDb(importDb));
    }

    /**
     * 删除importdb
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportDb:remove')")
    @Log(title = "importdb", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{dbIds}")
    public AjaxResult remove(@PathVariable Long[] dbIds)
    {
        return toAjax(importDbService.deleteImportDbByDbIds(dbIds));
    }
}
