package com.ruoyi.web.controller.zeamap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.zeamap.domain.VariantSelectCondition;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.zeamap.domain.Variant;
import com.ruoyi.zeamap.service.IVariantService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * variantController
 *
 * @author ruoyi
 * @date 2022-10-30
 */
@RestController
@RequestMapping("/variations/variant")
public class VariantController extends BaseController {
    @Autowired
    private IVariantService variantService;

    /**
     * 查询variant列表
     */
    @PreAuthorize("@ss.hasPermi('variations:variant:list')")
    @GetMapping("/list")
    public TableDataInfo list(Variant variant) {
        startPage();
        List<Variant> list = variantService.selectVariantList(variant);
        return getDataTable(list);
    }

    /**
     * 导出variant列表
     */
    @PreAuthorize("@ss.hasPermi('variations:variant:export')")
    @Log(title = "variant", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Variant variant) {
        List<Variant> list = variantService.selectVariantList(variant);
        ExcelUtil<Variant> util = new ExcelUtil<Variant>(Variant.class);
        util.exportExcel(response, list, "variant数据");
    }

    /**
     * 获取variant详细信息
     */
    @PreAuthorize("@ss.hasPermi('variations:variant:query')")
    @GetMapping(value = "/{variantId}")
    public AjaxResult getInfo(@PathVariable("variantId") String variantId) {
        return AjaxResult.success(variantService.selectVariantByVariantId(variantId));
    }

    /**
     * 新增variant
     */
    @PreAuthorize("@ss.hasPermi('variations:variant:add')")
    @Log(title = "variant", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Variant variant) {
        return toAjax(variantService.insertVariant(variant));
    }

    /**
     * 修改variant
     */
    @PreAuthorize("@ss.hasPermi('variations:variant:edit')")
    @Log(title = "variant", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Variant variant) {
        return toAjax(variantService.updateVariant(variant));
    }

    /**
     * 删除variant
     */
    @PreAuthorize("@ss.hasPermi('variations:variant:remove')")
    @Log(title = "variant", businessType = BusinessType.DELETE)
    @DeleteMapping("/{variantIds}")
    public AjaxResult remove(@PathVariable String[] variantIds) {
        return toAjax(variantService.deleteVariantByVariantIds(variantIds));
    }


    /**
     * variantController
     *
     * @author 刘洋、邵雯
     * @date 2023-3-2
     */


    //查询Reference
    @PreAuthorize("@ss.hasPermi('variations:variant:selectReference')")
    @GetMapping("/selectReference")
    @ResponseBody
    public AjaxResult selectReference() {
        List<String> list=variantService.selectReference();
        return AjaxResult.success(list);
    }

    //查询Version
    @PreAuthorize("@ss.hasPermi('variations:variant:selectVersion')")
    @GetMapping("/selectVersion")
    @ResponseBody
    public AjaxResult selectVersion(@RequestParam String accession) {
        List<String> list=variantService.selectVersion(accession);
        return AjaxResult.success(list);
    }

    //查询Population
    @PreAuthorize("@ss.hasPermi('variations:variant:selectPopulation')")
    @GetMapping("/selectPopulation")
    @ResponseBody
    public AjaxResult selectPopulation() {
        List<String> list=variantService.selectPopulation();
        return AjaxResult.success(list);
    }

    //查询Analysis里面的description
    @PreAuthorize("@ss.hasPermi('variations:variant:selectAnalysis')")
    @GetMapping("/selectAnalysis")
    @ResponseBody
    public AjaxResult selectAnalysis() {
        List<String> list=variantService.selectAnalysis();
        return AjaxResult.success(list);
    }

    //查询VariantClass
    @PreAuthorize("@ss.hasPermi('variations:variant:selectVariantClass')")
    @GetMapping("/selectVariantClass")
    @ResponseBody
    public AjaxResult selectVariantClass() {
        List<String> list=variantService.selectVariantClass();
        return AjaxResult.success(list);
    }

    //查询Region下拉框里面的chr
    @PreAuthorize("@ss.hasPermi('variations:variant:selectChr')")
    @GetMapping("/selectChr")
    @ResponseBody
    public AjaxResult selectChr() {
        List<String> list=variantService.selectChr();
        return AjaxResult.success(list);
    }

    //查询Region下拉框里面的Posi
    @PreAuthorize("@ss.hasPermi('variations:variant:selectPosi')")
    @GetMapping("/selectPosi")
    @ResponseBody
    public AjaxResult selectPosi() {
        List<String> list=variantService.selectPosi();
        return AjaxResult.success(list);
    }

    //Annotation 查询 impacts
    @PreAuthorize("@ss.hasPermi('variations:variant:selectImpacts')")
    @GetMapping("/selectImpacts")
    @ResponseBody
    public AjaxResult selectImpacts() {
        List<String> list=variantService.selectImpacts();
        return AjaxResult.success(list);
    }

    //Annotation 查询consequences
    @PreAuthorize("@ss.hasPermi('variations:variant:selectConsequences')")
    @GetMapping("/selectConsequences")
    @ResponseBody
    public AjaxResult selectConsequences() {
        List<String> list=variantService.selectConsequences();
        return AjaxResult.success(list);
    }

    /*
     *大查询
     * 其中VariantSelectCondition是一个实体类，来承接前端返回的参数
     */

    @PreAuthorize("@ss.hasPermi('variations:variant:selectVariant')")
    @PostMapping("/selectVariant")
    public TableDataInfo selectVariant(@RequestBody VariantSelectCondition selectCondition) {
        startPage();
        //System.out.println(selectCondition);
        List<Variant> list = variantService.selectVariant(selectCondition.getType(), selectCondition.getChr(), selectCondition.getPosi_min(), selectCondition.getPosi_max(), selectCondition.getMaf_min(), selectCondition.getMaf_max(), selectCondition.getImpacts(), selectCondition.getConsequences(), selectCondition.getAccession(), selectCondition.getVersion(), selectCondition.getAlias(), selectCondition.getDescription());
        return getDataTable(list);
    }

    //下载表格
    @PreAuthorize("@ss.hasPermi('variations:variant:download')")
    @Log(title = "【下载variant数据】", businessType = BusinessType.EXPORT)
    @PostMapping("/download")
    public void download(HttpServletResponse response,@RequestParam List<String> ids) {

            System.out.println(ids);
            List<Variant> list = new ArrayList<>();
            for (String id : ids) {
                //用每个id去数据库里面查
                Variant v = variantService.selectVariantByVariantId(id);
                //把查到的添加到list集合
                list.add(v);
            }
            ExcelUtil<Variant> util = new ExcelUtil<Variant>(Variant.class);
            util.exportExcel(response,list, "变异数据");
    }

}
