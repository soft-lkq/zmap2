package com.ruoyi.zeamap.service;

import java.util.List;

import com.ruoyi.zeamap.domain.ImportDbxref;
import com.ruoyi.zeamap.domain.ImportXot;

/**
 * 1Service接口
 * 
 * @author ruoyi
 * @date 2023-03-15
 */
public interface IImportXotService 
{

    //导入
    public String importXotData(List<ImportXot> importXotList, Boolean isUpdateSupport, String operName);


    /**
     * 查询1
     * 
     * @param xotId 1主键
     * @return 1
     */
    public ImportXot selectImportXotByXotId(Long xotId);

    /**
     * 查询1列表
     * 
     * @param importXot 1
     * @return 1集合
     */
    public List<ImportXot> selectImportXotList(ImportXot importXot);

    /**
     * 新增1
     * 
     * @param importXot 1
     * @return 结果
     */
    public int insertImportXot(ImportXot importXot);

    /**
     * 修改1
     * 
     * @param importXot 1
     * @return 结果
     */
    public int updateImportXot(ImportXot importXot);

    /**
     * 批量删除1
     * 
     * @param xotIds 需要删除的1主键集合
     * @return 结果
     */
    public int deleteImportXotByXotIds(Long[] xotIds);

    /**
     * 删除1信息
     * 
     * @param xotId 1主键
     * @return 结果
     */
    public int deleteImportXotByXotId(Long xotId);
}
