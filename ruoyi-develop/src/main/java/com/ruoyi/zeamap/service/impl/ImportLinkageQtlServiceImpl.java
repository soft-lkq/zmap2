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
import com.ruoyi.zeamap.mapper.ImportLinkageQtlMapper;
import com.ruoyi.zeamap.domain.ImportLinkageQtl;
import com.ruoyi.zeamap.service.IImportLinkageQtlService;

import javax.validation.Validator;

/**
 * ImportLqtlService业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-20
 */
@Service
public class ImportLinkageQtlServiceImpl implements IImportLinkageQtlService 
{
    @Autowired
    private ImportLinkageQtlMapper importLinkageQtlMapper;

    private static final Logger log = LoggerFactory.getLogger(ImportLinkageQtlServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importLinkageQtlData(List<ImportLinkageQtl> importList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(importList) || importList.size() == 0)
        {
            throw new ServiceException("导入linkage_qtl数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ImportLinkageQtl importLinkageQtl : importList)
        {
            try
            {
                // 验证是否存在这个用户
                ImportLinkageQtl i = importLinkageQtlMapper.selectImportLinkageQtlByLinkageQtlId(importLinkageQtl.getLinkageQtlId());
                if (StringUtils.isNull(i))
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setCreateBy(operName);
                    this.insertImportLinkageQtl(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "linkageQtl_id " + i.getLinkageQtlId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setUpdateBy(operName);
                    this.updateImportLinkageQtl(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "linkageQtl_id " + i.getLinkageQtlId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "linkageQtl_id " + i.getLinkageQtlId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "linkageQtl_id " + importLinkageQtl.getLinkageQtlId() + " 导入失败：";
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
     * 查询ImportLqtl
     * 
     * @param linkageQtlId ImportLqtl主键
     * @return ImportLqtl
     */
    @Override
    public ImportLinkageQtl selectImportLinkageQtlByLinkageQtlId(Long linkageQtlId)
    {
        return importLinkageQtlMapper.selectImportLinkageQtlByLinkageQtlId(linkageQtlId);
    }

    /**
     * 查询ImportLqtl列表
     * 
     * @param importLinkageQtl ImportLqtl
     * @return ImportLqtl
     */
    @Override
    public List<ImportLinkageQtl> selectImportLinkageQtlList(ImportLinkageQtl importLinkageQtl)
    {
        return importLinkageQtlMapper.selectImportLinkageQtlList(importLinkageQtl);
    }

    /**
     * 新增ImportLqtl
     * 
     * @param importLinkageQtl ImportLqtl
     * @return 结果
     */
    @Override
    public int insertImportLinkageQtl(ImportLinkageQtl importLinkageQtl)
    {
        return importLinkageQtlMapper.insertImportLinkageQtl(importLinkageQtl);
    }

    /**
     * 修改ImportLqtl
     * 
     * @param importLinkageQtl ImportLqtl
     * @return 结果
     */
    @Override
    public int updateImportLinkageQtl(ImportLinkageQtl importLinkageQtl)
    {
        return importLinkageQtlMapper.updateImportLinkageQtl(importLinkageQtl);
    }

    /**
     * 批量删除ImportLqtl
     * 
     * @param linkageQtlIds 需要删除的ImportLqtl主键
     * @return 结果
     */
    @Override
    public int deleteImportLinkageQtlByLinkageQtlIds(Long[] linkageQtlIds)
    {
        return importLinkageQtlMapper.deleteImportLinkageQtlByLinkageQtlIds(linkageQtlIds);
    }

    /**
     * 删除ImportLqtl信息
     * 
     * @param linkageQtlId ImportLqtl主键
     * @return 结果
     */
    @Override
    public int deleteImportLinkageQtlByLinkageQtlId(Long linkageQtlId)
    {
        return importLinkageQtlMapper.deleteImportLinkageQtlByLinkageQtlId(linkageQtlId);
    }
}
