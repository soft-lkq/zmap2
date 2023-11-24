package com.ruoyi.zeamap.service.impl;

import com.ruoyi.zeamap.domain.InfoSelectCondition;
import com.ruoyi.zeamap.domain.TfbdInfo;
import com.ruoyi.zeamap.mapper.TfbdInfoMapper;
import com.ruoyi.zeamap.service.ITfbdInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【tfbd_info 查询、下载】Service业务层处理
 *
 * @author 邵雯
 * @date 2023-03-07
 */
@Service
public class TfbdInfoServiceImpl implements ITfbdInfoService {
    @Autowired
    private TfbdInfoMapper tfbdInfoMapper;

    /**
     * 查询【TfbdInfo】
     *
     * @param tfbdId 【TfbdInfo】主键
     * @return 【TfbdInfo】
     */
    @Override
    public TfbdInfo selectTfbdInfoByTfbdId(Long tfbdId) {
        return tfbdInfoMapper.selectTfbdInfoByTfbdId(tfbdId);
    }

    /**
     * 查询【TfbdInfo】列表
     *
     * @param tfbdInfo 【TfbdInfo】
     * @return 【TfbdInfo】
     */
    @Override
    public List<TfbdInfo> selectTfbdInfoList(TfbdInfo tfbdInfo) {
        return tfbdInfoMapper.selectTfbdInfoList(tfbdInfo);
    }

    /**
     * 新增【TfbdInfo】
     *
     * @param tfbdInfo 【TfbdInfo】
     * @return 结果
     */
    @Override
    public int insertTfbdInfo(TfbdInfo tfbdInfo) {
        return tfbdInfoMapper.insertTfbdInfo(tfbdInfo);
    }

    /**
     * 修改【TfbdInfo】
     *
     * @param tfbdInfo 【TfbdInfo】
     * @return 结果
     */
    @Override
    public int updateTfbdInfo(TfbdInfo tfbdInfo) {
        return tfbdInfoMapper.updateTfbdInfo(tfbdInfo);
    }

    /**
     * 批量删除【TfbdInfo】
     *
     * @param tfbdIds 需要删除的【TfbdInfo】主键
     * @return 结果
     */
    @Override
    public int deleteTfbdInfoByTfbdIds(Long[] tfbdIds) {
        return tfbdInfoMapper.deleteTfbdInfoByTfbdIds(tfbdIds);
    }

    /**
     * 删除【TfbdInfo】信息
     *
     * @param tfbdId 【TfbdInfo】主键
     * @return 结果
     */
    @Override
    public int deleteTfbdInfoByTfbdId(Long tfbdId) {
        return tfbdInfoMapper.deleteTfbdInfoByTfbdId(tfbdId);
    }


    //查询Reference
    @Override
    public List<String> selectReference() {
        return tfbdInfoMapper.selectReference();
    }

    //查询Version
    @Override
    public List<String> selectVersion(String accession) {
        return tfbdInfoMapper.selectVersion(accession);
    }

    //查询Analysis
    @Override
    public List<String> selectAnalysis() {
        return tfbdInfoMapper.selectAnalysis();
    }

    //查询TF ID
    @Override
    public List<String> selectTFID() {
        return tfbdInfoMapper.selectTFID();
    }

    //查询TF Name
    @Override
    public List<String> selectTFName() {
        return tfbdInfoMapper.selectTFName();
    }

    //查询TF Family
    @Override
    public List<String> selectTFFamily() {
        return tfbdInfoMapper.selectTFFamily();
    }

    //查询selectTFGeneID
    @Override
    public List<String> selectTFGeneID() {
        return tfbdInfoMapper.selectTFGeneID();
    }

    //查询 Info
    public List<InfoSelectCondition> selectInfo(String accession, String version, String analysis_name, String info_name, String info_simplename, String info_family, String target_gene, Double p_value) {
        return tfbdInfoMapper.selectInfo(accession, version, analysis_name, info_name, info_simplename, info_family, target_gene, p_value);
    }

    public List<InfoSelectCondition> selectInfo11() {
        return tfbdInfoMapper.selectInfo11();
    }

}
