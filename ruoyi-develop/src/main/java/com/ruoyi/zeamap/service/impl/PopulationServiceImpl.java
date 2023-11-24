package com.ruoyi.zeamap.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.PopulationMapper;
import com.ruoyi.zeamap.domain.Population;
import com.ruoyi.zeamap.service.IPopulationService;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Validator;

/**
 * 产品Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-14
 */
@Service
public class PopulationServiceImpl implements IPopulationService
{
    @Autowired
    private PopulationMapper populationMapper;



    private static final Logger log = LoggerFactory.getLogger(PopulationServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importPopulationData(List<Population> populationList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(populationList) || populationList.size() == 0)
        {
            throw new ServiceException("导入population数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (Population population : populationList)
        {
            try
            {
                // 验证是否存在这个用户
                Population u = populationMapper.selectPopulationByPopulationId(population.getPopulationId());
                if (StringUtils.isNull(u))
                {
                    BeanValidators.validateWithException(validator, population);
                    population.setCreateBy(operName);
                    this.insertPopulation(population);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "id " + population.getPopulationId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, population);
                    population.setUpdateBy(operName);
                    this.updatePopulation(population);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "id " + population.getPopulationId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "id " + population.getPopulationId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "id " + population.getPopulationId() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    @Override
    public Long selectPopulationidByName(String name) {
        return populationMapper.selectPopulationidByName(name);
    }


    /**
     * 查询产品
     * 
     * @param populationId 产品主键
     * @return 产品
     */
    @Override
    public Population selectPopulationByPopulationId(Long populationId)
    {
        return populationMapper.selectPopulationByPopulationId(populationId);
    }

    /**
     * 查询产品列表
     * 
     * @param population 产品
     * @return 产品
     */
    @Override
    public List<Population> selectPopulationList(Population population)
    {
        return populationMapper.selectPopulationList(population);
    }

    /**
     * 新增产品
     * 
     * @param population 产品
     * @return 结果
     */
    @Override
    public int insertPopulation(Population population)
    {
        return populationMapper.insertPopulation(population);
    }

    /**
     * 修改产品
     * 
     * @param population 产品
     * @return 结果
     */
    @Override
    public int updatePopulation(Population population)
    {
        return populationMapper.updatePopulation(population);
    }

    /**
     * 批量删除产品
     * 
     * @param populationIds 需要删除的产品主键
     * @return 结果
     */
    @Override
    public int deletePopulationByPopulationIds(Long[] populationIds)
    {
        return populationMapper.deletePopulationByPopulationIds(populationIds);
    }

    /**
     * 删除产品信息
     * 
     * @param populationId 产品主键
     * @return 结果
     */
    @Override
    public int deletePopulationByPopulationId(Long populationId)
    {
        return populationMapper.deletePopulationByPopulationId(populationId);
    }
}
