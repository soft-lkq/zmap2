package com.ruoyi.zeamap.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.zeamap.domain.Tissue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.EnvironmentMapper;
import com.ruoyi.zeamap.domain.Environment;
import com.ruoyi.zeamap.service.IEnvironmentService;

/**
 * environmentService业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-10
 */
@Service
public class EnvironmentServiceImpl implements IEnvironmentService 
{
    @Autowired
    private EnvironmentMapper environmentMapper;

    /**
     * 查询environment
     * 
     * @param environmentId environment主键
     * @return environment
     */
    @Override
    public Environment selectEnvironmentByEnvironmentId(Long environmentId)
    {
        return environmentMapper.selectEnvironmentByEnvironmentId(environmentId);
    }

    /**
     * 查询environment列表
     * 
     * @param environment environment
     * @return environment
     */
    @Override
    public List<Environment> selectEnvironmentList(Environment environment)
    {
        return environmentMapper.selectEnvironmentList(environment);
    }

    /**
     * 新增environment
     * 
     * @param environment environment
     * @return 结果
     */
    @Override
    public int insertEnvironment(Environment environment)
    {
        environment.setCreateTime(DateUtils.getNowDate());
        return environmentMapper.insertEnvironment(environment);
    }

    /**
     * 修改environment
     * 
     * @param environment environment
     * @return 结果
     */
    @Override
    public int updateEnvironment(Environment environment)
    {
        environment.setUpdateTime(DateUtils.getNowDate());
        return environmentMapper.updateEnvironment(environment);
    }

    /**
     * 批量删除environment
     * 
     * @param environmentIds 需要删除的environment主键
     * @return 结果
     */
    @Override
    public int deleteEnvironmentByEnvironmentIds(Long[] environmentIds)
    {
        return environmentMapper.deleteEnvironmentByEnvironmentIds(environmentIds);
    }

    /**
     * 删除environment信息
     * 
     * @param environmentId environment主键
     * @return 结果
     */
    @Override
    public int deleteEnvironmentByEnvironmentId(Long environmentId)
    {
        return environmentMapper.deleteEnvironmentByEnvironmentId(environmentId);
    }

    @Override
    public Map<String, List<String>> SelectorClassDesc() {

        List<Environment> environments  = environmentMapper.selectMultiSelectorClassDesc();

        Map<String, List<String>> env = new HashMap<>();
        //与Tissue 中同理
        for (Environment environment:environments) {
            if (env.get(environment.getEnvironmentClass())==null){
                List<String> envDesc = new ArrayList<>();
                envDesc.add(environment.getEnvironmentDesc());
                env.put(environment.getEnvironmentClass(), envDesc);
            }else{
                List<String> envDes = env.get(environment.getEnvironmentClass());
                envDes.add(environment.getEnvironmentDesc());
            }
        }
        return env;
    }
}
