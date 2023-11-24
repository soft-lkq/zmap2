package com.ruoyi.zeamap.service;

import java.util.List;
import com.ruoyi.zeamap.domain.ImportExpression;
import com.ruoyi.zeamap.domain.ImportFeature;

/**
 * 基因表达量查询Service接口
 * 
 * @author ruoyi
 * @date 2023-03-22
 */
public interface IImportExpressionService 
{
    public String importExpressionData(List<ImportExpression> importList, Boolean isUpdateSupport, String operName);


    /**
     * 查询基因表达量查询
     * 
     * @param expressionId 基因表达量查询主键
     * @return 基因表达量查询
     */
    public ImportExpression selectImportExpressionByExpressionId(Long expressionId);

    /**
     * 查询基因表达量查询列表
     * 
     * @param importExpression 基因表达量查询
     * @return 基因表达量查询集合
     */
    public List<ImportExpression> selectImportExpressionList(ImportExpression importExpression);

    /**
     * 新增基因表达量查询
     * 
     * @param importExpression 基因表达量查询
     * @return 结果
     */
    public int insertImportExpression(ImportExpression importExpression);

    /**
     * 修改基因表达量查询
     * 
     * @param importExpression 基因表达量查询
     * @return 结果
     */
    public int updateImportExpression(ImportExpression importExpression);

    /**
     * 批量删除基因表达量查询
     * 
     * @param expressionIds 需要删除的基因表达量查询主键集合
     * @return 结果
     */
    public int deleteImportExpressionByExpressionIds(Long[] expressionIds);

    /**
     * 删除基因表达量查询信息
     * 
     * @param expressionId 基因表达量查询主键
     * @return 结果
     */
    public int deleteImportExpressionByExpressionId(Long expressionId);
}
