package com.ruoyi.web.controller.zeamap;

import com.ruoyi.zeamap.domain.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.zeamap.service.IVariantServiceNew;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * variantController
 *
 * @author 温镜蓉
 * @date 2023-05-06
 */
@RestController
@RequestMapping("/system/variant")
public class VariantControllerNew extends BaseController
{
    @Autowired
    private IVariantServiceNew variantService;

    /**
     * 搜索框:直接/模糊查询variant列表的VID并取前20条
     */
    @PreAuthorize("@ss.hasAnyRoles({'common','admin'})")
    @GetMapping("/select")
    public SearchResult select(String VID)
    {
        SearchResult searchResult = new SearchResult();
        searchResult.setData(variantService.select(VID));
        return searchResult;
    }

    /**
     *根据搜索框的VID去viriant表里找对应的chr和position。然后带着这些信息去vcf文件里去找匹配的某行数据
     */
    @PreAuthorize("@ss.hasAnyRoles({'common','admin'})")
    @GetMapping("/PointChart")
    public PointChart PointChart(String VID)
    {
        String chr = variantService.selectChr(VID);
        String posi = variantService.selectPosition(VID);

        List<Phewas> phewasList = new ArrayList<Phewas>();

        try {
            FileReader fr = new FileReader("C:\\Users\\Administrator\\Desktop\\zeamap\\file\\wwj4lkq.gwas.vcf");
            BufferedReader br = new BufferedReader(fr);

            //跳过vcf里的注释
            for (int i = 1; i <= 339; i++) {
                br.readLine();
            }

            //提取trait
            String pheno = br.readLine();
            String[] inpheno = pheno.split("\\s+");
            String[] selectTrait = Arrays.copyOfRange(inpheno, 9, inpheno.length);

            //trait与trait_group的map
            Map<String,String> map = new HashMap<>();
            List<TraitAndGroup> list = variantService.selectTraitAndGroup();
            for (TraitAndGroup traitAndGroup: list) {
                map.put(traitAndGroup.getTrait(),traitAndGroup.getTrait_group());
            }

            //遍历每一行
            String line;
            int adder = 0;
            while ( (line = br.readLine()) != null) {

                String[] inline = line.split("\\s+");

                //判断chr和posi是否相等
                if( inline[0].equals(chr) && inline[1].equals(posi) ) {

                    adder += 1;

                    //提取Ref_allele_freq
                    String selectFreq = inline[7];
                    String[] inSelectFreq = selectFreq.split(";");
                    String freq = inSelectFreq[10].split("=")[1];

                    //提取log_pvalue
                    String[] selectLp = Arrays.copyOfRange(inline, 9, inline.length);
                    for (int i = 0; i < selectLp.length; i++) {
                        Phewas phewas = new Phewas();
                        String lp = selectLp[i].split(":")[1];

                        String trait = selectTrait[i];
                        String group = map.get(trait);

                        //赋值
                        phewas.setChromosome(chr);
                        phewas.setId(adder);
                        phewas.setLog_pvalue(lp);
                        phewas.setPosition(posi);
                        phewas.setRef_allele(inline[3]);
                        phewas.setRef_allele_freq(freq);
                        phewas.setViriant(VID);
                        phewas.setTrait(trait);
                        phewas.setTrait_label(trait);
                        phewas.setTrait_group(group);

                        //存入list
                        phewasList.add(phewas);
                    }

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        PointChart pointChart = new PointChart();
        PhePosi phePosi = new PhePosi();
        phePosi.setPosition(posi);
        phePosi.setPhewas(phewasList);
        pointChart.setData(phePosi);
        return pointChart;
    }

    /**
     * 查询gene及与其直接关联，间接关联的gene
     */
    @PreAuthorize("@ss.hasAnyRoles({'common','admin'})")
    @GetMapping("/gene")
    public GeneResult gene(GeneCriteria geneCriteria)
    {
        List<Gene> genes = variantService.selectGenes(geneCriteria);
        GeneResult geneResult = new GeneResult();
        geneResult.setGenes(genes);
        return geneResult;
    }

}
