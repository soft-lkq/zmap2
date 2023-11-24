package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.zeamap.domain.ImportCv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.ImportCvtermMapper;
import com.ruoyi.zeamap.domain.ImportCvterm;
import com.ruoyi.zeamap.service.IImportCvtermService;

import javax.validation.Validator;

/**
 * ImportCvtermService业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-30
 */
@Service
public class ImportCvtermServiceImpl implements IImportCvtermService 
{
    @Autowired
    private ImportCvtermMapper importCvtermMapper;

    private static final Logger log = LoggerFactory.getLogger(ImportCvtermServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importCvtermData(List<ImportCvterm> importList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(importList) || importList.size() == 0)
        {
            throw new ServiceException("导入cv数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ImportCvterm importAll : importList)
        {
            try
            {
                // 验证是否存在这个用户
                ImportCvterm i = importCvtermMapper.selectImportCvtermByCvtermId(importAll.getCvtermId());
                if (StringUtils.isNull(i))
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setCreateBy(operName);
                    this.insertImportCvterm(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "cvterm_id " + i.getCvtermId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setUpdateBy(operName);
                    this.updateImportCvterm(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "cvterm_id " + i.getCvtermId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "cvterm_id " + i.getCvtermId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "cvterm_id " + importAll.getCvtermId() + " 导入失败：";
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
     * 查询ImportCvterm
     * 
     * @param cvtermId ImportCvterm主键
     * @return ImportCvterm
     */
    @Override
    public ImportCvterm selectImportCvtermByCvtermId(String cvtermId)
    {
        return importCvtermMapper.selectImportCvtermByCvtermId(cvtermId);
    }

    /**
     * 查询ImportCvterm列表
     * 
     * @param importCvterm ImportCvterm
     * @return ImportCvterm
     */
    @Override
    public List<ImportCvterm> selectImportCvtermList(ImportCvterm importCvterm)
    {
        return importCvtermMapper.selectImportCvtermList(importCvterm);
    }

    /**
     * 新增ImportCvterm
     * 
     * @param importCvterm ImportCvterm
     * @return 结果
     */
    @Override
    public int insertImportCvterm(ImportCvterm importCvterm)
    {
        return importCvtermMapper.insertImportCvterm(importCvterm);
    }

    /**
     * 修改ImportCvterm
     * 
     * @param importCvterm ImportCvterm
     * @return 结果
     */
    @Override
    public int updateImportCvterm(ImportCvterm importCvterm)
    {
        return importCvtermMapper.updateImportCvterm(importCvterm);
    }

    /**
     * 批量删除ImportCvterm
     * 
     * @param cvtermIds 需要删除的ImportCvterm主键
     * @return 结果
     */
    @Override
    public int deleteImportCvtermByCvtermIds(String[] cvtermIds)
    {
        return importCvtermMapper.deleteImportCvtermByCvtermIds(cvtermIds);
    }

    /**
     * 删除ImportCvterm信息
     * 
     * @param cvtermId ImportCvterm主键
     * @return 结果
     */
    @Override
    public int deleteImportCvtermByCvtermId(String cvtermId)
    {
        return importCvtermMapper.deleteImportCvtermByCvtermId(cvtermId);
    }
}
