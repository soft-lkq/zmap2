package com.ruoyi.web.controller.zeamap;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.zeamap.domain.Tissue;
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
import com.ruoyi.zeamap.domain.Environment;
import com.ruoyi.zeamap.service.IEnvironmentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * environmentController
 * 
 * @author ruoyi
 * @date 2023-01-10
 */
@RestController
@RequestMapping("/zeamap/environment")
public class EnvironmentController extends BaseController
{
    @Autowired
    private IEnvironmentService environmentService;

    /**
     * 查询environment列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:environment:list')")
    @GetMapping("/list")
    public TableDataInfo list(Environment environment)
    {
        startPage();
        List<Environment> list = environmentService.selectEnvironmentList(environment);
        return getDataTable(list);
    }

    /**
     * 导出environment列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:environment:export')")
    @Log(title = "environment", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Environment environment)
    {
        List<Environment> list = environmentService.selectEnvironmentList(environment);
        ExcelUtil<Environment> util = new ExcelUtil<Environment>(Environment.class);
        util.exportExcel(response, list, "environment数据");
    }

    /**
     * 获取environment详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:environment:query')")
    @GetMapping(value = "/{environmentId}")
    public AjaxResult getInfo(@PathVariable("environmentId") Long environmentId)
    {
        return AjaxResult.success(environmentService.selectEnvironmentByEnvironmentId(environmentId));
    }

    /**
     * 新增environment
     */
    @PreAuthorize("@ss.hasPermi('zeamap:environment:add')")
    @Log(title = "environment", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Environment environment)
    {
        return toAjax(environmentService.insertEnvironment(environment));
    }

    /**
     * 修改environment
     */
    @PreAuthorize("@ss.hasPermi('zeamap:environment:edit')")
    @Log(title = "environment", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Environment environment)
    {
        return toAjax(environmentService.updateEnvironment(environment));
    }

    /**
     * 删除environment
     */
    @PreAuthorize("@ss.hasPermi('zeamap:environment:remove')")
    @Log(title = "environment", businessType = BusinessType.DELETE)
	@DeleteMapping("/{environmentIds}")
    public AjaxResult remove(@PathVariable Long[] environmentIds)
    {
        return toAjax(environmentService.deleteEnvironmentByEnvironmentIds(environmentIds));
    }

    @GetMapping("/multi")
    public AjaxResult selectorClassDesc(){

        return AjaxResult.success(environmentService.SelectorClassDesc());
    }

}
