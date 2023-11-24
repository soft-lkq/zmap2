package com.ruoyi.web.controller.zeamap;


import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.zeamap.service.GenoViewerService;
import com.ruoyi.zeamap.service.LDviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/zeamap/genoviewer")
public class GenoViewerController extends BaseController {
    @Autowired
    private LDviewService lDviewService;
    @Autowired
    private GenoViewerService genoViewerService;

    @ResponseBody
    @RequestMapping("/reference")
    public AjaxResult Reference(){
        List<String> list = lDviewService.selectaccession();
        return AjaxResult.success(list);
    }

    @ResponseBody
    @RequestMapping("/version")
    public AjaxResult Version(String accession){
        return AjaxResult.success(lDviewService.selectVersionByAccesion(accession));
    }

    @ResponseBody
    @RequestMapping("/alias")
    public AjaxResult Alias(){
        return AjaxResult.success(lDviewService.selectAlias());
    }

    @ResponseBody
    @RequestMapping("/description")
    public AjaxResult Description(String accession,String version,String alias){
        Long db_id=lDviewService.selectDbid(accession);
        Long dbxref_id = lDviewService.selectDbxrefIdByAll(accession,version,db_id);
        Long population_id = lDviewService.selectPopulationId(alias);
        return AjaxResult.success(lDviewService.selectDescription(population_id,dbxref_id));
    }

    @ResponseBody
    @RequestMapping("/selectChorm")
    public AjaxResult selectLoad(String accession,String version,String alias,String description) throws IOException {
        Long db_id = lDviewService.selectDbid(accession);
        Long dbxref_id = lDviewService.selectDbxrefIdByAll(accession,version,db_id);
        Long population_id = lDviewService.selectPopulationId(alias);
        Long analysis_id = lDviewService.selectAnalysisId(population_id,dbxref_id,description);
        String path = genoViewerService.selectFile(analysis_id);
        if (path == null|| path.equals("")){
            List<String> e = new ArrayList<>();
            return AjaxResult.success(e);
        }
        return AjaxResult.success(genoViewerService.selectChorm(path));
    }

    @ResponseBody
    @RequestMapping("/TST")
    public AjaxResult TST(){
        return AjaxResult.success(genoViewerService.selectTst());
    }

    @ResponseBody
    @RequestMapping("/Mixed")
    public AjaxResult Mix(){
        return AjaxResult.success(genoViewerService.selectMix());
    }

    @ResponseBody
    @RequestMapping("/NSS")
    public AjaxResult NSS(){
        return AjaxResult.success(genoViewerService.selectNss());
    }

    @ResponseBody
    @RequestMapping("/SS")
    public AjaxResult SS(){
        return AjaxResult.success(genoViewerService.selectSS());
    }

    @ResponseBody
    @RequestMapping("/selectData")
    public TableDataInfo Data(String accession, String version, String alias, String description, String[] choose, String chorm, int start, int end, int pageSize, int pageNum) throws IOException {
        Long db_id = lDviewService.selectDbid(accession);
        Long dbxref_id = lDviewService.selectDbxrefIdByAll(accession,version,db_id);
        Long population_id = lDviewService.selectPopulationId(alias);
        Long analysis_id = lDviewService.selectAnalysisId(population_id,dbxref_id,description);
        String path = genoViewerService.selectFile(analysis_id);
        if (path == null|| path.equals("")){
            return null;
        }
        List<String> list=genoViewerService.selectData(path,choose,chorm,start,end);
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(0);
        rspData.setRows(PageUtils.startWjPage(list, pageNum, pageSize));
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }
}
