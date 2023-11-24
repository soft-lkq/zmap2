package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.ImportAssociationMarker;
import com.ruoyi.zeamap.service.IImportAssociationMarkerService;
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
@RequestMapping("/zeamap/ImportAssociationMarker")
public class ImportAssociationMarkerController extends BaseController
{
    @Autowired
    private IImportAssociationMarkerService importAssociationMarkerService;

    /**
     * 查询Import列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportMarker:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImportAssociationMarker importAssociationMarker)
    {
        startPage();
        List<ImportAssociationMarker> list = importAssociationMarkerService.selectImportAssociationMarkerList(importAssociationMarker);
        return getDataTable(list);
    }

    /**
     * 导出Import列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportMarker:export')")
    @Log(title = "Import", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImportAssociationMarker importAssociationMarker)
    {
        List<ImportAssociationMarker> list = importAssociationMarkerService.selectImportAssociationMarkerList(importAssociationMarker);
        ExcelUtil<ImportAssociationMarker> util = new ExcelUtil<ImportAssociationMarker>(ImportAssociationMarker.class);
        util.exportExcel(response, list, "Import数据");
    }

    /**
     * 获取Import详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportMarker:query')")
    @GetMapping(value = "/{associationMarkerId}")
    public AjaxResult getInfo(@PathVariable("associationMarkerId") Long associationMarkerId)
    {
        return AjaxResult.success(importAssociationMarkerService.selectImportAssociationMarkerByAssociationMarkerId(associationMarkerId));
    }

    /**
     * 新增Import
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportMarker:add')")
    @Log(title = "Import", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ImportAssociationMarker importAssociationMarker)
    {
        return toAjax(importAssociationMarkerService.insertImportAssociationMarker(importAssociationMarker));
    }

    /**
     * 修改Import
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportMarker:edit')")
    @Log(title = "Import", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ImportAssociationMarker importAssociationMarker)
    {
        return toAjax(importAssociationMarkerService.updateImportAssociationMarker(importAssociationMarker));
    }

    /**
     * 删除Import
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportMarker:remove')")
    @Log(title = "Import", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{associationMarkerIds}")
    public AjaxResult remove(@PathVariable Long[] associationMarkerIds)
    {
        return toAjax(importAssociationMarkerService.deleteImportAssociationMarkerByAssociationMarkerIds(associationMarkerIds));
    }
}
