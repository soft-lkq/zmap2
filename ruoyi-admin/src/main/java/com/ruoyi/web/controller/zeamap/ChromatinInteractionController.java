package com.ruoyi.web.controller.zeamap;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.zeamap.domain.ChromatinInteractionSelectCondition;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.zeamap.domain.ChromatinInteraction;
import com.ruoyi.zeamap.service.IChromatinInteractionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
@RestController
@RequestMapping("/chromatin_interaction")
public class ChromatinInteractionController extends BaseController
{
    @Autowired
    private IChromatinInteractionService chromatinInteractionService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:interaction:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChromatinInteraction chromatinInteraction)
    {
        startPage();
        List<ChromatinInteraction> list = chromatinInteractionService.selectChromatinInteractionList(chromatinInteraction);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:interaction:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChromatinInteraction chromatinInteraction)
    {
        List<ChromatinInteraction> list = chromatinInteractionService.selectChromatinInteractionList(chromatinInteraction);
        ExcelUtil<ChromatinInteraction> util = new ExcelUtil<ChromatinInteraction>(ChromatinInteraction.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:interaction:query')")
    @GetMapping(value = "/{chromatinInteractionId}")
    public AjaxResult getInfo(@PathVariable("chromatinInteractionId") Long chromatinInteractionId)
    {
        return AjaxResult.success(chromatinInteractionService.selectChromatinInteractionByChromatinInteractionId(chromatinInteractionId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:interaction:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChromatinInteraction chromatinInteraction)
    {
        return toAjax(chromatinInteractionService.insertChromatinInteraction(chromatinInteraction));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:interaction:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChromatinInteraction chromatinInteraction)
    {
        return toAjax(chromatinInteractionService.updateChromatinInteraction(chromatinInteraction));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:interaction:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{chromatinInteractionIds}")
    public AjaxResult remove(@PathVariable Long[] chromatinInteractionIds)
    {
        return toAjax(chromatinInteractionService.deleteChromatinInteractionByChromatinInteractionIds(chromatinInteractionIds));
    }

    /*
    *@Author 刘洋
    * @Date 2023/4/13
    *
     */
    //查找dbxref表里面的accession
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:chromatin_interaction:selectaccession')")
    @GetMapping("/selectaccession")
    public AjaxResult selectaccession() {
        List<String> list=chromatinInteractionService.selectaccession();
        return AjaxResult.success(list);
    }

    //查找dbxref表里面的version,version是accession的下级
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:chromatin_interaction:selectversion')")
    @GetMapping("/selectversion")
    public AjaxResult selectversion(@RequestParam String accession) {
        List<String> list=chromatinInteractionService.selectversion(accession);
        return AjaxResult.success(list);
    }
    //查找analysis表的description
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:chromatin_interaction:selectanalysis')")
    @GetMapping("/selectanalysis")
    public AjaxResult selectanalysis(@RequestParam String accession,@RequestParam String version) {
        List<String> list=chromatinInteractionService.selectanalysis(accession,version);
        return AjaxResult.success(list);
    }
    //查找chrA
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:chromatin_interaction:selectchrA')")
    @GetMapping("/selectchrA")
    public AjaxResult selectchrA() {
        List<String> list=chromatinInteractionService.selectchrA();
        return AjaxResult.success(list);
    }
    //查找chrB
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:chromatin_interaction:selectchrB')")
    @GetMapping("/selectchrB")
    public AjaxResult selectchrB() {
        List<String> list=chromatinInteractionService.selectchrB();
        return AjaxResult.success(list);
    }

    //大查询
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:chromatin_interaction:selectchromatin_interaction')")
    @PostMapping("/selectchromatin_interaction")
    public TableDataInfo selectchromatin_interaction(@RequestBody ChromatinInteractionSelectCondition chromatinInteractionSelectCondition) {
        startPage();
        List<ChromatinInteraction> list=chromatinInteractionService.selectchromatin_interaction(chromatinInteractionSelectCondition.getAccession(),chromatinInteractionSelectCondition.getVersion(),chromatinInteractionSelectCondition.getDescription(),chromatinInteractionSelectCondition.getChrA(),chromatinInteractionSelectCondition.getStartA(),chromatinInteractionSelectCondition.getEndA(),chromatinInteractionSelectCondition.getChrB(),chromatinInteractionSelectCondition.getStartB(),chromatinInteractionSelectCondition.getEndB());
        return getDataTable(list);
    }

    //下载
    @PreAuthorize("@ss.hasPermi('ruoyi.zeamap:chromatin_interaction:download')")
    @Log(title = "【下载chromatin_interaction数据】", businessType = BusinessType.EXPORT)
    @PostMapping("/download")
    public void download(HttpServletResponse response, @RequestBody List<ChromatinInteraction> list) {
        //System.out.println(list);
        ExcelUtil<ChromatinInteraction> util = new ExcelUtil<ChromatinInteraction>(ChromatinInteraction.class);
        util.exportExcel(response,list, "查询chromatin_interaction数据");
    }



}
