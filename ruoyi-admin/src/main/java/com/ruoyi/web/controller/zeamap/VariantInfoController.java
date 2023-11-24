package com.ruoyi.web.controller.zeamap;

import java.util.*;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.zeamap.domain.VariantInfo;
import com.ruoyi.zeamap.service.IVariantInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2022-10-30
 */
@RestController
@RequestMapping("/variations/variant_info")
public class VariantInfoController extends BaseController {
    @Autowired
    private IVariantInfoService variantInfoService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('variations:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(VariantInfo variantInfo) {
        startPage();
        List<VariantInfo> list = variantInfoService.selectVariantInfoList(variantInfo);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('variations:info:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VariantInfo variantInfo) {
        List<VariantInfo> list = variantInfoService.selectVariantInfoList(variantInfo);
        ExcelUtil<VariantInfo> util = new ExcelUtil<VariantInfo>(VariantInfo.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('variations:info:query')")
    @GetMapping(value = "/{variantinfoId}")
    public AjaxResult getInfo(@PathVariable("variantinfoId") Long variantinfoId) {
        return AjaxResult.success(variantInfoService.selectVariantInfoByVariantinfoId(variantinfoId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('variations:info:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VariantInfo variantInfo) {
        return toAjax(variantInfoService.insertVariantInfo(variantInfo));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('variations:info:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VariantInfo variantInfo) {
        return toAjax(variantInfoService.updateVariantInfo(variantInfo));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('variations:info:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{variantinfoIds}")
    public AjaxResult remove(@PathVariable Long[] variantinfoIds) {
        return toAjax(variantInfoService.deleteVariantInfoByVariantinfoIds(variantinfoIds));
    }


    /**
     * variantInfoController
     * 变异详情页
     * @author 刘洋、邵雯
     * @date 2023-3-2
     * @return
    */
    @PreAuthorize("@ss.hasPermi('variations:variantinfo:selectByVID')")
    @PostMapping("/selectByVID")
    @ResponseBody
    public List<JSONObject> selectByVID(@RequestParam String VID) {
        List<JSONObject> list= new ArrayList<>();
        String summary = variantInfoService.selectSummaryByVID(VID);
        String information = variantInfoService.selectInformationByVID(VID);
        String annotation = variantInfoService.selectAnnotationsByVID(VID);
        String pie = variantInfoService.selectPieplotsByVID(VID);
        JSONObject jsonObject1=JSONObject.parse(summary);
        JSONObject jsonObject2=JSONObject.parse(information);
        JSONObject jsonObject3=JSONObject.parse(annotation);
        JSONObject jsonObject4=JSONObject.parse(pie);
        list.add(jsonObject1);
        list.add(jsonObject2);
        list.add(jsonObject3);
        list.add(jsonObject4);
        return list;
    }
}




