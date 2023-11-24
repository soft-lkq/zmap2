package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.ImportTissue;
import com.ruoyi.zeamap.service.IImportTissueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 组织Controller
 * 
 * @author ruoyi
 * @date 2023-03-22
 */
@RestController
@RequestMapping("/zeamap/ImportTissue")
public class ImportTissueController extends BaseController
{
    @Autowired
    private IImportTissueService importTissueService;

    /**
     * 查询组织列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportTissue:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImportTissue importTissue)
    {
        startPage();
        List<ImportTissue> list = importTissueService.selectImportTissueList(importTissue);
        return getDataTable(list);
    }

    /**
     * 导出组织列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportTissue:export')")
    @Log(title = "组织", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImportTissue importTissue)
    {
        List<ImportTissue> list = importTissueService.selectImportTissueList(importTissue);
        ExcelUtil<ImportTissue> util = new ExcelUtil<ImportTissue>(ImportTissue.class);
        util.exportExcel(response, list, "组织数据");
    }

    /**
     * 获取组织详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportTissue:query')")
    @GetMapping(value = "/{tissueId}")
    public AjaxResult getInfo(@PathVariable("tissueId") Long tissueId)
    {
        return AjaxResult.success(importTissueService.selectImportTissueByTissueId(tissueId));
    }

    /**
     * 新增组织
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportTissue:add')")
    @Log(title = "组织", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody ImportTissue importTissue)
    {
        return toAjax(importTissueService.insertImportTissue(importTissue));
    }

    /**
     * 修改组织
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportTissue:edit')")
    @Log(title = "组织", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ImportTissue importTissue)
    {
        return toAjax(importTissueService.updateImportTissue(importTissue));
    }

    /**
     * 删除组织
     */
    @PreAuthorize("@ss.hasPermi('zeamap:ImportTissue:remove')")
    @Log(title = "组织", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{tissueIds}")
    public AjaxResult remove(@PathVariable Long[] tissueIds)
    {
        return toAjax(importTissueService.deleteImportTissueByTissueIds(tissueIds));
    }
}
