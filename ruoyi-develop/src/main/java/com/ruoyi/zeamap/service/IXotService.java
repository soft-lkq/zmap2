package com.ruoyi.zeamap.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.zeamap.domain.Xot;
import com.ruoyi.zeamap.domain.XotGermplasm;

/**
 * xotService接口
 * 
 * @author ruoyi
 * @date 2023-01-08
 */
public interface IXotService 
{
    /**
     * 查询xot
     * 
     * @param xotId xot主键
     * @return xot
     */
    public Xot selectXotByXotId(Long xotId);

    /**
     * 查询xot列表
     * 
     * @param xot xot
     * @return xot集合
     */
    public List<Xot> selectXotList(Xot xot);

    /**
     * 新增xot
     * 
     * @param xot xot
     * @return 结果
     */
    public int insertXot(Xot xot);

    /**
     * 修改xot
     * 
     * @param xot xot
     * @return 结果
     */
    public int updateXot(Xot xot);

    /**
     * 批量删除xot
     * 
     * @param xotIds 需要删除的xot主键集合
     * @return 结果
     */
    public int deleteXotByXotIds(Long[] xotIds);

    /**
     * 删除xot信息
     * 
     * @param xotId xot主键
     * @return 结果
     */
    public int deleteXotByXotId(Long xotId);



    public List<Xot> selectXotFull(Xot xot);

    public Map<String, List<String>> selectDownMenuData();

    public Long  selectXotName(String uid);

    public List<XotGermplasm> selectGermplasmByXotId(Long uid);

    public List<XotGermplasm> selectGermplasmByXot(String uid);
}
