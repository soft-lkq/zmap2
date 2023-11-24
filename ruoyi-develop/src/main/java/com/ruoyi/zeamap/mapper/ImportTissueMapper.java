package com.ruoyi.zeamap.mapper;

import java.util.List;
import com.ruoyi.zeamap.domain.ImportTissue;

/**
 * 组织Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-22
 */
public interface ImportTissueMapper 
{
    /**
     * 查询组织
     * 
     * @param tissueId 组织主键
     * @return 组织
     */
    public ImportTissue selectImportTissueByTissueId(Long tissueId);

    /**
     * 查询组织列表
     * 
     * @param importTissue 组织
     * @return 组织集合
     */
    public List<ImportTissue> selectImportTissueList(ImportTissue importTissue);

    /**
     * 新增组织
     * 
     * @param importTissue 组织
     * @return 结果
     */
    public int insertImportTissue(ImportTissue importTissue);

    /**
     * 修改组织
     * 
     * @param importTissue 组织
     * @return 结果
     */
    public int updateImportTissue(ImportTissue importTissue);

    /**
     * 删除组织
     * 
     * @param tissueId 组织主键
     * @return 结果
     */
    public int deleteImportTissueByTissueId(Long tissueId);

    /**
     * 批量删除组织
     * 
     * @param tissueIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImportTissueByTissueIds(Long[] tissueIds);
}
