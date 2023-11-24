package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.EvolSelectCondition;
import com.ruoyi.zeamap.domain.Evolution;
import com.ruoyi.zeamap.service.IEvolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 新增需求 4.7 variations
 * evolution 查询 下载
 *
 * @author 邵雯
 * @date 2023-04-12
 */
@RestController
@RequestMapping("/variations/evolution")
public class EvolutionController extends BaseController {
    @Autowired
    private IEvolutionService evolutionService;

    /**
     * 查询【evolution】列表
     */
    @PreAuthorize("@ss.hasPermi('system:evolution:list')")
    @GetMapping("/list")
    public TableDataInfo list(Evolution evolution) {
        startPage();
        List<Evolution> list = evolutionService.selectEvolutionList(evolution);
        return getDataTable(list);
    }

    /**
     * 导出【evolution】列表
     */
    @PreAuthorize("@ss.hasPermi('system:evolution:export')")
    @Log(title = "【evolution 数据】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Evolution evolution) {
        List<Evolution> list = evolutionService.selectEvolutionList(evolution);
        ExcelUtil<Evolution> util = new ExcelUtil<Evolution>(Evolution.class);
        util.exportExcel(response, list, "evolution 数据");
    }

    /**
     * 获取【evolution】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:evolution:query')")
    @GetMapping(value = "/{evolutionId}")
    public AjaxResult getInfo(@PathVariable("evolutionId") Long evolutionId) {
        return AjaxResult.success(evolutionService.selectEvolutionByEvolutionId(evolutionId));
    }

    /**
     * 新增【evolution】数据
     */
    @PreAuthorize("@ss.hasPermi('system:evolution:add')")
    @Log(title = "新增【evolution】数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Evolution evolution) {
        return toAjax(evolutionService.insertEvolution(evolution));
    }

    /**
     * 修改【evolution】数据
     */
    @PreAuthorize("@ss.hasPermi('system:evolution:edit')")
    @Log(title = "修改【evolution】数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Evolution evolution) {
        return toAjax(evolutionService.updateEvolution(evolution));
    }

    /**
     * 删除【evolution】单条数据
     */
    @PreAuthorize("@ss.hasPermi('system:evolution:remove')")
    @Log(title = "删除【evolution】单条数据", businessType = BusinessType.DELETE)
    @DeleteMapping("/{evolutionIds}")
    public AjaxResult remove(@PathVariable Long[] evolutionIds) {
        return toAjax(evolutionService.deleteEvolutionByEvolutionIds(evolutionIds));
    }


    //查询Reference下拉框
    @GetMapping("/selectReference")
    @PreAuthorize("@ss.hasPermi('system:evolution:selectReference')")
    @ResponseBody
    public AjaxResult selectReference() {
        List<String> list = evolutionService.selectReference();
        return AjaxResult.success(list);
    }

    //查询Version下拉框
    @RequestMapping("/selectVersion")
    @PreAuthorize("@ss.hasPermi('system:evolution:selectVersion')")
    @ResponseBody
    public AjaxResult selectVersion(@RequestParam String accession) {
        List<String> list = evolutionService.selectVersion(accession);
        return AjaxResult.success(list);
    }

    //查询Indicator 非下拉框，前端选项展示
    @RequestMapping("/selectIndicator")
    @PreAuthorize("@ss.hasPermi('system:evolution:selectIndicator')")
    @ResponseBody
    public AjaxResult selectIndicator() {
        List<String> list = evolutionService.selectIndicator();
        return AjaxResult.success(list);
    }

    //查询selectiontype 下拉框
    @RequestMapping("/selectselectiontype")
    @PreAuthorize("@ss.hasPermi('system:evolution:selectselectiontype')")
    @ResponseBody
    public AjaxResult selectselectiontype(String indicator) {
        List<String> list = evolutionService.selectselectiontype(indicator);
        return AjaxResult.success(list);
    }

    //查询popcompared 下拉框
    @RequestMapping("/selectpopcompared")
    @PreAuthorize("@ss.hasPermi('system:evolution:selectpopcompared')")
    @ResponseBody
    public AjaxResult selectpopcompared(String indicator) {
        List<String> list = evolutionService.selectpopcompared(indicator);
        return AjaxResult.success(list);
    }

    //查询chr 下拉框
    @RequestMapping("/selectchr")
    @PreAuthorize("@ss.hasPermi('system:evolution:selectchr')")
    @ResponseBody
    public AjaxResult selectchr() {
        List<String> list = evolutionService.selectchr();
        return AjaxResult.success(list);
    }

    //限制查询范围 start end

    //大查询 evolution 和 evolution_type
    @RequestMapping("/selectevol")//get
    @PreAuthorize("@ss.hasPermi('system:evolution:selectevol')")
    public TableDataInfo selectevol(@RequestBody EvolSelectCondition evolSelectCondition) {
        startPage();
        List<EvolSelectCondition> list = evolutionService.selectevol(evolSelectCondition.getRef(), evolSelectCondition.getVersion(), evolSelectCondition.getIndicator(), evolSelectCondition.getSelect()
                , evolSelectCondition.getCompare_pop(), evolSelectCondition.getChro(), evolSelectCondition.getStart(), evolSelectCondition.getEnd());
        return getDataTable(list);
    }

    //下载 Evolution 查询结果
    @PreAuthorize("@ss.hasPermi('system:evolution:download')")
    @RequestMapping("/download")
    public void download(HttpServletResponse response, @RequestBody List<EvolSelectCondition> list) {
        ExcelUtil<EvolSelectCondition> util = new ExcelUtil<>(EvolSelectCondition.class);
        util.exportExcel(response, list, "查询数据 evoltion");
    }


}
