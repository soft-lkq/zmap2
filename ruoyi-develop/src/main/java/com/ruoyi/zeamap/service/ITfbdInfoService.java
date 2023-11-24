package com.ruoyi.zeamap.service;

import com.ruoyi.zeamap.domain.InfoSelectCondition;
import com.ruoyi.zeamap.domain.TfbdInfo;

import java.util.List;

/**
 * 【tfbd_info 查询、下载】Service接口
 *
 * @author 邵雯
 * @date 2023-03-07
 */
public interface ITfbdInfoService {
    /**
     * 查询【TfbdInfo】
     *
     * @param tfbdId 【TfbdInfo】主键
     * @return 【TfbdInfo】
     */
    public TfbdInfo selectTfbdInfoByTfbdId(Long tfbdId);

    /**
     * 查询【TfbdInfo】列表
     *
     * @param tfbdInfo 【TfbdInfo】
     * @return 【TfbdInfo】集合
     */
    public List<TfbdInfo> selectTfbdInfoList(TfbdInfo tfbdInfo);

    /**
     * 新增【TfbdInfo】
     *
     * @param tfbdInfo 【TfbdInfo】
     * @return 结果
     */
    public int insertTfbdInfo(TfbdInfo tfbdInfo);

    /**
     * 修改【TfbdInfo】
     *
     * @param tfbdInfo 【TfbdInfo】
     * @return 结果
     */
    public int updateTfbdInfo(TfbdInfo tfbdInfo);

    /**
     * 批量删除【TfbdInfo】
     *
     * @param tfbdIds 需要删除的【TfbdInfo】主键集合
     * @return 结果
     */
    public int deleteTfbdInfoByTfbdIds(Long[] tfbdIds);

    /**
     * 删除【TfbdInfo】单条信息
     *
     * @param tfbdId 【TfbdInfo】主键
     * @return 结果
     */
    public int deleteTfbdInfoByTfbdId(Long tfbdId);


    //查询Reference
    public List<String> selectReference();

    //查询Version
    public List<String> selectVersion(String accession);

    //查询Version
    public List<String> selectAnalysis();

    //查询TF ID
    public List<String> selectTFID();

    //查询TF Name
    public List<String> selectTFName();

    //查询TF Family
    public List<String> selectTFFamily();

    //查询TFGeneID
    public List<String> selectTFGeneID();

    //查询 Info
    public List<InfoSelectCondition> selectInfo(String accession, String version, String analysis_name, String info_name,
                                                String info_simplename, String info_family, String target_gene, Double p_value);

    public List<InfoSelectCondition> selectInfo11();
}
