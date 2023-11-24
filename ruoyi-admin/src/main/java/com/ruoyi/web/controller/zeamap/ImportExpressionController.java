package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.ImportExpression;
import com.ruoyi.zeamap.service.IImportExpressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 基因表达量查询Controller
 * 
 * @author ruoyi
 * @date 2023-03-22
 */
@RestController
@RequestMapping("/zeamap/ImportExpression")
public class ImportExpressionController extends BaseController
{
    @Autowired
    private IImportExpressionService importExpressionService;

    /**
     * 查询基因表达量查询列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:expression:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImportExpression importExpression)
    {
        startPage();
        List<ImportExpression> list = importExpressionService.selectImportExpressionList(importExpression);
        return getDataTable(list);
    }

    /**
     * 导出基因表达量查询列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:expression:export')")
    @Log(title = "基因表达量查询", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImportExpression importExpression)
    {
        List<ImportExpression> list = importExpressionService.selectImportExpressionList(importExpression);
        ExcelUtil<ImportExpression> util = new ExcelUtil<ImportExpression>(ImportExpression.class);
        util.exportExcel(response, list, "基因表达量查询数据");
    }

    /**
     * 获取基因表达量查询详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:expression:query')")
    @GetMapping(value = "/{expressionId}")
    public AjaxResult getInfo(@PathVariable("expressionId") Long expressionId)
    {
        return AjaxResult.success(importExpressionService.selectImportExpressionByExpressionId(expressionId));
    }

    /**
     * 新增基因表达量查询
     */
    @PreAuthorize("@ss.hasPermi('zeamap:expression:add')")
    @Log(title = "基因表达量查询", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ImportExpression importExpression)
    {
        return toAjax(importExpressionService.insertImportExpression(importExpression));
    }

    /**
     * 修改基因表达量查询
     */
    @PreAuthorize("@ss.hasPermi('zeamap:expression:edit')")
    @Log(title = "基因表达量查询", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ImportExpression importExpression)
    {
        return toAjax(importExpressionService.updateImportExpression(importExpression));
    }

    /**
     * 删除基因表达量查询
     */
    @PreAuthorize("@ss.hasPermi('zeamap:expression:remove')")
    @Log(title = "基因表达量查询", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{expressionIds}")
    public AjaxResult remove(@PathVariable Long[] expressionIds)
    {
        return toAjax(importExpressionService.deleteImportExpressionByExpressionIds(expressionIds));
    }
}
