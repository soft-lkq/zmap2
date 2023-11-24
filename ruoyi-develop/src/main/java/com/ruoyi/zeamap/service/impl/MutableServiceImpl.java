package com.ruoyi.zeamap.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.MutableMapper;
import com.ruoyi.zeamap.domain.Mutable;
import com.ruoyi.zeamap.service.IMutableService;

/**
 * Location, TraitDateLoc,Year,Tissue 查找使用
Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-08
 */
@Service
public class MutableServiceImpl implements IMutableService 
{
    @Autowired
    private MutableMapper mutableMapper;

    /**
     * 查询Location, TraitDateLoc,Year,Tissue 查找使用

     * 
     * @param mutableId Location, TraitDateLoc,Year,Tissue 查找使用
主键
     * @return Location, TraitDateLoc,Year,Tissue 查找使用

     */
    @Override
    public Mutable selectMutableByMutableId(Long mutableId)
    {
        return mutableMapper.selectMutableByMutableId(mutableId);
    }

    /**
     * 查询Location, TraitDateLoc,Year,Tissue 查找使用
列表
     * 
     * @param mutable Location, TraitDateLoc,Year,Tissue 查找使用

     * @return Location, TraitDateLoc,Year,Tissue 查找使用

     */
    @Override
    public List<Mutable> selectMutableList(Mutable mutable)
    {
        return mutableMapper.selectMutableList(mutable);
    }

    /**
     * 新增Location, TraitDateLoc,Year,Tissue 查找使用

     * 
     * @param mutable Location, TraitDateLoc,Year,Tissue 查找使用

     * @return 结果
     */
    @Override
    public int insertMutable(Mutable mutable)
    {
        return mutableMapper.insertMutable(mutable);
    }

    /**
     * 修改Location, TraitDateLoc,Year,Tissue 查找使用

     * 
     * @param mutable Location, TraitDateLoc,Year,Tissue 查找使用

     * @return 结果
     */
    @Override
    public int updateMutable(Mutable mutable)
    {
        return mutableMapper.updateMutable(mutable);
    }

    /**
     * 批量删除Location, TraitDateLoc,Year,Tissue 查找使用

     * 
     * @param mutableIds 需要删除的Location, TraitDateLoc,Year,Tissue 查找使用
主键
     * @return 结果
     */
    @Override
    public int deleteMutableByMutableIds(Long[] mutableIds)
    {
        return mutableMapper.deleteMutableByMutableIds(mutableIds);
    }

    /**
     * 删除Location, TraitDateLoc,Year,Tissue 查找使用
信息
     * 
     * @param mutableId Location, TraitDateLoc,Year,Tissue 查找使用
主键
     * @return 结果
     */
    @Override
    public int deleteMutableByMutableId(Long mutableId)
    {
        return mutableMapper.deleteMutableByMutableId(mutableId);
    }
}
