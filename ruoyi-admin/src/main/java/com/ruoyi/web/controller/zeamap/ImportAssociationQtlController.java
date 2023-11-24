package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.ImportAssociationQtl;
import com.ruoyi.zeamap.service.IImportAssociationQtlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * ImportAqtlController
 * 
 * @author ruoyi
 * @date 2023-03-18
 */
@RestController
@RequestMapping("/zeamap/ImportAqtl")
public class ImportAssociationQtlController extends BaseController
{
    @Autowired
    private IImportAssociationQtlService importAssociationQtlService;

    /**
     * 查询ImportAqtl列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportAqtl:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImportAssociationQtl importAssociationQtl)
    {
        startPage();
        List<ImportAssociationQtl> list = importAssociationQtlService.selectImportAssociationQtlList(importAssociationQtl);
        return getDataTable(list);
    }

    /**
     * 导出ImportAqtl列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportAqtl:export')")
    @Log(title = "ImportAqtl", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImportAssociationQtl importAssociationQtl)
    {
        List<ImportAssociationQtl> list = importAssociationQtlService.selectImportAssociationQtlList(importAssociationQtl);
        ExcelUtil<ImportAssociationQtl> util = new ExcelUtil<ImportAssociationQtl>(ImportAssociationQtl.class);
        util.exportExcel(response, list, "ImportAqtl数据");
    }

    /**
     * 获取ImportAqtl详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportAqtl:query')")
    @GetMapping(value = "/{associationQtlId}")
    public AjaxResult getInfo(@PathVariable("associationQtlId") Long associationQtlId)
    {
        return AjaxResult.success(importAssociationQtlService.selectImportAssociationQtlByAssociationQtlId(associationQtlId));
    }

    /**
     * 新增ImportAqtl
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportAqtl:add')")
    @Log(title = "ImportAqtl", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ImportAssociationQtl importAssociationQtl)
    {
        return toAjax(importAssociationQtlService.insertImportAssociationQtl(importAssociationQtl));
    }

    /**
     * 修改ImportAqtl
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportAqtl:edit')")
    @Log(title = "ImportAqtl", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ImportAssociationQtl importAssociationQtl)
    {
        return toAjax(importAssociationQtlService.updateImportAssociationQtl(importAssociationQtl));
    }

    /**
     * 删除ImportAqtl
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportAqtl:remove')")
    @Log(title = "ImportAqtl", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{associationQtlIds}")
    public AjaxResult remove(@PathVariable Long[] associationQtlIds)
    {
        return toAjax(importAssociationQtlService.deleteImportAssociationQtlByAssociationQtlIds(associationQtlIds));
    }
}
