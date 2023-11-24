package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.zeamap.domain.ImportLinkageQtl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.ImportLinkageMarkerMapper;
import com.ruoyi.zeamap.domain.ImportLinkageMarker;
import com.ruoyi.zeamap.service.IImportLinkageMarkerService;

import javax.validation.Validator;

/**
 * ImportService业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-21
 */
@Service
public class ImportLinkageMarkerServiceImpl implements IImportLinkageMarkerService 
{
    @Autowired
    private ImportLinkageMarkerMapper importLinkageMarkerMapper;

    private static final Logger log = LoggerFactory.getLogger(ImportLinkageQtlServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importLinkageMarkerData(List<ImportLinkageMarker> importList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(importList) || importList.size() == 0)
        {
            throw new ServiceException("导入linkage_qtl数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ImportLinkageMarker importLinkageMarker : importList)
        {
            try
            {
                // 验证是否存在这个用户
                ImportLinkageMarker i = importLinkageMarkerMapper.selectImportLinkageMarkerByLinkageMarkerId(importLinkageMarker.getLinkageMarkerId());
                if (StringUtils.isNull(i))
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setCreateBy(operName);
                    this.insertImportLinkageMarker(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "linkageMarker_id " + i.getLinkageMarkerId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setUpdateBy(operName);
                    this.updateImportLinkageMarker(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "linkageMarker_id " + i.getLinkageMarkerId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "linkageMarker_id " + i.getLinkageMarkerId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "linkageMarker_id " + importLinkageMarker.getLinkageMarkerId() + " 导入失败：";
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
     * @param linkageMarkerId Import主键
     * @return Import
     */
    @Override
    public ImportLinkageMarker selectImportLinkageMarkerByLinkageMarkerId(Long linkageMarkerId)
    {
        return importLinkageMarkerMapper.selectImportLinkageMarkerByLinkageMarkerId(linkageMarkerId);
    }

    /**
     * 查询Import列表
     * 
     * @param importLinkageMarker Import
     * @return Import
     */
    @Override
    public List<ImportLinkageMarker> selectImportLinkageMarkerList(ImportLinkageMarker importLinkageMarker)
    {
        return importLinkageMarkerMapper.selectImportLinkageMarkerList(importLinkageMarker);
    }

    /**
     * 新增Import
     * 
     * @param importLinkageMarker Import
     * @return 结果
     */
    @Override
    public int insertImportLinkageMarker(ImportLinkageMarker importLinkageMarker)
    {
        return importLinkageMarkerMapper.insertImportLinkageMarker(importLinkageMarker);
    }

    /**
     * 修改Import
     * 
     * @param importLinkageMarker Import
     * @return 结果
     */
    @Override
    public int updateImportLinkageMarker(ImportLinkageMarker importLinkageMarker)
    {
        return importLinkageMarkerMapper.updateImportLinkageMarker(importLinkageMarker);
    }

    /**
     * 批量删除Import
     * 
     * @param linkageMarkerIds 需要删除的Import主键
     * @return 结果
     */
    @Override
    public int deleteImportLinkageMarkerByLinkageMarkerIds(Long[] linkageMarkerIds)
    {
        return importLinkageMarkerMapper.deleteImportLinkageMarkerByLinkageMarkerIds(linkageMarkerIds);
    }

    /**
     * 删除Import信息
     * 
     * @param linkageMarkerId Import主键
     * @return 结果
     */
    @Override
    public int deleteImportLinkageMarkerByLinkageMarkerId(Long linkageMarkerId)
    {
        return importLinkageMarkerMapper.deleteImportLinkageMarkerByLinkageMarkerId(linkageMarkerId);
    }
}
