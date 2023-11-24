package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.ImportSubgroup;
import com.ruoyi.zeamap.service.IImportSubgroupService;
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
@RequestMapping("/zeamap/ImportSubgroup")
public class ImportSubgroupController extends BaseController
{
    @Autowired
    private IImportSubgroupService importSubgroupService;

    /**
     * 查询Import列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:subgroup:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImportSubgroup importSubgroup)
    {
        startPage();
        List<ImportSubgroup> list = importSubgroupService.selectImportSubgroupList(importSubgroup);
        return getDataTable(list);
    }

    /**
     * 导出Import列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:subgroup:export')")
    @Log(title = "Import", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImportSubgroup importSubgroup)
    {
        List<ImportSubgroup> list = importSubgroupService.selectImportSubgroupList(importSubgroup);
        ExcelUtil<ImportSubgroup> util = new ExcelUtil<ImportSubgroup>(ImportSubgroup.class);
        util.exportExcel(response, list, "Import数据");
    }

    /**
     * 获取Import详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:subgroup:query')")
    @GetMapping(value = "/{subgroupId}")
    public AjaxResult getInfo(@PathVariable("subgroupId") Long subgroupId)
    {
        return AjaxResult.success(importSubgroupService.selectImportSubgroupBySubgroupId(subgroupId));
    }

    /**
     * 新增Import
     */
    @PreAuthorize("@ss.hasPermi('zeamap:subgroup:add')")
    @Log(title = "Import", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ImportSubgroup importSubgroup)
    {
        return toAjax(importSubgroupService.insertImportSubgroup(importSubgroup));
    }

    /**
     * 修改Import
     */
    @PreAuthorize("@ss.hasPermi('zeamap:subgroup:edit')")
    @Log(title = "Import", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ImportSubgroup importSubgroup)
    {
        return toAjax(importSubgroupService.updateImportSubgroup(importSubgroup));
    }

    /**
     * 删除Import
     */
    @PreAuthorize("@ss.hasPermi('zeamap:subgroup:remove')")
    @Log(title = "Import", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{subgroupIds}")
    public AjaxResult remove(@PathVariable Long[] subgroupIds)
    {
        return toAjax(importSubgroupService.deleteImportSubgroupBySubgroupIds(subgroupIds));
    }
}
