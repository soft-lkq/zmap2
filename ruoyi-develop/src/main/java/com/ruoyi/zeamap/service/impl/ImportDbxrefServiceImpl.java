package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.ImportDbxrefMapper;
import com.ruoyi.zeamap.domain.ImportDbxref;
import com.ruoyi.zeamap.service.IImportDbxrefService;

import javax.validation.Validator;

/**
 * 1Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-14
 */
@Service
public class ImportDbxrefServiceImpl implements IImportDbxrefService 
{
    @Autowired
    private ImportDbxrefMapper importDbxrefMapper;

    private static final Logger log = LoggerFactory.getLogger(ImportDbxrefServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importDbxrefData(List<ImportDbxref> importDbxrefList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(importDbxrefList) || importDbxrefList.size() == 0)
        {
            throw new ServiceException("导入dbxref数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ImportDbxref importDbxref : importDbxrefList)
        {
            try
            {
                // 验证是否存在这个用户
                ImportDbxref i = importDbxrefMapper.selectImportDbxrefByDbxrefId(importDbxref.getDbxrefId());
                if (StringUtils.isNull(i))
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setCreateBy(operName);
                    this.insertImportDbxref(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "dbxref_id " + i.getDbxrefId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setUpdateBy(operName);
                    this.updateImportDbxref(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "dbxref_id " + i.getDbxrefId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "dbxref_id " + i.getDbxrefId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "dbxref_id " + importDbxref.getDbxrefId() + " 导入失败：";
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
     * 查询1
     * 
     * @param dbxrefId 1主键
     * @return 1
     */
    @Override
    public ImportDbxref selectImportDbxrefByDbxrefId(Long dbxrefId)
    {
        return importDbxrefMapper.selectImportDbxrefByDbxrefId(dbxrefId);
    }

    /**
     * 查询1列表
     * 
     * @param importDbxref 1
     * @return 1
     */
    @Override
    public List<ImportDbxref> selectImportDbxrefList(ImportDbxref importDbxref)
    {
        return importDbxrefMapper.selectImportDbxrefList(importDbxref);
    }

    /**
     * 新增1
     * 
     * @param importDbxref 1
     * @return 结果
     */
    @Override
    public int insertImportDbxref(ImportDbxref importDbxref)
    {
        return importDbxrefMapper.insertImportDbxref(importDbxref);
    }

    /**
     * 修改1
     * 
     * @param importDbxref 1
     * @return 结果
     */
    @Override
    public int updateImportDbxref(ImportDbxref importDbxref)
    {
        return importDbxrefMapper.updateImportDbxref(importDbxref);
    }

    /**
     * 批量删除1
     * 
     * @param dbxrefIds 需要删除的1主键
     * @return 结果
     */
    @Override
    public int deleteImportDbxrefByDbxrefIds(Long[] dbxrefIds)
    {
        return importDbxrefMapper.deleteImportDbxrefByDbxrefIds(dbxrefIds);
    }

    /**
     * 删除1信息
     * 
     * @param dbxrefId 1主键
     * @return 结果
     */
    @Override
    public int deleteImportDbxrefByDbxrefId(Long dbxrefId)
    {
        return importDbxrefMapper.deleteImportDbxrefByDbxrefId(dbxrefId);
    }
}
