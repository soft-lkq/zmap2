package com.ruoyi.zeamap.mapper;
import java.util.List;
import com.ruoyi.zeamap.domain.ChromatinInteraction;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-12
 */
public interface ChromatinInteractionMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param chromatinInteractionId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public ChromatinInteraction selectChromatinInteractionByChromatinInteractionId(Long chromatinInteractionId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param chromatinInteraction 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ChromatinInteraction> selectChromatinInteractionList(ChromatinInteraction chromatinInteraction);

    /**
     * 新增【请填写功能名称】
     * 
     * @param chromatinInteraction 【请填写功能名称】
     * @return 结果
     */
    public int insertChromatinInteraction(ChromatinInteraction chromatinInteraction);

    /**
     * 修改【请填写功能名称】
     * 
     * @param chromatinInteraction 【请填写功能名称】
     * @return 结果
     */
    public int updateChromatinInteraction(ChromatinInteraction chromatinInteraction);

    /**
     * 删除【请填写功能名称】
     * 
     * @param chromatinInteractionId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteChromatinInteractionByChromatinInteractionId(Long chromatinInteractionId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param chromatinInteractionIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChromatinInteractionByChromatinInteractionIds(Long[] chromatinInteractionIds);

    /*
    *Date: 2023/4/13
    * @Author 刘洋
     */

    //查找dbxref表里面的accession
    public List<String> selectaccession();

    //查找dbxref表里面的version,version是reference的下级
    public List<String> selectversion(String accession);

    //查找Analysis的description
    public List<String> selectanalysis(@Param("accession") String accession,@Param("version") String version);

    //查找chrA
    public List<String> selectchrA();

    //查找chrB
    public List<String> selectchrB();

    //大查询
    public List<ChromatinInteraction> selectchromatin_interaction(@Param("accession") String accession, @Param("version") String version,@Param("description") String description,@Param("chrA") String chrA, @Param("startA") long startA, @Param("endA") long endA,@Param("chrB") String chrB, @Param("startB") long startB, @Param("endB") long endB);
}
