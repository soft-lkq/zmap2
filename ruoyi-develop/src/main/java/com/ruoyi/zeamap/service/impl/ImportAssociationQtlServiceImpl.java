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
import com.ruoyi.zeamap.mapper.ImportAssociationQtlMapper;
import com.ruoyi.zeamap.domain.ImportAssociationQtl;
import com.ruoyi.zeamap.service.IImportAssociationQtlService;

import javax.validation.Validator;

/**
 * ImportAqtlService业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-18
 */
@Service
public class ImportAssociationQtlServiceImpl implements IImportAssociationQtlService 
{
    @Autowired
    private ImportAssociationQtlMapper importAssociationQtlMapper;

    private static final Logger log = LoggerFactory.getLogger(ImportAssociationQtlServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importAssociationQtlData(List<ImportAssociationQtl> importList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(importList) || importList.size() == 0)
        {
            throw new ServiceException("导入association_qtl数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ImportAssociationQtl importAssociationQtl : importList)
        {
            try
            {
                // 验证是否存在这个用户
                ImportAssociationQtl i = importAssociationQtlMapper.selectImportAssociationQtlByAssociationQtlId(importAssociationQtl.getAssociationQtlId());
                if (StringUtils.isNull(i))
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setCreateBy(operName);
                    this.insertImportAssociationQtl(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "associationQtl_id " + i.getAssociationQtlId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setUpdateBy(operName);
                    this.updateImportAssociationQtl(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "associationQtl_id " + i.getAssociationQtlId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "associationQtl_id " + i.getAssociationQtlId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "associationQtl_id " + importAssociationQtl.getAssociationQtlId() + " 导入失败：";
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
     * 查询ImportAqtl
     * 
     * @param associationQtlId ImportAqtl主键
     * @return ImportAqtl
     */
    @Override
    public ImportAssociationQtl selectImportAssociationQtlByAssociationQtlId(Long associationQtlId)
    {
        return importAssociationQtlMapper.selectImportAssociationQtlByAssociationQtlId(associationQtlId);
    }

    /**
     * 查询ImportAqtl列表
     * 
     * @param importAssociationQtl ImportAqtl
     * @return ImportAqtl
     */
    @Override
    public List<ImportAssociationQtl> selectImportAssociationQtlList(ImportAssociationQtl importAssociationQtl)
    {
        return importAssociationQtlMapper.selectImportAssociationQtlList(importAssociationQtl);
    }

    /**
     * 新增ImportAqtl
     * 
     * @param importAssociationQtl ImportAqtl
     * @return 结果
     */
    @Override
    public int insertImportAssociationQtl(ImportAssociationQtl importAssociationQtl)
    {
        return importAssociationQtlMapper.insertImportAssociationQtl(importAssociationQtl);
    }

    /**
     * 修改ImportAqtl
     * 
     * @param importAssociationQtl ImportAqtl
     * @return 结果
     */
    @Override
    public int updateImportAssociationQtl(ImportAssociationQtl importAssociationQtl)
    {
        return importAssociationQtlMapper.updateImportAssociationQtl(importAssociationQtl);
    }

    /**
     * 批量删除ImportAqtl
     * 
     * @param associationQtlIds 需要删除的ImportAqtl主键
     * @return 结果
     */
    @Override
    public int deleteImportAssociationQtlByAssociationQtlIds(Long[] associationQtlIds)
    {
        return importAssociationQtlMapper.deleteImportAssociationQtlByAssociationQtlIds(associationQtlIds);
    }

    /**
     * 删除ImportAqtl信息
     * 
     * @param associationQtlId ImportAqtl主键
     * @return 结果
     */
    @Override
    public int deleteImportAssociationQtlByAssociationQtlId(Long associationQtlId)
    {
        return importAssociationQtlMapper.deleteImportAssociationQtlByAssociationQtlId(associationQtlId);
    }
}
