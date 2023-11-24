package com.ruoyi.zeamap.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.zeamap.domain.ImportAnalysis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.GermplasmMapper;
import com.ruoyi.zeamap.domain.Germplasm;
import com.ruoyi.zeamap.service.IGermplasmService;

import javax.validation.Validator;

/**
 * 产品详情Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-14
 */
@Service
public class GermplasmServiceImpl implements IGermplasmService
{
    @Autowired
    private GermplasmMapper germplasmMapper;

    private static final Logger log = LoggerFactory.getLogger(GermplasmServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importGermplasmData(List<Germplasm> importList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(importList) || importList.size() == 0)
        {
            throw new ServiceException("导入analysis数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (Germplasm importAll : importList)
        {
            try
            {
                // 验证是否存在这个用户
                Germplasm i = germplasmMapper.selectGermplasmByGermplasmId(importAll.getGermplasmId());
                if (StringUtils.isNull(i))
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setCreateBy(operName);
                    this.insertGermplasm(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "germplasm_id " + i.getGermplasmId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setUpdateBy(operName);
                    this.updateGermplasm(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "germplasm_id " + i.getGermplasmId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "germplasm_id " + i.getGermplasmId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "germplasm_id " + importAll.getGermplasmId() + " 导入失败：";
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
    public List<Germplasm> selectGermplasmByName(String name) {
        return germplasmMapper.selectGermplasmByName(name);
    }

    @Override
    public List<Germplasm> selectGermplasmListFromPid(Long population_id) {
        return germplasmMapper.selectGermplasmListFromPid(population_id);
    }

    @Override
    public Long selectPopulationId(String name) {
        return germplasmMapper.selectPopulationId(name);
    }

    @Override
    public Map<String, List<String>> SelectorSubGroupGermplasm() {
        List<Germplasm> germplasms = germplasmMapper.SelectorSubGroupGermplasm();

        //与Tissue 中同理
        Map<String, List<String>> g = new HashMap<>();

        for (Germplasm germplasm:germplasms) {
            if (g.get(germplasm.getSubgroup().getName())==null){
                List<String> germNames = new ArrayList<>();
                germNames.add(germplasm.getName());
                g.put(germplasm.getSubgroup().getName(), germNames);
            }else{
                List<String> germNames = g.get(germplasm.getSubgroup().getName());
                germNames.add(germplasm.getName());
            }
        }

        return g;
    }

    /**
     * 查询产品详情
     *
     * @param germplasmId 产品详情主键
     * @return 产品详情
     */
    @Override
    public Germplasm selectGermplasmByGermplasmId(Long germplasmId)
    {
        return germplasmMapper.selectGermplasmByGermplasmId(germplasmId);
    }

    /**
     * 查询产品详情列表
     *
     * @param germplasm 产品详情
     * @return 产品详情
     */
    @Override
    public List<Germplasm> selectGermplasmList(Germplasm germplasm)
    {
        return germplasmMapper.selectGermplasmList(germplasm);
    }

    /**
     * 新增产品详情
     *
     * @param germplasm 产品详情
     * @return 结果
     */
    @Override
    public int insertGermplasm(Germplasm germplasm)
    {
        return germplasmMapper.insertGermplasm(germplasm);
    }

    /**
     * 修改产品详情
     *
     * @param germplasm 产品详情
     * @return 结果
     */
    @Override
    public int updateGermplasm(Germplasm germplasm)
    {
        return germplasmMapper.updateGermplasm(germplasm);
    }

    /**
     * 批量删除产品详情
     *
     * @param germplasmIds 需要删除的产品详情主键
     * @return 结果
     */
    @Override
    public int deleteGermplasmByGermplasmIds(Long[] germplasmIds)
    {
        return germplasmMapper.deleteGermplasmByGermplasmIds(germplasmIds);
    }

    /**
     * 删除产品详情信息
     *
     * @param germplasmId 产品详情主键
     * @return 结果
     */
    @Override
    public int deleteGermplasmByGermplasmId(Long germplasmId)
    {
        return germplasmMapper.deleteGermplasmByGermplasmId(germplasmId);
    }
}
