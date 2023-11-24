package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.Germplasm;
import com.ruoyi.zeamap.service.IGermplasmService;
import com.ruoyi.zeamap.service.IPopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 产品详情Controller
 * 
 * @author ruoyi
 * @date 2023-03-14
 */
@RestController
@RequestMapping("/zeamap/germplasm")
public class GermplasmController extends BaseController
{
    @Autowired
    private IGermplasmService germplasmService;
    @Autowired
    private IPopulationService populationService;


    @ResponseBody
    @RequestMapping ("/details")
    public AjaxResult details(String name)
    {
        Long population_id = germplasmService.selectPopulationId(name);
        List<Germplasm> list = germplasmService.selectGermplasmListFromPid(population_id);
        return AjaxResult.success(list);
    }

    @ResponseBody
    @RequestMapping("/choose")
    public AjaxResult choose(String name){
        return AjaxResult.success(germplasmService.selectGermplasmByName(name));
    }

    /**
     * 查询产品详情列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:germplasm:list')")
    @GetMapping("/list")
    public TableDataInfo list(Germplasm germplasm)
    {
        startPage();
        List<Germplasm> list = germplasmService.selectGermplasmList(germplasm);
        return getDataTable(list);
    }

    /**
     * 导出产品详情列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:germplasm:export')")
    @Log(title = "产品详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Germplasm germplasm)
    {
        List<Germplasm> list = germplasmService.selectGermplasmList(germplasm);
        ExcelUtil<Germplasm> util = new ExcelUtil<Germplasm>(Germplasm.class);
        util.exportExcel(response, list, "产品详情数据");
    }

    /**
     * 获取产品详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:germplasm:query')")
    @GetMapping(value = "/{germplasmId}")
    public AjaxResult getInfo(@PathVariable("germplasmId") Long germplasmId)
    {
        return AjaxResult.success(germplasmService.selectGermplasmByGermplasmId(germplasmId));
    }

    /**
     * 新增产品详情
     */
    @PreAuthorize("@ss.hasPermi('zeamap:germplasm:add')")
    @Log(title = "产品详情", businessType = BusinessType.INSERT)
    @GetMapping("/add")
    public AjaxResult add(@RequestBody Germplasm germplasm)
    {
        return toAjax(germplasmService.insertGermplasm(germplasm));
    }

    /**
     * 修改产品详情
     */
    @PreAuthorize("@ss.hasPermi('zeamap:germplasm:edit')")
    @Log(title = "产品详情", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Germplasm germplasm)
    {
        return toAjax(germplasmService.updateGermplasm(germplasm));
    }

    /**
     * 删除产品详情
     */
    @PreAuthorize("@ss.hasPermi('zeamap:germplasm:remove')")
    @Log(title = "产品详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{germplasmIds}")
    public AjaxResult remove(@PathVariable Long[] germplasmIds)
    {
        return toAjax(germplasmService.deleteGermplasmByGermplasmIds(germplasmIds));
    }

    @GetMapping("/multi")
    public AjaxResult selectorClassDesc(){
        return AjaxResult.success(germplasmService.SelectorSubGroupGermplasm());
    }
}
