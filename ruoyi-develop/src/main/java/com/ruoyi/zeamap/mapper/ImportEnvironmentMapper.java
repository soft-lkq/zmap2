package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.ImportEnvironment;

/**
 * ImportEnvironmentMapper接口
 * 
 * @author ruoyi
 * @date 2023-04-09
 */
public interface ImportEnvironmentMapper 
{
    /**
     * 查询ImportEnvironment
     * 
     * @param environmentId ImportEnvironment主键
     * @return ImportEnvironment
     */
    public ImportEnvironment selectImportEnvironmentByEnvironmentId(Long environmentId);

    /**
     * 查询ImportEnvironment列表
     * 
     * @param importEnvironment ImportEnvironment
     * @return ImportEnvironment集合
     */
    public List<ImportEnvironment> selectImportEnvironmentList(ImportEnvironment importEnvironment);

    /**
     * 新增ImportEnvironment
     * 
     * @param importEnvironment ImportEnvironment
     * @return 结果
     */
    public int insertImportEnvironment(ImportEnvironment importEnvironment);

    /**
     * 修改ImportEnvironment
     * 
     * @param importEnvironment ImportEnvironment
     * @return 结果
     */
    public int updateImportEnvironment(ImportEnvironment importEnvironment);

    /**
     * 删除ImportEnvironment
     * 
     * @param environmentId ImportEnvironment主键
     * @return 结果
     */
    public int deleteImportEnvironmentByEnvironmentId(Long environmentId);

    /**
     * 批量删除ImportEnvironment
     * 
     * @param environmentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImportEnvironmentByEnvironmentIds(Long[] environmentIds);
}
