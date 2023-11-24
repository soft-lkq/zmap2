package com.ruoyi.zeamap.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.zeamap.domain.Environment;

/**
 * environmentService接口
 * 
 * @author ruoyi
 * @date 2023-01-10
 */
public interface IEnvironmentService 
{
    /**
     * 查询environment
     * 
     * @param environmentId environment主键
     * @return environment
     */
    public Environment selectEnvironmentByEnvironmentId(Long environmentId);

    /**
     * 查询environment列表
     * 
     * @param environment environment
     * @return environment集合
     */
    public List<Environment> selectEnvironmentList(Environment environment);

    /**
     * 新增environment
     * 
     * @param environment environment
     * @return 结果
     */
    public int insertEnvironment(Environment environment);

    /**
     * 修改environment
     * 
     * @param environment environment
     * @return 结果
     */
    public int updateEnvironment(Environment environment);

    /**
     * 批量删除environment
     * 
     * @param environmentIds 需要删除的environment主键集合
     * @return 结果
     */
    public int deleteEnvironmentByEnvironmentIds(Long[] environmentIds);

    /**
     * 删除environment信息
     * 
     * @param environmentId environment主键
     * @return 结果
     */
    public int deleteEnvironmentByEnvironmentId(Long environmentId);

    public Map<String,List<String>> SelectorClassDesc();

}
