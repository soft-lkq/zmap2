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
import com.ruoyi.zeamap.mapper.ImportFeatureMapper;
import com.ruoyi.zeamap.domain.ImportFeature;
import com.ruoyi.zeamap.service.IImportFeatureService;

import javax.validation.Validator;

/**
 * ImportfeatureService业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-22
 */
@Service
public class ImportFeatureServiceImpl implements IImportFeatureService 
{
    @Autowired
    private ImportFeatureMapper importFeatureMapper;

    private static final Logger log = LoggerFactory.getLogger(ImportFeatureServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importFeatureData(List<ImportFeature> importList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(importList) || importList.size() == 0)
        {
            throw new ServiceException("导入feature数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ImportFeature importAll : importList)
        {
            try
            {
                // 验证是否存在这个用户
                ImportFeature i = importFeatureMapper.selectImportFeatureByFeatureId(importAll.getFeatureId());
                if (StringUtils.isNull(i))
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setCreateBy(operName);
                    this.insertImportFeature(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "feature_id " + i.getFeatureId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setUpdateBy(operName);
                    this.updateImportFeature(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "feature_id " + i.getFeatureId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "feature_id " + i.getFeatureId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "tissue_id " + importAll.getFeatureId() + " 导入失败：";
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
     * 查询Importfeature
     * 
     * @param featureId Importfeature主键
     * @return Importfeature
     */
    @Override
    public ImportFeature selectImportFeatureByFeatureId(Long featureId)
    {
        return importFeatureMapper.selectImportFeatureByFeatureId(featureId);
    }

    /**
     * 查询Importfeature列表
     * 
     * @param importFeature Importfeature
     * @return Importfeature
     */
    @Override
    public List<ImportFeature> selectImportFeatureList(ImportFeature importFeature)
    {
        return importFeatureMapper.selectImportFeatureList(importFeature);
    }

    /**
     * 新增Importfeature
     * 
     * @param importFeature Importfeature
     * @return 结果
     */
    @Override
    public int insertImportFeature(ImportFeature importFeature)
    {
        importFeature.setCreateTime(DateUtils.getNowDate());
        return importFeatureMapper.insertImportFeature(importFeature);
    }

    /**
     * 修改Importfeature
     * 
     * @param importFeature Importfeature
     * @return 结果
     */
    @Override
    public int updateImportFeature(ImportFeature importFeature)
    {
        importFeature.setUpdateTime(DateUtils.getNowDate());
        return importFeatureMapper.updateImportFeature(importFeature);
    }

    /**
     * 批量删除Importfeature
     * 
     * @param featureIds 需要删除的Importfeature主键
     * @return 结果
     */
    @Override
    public int deleteImportFeatureByFeatureIds(Long[] featureIds)
    {
        return importFeatureMapper.deleteImportFeatureByFeatureIds(featureIds);
    }

    /**
     * 删除Importfeature信息
     * 
     * @param featureId Importfeature主键
     * @return 结果
     */
    @Override
    public int deleteImportFeatureByFeatureId(Long featureId)
    {
        return importFeatureMapper.deleteImportFeatureByFeatureId(featureId);
    }
}
