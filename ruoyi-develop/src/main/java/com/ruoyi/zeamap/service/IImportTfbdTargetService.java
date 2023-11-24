package com.ruoyi.zeamap.service;

import java.util.List;

import com.ruoyi.zeamap.domain.ImportTfbdInfo;
import com.ruoyi.zeamap.domain.ImportTfbdTarget;

/**
 * ImportService接口
 * 
 * @author ruoyi
 * @date 2023-04-09
 */
public interface IImportTfbdTargetService 
{

    public String importTfbdTargetData(List<ImportTfbdTarget> importList, Boolean isUpdateSupport, String operName);

    /**
     * 查询Import
     * 
     * @param tfbdTargetId Import主键
     * @return Import
     */
    public ImportTfbdTarget selectImportTfbdTargetByTfbdTargetId(Long tfbdTargetId);

    /**
     * 查询Import列表
     * 
     * @param importTfbdTarget Import
     * @return Import集合
     */
    public List<ImportTfbdTarget> selectImportTfbdTargetList(ImportTfbdTarget importTfbdTarget);

    /**
     * 新增Import
     * 
     * @param importTfbdTarget Import
     * @return 结果
     */
    public int insertImportTfbdTarget(ImportTfbdTarget importTfbdTarget);

    /**
     * 修改Import
     * 
     * @param importTfbdTarget Import
     * @return 结果
     */
    public int updateImportTfbdTarget(ImportTfbdTarget importTfbdTarget);

    /**
     * 批量删除Import
     * 
     * @param tfbdTargetIds 需要删除的Import主键集合
     * @return 结果
     */
    public int deleteImportTfbdTargetByTfbdTargetIds(Long[] tfbdTargetIds);

    /**
     * 删除Import信息
     * 
     * @param tfbdTargetId Import主键
     * @return 结果
     */
    public int deleteImportTfbdTargetByTfbdTargetId(Long tfbdTargetId);
}
