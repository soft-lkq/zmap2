package com.ruoyi.zeamap.service;

import java.util.List;
import com.ruoyi.zeamap.domain.Mutable;

/**
 * Location, TraitDateLoc,Year,Tissue 查找使用
Service接口
 * 
 * @author ruoyi
 * @date 2023-01-08
 */
public interface IMutableService 
{
    /**
     * 查询Location, TraitDateLoc,Year,Tissue 查找使用

     * 
     * @param mutableId Location, TraitDateLoc,Year,Tissue 查找使用
主键
     * @return Location, TraitDateLoc,Year,Tissue 查找使用

     */
    public Mutable selectMutableByMutableId(Long mutableId);

    /**
     * 查询Location, TraitDateLoc,Year,Tissue 查找使用
列表
     * 
     * @param mutable Location, TraitDateLoc,Year,Tissue 查找使用

     * @return Location, TraitDateLoc,Year,Tissue 查找使用
集合
     */
    public List<Mutable> selectMutableList(Mutable mutable);

    /**
     * 新增Location, TraitDateLoc,Year,Tissue 查找使用

     * 
     * @param mutable Location, TraitDateLoc,Year,Tissue 查找使用

     * @return 结果
     */
    public int insertMutable(Mutable mutable);

    /**
     * 修改Location, TraitDateLoc,Year,Tissue 查找使用

     * 
     * @param mutable Location, TraitDateLoc,Year,Tissue 查找使用

     * @return 结果
     */
    public int updateMutable(Mutable mutable);

    /**
     * 批量删除Location, TraitDateLoc,Year,Tissue 查找使用

     * 
     * @param mutableIds 需要删除的Location, TraitDateLoc,Year,Tissue 查找使用
主键集合
     * @return 结果
     */
    public int deleteMutableByMutableIds(Long[] mutableIds);

    /**
     * 删除Location, TraitDateLoc,Year,Tissue 查找使用
信息
     * 
     * @param mutableId Location, TraitDateLoc,Year,Tissue 查找使用
主键
     * @return 结果
     */
    public int deleteMutableByMutableId(Long mutableId);
}
