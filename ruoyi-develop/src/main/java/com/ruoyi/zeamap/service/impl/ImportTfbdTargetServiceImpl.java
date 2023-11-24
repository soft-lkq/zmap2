package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.zeamap.domain.ImportTfbdInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.ImportTfbdTargetMapper;
import com.ruoyi.zeamap.domain.ImportTfbdTarget;
import com.ruoyi.zeamap.service.IImportTfbdTargetService;

import javax.validation.Validator;

/**
 * ImportService业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-09
 */
@Service
public class ImportTfbdTargetServiceImpl implements IImportTfbdTargetService 
{
    @Autowired
    private ImportTfbdTargetMapper importTfbdTargetMapper;

    private static final Logger log = LoggerFactory.getLogger(ImportTfbdTargetServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importTfbdTargetData(List<ImportTfbdTarget> importList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(importList) || importList.size() == 0)
        {
            throw new ServiceException("导入tfbd_target数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ImportTfbdTarget importAll : importList)
        {
            try
            {
                // 验证是否存在这个用户
                ImportTfbdTarget i = importTfbdTargetMapper.selectImportTfbdTargetByTfbdTargetId(importAll.getTfbdTargetId());
                if (StringUtils.isNull(i))
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setCreateBy(operName);
                    this.insertImportTfbdTarget(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "tfbdtarget_id " + i.getTfbdTargetId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setUpdateBy(operName);
                    this.updateImportTfbdTarget(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "tfbdtarget_id " + i.getTfbdTargetId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "tfbdtarget_id " + i.getTfbdTargetId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "tfbdtarget_id " + importAll.getTfbdTargetId() + " 导入失败：";
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
     * 查询Import
     * 
     * @param tfbdTargetId Import主键
     * @return Import
     */
    @Override
    public ImportTfbdTarget selectImportTfbdTargetByTfbdTargetId(Long tfbdTargetId)
    {
        return importTfbdTargetMapper.selectImportTfbdTargetByTfbdTargetId(tfbdTargetId);
    }

    /**
     * 查询Import列表
     * 
     * @param importTfbdTarget Import
     * @return Import
     */
    @Override
    public List<ImportTfbdTarget> selectImportTfbdTargetList(ImportTfbdTarget importTfbdTarget)
    {
        return importTfbdTargetMapper.selectImportTfbdTargetList(importTfbdTarget);
    }

    /**
     * 新增Import
     * 
     * @param importTfbdTarget Import
     * @return 结果
     */
    @Override
    public int insertImportTfbdTarget(ImportTfbdTarget importTfbdTarget)
    {
        return importTfbdTargetMapper.insertImportTfbdTarget(importTfbdTarget);
    }

    /**
     * 修改Import
     * 
     * @param importTfbdTarget Import
     * @return 结果
     */
    @Override
    public int updateImportTfbdTarget(ImportTfbdTarget importTfbdTarget)
    {
        return importTfbdTargetMapper.updateImportTfbdTarget(importTfbdTarget);
    }

    /**
     * 批量删除Import
     * 
     * @param tfbdTargetIds 需要删除的Import主键
     * @return 结果
     */
    @Override
    public int deleteImportTfbdTargetByTfbdTargetIds(Long[] tfbdTargetIds)
    {
        return importTfbdTargetMapper.deleteImportTfbdTargetByTfbdTargetIds(tfbdTargetIds);
    }

    /**
     * 删除Import信息
     * 
     * @param tfbdTargetId Import主键
     * @return 结果
     */
    @Override
    public int deleteImportTfbdTargetByTfbdTargetId(Long tfbdTargetId)
    {
        return importTfbdTargetMapper.deleteImportTfbdTargetByTfbdTargetId(tfbdTargetId);
    }
}
