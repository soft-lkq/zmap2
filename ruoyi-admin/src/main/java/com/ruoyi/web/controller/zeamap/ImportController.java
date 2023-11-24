package com.ruoyi.web.controller.zeamap;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.zeamap.domain.*;
import com.ruoyi.zeamap.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("zeamap/import")
public class ImportController extends BaseController {
    @Autowired
    private IImportDbxrefService importDbxrefService;
    @Autowired
    private IPopulationService populationService;
    @Autowired
    private IImportAnalysisService iImportAnalysisService;
    @Autowired
    private IImportXotService iImportXotService;
    @Autowired
    private IImportMutableService iImportMutableService;
    @Autowired
    private IImportXotMutableService iImportXotMutableService;
    @Autowired
    private IImportVariantService iImportVariantService;
    @Autowired
    private IImportVariantInfoService iImportVariantInfoService;
    @Autowired
    private IImportAssociationQtlService importAssociationQtlService;
    @Autowired
    private IImportLinkageQtlService iImportLinkageQtlService;
    @Autowired
    private IImportAssociationMarkerService iImportAssociationMarkerService;
    @Autowired
    private IImportLinkageMarkerService iImportLinkageMarkerService;
    @Autowired
    private IImportTissueService iImportTissueService;
    @Autowired
    private IImportFeatureService iImportFeatureService;
    @Autowired
    private IImportExpressionService iImportExpressionService;
    @Autowired
    private IGermplasmService iGermplasmService;
    @Autowired
    private IImportFeaturelocService featurelocService;
    @Autowired
    private IImportCvService cvService;



    //dbxref导入
    @Log(title = "dbxref导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importDbxrefData")
    public AjaxResult importDbxrefData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ImportDbxref> util = new ExcelUtil<>(ImportDbxref.class); // todo
        List<ImportDbxref> importDbxrefList = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
        String message = importDbxrefService.importDbxrefData(importDbxrefList,updateSupport,operName); // todo
        return AjaxResult.success(message);
    }
    @PostMapping("/importDbxrefTemplate")
    public void importDbxrefTemplate(HttpServletResponse response)
    {
        ExcelUtil<ImportDbxref> util = new ExcelUtil<>(ImportDbxref.class); // todo
        util.importTemplateExcel(response, "dbxref表信息");
    }

    @Autowired
    private IImportDbService importdbService;
    //db导入
    @Log(title = "db导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importDbData")
    public AjaxResult importDbData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ImportDb> util = new ExcelUtil<>(ImportDb.class); // todo
        List<ImportDb> Dblist = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
        String message = importdbService.importDbData(Dblist,updateSupport,operName); // todo
        return AjaxResult.success(message);
    }
    @PostMapping("/importDbTemplate")
    public void importDbTemplate(HttpServletResponse response)
    {
        ExcelUtil<Db> util = new ExcelUtil<>(Db.class); // todo
        util.importTemplateExcel(response, "db表信息");
    }

    //population导入
    @Log(title = "population导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importPopulationData")
    public AjaxResult importPopulationData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<Population> util = new ExcelUtil<>(Population.class); // todo
        List<Population> populationList = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
        String message = populationService.importPopulationData(populationList,updateSupport,operName); // todo
        return AjaxResult.success(message);
    }
    @PostMapping("/importPopulationTemplate")
    public void importPopulationTemplate(HttpServletResponse response)
    {
        ExcelUtil<Population> util = new ExcelUtil<>(Population.class); // todo
        util.importTemplateExcel(response, "population表信息");
    }


    //analysis导入
    @Log(title = "analysis导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importAnalysisData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ImportAnalysis> util = new ExcelUtil<>(ImportAnalysis.class); // todo
        List<ImportAnalysis> s = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
                String message = iImportAnalysisService.importAnalysisData(s, updateSupport, operName); // todo
        return AjaxResult.success(message);
    }

    @PostMapping("/importAnalysisTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<ImportAnalysis> util = new ExcelUtil<>(ImportAnalysis.class); // todo
        util.importTemplateExcel(response, "analysis表信息");
    }


    //xot导入
    @Log(title = "xot导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importXotData")
    public AjaxResult importXotData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ImportXot> util = new ExcelUtil<>(ImportXot.class); // todo
        List<ImportXot> s = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
        String message = iImportXotService.importXotData(s, updateSupport, operName); // todo
        return AjaxResult.success(message);
    }

    @PostMapping("/importXotTemplate")
    public void importXotTemplate(HttpServletResponse response)
    {
        ExcelUtil<ImportXot> util = new ExcelUtil<>(ImportXot.class); // todo
        util.importTemplateExcel(response, "xot表信息");
    }


    //mutable导入
    @Log(title = "mutable导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importMutableData")
    public AjaxResult importMutableData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ImportMutable> util = new ExcelUtil<>(ImportMutable.class); // todo
        List<ImportMutable> s = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
        String message = iImportMutableService.importMutableData(s, updateSupport, operName); // todo
        return AjaxResult.success(message);
    }

    @PostMapping("/importMutableTemplate")
    public void importMutableTemplate(HttpServletResponse response)
    {
        ExcelUtil<ImportMutable> util = new ExcelUtil<>(ImportMutable.class); // todo
        util.importTemplateExcel(response, "mutable表信息");
    }

    //xot_mutable导入
    @Log(title = "xot_mutable导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importXotMutableData")
    public AjaxResult importXotMutableData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ImportXotMutable> util = new ExcelUtil<>(ImportXotMutable.class); // todo
        List<ImportXotMutable> s = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
        String message = iImportXotMutableService.importXotMutableData(s,updateSupport,operName); // todo
        return AjaxResult.success(message);
    }

    @PostMapping("/importXotMutableTemplate")
    public void importXotMutableTemplate(HttpServletResponse response)
    {
        ExcelUtil<ImportXotMutable> util = new ExcelUtil<>(ImportXotMutable.class); // todo
        util.importTemplateExcel(response, "xot_mutable表信息");
    }

    @Autowired
    private IImportXotGermplasmService xotGermplasmService;

    //xot_mutable导入
    @Log(title = "xot_germplasm导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importXotGerplasmData")
    public AjaxResult importXotGermplasmData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ImportXotGermplasm> util = new ExcelUtil<>(ImportXotGermplasm.class); // todo
        List<ImportXotGermplasm> s = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
        String message = xotGermplasmService.importXotGermplasmData(s,updateSupport,operName); // todo
        return AjaxResult.success(message);
    }

    @PostMapping("/importXotGermplasmTemplate")
    public void importXotGermplasmTemplate(HttpServletResponse response)
    {
        ExcelUtil<ImportXotGermplasm> util = new ExcelUtil<>(ImportXotGermplasm.class); // todo
        util.importTemplateExcel(response, "xot_germplasm表信息");
    }

    //variant导入
    @Log(title = "variant导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importVariantData")
    public AjaxResult importVariantData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ImportVariant> util = new ExcelUtil<>(ImportVariant.class); // todo
        List<ImportVariant> s = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
        String message = iImportVariantService.importVariantData(s,updateSupport,operName); // todo
        return AjaxResult.success(message);
    }

    @PostMapping("/importVariantTemplate")
    public void importVariantTemplate(HttpServletResponse response)
    {
        ExcelUtil<ImportVariant> util = new ExcelUtil<>(ImportVariant.class); // todo
        util.importTemplateExcel(response, "variant表信息");
    }


    //variantinfo导入
    @Log(title = "variantinfo导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importVariantInfoData")
    public AjaxResult importVariantInfoData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ImportVariantInfo> util = new ExcelUtil<>(ImportVariantInfo.class); // todo
        List<ImportVariantInfo> s = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
        String message = iImportVariantInfoService.importVariantInfoData(s,updateSupport,operName); // todo
        return AjaxResult.success(message);
    }

    @PostMapping("/importVariantInfoTemplate")
    public void importVariantInfoTemplate(HttpServletResponse response)
    {
        ExcelUtil<ImportVariantInfo> util = new ExcelUtil<>(ImportVariantInfo.class); // todo
        util.importTemplateExcel(response, "variantInfo表信息");
    }

    //associationQtl导入
    @Log(title = "associationQtl导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importAssociationQtlData")
    public AjaxResult importAssociationQtlData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ImportAssociationQtl> util = new ExcelUtil<>(ImportAssociationQtl.class); // todo
        List<ImportAssociationQtl> s = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
        String message = importAssociationQtlService.importAssociationQtlData(s,updateSupport,operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importAssociationQtlTemplate")
    public void importAssociationQtlTemplate(HttpServletResponse response)
    {
        ExcelUtil<ImportAssociationQtl> util = new ExcelUtil<>(ImportAssociationQtl.class); // todo
        util.importTemplateExcel(response, "AssociationQtl表信息");
    }

    //linkageQtl导入
    @Log(title = "linkageQtl导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importLinkageQtlData")
    public AjaxResult importLinkageQtlData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ImportLinkageQtl> util = new ExcelUtil<>(ImportLinkageQtl.class); // todo
        List<ImportLinkageQtl> s = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
        String message = iImportLinkageQtlService.importLinkageQtlData(s,updateSupport,operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importLinkageQtlTemplate")
    public void importLinkageQtlTemplate(HttpServletResponse response)
    {
        ExcelUtil<ImportLinkageQtl> util = new ExcelUtil<>(ImportLinkageQtl.class); // todo
        util.importTemplateExcel(response, "linkageQtl表信息");
    }


    //associationMarker导入
    @Log(title = "associationMarker导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importAssociationMarkerData")
    public AjaxResult importAssociationMarkeData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ImportAssociationMarker> util = new ExcelUtil<>(ImportAssociationMarker.class); // todo
        List<ImportAssociationMarker> s = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
        String message = iImportAssociationMarkerService.importAssociationMarkerData(s,updateSupport,operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importAssociationMarkerTemplate")
    public void importAssociationMarkerTemplate(HttpServletResponse response)
    {
        ExcelUtil<ImportAssociationMarker> util = new ExcelUtil<>(ImportAssociationMarker.class); // todo
        util.importTemplateExcel(response, "association_marker表信息");
    }

    //linkageMarker导入
    @Log(title = "linkageMarker导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importLinkageMarkerData")
    public AjaxResult importLinkageMarkerData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ImportLinkageMarker> util = new ExcelUtil<>(ImportLinkageMarker.class); // todo
        List<ImportLinkageMarker> s = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
        String message = iImportLinkageMarkerService.importLinkageMarkerData(s,updateSupport,operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importLinkageMarkerTemplate")
    public void importLinkageMarkerTemplate(HttpServletResponse response)
    {
        ExcelUtil<ImportLinkageMarker> util = new ExcelUtil<>(ImportLinkageMarker.class); // todo
        util.importTemplateExcel(response, "linkageMarker表信息");
    }

    //Tissue导入
    @Log(title = "Tissue导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importTissueData")
    public AjaxResult importTissueData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ImportTissue> util = new ExcelUtil<>(ImportTissue.class); // todo
        List<ImportTissue> s = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
        String message = iImportTissueService.importTissueData(s,updateSupport,operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importTissueTemplate")
    public void importTissueTemplate(HttpServletResponse response)
    {
        ExcelUtil<ImportTissue> util = new ExcelUtil<>(ImportTissue.class); // todo
        util.importTemplateExcel(response, "Tissue表信息");
    }

    //Feature导入
    @Log(title = "Feature导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importFeatureData")
    public AjaxResult importFeatureData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ImportFeature> util = new ExcelUtil<>(ImportFeature.class); // todo
        List<ImportFeature> s = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
        String message = iImportFeatureService.importFeatureData(s,updateSupport,operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importFeatureTemplate")
    public void importFeatureTemplate(HttpServletResponse response)
    {
        ExcelUtil<ImportFeature> util = new ExcelUtil<>(ImportFeature.class); // todo
        util.importTemplateExcel(response, "feature表信息");
    }

    //Expression导入
    @Log(title = "Expression导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importExpressionData")
    public AjaxResult importExpressionData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ImportExpression> util = new ExcelUtil<>(ImportExpression.class); // todo
        List<ImportExpression> s = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
        String message = iImportExpressionService.importExpressionData(s,updateSupport,operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importExpressionTemplate")
    public void importExpressionTemplate(HttpServletResponse response)
    {
        ExcelUtil<ImportExpression> util = new ExcelUtil<>(ImportExpression.class); // todo
        util.importTemplateExcel(response, "expression表信息");
    }

    //Germplasm导入
    @Log(title = "Germplasm导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importGerplasmData")
    public AjaxResult importGerplasmData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<Germplasm> util = new ExcelUtil<>(Germplasm.class); // todo
        List<Germplasm> s = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
        String message = iGermplasmService.importGermplasmData(s,updateSupport,operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importGermplasmTemplate")
    public void importGermplasmTemplate(HttpServletResponse response)
    {
        ExcelUtil<Germplasm> util = new ExcelUtil<>(Germplasm.class); // todo
        util.importTemplateExcel(response, "germplasm表信息");
    }

    //Featureloc导入
    @Log(title = "Feature导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importFeaturelocData")
    public AjaxResult importFeaturelocData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ImportFeatureloc> util = new ExcelUtil<>(ImportFeatureloc.class); // todo
        List<ImportFeatureloc> s = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
        String message = featurelocService.importFeaturelocData(s,updateSupport,operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importFeaturelocTemplate")
    public void importFeaturelocTemplate(HttpServletResponse response)
    {
        ExcelUtil<ImportFeatureloc> util = new ExcelUtil<>(ImportFeatureloc.class); // todo
        util.importTemplateExcel(response, "featureloc表信息");
    }

    //Cv导入
    @Log(title = "Cv导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importCvData")
    public AjaxResult importCvData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ImportCv> util = new ExcelUtil<>(ImportCv.class); // todo
        List<ImportCv> s = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
        String message = cvService.importCvData(s,updateSupport,operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importCvTemplate")
    public void importCvTemplate(HttpServletResponse response)
    {
        ExcelUtil<ImportCv> util = new ExcelUtil<>(ImportCv.class); // todo
        util.importTemplateExcel(response, "cv表信息");
    }

    @Autowired
    private IImportCvtermService cvtermService;
    //Cvterm导入
    @Log(title = "Cvterm导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importCvtermData")
    public AjaxResult importCvtermData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ImportCvterm> util = new ExcelUtil<>(ImportCvterm.class); // todo
        List<ImportCvterm> s = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
        String message = cvtermService.importCvtermData(s,updateSupport,operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importCvtermTemplate")
    public void importCvtermTemplate(HttpServletResponse response)
    {
        ExcelUtil<ImportCvterm> util = new ExcelUtil<>(ImportCvterm.class); // todo
        util.importTemplateExcel(response, "cvterm表信息");
    }

    @Autowired
    private IImportTfbdInfoService tfbdInfoService;

    //Tfbd_info导入
    @Log(title = "Tfbd_info导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importTfbdInfoData")
    public AjaxResult importTfbdInfoData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ImportTfbdInfo> util = new ExcelUtil<>(ImportTfbdInfo.class); // todo
        List<ImportTfbdInfo> s = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
        String message = tfbdInfoService.importTfbdInfoData(s,updateSupport,operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importTfbdInfoTemplate")
    public void importTfbdInfoTemplate(HttpServletResponse response)
    {
        ExcelUtil<ImportTfbdInfo> util = new ExcelUtil<>(ImportTfbdInfo.class); // todo
        util.importTemplateExcel(response, "tfbd_info表信息");
    }

    @Autowired
    private  IImportTfbdTargetService tfbdTargetService;

    //Tfbd_target导入
    @Log(title = "Tfbd_target导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importTfbdTargetData")
    public AjaxResult importTfbdTargetData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ImportTfbdTarget> util = new ExcelUtil<>(ImportTfbdTarget.class); // todo
        List<ImportTfbdTarget> s = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
        String message = tfbdTargetService.importTfbdTargetData(s,updateSupport,operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importTfbdTargetTemplate")
    public void importTfbdTargetTemplate(HttpServletResponse response)
    {
        ExcelUtil<ImportTfbdTarget> util = new ExcelUtil<>(ImportTfbdTarget.class); // todo
        util.importTemplateExcel(response, "tfbd_target表信息");
    }

    @Autowired
    private IImportEnvironmentService environmentService;

    //Environment导入
    @Log(title = "Environment导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importEnvironmentData")
    public AjaxResult importEnvironmentData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ImportEnvironment> util = new ExcelUtil<>(ImportEnvironment.class); // todo
        List<ImportEnvironment> s = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
        String message = environmentService.importEnvironmentData(s,updateSupport,operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importEnvironmentTemplate")
    public void importEnvironmentTemplate(HttpServletResponse response)
    {
        ExcelUtil<ImportEnvironment> util = new ExcelUtil<>(ImportEnvironment.class); // todo
        util.importTemplateExcel(response, "environment表信息");
    }

    @Autowired
    private IImportSubgroupService subgroupService;

    //Subgroup导入
    @Log(title = "Subgroup导入", businessType = BusinessType.IMPORT) // todo
    @PostMapping("/importSubgroupData")
    public AjaxResult importSubgroupData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ImportSubgroup> util = new ExcelUtil<>(ImportSubgroup.class); // todo
        List<ImportSubgroup> s = util.importExcel(file.getInputStream()); // todo
        String operName = getUsername();
        String message = subgroupService.importSubgroupData(s,updateSupport,operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importSubgroupTemplate")
    public void importSubgroupTemplate(HttpServletResponse response)
    {
        ExcelUtil<ImportSubgroup> util = new ExcelUtil<>(ImportSubgroup.class); // todo
        util.importTemplateExcel(response, "subgroup表信息");
    }

}
