package com.ruoyi.web.controller.zeamap;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.zeamap.domain.LinkageQtl;
import com.ruoyi.zeamap.domain.LinkageQtlSelectCondition;
import com.ruoyi.zeamap.service.ILinkageQtlService;
import org.apache.poi.ss.formula.functions.T;
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
@RequestMapping("genetics/search_qtl/linkage_qtl")
public class LinkageQtlController extends BaseController {
    @Autowired
    private ILinkageQtlService linkageQtlService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:qtl:list')")
    @GetMapping("/list")
    public TableDataInfo list(LinkageQtl linkageQtl) {
        startPage();
        List<LinkageQtl> list = linkageQtlService.selectLinkageQtlList(linkageQtl);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:qtl:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LinkageQtl linkageQtl) {

        List<LinkageQtl> list = linkageQtlService.selectLinkageQtlList(linkageQtl);
        ExcelUtil<LinkageQtl> util = new ExcelUtil<LinkageQtl>(LinkageQtl.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:qtl:query')")
    @GetMapping(value = "/{linkageQtlId}")
    public AjaxResult getInfo(@PathVariable("linkageQtlId") Long linkageQtlId) {
        return AjaxResult.success(linkageQtlService.selectLinkageQtlByLinkageQtlId(linkageQtlId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:qtl:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LinkageQtl linkageQtl) {
        return toAjax(linkageQtlService.insertLinkageQtl(linkageQtl));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:qtl:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LinkageQtl linkageQtl) {
        return toAjax(linkageQtlService.updateLinkageQtl(linkageQtl));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:qtl:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{linkageQtlIds}")
    public AjaxResult remove(@PathVariable Long[] linkageQtlIds) {
        return toAjax(linkageQtlService.deleteLinkageQtlByLinkageQtlIds(linkageQtlIds));
    }

    /**
     * 由此开始
     *
     * @Author 刘洋
     * @Date 2023/3/11
     * Search Qtl模块 Linkage Mapping的内容
     */

    //查找dbxref表里面的accession
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:linkageQtl:selectaccession')")
    @GetMapping("/selectaccession")
    public AjaxResult selectaccession() {
        List<String> list=linkageQtlService.selectaccession();
        return AjaxResult.success(list);
    }

    //查找dbxref表里面的version,version是accession的下级
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:linkageQtl:selectversion')")
    @GetMapping("/selectversion")
    public AjaxResult selectversion(@RequestParam String accession) {
        List<String> list=linkageQtlService.selectversion(accession);
        return AjaxResult.success(list);
    }

    //查找Trait Category
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:linkageQtl:selecttraitcategory')")
    @GetMapping("/selecttraitcategory")
    public AjaxResult selecttraitcategory() {
        List<String> list=linkageQtlService.selecttraitcategory();
        return AjaxResult.success(list);
    }

    //查找Trait Id
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:linkageQtl:selecttraitid')")
    @GetMapping("/selecttraitid")
    public AjaxResult selecttraitid(@RequestParam String trait_id) {
        List<String> list=linkageQtlService.selecttraitid(trait_id);
        return AjaxResult.success(list);
    }

    //查找chr
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:linkageQtl:selectchr')")
    @GetMapping("/selectchr")
    public AjaxResult selectchr() {
        List<String> list=linkageQtlService.selectchr();
        return AjaxResult.success(list);
    }
    //查找Linkage Map
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:linkageQtl:selectlinkagemap')")
    @GetMapping("/selectlinkagemap")
    public AjaxResult selectlinkagemap() {
        List<String> list=linkageQtlService.selectlinkagemap();
        return AjaxResult.success(list);
    }

    //大查询
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:linkageQtl:selectlinkage_qtl')")
    @PostMapping ("/selectlinkage_qtl")
    public TableDataInfo selectlinkage_qtl(@RequestBody LinkageQtlSelectCondition linkageQtlSelectCondition) {
        startPage();
        List<LinkageQtl> list=linkageQtlService.selectlinkage_qtl(linkageQtlSelectCondition.getAccession(), linkageQtlSelectCondition.getVersion(), linkageQtlSelectCondition.getOmics(), linkageQtlSelectCondition.getXot_uid(), linkageQtlSelectCondition.getLinkageMap(), linkageQtlSelectCondition.getChr(), linkageQtlSelectCondition.getStart(), linkageQtlSelectCondition.getEnd(), linkageQtlSelectCondition.getLod_min(), linkageQtlSelectCondition.getLod_max());
        return getDataTable(list);
    }
    //下载
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:linkageQtl:selectlinkage_qtl')")
    @Log(title = "【下载linkage_qtl数据】", businessType = BusinessType.EXPORT)
    @PostMapping("/download")
    public void download(HttpServletResponse response,@RequestBody List<LinkageQtl> list) {
        ExcelUtil<LinkageQtl> util = new ExcelUtil<LinkageQtl>(LinkageQtl.class);
        util.exportExcel(response,list, "查询Linkage_Qtl数据");
    }
}

