package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.zeamap.domain.ImportVariant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.ImportTissueMapper;
import com.ruoyi.zeamap.domain.ImportTissue;
import com.ruoyi.zeamap.service.IImportTissueService;

import javax.validation.Validator;

/**
 * 组织Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-22
 */
@Service
public class ImportTissueServiceImpl implements IImportTissueService 
{
    @Autowired
    private ImportTissueMapper importTissueMapper;

    private static final Logger log = LoggerFactory.getLogger(ImportTissueServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importTissueData(List<ImportTissue> importList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(importList) || importList.size() == 0)
        {
            throw new ServiceException("导入tissue数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ImportTissue importAll : importList)
        {
            try
            {
                // 验证是否存在这个用户
                ImportTissue i = importTissueMapper.selectImportTissueByTissueId(importAll.getTissueId());
                if (StringUtils.isNull(i))
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setCreateBy(operName);
                    this.insertImportTissue(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "tissue_id " + i.getTissueId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setUpdateBy(operName);
                    this.updateImportTissue(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "tissue_id " + i.getTissueId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "tissue_id " + i.getTissueId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "tissue_id " + importAll.getTissueId() + " 导入失败：";
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
     * 查询组织
     * 
     * @param tissueId 组织主键
     * @return 组织
     */
    @Override
    public ImportTissue selectImportTissueByTissueId(Long tissueId)
    {
        return importTissueMapper.selectImportTissueByTissueId(tissueId);
    }

    /**
     * 查询组织列表
     * 
     * @param importTissue 组织
     * @return 组织
     */
    @Override
    public List<ImportTissue> selectImportTissueList(ImportTissue importTissue)
    {
        return importTissueMapper.selectImportTissueList(importTissue);
    }

    /**
     * 新增组织
     * 
     * @param importTissue 组织
     * @return 结果
     */
    @Override
    public int insertImportTissue(ImportTissue importTissue)
    {
        importTissue.setCreateTime(DateUtils.getNowDate());
        return importTissueMapper.insertImportTissue(importTissue);
    }

    /**
     * 修改组织
     * 
     * @param importTissue 组织
     * @return 结果
     */
    @Override
    public int updateImportTissue(ImportTissue importTissue)
    {
        importTissue.setUpdateTime(DateUtils.getNowDate());
        return importTissueMapper.updateImportTissue(importTissue);
    }

    /**
     * 批量删除组织
     * 
     * @param tissueIds 需要删除的组织主键
     * @return 结果
     */
    @Override
    public int deleteImportTissueByTissueIds(Long[] tissueIds)
    {
        return importTissueMapper.deleteImportTissueByTissueIds(tissueIds);
    }

    /**
     * 删除组织信息
     * 
     * @param tissueId 组织主键
     * @return 结果
     */
    @Override
    public int deleteImportTissueByTissueId(Long tissueId)
    {
        return importTissueMapper.deleteImportTissueByTissueId(tissueId);
    }
}
