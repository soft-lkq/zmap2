package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.zeamap.domain.ImportAssociationQtl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.ImportAssociationMarkerMapper;
import com.ruoyi.zeamap.domain.ImportAssociationMarker;
import com.ruoyi.zeamap.service.IImportAssociationMarkerService;

import javax.validation.Validator;

/**
 * ImportService业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-21
 */
@Service
public class ImportAssociationMarkerServiceImpl implements IImportAssociationMarkerService 
{
    @Autowired
    private ImportAssociationMarkerMapper importAssociationMarkerMapper;

    private static final Logger log = LoggerFactory.getLogger(ImportAssociationMarkerServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importAssociationMarkerData(List<ImportAssociationMarker> importList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(importList) || importList.size() == 0)
        {
            throw new ServiceException("导入association_marker数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ImportAssociationMarker importAssociationMarker : importList)
        {
            try
            {
                // 验证是否存在这个用户
                ImportAssociationMarker i = importAssociationMarkerMapper.selectImportAssociationMarkerByAssociationMarkerId(importAssociationMarker.getAssociationMarkerId());
                if (StringUtils.isNull(i))
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setCreateBy(operName);
                    this.insertImportAssociationMarker(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "associationQtl_marker " + i.getAssociationMarkerId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setUpdateBy(operName);
                    this.updateImportAssociationMarker(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "associationQtl_marker " + i.getAssociationMarkerId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "associationQtl_marker " + i.getAssociationMarkerId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "associationQtl_marker " + importAssociationMarker.getAssociationMarkerId()+ " 导入失败：";
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
     * @param associationMarkerId Import主键
     * @return Import
     */
    @Override
    public ImportAssociationMarker selectImportAssociationMarkerByAssociationMarkerId(Long associationMarkerId)
    {
        return importAssociationMarkerMapper.selectImportAssociationMarkerByAssociationMarkerId(associationMarkerId);
    }

    /**
     * 查询Import列表
     * 
     * @param importAssociationMarker Import
     * @return Import
     */
    @Override
    public List<ImportAssociationMarker> selectImportAssociationMarkerList(ImportAssociationMarker importAssociationMarker)
    {
        return importAssociationMarkerMapper.selectImportAssociationMarkerList(importAssociationMarker);
    }

    /**
     * 新增Import
     * 
     * @param importAssociationMarker Import
     * @return 结果
     */
    @Override
    public int insertImportAssociationMarker(ImportAssociationMarker importAssociationMarker)
    {
        return importAssociationMarkerMapper.insertImportAssociationMarker(importAssociationMarker);
    }

    /**
     * 修改Import
     * 
     * @param importAssociationMarker Import
     * @return 结果
     */
    @Override
    public int updateImportAssociationMarker(ImportAssociationMarker importAssociationMarker)
    {
        return importAssociationMarkerMapper.updateImportAssociationMarker(importAssociationMarker);
    }

    /**
     * 批量删除Import
     * 
     * @param associationMarkerIds 需要删除的Import主键
     * @return 结果
     */
    @Override
    public int deleteImportAssociationMarkerByAssociationMarkerIds(Long[] associationMarkerIds)
    {
        return importAssociationMarkerMapper.deleteImportAssociationMarkerByAssociationMarkerIds(associationMarkerIds);
    }

    /**
     * 删除Import信息
     * 
     * @param associationMarkerId Import主键
     * @return 结果
     */
    @Override
    public int deleteImportAssociationMarkerByAssociationMarkerId(Long associationMarkerId)
    {
        return importAssociationMarkerMapper.deleteImportAssociationMarkerByAssociationMarkerId(associationMarkerId);
    }
}
