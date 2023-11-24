package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.ImportCv;
import com.ruoyi.zeamap.service.IImportCvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * ImportCvController
 * 
 * @author ruoyi
 * @date 2023-03-30
 */
@RestController
@RequestMapping("/zeamap/ImportCv")
public class ImportCvController extends BaseController
{
    @Autowired
    private IImportCvService importCvService;

    /**
     * 查询ImportCv列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:cv:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImportCv importCv)
    {
        startPage();
        List<ImportCv> list = importCvService.selectImportCvList(importCv);
        return getDataTable(list);
    }

    /**
     * 导出ImportCv列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:cv:export')")
    @Log(title = "ImportCv", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImportCv importCv)
    {
        List<ImportCv> list = importCvService.selectImportCvList(importCv);
        ExcelUtil<ImportCv> util = new ExcelUtil<ImportCv>(ImportCv.class);
        util.exportExcel(response, list, "ImportCv数据");
    }

    /**
     * 获取ImportCv详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:cv:query')")
    @GetMapping(value = "/{cvId}")
    public AjaxResult getInfo(@PathVariable("cvId") String cvId)
    {
        return AjaxResult.success(importCvService.selectImportCvByCvId(cvId));
    }

    /**
     * 新增ImportCv
     */
    @PreAuthorize("@ss.hasPermi('zeamap:cv:add')")
    @Log(title = "ImportCv", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ImportCv importCv)
    {
        return toAjax(importCvService.insertImportCv(importCv));
    }

    /**
     * 修改ImportCv
     */
    @PreAuthorize("@ss.hasPermi('zeamap:cv:edit')")
    @Log(title = "ImportCv", businessType = BusinessType.UPDATE)
    @PutMapping("edit")
    public AjaxResult edit(@RequestBody ImportCv importCv)
    {
        return toAjax(importCvService.updateImportCv(importCv));
    }

    /**
     * 删除ImportCv
     */
    @PreAuthorize("@ss.hasPermi('zeamap:cv:remove')")
    @Log(title = "ImportCv", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{cvIds}")
    public AjaxResult remove(@PathVariable String[] cvIds)
    {
        return toAjax(importCvService.deleteImportCvByCvIds(cvIds));
    }
}
