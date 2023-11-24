package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.ImportLinkageQtl;
import com.ruoyi.zeamap.service.IImportLinkageQtlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * ImportLqtlController
 * 
 * @author ruoyi
 * @date 2023-03-20
 */
@RestController
@RequestMapping("/zeamap/ImportLqtl")
public class ImportLinkageQtlController extends BaseController
{
    @Autowired
    private IImportLinkageQtlService importLinkageQtlService;

    /**
     * 查询ImportLqtl列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportLqtl:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImportLinkageQtl importLinkageQtl)
    {
        startPage();
        List<ImportLinkageQtl> list = importLinkageQtlService.selectImportLinkageQtlList(importLinkageQtl);
        return getDataTable(list);
    }

    /**
     * 导出ImportLqtl列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportLqtl:export')")
    @Log(title = "ImportLqtl", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImportLinkageQtl importLinkageQtl)
    {
        List<ImportLinkageQtl> list = importLinkageQtlService.selectImportLinkageQtlList(importLinkageQtl);
        ExcelUtil<ImportLinkageQtl> util = new ExcelUtil<ImportLinkageQtl>(ImportLinkageQtl.class);
        util.exportExcel(response, list, "ImportLqtl数据");
    }

    /**
     * 获取ImportLqtl详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportLqtl:query')")
    @GetMapping(value = "/{linkageQtlId}")
    public AjaxResult getInfo(@PathVariable("linkageQtlId") Long linkageQtlId)
    {
        return AjaxResult.success(importLinkageQtlService.selectImportLinkageQtlByLinkageQtlId(linkageQtlId));
    }

    /**
     * 新增ImportLqtl
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportLqtl:add')")
    @Log(title = "ImportLqtl", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ImportLinkageQtl importLinkageQtl)
    {
        return toAjax(importLinkageQtlService.insertImportLinkageQtl(importLinkageQtl));
    }

    /**
     * 修改ImportLqtl
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportLqtl:edit')")
    @Log(title = "ImportLqtl", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ImportLinkageQtl importLinkageQtl)
    {
        return toAjax(importLinkageQtlService.updateImportLinkageQtl(importLinkageQtl));
    }

    /**
     * 删除ImportLqtl
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportLqtl:remove')")
    @Log(title = "ImportLqtl", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{linkageQtlIds}")
    public AjaxResult remove(@PathVariable Long[] linkageQtlIds)
    {
        return toAjax(importLinkageQtlService.deleteImportLinkageQtlByLinkageQtlIds(linkageQtlIds));
    }
}
