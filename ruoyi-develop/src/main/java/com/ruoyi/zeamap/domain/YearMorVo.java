package com.ruoyi.zeamap.domain;

import com.ruoyi.common.annotation.Excel;

import java.math.BigDecimal;

public class YearMorVo {
    private Long year;
    /**
     * 穗上叶长
     */
    @Excel(name = "穗上叶长")
    private BigDecimal leafLength;

    /**
     * 穗上叶宽
     */
    @Excel(name = "穗上叶宽")
    private BigDecimal leafWidth;

    /**
     * 株高
     */
    @Excel(name = "株高")
    private BigDecimal plantHeight;

    /**
     * 穗位
     */
    @Excel(name = "穗位")
    private BigDecimal earHeight;

    /**
     * 雄穗最上面节间长度
     */
    @Excel(name = "雄穗最上面节间长度")
    private BigDecimal tasselLengthTop;

    /**
     * 雄一级侧枝数目
     */
    @Excel(name = "雄一级侧枝数目")
    private BigDecimal tasselBranchNumber1;

    /**
     * 果穗表现
     */
    @Excel(name = "果穗表现")
    private String expression;

    /**
     * 雄穗分枝数
     */
    @Excel(name = "雄穗分枝数")
    private BigDecimal tasselBranchNumber;

    /**
     * 倒伏倒折率之和
     */
    @Excel(name = "倒伏倒折率之和")
    private BigDecimal rates;

    /**
     * 穗上叶片数
     */
    @Excel(name = "穗上叶片数")
    private Long leafNumberAboveEar;

    /**
     * 苗势
     */
    @Excel(name = "苗势")
    private String seedlingPotential;

    /**
     * 雄穗倒数第二侧枝长度
     */
    @Excel(name = "雄穗倒数第二侧枝长度")
    private BigDecimal tasselLength2;

    /**
     * 雄穗倒数第二侧枝姿势
     */
    @Excel(name = "雄穗倒数第二侧枝姿势")
    private BigDecimal tasselPosture2;

    /**
     * 雄穗主轴与倒数第二侧枝夹角
     */
    @Excel(name = "雄穗主轴与倒数第二侧枝夹角")
    private BigDecimal tasselAngle2;

    /**
     * 雄穗最低位侧枝以上主轴长度
     */
    @Excel(name = "雄穗最低位侧枝以上主轴长度")
    private BigDecimal tasselLength3;

    /**
     * 雄穗最高位侧枝以上主轴长度
     */
    @Excel(name = "雄穗最高位侧枝以上主轴长度")
    private BigDecimal tasselLength4;

    /**
     * 雄穗小穗密度
     */
    @Excel(name = "雄穗小穗密度")
    private BigDecimal tasselDensity;

    /**
     * 雄穗鲜重
     */
    @Excel(name = "雄穗鲜重")
    private BigDecimal tasselWeight1;

    /**
     * 雄穗干重
     */
    @Excel(name = "雄穗干重")
    private BigDecimal tasselWeight2;

    /**
     * 穗小花数
     */
    @Excel(name = "穗小花数")
    private Long tasselFloretNumber;

    /**
     * 花粉量
     */
    @Excel(name = "花粉量")
    private String pollenQuantity;

    /**
     * 根分布
     */
    @Excel(name = "根分布")
    private String rootDistribution;

    /**
     * 根层
     */
    @Excel(name = "根层")
    private String rootLayer;

    /**
     * 根粗细
     */
    @Excel(name = "根粗细")
    private String rootThickness;

    /**
     * 根夹角
     */
    @Excel(name = "根夹角")
    private String rootAngle;

    /**
     * 母根分布
     */
    @Excel(name = "母根分布")
    private String femaleRootDistribution;

    /**
     * 父根分布
     */
    @Excel(name = "父根分布")
    private String maleRootDistribution;

    /**
     * 第一叶顶端形状
     */
    @Excel(name = "第一叶顶端形状")
    private String leafShape1;

    /**
     * 顶叶叶姿
     */
    @Excel(name = "顶叶叶姿")
    private String leafPosture1;

    /**
     * 上位穗上叶与茎秆夹角
     */
    @Excel(name = "上位穗上叶与茎秆夹角")
    private String leafAngle;

    /**
     * 上位穗上叶姿态
     */
    @Excel(name = "上位穗上叶姿态")
    private String leafPosture2;

    /**
     * 成株叶片数
     */
    @Excel(name = "成株叶片数")
    private Long leafNumber1;

    /**
     * 茎粗
     */
    @Excel(name = "茎粗")
    private BigDecimal stemDiameter;

    /**
     * 果穗着生姿态
     */
    @Excel(name = "果穗着生姿态")
    private String earBearingPosture;

    /**
     * 苞叶层数
     */
    @Excel(name = "苞叶层数")
    private Long huskTier;

    /**
     * 苞叶总厚度
     */
    @Excel(name = "苞叶总厚度")
    private BigDecimal huskThickness1;

    /**
     * 苞叶总数
     */
    @Excel(name = "苞叶总数")
    private Long huskTierAll;

    /**
     * 苞叶厚度
     */
    @Excel(name = "苞叶厚度")
    private BigDecimal huskThickness2;

    /**
     * 花丝花青甙显色
     */
    @Excel(name = "花丝花青甙显色")
    private String silkColor;

    /**
     * 花药花青甙显色
     */
    @Excel(name = "花药花青甙显色")
    private String antherColor;

    /**
     * 茎支持根花青甙显色
     */
    @Excel(name = "茎支持根花青甙显色")
    private String stemRootColor;

    /**
     * 穗轴颜色
     */
    @Excel(name = "穗轴颜色")
    private String rachisColor;

    /**
     * 第一叶鞘花青甙显色
     */
    @Excel(name = "第一叶鞘花青甙显色")
    private String sheathColor1;

    /**
     * 颖片基部花青甙显色
     */
    @Excel(name = "颖片基部花青甙显色")
    private String glumeColor;

    /**
     * 幼苗叶色
     */
    @Excel(name = "幼苗叶色")
    private String leafColor1;

    /**
     * 籽粒背面颜色
     */
    @Excel(name = "籽粒背面颜色")
    private String grainColor2;

    /**
     * 籽粒颜色
     */
    @Excel(name = "籽粒颜色")
    private String grainColor;

    /**
     * 上位穗上叶鞘花青甙显色
     */
    @Excel(name = "上位穗上叶鞘花青甙显色")
    private String sheathColor2;

    /** 上位穗上叶叶色 */
    @Excel(name = "上位穗上叶叶色")
    private String leafColor2;

    public YearMorVo() {
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
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

    public YearMorVo(Long year, BigDecimal leafLength, BigDecimal leafWidth, BigDecimal plantHeight, BigDecimal earHeight, BigDecimal tasselLengthTop, BigDecimal tasselBranchNumber1, String expression, BigDecimal tasselBranchNumber, BigDecimal rates, Long leafNumberAboveEar, String seedlingPotential, BigDecimal tasselLength2, BigDecimal tasselPosture2, BigDecimal tasselAngle2, BigDecimal tasselLength3, BigDecimal tasselLength4, BigDecimal tasselDensity, BigDecimal tasselWeight1, BigDecimal tasselWeight2, Long tasselFloretNumber, String pollenQuantity, String rootDistribution, String rootLayer, String rootThickness, String rootAngle, String femaleRootDistribution, String maleRootDistribution, String leafShape1, String leafPosture1, String leafAngle, String leafPosture2, Long leafNumber1, BigDecimal stemDiameter, String earBearingPosture, Long huskTier, BigDecimal huskThickness1, Long huskTierAll, BigDecimal huskThickness2, String silkColor, String antherColor, String stemRootColor, String rachisColor, String sheathColor1, String glumeColor, String leafColor1, String grainColor2, String grainColor, String sheathColor2, String leafColor2) {
        this.year = year;
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
    }
}
