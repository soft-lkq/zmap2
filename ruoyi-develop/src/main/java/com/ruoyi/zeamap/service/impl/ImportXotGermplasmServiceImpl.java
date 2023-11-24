package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.zeamap.domain.ImportXotMutable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.ImportXotGermplasmMapper;
import com.ruoyi.zeamap.domain.ImportXotGermplasm;
import com.ruoyi.zeamap.service.IImportXotGermplasmService;

import javax.validation.Validator;

/**
 * importService业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-11
 */
@Service
public class ImportXotGermplasmServiceImpl implements IImportXotGermplasmService 
{
    @Autowired
    private ImportXotGermplasmMapper importXotGermplasmMapper;

    private static final Logger log = LoggerFactory.getLogger(ImportXotMutableServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importXotGermplasmData(List<ImportXotGermplasm> importList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(importList) || importList.size() == 0)
        {
            throw new ServiceException("导入xot_germplasm数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ImportXotGermplasm importXotGermplasm : importList)
        {
            try
            {
                // 验证是否存在这个用户
                ImportXotGermplasm i = importXotGermplasmMapper.selectImportXotGermplasmByXotGermplasmId(importXotGermplasm.getXotGermplasmId());
                if (StringUtils.isNull(i))
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setCreateBy(operName);
                    this.insertImportXotGermplasm(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "xotgermplasm_id " + i.getXotGermplasmId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setUpdateBy(operName);
                    this.updateImportXotGermplasm(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "xotgermplasm_id " + i.getXotGermplasmId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "xotgermplasm_id " + i.getXotGermplasmId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "xotgermplasm_id " + importXotGermplasm.getXotGermplasmId()+ " 导入失败：";
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
     * 查询import
     * 
     * @param xotGermplasmId import主键
     * @return import
     */
    @Override
    public ImportXotGermplasm selectImportXotGermplasmByXotGermplasmId(Long xotGermplasmId)
    {
        return importXotGermplasmMapper.selectImportXotGermplasmByXotGermplasmId(xotGermplasmId);
    }

    /**
     * 查询import列表
     * 
     * @param importXotGermplasm import
     * @return import
     */
    @Override
    public List<ImportXotGermplasm> selectImportXotGermplasmList(ImportXotGermplasm importXotGermplasm)
    {
        return importXotGermplasmMapper.selectImportXotGermplasmList(importXotGermplasm);
    }

    /**
     * 新增import
     * 
     * @param importXotGermplasm import
     * @return 结果
     */
    @Override
    public int insertImportXotGermplasm(ImportXotGermplasm importXotGermplasm)
    {
        return importXotGermplasmMapper.insertImportXotGermplasm(importXotGermplasm);
    }

    /**
     * 修改import
     * 
     * @param importXotGermplasm import
     * @return 结果
     */
    @Override
    public int updateImportXotGermplasm(ImportXotGermplasm importXotGermplasm)
    {
        return importXotGermplasmMapper.updateImportXotGermplasm(importXotGermplasm);
    }

    /**
     * 批量删除import
     * 
     * @param xotGermplasmIds 需要删除的import主键
     * @return 结果
     */
    @Override
    public int deleteImportXotGermplasmByXotGermplasmIds(Long[] xotGermplasmIds)
    {
        return importXotGermplasmMapper.deleteImportXotGermplasmByXotGermplasmIds(xotGermplasmIds);
    }

    /**
     * 删除import信息
     * 
     * @param xotGermplasmId import主键
     * @return 结果
     */
    @Override
    public int deleteImportXotGermplasmByXotGermplasmId(Long xotGermplasmId)
    {
        return importXotGermplasmMapper.deleteImportXotGermplasmByXotGermplasmId(xotGermplasmId);
    }
}
