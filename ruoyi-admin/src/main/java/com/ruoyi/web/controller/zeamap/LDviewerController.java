package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.zeamap.service.LDviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/zeamap/LDviewer")
public class LDviewerController {
    @Autowired
    private LDviewService lDviewService;

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
        String path = lDviewService.selectLoadByAnalysisId(analysis_id);
        if (path == null|| path.equals("")){
            List<String> e = new ArrayList<>();
            return AjaxResult.success(e);
        }
        return AjaxResult.success(lDviewService.selectChorm(path));
    }

    @ResponseBody
    @RequestMapping("/selectAll")
    public AjaxResult selectAll(String accession,String version,String alias,String description,String chorm,int start,int end) throws IOException {
        Long db_id = lDviewService.selectDbid(accession);
        Long dbxref_id = lDviewService.selectDbxrefIdByAll(accession,version,db_id);
        Long population_id = lDviewService.selectPopulationId(alias);
        Long analysis_id = lDviewService.selectAnalysisId(population_id,dbxref_id,description);
        String path = lDviewService.selectLoadByAnalysisId(analysis_id);
        if (path == null|| path.equals("")){
            List<String> e = new ArrayList<>();
            return AjaxResult.success(e);
        }
        return AjaxResult.success(lDviewService.selectData(path,chorm,start,end));
    }


}
