package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.Pca;

/**
 * PcaMapper接口
 * 
 * @author ruoyi
 * @date 2023-03-27
 */
public interface PcaMapper 
{
    /**
     * 查询Pca
     * 
     * @param sample Pca主键
     * @return Pca
     */
    public Pca selectPcaBySample(String sample);

    /**
     * 查询Pca列表
     * 
     * @param pca Pca
     * @return Pca集合
     */
    public List<Pca> selectPcaList(Pca pca);

    /**
     * 新增Pca
     * 
     * @param pca Pca
     * @return 结果
     */
    public int insertPca(Pca pca);

    /**
     * 修改Pca
     * 
     * @param pca Pca
     * @return 结果
     */
    public int updatePca(Pca pca);

    /**
     * 删除Pca
     * 
     * @param sample Pca主键
     * @return 结果
     */
    public int deletePcaBySample(String sample);

    /**
     * 批量删除Pca
     * 
     * @param samples 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePcaBySamples(String[] samples);
}
