package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.zeamap.domain.ImportVariant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.ImportVariantInfoMapper;
import com.ruoyi.zeamap.domain.ImportVariantInfo;
import com.ruoyi.zeamap.service.IImportVariantInfoService;

import javax.validation.Validator;

/**
 * ImportInfoService业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-18
 */
@Service
public class ImportVariantInfoServiceImpl implements IImportVariantInfoService 
{
    @Autowired
    private ImportVariantInfoMapper importVariantInfoMapper;

    private static final Logger log = LoggerFactory.getLogger(ImportVariantInfoServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importVariantInfoData(List<ImportVariantInfo> importList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(importList) || importList.size() == 0)
        {
            throw new ServiceException("导入variant_info数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ImportVariantInfo importVariantInfo : importList)
        {
            try
            {
                // 验证是否存在这个用户
                ImportVariantInfo i = importVariantInfoMapper.selectImportVariantInfoByVariantinfoId(importVariantInfo.getVariantinfoId());
                if (StringUtils.isNull(i))
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setCreateBy(operName);
                    this.insertImportVariantInfo(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "variantInfo_id " + i.getVariantinfoId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setUpdateBy(operName);
                    this.updateImportVariantInfo(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "variantInfo_id " + i.getVariantinfoId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "variantInfo_id " + i.getVariantinfoId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "variantInfo_id " + importVariantInfo.getVariantinfoId() + " 导入失败：";
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
     * 查询ImportInfo
     * 
     * @param variantinfoId ImportInfo主键
     * @return ImportInfo
     */
    @Override
    public ImportVariantInfo selectImportVariantInfoByVariantinfoId(String variantinfoId)
    {
        return importVariantInfoMapper.selectImportVariantInfoByVariantinfoId(variantinfoId);
    }

    /**
     * 查询ImportInfo列表
     * 
     * @param importVariantInfo ImportInfo
     * @return ImportInfo
     */
    @Override
    public List<ImportVariantInfo> selectImportVariantInfoList(ImportVariantInfo importVariantInfo)
    {
        return importVariantInfoMapper.selectImportVariantInfoList(importVariantInfo);
    }

    /**
     * 新增ImportInfo
     * 
     * @param importVariantInfo ImportInfo
     * @return 结果
     */
    @Override
    public int insertImportVariantInfo(ImportVariantInfo importVariantInfo)
    {
        return importVariantInfoMapper.insertImportVariantInfo(importVariantInfo);
    }

    /**
     * 修改ImportInfo
     * 
     * @param importVariantInfo ImportInfo
     * @return 结果
     */
    @Override
    public int updateImportVariantInfo(ImportVariantInfo importVariantInfo)
    {
        return importVariantInfoMapper.updateImportVariantInfo(importVariantInfo);
    }

    /**
     * 批量删除ImportInfo
     * 
     * @param variantinfoIds 需要删除的ImportInfo主键
     * @return 结果
     */
    @Override
    public int deleteImportVariantInfoByVariantinfoIds(String[] variantinfoIds)
    {
        return importVariantInfoMapper.deleteImportVariantInfoByVariantinfoIds(variantinfoIds);
    }

    /**
     * 删除ImportInfo信息
     * 
     * @param variantinfoId ImportInfo主键
     * @return 结果
     */
    @Override
    public int deleteImportVariantInfoByVariantinfoId(String variantinfoId)
    {
        return importVariantInfoMapper.deleteImportVariantInfoByVariantinfoId(variantinfoId);
    }
}
