package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.ImportDbMapper;
import com.ruoyi.zeamap.domain.ImportDb;
import com.ruoyi.zeamap.service.IImportDbService;

import javax.validation.Validator;

/**
 * importdbService业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-26
 */
@Service
public class ImportDbServiceImpl implements IImportDbService 
{
    @Autowired
    private ImportDbMapper importDbMapper;

    private static final Logger log = LoggerFactory.getLogger(ImportDbServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importDbData(List<ImportDb> importList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(importList) || importList.size() == 0)
        {
            throw new ServiceException("导入db数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ImportDb importDb : importList)
        {
            try
            {
                // 验证是否存在这个用户
                ImportDb i = importDbMapper.selectImportDbByDbId(importDb.getDbId());
                if (StringUtils.isNull(i))
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setCreateBy(operName);
                    this.insertImportDb(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "db_id " + i.getDbId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setUpdateBy(operName);
                    this.updateImportDb(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "db_id " + i.getDbId()  + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "db_id " + i.getDbId()  + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "db_id " + importDb.getDbId() + " 导入失败：";
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
     * 查询importdb
     * 
     * @param dbId importdb主键
     * @return importdb
     */
    @Override
    public ImportDb selectImportDbByDbId(Long dbId)
    {
        return importDbMapper.selectImportDbByDbId(dbId);
    }

    /**
     * 查询importdb列表
     * 
     * @param importDb importdb
     * @return importdb
     */
    @Override
    public List<ImportDb> selectImportDbList(ImportDb importDb)
    {
        return importDbMapper.selectImportDbList(importDb);
    }

    /**
     * 新增importdb
     * 
     * @param importDb importdb
     * @return 结果
     */
    @Override
    public int insertImportDb(ImportDb importDb)
    {
        return importDbMapper.insertImportDb(importDb);
    }

    /**
     * 修改importdb
     * 
     * @param importDb importdb
     * @return 结果
     */
    @Override
    public int updateImportDb(ImportDb importDb)
    {
        return importDbMapper.updateImportDb(importDb);
    }

    /**
     * 批量删除importdb
     * 
     * @param dbIds 需要删除的importdb主键
     * @return 结果
     */
    @Override
    public int deleteImportDbByDbIds(Long[] dbIds)
    {
        return importDbMapper.deleteImportDbByDbIds(dbIds);
    }

    /**
     * 删除importdb信息
     * 
     * @param dbId importdb主键
     * @return 结果
     */
    @Override
    public int deleteImportDbByDbId(Long dbId)
    {
        return importDbMapper.deleteImportDbByDbId(dbId);
    }
}
