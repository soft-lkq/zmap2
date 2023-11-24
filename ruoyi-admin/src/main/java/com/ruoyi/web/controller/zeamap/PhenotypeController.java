package com.ruoyi.web.controller.zeamap;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.zeamap.domain.*;
import com.ruoyi.zeamap.service.ITraitTypeService;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.zeamap.service.IPhenotypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * PhenotypeController
 * 
 * @author wj
 * @date 2023-10-11
 */
@RestController
@RequestMapping("/zeamap/Phenotype")
public class PhenotypeController extends BaseController
{
    @Autowired
    private IPhenotypeService phenotypeService;

    @Autowired
    private ITraitTypeService traitTypeService;


    /**
     * 查询Phenotype列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Phenotype:list')")
    @GetMapping("/list")
    public TableDataInfo list(Phenotype phenotype)
    {
        startPage();
        List<Phenotype> list = phenotypeService.selectPhenotypeList(phenotype);
        return getDataTable(list);
    }

    /**
     * 导出Phenotype列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Phenotype:export')")
    @Log(title = "Phenotype", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Phenotype phenotype)
    {
        List<Phenotype> list = phenotypeService.selectPhenotypeList(phenotype);
        ExcelUtil<Phenotype> util = new ExcelUtil<Phenotype>(Phenotype.class);
        util.exportExcel(response, list, "Phenotype数据");
    }

    /**
     * 获取Phenotype详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Phenotype:query')")
    @GetMapping(value = "/{code}")
    public AjaxResult getInfo(@PathVariable("code") Long code)
    {
        return AjaxResult.success(phenotypeService.selectPhenotypeByCode(code));
    }

    /**
     * 新增Phenotype
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Phenotype:add')")
    @Log(title = "Phenotype", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Phenotype phenotype)
    {
        return toAjax(phenotypeService.insertPhenotype(phenotype));
    }

    /**
     * 修改Phenotype
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Phenotype:edit')")
    @Log(title = "Phenotype", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Phenotype phenotype)
    {
        return toAjax(phenotypeService.updatePhenotype(phenotype));
    }

    /**
     * 删除Phenotype
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Phenotype:remove')")
    @Log(title = "Phenotype", businessType = BusinessType.DELETE)
	@DeleteMapping("/{codes}")
    public AjaxResult remove(@PathVariable Long[] codes)
    {
        return toAjax(phenotypeService.deletePhenotypeByCodes(codes));
    }

    @PostMapping("/year")
    public AjaxResult selectByYear(Long year){
        return AjaxResult.success(phenotypeService.selectPhenotypeByYear(year));
    }

    @PostMapping("/name")
    public AjaxResult selectByname(String pedigree){
        return AjaxResult.success(phenotypeService.selectPhenotypeByname(pedigree));
    }

    @PostMapping("/Morphological")
    public AjaxResult selectMorph(String pedigree){
        MorphologicalVo[] morphologicalVos = phenotypeService.selectMorphologicalByname(pedigree);
        return AjaxResult.success(phenotypeService.meanMorphological(morphologicalVos));
    }

    @GetMapping ("/MorMean")
    public AjaxResult selectMorMean(){
        MorphologicalVo[] morphologicalVo = phenotypeService.selectAllMorphological();
        return AjaxResult.success(phenotypeService.meanMorphological(morphologicalVo));
    }

    @PostMapping("/Agronomical")
    public AjaxResult selectAgronomical(String pedigree){
        AgronomicalVo[] agronomicalVos = phenotypeService.selectAgronomicalByname(pedigree);
        return AjaxResult.success(phenotypeService.meanAgronomicalVo(agronomicalVos));
    }

    @GetMapping("/AgrMean")
    public AjaxResult selectAgrMean(){
        AgronomicalVo[] agronomicalVos = phenotypeService.selectAllAgronomical();
        return AjaxResult.success(phenotypeService.meanAgronomicalVo(agronomicalVos));
    }

    @PostMapping("/Date")
    public AjaxResult selectDateByName(String pedigree){
        BxDateVo[] bxDateVos = phenotypeService.selectBxDate(pedigree);
        return AjaxResult.success(phenotypeService.meanDate(bxDateVos));
    }

    @GetMapping("/DateMean")
    public AjaxResult selectMeanDate(){
        BxDateVo[] bxDateVos = phenotypeService.selectAllDate();
        return AjaxResult.success(phenotypeService.meanDate(bxDateVos));
    }

    @PostMapping("/Rates")
    public AjaxResult selectRateByName(String pedigree){
        BxRateVo[] bxRateVos = phenotypeService.selectBxRateByName(pedigree);
        return AjaxResult.success(phenotypeService.MeanRate(bxRateVos));
    }

    @GetMapping("/RatesMean")
    public AjaxResult selectMeanRate(){
        BxRateVo[] rateVos = phenotypeService.selectAllRate();
        return AjaxResult.success(phenotypeService.MeanRate(rateVos));
    }


    @PostMapping("/location")
    public AjaxResult selectBylocation(String location){
        return AjaxResult.success(phenotypeService.selectPhenotypeByLocation(location));
    }

    @GetMapping("/all")
    public AjaxResult selectAll(){
        return AjaxResult.success(phenotypeService.selectAllPhenotype());
    }

    @PostMapping("/trait")
    public AjaxResult selectTrait(String trait){
        List<TraitVo> traitVos = phenotypeService.selectTVo();
        List<String> strings = phenotypeService.selectTrait(trait);
        return AjaxResult.success(phenotypeService.resultTrait(traitVos,strings));
    }

    @PostMapping("traitByName")
    public AjaxResult selectTraitByName(String pedigree,String trait){
        List<TraitVo> traitVos = phenotypeService.selectTVoByName(pedigree,trait);
        List<String> strings = phenotypeService.selectTraitByName(pedigree,trait);
        return AjaxResult.success(phenotypeService.resultTrait(traitVos,strings));
    }

    @PostMapping("/locationTrait")
    public AjaxResult selectTraitByGroup(String trait){
       List<GeVo> geVos = phenotypeService.selectGe(trait);
       List<String> strings = phenotypeService.selectTraitGroup(trait);
       return AjaxResult.success(phenotypeService.resultGeVo(geVos,strings));
    }

    @PostMapping("/locationTraitName")
    public AjaxResult selectTraitGroupByname(String pedigree,String trait){
        List<GeVo> geVos = phenotypeService.selectGeByName(pedigree,trait);
        List<String> strings = phenotypeService.selectTraitGroupByName(pedigree,trait);
        return AjaxResult.success(phenotypeService.resultGeVo(geVos,strings));
    }

    @GetMapping("/allMor")
    public AjaxResult selectAllMor(){
        return  AjaxResult.success(phenotypeService.selectAllMar());
    }

    @GetMapping("/yearMor")
    public AjaxResult selectYearMor(){
        return AjaxResult.success(phenotypeService.selectYearMor());
    }

    @PostMapping("/checkTraitTypeName")
    public AjaxResult checkTraitTypeName(String traitName) {
        return AjaxResult.success(phenotypeService.countBx(traitName));
    }

}

