package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.zeamap.domain.ImportTissue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.ImportExpressionMapper;
import com.ruoyi.zeamap.domain.ImportExpression;
import com.ruoyi.zeamap.service.IImportExpressionService;

import javax.validation.Validator;

/**
 * 基因表达量查询Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-22
 */
@Service
public class ImportExpressionServiceImpl implements IImportExpressionService 
{
    @Autowired
    private ImportExpressionMapper importExpressionMapper;

    private static final Logger log = LoggerFactory.getLogger(ImportExpressionServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importExpressionData(List<ImportExpression> importList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(importList) || importList.size() == 0)
        {
            throw new ServiceException("导入expression数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ImportExpression importAll : importList)
        {
            try
            {
                // 验证是否存在这个用户
                ImportExpression i = importExpressionMapper.selectImportExpressionByExpressionId(importAll.getExpressionId());
                if (StringUtils.isNull(i))
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setCreateBy(operName);
                    this.insertImportExpression(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "expression_id " + i.getExpressionId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setUpdateBy(operName);
                    this.updateImportExpression(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "expression_id " + i.getExpressionId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "expression_id " + i.getExpressionId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "expression_id " + importAll.getExpressionId() + " 导入失败：";
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
     * 查询基因表达量查询
     * 
     * @param expressionId 基因表达量查询主键
     * @return 基因表达量查询
     */
    @Override
    public ImportExpression selectImportExpressionByExpressionId(Long expressionId)
    {
        return importExpressionMapper.selectImportExpressionByExpressionId(expressionId);
    }

    /**
     * 查询基因表达量查询列表
     * 
     * @param importExpression 基因表达量查询
     * @return 基因表达量查询
     */
    @Override
    public List<ImportExpression> selectImportExpressionList(ImportExpression importExpression)
    {
        return importExpressionMapper.selectImportExpressionList(importExpression);
    }

    /**
     * 新增基因表达量查询
     * 
     * @param importExpression 基因表达量查询
     * @return 结果
     */
    @Override
    public int insertImportExpression(ImportExpression importExpression)
    {
        importExpression.setCreateTime(DateUtils.getNowDate());
        return importExpressionMapper.insertImportExpression(importExpression);
    }

    /**
     * 修改基因表达量查询
     * 
     * @param importExpression 基因表达量查询
     * @return 结果
     */
    @Override
    public int updateImportExpression(ImportExpression importExpression)
    {
        importExpression.setUpdateTime(DateUtils.getNowDate());
        return importExpressionMapper.updateImportExpression(importExpression);
    }

    /**
     * 批量删除基因表达量查询
     * 
     * @param expressionIds 需要删除的基因表达量查询主键
     * @return 结果
     */
    @Override
    public int deleteImportExpressionByExpressionIds(Long[] expressionIds)
    {
        return importExpressionMapper.deleteImportExpressionByExpressionIds(expressionIds);
    }

    /**
     * 删除基因表达量查询信息
     * 
     * @param expressionId 基因表达量查询主键
     * @return 结果
     */
    @Override
    public int deleteImportExpressionByExpressionId(Long expressionId)
    {
        return importExpressionMapper.deleteImportExpressionByExpressionId(expressionId);
    }
}
