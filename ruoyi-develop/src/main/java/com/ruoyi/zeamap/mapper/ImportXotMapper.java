package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.ImportXot;

/**
 * 1Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-15
 */
public interface ImportXotMapper 
{
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
     * 删除1
     * 
     * @param xotId 1主键
     * @return 结果
     */
    public int deleteImportXotByXotId(Long xotId);

    /**
     * 批量删除1
     * 
     * @param xotIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImportXotByXotIds(Long[] xotIds);
}
