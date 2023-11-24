package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.InfoSelectCondition;
import com.ruoyi.zeamap.domain.TfbdInfo;
import com.ruoyi.zeamap.service.ITfbdInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 新增需求 1.3 Transcription factor binding site
 * tfbd_info 查询 下载
 *
 * @author 邵雯
 * @date 2023-03-07
 */
@RestController
@RequestMapping("/tran/fator/info")
public class TfbdInfoController extends BaseController {
    @Autowired
    private ITfbdInfoService tfbdInfoService;

    /**
     * 查询 tfbd_info 列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(TfbdInfo tfbdInfo) {
        startPage();
        List<TfbdInfo> list = tfbdInfoService.selectTfbdInfoList(tfbdInfo);
        return getDataTable(list);
    }

    /**
     * 导出 tfbd_info列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, TfbdInfo tfbdInfo) {
        List<TfbdInfo> list = tfbdInfoService.selectTfbdInfoList(tfbdInfo);
        ExcelUtil<TfbdInfo> util = new ExcelUtil<TfbdInfo>(TfbdInfo.class);
        util.exportExcel(response, list, "tfbd_info 数据");
    }

    /**
     * 获取 tfbd_info详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:query')")
    @GetMapping(value = "/{tfbdId}")
    public AjaxResult getInfo(@PathVariable("tfbdId") Long tfbdId) {
        return AjaxResult.success(tfbdInfoService.selectTfbdInfoByTfbdId(tfbdId));
    }

    /**
     * 新增 tfbd_info 数据
     */
    @PreAuthorize("@ss.hasPermi('system:info:add')")
    @PostMapping
    public AjaxResult add(@RequestBody TfbdInfo tfbdInfo) {
        return toAjax(tfbdInfoService.insertTfbdInfo(tfbdInfo));
    }

    /**
     * 修改 tfbd_info 数据
     */
    @PreAuthorize("@ss.hasPermi('system:info:edit')")
    @PutMapping
    public AjaxResult edit(@RequestBody TfbdInfo tfbdInfo) {
        return toAjax(tfbdInfoService.updateTfbdInfo(tfbdInfo));
    }

    /**
     * 删除 tfbd_info 单条数据
     */
    @PreAuthorize("@ss.hasPermi('system:info:remove')")
    @DeleteMapping("/{tfbdIds}")
    public AjaxResult remove(@PathVariable Long[] tfbdIds) {
        return toAjax(tfbdInfoService.deleteTfbdInfoByTfbdIds(tfbdIds));
    }

    //查询Reference
    @GetMapping("/selectReference")
    @PreAuthorize("@ss.hasPermi('system:info:selectReference')")
    @ResponseBody
    public AjaxResult selectReference() {
        List<String> list = tfbdInfoService.selectReference();
        return AjaxResult.success(list);
    }

    //查询Version
    @GetMapping("/selectVersion")
    @PreAuthorize("@ss.hasPermi('system:info:selectVersion')")
    @ResponseBody
    public AjaxResult selectVersion(@RequestParam String accession) {
        List<String> list = tfbdInfoService.selectVersion(accession);
        return AjaxResult.success(list);
    }

    //查询Analysis
    @GetMapping("/selectAnalysis")
    @PreAuthorize("@ss.hasAnyPermi('system:info:selectVersion')")
    @ResponseBody
    public AjaxResult selectAnalysis() {
        List<String> list = tfbdInfoService.selectAnalysis();
        return AjaxResult.success(list);
    }

    //查询TF ID
    @GetMapping("/selectTFID")
    @PreAuthorize("@ss.hasAnyPermi('system:info:selectTFID')")
    @ResponseBody
    public AjaxResult selectTFID() {
        List<String> list = tfbdInfoService.selectTFID();
        return AjaxResult.success(list);
    }

    //查询TF Name
    @GetMapping("/selectTFName")
    @PreAuthorize("@ss.hasAnyPermi('system:info:selectTFName')")
    @ResponseBody
    public AjaxResult selectTFName() {
        List<String> list = tfbdInfoService.selectTFName();
        return AjaxResult.success(list);
    }

    //查询TF Family
    @GetMapping("/selectTFFamily")
    @PreAuthorize("@ss.hasAnyPermi('system:info:selectTFFamily')")
    @ResponseBody
    public AjaxResult selectTFFamily() {
        List<String> list = tfbdInfoService.selectTFFamily();
        return AjaxResult.success(list);
    }

    //查询Target Gene ID
    @GetMapping("/selectTFGeneID")
    @PreAuthorize("@ss.hasAnyPermi('system:info:selectTFGeneID')")
    @ResponseBody
    public AjaxResult selectTFGeneID() {
        List<String> list = tfbdInfoService.selectTFGeneID();
        return AjaxResult.success(list);
    }

    //超链接 selectByGene 跳转到 genomics wjr

    //查询 tfbd_info
    @RequestMapping("/selectInfo")
    @PreAuthorize("@ss.hasPermi('system:info:selectInfo')")
    public TableDataInfo selectInfo(@RequestBody InfoSelectCondition selectCondition) {
        startPage();
        List<InfoSelectCondition> list = tfbdInfoService.selectInfo(selectCondition.getAccession(), selectCondition.getVersion(), selectCondition.getAnalysis_name(), selectCondition.getInfo_name(),
                selectCondition.getInfo_simplename(), selectCondition.getInfo_family(), selectCondition.getTarget_gene(), selectCondition.getP_value());
        //改ref太麻烦了，让前端拼接一下
        return getDataTable(list);
    }

    /*    @PostMapping("/selectInfo")
    @PreAuthorize("@ss.hasPermi('system:info:selectInfo')")
    public AjaxResult selectInfo(InfoSelectCondition selectCondition) {
        List<InfoSelectCondition> list = tfbdInfoService.selectInfo(selectCondition.getAccession(), selectCondition.getVersion(), selectCondition.getAnalysis_name(), selectCondition.getInfo_name(),
                selectCondition.getInfo_simplename(), selectCondition.getInfo_family(), selectCondition.getTarget_gene(), selectCondition.getP_value());
        //改ref太麻烦了，让前端拼接一下
        return AjaxResult.success(list);
    }*/

    /*

        @GetMapping("/selectInfo11")
        @PreAuthorize("@ss.hasPermi('system:info:selectInfo11')")
        public AjaxResult selectInfo11() {
            List<InfoSelectCondition> list = tfbdInfoService.selectInfo11();
                    return AjaxResult.success(list);
        }
    */
    //下载 Transcription查询结果
    @PreAuthorize("@ss.hasPermi('system:info:download')")
    @RequestMapping("/download")
    public void download(HttpServletResponse response, @RequestBody List<InfoSelectCondition> list) {
        ExcelUtil<InfoSelectCondition> util = new ExcelUtil<>(InfoSelectCondition.class);
        util.exportExcel(response, list, "查询数据 info_table");
    }
}


/*    //下载 Transcription查询结果
    @PreAuthorize("@ss.hasPermi('system:info:download')")
    @RequestMapping("/download")
    public void download(HttpServletResponse response, Map<String, String> map) {
        try {
            //获取前端传来的json,用字符串
            String ids = map.get("ids");
            //解析字符串里面的id，并存入list集合中
            List<String> collect = Arrays.asList(ids.split(",")).stream().map(s -> s.trim()).collect(Collectors.toList());

            String Analysis = map.get("Analysis");
            List<String> collect1 = Arrays.asList(Analysis.split(",")).stream().map(s -> s.trim()).collect(Collectors.toList());
            String Ref = map.get("Ref");
            List<String> collect2 = Arrays.asList(Ref.split(",")).stream().map(s -> s.trim()).collect(Collectors.toList());
            String TFID = map.get("TF ID");
            List<String> collect3 = Arrays.asList(TFID.split(",")).stream().map(s -> s.trim()).collect(Collectors.toList());
            String TFName = map.get("TF Name");
            List<String> collect4 = Arrays.asList(TFName.split(",")).stream().map(s -> s.trim()).collect(Collectors.toList());
            String TFFamily = map.get("TF Family");
            List<String> collect5 = Arrays.asList(TFFamily.split(",")).stream().map(s -> s.trim()).collect(Collectors.toList());
            String TargetGene = map.get("Target Gene");
            List<String> collect6 = Arrays.asList(TargetGene.split(",")).stream().map(s -> s.trim()).collect(Collectors.toList());
            String Pvalue = map.get("P-value");
            List<String> collect7 = Arrays.asList(Pvalue.split(",")).stream().map(s -> s.trim()).collect(Collectors.toList());

            List<InfoSelectCondition> list = new ArrayList<>();
            for (int i = 0; i < collect.size(); i++) {
                InfoSelectCondition selectCondition = new InfoSelectCondition(collect1.get(i), collect2.get(i), collect3.get(i), collect4.get(i), collect5.get(i), collect6.get(i), Double.parseDouble(collect7.get(i)));
                list.add(selectCondition);
            }
            ExcelUtil<InfoSelectCondition> util = new ExcelUtil<>(InfoSelectCondition.class);
            util.exportExcel(response,list, "查询数据 info_table");
        } catch (Exception ex) {
            logger.error("添加信息异常", ex);
        }
    }*/

