package com.ruoyi.web.controller.zeamap;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.zeamap.domain.Tissue;
import com.ruoyi.zeamap.service.ITissueService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 组织Controller
 * 
 * @author ruoyi
 * @date 2022-11-19
 */
@RestController
@RequestMapping("/zeamap/tissue")
public class TissueController extends BaseController
{
    @Autowired
    private ITissueService tissueService;

    /**
     * 查询组织列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:tissue:list')")
    @GetMapping("/list")
    public TableDataInfo list(Tissue tissue)
    {
        startPage();
        List<Tissue> list = tissueService.selectTissueList(tissue);
        return getDataTable(list);
    }

    /**
     * 导出组织列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:tissue:export')")
    @Log(title = "组织", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Tissue tissue)
    {
        List<Tissue> list = tissueService.selectTissueList(tissue);
        ExcelUtil<Tissue> util = new ExcelUtil<Tissue>(Tissue.class);
        util.exportExcel(response, list, "组织数据");
    }

    /**
     * 获取组织详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:tissue:query')")
    @GetMapping(value = "/{tissueId}")
    public AjaxResult getInfo(@PathVariable("tissueId") Long tissueId)
    {
        return AjaxResult.success(tissueService.selectTissueByTissueId(tissueId));
    }

    /**
     * 新增组织
     */
    @PreAuthorize("@ss.hasPermi('zeamap:tissue:add')")
    @Log(title = "组织", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Tissue tissue)
    {
        return toAjax(tissueService.insertTissue(tissue));
    }

    /**
     * 修改组织
     */
    @PreAuthorize("@ss.hasPermi('zeamap:tissue:edit')")
    @Log(title = "组织", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Tissue tissue)
    {
        return toAjax(tissueService.updateTissue(tissue));
    }

    /**
     * 删除组织
     */
    @PreAuthorize("@ss.hasPermi('zeamap:tissue:remove')")
    @Log(title = "组织", businessType = BusinessType.DELETE)
	@DeleteMapping("/{tissueIds}")
    public AjaxResult remove(@PathVariable Long[] tissueIds)
    {
        return toAjax(tissueService.deleteTissueByTissueIds(tissueIds));
    }

    /**
     * 5.2 Multi expression viewer Filter选中Tissue中Selector 所需的信息
     * @return
     */
    @GetMapping("/multi")
    public AjaxResult selectorClassDesc(){

        return AjaxResult.success(tissueService.SelectorClassDesc());
    }


}
