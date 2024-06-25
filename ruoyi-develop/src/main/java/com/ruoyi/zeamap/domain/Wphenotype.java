package com.ruoyi.zeamap.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 表型对象 phenotype
 * 
 * @author ruoyi
 * @date 2024-03-19
 */
public class Wphenotype extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 表包含的列 */
    @Excel(name = "表包含的列")
    private String colDescription;

    /** 表名称 */
    @Excel(name = "表名称")
    private String bookName;

    /** 表所属项目 */
    @Excel(name = "表所属项目")
    private String project;

    /** 年份 */
    @Excel(name = "年份")
    private Long year;

    /** 试验地点 */
    @Excel(name = "试验地点")
    private String location;

    /** 序号 */
    @Excel(name = "序号")
    private Long seq;

    /** 区号 */
    @Excel(name = "区号")
    private Long plotNumber;

    /** 区号文件名 */
    @Excel(name = "区号文件名")
    private String plotNumberName;

    /** 系谱内部码 */
    private Long pedid;

    /** 系谱 */
    @Excel(name = "系谱")
    private String pedigree;

    /** 系谱别名 */
    @Excel(name = "系谱别名")
    private String pedigree2;

    /** 来源1 */
    @Excel(name = "来源1")
    private String pedigreeSource1;

    /** 来源2 */
    @Excel(name = "来源2")
    private String pedigreeSource2;

    /** 母本系谱内部码 */
    @Excel(name = "母本系谱内部码")
    private Long femalePedid;

    /** 母本区号 */
    @Excel(name = "母本区号")
    private String femalePlot;

    /** 母本系谱名 */
    @Excel(name = "母本系谱名")
    private String femalePedigree;

    /** 父本系谱内部码 */
    @Excel(name = "父本系谱内部码")
    private Long malePedid;

    /** 父本区号 */
    @Excel(name = "父本区号")
    private String malePlot;

    /** 父本系谱名 */
    @Excel(name = "父本系谱名")
    private String malePedigree;

    /** 重复号 */
    @Excel(name = "重复号")
    private Long repNumber;

    /** 所属种质类群1 */
    @Excel(name = "所属种质类群1")
    private String population;

    /** 密度 */
    @Excel(name = "密度")
    private BigDecimal density;

    /** 行长 */
    @Excel(name = "行长")
    private Long rowLength;

    /** 行数 */
    @Excel(name = "行数")
    private Long rowNumber;

    /** 播种方式 */
    @Excel(name = "播种方式")
    private String seedingMethod;

    /** 种子量 */
    @Excel(name = "种子量")
    private Long quantity;

    /** 机播编号 */
    @Excel(name = "机播编号")
    private Long planterSowNumber;

    /** 决定 */
    @Excel(name = "决定")
    private String decisionNursery;

    /** 种质状态 */
    @Excel(name = "种质状态")
    private String inventoryState;

    /** 收获数量 */
    @Excel(name = "收获数量")
    private Long harvestNumber;

    /** 系谱世代 */
    @Excel(name = "系谱世代")
    private String generations;

    /** 种质状态（是否在用） */
    @Excel(name = "种质状态", readConverterExp = "是=否在用")
    private String invertoryState;

    /** 预览错误信息 */
    @Excel(name = "预览错误信息")
    private String previewErrorMessage;

    /** 系谱资源号码 */
    @Excel(name = "系谱资源号码")
    private Long sourceId;

    /** 穗上叶长 */
    @Excel(name = "穗上叶长")
    private BigDecimal leafLength;

    /** 穗上叶宽 */
    @Excel(name = "穗上叶宽")
    private BigDecimal leafWidth;

    /** 株高 */
    @Excel(name = "株高")
    private BigDecimal plantHeight;

    /** 穗位 */
    @Excel(name = "穗位")
    private BigDecimal earHeight;

    /** 雄穗最上面节间长度 */
    @Excel(name = "雄穗最上面节间长度")
    private BigDecimal tasselLengthTop;

    /** 雄一级侧枝数目 */
    @Excel(name = "雄一级侧枝数目")
    private BigDecimal tasselBranchNumber1;

    /** 果穗表现 */
    @Excel(name = "果穗表现")
    private String expression;

    /** 雄穗分枝数 */
    @Excel(name = "雄穗分枝数")
    private BigDecimal tasselBranchNumber;

    /** 倒伏倒折率之和 */
    @Excel(name = "倒伏倒折率之和")
    private BigDecimal rates;

    /** 穗上叶片数 */
    @Excel(name = "穗上叶片数")
    private Long leafNumberAboveEar;

    /** 苗势 */
    @Excel(name = "苗势")
    private String seedlingPotential;

    /** 雄穗倒数第二侧枝长度 */
    @Excel(name = "雄穗倒数第二侧枝长度")
    private BigDecimal tasselLength2;

    /** 雄穗倒数第二侧枝姿势 */
    @Excel(name = "雄穗倒数第二侧枝姿势")
    private BigDecimal tasselPosture2;

    /** 雄穗主轴与倒数第二侧枝夹角 */
    @Excel(name = "雄穗主轴与倒数第二侧枝夹角")
    private BigDecimal tasselAngle2;

    /** 雄穗最低位侧枝以上主轴长度 */
    @Excel(name = "雄穗最低位侧枝以上主轴长度")
    private BigDecimal tasselLength3;

    /** 雄穗最高位侧枝以上主轴长度 */
    @Excel(name = "雄穗最高位侧枝以上主轴长度")
    private BigDecimal tasselLength4;

    /** 雄穗小穗密度 */
    @Excel(name = "雄穗小穗密度")
    private BigDecimal tasselDensity;

    /** 雄穗鲜重 */
    @Excel(name = "雄穗鲜重")
    private BigDecimal tasselWeight1;

    /** 雄穗干重 */
    @Excel(name = "雄穗干重")
    private BigDecimal tasselWeight2;

    /** 穗小花数 */
    @Excel(name = "穗小花数")
    private Long tasselFloretNumber;

    /** 花粉量 */
    @Excel(name = "花粉量")
    private String pollenQuantity;

    /** 根分布 */
    @Excel(name = "根分布")
    private String rootDistribution;

    /** 根层 */
    @Excel(name = "根层")
    private String rootLayer;

    /** 根粗细 */
    @Excel(name = "根粗细")
    private String rootThickness;

    /** 根夹角 */
    @Excel(name = "根夹角")
    private String rootAngle;

    /** 母根分布 */
    @Excel(name = "母根分布")
    private String femaleRootDistribution;

    /** 父根分布 */
    @Excel(name = "父根分布")
    private String maleRootDistribution;

    /** 第一叶顶端形状 */
    @Excel(name = "第一叶顶端形状")
    private String leafShape1;

    /** 顶叶叶姿 */
    @Excel(name = "顶叶叶姿")
    private String leafPosture1;

    /** 上位穗上叶与茎秆夹角 */
    @Excel(name = "上位穗上叶与茎秆夹角")
    private String leafAngle;

    /** 上位穗上叶姿态 */
    @Excel(name = "上位穗上叶姿态")
    private String leafPosture2;

    /** 成株叶片数 */
    @Excel(name = "成株叶片数")
    private Long leafNumber1;

    /** 茎粗 */
    @Excel(name = "茎粗")
    private BigDecimal stemDiameter;

    /** 果穗着生姿态 */
    @Excel(name = "果穗着生姿态")
    private String earBearingPosture;

    /** 苞叶层数 */
    @Excel(name = "苞叶层数")
    private Long huskTier;

    /** 苞叶总厚度 */
    @Excel(name = "苞叶总厚度")
    private BigDecimal huskThickness1;

    /** 苞叶总数 */
    @Excel(name = "苞叶总数")
    private Long huskTierAll;

    /** 苞叶厚度 */
    @Excel(name = "苞叶厚度")
    private BigDecimal huskThickness2;

    /** 花丝花青甙显色 */
    @Excel(name = "花丝花青甙显色")
    private String silkColor;

    /** 花药花青甙显色 */
    @Excel(name = "花药花青甙显色")
    private String antherColor;

    /** 茎支持根花青甙显色 */
    @Excel(name = "茎支持根花青甙显色")
    private String stemRootColor;

    /** 穗轴颜色 */
    @Excel(name = "穗轴颜色")
    private String rachisColor;

    /** 第一叶鞘花青甙显色 */
    @Excel(name = "第一叶鞘花青甙显色")
    private String sheathColor1;

    /** 颖片基部花青甙显色 */
    @Excel(name = "颖片基部花青甙显色")
    private String glumeColor;

    /** 幼苗叶色 */
    @Excel(name = "幼苗叶色")
    private String leafColor1;

    /** 籽粒背面颜色 */
    @Excel(name = "籽粒背面颜色")
    private String grainColor2;

    /** 籽粒颜色 */
    @Excel(name = "籽粒颜色")
    private String grainColor;

    /** 上位穗上叶鞘花青甙显色 */
    @Excel(name = "上位穗上叶鞘花青甙显色")
    private String sheathColor2;

    /** 上位穗上叶叶色 */
    @Excel(name = "上位穗上叶叶色")
    private String leafColor2;

    /** 田评 */
    @Excel(name = "田评")
    private String fieldEvaluation;

    /** 田评2 */
    @Excel(name = "田评2")
    private String fieldEvaluation2;

    /** 室评 */
    @Excel(name = "室评")
    private String laboratoryEvaluation;

    /** 室评2 */
    @Excel(name = "室评2")
    private String laboratoryEvaluation2;

    /** 沾光 */
    @Excel(name = "沾光")
    private String benefitial;

    /** 空杆数 */
    @Excel(name = "空杆数")
    private Long emptyStalkNumber;

    /** 入选株数 */
    @Excel(name = "入选株数")
    private Long selectedPlantNumber;

    /** 株数 */
    @Excel(name = "株数")
    private Long plantNumber;

    /** 保绿度 */
    @Excel(name = "保绿度")
    private String leafStayGreen;

    /** 授粉计划1 */
    @Excel(name = "授粉计划1")
    private String pollinationPlan1;

    /** 授粉计划2 */
    @Excel(name = "授粉计划2")
    private String pollinationPlan2;

    /** 双穗数 */
    @Excel(name = "双穗数")
    private Long doubleEarNumber;

    /** 翌年处理意见 */
    @Excel(name = "翌年处理意见")
    private String decisionStrip;

    /** 决策来源 */
    @Excel(name = "决策来源")
    private String decisionSource;

    /** 位点差 */
    @Excel(name = "位点差")
    private String siteDiscrepancy;

    /** 测试种1 */
    @Excel(name = "测试种1")
    private String tests1;

    /** 测试种2 */
    @Excel(name = "测试种2")
    private String tests2;

    /** 抽雄期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "抽雄期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date daysToTassel;

    /** 出苗期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出苗期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date daysToSeedling;

    /** 成熟期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "成熟期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date daysToMaturity;

    /** 播种期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "播种期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date datePlanted;

    /** 生育期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生育期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date growthPeriod;

    /** 散粉期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "散粉期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date daysToAnther;

    /** 吐丝期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "吐丝期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date daysToSilk;

    /** 收获日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收获日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dateHarvested;

    /** 散粉期（补） */
    @Excel(name = "散粉期", readConverterExp = "补=")
    private Date daysToAnther2;

    /** 吐丝期（补） */
    @Excel(name = "吐丝期", readConverterExp = "补=")
    private Date daysToSilk2;

    /** 散粉吐丝间隔 */
    @Excel(name = "散粉吐丝间隔")
    private Long antherTasselInterval;

    /** 籽粒长 */
    @Excel(name = "籽粒长")
    private BigDecimal grainLength;

    /** 粒长标准差 */
    @Excel(name = "粒长标准差")
    private BigDecimal grainLengthSd;

    /** 籽粒宽 */
    @Excel(name = "籽粒宽")
    private BigDecimal grainWidth;

    /** 粒宽标准差 */
    @Excel(name = "粒宽标准差")
    private BigDecimal grainWidthSd;

    /** 穗长 */
    @Excel(name = "穗长")
    private BigDecimal earLength;

    /** 穗宽 */
    @Excel(name = "穗宽")
    private BigDecimal earDiameter;

    /** 穗数 */
    @Excel(name = "穗数")
    private Long earNumber;

    /** 穗行数 */
    @Excel(name = "穗行数")
    private BigDecimal kernelRowNumber;

    /** 行粒数 */
    @Excel(name = "行粒数")
    private BigDecimal kernelNumbersPerRow;

    /** 粒形 */
    @Excel(name = "粒形")
    private String grainShape;

    /** 粒型 */
    @Excel(name = "粒型")
    private String grainType;

    /** 百粒重 */
    @Excel(name = "百粒重")
    private BigDecimal grainWeight;

    /** 小区标准产量 */
    @Excel(name = "小区标准产量")
    private BigDecimal yield;

    /** 穗形 */
    @Excel(name = "穗形")
    private String earShape;

    /** 穗柄长度 */
    @Excel(name = "穗柄长度")
    private BigDecimal earStalkLength;

    /** 穗干重 */
    @Excel(name = "穗干重")
    private BigDecimal earDryWeight;

    /** 穗粒干重 */
    @Excel(name = "穗粒干重")
    private BigDecimal kernelDryWeight;

    /** 穗粒湿重 */
    @Excel(name = "穗粒湿重")
    private BigDecimal kernelWetWeight;

    /** 穗粒数 */
    @Excel(name = "穗粒数")
    private Long kernelNumbersPerEar;

    /** 穗粒重 */
    @Excel(name = "穗粒重")
    private BigDecimal earKernelWeight;

    /** 穗湿重 */
    @Excel(name = "穗湿重")
    private BigDecimal earWetWeight;

    /** 单穗重 */
    @Excel(name = "单穗重")
    private BigDecimal earWeight;

    /** 籽粒长宽比 */
    @Excel(name = "籽粒长宽比")
    private BigDecimal kernelLengthWidthRatio;

    /** 籽粒含水量 */
    @Excel(name = "籽粒含水量")
    private BigDecimal grainWaterContent;

    /** 出籽率 */
    @Excel(name = "出籽率")
    private BigDecimal kernelPercentage;

    /** 容重 */
    @Excel(name = "容重")
    private BigDecimal volumeWeight;

    /** 结实性 */
    @Excel(name = "结实性")
    private String fecundity;

    /** 比对照1±% */
    @Excel(name = "比对照1±%")
    private String ck1;

    /** 比对照2 */
    @Excel(name = "比对照2")
    private String ck2;

    /** 比对照3 */
    @Excel(name = "比对照3")
    private String ck3;

    /** 比对照4 */
    @Excel(name = "比对照4")
    private String ck4;

    /** 比对照5 */
    @Excel(name = "比对照5")
    private String ck5;

    /** 比对照6 */
    @Excel(name = "比对照6")
    private String ck6;

    /** 生物产量 */
    @Excel(name = "生物产量")
    private BigDecimal biomass;

    /** 粒直径 */
    @Excel(name = "粒直径")
    private BigDecimal grainDiameter;

    /** 秃尖长 */
    @Excel(name = "秃尖长")
    private BigDecimal barrenEarTip;

    /** 样品重量 */
    @Excel(name = "样品重量")
    private BigDecimal sampleWeight;

    /** 样品称重日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "样品称重日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date sampleWeightDate;

    /** 籽粒红色均值 */
    @Excel(name = "籽粒红色均值")
    private BigDecimal grainRedMeanValue;

    /** 籽粒蓝色均值 */
    @Excel(name = "籽粒蓝色均值")
    private BigDecimal grainBlueMeanValue;

    /** 籽粒绿色均值 */
    @Excel(name = "籽粒绿色均值")
    private BigDecimal grainGreenMeanValue;

    /** 籽粒面积比 */
    @Excel(name = "籽粒面积比")
    private BigDecimal grainAreaRatio;

    /** 籽粒面积标准差 */
    @Excel(name = "籽粒面积标准差")
    private BigDecimal grainAreaSd;

    /** 籽粒面积均值 */
    @Excel(name = "籽粒面积均值")
    private BigDecimal grainAreaMeanValue;

    /** 籽粒圆度均值 */
    @Excel(name = "籽粒圆度均值")
    private BigDecimal grainMeanRoundness;

    /** 籽粒周长标准差 */
    @Excel(name = "籽粒周长标准差")
    private BigDecimal grainMeanCircumferenceSd;

    /** 籽粒周长均值 */
    @Excel(name = "籽粒周长均值")
    private BigDecimal grainMeanCircumference;

    /** 籽粒总面积 */
    @Excel(name = "籽粒总面积")
    private BigDecimal totalKernelArea;

    /** 对照1产量 */
    @Excel(name = "对照1产量")
    private String ck1Yield;

    /** 对照2产量 */
    @Excel(name = "对照2产量")
    private String ck2Yield;

    /** 对照3产量 */
    @Excel(name = "对照3产量")
    private String ck3Yield;

    /** 穗轴干重 */
    @Excel(name = "穗轴干重")
    private BigDecimal cobDryWeight;

    /** 穗轴湿重 */
    @Excel(name = "穗轴湿重")
    private BigDecimal cobWetWeight;

    /** 穗轴粗 */
    @Excel(name = "穗轴粗")
    private BigDecimal cobDiameter;

    /** 籽粒成熟度 */
    @Excel(name = "籽粒成熟度")
    private String rm;

    /** 粒厚 */
    @Excel(name = "粒厚")
    private BigDecimal grainThickness;

    /** 粒品质 */
    @Excel(name = "粒品质")
    private BigDecimal grainQuality;

    /** 名次 */
    @Excel(name = "名次")
    private String rank;

    /** 皮的厚薄 */
    @Excel(name = "皮的厚薄")
    private Long seedcaseThickness;

    /** 气味 */
    @Excel(name = "气味")
    private Long scent;

    /** 柔嫩度 */
    @Excel(name = "柔嫩度")
    private Long tenderness;

    /** 蒸煮总分 */
    @Excel(name = "蒸煮总分")
    private Long cookingScore;

    /** 甜度 */
    @Excel(name = "甜度")
    private Long sweetness;

    /** 风味 */
    @Excel(name = "风味")
    private String flavor;

    /** 鲜穗等级划分 */
    @Excel(name = "鲜穗等级划分")
    private String freshEarLevel;

    /** 鲜穗产量 */
    @Excel(name = "鲜穗产量")
    private Long freshEarYield;

    /** 穗匀度 */
    @Excel(name = "穗匀度")
    private String earEvenness;

    /** 黑粉 */
    @Excel(name = "黑粉")
    private Long ustilagoMaydis;

    /** 穗腐病 */
    @Excel(name = "穗腐病")
    private Long maizeEarRot;

    /** 纹枯病(级) */
    @Excel(name = "纹枯病(级)")
    private Long maizeSheathBlight;

    /** 锈病 */
    @Excel(name = "锈病")
    private Long southernCornRust;

    /** 叶斑病(级) */
    @Excel(name = "叶斑病(级)")
    private Long leafSpotDisease;

    /** 玉米螟 */
    @Excel(name = "玉米螟")
    private Long maizeBorer;

    /** 茎腐病 */
    @Excel(name = "茎腐病")
    private String maizeStalkRot;

    /** 粗缩 */
    @Excel(name = "粗缩")
    private String maizeRoughDwarfDisease;

    /** 锈病txt */
    @Excel(name = "锈病txt")
    private String southernCornRustTxt;

    /** 大斑病txt */
    @Excel(name = "大斑病txt")
    private String northernLeafBlight;

    /** 矮花叶病 */
    @Excel(name = "矮花叶病")
    private String maizeDwarfMosaicDisease;

    /** 白化病 */
    @Excel(name = "白化病")
    private String maizeAlbinism;

    /** 褐斑病 */
    @Excel(name = "褐斑病")
    private String physodermaMaydis;

    /** 灰斑病 */
    @Excel(name = "灰斑病")
    private String grayLeafSpot;

    /** 粒腐病 */
    @Excel(name = "粒腐病")
    private String earKernelRot;

    /** 小斑病 */
    @Excel(name = "小斑病")
    private String southernLeafBlight;

    /** 禾谷茎腐（%） */
    @Excel(name = "禾谷茎腐", readConverterExp = "%=")
    private String graminearumStalkRot;

    /** 腐霉茎腐（%） */
    @Excel(name = "腐霉茎腐", readConverterExp = "%=")
    private String pythiumStalkRot;

    /** 禾谷穗腐（级） */
    @Excel(name = "禾谷穗腐", readConverterExp = "级=")
    private String fGraminearum;

    /** 拟轮枝穗腐（级） */
    @Excel(name = "拟轮枝穗腐", readConverterExp = "级=")
    private String fVerticillioides;

    /** 蚜虫 */
    @Excel(name = "蚜虫")
    private String aphis;

    /** 抗虫性 */
    @Excel(name = "抗虫性")
    private String borerResistance;

    /** 接种处理 */
    @Excel(name = "接种处理")
    private String treatmentsApplied;

    /** 抗性性状1 */
    @Excel(name = "抗性性状1")
    private String resistanceCharacters1;

    /** 抗性性状2 */
    @Excel(name = "抗性性状2")
    private String resistanceCharacters2;

    /** 抗性性状3 */
    @Excel(name = "抗性性状3")
    private String resistanceCharacters3;

    /** 综合抗性 */
    @Excel(name = "综合抗性")
    private String comprehensiveResistance;

    /** 根倒伏 */
    @Excel(name = "根倒伏")
    private String rootLodging;

    /** 抗倒性 */
    @Excel(name = "抗倒性")
    private String lodgingResistance;

    /** 茎倒伏 */
    @Excel(name = "茎倒伏")
    private BigDecimal stemLodging;

    /** 死苗率1 */
    @Excel(name = "死苗率1")
    private BigDecimal seedlingDeathPercent1;

    /** 死苗数1 */
    @Excel(name = "死苗数1")
    private Long deadSeedlingNumber1;

    /** 死苗率2 */
    @Excel(name = "死苗率2")
    private BigDecimal seedlingDeathPercent2;

    /** 死苗数2 */
    @Excel(name = "死苗数2")
    private Long deadSeedlingNumber2;

    /** 死苗率3 */
    @Excel(name = "死苗率3")
    private BigDecimal seedlingDeathPercent3;

    /** 死苗数3 */
    @Excel(name = "死苗数3")
    private Long deadSeedlingNumber3;

    /** 鉴定药品 */
    @Excel(name = "鉴定药品")
    private String treatName;

    /** 畸形苗率% */
    @Excel(name = "畸形苗率%")
    private BigDecimal deformedSeedlingPercent;

    /** 畸形苗数 */
    @Excel(name = "畸形苗数")
    private Long deformedSeedlingNumber;

    /** 备注1 */
    @Excel(name = "备注1")
    private String comment1;

    /** 备注2 */
    @Excel(name = "备注2")
    private String comment2;

    /** 备注3 */
    @Excel(name = "备注3")
    private String comment3;

    public Wphenotype() {
    }

   

    public Wphenotype(String colDescription, String bookName, String project, Long year, String location, Long seq, Long plotNumber, String plotNumberName, Long pedid, String pedigree, String pedigree2, String pedigreeSource1, String pedigreeSource2, Long femalePedid, String femalePlot, String femalePedigree, Long malePedid, String malePlot, String malePedigree, Long repNumber, String population, BigDecimal density, Long rowLength, Long rowNumber, String seedingMethod, Long quantity, Long planterSowNumber, String decisionNursery, String inventoryState, Long harvestNumber, String generations, String invertoryState, String previewErrorMessage, Long sourceId, BigDecimal leafLength, BigDecimal leafWidth, BigDecimal plantHeight, BigDecimal earHeight, BigDecimal tasselLengthTop, BigDecimal tasselBranchNumber1, String expression, BigDecimal tasselBranchNumber, BigDecimal rates, Long leafNumberAboveEar, String seedlingPotential, BigDecimal tasselLength2, BigDecimal tasselPosture2, BigDecimal tasselAngle2, BigDecimal tasselLength3, BigDecimal tasselLength4, BigDecimal tasselDensity, BigDecimal tasselWeight1, BigDecimal tasselWeight2, Long tasselFloretNumber, String pollenQuantity, String rootDistribution, String rootLayer, String rootThickness, String rootAngle, String femaleRootDistribution, String maleRootDistribution, String leafShape1, String leafPosture1, String leafAngle, String leafPosture2, Long leafNumber1, BigDecimal stemDiameter, String earBearingPosture, Long huskTier, BigDecimal huskThickness1, Long huskTierAll, BigDecimal huskThickness2, String silkColor, String antherColor, String stemRootColor, String rachisColor, String sheathColor1, String glumeColor, String leafColor1, String grainColor2, String grainColor, String sheathColor2, String leafColor2, String fieldEvaluation, String fieldEvaluation2, String laboratoryEvaluation, String laboratoryEvaluation2, String benefitial, Long emptyStalkNumber, Long selectedPlantNumber, Long plantNumber, String leafStayGreen, String pollinationPlan1, String pollinationPlan2, Long doubleEarNumber, String decisionStrip, String decisionSource, String siteDiscrepancy, String tests1, String tests2, Date daysToTassel, Date daysToSeedling, Date daysToMaturity, Date datePlanted, Date growthPeriod, Date daysToAnther, Date daysToSilk, Date dateHarvested, Date daysToAnther2, Date daysToSilk2, Long antherTasselInterval, BigDecimal grainLength, BigDecimal grainLengthSd, BigDecimal grainWidth, BigDecimal grainWidthSd, BigDecimal earLength, BigDecimal earDiameter, Long earNumber, BigDecimal kernelRowNumber, BigDecimal kernelNumbersPerRow, String grainShape, String grainType, BigDecimal grainWeight, BigDecimal yield, String earShape, BigDecimal earStalkLength, BigDecimal earDryWeight, BigDecimal kernelDryWeight, BigDecimal kernelWetWeight, Long kernelNumbersPerEar, BigDecimal earKernelWeight, BigDecimal earWetWeight, BigDecimal earWeight, BigDecimal kernelLengthWidthRatio, BigDecimal grainWaterContent, BigDecimal kernelPercentage, BigDecimal volumeWeight, String fecundity, String ck1, String ck2, String ck3, String ck4, String ck5, String ck6, BigDecimal biomass, BigDecimal grainDiameter, BigDecimal barrenEarTip, BigDecimal sampleWeight, Date sampleWeightDate, BigDecimal grainRedMeanValue, BigDecimal grainBlueMeanValue, BigDecimal grainGreenMeanValue, BigDecimal grainAreaRatio, BigDecimal grainAreaSd, BigDecimal grainAreaMeanValue, BigDecimal grainMeanRoundness, BigDecimal grainMeanCircumferenceSd, BigDecimal grainMeanCircumference, BigDecimal totalKernelArea, String ck1Yield, String ck2Yield, String ck3Yield, BigDecimal cobDryWeight, BigDecimal cobWetWeight, BigDecimal cobDiameter, String rm, BigDecimal grainThickness, BigDecimal grainQuality, String rank, Long seedcaseThickness, Long scent, Long tenderness, Long cookingScore, Long sweetness, String flavor, String freshEarLevel, Long freshEarYield, String earEvenness, Long ustilagoMaydis, Long maizeEarRot, Long maizeSheathBlight, Long southernCornRust, Long leafSpotDisease, Long maizeBorer, String maizeStalkRot, String maizeRoughDwarfDisease, String southernCornRustTxt, String northernLeafBlight, String maizeDwarfMosaicDisease, String maizeAlbinism, String physodermaMaydis, String grayLeafSpot, String earKernelRot, String southernLeafBlight, String graminearumStalkRot, String pythiumStalkRot, String fGraminearum, String fVerticillioides, String aphis, String borerResistance, String treatmentsApplied, String resistanceCharacters1, String resistanceCharacters2, String resistanceCharacters3, String comprehensiveResistance, String rootLodging, String lodgingResistance, BigDecimal stemLodging, BigDecimal seedlingDeathPercent1, Long deadSeedlingNumber1, BigDecimal seedlingDeathPercent2, Long deadSeedlingNumber2, BigDecimal seedlingDeathPercent3, Long deadSeedlingNumber3, String treatName, BigDecimal deformedSeedlingPercent, Long deformedSeedlingNumber, String comment1, String comment2, String comment3) {
        this.colDescription = colDescription;
        this.bookName = bookName;
        this.project = project;
        this.year = year;
        this.location = location;
        this.seq = seq;
        this.plotNumber = plotNumber;
        this.plotNumberName = plotNumberName;
        this.pedid = pedid;
        this.pedigree = pedigree;
        this.pedigree2 = pedigree2;
        this.pedigreeSource1 = pedigreeSource1;
        this.pedigreeSource2 = pedigreeSource2;
        this.femalePedid = femalePedid;
        this.femalePlot = femalePlot;
        this.femalePedigree = femalePedigree;
        this.malePedid = malePedid;
        this.malePlot = malePlot;
        this.malePedigree = malePedigree;
        this.repNumber = repNumber;
        this.population = population;
        this.density = density;
        this.rowLength = rowLength;
        this.rowNumber = rowNumber;
        this.seedingMethod = seedingMethod;
        this.quantity = quantity;
        this.planterSowNumber = planterSowNumber;
        this.decisionNursery = decisionNursery;
        this.inventoryState = inventoryState;
        this.harvestNumber = harvestNumber;
        this.generations = generations;
        this.invertoryState = invertoryState;
        this.previewErrorMessage = previewErrorMessage;
        this.sourceId = sourceId;
        this.leafLength = leafLength;
        this.leafWidth = leafWidth;
        this.plantHeight = plantHeight;
        this.earHeight = earHeight;
        this.tasselLengthTop = tasselLengthTop;
        this.tasselBranchNumber1 = tasselBranchNumber1;
        this.expression = expression;
        this.tasselBranchNumber = tasselBranchNumber;
        this.rates = rates;
        this.leafNumberAboveEar = leafNumberAboveEar;
        this.seedlingPotential = seedlingPotential;
        this.tasselLength2 = tasselLength2;
        this.tasselPosture2 = tasselPosture2;
        this.tasselAngle2 = tasselAngle2;
        this.tasselLength3 = tasselLength3;
        this.tasselLength4 = tasselLength4;
        this.tasselDensity = tasselDensity;
        this.tasselWeight1 = tasselWeight1;
        this.tasselWeight2 = tasselWeight2;
        this.tasselFloretNumber = tasselFloretNumber;
        this.pollenQuantity = pollenQuantity;
        this.rootDistribution = rootDistribution;
        this.rootLayer = rootLayer;
        this.rootThickness = rootThickness;
        this.rootAngle = rootAngle;
        this.femaleRootDistribution = femaleRootDistribution;
        this.maleRootDistribution = maleRootDistribution;
        this.leafShape1 = leafShape1;
        this.leafPosture1 = leafPosture1;
        this.leafAngle = leafAngle;
        this.leafPosture2 = leafPosture2;
        this.leafNumber1 = leafNumber1;
        this.stemDiameter = stemDiameter;
        this.earBearingPosture = earBearingPosture;
        this.huskTier = huskTier;
        this.huskThickness1 = huskThickness1;
        this.huskTierAll = huskTierAll;
        this.huskThickness2 = huskThickness2;
        this.silkColor = silkColor;
        this.antherColor = antherColor;
        this.stemRootColor = stemRootColor;
        this.rachisColor = rachisColor;
        this.sheathColor1 = sheathColor1;
        this.glumeColor = glumeColor;
        this.leafColor1 = leafColor1;
        this.grainColor2 = grainColor2;
        this.grainColor = grainColor;
        this.sheathColor2 = sheathColor2;
        this.leafColor2 = leafColor2;
        this.fieldEvaluation = fieldEvaluation;
        this.fieldEvaluation2 = fieldEvaluation2;
        this.laboratoryEvaluation = laboratoryEvaluation;
        this.laboratoryEvaluation2 = laboratoryEvaluation2;
        this.benefitial = benefitial;
        this.emptyStalkNumber = emptyStalkNumber;
        this.selectedPlantNumber = selectedPlantNumber;
        this.plantNumber = plantNumber;
        this.leafStayGreen = leafStayGreen;
        this.pollinationPlan1 = pollinationPlan1;
        this.pollinationPlan2 = pollinationPlan2;
        this.doubleEarNumber = doubleEarNumber;
        this.decisionStrip = decisionStrip;
        this.decisionSource = decisionSource;
        this.siteDiscrepancy = siteDiscrepancy;
        this.tests1 = tests1;
        this.tests2 = tests2;
        this.daysToTassel = daysToTassel;
        this.daysToSeedling = daysToSeedling;
        this.daysToMaturity = daysToMaturity;
        this.datePlanted = datePlanted;
        this.growthPeriod = growthPeriod;
        this.daysToAnther = daysToAnther;
        this.daysToSilk = daysToSilk;
        this.dateHarvested = dateHarvested;
        this.daysToAnther2 = daysToAnther2;
        this.daysToSilk2 = daysToSilk2;
        this.antherTasselInterval = antherTasselInterval;
        this.grainLength = grainLength;
        this.grainLengthSd = grainLengthSd;
        this.grainWidth = grainWidth;
        this.grainWidthSd = grainWidthSd;
        this.earLength = earLength;
        this.earDiameter = earDiameter;
        this.earNumber = earNumber;
        this.kernelRowNumber = kernelRowNumber;
        this.kernelNumbersPerRow = kernelNumbersPerRow;
        this.grainShape = grainShape;
        this.grainType = grainType;
        this.grainWeight = grainWeight;
        this.yield = yield;
        this.earShape = earShape;
        this.earStalkLength = earStalkLength;
        this.earDryWeight = earDryWeight;
        this.kernelDryWeight = kernelDryWeight;
        this.kernelWetWeight = kernelWetWeight;
        this.kernelNumbersPerEar = kernelNumbersPerEar;
        this.earKernelWeight = earKernelWeight;
        this.earWetWeight = earWetWeight;
        this.earWeight = earWeight;
        this.kernelLengthWidthRatio = kernelLengthWidthRatio;
        this.grainWaterContent = grainWaterContent;
        this.kernelPercentage = kernelPercentage;
        this.volumeWeight = volumeWeight;
        this.fecundity = fecundity;
        this.ck1 = ck1;
        this.ck2 = ck2;
        this.ck3 = ck3;
        this.ck4 = ck4;
        this.ck5 = ck5;
        this.ck6 = ck6;
        this.biomass = biomass;
        this.grainDiameter = grainDiameter;
        this.barrenEarTip = barrenEarTip;
        this.sampleWeight = sampleWeight;
        this.sampleWeightDate = sampleWeightDate;
        this.grainRedMeanValue = grainRedMeanValue;
        this.grainBlueMeanValue = grainBlueMeanValue;
        this.grainGreenMeanValue = grainGreenMeanValue;
        this.grainAreaRatio = grainAreaRatio;
        this.grainAreaSd = grainAreaSd;
        this.grainAreaMeanValue = grainAreaMeanValue;
        this.grainMeanRoundness = grainMeanRoundness;
        this.grainMeanCircumferenceSd = grainMeanCircumferenceSd;
        this.grainMeanCircumference = grainMeanCircumference;
        this.totalKernelArea = totalKernelArea;
        this.ck1Yield = ck1Yield;
        this.ck2Yield = ck2Yield;
        this.ck3Yield = ck3Yield;
        this.cobDryWeight = cobDryWeight;
        this.cobWetWeight = cobWetWeight;
        this.cobDiameter = cobDiameter;
        this.rm = rm;
        this.grainThickness = grainThickness;
        this.grainQuality = grainQuality;
        this.rank = rank;
        this.seedcaseThickness = seedcaseThickness;
        this.scent = scent;
        this.tenderness = tenderness;
        this.cookingScore = cookingScore;
        this.sweetness = sweetness;
        this.flavor = flavor;
        this.freshEarLevel = freshEarLevel;
        this.freshEarYield = freshEarYield;
        this.earEvenness = earEvenness;
        this.ustilagoMaydis = ustilagoMaydis;
        this.maizeEarRot = maizeEarRot;
        this.maizeSheathBlight = maizeSheathBlight;
        this.southernCornRust = southernCornRust;
        this.leafSpotDisease = leafSpotDisease;
        this.maizeBorer = maizeBorer;
        this.maizeStalkRot = maizeStalkRot;
        this.maizeRoughDwarfDisease = maizeRoughDwarfDisease;
        this.southernCornRustTxt = southernCornRustTxt;
        this.northernLeafBlight = northernLeafBlight;
        this.maizeDwarfMosaicDisease = maizeDwarfMosaicDisease;
        this.maizeAlbinism = maizeAlbinism;
        this.physodermaMaydis = physodermaMaydis;
        this.grayLeafSpot = grayLeafSpot;
        this.earKernelRot = earKernelRot;
        this.southernLeafBlight = southernLeafBlight;
        this.graminearumStalkRot = graminearumStalkRot;
        this.pythiumStalkRot = pythiumStalkRot;
        this.fGraminearum = fGraminearum;
        this.fVerticillioides = fVerticillioides;
        this.aphis = aphis;
        this.borerResistance = borerResistance;
        this.treatmentsApplied = treatmentsApplied;
        this.resistanceCharacters1 = resistanceCharacters1;
        this.resistanceCharacters2 = resistanceCharacters2;
        this.resistanceCharacters3 = resistanceCharacters3;
        this.comprehensiveResistance = comprehensiveResistance;
        this.rootLodging = rootLodging;
        this.lodgingResistance = lodgingResistance;
        this.stemLodging = stemLodging;
        this.seedlingDeathPercent1 = seedlingDeathPercent1;
        this.deadSeedlingNumber1 = deadSeedlingNumber1;
        this.seedlingDeathPercent2 = seedlingDeathPercent2;
        this.deadSeedlingNumber2 = deadSeedlingNumber2;
        this.seedlingDeathPercent3 = seedlingDeathPercent3;
        this.deadSeedlingNumber3 = deadSeedlingNumber3;
        this.treatName = treatName;
        this.deformedSeedlingPercent = deformedSeedlingPercent;
        this.deformedSeedlingNumber = deformedSeedlingNumber;
        this.comment1 = comment1;
        this.comment2 = comment2;
        this.comment3 = comment3;
    }

    public String getColDescription() {
        return colDescription;
    }

    public void setColDescription(String colDescription) {
        this.colDescription = colDescription;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public Long getPlotNumber() {
        return plotNumber;
    }

    public void setPlotNumber(Long plotNumber) {
        this.plotNumber = plotNumber;
    }

    public String getPlotNumberName() {
        return plotNumberName;
    }

    public void setPlotNumberName(String plotNumberName) {
        this.plotNumberName = plotNumberName;
    }

    public Long getPedid() {
        return pedid;
    }

    public void setPedid(Long pedid) {
        this.pedid = pedid;
    }

    public String getPedigree() {
        return pedigree;
    }

    public void setPedigree(String pedigree) {
        this.pedigree = pedigree;
    }

    public String getPedigree2() {
        return pedigree2;
    }

    public void setPedigree2(String pedigree2) {
        this.pedigree2 = pedigree2;
    }

    public String getPedigreeSource1() {
        return pedigreeSource1;
    }

    public void setPedigreeSource1(String pedigreeSource1) {
        this.pedigreeSource1 = pedigreeSource1;
    }

    public String getPedigreeSource2() {
        return pedigreeSource2;
    }

    public void setPedigreeSource2(String pedigreeSource2) {
        this.pedigreeSource2 = pedigreeSource2;
    }

    public Long getFemalePedid() {
        return femalePedid;
    }

    public void setFemalePedid(Long femalePedid) {
        this.femalePedid = femalePedid;
    }

    public String getFemalePlot() {
        return femalePlot;
    }

    public void setFemalePlot(String femalePlot) {
        this.femalePlot = femalePlot;
    }

    public String getFemalePedigree() {
        return femalePedigree;
    }

    public void setFemalePedigree(String femalePedigree) {
        this.femalePedigree = femalePedigree;
    }

    public Long getMalePedid() {
        return malePedid;
    }

    public void setMalePedid(Long malePedid) {
        this.malePedid = malePedid;
    }

    public String getMalePlot() {
        return malePlot;
    }

    public void setMalePlot(String malePlot) {
        this.malePlot = malePlot;
    }

    public String getMalePedigree() {
        return malePedigree;
    }

    public void setMalePedigree(String malePedigree) {
        this.malePedigree = malePedigree;
    }

    public Long getRepNumber() {
        return repNumber;
    }

    public void setRepNumber(Long repNumber) {
        this.repNumber = repNumber;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public BigDecimal getDensity() {
        return density;
    }

    public void setDensity(BigDecimal density) {
        this.density = density;
    }

    public Long getRowLength() {
        return rowLength;
    }

    public void setRowLength(Long rowLength) {
        this.rowLength = rowLength;
    }

    public Long getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Long rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getSeedingMethod() {
        return seedingMethod;
    }

    public void setSeedingMethod(String seedingMethod) {
        this.seedingMethod = seedingMethod;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getPlanterSowNumber() {
        return planterSowNumber;
    }

    public void setPlanterSowNumber(Long planterSowNumber) {
        this.planterSowNumber = planterSowNumber;
    }

    public String getDecisionNursery() {
        return decisionNursery;
    }

    public void setDecisionNursery(String decisionNursery) {
        this.decisionNursery = decisionNursery;
    }

    public String getInventoryState() {
        return inventoryState;
    }

    public void setInventoryState(String inventoryState) {
        this.inventoryState = inventoryState;
    }

    public Long getHarvestNumber() {
        return harvestNumber;
    }

    public void setHarvestNumber(Long harvestNumber) {
        this.harvestNumber = harvestNumber;
    }

    public String getGenerations() {
        return generations;
    }

    public void setGenerations(String generations) {
        this.generations = generations;
    }

    public String getInvertoryState() {
        return invertoryState;
    }

    public void setInvertoryState(String invertoryState) {
        this.invertoryState = invertoryState;
    }

    public String getPreviewErrorMessage() {
        return previewErrorMessage;
    }

    public void setPreviewErrorMessage(String previewErrorMessage) {
        this.previewErrorMessage = previewErrorMessage;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public BigDecimal getLeafLength() {
        return leafLength;
    }

    public void setLeafLength(BigDecimal leafLength) {
        this.leafLength = leafLength;
    }

    public BigDecimal getLeafWidth() {
        return leafWidth;
    }

    public void setLeafWidth(BigDecimal leafWidth) {
        this.leafWidth = leafWidth;
    }

    public BigDecimal getPlantHeight() {
        return plantHeight;
    }

    public void setPlantHeight(BigDecimal plantHeight) {
        this.plantHeight = plantHeight;
    }

    public BigDecimal getEarHeight() {
        return earHeight;
    }

    public void setEarHeight(BigDecimal earHeight) {
        this.earHeight = earHeight;
    }

    public BigDecimal getTasselLengthTop() {
        return tasselLengthTop;
    }

    public void setTasselLengthTop(BigDecimal tasselLengthTop) {
        this.tasselLengthTop = tasselLengthTop;
    }

    public BigDecimal getTasselBranchNumber1() {
        return tasselBranchNumber1;
    }

    public void setTasselBranchNumber1(BigDecimal tasselBranchNumber1) {
        this.tasselBranchNumber1 = tasselBranchNumber1;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public BigDecimal getTasselBranchNumber() {
        return tasselBranchNumber;
    }

    public void setTasselBranchNumber(BigDecimal tasselBranchNumber) {
        this.tasselBranchNumber = tasselBranchNumber;
    }

    public BigDecimal getRates() {
        return rates;
    }

    public void setRates(BigDecimal rates) {
        this.rates = rates;
    }

    public Long getLeafNumberAboveEar() {
        return leafNumberAboveEar;
    }

    public void setLeafNumberAboveEar(Long leafNumberAboveEar) {
        this.leafNumberAboveEar = leafNumberAboveEar;
    }

    public String getSeedlingPotential() {
        return seedlingPotential;
    }

    public void setSeedlingPotential(String seedlingPotential) {
        this.seedlingPotential = seedlingPotential;
    }

    public BigDecimal getTasselLength2() {
        return tasselLength2;
    }

    public void setTasselLength2(BigDecimal tasselLength2) {
        this.tasselLength2 = tasselLength2;
    }

    public BigDecimal getTasselPosture2() {
        return tasselPosture2;
    }

    public void setTasselPosture2(BigDecimal tasselPosture2) {
        this.tasselPosture2 = tasselPosture2;
    }

    public BigDecimal getTasselAngle2() {
        return tasselAngle2;
    }

    public void setTasselAngle2(BigDecimal tasselAngle2) {
        this.tasselAngle2 = tasselAngle2;
    }

    public BigDecimal getTasselLength3() {
        return tasselLength3;
    }

    public void setTasselLength3(BigDecimal tasselLength3) {
        this.tasselLength3 = tasselLength3;
    }

    public BigDecimal getTasselLength4() {
        return tasselLength4;
    }

    public void setTasselLength4(BigDecimal tasselLength4) {
        this.tasselLength4 = tasselLength4;
    }

    public BigDecimal getTasselDensity() {
        return tasselDensity;
    }

    public void setTasselDensity(BigDecimal tasselDensity) {
        this.tasselDensity = tasselDensity;
    }

    public BigDecimal getTasselWeight1() {
        return tasselWeight1;
    }

    public void setTasselWeight1(BigDecimal tasselWeight1) {
        this.tasselWeight1 = tasselWeight1;
    }

    public BigDecimal getTasselWeight2() {
        return tasselWeight2;
    }

    public void setTasselWeight2(BigDecimal tasselWeight2) {
        this.tasselWeight2 = tasselWeight2;
    }

    public Long getTasselFloretNumber() {
        return tasselFloretNumber;
    }

    public void setTasselFloretNumber(Long tasselFloretNumber) {
        this.tasselFloretNumber = tasselFloretNumber;
    }

    public String getPollenQuantity() {
        return pollenQuantity;
    }

    public void setPollenQuantity(String pollenQuantity) {
        this.pollenQuantity = pollenQuantity;
    }

    public String getRootDistribution() {
        return rootDistribution;
    }

    public void setRootDistribution(String rootDistribution) {
        this.rootDistribution = rootDistribution;
    }

    public String getRootLayer() {
        return rootLayer;
    }

    public void setRootLayer(String rootLayer) {
        this.rootLayer = rootLayer;
    }

    public String getRootThickness() {
        return rootThickness;
    }

    public void setRootThickness(String rootThickness) {
        this.rootThickness = rootThickness;
    }

    public String getRootAngle() {
        return rootAngle;
    }

    public void setRootAngle(String rootAngle) {
        this.rootAngle = rootAngle;
    }

    public String getFemaleRootDistribution() {
        return femaleRootDistribution;
    }

    public void setFemaleRootDistribution(String femaleRootDistribution) {
        this.femaleRootDistribution = femaleRootDistribution;
    }

    public String getMaleRootDistribution() {
        return maleRootDistribution;
    }

    public void setMaleRootDistribution(String maleRootDistribution) {
        this.maleRootDistribution = maleRootDistribution;
    }

    public String getLeafShape1() {
        return leafShape1;
    }

    public void setLeafShape1(String leafShape1) {
        this.leafShape1 = leafShape1;
    }

    public String getLeafPosture1() {
        return leafPosture1;
    }

    public void setLeafPosture1(String leafPosture1) {
        this.leafPosture1 = leafPosture1;
    }

    public String getLeafAngle() {
        return leafAngle;
    }

    public void setLeafAngle(String leafAngle) {
        this.leafAngle = leafAngle;
    }

    public String getLeafPosture2() {
        return leafPosture2;
    }

    public void setLeafPosture2(String leafPosture2) {
        this.leafPosture2 = leafPosture2;
    }

    public Long getLeafNumber1() {
        return leafNumber1;
    }

    public void setLeafNumber1(Long leafNumber1) {
        this.leafNumber1 = leafNumber1;
    }

    public BigDecimal getStemDiameter() {
        return stemDiameter;
    }

    public void setStemDiameter(BigDecimal stemDiameter) {
        this.stemDiameter = stemDiameter;
    }

    public String getEarBearingPosture() {
        return earBearingPosture;
    }

    public void setEarBearingPosture(String earBearingPosture) {
        this.earBearingPosture = earBearingPosture;
    }

    public Long getHuskTier() {
        return huskTier;
    }

    public void setHuskTier(Long huskTier) {
        this.huskTier = huskTier;
    }

    public BigDecimal getHuskThickness1() {
        return huskThickness1;
    }

    public void setHuskThickness1(BigDecimal huskThickness1) {
        this.huskThickness1 = huskThickness1;
    }

    public Long getHuskTierAll() {
        return huskTierAll;
    }

    public void setHuskTierAll(Long huskTierAll) {
        this.huskTierAll = huskTierAll;
    }

    public BigDecimal getHuskThickness2() {
        return huskThickness2;
    }

    public void setHuskThickness2(BigDecimal huskThickness2) {
        this.huskThickness2 = huskThickness2;
    }

    public String getSilkColor() {
        return silkColor;
    }

    public void setSilkColor(String silkColor) {
        this.silkColor = silkColor;
    }

    public String getAntherColor() {
        return antherColor;
    }

    public void setAntherColor(String antherColor) {
        this.antherColor = antherColor;
    }

    public String getStemRootColor() {
        return stemRootColor;
    }

    public void setStemRootColor(String stemRootColor) {
        this.stemRootColor = stemRootColor;
    }

    public String getRachisColor() {
        return rachisColor;
    }

    public void setRachisColor(String rachisColor) {
        this.rachisColor = rachisColor;
    }

    public String getSheathColor1() {
        return sheathColor1;
    }

    public void setSheathColor1(String sheathColor1) {
        this.sheathColor1 = sheathColor1;
    }

    public String getGlumeColor() {
        return glumeColor;
    }

    public void setGlumeColor(String glumeColor) {
        this.glumeColor = glumeColor;
    }

    public String getLeafColor1() {
        return leafColor1;
    }

    public void setLeafColor1(String leafColor1) {
        this.leafColor1 = leafColor1;
    }

    public String getGrainColor2() {
        return grainColor2;
    }

    public void setGrainColor2(String grainColor2) {
        this.grainColor2 = grainColor2;
    }

    public String getGrainColor() {
        return grainColor;
    }

    public void setGrainColor(String grainColor) {
        this.grainColor = grainColor;
    }

    public String getSheathColor2() {
        return sheathColor2;
    }

    public void setSheathColor2(String sheathColor2) {
        this.sheathColor2 = sheathColor2;
    }

    public String getLeafColor2() {
        return leafColor2;
    }

    public void setLeafColor2(String leafColor2) {
        this.leafColor2 = leafColor2;
    }

    public String getFieldEvaluation() {
        return fieldEvaluation;
    }

    public void setFieldEvaluation(String fieldEvaluation) {
        this.fieldEvaluation = fieldEvaluation;
    }

    public String getFieldEvaluation2() {
        return fieldEvaluation2;
    }

    public void setFieldEvaluation2(String fieldEvaluation2) {
        this.fieldEvaluation2 = fieldEvaluation2;
    }

    public String getLaboratoryEvaluation() {
        return laboratoryEvaluation;
    }

    public void setLaboratoryEvaluation(String laboratoryEvaluation) {
        this.laboratoryEvaluation = laboratoryEvaluation;
    }

    public String getLaboratoryEvaluation2() {
        return laboratoryEvaluation2;
    }

    public void setLaboratoryEvaluation2(String laboratoryEvaluation2) {
        this.laboratoryEvaluation2 = laboratoryEvaluation2;
    }

    public String getBenefitial() {
        return benefitial;
    }

    public void setBenefitial(String benefitial) {
        this.benefitial = benefitial;
    }

    public Long getEmptyStalkNumber() {
        return emptyStalkNumber;
    }

    public void setEmptyStalkNumber(Long emptyStalkNumber) {
        this.emptyStalkNumber = emptyStalkNumber;
    }

    public Long getSelectedPlantNumber() {
        return selectedPlantNumber;
    }

    public void setSelectedPlantNumber(Long selectedPlantNumber) {
        this.selectedPlantNumber = selectedPlantNumber;
    }

    public Long getPlantNumber() {
        return plantNumber;
    }

    public void setPlantNumber(Long plantNumber) {
        this.plantNumber = plantNumber;
    }

    public String getLeafStayGreen() {
        return leafStayGreen;
    }

    public void setLeafStayGreen(String leafStayGreen) {
        this.leafStayGreen = leafStayGreen;
    }

    public String getPollinationPlan1() {
        return pollinationPlan1;
    }

    public void setPollinationPlan1(String pollinationPlan1) {
        this.pollinationPlan1 = pollinationPlan1;
    }

    public String getPollinationPlan2() {
        return pollinationPlan2;
    }

    public void setPollinationPlan2(String pollinationPlan2) {
        this.pollinationPlan2 = pollinationPlan2;
    }

    public Long getDoubleEarNumber() {
        return doubleEarNumber;
    }

    public void setDoubleEarNumber(Long doubleEarNumber) {
        this.doubleEarNumber = doubleEarNumber;
    }

    public String getDecisionStrip() {
        return decisionStrip;
    }

    public void setDecisionStrip(String decisionStrip) {
        this.decisionStrip = decisionStrip;
    }

    public String getDecisionSource() {
        return decisionSource;
    }

    public void setDecisionSource(String decisionSource) {
        this.decisionSource = decisionSource;
    }

    public String getSiteDiscrepancy() {
        return siteDiscrepancy;
    }

    public void setSiteDiscrepancy(String siteDiscrepancy) {
        this.siteDiscrepancy = siteDiscrepancy;
    }

    public String getTests1() {
        return tests1;
    }

    public void setTests1(String tests1) {
        this.tests1 = tests1;
    }

    public String getTests2() {
        return tests2;
    }

    public void setTests2(String tests2) {
        this.tests2 = tests2;
    }

    public Date getDaysToTassel() {
        return daysToTassel;
    }

    public void setDaysToTassel(Date daysToTassel) {
        this.daysToTassel = daysToTassel;
    }

    public Date getDaysToSeedling() {
        return daysToSeedling;
    }

    public void setDaysToSeedling(Date daysToSeedling) {
        this.daysToSeedling = daysToSeedling;
    }

    public Date getDaysToMaturity() {
        return daysToMaturity;
    }

    public void setDaysToMaturity(Date daysToMaturity) {
        this.daysToMaturity = daysToMaturity;
    }

    public Date getDatePlanted() {
        return datePlanted;
    }

    public void setDatePlanted(Date datePlanted) {
        this.datePlanted = datePlanted;
    }

    public Date getGrowthPeriod() {
        return growthPeriod;
    }

    public void setGrowthPeriod(Date growthPeriod) {
        this.growthPeriod = growthPeriod;
    }

    public Date getDaysToAnther() {
        return daysToAnther;
    }

    public void setDaysToAnther(Date daysToAnther) {
        this.daysToAnther = daysToAnther;
    }

    public Date getDaysToSilk() {
        return daysToSilk;
    }

    public void setDaysToSilk(Date daysToSilk) {
        this.daysToSilk = daysToSilk;
    }

    public Date getDateHarvested() {
        return dateHarvested;
    }

    public void setDateHarvested(Date dateHarvested) {
        this.dateHarvested = dateHarvested;
    }

    public Date getDaysToAnther2() {
        return daysToAnther2;
    }

    public void setDaysToAnther2(Date daysToAnther2) {
        this.daysToAnther2 = daysToAnther2;
    }

    public Date getDaysToSilk2() {
        return daysToSilk2;
    }

    public void setDaysToSilk2(Date daysToSilk2) {
        this.daysToSilk2 = daysToSilk2;
    }

    public Long getAntherTasselInterval() {
        return antherTasselInterval;
    }

    public void setAntherTasselInterval(Long antherTasselInterval) {
        this.antherTasselInterval = antherTasselInterval;
    }

    public BigDecimal getGrainLength() {
        return grainLength;
    }

    public void setGrainLength(BigDecimal grainLength) {
        this.grainLength = grainLength;
    }

    public BigDecimal getGrainLengthSd() {
        return grainLengthSd;
    }

    public void setGrainLengthSd(BigDecimal grainLengthSd) {
        this.grainLengthSd = grainLengthSd;
    }

    public BigDecimal getGrainWidth() {
        return grainWidth;
    }

    public void setGrainWidth(BigDecimal grainWidth) {
        this.grainWidth = grainWidth;
    }

    public BigDecimal getGrainWidthSd() {
        return grainWidthSd;
    }

    public void setGrainWidthSd(BigDecimal grainWidthSd) {
        this.grainWidthSd = grainWidthSd;
    }

    public BigDecimal getEarLength() {
        return earLength;
    }

    public void setEarLength(BigDecimal earLength) {
        this.earLength = earLength;
    }

    public BigDecimal getEarDiameter() {
        return earDiameter;
    }

    public void setEarDiameter(BigDecimal earDiameter) {
        this.earDiameter = earDiameter;
    }

    public Long getEarNumber() {
        return earNumber;
    }

    public void setEarNumber(Long earNumber) {
        this.earNumber = earNumber;
    }

    public BigDecimal getKernelRowNumber() {
        return kernelRowNumber;
    }

    public void setKernelRowNumber(BigDecimal kernelRowNumber) {
        this.kernelRowNumber = kernelRowNumber;
    }

    public BigDecimal getKernelNumbersPerRow() {
        return kernelNumbersPerRow;
    }

    public void setKernelNumbersPerRow(BigDecimal kernelNumbersPerRow) {
        this.kernelNumbersPerRow = kernelNumbersPerRow;
    }

    public String getGrainShape() {
        return grainShape;
    }

    public void setGrainShape(String grainShape) {
        this.grainShape = grainShape;
    }

    public String getGrainType() {
        return grainType;
    }

    public void setGrainType(String grainType) {
        this.grainType = grainType;
    }

    public BigDecimal getGrainWeight() {
        return grainWeight;
    }

    public void setGrainWeight(BigDecimal grainWeight) {
        this.grainWeight = grainWeight;
    }

    public BigDecimal getYield() {
        return yield;
    }

    public void setYield(BigDecimal yield) {
        this.yield = yield;
    }

    public String getEarShape() {
        return earShape;
    }

    public void setEarShape(String earShape) {
        this.earShape = earShape;
    }

    public BigDecimal getEarStalkLength() {
        return earStalkLength;
    }

    public void setEarStalkLength(BigDecimal earStalkLength) {
        this.earStalkLength = earStalkLength;
    }

    public BigDecimal getEarDryWeight() {
        return earDryWeight;
    }

    public void setEarDryWeight(BigDecimal earDryWeight) {
        this.earDryWeight = earDryWeight;
    }

    public BigDecimal getKernelDryWeight() {
        return kernelDryWeight;
    }

    public void setKernelDryWeight(BigDecimal kernelDryWeight) {
        this.kernelDryWeight = kernelDryWeight;
    }

    public BigDecimal getKernelWetWeight() {
        return kernelWetWeight;
    }

    public void setKernelWetWeight(BigDecimal kernelWetWeight) {
        this.kernelWetWeight = kernelWetWeight;
    }

    public Long getKernelNumbersPerEar() {
        return kernelNumbersPerEar;
    }

    public void setKernelNumbersPerEar(Long kernelNumbersPerEar) {
        this.kernelNumbersPerEar = kernelNumbersPerEar;
    }

    public BigDecimal getEarKernelWeight() {
        return earKernelWeight;
    }

    public void setEarKernelWeight(BigDecimal earKernelWeight) {
        this.earKernelWeight = earKernelWeight;
    }

    public BigDecimal getEarWetWeight() {
        return earWetWeight;
    }

    public void setEarWetWeight(BigDecimal earWetWeight) {
        this.earWetWeight = earWetWeight;
    }

    public BigDecimal getEarWeight() {
        return earWeight;
    }

    public void setEarWeight(BigDecimal earWeight) {
        this.earWeight = earWeight;
    }

    public BigDecimal getKernelLengthWidthRatio() {
        return kernelLengthWidthRatio;
    }

    public void setKernelLengthWidthRatio(BigDecimal kernelLengthWidthRatio) {
        this.kernelLengthWidthRatio = kernelLengthWidthRatio;
    }

    public BigDecimal getGrainWaterContent() {
        return grainWaterContent;
    }

    public void setGrainWaterContent(BigDecimal grainWaterContent) {
        this.grainWaterContent = grainWaterContent;
    }

    public BigDecimal getKernelPercentage() {
        return kernelPercentage;
    }

    public void setKernelPercentage(BigDecimal kernelPercentage) {
        this.kernelPercentage = kernelPercentage;
    }

    public BigDecimal getVolumeWeight() {
        return volumeWeight;
    }

    public void setVolumeWeight(BigDecimal volumeWeight) {
        this.volumeWeight = volumeWeight;
    }

    public String getFecundity() {
        return fecundity;
    }

    public void setFecundity(String fecundity) {
        this.fecundity = fecundity;
    }

    public String getCk1() {
        return ck1;
    }

    public void setCk1(String ck1) {
        this.ck1 = ck1;
    }

    public String getCk2() {
        return ck2;
    }

    public void setCk2(String ck2) {
        this.ck2 = ck2;
    }

    public String getCk3() {
        return ck3;
    }

    public void setCk3(String ck3) {
        this.ck3 = ck3;
    }

    public String getCk4() {
        return ck4;
    }

    public void setCk4(String ck4) {
        this.ck4 = ck4;
    }

    public String getCk5() {
        return ck5;
    }

    public void setCk5(String ck5) {
        this.ck5 = ck5;
    }

    public String getCk6() {
        return ck6;
    }

    public void setCk6(String ck6) {
        this.ck6 = ck6;
    }

    public BigDecimal getBiomass() {
        return biomass;
    }

    public void setBiomass(BigDecimal biomass) {
        this.biomass = biomass;
    }

    public BigDecimal getGrainDiameter() {
        return grainDiameter;
    }

    public void setGrainDiameter(BigDecimal grainDiameter) {
        this.grainDiameter = grainDiameter;
    }

    public BigDecimal getBarrenEarTip() {
        return barrenEarTip;
    }

    public void setBarrenEarTip(BigDecimal barrenEarTip) {
        this.barrenEarTip = barrenEarTip;
    }

    public BigDecimal getSampleWeight() {
        return sampleWeight;
    }

    public void setSampleWeight(BigDecimal sampleWeight) {
        this.sampleWeight = sampleWeight;
    }

    public Date getSampleWeightDate() {
        return sampleWeightDate;
    }

    public void setSampleWeightDate(Date sampleWeightDate) {
        this.sampleWeightDate = sampleWeightDate;
    }

    public BigDecimal getGrainRedMeanValue() {
        return grainRedMeanValue;
    }

    public void setGrainRedMeanValue(BigDecimal grainRedMeanValue) {
        this.grainRedMeanValue = grainRedMeanValue;
    }

    public BigDecimal getGrainBlueMeanValue() {
        return grainBlueMeanValue;
    }

    public void setGrainBlueMeanValue(BigDecimal grainBlueMeanValue) {
        this.grainBlueMeanValue = grainBlueMeanValue;
    }

    public BigDecimal getGrainGreenMeanValue() {
        return grainGreenMeanValue;
    }

    public void setGrainGreenMeanValue(BigDecimal grainGreenMeanValue) {
        this.grainGreenMeanValue = grainGreenMeanValue;
    }

    public BigDecimal getGrainAreaRatio() {
        return grainAreaRatio;
    }

    public void setGrainAreaRatio(BigDecimal grainAreaRatio) {
        this.grainAreaRatio = grainAreaRatio;
    }

    public BigDecimal getGrainAreaSd() {
        return grainAreaSd;
    }

    public void setGrainAreaSd(BigDecimal grainAreaSd) {
        this.grainAreaSd = grainAreaSd;
    }

    public BigDecimal getGrainAreaMeanValue() {
        return grainAreaMeanValue;
    }

    public void setGrainAreaMeanValue(BigDecimal grainAreaMeanValue) {
        this.grainAreaMeanValue = grainAreaMeanValue;
    }

    public BigDecimal getGrainMeanRoundness() {
        return grainMeanRoundness;
    }

    public void setGrainMeanRoundness(BigDecimal grainMeanRoundness) {
        this.grainMeanRoundness = grainMeanRoundness;
    }

    public BigDecimal getGrainMeanCircumferenceSd() {
        return grainMeanCircumferenceSd;
    }

    public void setGrainMeanCircumferenceSd(BigDecimal grainMeanCircumferenceSd) {
        this.grainMeanCircumferenceSd = grainMeanCircumferenceSd;
    }

    public BigDecimal getGrainMeanCircumference() {
        return grainMeanCircumference;
    }

    public void setGrainMeanCircumference(BigDecimal grainMeanCircumference) {
        this.grainMeanCircumference = grainMeanCircumference;
    }

    public BigDecimal getTotalKernelArea() {
        return totalKernelArea;
    }

    public void setTotalKernelArea(BigDecimal totalKernelArea) {
        this.totalKernelArea = totalKernelArea;
    }

    public String getCk1Yield() {
        return ck1Yield;
    }

    public void setCk1Yield(String ck1Yield) {
        this.ck1Yield = ck1Yield;
    }

    public String getCk2Yield() {
        return ck2Yield;
    }

    public void setCk2Yield(String ck2Yield) {
        this.ck2Yield = ck2Yield;
    }

    public String getCk3Yield() {
        return ck3Yield;
    }

    public void setCk3Yield(String ck3Yield) {
        this.ck3Yield = ck3Yield;
    }

    public BigDecimal getCobDryWeight() {
        return cobDryWeight;
    }

    public void setCobDryWeight(BigDecimal cobDryWeight) {
        this.cobDryWeight = cobDryWeight;
    }

    public BigDecimal getCobWetWeight() {
        return cobWetWeight;
    }

    public void setCobWetWeight(BigDecimal cobWetWeight) {
        this.cobWetWeight = cobWetWeight;
    }

    public BigDecimal getCobDiameter() {
        return cobDiameter;
    }

    public void setCobDiameter(BigDecimal cobDiameter) {
        this.cobDiameter = cobDiameter;
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }

    public BigDecimal getGrainThickness() {
        return grainThickness;
    }

    public void setGrainThickness(BigDecimal grainThickness) {
        this.grainThickness = grainThickness;
    }

    public BigDecimal getGrainQuality() {
        return grainQuality;
    }

    public void setGrainQuality(BigDecimal grainQuality) {
        this.grainQuality = grainQuality;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Long getSeedcaseThickness() {
        return seedcaseThickness;
    }

    public void setSeedcaseThickness(Long seedcaseThickness) {
        this.seedcaseThickness = seedcaseThickness;
    }

    public Long getScent() {
        return scent;
    }

    public void setScent(Long scent) {
        this.scent = scent;
    }

    public Long getTenderness() {
        return tenderness;
    }

    public void setTenderness(Long tenderness) {
        this.tenderness = tenderness;
    }

    public Long getCookingScore() {
        return cookingScore;
    }

    public void setCookingScore(Long cookingScore) {
        this.cookingScore = cookingScore;
    }

    public Long getSweetness() {
        return sweetness;
    }

    public void setSweetness(Long sweetness) {
        this.sweetness = sweetness;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getFreshEarLevel() {
        return freshEarLevel;
    }

    public void setFreshEarLevel(String freshEarLevel) {
        this.freshEarLevel = freshEarLevel;
    }

    public Long getFreshEarYield() {
        return freshEarYield;
    }

    public void setFreshEarYield(Long freshEarYield) {
        this.freshEarYield = freshEarYield;
    }

    public String getEarEvenness() {
        return earEvenness;
    }

    public void setEarEvenness(String earEvenness) {
        this.earEvenness = earEvenness;
    }

    public Long getUstilagoMaydis() {
        return ustilagoMaydis;
    }

    public void setUstilagoMaydis(Long ustilagoMaydis) {
        this.ustilagoMaydis = ustilagoMaydis;
    }

    public Long getMaizeEarRot() {
        return maizeEarRot;
    }

    public void setMaizeEarRot(Long maizeEarRot) {
        this.maizeEarRot = maizeEarRot;
    }

    public Long getMaizeSheathBlight() {
        return maizeSheathBlight;
    }

    public void setMaizeSheathBlight(Long maizeSheathBlight) {
        this.maizeSheathBlight = maizeSheathBlight;
    }

    public Long getSouthernCornRust() {
        return southernCornRust;
    }

    public void setSouthernCornRust(Long southernCornRust) {
        this.southernCornRust = southernCornRust;
    }

    public Long getLeafSpotDisease() {
        return leafSpotDisease;
    }

    public void setLeafSpotDisease(Long leafSpotDisease) {
        this.leafSpotDisease = leafSpotDisease;
    }

    public Long getMaizeBorer() {
        return maizeBorer;
    }

    public void setMaizeBorer(Long maizeBorer) {
        this.maizeBorer = maizeBorer;
    }

    public String getMaizeStalkRot() {
        return maizeStalkRot;
    }

    public void setMaizeStalkRot(String maizeStalkRot) {
        this.maizeStalkRot = maizeStalkRot;
    }

    public String getMaizeRoughDwarfDisease() {
        return maizeRoughDwarfDisease;
    }

    public void setMaizeRoughDwarfDisease(String maizeRoughDwarfDisease) {
        this.maizeRoughDwarfDisease = maizeRoughDwarfDisease;
    }

    public String getSouthernCornRustTxt() {
        return southernCornRustTxt;
    }

    public void setSouthernCornRustTxt(String southernCornRustTxt) {
        this.southernCornRustTxt = southernCornRustTxt;
    }

    public String getNorthernLeafBlight() {
        return northernLeafBlight;
    }

    public void setNorthernLeafBlight(String northernLeafBlight) {
        this.northernLeafBlight = northernLeafBlight;
    }

    public String getMaizeDwarfMosaicDisease() {
        return maizeDwarfMosaicDisease;
    }

    public void setMaizeDwarfMosaicDisease(String maizeDwarfMosaicDisease) {
        this.maizeDwarfMosaicDisease = maizeDwarfMosaicDisease;
    }

    public String getMaizeAlbinism() {
        return maizeAlbinism;
    }

    public void setMaizeAlbinism(String maizeAlbinism) {
        this.maizeAlbinism = maizeAlbinism;
    }

    public String getPhysodermaMaydis() {
        return physodermaMaydis;
    }

    public void setPhysodermaMaydis(String physodermaMaydis) {
        this.physodermaMaydis = physodermaMaydis;
    }

    public String getGrayLeafSpot() {
        return grayLeafSpot;
    }

    public void setGrayLeafSpot(String grayLeafSpot) {
        this.grayLeafSpot = grayLeafSpot;
    }

    public String getEarKernelRot() {
        return earKernelRot;
    }

    public void setEarKernelRot(String earKernelRot) {
        this.earKernelRot = earKernelRot;
    }

    public String getSouthernLeafBlight() {
        return southernLeafBlight;
    }

    public void setSouthernLeafBlight(String southernLeafBlight) {
        this.southernLeafBlight = southernLeafBlight;
    }

    public String getGraminearumStalkRot() {
        return graminearumStalkRot;
    }

    public void setGraminearumStalkRot(String graminearumStalkRot) {
        this.graminearumStalkRot = graminearumStalkRot;
    }

    public String getPythiumStalkRot() {
        return pythiumStalkRot;
    }

    public void setPythiumStalkRot(String pythiumStalkRot) {
        this.pythiumStalkRot = pythiumStalkRot;
    }

    public String getfGraminearum() {
        return fGraminearum;
    }

    public void setfGraminearum(String fGraminearum) {
        this.fGraminearum = fGraminearum;
    }

    public String getfVerticillioides() {
        return fVerticillioides;
    }

    public void setfVerticillioides(String fVerticillioides) {
        this.fVerticillioides = fVerticillioides;
    }

    public String getAphis() {
        return aphis;
    }

    public void setAphis(String aphis) {
        this.aphis = aphis;
    }

    public String getBorerResistance() {
        return borerResistance;
    }

    public void setBorerResistance(String borerResistance) {
        this.borerResistance = borerResistance;
    }

    public String getTreatmentsApplied() {
        return treatmentsApplied;
    }

    public void setTreatmentsApplied(String treatmentsApplied) {
        this.treatmentsApplied = treatmentsApplied;
    }

    public String getResistanceCharacters1() {
        return resistanceCharacters1;
    }

    public void setResistanceCharacters1(String resistanceCharacters1) {
        this.resistanceCharacters1 = resistanceCharacters1;
    }

    public String getResistanceCharacters2() {
        return resistanceCharacters2;
    }

    public void setResistanceCharacters2(String resistanceCharacters2) {
        this.resistanceCharacters2 = resistanceCharacters2;
    }

    public String getResistanceCharacters3() {
        return resistanceCharacters3;
    }

    public void setResistanceCharacters3(String resistanceCharacters3) {
        this.resistanceCharacters3 = resistanceCharacters3;
    }

    public String getComprehensiveResistance() {
        return comprehensiveResistance;
    }

    public void setComprehensiveResistance(String comprehensiveResistance) {
        this.comprehensiveResistance = comprehensiveResistance;
    }

    public String getRootLodging() {
        return rootLodging;
    }

    public void setRootLodging(String rootLodging) {
        this.rootLodging = rootLodging;
    }

    public String getLodgingResistance() {
        return lodgingResistance;
    }

    public void setLodgingResistance(String lodgingResistance) {
        this.lodgingResistance = lodgingResistance;
    }

    public BigDecimal getStemLodging() {
        return stemLodging;
    }

    public void setStemLodging(BigDecimal stemLodging) {
        this.stemLodging = stemLodging;
    }

    public BigDecimal getSeedlingDeathPercent1() {
        return seedlingDeathPercent1;
    }

    public void setSeedlingDeathPercent1(BigDecimal seedlingDeathPercent1) {
        this.seedlingDeathPercent1 = seedlingDeathPercent1;
    }

    public Long getDeadSeedlingNumber1() {
        return deadSeedlingNumber1;
    }

    public void setDeadSeedlingNumber1(Long deadSeedlingNumber1) {
        this.deadSeedlingNumber1 = deadSeedlingNumber1;
    }

    public BigDecimal getSeedlingDeathPercent2() {
        return seedlingDeathPercent2;
    }

    public void setSeedlingDeathPercent2(BigDecimal seedlingDeathPercent2) {
        this.seedlingDeathPercent2 = seedlingDeathPercent2;
    }

    public Long getDeadSeedlingNumber2() {
        return deadSeedlingNumber2;
    }

    public void setDeadSeedlingNumber2(Long deadSeedlingNumber2) {
        this.deadSeedlingNumber2 = deadSeedlingNumber2;
    }

    public BigDecimal getSeedlingDeathPercent3() {
        return seedlingDeathPercent3;
    }

    public void setSeedlingDeathPercent3(BigDecimal seedlingDeathPercent3) {
        this.seedlingDeathPercent3 = seedlingDeathPercent3;
    }

    public Long getDeadSeedlingNumber3() {
        return deadSeedlingNumber3;
    }

    public void setDeadSeedlingNumber3(Long deadSeedlingNumber3) {
        this.deadSeedlingNumber3 = deadSeedlingNumber3;
    }

    public String getTreatName() {
        return treatName;
    }

    public void setTreatName(String treatName) {
        this.treatName = treatName;
    }

    public BigDecimal getDeformedSeedlingPercent() {
        return deformedSeedlingPercent;
    }

    public void setDeformedSeedlingPercent(BigDecimal deformedSeedlingPercent) {
        this.deformedSeedlingPercent = deformedSeedlingPercent;
    }

    public Long getDeformedSeedlingNumber() {
        return deformedSeedlingNumber;
    }

    public void setDeformedSeedlingNumber(Long deformedSeedlingNumber) {
        this.deformedSeedlingNumber = deformedSeedlingNumber;
    }

    public String getComment1() {
        return comment1;
    }

    public void setComment1(String comment1) {
        this.comment1 = comment1;
    }

    public String getComment2() {
        return comment2;
    }

    public void setComment2(String comment2) {
        this.comment2 = comment2;
    }

    public String getComment3() {
        return comment3;
    }

    public void setComment3(String comment3) {
        this.comment3 = comment3;
    }
}
