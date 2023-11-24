package com.ruoyi.web.controller.zeamap;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.Trait;
import com.ruoyi.zeamap.service.ITraitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2023-07-03
 */
@RestController
@RequestMapping("/trait")
public class TraitController extends BaseController
{
    @Autowired
    private ITraitService traitService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:trait:list')")
    @GetMapping("/list")
    public TableDataInfo list(Trait trait)
    {
        startPage();
        List<Trait> list = traitService.selectTraitList(trait);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:trait:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Trait trait)
    {
        List<Trait> list = traitService.selectTraitList(trait);
        ExcelUtil<Trait> util = new ExcelUtil<Trait>(Trait.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:trait:query')")
    @GetMapping(value = "/{traitId}")
    public AjaxResult getInfo(@PathVariable("traitId") Long traitId)
    {
        return AjaxResult.success(traitService.selectTraitByTraitId(traitId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:trait:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Trait trait)
    {
        return toAjax(traitService.insertTrait(trait));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:trait:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Trait trait)
    {
        return toAjax(traitService.updateTrait(trait));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:trait:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{traitIds}")
    public AjaxResult remove(@PathVariable Long[] traitIds)
    {
        return toAjax(traitService.deleteTraitByTraitIds(traitIds));
    }




    @GetMapping("/getTraitByType")
    public AjaxResult getTraitByType(Long typeId){
        if(typeId==null||typeId==0)
            return AjaxResult.error("不存在");
        List<Trait> list =traitService.getTraitByType(typeId);
        return AjaxResult.success(list);
    }


    //1.6 大查询 模糊匹配 根据性状名称模糊匹配
    @PreAuthorize("@ss.hasPermi('system:trait:list')")
    @PostMapping("/selectTrait")
    public TableDataInfo selectTrait(Trait trait) {
        startPage();
        List<Trait> list = traitService.selectTrait(trait.getTraitName());
        return getDataTable(list);
    }

    //1.6 查询是否存在输入的name
    @PreAuthorize("@ss.hasPermi('system:population:list')")
    @PostMapping("/checkTraitName")
    public AjaxResult checkTraitName(@RequestBody Trait trait) {
        Integer tra = traitService.checkTraitName(trait.getTraitName());
        return AjaxResult.success(tra);
    }

    //1.6 1.7 下载
    @PreAuthorize("@ss.hasPermi('system:trait:download')")
    @RequestMapping("/download")
    public void download(HttpServletResponse response, @RequestBody List<Long> list) {
        try {
            List<Trait> alist = new ArrayList<>();
            for (Long id : list) {
                Trait trait = traitService.selectTraitByTraitId(id);
                alist.add(trait);
            }
            ExcelUtil<Trait> util = new ExcelUtil<>(Trait.class);
            util.exportExcel(response, alist, "查询数据 Trait");
        } catch (Exception ex) {
            logger.error("添加信息异常", ex);
        }
    }

}
