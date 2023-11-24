package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.zeamap.domain.ImportDbxref;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.ImportXotMapper;
import com.ruoyi.zeamap.domain.ImportXot;
import com.ruoyi.zeamap.service.IImportXotService;

import javax.validation.Validator;

/**
 * 1Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-15
 */
@Service
public class ImportXotServiceImpl implements IImportXotService 
{
    @Autowired
    private ImportXotMapper importXotMapper;

    private static final Logger log = LoggerFactory.getLogger(ImportXotServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importXotData(List<ImportXot> importList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(importList) || importList.size() == 0)
        {
            throw new ServiceException("导入xot数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ImportXot importXot : importList)
        {
            try
            {
                // 验证是否存在这个用户
                ImportXot i = importXotMapper.selectImportXotByXotId(importXot.getXotId());
                if (StringUtils.isNull(i))
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setCreateBy(operName);
                    this.insertImportXot(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "xot_id " + i.getXotId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setUpdateBy(operName);
                    this.updateImportXot(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "xot_id " + i.getXotId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "xot_id " + i.getXotId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "xot_id " + importXot.getXotId() + " 导入失败：";
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
     * @param xotId 1主键
     * @return 1
     */
    @Override
    public ImportXot selectImportXotByXotId(Long xotId)
    {
        return importXotMapper.selectImportXotByXotId(xotId);
    }

    /**
     * 查询1列表
     * 
     * @param importXot 1
     * @return 1
     */
    @Override
    public List<ImportXot> selectImportXotList(ImportXot importXot)
    {
        return importXotMapper.selectImportXotList(importXot);
    }

    /**
     * 新增1
     * 
     * @param importXot 1
     * @return 结果
     */
    @Override
    public int insertImportXot(ImportXot importXot)
    {
        return importXotMapper.insertImportXot(importXot);
    }

    /**
     * 修改1
     * 
     * @param importXot 1
     * @return 结果
     */
    @Override
    public int updateImportXot(ImportXot importXot)
    {
        return importXotMapper.updateImportXot(importXot);
    }

    /**
     * 批量删除1
     * 
     * @param xotIds 需要删除的1主键
     * @return 结果
     */
    @Override
    public int deleteImportXotByXotIds(Long[] xotIds)
    {
        return importXotMapper.deleteImportXotByXotIds(xotIds);
    }

    /**
     * 删除1信息
     * 
     * @param xotId 1主键
     * @return 结果
     */
    @Override
    public int deleteImportXotByXotId(Long xotId)
    {
        return importXotMapper.deleteImportXotByXotId(xotId);
    }
}
