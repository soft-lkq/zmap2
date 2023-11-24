package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.zeamap.domain.ImportFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.ImportFeaturelocMapper;
import com.ruoyi.zeamap.domain.ImportFeatureloc;
import com.ruoyi.zeamap.service.IImportFeaturelocService;

import javax.validation.Validator;

/**
 * ImportFeaturelocService业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-30
 */
@Service
public class ImportFeaturelocServiceImpl implements IImportFeaturelocService 
{
    @Autowired
    private ImportFeaturelocMapper importFeaturelocMapper;

    private static final Logger log = LoggerFactory.getLogger(ImportFeaturelocServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importFeaturelocData(List<ImportFeatureloc> importList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(importList) || importList.size() == 0)
        {
            throw new ServiceException("导入featureloc数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ImportFeatureloc importAll : importList)
        {
            try
            {
                // 验证是否存在这个用户
                ImportFeatureloc i = importFeaturelocMapper.selectImportFeaturelocByFeaturelocId(importAll.getFeaturelocId());
                if (StringUtils.isNull(i))
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setCreateBy(operName);
                    this.insertImportFeatureloc(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "featureloc_id " + i.getFeaturelocId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setUpdateBy(operName);
                    this.updateImportFeatureloc(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "featureloc_id " + i.getFeaturelocId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "featureloc_id " + i.getFeaturelocId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "featureloc_id " + importAll.getFeaturelocId() + " 导入失败：";
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
     * 查询ImportFeatureloc
     * 
     * @param featurelocId ImportFeatureloc主键
     * @return ImportFeatureloc
     */
    @Override
    public ImportFeatureloc selectImportFeaturelocByFeaturelocId(String featurelocId)
    {
        return importFeaturelocMapper.selectImportFeaturelocByFeaturelocId(featurelocId);
    }

    /**
     * 查询ImportFeatureloc列表
     * 
     * @param importFeatureloc ImportFeatureloc
     * @return ImportFeatureloc
     */
    @Override
    public List<ImportFeatureloc> selectImportFeaturelocList(ImportFeatureloc importFeatureloc)
    {
        return importFeaturelocMapper.selectImportFeaturelocList(importFeatureloc);
    }

    /**
     * 新增ImportFeatureloc
     * 
     * @param importFeatureloc ImportFeatureloc
     * @return 结果
     */
    @Override
    public int insertImportFeatureloc(ImportFeatureloc importFeatureloc)
    {
        return importFeaturelocMapper.insertImportFeatureloc(importFeatureloc);
    }

    /**
     * 修改ImportFeatureloc
     * 
     * @param importFeatureloc ImportFeatureloc
     * @return 结果
     */
    @Override
    public int updateImportFeatureloc(ImportFeatureloc importFeatureloc)
    {
        return importFeaturelocMapper.updateImportFeatureloc(importFeatureloc);
    }

    /**
     * 批量删除ImportFeatureloc
     * 
     * @param featurelocIds 需要删除的ImportFeatureloc主键
     * @return 结果
     */
    @Override
    public int deleteImportFeaturelocByFeaturelocIds(String[] featurelocIds)
    {
        return importFeaturelocMapper.deleteImportFeaturelocByFeaturelocIds(featurelocIds);
    }

    /**
     * 删除ImportFeatureloc信息
     * 
     * @param featurelocId ImportFeatureloc主键
     * @return 结果
     */
    @Override
    public int deleteImportFeaturelocByFeaturelocId(String featurelocId)
    {
        return importFeaturelocMapper.deleteImportFeaturelocByFeaturelocId(featurelocId);
    }
}
