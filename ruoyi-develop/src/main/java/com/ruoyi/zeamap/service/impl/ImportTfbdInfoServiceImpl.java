package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.zeamap.domain.ImportTissue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.ImportTfbdInfoMapper;
import com.ruoyi.zeamap.domain.ImportTfbdInfo;
import com.ruoyi.zeamap.service.IImportTfbdInfoService;

import javax.validation.Validator;

/**
 * ImportService业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-06
 */
@Service
public class ImportTfbdInfoServiceImpl implements IImportTfbdInfoService 
{
    @Autowired
    private ImportTfbdInfoMapper importTfbdInfoMapper;

    private static final Logger log = LoggerFactory.getLogger(ImportTfbdInfoServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importTfbdInfoData(List<ImportTfbdInfo> importList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(importList) || importList.size() == 0)
        {
            throw new ServiceException("导入tfbd_info数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ImportTfbdInfo importAll : importList)
        {
            try
            {
                // 验证是否存在这个用户
                ImportTfbdInfo i = importTfbdInfoMapper.selectImportTfbdInfoByTfbdId(importAll.getTfbdId());
                if (StringUtils.isNull(i))
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setCreateBy(operName);
                    this.insertImportTfbdInfo(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "tfbdinfo_id " + i.getTfbdId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setUpdateBy(operName);
                    this.updateImportTfbdInfo(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "tfbdinfo_id " + i.getTfbdId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "tfbdinfo_id " + i.getTfbdId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "tfbdinfo_id " + importAll.getTfbdId() + " 导入失败：";
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
     * @param tfbdId Import主键
     * @return Import
     */
    @Override
    public ImportTfbdInfo selectImportTfbdInfoByTfbdId(Long tfbdId)
    {
        return importTfbdInfoMapper.selectImportTfbdInfoByTfbdId(tfbdId);
    }

    /**
     * 查询Import列表
     * 
     * @param importTfbdInfo Import
     * @return Import
     */
    @Override
    public List<ImportTfbdInfo> selectImportTfbdInfoList(ImportTfbdInfo importTfbdInfo)
    {
        return importTfbdInfoMapper.selectImportTfbdInfoList(importTfbdInfo);
    }

    /**
     * 新增Import
     * 
     * @param importTfbdInfo Import
     * @return 结果
     */
    @Override
    public int insertImportTfbdInfo(ImportTfbdInfo importTfbdInfo)
    {
        return importTfbdInfoMapper.insertImportTfbdInfo(importTfbdInfo);
    }

    /**
     * 修改Import
     * 
     * @param importTfbdInfo Import
     * @return 结果
     */
    @Override
    public int updateImportTfbdInfo(ImportTfbdInfo importTfbdInfo)
    {
        return importTfbdInfoMapper.updateImportTfbdInfo(importTfbdInfo);
    }

    /**
     * 批量删除Import
     * 
     * @param tfbdIds 需要删除的Import主键
     * @return 结果
     */
    @Override
    public int deleteImportTfbdInfoByTfbdIds(Long[] tfbdIds)
    {
        return importTfbdInfoMapper.deleteImportTfbdInfoByTfbdIds(tfbdIds);
    }

    /**
     * 删除Import信息
     * 
     * @param tfbdId Import主键
     * @return 结果
     */
    @Override
    public int deleteImportTfbdInfoByTfbdId(Long tfbdId)
    {
        return importTfbdInfoMapper.deleteImportTfbdInfoByTfbdId(tfbdId);
    }
}
