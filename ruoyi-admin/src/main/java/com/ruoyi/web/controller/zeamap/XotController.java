package com.ruoyi.web.controller.zeamap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ruoyi.zeamap.domain.*;
import com.ruoyi.zeamap.vo.XotVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.zeamap.service.IXotService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * xotController
 * 
 * @author ruoyi
 * @date 2023-01-08
 */
@RestController
@RequestMapping("/zeamap/xot")
public class XotController extends BaseController
{
    @Autowired
    private IXotService xotService;

    /**
     * 查询xot列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:xot:list')")
    @GetMapping("/list")
    public TableDataInfo list(Xot xot)
    {
        startPage();
        List<Xot> list = xotService.selectXotList(xot);
        return getDataTable(list);
    }

    /**
     * 导出xot列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:xot:export')")
    @Log(title = "xot", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Xot xot)
    {
        List<Xot> list = xotService.selectXotList(xot);
        ExcelUtil<Xot> util = new ExcelUtil<Xot>(Xot.class);
        util.exportExcel(response, list, "xot数据");
    }

    /**
     * 获取xot详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:xot:query')")
    @GetMapping(value = "/{xotId}")
    public AjaxResult getInfo(@PathVariable("xotId") Long xotId)
    {
        return AjaxResult.success(xotService.selectXotByXotId(xotId));
    }

    /**
     * 新增xot
     */
    @PreAuthorize("@ss.hasPermi('zeamap:xot:add')")
    @Log(title = "xot", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Xot xot)
    {
        return toAjax(xotService.insertXot(xot));
    }

    /**
     * 修改xot
     */
    @PreAuthorize("@ss.hasPermi('zeamap:xot:edit')")
    @Log(title = "xot", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Xot xot)
    {
        return toAjax(xotService.updateXot(xot));
    }

    /**
     * 删除xot
     */
    @PreAuthorize("@ss.hasPermi('zeamap:xot:remove')")
    @Log(title = "xot", businessType = BusinessType.DELETE)
	@DeleteMapping("/{xotIds}")
    public AjaxResult remove(@PathVariable Long[] xotIds)
    {
        return toAjax(xotService.deleteXotByXotIds(xotIds));
    }


    /**
     * 5.4的接口
     * @param category
     * @param type
     * @param analysis
     * @param name
     * @param location
     * @param year
     * @param tissue
     * @param traitDateLoc
     * @return
     */
    @GetMapping("/xots")
    public TableDataInfo XotFind(@RequestParam(required = false) String category,@RequestParam(required = false) String type,@RequestParam(required = false) String analysis,
                                 @RequestParam(required = false) String name,@RequestParam(required = false) String location,@RequestParam(required = false) String year,
                                 @RequestParam(required = false) String tissue,@RequestParam(required = false) String traitDateLoc) {

        startPage();
        Xot xot = new Xot();

        xot.setCategory(category);
        xot.setType(type);
        xot.setDescription(name);
//        Analysis a = new Analysis();
//        a.setName(analysis);
//        xot.setAnalysis(a);
        if(analysis!=null){
            xot.setAnalysisId(Long.valueOf(analysis));
        }


//        xot.setName(name);//name 不是 xot 和analysis的name而是description
        xot.setDescription(name);
        xot.setLocation(location);
        xot.setTissue(tissue);
        xot.setTraitDateLoc(traitDateLoc);
        xot.setYear(year);
        List<Xot> list = xotService.selectXotFull(xot);

        return getDataTable(list);
    }


    @GetMapping("/xots/DownMenu")
    public AjaxResult XotDownMenu() {
        //获得下拉菜单所有的数据
        Map<String, List<String>> menuaData = xotService.selectDownMenuData();
        return AjaxResult.success(menuaData);
    }

    @GetMapping("/xots/uidgermplasm")
    public TableDataInfo XotUidGermplasm(@RequestParam String uid) {

//        使用startPage
        startPage();
        List<XotGermplasm> xotGermplasms = xotService.selectGermplasmByXot(uid);
        return getDataTable(xotGermplasms);

        //获得下拉菜单所有的数据
//        Long xot  = xotService.selectXotName(uid);
//        System.out.println(xot);
//        List<XotGermplasm> res = xotService.selectGermplasmByXotId(xot);
//        Mutable mutable = null;
//        Germplasm germplasm= null;
//        Map<String, Object> res = new HashMap<>();
//        res.put("Xot", xot);
//        res.put("mutable", mutable);
//        res.put("germplasm", germplasm);
//        return AjaxResult.success(res);
    }

}
