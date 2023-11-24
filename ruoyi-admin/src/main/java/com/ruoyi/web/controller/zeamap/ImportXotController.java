package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.ImportXot;
import com.ruoyi.zeamap.service.IImportXotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 1Controller
 * 
 * @author ruoyi
 * @date 2023-03-15
 */
@RestController
@RequestMapping("/zeamap/ImportXot")
public class ImportXotController extends BaseController
{
    @Autowired
    private IImportXotService importXotService;

    /**
     * 查询1列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportXot:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImportXot importXot)
    {
        startPage();
        List<ImportXot> list = importXotService.selectImportXotList(importXot);
        return getDataTable(list);
    }

    /**
     * 导出1列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportXot:export')")
    @Log(title = "1", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImportXot importXot)
    {
        List<ImportXot> list = importXotService.selectImportXotList(importXot);
        ExcelUtil<ImportXot> util = new ExcelUtil<ImportXot>(ImportXot.class);
        util.exportExcel(response, list, "1数据");
    }

    /**
     * 获取1详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportXot:query')")
    @GetMapping(value = "/{xotId}")
    public AjaxResult getInfo(@PathVariable("xotId") Long xotId)
    {
        return AjaxResult.success(importXotService.selectImportXotByXotId(xotId));
    }

    /**
     * 新增1
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportXot:add')")
    @Log(title = "1", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ImportXot importXot)
    {
        return toAjax(importXotService.insertImportXot(importXot));
    }

    /**
     * 修改1
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportXot:edit')")
    @Log(title = "1", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ImportXot importXot)
    {
        return toAjax(importXotService.updateImportXot(importXot));
    }

    /**
     * 删除1
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportXot:remove')")
    @Log(title = "1", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{xotIds}")
    public AjaxResult remove(@PathVariable Long[] xotIds)
    {
        return toAjax(importXotService.deleteImportXotByXotIds(xotIds));
    }
}
