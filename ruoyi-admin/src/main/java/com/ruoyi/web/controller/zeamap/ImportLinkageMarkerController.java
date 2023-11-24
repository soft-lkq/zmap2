package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.ImportLinkageMarker;
import com.ruoyi.zeamap.service.IImportLinkageMarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * ImportController
 * 
 * @author ruoyi
 * @date 2023-03-21
 */
@RestController
@RequestMapping("/zeamap/ImportLmarker")
public class ImportLinkageMarkerController extends BaseController
{
    @Autowired
    private IImportLinkageMarkerService importLinkageMarkerService;

    /**
     * 查询Import列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Importmarker:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImportLinkageMarker importLinkageMarker)
    {
        startPage();
        List<ImportLinkageMarker> list = importLinkageMarkerService.selectImportLinkageMarkerList(importLinkageMarker);
        return getDataTable(list);
    }

    /**
     * 导出Import列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Importmarker:export')")
    @Log(title = "Import", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImportLinkageMarker importLinkageMarker)
    {
        List<ImportLinkageMarker> list = importLinkageMarkerService.selectImportLinkageMarkerList(importLinkageMarker);
        ExcelUtil<ImportLinkageMarker> util = new ExcelUtil<ImportLinkageMarker>(ImportLinkageMarker.class);
        util.exportExcel(response, list, "Import数据");
    }

    /**
     * 获取Import详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Importmarker:query')")
    @GetMapping(value = "/{linkageMarkerId}")
    public AjaxResult getInfo(@PathVariable("linkageMarkerId") Long linkageMarkerId)
    {
        return AjaxResult.success(importLinkageMarkerService.selectImportLinkageMarkerByLinkageMarkerId(linkageMarkerId));
    }

    /**
     * 新增Import
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Importmarker:add')")
    @Log(title = "Import", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ImportLinkageMarker importLinkageMarker)
    {
        return toAjax(importLinkageMarkerService.insertImportLinkageMarker(importLinkageMarker));
    }

    /**
     * 修改Import
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Importmarker:edit')")
    @Log(title = "Import", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ImportLinkageMarker importLinkageMarker)
    {
        return toAjax(importLinkageMarkerService.updateImportLinkageMarker(importLinkageMarker));
    }

    /**
     * 删除Import
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Importmarker:remove')")
    @Log(title = "Import", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{linkageMarkerIds}")
    public AjaxResult remove(@PathVariable Long[] linkageMarkerIds)
    {
        return toAjax(importLinkageMarkerService.deleteImportLinkageMarkerByLinkageMarkerIds(linkageMarkerIds));
    }
}
