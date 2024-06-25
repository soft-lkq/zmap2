package com.ruoyi.zeamap.service.impl;

import com.ruoyi.zeamap.domain.*;
import com.ruoyi.zeamap.mapper.WphenotypeMapper;
import com.ruoyi.zeamap.service.IWphenotypeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * 表型Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-19
 */
@Service
public class WphenotypeServiceImpl implements IWphenotypeService 
{
    @Autowired
    private WphenotypeMapper wphenotypeMapper;

    /**
     * 查询表型
     * 
     * @param pedid 表型主键
     * @return 表型
     */
    @Override
    public Wphenotype selectWphenotypeByPedid(Long pedid)
    {
        return wphenotypeMapper.selectWphenotypeByPedid(pedid);
    }

    /**
     * 查询表型列表
     * 
     * @param wphenotype 表型
     * @return 表型
     */
    @Override
    public List<Wphenotype> selectWphenotypeList(Wphenotype wphenotype)
    {
        return wphenotypeMapper.selectWphenotypeList(wphenotype);
    }

    /**
     * 新增表型
     * 
     * @param wphenotype 表型
     * @return 结果
     */
    @Override
    public int insertWphenotype(Wphenotype wphenotype)
    {
        return wphenotypeMapper.insertWphenotype(wphenotype);
    }

    /**
     * 修改表型
     * 
     * @param wphenotype 表型
     * @return 结果
     */
    @Override
    public int updateWphenotype(Wphenotype wphenotype)
    {
        return wphenotypeMapper.updateWphenotype(wphenotype);
    }

    /**
     * 批量删除表型
     * 
     * @param pedids 需要删除的表型主键
     * @return 结果
     */
    @Override
    public int deleteWphenotypeByPedids(Long[] pedids)
    {
        return wphenotypeMapper.deleteWphenotypeByPedids(pedids);
    }

    /**
     * 删除表型信息
     * 
     * @param pedid 表型主键
     * @return 结果
     */
    @Override
    public int deleteWphenotypeByPedid(Long pedid)
    {
        return wphenotypeMapper.deleteWphenotypeByPedid(pedid);
    }

    @Override
    public List<Wphenotype> selectPhenotypeByYear(List<Long> years) {
        return wphenotypeMapper.selectPhenotypeByYear(years);
    }

    @Override
    public List<Wphenotype> selectPhenotypeByname(String pedigree) {
        return wphenotypeMapper.selectPhenotypeByname(pedigree);
    }

    @Override
    public List<Wphenotype> selectAllPhenotype() {
        return wphenotypeMapper.selectAllPhenotype();
    }

    @Override
    public List<Map<String,String>> selectBy(List<String> pedigrees, List<Long> years, List<String> locations) {
        return wphenotypeMapper.selectBy(pedigrees, years, locations);
    }


    @Override
    public List<SearchVo> selectWithTrait(@Param("pedigrees")List<String> pedigrees, @Param("years")List<Long> years, @Param("locations")List<String> locations,@Param("traits")List<String> traits) {
        return wphenotypeMapper.selectWithTrait(pedigrees,years,locations,traits);
    }

    @Override
    public List<SearchVo> resultWith(List<SearchVo> searchVos, List<String> strings) {
        SearchVo[] traitVos1 = searchVos.toArray(new SearchVo[searchVos.size()]);
        String[] strings1 = strings.toArray(new String[strings.size()]);
        for(int i=0;i<strings.size();i++){
            traitVos1[i].setTrait(strings1[i]);
        }
        return Arrays.asList(traitVos1);
    }

    @Override
    public List<String> searchTrait(@Param("pedigrees")List<String> pedigrees, @Param("years")List<Long> years, @Param("locations")List<String> locations, @Param("traits")List<String> traits) {
        return wphenotypeMapper.searchTrait(pedigrees,years,locations,traits);
    }

    @Override
    public boolean isTrait(List<String> traits) {
        if(traits.isEmpty())
            return false;
        for (String trait : traits) {
            for (int i=trait.length();--i>=0;){
                if(!Character.isDigit(trait.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public List<Long> selectAllYear() {
        return wphenotypeMapper.selectAllYear();
    }

    @Override
    public List<String> selectAllTrait() {
        return wphenotypeMapper.selectAllTrait();
    }

    @Override
    public List<String> selectAllLocation() {
        return wphenotypeMapper.selectAllLocation();
    }

    @Override
    public MorphologicalVo[] selectMorphologicalByname(String pedigree) {
        return wphenotypeMapper.selectMorphologicalByname(pedigree);
    }

    @Override
    public MorphologicalVo meanMorphological(MorphologicalVo[] morphologicalVos) {
        BigDecimal leafLengthSum = BigDecimal.ZERO;
        BigDecimal leafWidthSum = BigDecimal.ZERO;
        BigDecimal plantHeightSum = BigDecimal.ZERO;
        BigDecimal earHeightSum = BigDecimal.ZERO;
        BigDecimal tasselBranchNumberSum = BigDecimal.ZERO;
        Long leafNumber1Sum = 0L;
        BigDecimal stemDiameterSum = BigDecimal.ZERO;


        for (MorphologicalVo morphological : morphologicalVos) {
            if(morphological.getLeafLength()!=null)
            leafLengthSum = leafLengthSum.add(morphological.getLeafLength());
            if(morphological.getLeafWidth()!=null)
            leafWidthSum = leafWidthSum.add(morphological.getLeafWidth());
            if(morphological.getPlantHeight()!=null)
            plantHeightSum = plantHeightSum.add(morphological.getPlantHeight());
            if(morphological.getEarHeight()!=null)
            earHeightSum = earHeightSum.add(morphological.getEarHeight());
            if(morphological.getTasselBranchNumber()!=null)
            tasselBranchNumberSum = tasselBranchNumberSum.add(morphological.getTasselBranchNumber());
            if(morphological.getLeafNumber1()!=null)
            leafNumber1Sum += morphological.getLeafNumber1();
            if(morphological.getStemDiameter()!=null)
            stemDiameterSum = stemDiameterSum.add(morphological.getStemDiameter());
        }

        int numRecords = morphologicalVos.length;

        BigDecimal leafLengthAverage = BigDecimal.ZERO;
        BigDecimal leafWidthAverage = BigDecimal.ZERO;
        BigDecimal plantHeightAverage = BigDecimal.ZERO;
        BigDecimal earHeightAverage = BigDecimal.ZERO;
        BigDecimal tasselBranchNumberAverage = BigDecimal.ZERO;
        Long leafNumber1Average = 0L;
        BigDecimal stemDiameterAverage = BigDecimal.ZERO;



        if(leafLengthSum != BigDecimal.ZERO) leafLengthAverage = leafLengthSum.divide(BigDecimal.valueOf(numRecords), 2, BigDecimal.ROUND_HALF_UP);
        if(leafWidthSum!= BigDecimal.ZERO)leafWidthAverage = leafWidthSum.divide(BigDecimal.valueOf(numRecords), 2, BigDecimal.ROUND_HALF_UP);
        if(plantHeightSum!= BigDecimal.ZERO)plantHeightAverage = plantHeightSum.divide(BigDecimal.valueOf(numRecords), 2, BigDecimal.ROUND_HALF_UP);
        if(earHeightSum!= BigDecimal.ZERO)earHeightAverage = earHeightSum.divide(BigDecimal.valueOf(numRecords), 2, BigDecimal.ROUND_HALF_UP);
        if(tasselBranchNumberSum!= BigDecimal.ZERO)tasselBranchNumberAverage = tasselBranchNumberSum.divide(BigDecimal.valueOf(numRecords), 2, BigDecimal.ROUND_HALF_UP);
        if(leafNumber1Sum!=0L)leafNumber1Average = leafNumber1Sum/numRecords;
        if(stemDiameterSum!= BigDecimal.ZERO)stemDiameterAverage = stemDiameterSum.divide(BigDecimal.valueOf(numRecords), 2, BigDecimal.ROUND_HALF_UP);
        MorphologicalVo res = new MorphologicalVo(leafLengthAverage,leafWidthAverage,plantHeightAverage,earHeightAverage,tasselBranchNumberAverage,leafNumber1Average,stemDiameterAverage);
        res.setPedid(1L);
        res.setPedigree("all");
        res.setPedigreeSource1("all");
        res.setPedigreeSource2("all");
        res.setYear(2000L);
        res.setLocation("all");
        res.setRootLayer("1");
        res.setSilkColor("1");
        res.setAntherColor("1");
        res.setRachisColor("1");
        res.setGrainColor("1");
        return res;
    }

    @Override
    public MorphologicalVo[] selectAllMorphological() {
        return wphenotypeMapper.selectAllMorphological();
    }

    @Override
    public AgronomicalVo[] selectAgronomicalByname(String pedigree) {
        return wphenotypeMapper.selectAgrByName(pedigree);
    }

    @Override
    public AgronomicalVo[] selectAllAgronomical() {
        return wphenotypeMapper.selectAllAgr();
    }

    @Override
    public AgronomicalVo meanAgronomicalVo(AgronomicalVo[] agronomicalVos) {
        Long a = 0L;
        Long b = 0L;
        Long c = 0L;
        Long d = 0L;
        Long e = 0L;
        int len = agronomicalVos.length;
        for (AgronomicalVo arg :
                agronomicalVos) {
            if(arg.getEmptyStalkNumber()!=null) a+=arg.getEmptyStalkNumber();
            if(arg.getDoubleEarNumber()!=null)b+=arg.getDoubleEarNumber();
            if(arg.getAntherTasselInterval()!=null)c+=arg.getAntherTasselInterval();
            if(arg.getSelectedPlantNumber()!=null)d+=arg.getSelectedPlantNumber();
            if(arg.getPlantNumber()!=null)e+=arg.getPlantNumber();
        }
        if(a!=0L)a /= len;
        if(b!=0L)b /= len;
        if(c!=0L)c /= len;
        if(d!=0L)d /= len;
        if(e!=0L)e /= len;
        AgronomicalVo res = new AgronomicalVo(a,b,c,d,e);
        res.setPedigree("all");
        res.setPedigreeSource1("all");
        res.setPedigreeSource2("all");
        res.setYear(2000L);
        res.setLocation("all");
        res.setFieldEvaluation("1");
        res.setFieldEvaluation2("1");
        res.setLaboratoryEvaluation("1");
        res.setLaboratoryEvaluation2("1");
        res.setBenefitial("1");
        res.setLeafStayGreen("1");
        res.setPollinationPlan1("1");
        res.setPollinationPlan2("1");
        res.setDecisionSource("1");
        res.setDecisionStrip("1");
        res.setTests1("1");
        res.setTests2("1");
        res.setSiteDiscrepancy("1");
        return res;
    }

    @Override
    public BxDateVo[] selectBxDate(String pedigree) {
        return wphenotypeMapper.selectBxDate(pedigree);
    }

    @Override
    public BxDateVo[] selectAllDate() {
        return wphenotypeMapper.selectAllDate();
    }

    @Override
    public BxDateVo meanDate(BxDateVo[] bxDateVos) {
        BxDateVo bxDateVo = new BxDateVo();
        Date date1 = new Date();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        int y = 0;
        int m = 0;
        int d = 0;
        for (BxDateVo b1: bxDateVos) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(b1.getDateHarvested());
            y+=calendar.get(Calendar.YEAR);
            m+=calendar.get(Calendar.MONTH);
            d+=calendar.get(Calendar.DATE);
        }
        calendar1.set(Calendar.YEAR,y/bxDateVos.length);
        calendar1.set(Calendar.MONTH,m/bxDateVos.length);
        calendar1.set(Calendar.DATE,d/bxDateVos.length);
        Date s = calendar1.getTime();
        bxDateVo.setDateHarvested(s);

        Date date2 = new Date();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        y = 0;
        m = 0;
        d = 0;
        for (BxDateVo b1: bxDateVos) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(b1.getDatePlanted());
            y+=calendar.get(Calendar.YEAR);
            m+=calendar.get(Calendar.MONTH);
            d+=calendar.get(Calendar.DATE);
        }
        calendar2.set(Calendar.YEAR,y/bxDateVos.length);
        calendar2.set(Calendar.MONTH,m/bxDateVos.length);
        calendar2.set(Calendar.DATE,d/bxDateVos.length);
        Date i = calendar2.getTime();
        bxDateVo.setDatePlanted(i);

        Date date3 = new Date();
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(date3);
        y = 0;
        m = 0;
        d = 0;
        for (BxDateVo b1: bxDateVos) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(b1.getDaysToAnther());
            y+=calendar.get(Calendar.YEAR);
            m+=calendar.get(Calendar.MONTH);
            d+=calendar.get(Calendar.DATE);
        }
        calendar3.set(Calendar.YEAR,y/bxDateVos.length);
        calendar3.set(Calendar.MONTH,m/bxDateVos.length);
        calendar3.set(Calendar.DATE,d/bxDateVos.length);
        Date e = calendar3.getTime();
        bxDateVo.setDaysToAnther(e);

        Date date4 = new Date();
        Calendar calendar4 = Calendar.getInstance();
        calendar4.setTime(date4);
        y = 0;
        m = 0;
        d = 0;
        for (BxDateVo b1: bxDateVos) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(b1.getDaysToSilk());
            y+=calendar.get(Calendar.YEAR);
            m+=calendar.get(Calendar.MONTH);
            d+=calendar.get(Calendar.DATE);
        }
        calendar4.set(Calendar.YEAR,y/bxDateVos.length);
        calendar4.set(Calendar.MONTH,m/bxDateVos.length);
        calendar4.set(Calendar.DATE,d/bxDateVos.length);
        Date r = calendar4.getTime();
        bxDateVo.setDaysToSilk(r);

        Date date5 = new Date();
        Calendar calendar5 = Calendar.getInstance();
        calendar5.setTime(date5);
        y = 0;
        m = 0;
        d = 0;
        for (BxDateVo b1: bxDateVos) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(b1.getDaysToSeedling());
            y+=calendar.get(Calendar.YEAR);
            m+=calendar.get(Calendar.MONTH);
            d+=calendar.get(Calendar.DATE);
        }
        calendar5.set(Calendar.YEAR,y/bxDateVos.length);
        calendar5.set(Calendar.MONTH,m/bxDateVos.length);
        calendar5.set(Calendar.DATE,d/bxDateVos.length);
        Date t = calendar5.getTime();
        bxDateVo.setDaysToSeedling(t);

        Date date6 = new Date();
        Calendar calendar6 = Calendar.getInstance();
        calendar6.setTime(date6);
        y = 0;
        m = 0;
        d = 0;
        for (BxDateVo b1: bxDateVos) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(b1.getGrowthPeriod());
            y+=calendar.get(Calendar.YEAR);
            m+=calendar.get(Calendar.MONTH);
            d+=calendar.get(Calendar.DATE);
        }
        calendar6.set(Calendar.YEAR,y/bxDateVos.length);
        calendar6.set(Calendar.MONTH,m/bxDateVos.length);
        calendar6.set(Calendar.DATE,d/bxDateVos.length);
        Date u = calendar6.getTime();
        bxDateVo.setGrowthPeriod(u);

        Date date7 = new Date();
        Calendar calendar7 = Calendar.getInstance();
        calendar6.setTime(date7);
        y = 0;
        m = 0;
        d = 0;
        for (BxDateVo b1: bxDateVos) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(b1.getDaysToMaturity());
            y+=calendar.get(Calendar.YEAR);
            m+=calendar.get(Calendar.MONTH);
            d+=calendar.get(Calendar.DATE);
        }
        calendar7.set(Calendar.YEAR,y/bxDateVos.length);
        calendar7.set(Calendar.MONTH,m/bxDateVos.length);
        calendar7.set(Calendar.DATE,d/bxDateVos.length);
        Date h = calendar7.getTime();
        bxDateVo.setDaysToMaturity(h);

        Date date8 = new Date();
        Calendar calendar8 = Calendar.getInstance();
        calendar6.setTime(date8);
        y = 0;
        m = 0;
        d = 0;
        for (BxDateVo b1: bxDateVos) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(b1.getDaysToTassel());
            y+=calendar.get(Calendar.YEAR);
            m+=calendar.get(Calendar.MONTH);
            d+=calendar.get(Calendar.DATE);
        }
        calendar8.set(Calendar.YEAR,y/bxDateVos.length);
        calendar8.set(Calendar.MONTH,m/bxDateVos.length);
        calendar8.set(Calendar.DATE,d/bxDateVos.length);
        Date l = calendar8.getTime();
        bxDateVo.setDaysToTassel(l);

        return bxDateVo;
    }

    @Override
    public BxRateVo[] selectBxRateByName(String pedigree) {
        return wphenotypeMapper.selectBxRateByName(pedigree);
    }

    @Override
    public BxRateVo[] selectAllRate() {
        return wphenotypeMapper.selectAllRate();
    }

    @Override
    public BxRateVo MeanRate(BxRateVo[] bxRateVos) {
        Long a=0L;
        Long b=0L;
        Long c=0L;
        Long d=0L;
        Long e=0L;
        Long f=0L;
        Long g=0L;
        Long h=0L;
        for (BxRateVo rate :
                bxRateVos) {
            a+= rate.getUstilagoMaydis();
            b+= rate.getMaizeBorer();
            c+= rate.getLeafSpotDisease();
            d+= rate.getMaizeEarRot();
            e+= rate.getMaizeSheathBlight();
            f+= rate.getSouthernCornRust();
            g+= Long.parseLong(rate.getComprehensiveResistance());
            h+= Long.parseLong(rate.getNorthernLeafBlight());
        }
        a=a/bxRateVos.length;
        b=b/bxRateVos.length;
        c=c/bxRateVos.length;
        d=d/bxRateVos.length;
        e=e/bxRateVos.length;
        f=f/bxRateVos.length;
        g=g/bxRateVos.length;
        h=h/bxRateVos.length;
        String gi = Long.toString(g);
        String hi = Long.toString(h);
        BxRateVo reslut = new BxRateVo(a,d,e,f,c,b,hi,gi);
        return reslut;
    }

    @Override
    public Yield[] selectYieldByName(String pedigree) {
        return wphenotypeMapper.selectYieldByName(pedigree);
    }

    @Override
    public Yield[] selectAllYield() {
        return wphenotypeMapper.selectAllYield();
    }

    @Override
    public Yield MeanYield(Yield[] yields) {
        BigDecimal grainLengthSum = BigDecimal.ZERO;
        BigDecimal grainWidthSum = BigDecimal.ZERO;
        BigDecimal earLengthSum = BigDecimal.ZERO;
        BigDecimal earDiameterSum = BigDecimal.ZERO;
        BigDecimal kernelRowNumberSum = BigDecimal.ZERO;
        BigDecimal kernelNumbersPerRowSum = BigDecimal.ZERO;
        BigDecimal grainWeightSum = BigDecimal.ZERO;
        BigDecimal yieldSum = BigDecimal.ZERO;
        Long kernelNumbersPerEarSum = 0L;
        BigDecimal earKernelWeightSum = BigDecimal.ZERO;
        BigDecimal grainWaterContentSum = BigDecimal.ZERO;
        BigDecimal kernelPercentageSum = BigDecimal.ZERO;

        int numRecords = yields.length;

        for (Yield y : yields) {
            if(y.getGrainLength()!=null)grainLengthSum = grainLengthSum.add(y.getGrainLength());
            if(y.getGrainWidth()!=null)grainWidthSum = grainWidthSum.add(y.getGrainWidth());
            if(y.getEarLength()!=null)earLengthSum = earLengthSum.add(y.getEarLength());
            if(y.getEarDiameter()!=null)earDiameterSum = earDiameterSum.add(y.getEarDiameter());
            if(y.getKernelRowNumber()!=null)kernelRowNumberSum = kernelRowNumberSum.add(y.getKernelRowNumber());
            if(y.getKernelNumbersPerRow()!=null)kernelNumbersPerRowSum = kernelNumbersPerRowSum.add(y.getKernelNumbersPerRow());
            if(y.getGrainWeight()!=null)grainWeightSum = grainWeightSum.add(y.getGrainWeight());
            if(y.getYield()!=null)yieldSum = yieldSum.add(y.getYield());
            if(y.getKernelNumbersPerEar()!=null)kernelNumbersPerEarSum += y.getKernelNumbersPerEar();
            if(y.getEarKernelWeight()!=null)earKernelWeightSum = earKernelWeightSum.add(y.getEarKernelWeight());
            if(y.getGrainWaterContent()!=null)grainWaterContentSum = grainWaterContentSum.add(y.getGrainWaterContent());
            if(y.getKernelPercentage()!=null)kernelPercentageSum =kernelPercentageSum.add(y.getKernelPercentage());
        }
        BigDecimal grainLength = BigDecimal.ZERO;
        BigDecimal grainWidth = BigDecimal.ZERO;
        BigDecimal earLength = BigDecimal.ZERO;
        BigDecimal earDiameter = BigDecimal.ZERO;
        BigDecimal kernelRow = BigDecimal.ZERO;
        BigDecimal kernelNumPer = BigDecimal.ZERO;
        BigDecimal grainWeight = BigDecimal.ZERO;
        BigDecimal yield = BigDecimal.ZERO;
        Long kernelNumPerEar = 0L;
        BigDecimal earKernel = BigDecimal.ZERO;
        BigDecimal grainWater = BigDecimal.ZERO;
        BigDecimal kernelPer = BigDecimal.ZERO;

        if(grainLengthSum!=BigDecimal.ZERO) grainLength = grainLengthSum.divide(BigDecimal.valueOf(numRecords), 2, BigDecimal.ROUND_HALF_UP);
        if(grainWidthSum!=BigDecimal.ZERO)grainWidth = grainWidthSum.divide(BigDecimal.valueOf(numRecords), 2, BigDecimal.ROUND_HALF_UP);
        if(earLengthSum!=BigDecimal.ZERO) earLength = earLengthSum.divide(BigDecimal.valueOf(numRecords), 2, BigDecimal.ROUND_HALF_UP);
        if(earDiameterSum!=BigDecimal.ZERO)earDiameter = earDiameterSum.divide(BigDecimal.valueOf(numRecords), 2, BigDecimal.ROUND_HALF_UP);
        if(kernelRowNumberSum!=BigDecimal.ZERO)kernelRow = kernelRowNumberSum.divide(BigDecimal.valueOf(numRecords), 2, BigDecimal.ROUND_HALF_UP);
        if(kernelNumbersPerRowSum!=BigDecimal.ZERO)kernelNumPer = kernelNumbersPerRowSum.divide(BigDecimal.valueOf(numRecords), 2, BigDecimal.ROUND_HALF_UP);
        if(grainWeightSum!=BigDecimal.ZERO) grainWeight = grainWeightSum.divide(BigDecimal.valueOf(numRecords), 2, BigDecimal.ROUND_HALF_UP);
        if(yieldSum!=BigDecimal.ZERO) yield = yieldSum.divide(BigDecimal.valueOf(numRecords), 2, BigDecimal.ROUND_HALF_UP);
        if(kernelNumPerEar!=0L) kernelNumPerEar = kernelNumbersPerEarSum/numRecords;
        if(earKernelWeightSum!=BigDecimal.ZERO)earKernel = earKernelWeightSum.divide(BigDecimal.valueOf(numRecords), 2, BigDecimal.ROUND_HALF_UP);
        if(grainWaterContentSum!=BigDecimal.ZERO) grainWater = grainWaterContentSum.divide(BigDecimal.valueOf(numRecords), 2, BigDecimal.ROUND_HALF_UP);
         if(kernelPercentageSum!=BigDecimal.ZERO)kernelPer = kernelPercentageSum.divide(BigDecimal.valueOf(numRecords), 2, BigDecimal.ROUND_HALF_UP);

        Yield res = new Yield(grainLength,grainWidth,earLength,earDiameter,kernelRow,kernelNumPer,grainWeight,yield,kernelNumPerEar,earKernel,grainWater,kernelPer);
        return res;
    }


    @Override
    public List<Wphenotype> selectPhenotypeByLocations(List<String> locations) {
        return wphenotypeMapper.selectPhenotypeByLocations(locations);
    }

    @Override
    public List<Map<String,String>> selectTrait(List<String> traits){
        return wphenotypeMapper.selectTrait(traits);
    }


    @Override
    public List<TraitVo> selectTVo() {
        return wphenotypeMapper.selectTVo();
    }

    @Override
    public List<TraitVo> resultTrait(List<TraitVo> traitVos, List<String> strings) {
        TraitVo[] traitVos1 = traitVos.toArray(new TraitVo[traitVos.size()]);
        String[] strings1 = strings.toArray(new String[strings.size()]);
        for(int i=0;i<strings.size();i++){
            traitVos1[i].setTrait(strings1[i]);
        }
        return Arrays.asList(traitVos1);
    }

    @Override
    public List<TraitVo> selectTVoByName(String pedigree, String trait) {
        return wphenotypeMapper.selectTVoByName(pedigree,trait);
    }

    @Override
    public List<String> selectTraitByName(String pedigree, String trait) {
        return wphenotypeMapper.selectTraitByName(pedigree,trait);
    }

    @Override
    public List<String> selectTraitGroup(String trait) {
        return wphenotypeMapper.selectTraitGroup(trait);
    }

    @Override
    public List<GeVo> selectGe(String trait) {
        return wphenotypeMapper.selectGe(trait);
    }

    @Override
    public List<GeVo> resultGeVo(List<GeVo> geVoList, List<String> strings) {
        GeVo[] traitVos1 = geVoList.toArray(new GeVo[geVoList.size()]);
        String[] strings1 = strings.toArray(new String[strings.size()]);
        for(int i=0;i<strings.size();i++){
            traitVos1[i].setTrait(strings1[i]);
        }
        return Arrays.asList(traitVos1);
    }

    @Override
    public List<Map<String, String>> selectTraitsByName(String pedigree, List<String> traits) {
        return wphenotypeMapper.selectTraitsByName(pedigree,traits);
    }

    @Override
    public List<String> selectTraitGroupByName(String pedigree, String trait) {
        return wphenotypeMapper.selectTraitGroupByName(pedigree,trait);
    }

    @Override
    public List<GeVo> selectGeByName(String pedigree, String trait) {
        return wphenotypeMapper.selectGeByName(pedigree,trait);
    }

    @Override
    public List<MorphologicalVo> selectAllMar() {
        return wphenotypeMapper.selectAllMar();
    }

    @Override
    public List<AgronomicalVo> selectAllAgro() {
        return wphenotypeMapper.selectAllAgro();
    }

    @Override
    public List<AbioticStressVo> selectAllAbiotic() {
        return wphenotypeMapper.selectAllAbiotic();
    }

    @Override
    public List<BioticStressVo> selectAllBiotic() {
        return wphenotypeMapper.selectAllBiotic();
    }

    @Override
    public List<Map<String,String>> selectAllYields() {
        return wphenotypeMapper.selectAllYields();
    }

    @Override
    public List<YearMorVo> selectYearMor() {
        return wphenotypeMapper.selectYearMor();
    }

    @Override
    public List<YearAgr> selectYearAgr() {
        return wphenotypeMapper.selectYearAgr();
    }

    @Override
    public List<YearAbiotic> selectYearAbiotic() {
        return wphenotypeMapper.selectYearAbiotic();
    }

    @Override
    public List<YearBiotic> selectYearBiotic() {
        return wphenotypeMapper.selectYearBiotic();
    }

    @Override
    public List<YearYield> selectYearYield() {
        return wphenotypeMapper.selectYearYield();
    }

    @Override
    public int countBx(String traitName) {
        return wphenotypeMapper.countBx(traitName);
    }

    @Override
    public int countData() {
        return wphenotypeMapper.countData();
    }

    @Override
    public List<Map<String, String>> sort(List<Map<String, String>> maps) {
        List<Map<String,String>> adjustMaps = new ArrayList<>();
        for (Map<String, String> map :
                maps) {
            adjustMaps.add(adjust(map));
        }
        return adjustMaps;
    }

    @Override
    public List<String> selectAllpedigree() {
        List<String> names = wphenotypeMapper.selectAllpedigree();
        names.remove("");
        names.remove(null);
        return names;
    }

    private static  Map<String,String> adjust(Map<String,String> map){
        Map<String,String> resMap = new LinkedHashMap<>();
        if(map.containsKey("pedid")){
            resMap.put("pedid",map.get("pedid"));
        }
        if(map.containsKey("pedId")){
            resMap.put("pedId",map.get("pedId"));
        }
        if(map.containsKey("pedigree")){
            resMap.put("pedigree",map.get("pedigree"));
        }
        if(map.containsKey("pedigreeSource1")){
            resMap.put("pedigreeSource1",map.get("pedigreeSource1"));
        }
        if(map.containsKey("pedigreeSource2")){
            resMap.put("pedigreeSource2",map.get("pedigreeSource2"));
        }
        if(map.containsKey("year")){
            resMap.put("year",map.get("year"));
        }
        if(map.containsKey("location")){
            resMap.put("location",map.get("location"));
        }
        for(Map.Entry<String,String> entry: map.entrySet()){
            if(!entry.getKey().equals("pedigree")&&!entry.getKey().equals("pedid")){
                resMap.put(entry.getKey(),entry.getValue());
            }
        }
        return  resMap;
    }

    @Override
    public List<Map<String, String>> findBxServe(List<String> pedigrees, List<Long> years, List<String> locations, List<String> traits) {
        return wphenotypeMapper.findBxServe(pedigrees,years,locations,traits);
    }
}
