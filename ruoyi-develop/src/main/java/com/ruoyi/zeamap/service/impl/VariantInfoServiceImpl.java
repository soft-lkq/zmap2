package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.zeamap.mapper.VariantInfoMapper;
import com.ruoyi.zeamap.service.IVariantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.domain.VariantInfo;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2022-10-30
 */
@Service
public class VariantInfoServiceImpl implements IVariantInfoService {
    @Autowired
    private VariantInfoMapper variantInfoMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param variantinfoId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public VariantInfo selectVariantInfoByVariantinfoId(Long variantinfoId) {
        return variantInfoMapper.selectVariantInfoByVariantinfoId(variantinfoId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param variantInfo 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<VariantInfo> selectVariantInfoList(VariantInfo variantInfo) {
        return variantInfoMapper.selectVariantInfoList(variantInfo);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param variantInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertVariantInfo(VariantInfo variantInfo) {
        return variantInfoMapper.insertVariantInfo(variantInfo);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param variantInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateVariantInfo(VariantInfo variantInfo) {
        return variantInfoMapper.updateVariantInfo(variantInfo);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param variantinfoIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteVariantInfoByVariantinfoIds(Long[] variantinfoIds) {
        return variantInfoMapper.deleteVariantInfoByVariantinfoIds(variantinfoIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param variantinfoId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteVariantInfoByVariantinfoId(Long variantinfoId) {
        return variantInfoMapper.deleteVariantInfoByVariantinfoId(variantinfoId);
    }

    /**
     * variantInfoService业务层处理
     * 变异详情页
     * @author 刘洋、邵雯
     * @date 2023-3-2
     */
    @Override
    public String selectSummaryByVID(String VID) {
        return variantInfoMapper.selectSummaryByVID(VID);
    }

    @Override
    public String selectPieplotsByVID(String VID) {
        return variantInfoMapper.selectPieplotsByVID(VID);
    }

    @Override
    public String selectAnnotationsByVID(String VID) {
        return variantInfoMapper.selectAnnotationsByVID(VID);
    }

    @Override
    public String selectInformationByVID(String VID) {
        return variantInfoMapper.selectInformationByVID(VID);
    }
}
