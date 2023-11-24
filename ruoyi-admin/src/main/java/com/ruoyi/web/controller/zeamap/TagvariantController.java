package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.TagvSelectCondition;
import com.ruoyi.zeamap.domain.Tagvariant;
import com.ruoyi.zeamap.service.ITagvariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2023-04-29
 */
@RestController
@RequestMapping("/variations/tagvariant")
public class TagvariantController extends BaseController {
    @Autowired
    private ITagvariantService tagvariantService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:tagvariant:list')")
    @GetMapping("/list")
    public TableDataInfo list(Tagvariant tagvariant) {
        startPage();
        List<Tagvariant> list = tagvariantService.selectTagvariantList(tagvariant);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:tagvariant:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Tagvariant tagvariant) {
        List<Tagvariant> list = tagvariantService.selectTagvariantList(tagvariant);
        ExcelUtil<Tagvariant> util = new ExcelUtil<Tagvariant>(Tagvariant.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:tagvariant:query')")
    @GetMapping(value = "/{tagvariantId}")
    public AjaxResult getInfo(@PathVariable("tagvariantId") Long tagvariantId) {
        return AjaxResult.success(tagvariantService.selectTagvariantByTagvariantId(tagvariantId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:tagvariant:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Tagvariant tagvariant) {
        return toAjax(tagvariantService.insertTagvariant(tagvariant));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:tagvariant:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Tagvariant tagvariant) {
        return toAjax(tagvariantService.updateTagvariant(tagvariant));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:tagvariant:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{tagvariantIds}")
    public AjaxResult remove(@PathVariable Long[] tagvariantIds) {
        return toAjax(tagvariantService.deleteTagvariantByTagvariantIds(tagvariantIds));
    }

    //查询Reference
    @GetMapping("/selectReference")
    @PreAuthorize("@ss.hasPermi('system:tagvariant:selectReference')")
    @ResponseBody
    public AjaxResult selectReference() {
        List<String> list = tagvariantService.selectReference();
        return AjaxResult.success(list);
    }

    //查询Version
    @GetMapping("/selectVersion")
    @PreAuthorize("@ss.hasPermi('system:tagvariant:selectVersion')")
    @ResponseBody
    public AjaxResult selectVersion(@RequestParam String accession) {
        List<String> list = tagvariantService.selectVersion(accession);
        return AjaxResult.success(list);
    }

    //查询Population
    @PreAuthorize("@ss.hasPermi('system:tagvariant:selectPopulation')")
    @GetMapping("/selectPopulation")
    @ResponseBody
    public AjaxResult selectPopulation() {
        List<String> list = tagvariantService.selectPopulation();
        return AjaxResult.success(list);
    }

    //查询Analysis
    @PreAuthorize("@ss.hasAnyPermi('system:tagvariant:selectAnalysis')")
    @GetMapping("/selectAnalysis")
    @ResponseBody
    public AjaxResult selectAnalysis() {
        List<String> list = tagvariantService.selectAnalysis();
        return AjaxResult.success(list);
    }

    //查询Chr
    @PreAuthorize("@ss.hasPermi('system:tagvariant:selectChr')")
    @GetMapping("/selectChr")
    @ResponseBody
    public AjaxResult selectChr() {
        List<String> list = tagvariantService.selectChr();
        return AjaxResult.success(list);
    }


    //大查询 tagvariant
    @PreAuthorize("@ss.hasPermi('system:tagvariant:selectTagvariant')")
    @RequestMapping("/selectTagvariant")//get
    public TableDataInfo selectTagvariant(@RequestBody TagvSelectCondition tagvariantcondition) {
        startPage();
        List<TagvSelectCondition> list = tagvariantService.selectTagvariant(tagvariantcondition.getAccession(), tagvariantcondition.getVersion(), tagvariantcondition.getPopulation(), tagvariantcondition.getDescription(),
                tagvariantcondition.getChr(), tagvariantcondition.getStart(), tagvariantcondition.getEnd());
        return getDataTable(list);
    }

    //下载 tagvariant 查询结果
    @PreAuthorize("@ss.hasPermi('system:tagvariant:download')")
    @RequestMapping("/download")
    public void download(HttpServletResponse response, @RequestParam List<String> list) {
        try {
            List<Tagvariant> tagvlist = new ArrayList<>();
            for (String tagvariant_id : list) {
                Long id = Long.parseLong(tagvariant_id);
                Tagvariant selectCondition = tagvariantService.selectTagvariantByTagvariantId(id);
                tagvlist.add(selectCondition);
            }
            ExcelUtil<Tagvariant> util = new ExcelUtil<>(Tagvariant.class);
            util.exportExcel(response, tagvlist, "查询数据 tagvariant");
        } catch (Exception ex) {
            logger.error("下载evol异常", ex);
        }
    }

}
