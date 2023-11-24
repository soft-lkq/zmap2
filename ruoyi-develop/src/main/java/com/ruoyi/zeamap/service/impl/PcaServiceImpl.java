package com.ruoyi.zeamap.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.PcaMapper;
import com.ruoyi.zeamap.domain.Pca;
import com.ruoyi.zeamap.service.IPcaService;

/**
 * PcaService业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-27
 */
@Service
public class PcaServiceImpl implements IPcaService 
{
    @Autowired
    private PcaMapper pcaMapper;

    /**
     * 查询Pca
     * 
     * @param sample Pca主键
     * @return Pca
     */
    @Override
    public Pca selectPcaBySample(String sample)
    {
        return pcaMapper.selectPcaBySample(sample);
    }

    /**
     * 查询Pca列表
     * 
     * @param pca Pca
     * @return Pca
     */
    @Override
    public List<Pca> selectPcaList(Pca pca)
    {
        return pcaMapper.selectPcaList(pca);
    }

    /**
     * 新增Pca
     * 
     * @param pca Pca
     * @return 结果
     */
    @Override
    public int insertPca(Pca pca)
    {
        return pcaMapper.insertPca(pca);
    }

    /**
     * 修改Pca
     * 
     * @param pca Pca
     * @return 结果
     */
    @Override
    public int updatePca(Pca pca)
    {
        return pcaMapper.updatePca(pca);
    }

    /**
     * 批量删除Pca
     * 
     * @param samples 需要删除的Pca主键
     * @return 结果
     */
    @Override
    public int deletePcaBySamples(String[] samples)
    {
        return pcaMapper.deletePcaBySamples(samples);
    }

    /**
     * 删除Pca信息
     * 
     * @param sample Pca主键
     * @return 结果
     */
    @Override
    public int deletePcaBySample(String sample)
    {
        return pcaMapper.deletePcaBySample(sample);
    }
}
