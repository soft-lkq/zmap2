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
import com.ruoyi.zeamap.domain.Subgroup;
import com.ruoyi.zeamap.service.ISubgroupService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
@RestController
@RequestMapping("/zeamap/subgroup")
public class SubgroupController extends BaseController
{
    @Autowired
    private ISubgroupService subgroupService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:subgroup:list')")
    @GetMapping("/list")
    public TableDataInfo list(Subgroup subgroup)
    {
        startPage();
        List<Subgroup> list = subgroupService.selectSubgroupList(subgroup);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:subgroup:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Subgroup subgroup)
    {
        List<Subgroup> list = subgroupService.selectSubgroupList(subgroup);
        ExcelUtil<Subgroup> util = new ExcelUtil<Subgroup>(Subgroup.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:subgroup:query')")
    @GetMapping(value = "/{subgroupId}")
    public AjaxResult getInfo(@PathVariable("subgroupId") Long subgroupId)
    {
        return AjaxResult.success(subgroupService.selectSubgroupBySubgroupId(subgroupId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('zeamap:subgroup:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Subgroup subgroup)
    {
        return toAjax(subgroupService.insertSubgroup(subgroup));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('zeamap:subgroup:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Subgroup subgroup)
    {
        return toAjax(subgroupService.updateSubgroup(subgroup));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('zeamap:subgroup:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{subgroupIds}")
    public AjaxResult remove(@PathVariable Long[] subgroupIds)
    {
        return toAjax(subgroupService.deleteSubgroupBySubgroupIds(subgroupIds));
    }
}
