package com.ruoyi.zeamap.service;

import java.util.List;
import com.ruoyi.zeamap.domain.ImportTissue;
import com.ruoyi.zeamap.domain.ImportVariantInfo;

/**
 * 组织Service接口
 * 
 * @author ruoyi
 * @date 2023-03-22
 */
public interface IImportTissueService 
{
    public String importTissueData(List<ImportTissue> importList, Boolean isUpdateSupport, String operName);



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
     * 批量删除组织
     * 
     * @param tissueIds 需要删除的组织主键集合
     * @return 结果
     */
    public int deleteImportTissueByTissueIds(Long[] tissueIds);

    /**
     * 删除组织信息
     * 
     * @param tissueId 组织主键
     * @return 结果
     */
    public int deleteImportTissueByTissueId(Long tissueId);
}
