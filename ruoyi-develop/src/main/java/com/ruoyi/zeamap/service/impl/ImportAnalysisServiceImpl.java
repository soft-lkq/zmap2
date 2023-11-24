package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.zeamap.domain.ImportDbxref;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zeamap.mapper.ImportAnalysisMapper;
import com.ruoyi.zeamap.domain.ImportAnalysis;
import com.ruoyi.zeamap.service.IImportAnalysisService;

import javax.validation.Validator;

/**
 * ImportAnalysisService业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-15
 */
@Service
public class ImportAnalysisServiceImpl implements IImportAnalysisService 
{
    @Autowired
    private ImportAnalysisMapper importAnalysisMapper;

    private static final Logger log = LoggerFactory.getLogger(ImportAnalysisServiceImpl.class);

    @Autowired
    protected Validator validator;

    @Override
    public String importAnalysisData(List<ImportAnalysis> importList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(importList) || importList.size() == 0)
        {
            throw new ServiceException("导入analysis数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ImportAnalysis importAnalysis : importList)
        {
            try
            {
                // 验证是否存在这个用户
                ImportAnalysis i = importAnalysisMapper.selectImportAnalysisByAnalysisId(importAnalysis.getAnalysisId());
                if (StringUtils.isNull(i))
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setCreateBy(operName);
                    this.insertImportAnalysis(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "analysis_id " + i.getAnalysisId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, i);
                    i.setUpdateBy(operName);
                    this.updateImportAnalysis(i);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "analysis_id " + i.getAnalysisId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "analysis_id " + i.getAnalysisId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "analysis_id " + importAnalysis.getAnalysisId() + " 导入失败：";
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
     * 查询ImportAnalysis
     * 
     * @param analysisId ImportAnalysis主键
     * @return ImportAnalysis
     */
    @Override
    public ImportAnalysis selectImportAnalysisByAnalysisId(Long analysisId)
    {
        return importAnalysisMapper.selectImportAnalysisByAnalysisId(analysisId);
    }

    /**
     * 查询ImportAnalysis列表
     * 
     * @param importAnalysis ImportAnalysis
     * @return ImportAnalysis
     */
    @Override
    public List<ImportAnalysis> selectImportAnalysisList(ImportAnalysis importAnalysis)
    {
        return importAnalysisMapper.selectImportAnalysisList(importAnalysis);
    }

    /**
     * 新增ImportAnalysis
     * 
     * @param importAnalysis ImportAnalysis
     * @return 结果
     */
    @Override
    public int insertImportAnalysis(ImportAnalysis importAnalysis)
    {
        return importAnalysisMapper.insertImportAnalysis(importAnalysis);
    }

    /**
     * 修改ImportAnalysis
     * 
     * @param importAnalysis ImportAnalysis
     * @return 结果
     */
    @Override
    public int updateImportAnalysis(ImportAnalysis importAnalysis)
    {
        return importAnalysisMapper.updateImportAnalysis(importAnalysis);
    }

    /**
     * 批量删除ImportAnalysis
     * 
     * @param analysisIds 需要删除的ImportAnalysis主键
     * @return 结果
     */
    @Override
    public int deleteImportAnalysisByAnalysisIds(Long[] analysisIds)
    {
        return importAnalysisMapper.deleteImportAnalysisByAnalysisIds(analysisIds);
    }

    /**
     * 删除ImportAnalysis信息
     * 
     * @param analysisId ImportAnalysis主键
     * @return 结果
     */
    @Override
    public int deleteImportAnalysisByAnalysisId(Long analysisId)
    {
        return importAnalysisMapper.deleteImportAnalysisByAnalysisId(analysisId);
    }
}
