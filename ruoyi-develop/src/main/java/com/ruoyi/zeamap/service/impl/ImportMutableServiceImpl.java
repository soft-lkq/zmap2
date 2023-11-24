package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.zeamap.domain.ImportXot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.ImportMutableMapper;
import com.ruoyi.zeamap.domain.ImportMutable;
import com.ruoyi.zeamap.service.IImportMutableService;

import javax.validation.Validator;

/**
 * ImportMutableService业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-15
 */
@Service
public class ImportMutableServiceImpl implements IImportMutableService 
{
    @Autowired
    private ImportMutableMapper importMutableMapper;

    private static final Logger log = LoggerFactory.getLogger(ImportMutableServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importMutableData(List<ImportMutable> importList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(importList) || importList.size() == 0)
        {
            throw new ServiceException("导入mutable数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ImportMutable importMutable : importList)
        {
            try
            {
                // 验证是否存在这个用户
                ImportMutable i = importMutableMapper.selectImportMutableByMutableId(importMutable.getMutableId());
                if (StringUtils.isNull(i))
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setCreateBy(operName);
                    this.insertImportMutable(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "mutable_id " + i.getMutableId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setUpdateBy(operName);
                    this.updateImportMutable(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "mutable_id " + i.getMutableId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "mutable_id " + i.getMutableId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "mutable_id " + importMutable.getMutableId() + " 导入失败：";
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
     * 查询ImportMutable
     * 
     * @param mutableId ImportMutable主键
     * @return ImportMutable
     */
    @Override
    public ImportMutable selectImportMutableByMutableId(Long mutableId)
    {
        return importMutableMapper.selectImportMutableByMutableId(mutableId);
    }

    /**
     * 查询ImportMutable列表
     * 
     * @param importMutable ImportMutable
     * @return ImportMutable
     */
    @Override
    public List<ImportMutable> selectImportMutableList(ImportMutable importMutable)
    {
        return importMutableMapper.selectImportMutableList(importMutable);
    }

    /**
     * 新增ImportMutable
     * 
     * @param importMutable ImportMutable
     * @return 结果
     */
    @Override
    public int insertImportMutable(ImportMutable importMutable)
    {
        return importMutableMapper.insertImportMutable(importMutable);
    }

    /**
     * 修改ImportMutable
     * 
     * @param importMutable ImportMutable
     * @return 结果
     */
    @Override
    public int updateImportMutable(ImportMutable importMutable)
    {
        return importMutableMapper.updateImportMutable(importMutable);
    }

    /**
     * 批量删除ImportMutable
     * 
     * @param mutableIds 需要删除的ImportMutable主键
     * @return 结果
     */
    @Override
    public int deleteImportMutableByMutableIds(Long[] mutableIds)
    {
        return importMutableMapper.deleteImportMutableByMutableIds(mutableIds);
    }

    /**
     * 删除ImportMutable信息
     * 
     * @param mutableId ImportMutable主键
     * @return 结果
     */
    @Override
    public int deleteImportMutableByMutableId(Long mutableId)
    {
        return importMutableMapper.deleteImportMutableByMutableId(mutableId);
    }
}
