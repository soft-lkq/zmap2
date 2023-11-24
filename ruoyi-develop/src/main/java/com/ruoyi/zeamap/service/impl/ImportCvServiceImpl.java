package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.zeamap.domain.ImportFeatureloc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.ImportCvMapper;
import com.ruoyi.zeamap.domain.ImportCv;
import com.ruoyi.zeamap.service.IImportCvService;

import javax.validation.Validator;

/**
 * ImportCvService业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-30
 */
@Service
public class ImportCvServiceImpl implements IImportCvService 
{
    @Autowired
    private ImportCvMapper importCvMapper;

    private static final Logger log = LoggerFactory.getLogger(ImportCvServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importCvData(List<ImportCv> importList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(importList) || importList.size() == 0)
        {
            throw new ServiceException("导入cv数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ImportCv importAll : importList)
        {
            try
            {
                // 验证是否存在这个用户
                ImportCv i = importCvMapper.selectImportCvByCvId(importAll.getCvId());
                if (StringUtils.isNull(i))
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setCreateBy(operName);
                    this.insertImportCv(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "cv_id " + i.getCvId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setUpdateBy(operName);
                    this.updateImportCv(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "cv_id " + i.getCvId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "cv_id " + i.getCvId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "cv_id " + importAll.getCvId() + " 导入失败：";
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
     * 查询ImportCv
     * 
     * @param cvId ImportCv主键
     * @return ImportCv
     */
    @Override
    public ImportCv selectImportCvByCvId(String cvId)
    {
        return importCvMapper.selectImportCvByCvId(cvId);
    }

    /**
     * 查询ImportCv列表
     * 
     * @param importCv ImportCv
     * @return ImportCv
     */
    @Override
    public List<ImportCv> selectImportCvList(ImportCv importCv)
    {
        return importCvMapper.selectImportCvList(importCv);
    }

    /**
     * 新增ImportCv
     * 
     * @param importCv ImportCv
     * @return 结果
     */
    @Override
    public int insertImportCv(ImportCv importCv)
    {
        return importCvMapper.insertImportCv(importCv);
    }

    /**
     * 修改ImportCv
     * 
     * @param importCv ImportCv
     * @return 结果
     */
    @Override
    public int updateImportCv(ImportCv importCv)
    {
        return importCvMapper.updateImportCv(importCv);
    }

    /**
     * 批量删除ImportCv
     * 
     * @param cvIds 需要删除的ImportCv主键
     * @return 结果
     */
    @Override
    public int deleteImportCvByCvIds(String[] cvIds)
    {
        return importCvMapper.deleteImportCvByCvIds(cvIds);
    }

    /**
     * 删除ImportCv信息
     * 
     * @param cvId ImportCv主键
     * @return 结果
     */
    @Override
    public int deleteImportCvByCvId(String cvId)
    {
        return importCvMapper.deleteImportCvByCvId(cvId);
    }
}
