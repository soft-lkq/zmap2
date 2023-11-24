package com.ruoyi.web.controller.zeamap;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.zeamap.domain.AssociationMarkerSelectCondition;
import com.ruoyi.zeamap.domain.ChromatinInteraction;
import com.ruoyi.zeamap.service.IAssociationMarkerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.zeamap.domain.AssociationMarker;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2023-03-06
 */
@RestController
@RequestMapping("/genetics/search_marker/association_marker")
public class AssociationMarkerController extends BaseController {
    @Autowired
    private IAssociationMarkerService associationMarkerService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:marker:list')")
    @GetMapping("/list")
    public TableDataInfo list(AssociationMarker associationMarker) {
        startPage();
        List<AssociationMarker> list = associationMarkerService.selectAssociationMarkerList(associationMarker);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:marker:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AssociationMarker associationMarker) {
        List<AssociationMarker> list = associationMarkerService.selectAssociationMarkerList(associationMarker);
        ExcelUtil<AssociationMarker> util = new ExcelUtil<AssociationMarker>(AssociationMarker.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:marker:query')")
    @GetMapping(value = "/{associationMarkerId}")
    public AjaxResult getInfo(@PathVariable("associationMarkerId") Long associationMarkerId) {
        return AjaxResult.success(associationMarkerService.selectAssociationMarkerByAssociationMarkerId(associationMarkerId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:marker:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AssociationMarker associationMarker) {
        return toAjax(associationMarkerService.insertAssociationMarker(associationMarker));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:marker:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AssociationMarker associationMarker) {
        return toAjax(associationMarkerService.updateAssociationMarker(associationMarker));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:marker:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{associationMarkerIds}")
    public AjaxResult remove(@PathVariable Long[] associationMarkerIds) {
        return toAjax(associationMarkerService.deleteAssociationMarkerByAssociationMarkerIds(associationMarkerIds));
    }

    /**
     * 由此开始
     *
     * @Author 刘洋
     * @Date 2023/3/11
     * Search Markers模块 Association Mapping的内容
     */

    //查找dbxref表里面的accession
    @PreAuthorize("@ss.hasPermi('zeamap:associationMarker:selectaccession')")
    @GetMapping("/selectaccession")
    public AjaxResult selectaccession() {
        List<String> list = associationMarkerService.selectaccession();
        return AjaxResult.success(list);
    }

    //查找dbxref表里面的version,version是accession的下级
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:associationMarker:selectversion')")
    @GetMapping("/selectversion")
    public AjaxResult selectversion(@RequestParam String accession) {
        List<String> list = associationMarkerService.selectversion(accession);
        return AjaxResult.success(list);
    }

    //查找Trait Category
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:associationMarker:selecttraitcategory')")
    @GetMapping("/selecttraitcategory")
    public AjaxResult selecttraitcategory() {
        List<String> list = associationMarkerService.selecttraitcategory();
        return AjaxResult.success(list);
    }

    //查找Trait Id
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:associationMarker:selecttraitid')")
    @GetMapping("/selecttraitid")
    public AjaxResult selecttraitid(@RequestParam String trait_id) {
        List<String> list = associationMarkerService.selecttraitid(trait_id);
        return AjaxResult.success(list);
    }

    //查找chr
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:associationMarker:selectchr')")
    @GetMapping("/selectchr")
    public AjaxResult selectchr() {
        List<String> list = associationMarkerService.selectchr();
        return AjaxResult.success(list);
    }

    //查找Variant Type
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:associationMarker:selecttype')")
    @GetMapping("/selecttype")
    public AjaxResult selecttype() {
        List<String> list = associationMarkerService.selecttype();
        return AjaxResult.success(list);
    }


    //大查询
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:associationMarker:selectassociation_marker')")
    @PostMapping("/selectassociation_marker")
    public TableDataInfo selectassociation_marker(@RequestBody AssociationMarkerSelectCondition associationMarkerSelectCondition) {
        startPage();
        List<AssociationMarker> list = associationMarkerService.selectassociation_marker(associationMarkerSelectCondition.getAccession(), associationMarkerSelectCondition.getVersion(), associationMarkerSelectCondition.getOmics(), associationMarkerSelectCondition.getXot_uid(), associationMarkerSelectCondition.getChr(), associationMarkerSelectCondition.getStart(), associationMarkerSelectCondition.getEnd(), associationMarkerSelectCondition.getVariantType(), associationMarkerSelectCondition.getLog_min(), associationMarkerSelectCondition.getLog_max(), associationMarkerSelectCondition.getEffect_min(), associationMarkerSelectCondition.getEffect_max(), associationMarkerSelectCondition.getPip_min(), associationMarkerSelectCondition.getPip_max());
        return getDataTable(list);
    }

    //下载
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:associationMarker:download')")
    @Log(title = "【下载association_marker数据】", businessType = BusinessType.EXPORT)
    @PostMapping("/download")
    public void download(HttpServletResponse response,@RequestBody List<AssociationMarker> list) {

        ExcelUtil<AssociationMarker> util = new ExcelUtil<AssociationMarker>(AssociationMarker.class);
        util.exportExcel(response, list, "查询association_marker数据");
    }
}
