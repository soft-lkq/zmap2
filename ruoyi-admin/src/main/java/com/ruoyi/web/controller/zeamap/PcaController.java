package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.Pca;
import com.ruoyi.zeamap.service.IPcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * PcaController
 * 
 * @author ruoyi
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/zeamap/pca")
public class PcaController extends BaseController
{
    @Autowired
    private IPcaService pcaService;

    /**
     * 查询Pca列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:pca:list')")
    @GetMapping("/list")
    public TableDataInfo list(Pca pca)
    {
        startPage();
        List<Pca> list = pcaService.selectPcaList(pca);
        return getDataTable(list);
    }

    /**
     * 导出Pca列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:pca:export')")
    @Log(title = "Pca", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Pca pca)
    {
        List<Pca> list = pcaService.selectPcaList(pca);
        ExcelUtil<Pca> util = new ExcelUtil<Pca>(Pca.class);
        util.exportExcel(response, list, "Pca数据");
    }

    /**
     * 获取Pca详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:pca:query')")
    @GetMapping(value = "/{sample}")
    public AjaxResult getInfo(@PathVariable("sample") String sample)
    {
        return AjaxResult.success(pcaService.selectPcaBySample(sample));
    }

    /**
     * 新增Pca
     */
    @PreAuthorize("@ss.hasPermi('zeamap:pca:add')")
    @Log(title = "Pca", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody Pca pca)
    {
        return toAjax(pcaService.insertPca(pca));
    }

    /**
     * 修改Pca
     */
    @PreAuthorize("@ss.hasPermi('zeamap:pca:edit')")
    @Log(title = "Pca", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Pca pca)
    {
        return toAjax(pcaService.updatePca(pca));
    }

    /**
     * 删除Pca
     */
    @PreAuthorize("@ss.hasPermi('zeamap:pca:remove')")
    @Log(title = "Pca", businessType = BusinessType.DELETE)
	@DeleteMapping("/remove/{samples}")
    public AjaxResult remove(@PathVariable String[] samples)
    {
        return toAjax(pcaService.deletePcaBySamples(samples));
    }
}
