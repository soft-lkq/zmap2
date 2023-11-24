package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.zeamap.domain.ImportExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.ImportEnvironmentMapper;
import com.ruoyi.zeamap.domain.ImportEnvironment;
import com.ruoyi.zeamap.service.IImportEnvironmentService;

import javax.validation.Validator;

/**
 * ImportEnvironmentService业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-09
 */
@Service
public class ImportEnvironmentServiceImpl implements IImportEnvironmentService 
{
    @Autowired
    private ImportEnvironmentMapper importEnvironmentMapper;

    private static final Logger log = LoggerFactory.getLogger(ImportEnvironmentServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importEnvironmentData(List<ImportEnvironment> importList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(importList) || importList.size() == 0)
        {
            throw new ServiceException("导入environment数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ImportEnvironment importAll : importList)
        {
            try
            {
                // 验证是否存在这个用户
                ImportEnvironment i = importEnvironmentMapper.selectImportEnvironmentByEnvironmentId(importAll.getEnvironmentId());
                if (StringUtils.isNull(i))
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setCreateBy(operName);
                    this.insertImportEnvironment(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "environment_id " + i.getEnvironmentId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setUpdateBy(operName);
                    this.updateImportEnvironment(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "environment_id " + i.getEnvironmentId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "environment_id " + i.getEnvironmentId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "environment_id " + importAll.getEnvironmentId() + " 导入失败：";
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

    /**
     * 查询ImportEnvironment
     * 
     * @param environmentId ImportEnvironment主键
     * @return ImportEnvironment
     */
    @Override
    public ImportEnvironment selectImportEnvironmentByEnvironmentId(Long environmentId)
    {
        return importEnvironmentMapper.selectImportEnvironmentByEnvironmentId(environmentId);
    }

    /**
     * 查询ImportEnvironment列表
     * 
     * @param importEnvironment ImportEnvironment
     * @return ImportEnvironment
     */
    @Override
    public List<ImportEnvironment> selectImportEnvironmentList(ImportEnvironment importEnvironment)
    {
        return importEnvironmentMapper.selectImportEnvironmentList(importEnvironment);
    }

    /**
     * 新增ImportEnvironment
     * 
     * @param importEnvironment ImportEnvironment
     * @return 结果
     */
    @Override
    public int insertImportEnvironment(ImportEnvironment importEnvironment)
    {
        importEnvironment.setCreateTime(DateUtils.getNowDate());
        return importEnvironmentMapper.insertImportEnvironment(importEnvironment);
    }

    /**
     * 修改ImportEnvironment
     * 
     * @param importEnvironment ImportEnvironment
     * @return 结果
     */
    @Override
    public int updateImportEnvironment(ImportEnvironment importEnvironment)
    {
        importEnvironment.setUpdateTime(DateUtils.getNowDate());
        return importEnvironmentMapper.updateImportEnvironment(importEnvironment);
    }

    /**
     * 批量删除ImportEnvironment
     * 
     * @param environmentIds 需要删除的ImportEnvironment主键
     * @return 结果
     */
    @Override
    public int deleteImportEnvironmentByEnvironmentIds(Long[] environmentIds)
    {
        return importEnvironmentMapper.deleteImportEnvironmentByEnvironmentIds(environmentIds);
    }

    /**
     * 删除ImportEnvironment信息
     * 
     * @param environmentId ImportEnvironment主键
     * @return 结果
     */
    @Override
    public int deleteImportEnvironmentByEnvironmentId(Long environmentId)
    {
        return importEnvironmentMapper.deleteImportEnvironmentByEnvironmentId(environmentId);
    }
}
