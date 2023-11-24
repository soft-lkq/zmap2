package com.ruoyi.zeamap.service.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ruoyi.zeamap.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.PhenotypeMapper;
import com.ruoyi.zeamap.service.IPhenotypeService;

/**
 * PhenotypeService业务层处理
 * 
 * @author wj
 * @date 2023-10-11
 */
@Service
public class PhenotypeServiceImpl implements IPhenotypeService 
{
    @Autowired
    private PhenotypeMapper phenotypeMapper;

    /**
     * 查询Phenotype
     * 
     * @param code Phenotype主键
     * @return Phenotype
     */
    @Override
    public Phenotype selectPhenotypeByCode(Long code)
    {
        return phenotypeMapper.selectPhenotypeByCode(code);
    }

    /**
     * 查询Phenotype列表
     * 
     * @param phenotype Phenotype
     * @return Phenotype
     */
    @Override
    public List<Phenotype> selectPhenotypeList(Phenotype phenotype)
    {
        return phenotypeMapper.selectPhenotypeList(phenotype);
    }

    /**
     * 新增Phenotype
     * 
     * @param phenotype Phenotype
     * @return 结果
     */
    @Override
    public int insertPhenotype(Phenotype phenotype)
    {
        return phenotypeMapper.insertPhenotype(phenotype);
    }

    /**
     * 修改Phenotype
     * 
     * @param phenotype Phenotype
     * @return 结果
     */
    @Override
    public int updatePhenotype(Phenotype phenotype)
    {
        return phenotypeMapper.updatePhenotype(phenotype);
    }

    /**
     * 批量删除Phenotype
     * 
     * @param codes 需要删除的Phenotype主键
     * @return 结果
     */
    @Override
    public int deletePhenotypeByCodes(Long[] codes)
    {
        return phenotypeMapper.deletePhenotypeByCodes(codes);
    }

    /**
     * 删除Phenotype信息
     * 
     * @param code Phenotype主键
     * @return 结果
     */
    @Override
    public int deletePhenotypeByCode(Long code)
    {
        return phenotypeMapper.deletePhenotypeByCode(code);
    }

    @Override
    public List<Phenotype> selectPhenotypeByYear(Long year) {
        return phenotypeMapper.selectPhenotypeByYear(year);
    }

    @Override
    public List<Phenotype> selectPhenotypeByname(String pedigree) {
        return phenotypeMapper.selectPhenotypeByname(pedigree);
    }

    @Override
    public MorphologicalVo[] selectMorphologicalByname(String pedigree) {
        return phenotypeMapper.selectMorphologicalByname(pedigree);
    }

    @Override
    public MorphologicalVo[] selectAllMorphological() {
        return phenotypeMapper.selectAllMorphological();
    }

    @Override
    public MorphologicalVo meanMorphological(MorphologicalVo[] morphologicalVos) {
        MorphologicalVo morphologicalVo =new MorphologicalVo();
        double h = 0;
        for (MorphologicalVo morphologicalVo1 : morphologicalVos) {
            h += morphologicalVo1.getHeight();
        }
        h=h/morphologicalVos.length;
        morphologicalVo.setHeight(h);

        double e=0;
        for (MorphologicalVo morphologicalVo2: morphologicalVos) {
            e += morphologicalVo2.getEarHeight();
        }
        e=e/morphologicalVos.length;
        morphologicalVo.setEarHeight(e);

        double st=0;
        for (MorphologicalVo morphologicalVo3: morphologicalVos) {
            st += morphologicalVo3.getStemDiameter();
        }
        st=st/morphologicalVos.length;
        morphologicalVo.setStemDiameter(st);

        double s=0;;
        for (MorphologicalVo morphologicalVo4: morphologicalVos) {
            s += morphologicalVo4.getSpindleLength();
        }
        s=s/morphologicalVos.length;
        morphologicalVo.setSpindleLength(s);

        double m=0;
        for (MorphologicalVo morphologicalVo5: morphologicalVos) {
            m += morphologicalVo5.getEarHeight();
        }
        m=m/morphologicalVos.length;
        morphologicalVo.setMaleSpikes(m);

        double l1=0;
        for (MorphologicalVo morphologicalVo6: morphologicalVos) {
            l1 += morphologicalVo6.getLeafLength();
        }
        l1=l1/morphologicalVos.length;
        morphologicalVo.setLeafLength(l1);

        double l2=0;
        for (MorphologicalVo morphologicalVo7: morphologicalVos) {
            l2 += morphologicalVo7.getLeafWidth();
        }
        l2=l2/morphologicalVos.length;
        morphologicalVo.setLeafLength(l2);
        return morphologicalVo;
    }

    @Override
    public List<Phenotype> selectPhenotypeByLocation(String location) {
        return phenotypeMapper.selectPhenotypeByLocation(location);
    }

    @Override
    public List<Phenotype> selectAllPhenotype() {
        return phenotypeMapper.selectAllPhenotype();
    }

    @Override
    public AgronomicalVo[] selectAgronomicalByname(String pedigree) {
        return phenotypeMapper.selectAgronomicalByname(pedigree);
    }

    @Override
    public AgronomicalVo[] selectAllAgronomical() {
        return phenotypeMapper.selectAllAgronomical();
    }

    @Override
    public AgronomicalVo meanAgronomicalVo(AgronomicalVo[] agronomicalVos) {
        AgronomicalVo agronomicalVo = new AgronomicalVo();
        double a=0;
        for (AgronomicalVo v1: agronomicalVos) {
            a+=v1.getGrainLength();
        }
        a=a/agronomicalVos.length;
        agronomicalVo.setGrainLength(a);

        double b=0;
        for (AgronomicalVo v1: agronomicalVos) {
            b+=v1.getGrainWeight();
        }
        b=b/agronomicalVos.length;
        agronomicalVo.setGrainWeight(b);

        double c=0;
        for (AgronomicalVo v1: agronomicalVos) {
            c+=v1.getGrainWidth();
        }
        c=c/agronomicalVos.length;
        agronomicalVo.setGrainWidth(c);

        double d=0;
        for (AgronomicalVo v1: agronomicalVos) {
            d+=v1.getSpikeLength();
        }
        d=d/agronomicalVos.length;
        agronomicalVo.setSpikeLength(d);

        double e=0;
        for (AgronomicalVo v1: agronomicalVos) {
            e+=v1.getSpikeWidth();
        }
        e=e/agronomicalVos.length;
        agronomicalVo.setSpikeWidth(e);

        double f=0;
        for (AgronomicalVo v1: agronomicalVos) {
            f+=v1.getRow();
        }
        f=f/agronomicalVos.length;
        agronomicalVo.setRow(f);

        double g=0;
        for (AgronomicalVo v1: agronomicalVos) {
            g+=v1.getKernels();
        }
        g=g/agronomicalVos.length;
        agronomicalVo.setKernels(g);

        double h=0;
        for (AgronomicalVo v1: agronomicalVos) {
            h+=v1.getYield();
        }
        h=h/agronomicalVos.length;
        agronomicalVo.setYield(h);

        double i=0;
        for (AgronomicalVo v1: agronomicalVos) {
            i+=v1.getSeedYield();
        }
        i=i/agronomicalVos.length;
        agronomicalVo.setSeedYield(i);
        return agronomicalVo;
    }

    @Override
    public BxDateVo[] selectBxDate(String pedigree) {
        return phenotypeMapper.selectBxDate(pedigree);
    }

    @Override
    public BxDateVo[] selectAllDate() {
        return phenotypeMapper.selectAllDate();
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
            calendar.setTime(b1.getSilking());
            y+=calendar.get(Calendar.YEAR);
            m+=calendar.get(Calendar.MONTH);
            d+=calendar.get(Calendar.DATE);
        }
        calendar1.set(Calendar.YEAR,y/bxDateVos.length);
        calendar1.set(Calendar.MONTH,m/bxDateVos.length);
        calendar1.set(Calendar.DATE,d/bxDateVos.length);
        Date s = calendar1.getTime();
        bxDateVo.setSilking(s);

        Date date2 = new Date();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        y = 0;
        m = 0;
        d = 0;
        for (BxDateVo b1: bxDateVos) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(b1.getDispersal());
            y+=calendar.get(Calendar.YEAR);
            m+=calendar.get(Calendar.MONTH);
            d+=calendar.get(Calendar.DATE);
        }
        calendar2.set(Calendar.YEAR,y/bxDateVos.length);
        calendar2.set(Calendar.MONTH,m/bxDateVos.length);
        calendar2.set(Calendar.DATE,d/bxDateVos.length);
        Date i = calendar2.getTime();
        bxDateVo.setDispersal(i);

        Date date3 = new Date();
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(date3);
        y = 0;
        m = 0;
        d = 0;
        for (BxDateVo b1: bxDateVos) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(b1.getMature());
            y+=calendar.get(Calendar.YEAR);
            m+=calendar.get(Calendar.MONTH);
            d+=calendar.get(Calendar.DATE);
        }
        calendar3.set(Calendar.YEAR,y/bxDateVos.length);
        calendar3.set(Calendar.MONTH,m/bxDateVos.length);
        calendar3.set(Calendar.DATE,d/bxDateVos.length);
        Date e = calendar3.getTime();
        bxDateVo.setMature(e);
        return bxDateVo;

    }

    @Override
    public BxRateVo[] selectBxRateByName(String pedigree) {
        return phenotypeMapper.selectBxRateByName(pedigree);
    }

    @Override
    public BxRateVo[] selectAllRate() {
        return phenotypeMapper.selectAllRate();
    }

    @Override
    public BxRateVo MeanRate(BxRateVo[] bxRateVos) {
        BxRateVo bxRateVo = new BxRateVo();
        double a=0;
        for (BxRateVo v1: bxRateVos) {
            a+=v1.getRates();
        }
        a=a/bxRateVos.length;
        bxRateVo.setRates(a);

        double b=0;
        for (BxRateVo v2: bxRateVos) {
            b+=v2.getStemrot();
        }
        b=b/bxRateVos.length;
        bxRateVo.setStemrot(b);

        double c=0;
        for (BxRateVo v3: bxRateVos) {
            c+=v3.getRoughdwarf();
        }
        double re=c/bxRateVos.length;
        bxRateVo.setRoughdwarf(re);
        return bxRateVo;
    }

    @Override
    public List<String> selectTrait(String trait) {
        return phenotypeMapper.selectTrait(trait);
    }

    @Override
    public List<TraitVo> selectTVo() {
        return phenotypeMapper.selectTVo();
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
    public List<String> selectTraitGroup(String trait) {
        return phenotypeMapper.selectTraitGroup(trait);
    }

    @Override
    public List<GeVo> selectGe(String trait) {
        return phenotypeMapper.selectGe(trait);
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
    public List<String> selectTraitGroupByName(String pedigree, String trait) {
        return phenotypeMapper.selectTraitGroupByName(pedigree,trait);
    }

    @Override
    public List<GeVo> selectGeByName(String pedigree, String trait) {
        return phenotypeMapper.selectGeByName(pedigree,trait);
    }

    @Override
    public List<TraitVo> selectTVoByName(String pedigree, String trait) {
        return phenotypeMapper.selectTVoByName(pedigree,trait);
    }

    @Override
    public List<String> selectTraitByName(String pedigree, String trait) {
        return phenotypeMapper.selectTraitByName(pedigree,trait);
    }

    @Override
    public List<MorphologicalVo> selectAllMar() {
        return phenotypeMapper.selectAllMar();
    }

    @Override
    public List<YearMorVo> selectYearMor() {
        return phenotypeMapper.selectYearMor();
    }

    @Override
    public int countBx(String traitName) {
        return phenotypeMapper.countBx(traitName);
    }

}
