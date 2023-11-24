package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.ImportVariantInfo;
import com.ruoyi.zeamap.service.IImportVariantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * ImportInfoController
 * 
 * @author ruoyi
 * @date 2023-03-18
 */
@RestController
@RequestMapping("/zeamap/ImportVariantInfo")
public class ImportVariantInfoController extends BaseController
{
    @Autowired
    private IImportVariantInfoService importVariantInfoService;

    /**
     * 查询ImportInfo列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImportVariantInfo importVariantInfo)
    {
        startPage();
        List<ImportVariantInfo> list = importVariantInfoService.selectImportVariantInfoList(importVariantInfo);
        return getDataTable(list);
    }

    /**
     * 导出ImportInfo列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportInfo:export')")
    @Log(title = "ImportInfo", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImportVariantInfo importVariantInfo)
    {
        List<ImportVariantInfo> list = importVariantInfoService.selectImportVariantInfoList(importVariantInfo);
        ExcelUtil<ImportVariantInfo> util = new ExcelUtil<ImportVariantInfo>(ImportVariantInfo.class);
        util.exportExcel(response, list, "ImportInfo数据");
    }

    /**
     * 获取ImportInfo详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportInfo:query')")
    @GetMapping(value = "/{variantinfoId}")
    public AjaxResult getInfo(@PathVariable("variantinfoId") String variantinfoId)
    {
        return AjaxResult.success(importVariantInfoService.selectImportVariantInfoByVariantinfoId(variantinfoId));
    }

    /**
     * 新增ImportInfo
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportInfo:add')")
    @Log(title = "ImportInfo", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ImportVariantInfo importVariantInfo)
    {
        return toAjax(importVariantInfoService.insertImportVariantInfo(importVariantInfo));
    }

    /**
     * 修改ImportInfo
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportInfo:edit')")
    @Log(title = "ImportInfo", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ImportVariantInfo importVariantInfo)
    {
        return toAjax(importVariantInfoService.updateImportVariantInfo(importVariantInfo));
    }

    /**
     * 删除ImportInfo
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportInfo:remove')")
    @Log(title = "ImportInfo", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{variantinfoIds}")
    public AjaxResult remove(@PathVariable String[] variantinfoIds)
    {
        return toAjax(importVariantInfoService.deleteImportVariantInfoByVariantinfoIds(variantinfoIds));
    }
}
