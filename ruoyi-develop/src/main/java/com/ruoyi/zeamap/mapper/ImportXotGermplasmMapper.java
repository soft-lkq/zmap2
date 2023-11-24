package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.ImportXotGermplasm;

/**
 * importMapper接口
 * 
 * @author ruoyi
 * @date 2023-04-11
 */
public interface ImportXotGermplasmMapper 
{
    /**
     * 查询import
     * 
     * @param xotGermplasmId import主键
     * @return import
     */
    public ImportXotGermplasm selectImportXotGermplasmByXotGermplasmId(Long xotGermplasmId);

    /**
     * 查询import列表
     * 
     * @param importXotGermplasm import
     * @return import集合
     */
    public List<ImportXotGermplasm> selectImportXotGermplasmList(ImportXotGermplasm importXotGermplasm);

    /**
     * 新增import
     * 
     * @param importXotGermplasm import
     * @return 结果
     */
    public int insertImportXotGermplasm(ImportXotGermplasm importXotGermplasm);

    /**
     * 修改import
     * 
     * @param importXotGermplasm import
     * @return 结果
     */
    public int updateImportXotGermplasm(ImportXotGermplasm importXotGermplasm);

    /**
     * 删除import
     * 
     * @param xotGermplasmId import主键
     * @return 结果
     */
    public int deleteImportXotGermplasmByXotGermplasmId(Long xotGermplasmId);

    /**
     * 批量删除import
     * 
     * @param xotGermplasmIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImportXotGermplasmByXotGermplasmIds(Long[] xotGermplasmIds);
}
