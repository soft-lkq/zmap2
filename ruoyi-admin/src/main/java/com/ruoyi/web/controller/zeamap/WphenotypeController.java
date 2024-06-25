package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.*;
import com.ruoyi.zeamap.service.IWphenotypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 表型Controller
 * 
 * @author ruoyi
 * @date 2024-03-19
 */
@RestController
@RequestMapping("/zeamap/Wphenotype")
public class WphenotypeController extends BaseController
{
    @Autowired
    private IWphenotypeService wphenotypeService;

    /**
     * 查询表型列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Wphenotype:list')")
    @GetMapping("/list")
    public TableDataInfo list(Wphenotype wphenotype)
    {
        startPage();
        List<Wphenotype> list = wphenotypeService.selectWphenotypeList(wphenotype);
        return getDataTable(list);
    }

    /**
     * 导出表型列表
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Wphenotype:export')")
    @Log(title = "表型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Wphenotype wphenotype)
    {
        List<Wphenotype> list = wphenotypeService.selectWphenotypeList(wphenotype);
        ExcelUtil<Wphenotype> util = new ExcelUtil<Wphenotype>(Wphenotype.class);
        util.exportExcel(response, list, "表型数据");
    }

    /**
     * 获取表型详细信息
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Wphenotype:query')")
    @GetMapping(value = "/{pedid}")
    public AjaxResult getInfo(@PathVariable("pedid") Long pedid)
    {
        return AjaxResult.success(wphenotypeService.selectWphenotypeByPedid(pedid));
    }

    /**
     * 新增表型
     * 新增表型
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Wphenotype:add')")
    @Log(title = "表型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Wphenotype wphenotype)
    {
        return toAjax(wphenotypeService.insertWphenotype(wphenotype));
    }

    /**
     * 修改表型
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Wphenotype:edit')")
    @Log(title = "表型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Wphenotype wphenotype)
    {
        return toAjax(wphenotypeService.updateWphenotype(wphenotype));
    }

    /**
     * 删除表型
     */
    @PreAuthorize("@ss.hasPermi('zeamap:Wphenotype:remove')")
    @Log(title = "表型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{pedids}")
    public AjaxResult remove(@PathVariable Long[] pedids)
    {
        return toAjax(wphenotypeService.deleteWphenotypeByPedids(pedids));
    }

    @ExceptionHandler(value = {java.sql.SQLSyntaxErrorException.class})
    public String handleException(Exception e){
        return "该性状不存在";
    }

    @ExceptionHandler(value = {NumberFormatException.class})
    public String handleE2(Exception e){
        return "请输入正确格式";
    }

    @ExceptionHandler(value = {NullPointerException.class})
    public String handleE3(Exception e){
        return "暂无数据";
    }

    @ExceptionHandler(value = {ArithmeticException.class})
    public String handleE4(Exception e){
        return "数据中有null值";
    }

    @PostMapping("/year")
    public AjaxResult selectByYear(@RequestParam List<Long> years){
        return AjaxResult.success(wphenotypeService.selectPhenotypeByYear(years));
    }

    @PostMapping(value = "/name")
    public AjaxResult selectByname(String pedigree){
        try{
            pedigree= URLDecoder.decode(pedigree,"UTF-8");
            System.out.println(pedigree);
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(pedigree);
        return AjaxResult.success(wphenotypeService.selectPhenotypeByname(pedigree));
    }

    @GetMapping("/all")
    public AjaxResult selectAll(){
        return AjaxResult.success(wphenotypeService.selectAllPhenotype());
    }

    @PostMapping("/search")
    public AjaxResult search(@RequestParam List<String> pedigrees,@RequestParam List<Long> years,@RequestParam List<String> locations,@RequestParam List<String> traits){
        if(!pedigrees.isEmpty()){
        try{
            for (int i = 0;i<pedigrees.size();i++){
                pedigrees.set(i, URLDecoder.decode(pedigrees.get(i),"UTF-8"));
            }
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        }
        if(traits.isEmpty()){
            return AjaxResult.success(wphenotypeService.sort(wphenotypeService.selectBy(pedigrees, years, locations)));
        }
        if(wphenotypeService.isTrait(traits)){
            return AjaxResult.success("选择中有性状不存在");
        }
        List<Map<String,String>> maps =wphenotypeService.sort(wphenotypeService.findBxServe(pedigrees,years,locations,traits));
        for (Map<String,String> map : maps) {
            for (String t : traits) {
                if(!map.containsKey(t)){
                    map.put(t,"null");
                }
            }
        }
        return AjaxResult.success(maps);
    }

    @GetMapping("/allYear")
    public AjaxResult selectAllYear(){
        return AjaxResult.success(wphenotypeService.selectAllYear());
    }

    @GetMapping("/allLocation")
    public AjaxResult selectAllLocation(){
        return AjaxResult.success(wphenotypeService.selectAllLocation());
    }

    @GetMapping("/allTrait")
    public AjaxResult selectAllTrait(){
        return AjaxResult.success(wphenotypeService.selectAllTrait());
    }

    @GetMapping("/allPedigree")
    public AjaxResult selectAllPedigree(){
        return AjaxResult.success(wphenotypeService.selectAllpedigree());
    }

    @PostMapping("/Morphological")
    public AjaxResult selectMorph(String pedigree){
        try{
            pedigree= URLDecoder.decode(pedigree,"UTF-8");
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        MorphologicalVo[] morphologicalVos = wphenotypeService.selectMorphologicalByname(pedigree);
//        return AjaxResult.success(wphenotypeService.meanMorphological(morphologicalVos));
        return AjaxResult.success(wphenotypeService.meanMorphological(morphologicalVos));
    }

    @GetMapping ("/MorMean")
    public AjaxResult selectMorMean(){
        MorphologicalVo[] morphologicalVo = wphenotypeService.selectAllMorphological();
        return AjaxResult.success(wphenotypeService.meanMorphological(morphologicalVo));
    }

    @PostMapping("/Agronomical")
    public AjaxResult selectAgronomical(String pedigree){
        try{
            pedigree= URLDecoder.decode(pedigree,"UTF-8");
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        AgronomicalVo[] agronomicalVos = wphenotypeService.selectAgronomicalByname(pedigree);
        return AjaxResult.success(wphenotypeService.meanAgronomicalVo(agronomicalVos));
    }

    @GetMapping("/AgrMean")
    public AjaxResult selectAgrMean(){
        AgronomicalVo[] agronomicalVos = wphenotypeService.selectAllAgronomical();
        return AjaxResult.success(wphenotypeService.meanAgronomicalVo(agronomicalVos));
    }

    @PostMapping("/Date")
    public AjaxResult selectDateByName(String pedigree){
        try{
            pedigree= URLDecoder.decode(pedigree,"UTF-8");
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        BxDateVo[] bxDateVos = wphenotypeService.selectBxDate(pedigree);
        if(bxDateVos.length==1){
            return AjaxResult.success(bxDateVos[0]);
        }
        return AjaxResult.success(wphenotypeService.meanDate(bxDateVos));
    }

    @GetMapping("/DateMean")
    public AjaxResult selectMeanDate(){
        BxDateVo[] bxDateVos = wphenotypeService.selectAllDate();
        return AjaxResult.success(wphenotypeService.meanDate(bxDateVos));
    }

    @PostMapping("/Rates")
    public AjaxResult selectRateByName(String pedigree){
        try{
            pedigree= URLDecoder.decode(pedigree,"UTF-8");
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        BxRateVo[] bxRateVos = wphenotypeService.selectBxRateByName(pedigree);
        if(bxRateVos.length==1){
            return AjaxResult.success(bxRateVos);
        }
        return AjaxResult.success(wphenotypeService.MeanRate(bxRateVos));
    }

    @GetMapping("/RatesMean")
    public AjaxResult selectMeanRate(){
        BxRateVo[] rateVos = wphenotypeService.selectAllRate();
        return AjaxResult.success(wphenotypeService.MeanRate(rateVos));
    }

    @PostMapping("/Yield")
    public AjaxResult selectYieldByName(String pedigree){
        try{
            pedigree= URLDecoder.decode(pedigree,"UTF-8");
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Yield[] yields = wphenotypeService.selectYieldByName(pedigree);
        if(yields.length==1){
            return AjaxResult.success(yields);
        }
        return AjaxResult.success(wphenotypeService.MeanYield(yields));
    }

    @GetMapping("/YieldMean")
    public AjaxResult selectMeanYield(){
        Yield[] yields = wphenotypeService.selectAllYield();
        return AjaxResult.success(wphenotypeService.MeanYield(yields));
    }

    @PostMapping("/location")
    public AjaxResult selectBylocation(@RequestParam List<String> locations){
        return AjaxResult.success(wphenotypeService.selectPhenotypeByLocations(locations));
    }

    @PostMapping("/trait")
    public AjaxResult selectTrait(@RequestParam List<String> traits){
        if(wphenotypeService.isTrait(traits)){
            return AjaxResult.success("该性状不存在");
        }
        List<Map<String,String>> maps =wphenotypeService.sort(wphenotypeService.selectTrait(traits));
        for (Map<String,String> map : maps) {
            for (String t : traits) {
                if(!map.containsKey(t)){
                    map.put(t,"null");
                }
            }
        }
        return AjaxResult.success(maps);
    }

    @PostMapping("traitByName")
    public AjaxResult selectTraitByName(@RequestParam String pedigree,@RequestParam List<String> traits){
        try{
            pedigree= URLDecoder.decode(pedigree);
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        }
        if(wphenotypeService.isTrait(traits)){
            return AjaxResult.success("该性状不存在");
        }
        List<Map<String,String>> maps =wphenotypeService.sort(wphenotypeService.selectTraitsByName(pedigree,traits));
        for (Map<String,String> map : maps) {
            for (String t : traits) {
                if(!map.containsKey(t)){
                    map.put(t,"null");
                }
            }
        }
        return AjaxResult.success(maps);
    }

    @PostMapping("/locationTrait")
    public AjaxResult selectTraitByGroup(@RequestParam List<String> traits) {
        String trait = traits.get(0);
        if(wphenotypeService.isTrait(Collections.singletonList(trait))){
            return AjaxResult.success("该性状不存在");
        }
        List<GeVo> geVos;
        List<String> strings;
        geVos = wphenotypeService.selectGe(trait);
        strings = wphenotypeService.selectTraitGroup(trait);
        return AjaxResult.success(wphenotypeService.resultGeVo(geVos, strings));
    }

    @PostMapping("/locationTraitName")
    public AjaxResult selectTraitGroupByname(@RequestParam String pedigree,@RequestParam List<String> traits){
        String trait = traits.get(0);
        try{
            pedigree= URLDecoder.decode(pedigree);
        }catch (UnsupportedOperationException e){
            e.printStackTrace();
        }
        if(wphenotypeService.isTrait(Collections.singletonList(trait))){
            return AjaxResult.success("该性状不存在");
        }
        List<GeVo> geVos = wphenotypeService.selectGeByName(pedigree,trait);
        List<String> strings = wphenotypeService.selectTraitGroupByName(pedigree,trait);
        return AjaxResult.success(wphenotypeService.resultGeVo(geVos,strings));
    }

    @GetMapping("/allMor")
    public AjaxResult selectAllMor(){
        return  AjaxResult.success(wphenotypeService.selectAllMar());
    }

    @GetMapping("/allAgr")
    public AjaxResult selectallAgr(){
        return AjaxResult.success(wphenotypeService.selectAllAgro());
    }

    @GetMapping("/allAbiotic")
    public AjaxResult selectallAbiotic(){
        return AjaxResult.success(wphenotypeService.selectAllAbiotic());
    }

    @GetMapping("/allBiotic")
    public AjaxResult selectallBiotic(){
        return AjaxResult.success(wphenotypeService.selectAllBiotic());
    }

    @GetMapping("/allYield")
    public AjaxResult selectYield(){
        return AjaxResult.success(wphenotypeService.selectAllYields());
    }

    @GetMapping("/yearAgr")
    public AjaxResult selectYearAgr(){
        return AjaxResult.success(wphenotypeService.selectYearAgr());
    }

    @GetMapping("/yearAbiotic")
    public AjaxResult selectYearAbiotic(){
        return AjaxResult.success(wphenotypeService.selectYearAbiotic());
    }

    @GetMapping("/yearBiotic")
    public AjaxResult selectYearBiotic(){
        return AjaxResult.success(wphenotypeService.selectYearBiotic());
    }

    @GetMapping("/yearMor")
    public AjaxResult selectYearMor(){
        return AjaxResult.success(wphenotypeService.selectYearMor());
    }

    @GetMapping("yearYield")
    public AjaxResult selectYearYield(){
        return AjaxResult.success(wphenotypeService.selectYearYield());
    }

    @GetMapping("/checkTraitTypeName")
    public AjaxResult checkTraitTypeName() {
        List<Integer> list = new ArrayList<>();
        String t1="Morphological";
        int n1=wphenotypeService.countBx(t1);
        list.add(n1);
        String t2 = "Agronomical";
        int n2=wphenotypeService.countBx(t2);
        list.add(n2);
        String t3="Abiotic stress";
        int n3 = wphenotypeService.countBx(t3);
        String t4 = "Biotic stress";
        int n4=wphenotypeService.countBx(t4);
        list.add(n3);
        list.add(n4);
        String t5 = "Yield";
        int n6 = wphenotypeService.countBx(t5);
        list.add(n6);
        int n5=wphenotypeService.countData();
        list.add(n5);
        return AjaxResult.success(list);
    }

}
