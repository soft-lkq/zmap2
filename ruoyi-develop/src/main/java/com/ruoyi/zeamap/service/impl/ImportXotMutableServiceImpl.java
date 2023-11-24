package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.zeamap.domain.ImportMutable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.ImportXotMutableMapper;
import com.ruoyi.zeamap.domain.ImportXotMutable;
import com.ruoyi.zeamap.service.IImportXotMutableService;

import javax.validation.Validator;

/**
 * ImportXot_mutableService业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-15
 */
@Service
public class ImportXotMutableServiceImpl implements IImportXotMutableService 
{
    @Autowired
    private ImportXotMutableMapper importXotMutableMapper;

    private static final Logger log = LoggerFactory.getLogger(ImportXotMutableServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importXotMutableData(List<ImportXotMutable> importList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(importList) || importList.size() == 0)
        {
            throw new ServiceException("导入xot_mutable数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ImportXotMutable importXotMutable : importList)
        {
            try
            {
                // 验证是否存在这个用户
                ImportXotMutable i = importXotMutableMapper.selectImportXotMutableByXotMutableId(importXotMutable.getXotMutableId());
                if (StringUtils.isNull(i))
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setCreateBy(operName);
                    this.insertImportXotMutable(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "xotmutable_id " + i.getXotMutableId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setUpdateBy(operName);
                    this.updateImportXotMutable(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "xotmutable_id " + i.getXotMutableId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "xotmutable_id " + i.getXotMutableId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "xotmutable_id " + importXotMutable.getXotMutableId() + " 导入失败：";
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
     * 查询ImportXot_mutable
     * 
     * @param xotMutableId ImportXot_mutable主键
     * @return ImportXot_mutable
     */
    @Override
    public ImportXotMutable selectImportXotMutableByXotMutableId(Long xotMutableId)
    {
        return importXotMutableMapper.selectImportXotMutableByXotMutableId(xotMutableId);
    }

    /**
     * 查询ImportXot_mutable列表
     * 
     * @param importXotMutable ImportXot_mutable
     * @return ImportXot_mutable
     */
    @Override
    public List<ImportXotMutable> selectImportXotMutableList(ImportXotMutable importXotMutable)
    {
        return importXotMutableMapper.selectImportXotMutableList(importXotMutable);
    }

    /**
     * 新增ImportXot_mutable
     * 
     * @param importXotMutable ImportXot_mutable
     * @return 结果
     */
    @Override
    public int insertImportXotMutable(ImportXotMutable importXotMutable)
    {
        return importXotMutableMapper.insertImportXotMutable(importXotMutable);
    }

    /**
     * 修改ImportXot_mutable
     * 
     * @param importXotMutable ImportXot_mutable
     * @return 结果
     */
    @Override
    public int updateImportXotMutable(ImportXotMutable importXotMutable)
    {
        return importXotMutableMapper.updateImportXotMutable(importXotMutable);
    }

    /**
     * 批量删除ImportXot_mutable
     * 
     * @param xotMutableIds 需要删除的ImportXot_mutable主键
     * @return 结果
     */
    @Override
    public int deleteImportXotMutableByXotMutableIds(Long[] xotMutableIds)
    {
        return importXotMutableMapper.deleteImportXotMutableByXotMutableIds(xotMutableIds);
    }

    /**
     * 删除ImportXot_mutable信息
     * 
     * @param xotMutableId ImportXot_mutable主键
     * @return 结果
     */
    @Override
    public int deleteImportXotMutableByXotMutableId(Long xotMutableId)
    {
        return importXotMutableMapper.deleteImportXotMutableByXotMutableId(xotMutableId);
    }
}
