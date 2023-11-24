package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.ImportTfbdInfo;
import com.ruoyi.zeamap.service.IImportTfbdInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * ImportController
 * 
 * @author ruoyi
 * @date 2023-04-06
 */
@RestController
@RequestMapping("/zeamap/ImportTfdbinfo")
public class ImportTfbdInfoController extends BaseController
{
    @Autowired
    private IImportTfbdInfoService importTfbdInfoService;

    /**
     * 查询Import列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImportTfbdInfo importTfbdInfo)
    {
        startPage();
        List<ImportTfbdInfo> list = importTfbdInfoService.selectImportTfbdInfoList(importTfbdInfo);
        return getDataTable(list);
    }

    /**
     * 导出Import列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:info:export')")
    @Log(title = "Import", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImportTfbdInfo importTfbdInfo)
    {
        List<ImportTfbdInfo> list = importTfbdInfoService.selectImportTfbdInfoList(importTfbdInfo);
        ExcelUtil<ImportTfbdInfo> util = new ExcelUtil<ImportTfbdInfo>(ImportTfbdInfo.class);
        util.exportExcel(response, list, "Import数据");
    }

    /**
     * 获取Import详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:info:query')")
    @GetMapping(value = "/{tfbdId}")
    public AjaxResult getInfo(@PathVariable("tfbdId") Long tfbdId)
    {
        return AjaxResult.success(importTfbdInfoService.selectImportTfbdInfoByTfbdId(tfbdId));
    }

    /**
     * 新增Import
     */
    @PreAuthorize("@ss.hasPermi('zeamap:info:add')")
    @Log(title = "Import", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ImportTfbdInfo importTfbdInfo)
    {
        return toAjax(importTfbdInfoService.insertImportTfbdInfo(importTfbdInfo));
    }

    /**
     * 修改Import
     */
    @PreAuthorize("@ss.hasPermi('zeamap:info:edit')")
    @Log(title = "Import", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ImportTfbdInfo importTfbdInfo)
    {
        return toAjax(importTfbdInfoService.updateImportTfbdInfo(importTfbdInfo));
    }

    /**
     * 删除Import
     */
    @PreAuthorize("@ss.hasPermi('zeamap:info:remove')")
    @Log(title = "Import", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{tfbdIds}")
    public AjaxResult remove(@PathVariable Long[] tfbdIds)
    {
        return toAjax(importTfbdInfoService.deleteImportTfbdInfoByTfbdIds(tfbdIds));
    }
}
