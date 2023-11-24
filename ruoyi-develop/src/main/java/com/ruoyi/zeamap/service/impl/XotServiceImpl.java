package com.ruoyi.zeamap.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.zeamap.domain.XotGermplasm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.XotMapper;
import com.ruoyi.zeamap.domain.Xot;
import com.ruoyi.zeamap.service.IXotService;

/**
 * xotService业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-08
 */
@Service
public class XotServiceImpl implements IXotService 
{
    @Autowired
    private XotMapper xotMapper;

    /**
     * 查询xot
     * 
     * @param xotId xot主键
     * @return xot
     */
    @Override
    public Xot selectXotByXotId(Long xotId)
    {
        return xotMapper.selectXotByXotId(xotId);
    }

    /**
     * 查询xot列表
     * 
     * @param xot xot
     * @return xot
     */
    @Override
    public List<Xot> selectXotList(Xot xot)
    {
        return xotMapper.selectXotList(xot);
    }

    /**
     * 新增xot
     * 
     * @param xot xot
     * @return 结果
     */
    @Override
    public int insertXot(Xot xot)
    {
        return xotMapper.insertXot(xot);
    }

    /**
     * 修改xot
     * 
     * @param xot xot
     * @return 结果
     */
    @Override
    public int updateXot(Xot xot)
    {
        return xotMapper.updateXot(xot);
    }

    /**
     * 批量删除xot
     * 
     * @param xotIds 需要删除的xot主键
     * @return 结果
     */
    @Override
    public int deleteXotByXotIds(Long[] xotIds)
    {
        return xotMapper.deleteXotByXotIds(xotIds);
    }

    /**
     * 删除xot信息
     * 
     * @param xotId xot主键
     * @return 结果
     */
    @Override
    public int deleteXotByXotId(Long xotId)
    {
        return xotMapper.deleteXotByXotId(xotId);
    }




    @Override
    public List<Xot> selectXotFull(Xot xot) {


        //其中隐藏了total 但是我们切换其他的进行接收
        List<Xot> xots = xotMapper.selectFull(xot);
//        Page<Xot> xot1 = xots;
        return xots;
    }

    @Override
    public Long selectXotName(String uid) {
        Long xot = xotMapper.selectXotName(uid);
        return xot;
    }

    @Override
    public List<XotGermplasm> selectGermplasmByXotId(Long uid) {
        List<XotGermplasm> res =   xotMapper.selectGermplasmByXotId(uid);
        return res;
    }

    @Override
    public List<XotGermplasm> selectGermplasmByXot(String uid) {
        return xotMapper.selectGermplasmByXot(uid);
    }

    @Override
    public Map<String, List<String>> selectDownMenuData() {
        List<String> Category = xotMapper.selectXotAllCategory();

        List<String> Type = xotMapper.selectXotAllType();
//        List<String> Analysis = xotMapper.selectXotAllAnalysis();
//        List<String> Name = xotMapper.selectXotAllName();

        List<String> Analysis = xotMapper.selectXotAllAnalysisId();
        //name 是 的description
        List<String> Name = xotMapper.selectXotAllDescription();



        List<String> Location = xotMapper.selectXotAllLocation();
        List<String> TraitDateLoc = xotMapper.selectXotAllTraitDateLoc();
        List<String> Year = xotMapper.selectXotAllYear();
        List<String> Tissue = xotMapper.selectXotAllTissue();

        Map<String, List<String>> res = new HashMap<>();
        res.put("Type", Category);
        res.put("Category", Type);
        res.put("Analysis", Analysis);
        res.put("Name", Name);
        res.put("Location", Location);
        res.put("TraitDateLoc", TraitDateLoc);
        res.put("Year", Year);
        res.put("Tissue", Tissue);
        return res;
    }


}
