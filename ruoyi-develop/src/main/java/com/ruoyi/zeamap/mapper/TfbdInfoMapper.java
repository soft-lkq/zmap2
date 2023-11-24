package com.ruoyi.zeamap.mapper;

import com.ruoyi.zeamap.domain.InfoSelectCondition;
import com.ruoyi.zeamap.domain.TfbdInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 【TfbdInfo查询，下载】Mapper接口
 *
 * @author 邵雯
 * @date 2023-03-07
 */
public interface TfbdInfoMapper {
    /**
     * 查询 TfbdInfo通过tfbdId
     *
     * @param tfbdId TfbdInfo主键
     * @return TfbdInfo
     */
    public TfbdInfo selectTfbdInfoByTfbdId(Long tfbdId);

    /**
     * 查询 TfbdInfo列表
     *
     * @param tfbdInfo TfbdInfo
     * @return TfbdInfo集合
     */
    public List<TfbdInfo> selectTfbdInfoList(TfbdInfo tfbdInfo);

    /**
     * 新增 TfbdInfo单条数据
     *
     * @param tfbdInfo TfbdInfo
     * @return 结果
     */
    public int insertTfbdInfo(TfbdInfo tfbdInfo);

    /**
     * 修改 TfbdInfo单条数据
     *
     * @param tfbdInfo TfbdInfo
     * @return 结果
     */
    public int updateTfbdInfo(TfbdInfo tfbdInfo);

    /**
     * 删除 TfbdInfo单条数据
     *
     * @param tfbdId TfbdInfo主键
     * @return 结果
     */
    public int deleteTfbdInfoByTfbdId(Long tfbdId);

    /**
     * 批量删除 TfbdInfo数据
     *
     * @param tfbdIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTfbdInfoByTfbdIds(Long[] tfbdIds);


    //查询Reference
    public List<String> selectReference();

    //查询Version
    public List<String> selectVersion(String accession);

    //查询Analysis
    public List<String> selectAnalysis();

    //查询TF ID
    public List<String> selectTFID();

    //查询TF Name
    public List<String> selectTFName();

    //查询TF Family
    public List<String> selectTFFamily();

    //查询selectTFGeneID
    public List<String> selectTFGeneID();

    //查询 Info
    public List<InfoSelectCondition> selectInfo(@Param("accession") String accession, @Param("version") String version, @Param("analysis_name") String analysis_id, @Param("info_name") String info_name,
                                                @Param("info_simplename") String info_simplename, @Param("info_family") String info_family, @Param("target_gene") String target_gene, @Param("p_value") Double p_value);

    public List<InfoSelectCondition> selectInfo11();
}

