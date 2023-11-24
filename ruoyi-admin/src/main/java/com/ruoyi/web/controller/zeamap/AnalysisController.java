package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.poi.ExcelUtil;
//import com.ruoyi.zeamap.domain.Analysis;
//import com.ruoyi.zeamap.service.IAnalysisService;
import com.ruoyi.zeamap.domain.Analysis;
import com.ruoyi.zeamap.service.IAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 新增需求 3.Analysis
 * analysis表的查询和下载
 *
 * @author 邵雯
 * @date 2023-03-10
 */
@RestController
@RequestMapping("/tran/fator/analysis")
public class AnalysisController extends BaseController {
    @Autowired
    private IAnalysisService analysisService;

    /**
     * 查询【Analysis】列表
     */
    @PreAuthorize("@ss.hasPermi('system:analysis:list')")
    @GetMapping("/list")
    public TableDataInfo list(Analysis analysis) {
        startPage();
        List<Analysis> list = analysisService.selectAnalysisList(analysis);
        return getDataTable(list);
    }

    /**
     * 导出【Analysis】列表
     */
    @PreAuthorize("@ss.hasPermi('system:analysis:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, Analysis analysis) {
        List<Analysis> list = analysisService.selectAnalysisList(analysis);
        ExcelUtil<Analysis> util = new ExcelUtil<Analysis>(Analysis.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【Analysis】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:analysis:query')")
    @GetMapping(value = "/{analysisId}")
    public AjaxResult getInfo(@PathVariable("analysisId") Long analysisId) {
        return AjaxResult.success(analysisService.selectAnalysisByAnalysisId(analysisId));
    }

    /**
     * 新增【Analysis】
     */
    @PreAuthorize("@ss.hasPermi('system:analysis:add')")
    @PostMapping
    public AjaxResult add(@RequestBody Analysis analysis) {
        return toAjax(analysisService.insertAnalysis(analysis));
    }

    /**
     * 修改【Analysis】
     */
    @PreAuthorize("@ss.hasPermi('system:analysis:edit')")
    @PutMapping
    public AjaxResult edit(@RequestBody Analysis analysis) {
        return toAjax(analysisService.updateAnalysis(analysis));
    }

    /**
     * 删除【Analysis】
     */
    @PreAuthorize("@ss.hasPermi('system:analysis:remove')")
    @DeleteMapping("/{analysisIds}")
    public AjaxResult remove(@PathVariable Long[] analysisIds) {
        return toAjax(analysisService.deleteAnalysisByAnalysisIds(analysisIds));
    }


    //查询 Omica
    @PreAuthorize("@ss.hasPermi('system:analysis:selectOmics')")
    @GetMapping("/selectOmics")
    public AjaxResult selectOmics() {
        return AjaxResult.success(analysisService.selectOmics());
    }

    //查询 AnalysisID (即表中的name)
    @PreAuthorize("@ss.hasPermi('system:analysis:selectAnalysisID')")
    @GetMapping("/selectAnalysisID")
    public AjaxResult selectAnalysisID() {
        return AjaxResult.success(analysisService.selectAnalysisID());
    }

    //查询 Analysis
    @PreAuthorize("@ss.hasPermi('system:analysis:selectAnalysis')")
    @RequestMapping("/selectAnalysis")
    public TableDataInfo selectAnalysis(Analysis analysis) {
        startPage();
        List<Analysis> list = analysisService.selectAnalysis(analysis.getName(), analysis.getOmics(), analysis.getDescription());
        return getDataTable(list);
    }

    /*    @PreAuthorize("@ss.hasPermi('system:analysis:selectAnalysis')")
    @RequestMapping("/selectAnalysis")
    public AjaxResult selectAnalysis(Analysis analysis) {
        List<Analysis> list = analysisService.selectAnalysis(analysis.getName(), analysis.getOmics(), analysis.getDescription());
        return AjaxResult.success(list);
    }*/


    //下载 analysis表查询结果
    @PreAuthorize("@ss.hasPermi('system:analysis:download')")
    @RequestMapping("/download")
    public void download(HttpServletResponse response,@RequestParam List<String> list) {
        try {
            List<Analysis> alist = new ArrayList<>();

            for (String id:list) {
//                Analysis analysis = analysisService.selectAnalysisByAnalysisId(Long.parseLong(id));
                Analysis analysis = analysisService.selectAnalysisByName(id);
                alist.add(analysis);
            }
            ExcelUtil<Analysis> util = new ExcelUtil<>(Analysis.class);
            util.exportExcel(response, alist, "查询数据 analysis_table");
        } catch (Exception ex) {
            logger.error("添加信息异常", ex);
        }
    }

/*    //下载 analysis表查询结果
    @PreAuthorize("@ss.hasPermi('system:analysis:download')")
    @RequestMapping("/download")
    public void download(HttpServletResponse response, Map<String, String> map) {
        try {
            //获取前端传来的json,用字符串
            String ids = map.get("ids");
            //解析字符串里面的id，并存入list集合中
            List<String> collect = Arrays.asList(ids.split(",")).stream().map(s -> s.trim()).collect(Collectors.toList());
            List<Analysis> list = new ArrayList<>();

            for (String id : collect) {
//                Analysis analysis = analysisService.selectAnalysisByAnalysisId(Long.parseLong(id));
                Analysis analysis = analysisService.selectAnalysisByName(id);
                list.add(analysis);
            }
            ExcelUtil<Analysis> util = new ExcelUtil<>(Analysis.class);
            util.exportExcel(response, list, "查询数据 analysis_table");
        } catch (Exception ex) {
            logger.error("添加信息异常", ex);
        }
    }*/

    //测试 selectAnalysisByName 测试download结果是否正确
    @PreAuthorize("@ss.hasPermi('system:analysis:selectAnalysisByName')")
    @RequestMapping("/selectAnalysisByName")
    public AjaxResult selectAnalysisByName(String name) {
        return AjaxResult.success(analysisService.selectAnalysisByName(name));
    }

}
