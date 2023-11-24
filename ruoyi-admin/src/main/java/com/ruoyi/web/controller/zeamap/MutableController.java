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
import com.ruoyi.zeamap.domain.Mutable;
import com.ruoyi.zeamap.service.IMutableService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * Location, TraitDateLoc,Year,Tissue 查找使用
Controller
 * 
 * @author ruoyi
 * @date 2023-01-08
 */
@RestController
@RequestMapping("/zeamap/mutable")
public class MutableController extends BaseController
{
    @Autowired
    private IMutableService mutableService;

    /**
     * 查询Location, TraitDateLoc,Year,Tissue 查找使用
列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:mutable:list')")
    @GetMapping("/list")
    public TableDataInfo list(Mutable mutable)
    {
        startPage();
        List<Mutable> list = mutableService.selectMutableList(mutable);
        return getDataTable(list);
    }

    /**
     * 导出Location, TraitDateLoc,Year,Tissue 查找使用
列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:mutable:export')")
    @Log(title = "Location, TraitDateLoc,Year,Tissue 查找使用 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Mutable mutable)
    {
        List<Mutable> list = mutableService.selectMutableList(mutable);
        ExcelUtil<Mutable> util = new ExcelUtil<Mutable>(Mutable.class);
        util.exportExcel(response, list, "Location, TraitDateLoc,Year,Tissue 查找使用数据");
    }

    /**
     * 获取Location, TraitDateLoc,Year,Tissue 查找使用
详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:mutable:query')")
    @GetMapping(value = "/{mutableId}")
    public AjaxResult getInfo(@PathVariable("mutableId") Long mutableId)
    {
        return AjaxResult.success(mutableService.selectMutableByMutableId(mutableId));
    }

    /**
     * 新增Location, TraitDateLoc,Year,Tissue 查找使用

     */
    @PreAuthorize("@ss.hasPermi('zeamap:mutable:add')")
    @Log(title = "Location, TraitDateLoc,Year,Tissue 查找使用", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Mutable mutable)
    {
        return toAjax(mutableService.insertMutable(mutable));
    }

    /**
     * 修改Location, TraitDateLoc,Year,Tissue 查找使用

     */
    @PreAuthorize("@ss.hasPermi('zeamap:mutable:edit')")
    @Log(title = "Location, TraitDateLoc,Year,Tissue 查找使用", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Mutable mutable)
    {
        return toAjax(mutableService.updateMutable(mutable));
    }

    /**
     * 删除Location, TraitDateLoc,Year,Tissue 查找使用

     */
    @PreAuthorize("@ss.hasPermi('zeamap:mutable:remove')")
    @Log(title = "Location, TraitDateLoc,Year,Tissue 查找使用", businessType = BusinessType.DELETE)
	@DeleteMapping("/{mutableIds}")
    public AjaxResult remove(@PathVariable Long[] mutableIds)
    {
        return toAjax(mutableService.deleteMutableByMutableIds(mutableIds));
    }



}
