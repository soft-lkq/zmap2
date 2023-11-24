package com.ruoyi.web.controller.zeamap;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.zeamap.domain.*;
import com.ruoyi.zeamap.domain.AssociationQtl;
import com.ruoyi.zeamap.domain.AssociationQtlSelectCondition;
import com.ruoyi.zeamap.service.IAssociationQtlService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2023-03-06
 */
@RestController
@RequestMapping("/genetics/search_qtl/association_qtl")
public class AssociationQtlController extends BaseController {
    @Autowired
    private IAssociationQtlService associationQtlService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:qtl:list')")
    @GetMapping("/list")
    public TableDataInfo list(AssociationQtl associationQtl) {
        startPage();
        List<AssociationQtl> list = associationQtlService.selectAssociationQtlList(associationQtl);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:qtl:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AssociationQtl associationQtl) {
        List<AssociationQtl> list = associationQtlService.selectAssociationQtlList(associationQtl);
        ExcelUtil<AssociationQtl> util = new ExcelUtil<AssociationQtl>(AssociationQtl.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:qtl:query')")
    @GetMapping(value = "/{associationQtlId}")
    public AjaxResult getInfo(@PathVariable("associationQtlId") Long associationQtlId) {
        return AjaxResult.success(associationQtlService.selectAssociationQtlByAssociationQtlId(associationQtlId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:qtl:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AssociationQtl associationQtl) {
        return toAjax(associationQtlService.insertAssociationQtl(associationQtl));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:qtl:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AssociationQtl associationQtl) {
        return toAjax(associationQtlService.updateAssociationQtl(associationQtl));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:qtl:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{associationQtlIds}")
    public AjaxResult remove(@PathVariable Long[] associationQtlIds) {
        return toAjax(associationQtlService.deleteAssociationQtlByAssociationQtlIds(associationQtlIds));
    }

    /**
     * 由此开始
     *
     * @Author 刘洋
     * @Date 2023/3/11
     * Search Qtl模块 Association Mapping的内容
     */

    //查找dbxref表里面的accession
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:associationQtl:selectaccession')")
    @GetMapping("/selectaccession")
    public AjaxResult selectaccession() {
        List<String> list = associationQtlService.selectaccession();
        return AjaxResult.success(list);
    }

    //查找dbxref表里面的version,version是accession的下级
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:associationQtl:selectversion')")
    @GetMapping("/selectversion")
    public AjaxResult selectversion(@RequestParam String accession) {
        List<String> list = associationQtlService.selectversion(accession);
        return AjaxResult.success(list);
    }

    //查找Trait Category
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:associationQtl:selecttraitcategory')")
    @GetMapping("/selecttraitcategory")
    public AjaxResult selecttraitcategory() {
        List<String> list = associationQtlService.selecttraitcategory();
        return AjaxResult.success(list);
    }

    //查找Trait Id
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:associationQtl:selecttraitid')")
    @GetMapping("/selecttraitid")
    public AjaxResult selecttraitid(@RequestParam String trait_id) {
        List<String> list = associationQtlService.selecttraitid(trait_id);
        return AjaxResult.success(list);
    }

    //查找chr
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:associationQtl:selectchr')")
    @GetMapping("/selectchr")
    public AjaxResult selectchr() {
        List<String> list = associationQtlService.selectchr();
        return AjaxResult.success(list);
    }

    //大查询
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:associationQtl:selectassociation_qtl')")
    @PostMapping("/selectassociation_qtl")
    public TableDataInfo selectassociation_qtl(@RequestBody AssociationQtlSelectCondition associationQtlSelectCondition) {
        startPage();
        List<AssociationQtl> list = associationQtlService.selectassociation_qtl(associationQtlSelectCondition.getAccession(), associationQtlSelectCondition.getVersion(), associationQtlSelectCondition.getOmics(), associationQtlSelectCondition.getXot_uid(), associationQtlSelectCondition.getChr(), associationQtlSelectCondition.getStart(), associationQtlSelectCondition.getEnd(), associationQtlSelectCondition.getLog_min(), associationQtlSelectCondition.getLog_max());
        return getDataTable(list);
    }
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:association_qtl:download')")
    @Log(title = "【下载association_qtl数据】", businessType = BusinessType.EXPORT)
    @PostMapping("/download")
    public void download(HttpServletResponse response,@RequestBody List<AssociationQtl> list) {
        ExcelUtil<AssociationQtl> util = new ExcelUtil<AssociationQtl>(AssociationQtl.class);
        util.exportExcel(response, list, "查询Association_Qtl数据");
    }

}
