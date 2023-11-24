package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.ImportXotGermplasm;
import com.ruoyi.zeamap.service.IImportXotGermplasmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * importController
 * 
 * @author ruoyi
 * @date 2023-04-11
 */
@RestController
@RequestMapping("/zeamap/importXotGermplasm")
public class ImportXotGermplasmController extends BaseController
{
    @Autowired
    private IImportXotGermplasmService importXotGermplasmService;

    /**
     * 查询import列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:importxotgermplasm:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImportXotGermplasm importXotGermplasm)
    {
        startPage();
        List<ImportXotGermplasm> list = importXotGermplasmService.selectImportXotGermplasmList(importXotGermplasm);
        return getDataTable(list);
    }

    /**
     * 导出import列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:importxotgermplasm:export')")
    @Log(title = "import", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImportXotGermplasm importXotGermplasm)
    {
        List<ImportXotGermplasm> list = importXotGermplasmService.selectImportXotGermplasmList(importXotGermplasm);
        ExcelUtil<ImportXotGermplasm> util = new ExcelUtil<ImportXotGermplasm>(ImportXotGermplasm.class);
        util.exportExcel(response, list, "import数据");
    }

    /**
     * 获取import详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:importxotgermplasm:query')")
    @GetMapping(value = "/{xotGermplasmId}")
    public AjaxResult getInfo(@PathVariable("xotGermplasmId") Long xotGermplasmId)
    {
        return AjaxResult.success(importXotGermplasmService.selectImportXotGermplasmByXotGermplasmId(xotGermplasmId));
    }

    /**
     * 新增import
     */
    @PreAuthorize("@ss.hasPermi('zeamap:importxotgermplasm:add')")
    @Log(title = "import", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ImportXotGermplasm importXotGermplasm)
    {
        return toAjax(importXotGermplasmService.insertImportXotGermplasm(importXotGermplasm));
    }

    /**
     * 修改import
     */
    @PreAuthorize("@ss.hasPermi('zeamap:importxotgermplasm:edit')")
    @Log(title = "import", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ImportXotGermplasm importXotGermplasm)
    {
        return toAjax(importXotGermplasmService.updateImportXotGermplasm(importXotGermplasm));
    }

    /**
     * 删除import
     */
    @PreAuthorize("@ss.hasPermi('zeamap:importxotgermplasm:remove')")
    @Log(title = "import", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{xotGermplasmIds}")
    public AjaxResult remove(@PathVariable Long[] xotGermplasmIds)
    {
        return toAjax(importXotGermplasmService.deleteImportXotGermplasmByXotGermplasmIds(xotGermplasmIds));
    }
}
