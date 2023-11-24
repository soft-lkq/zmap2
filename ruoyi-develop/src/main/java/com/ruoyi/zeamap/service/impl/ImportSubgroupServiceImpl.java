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
import com.ruoyi.zeamap.mapper.ImportSubgroupMapper;
import com.ruoyi.zeamap.domain.ImportSubgroup;
import com.ruoyi.zeamap.service.IImportSubgroupService;

import javax.validation.Validator;

/**
 * ImportService业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-09
 */
@Service
public class ImportSubgroupServiceImpl implements IImportSubgroupService 
{
    @Autowired
    private ImportSubgroupMapper importSubgroupMapper;

    private static final Logger log = LoggerFactory.getLogger(ImportSubgroupServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importSubgroupData(List<ImportSubgroup> importList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(importList) || importList.size() == 0)
        {
            throw new ServiceException("导入subgroup数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ImportSubgroup importAll : importList)
        {
            try
            {
                // 验证是否存在这个用户
                ImportSubgroup i = importSubgroupMapper.selectImportSubgroupBySubgroupId(importAll.getSubgroupId());
                if (StringUtils.isNull(i))
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setCreateBy(operName);
                    this.insertImportSubgroup(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "subgroup_id " + i.getSubgroupId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setUpdateBy(operName);
                    this.updateImportSubgroup(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "subgroup_id " + i.getSubgroupId()+ " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "subgroup_id " + i.getSubgroupId()+ " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "subgroup_id " + importAll.getSubgroupId() + " 导入失败：";
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
     * @param subgroupId Import主键
     * @return Import
     */
    @Override
    public ImportSubgroup selectImportSubgroupBySubgroupId(Long subgroupId)
    {
        return importSubgroupMapper.selectImportSubgroupBySubgroupId(subgroupId);
    }

    /**
     * 查询Import列表
     * 
     * @param importSubgroup Import
     * @return Import
     */
    @Override
    public List<ImportSubgroup> selectImportSubgroupList(ImportSubgroup importSubgroup)
    {
        return importSubgroupMapper.selectImportSubgroupList(importSubgroup);
    }

    /**
     * 新增Import
     * 
     * @param importSubgroup Import
     * @return 结果
     */
    @Override
    public int insertImportSubgroup(ImportSubgroup importSubgroup)
    {
        return importSubgroupMapper.insertImportSubgroup(importSubgroup);
    }

    /**
     * 修改Import
     * 
     * @param importSubgroup Import
     * @return 结果
     */
    @Override
    public int updateImportSubgroup(ImportSubgroup importSubgroup)
    {
        return importSubgroupMapper.updateImportSubgroup(importSubgroup);
    }

    /**
     * 批量删除Import
     * 
     * @param subgroupIds 需要删除的Import主键
     * @return 结果
     */
    @Override
    public int deleteImportSubgroupBySubgroupIds(Long[] subgroupIds)
    {
        return importSubgroupMapper.deleteImportSubgroupBySubgroupIds(subgroupIds);
    }

    /**
     * 删除Import信息
     * 
     * @param subgroupId Import主键
     * @return 结果
     */
    @Override
    public int deleteImportSubgroupBySubgroupId(Long subgroupId)
    {
        return importSubgroupMapper.deleteImportSubgroupBySubgroupId(subgroupId);
    }
}
