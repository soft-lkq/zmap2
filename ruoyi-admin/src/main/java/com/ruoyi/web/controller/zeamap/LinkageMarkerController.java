package com.ruoyi.web.controller.zeamap;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.zeamap.domain.*;
import com.ruoyi.zeamap.domain.LinkageMarkerSelectCondition;
import com.ruoyi.zeamap.service.ILinkageMarkerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.zeamap.domain.LinkageMarker;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2023-03-06
 */
@RestController
@RequestMapping("/genetics/search_marker/linkage_marker")
public class LinkageMarkerController extends BaseController {
    @Autowired
    private ILinkageMarkerService linkageMarkerService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:marker:list')")
    @GetMapping("/list")
    public TableDataInfo list(LinkageMarker linkageMarker) {
        startPage();
        List<LinkageMarker> list = linkageMarkerService.selectLinkageMarkerList(linkageMarker);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:marker:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LinkageMarker linkageMarker) {
        List<LinkageMarker> list = linkageMarkerService.selectLinkageMarkerList(linkageMarker);
        ExcelUtil<LinkageMarker> util = new ExcelUtil<LinkageMarker>(LinkageMarker.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:marker:query')")
    @GetMapping(value = "/{linkageMarkerId}")
    public AjaxResult getInfo(@PathVariable("linkageMarkerId") Long linkageMarkerId) {
        return AjaxResult.success(linkageMarkerService.selectLinkageMarkerByLinkageMarkerId(linkageMarkerId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:marker:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LinkageMarker linkageMarker) {
        return toAjax(linkageMarkerService.insertLinkageMarker(linkageMarker));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:marker:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LinkageMarker linkageMarker) {
        return toAjax(linkageMarkerService.updateLinkageMarker(linkageMarker));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:marker:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{linkageMarkerIds}")
    public AjaxResult remove(@PathVariable Long[] linkageMarkerIds) {
        return toAjax(linkageMarkerService.deleteLinkageMarkerByLinkageMarkerIds(linkageMarkerIds));
    }

    /**
     * 由此开始
     *
     * @Author 刘洋
     * @Date 2023/3/11
     * Search Marker模块 Linkage Mapping的内容
     */

    //查找dbxref表里面的accession
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:linkageMarker:selectaccession')")
    @GetMapping("/selectaccession")
    public AjaxResult selectaccession() {
        List<String> list=linkageMarkerService.selectaccession();
        return AjaxResult.success(list);
    }

    //查找dbxref表里面的version,version是accession的下级
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:linkageMarker:selectversion')")
    @GetMapping("/selectversion")
    public AjaxResult selectversion(@RequestParam String accession) {
        List<String> list=linkageMarkerService.selectversion(accession);
        return AjaxResult.success(list);
    }

    //查找Trait Category
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:linkageMarker:selecttraitcategory')")
    @GetMapping("/selecttraitcategory")
    public AjaxResult selecttraitcategory() {
        List<String> list=linkageMarkerService.selecttraitcategory();
        return AjaxResult.success(list);
    }

    //查找Trait Id
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:linkageMarker:selecttraitid')")
    @GetMapping("/selecttraitid")
    public AjaxResult selecttraitid(@RequestParam String trait_id) {
        List<String> list=linkageMarkerService.selecttraitid(trait_id);
        return AjaxResult.success(list);
    }
    //查找Linkage Map
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:linkageMarker:selectlinkagemap')")
    @GetMapping("/selectlinkagemap")
    public AjaxResult selectlinkagemap() {
        List<String> list=linkageMarkerService.selectlinkagemap();
        return AjaxResult.success(list);
    }

    //查找LG(Linkage Group)
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:linkageMarker:selectlg')")
    @GetMapping("/selectlg")
    public AjaxResult selectlg() {
        List<String> list=linkageMarkerService.selectlg();
        return AjaxResult.success(list);
    }


    //大查询
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:linkageMarker:selectlinkage_marker')")
    @PostMapping("/selectlinkage_marker")
    public TableDataInfo selectlinkage_marker(@RequestBody LinkageMarkerSelectCondition linkageMarkerSelectCondition) {
        startPage();
        System.out.println(linkageMarkerSelectCondition.getLg());
        List<LinkageMarker> list= linkageMarkerService.selectlinkage_marker(linkageMarkerSelectCondition.getAccession(),linkageMarkerSelectCondition.getVersion(),linkageMarkerSelectCondition.getOmics(),linkageMarkerSelectCondition.getXot_uid(),linkageMarkerSelectCondition.getLinkageMap(),linkageMarkerSelectCondition.getLg(),linkageMarkerSelectCondition.getCm_min(),linkageMarkerSelectCondition.getCm_max());
        return getDataTable(list);
    }
    //下载
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:linkageMarker:selectlinkage_Marker')")
    @Log(title = "【下载linkage_marker数据】", businessType = BusinessType.EXPORT)
    @PostMapping("/download")
    public void download(HttpServletResponse response,@RequestBody List<LinkageMarker> list) {
        ExcelUtil<LinkageMarker> util = new ExcelUtil<LinkageMarker>(LinkageMarker.class);
        util.exportExcel(response,list, "查询Linkage_Marker数据");
    }

}
