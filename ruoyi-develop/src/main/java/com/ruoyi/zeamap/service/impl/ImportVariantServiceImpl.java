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
import com.ruoyi.zeamap.mapper.ImportVariantMapper;
import com.ruoyi.zeamap.domain.ImportVariant;
import com.ruoyi.zeamap.service.IImportVariantService;

import javax.validation.Validator;

/**
 * ImportVariantService业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-16
 */
@Service
public class ImportVariantServiceImpl implements IImportVariantService 
{
    @Autowired
    private ImportVariantMapper importVariantMapper;


    private static final Logger log = LoggerFactory.getLogger(ImportVariantServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importVariantData(List<ImportVariant> importList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(importList) || importList.size() == 0)
        {
            throw new ServiceException("导入variant数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ImportVariant importVariant : importList)
        {
            try
            {
                // 验证是否存在这个用户
                ImportVariant i = importVariantMapper.selectImportVariantByVariantId(importVariant.getVariantId());
                if (StringUtils.isNull(i))
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setCreateBy(operName);
                    this.insertImportVariant(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "variant_id " + i.getVariantId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setUpdateBy(operName);
                    this.updateImportVariant(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "variant_id " + i.getVariantId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "variant_id " + i.getVariantId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "variant_id " + importVariant.getVariantId() + " 导入失败：";
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
     * 查询ImportVariant
     * 
     * @param variantId ImportVariant主键
     * @return ImportVariant
     */
    @Override
    public ImportVariant selectImportVariantByVariantId(String variantId)
    {
        return importVariantMapper.selectImportVariantByVariantId(variantId);
    }

    /**
     * 查询ImportVariant列表
     * 
     * @param importVariant ImportVariant
     * @return ImportVariant
     */
    @Override
    public List<ImportVariant> selectImportVariantList(ImportVariant importVariant)
    {
        return importVariantMapper.selectImportVariantList(importVariant);
    }

    /**
     * 新增ImportVariant
     * 
     * @param importVariant ImportVariant
     * @return 结果
     */
    @Override
    public int insertImportVariant(ImportVariant importVariant)
    {
        return importVariantMapper.insertImportVariant(importVariant);
    }

    /**
     * 修改ImportVariant
     * 
     * @param importVariant ImportVariant
     * @return 结果
     */
    @Override
    public int updateImportVariant(ImportVariant importVariant)
    {
        return importVariantMapper.updateImportVariant(importVariant);
    }

    /**
     * 批量删除ImportVariant
     * 
     * @param variantIds 需要删除的ImportVariant主键
     * @return 结果
     */
    @Override
    public int deleteImportVariantByVariantIds(String[] variantIds)
    {
        return importVariantMapper.deleteImportVariantByVariantIds(variantIds);
    }

    /**
     * 删除ImportVariant信息
     * 
     * @param variantId ImportVariant主键
     * @return 结果
     */
    @Override
    public int deleteImportVariantByVariantId(String variantId)
    {
        return importVariantMapper.deleteImportVariantByVariantId(variantId);
    }
}
