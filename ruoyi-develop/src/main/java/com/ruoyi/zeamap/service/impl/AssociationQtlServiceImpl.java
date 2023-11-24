package com.ruoyi.zeamap.service.impl;

import java.util.List;

import com.ruoyi.zeamap.domain.AssociationQtl;
import com.ruoyi.zeamap.mapper.AssociationQtlMapper;
import com.ruoyi.zeamap.service.IAssociationQtlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-06
 */
@Service
public class AssociationQtlServiceImpl implements IAssociationQtlService {
    @Autowired
    private AssociationQtlMapper associationQtlMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param associationQtlId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public AssociationQtl selectAssociationQtlByAssociationQtlId(Long associationQtlId) {
        return associationQtlMapper.selectAssociationQtlByAssociationQtlId(associationQtlId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param associationQtl 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<AssociationQtl> selectAssociationQtlList(AssociationQtl associationQtl) {
        return associationQtlMapper.selectAssociationQtlList(associationQtl);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param associationQtl 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertAssociationQtl(AssociationQtl associationQtl) {
        return associationQtlMapper.insertAssociationQtl(associationQtl);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param associationQtl 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateAssociationQtl(AssociationQtl associationQtl) {
        return associationQtlMapper.updateAssociationQtl(associationQtl);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param associationQtlIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAssociationQtlByAssociationQtlIds(Long[] associationQtlIds) {
        return associationQtlMapper.deleteAssociationQtlByAssociationQtlIds(associationQtlIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param associationQtlId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAssociationQtlByAssociationQtlId(Long associationQtlId) {
        return associationQtlMapper.deleteAssociationQtlByAssociationQtlId(associationQtlId);
    }

    /**
     * 由此开始
     *
     * @Author 刘洋
     * @Date 2023/3/11
     * Search Qtl模块 Association Mapping的内容
     */

    //查找dbxref表里面的accession
    @Override
    public List<String> selectaccession() {
        return associationQtlMapper.selectaccession();
    }

    //查找dbxref表里面的version,version是reference的下级
    @Override
    public List<String> selectversion(String accession) {
        return associationQtlMapper.selectversion(accession);
    }

    //查找Trait Category
    @Override
    public List<String> selecttraitcategory() {
        return associationQtlMapper.selecttraitcategory();
    }

    //查找Trait Id
    @Override
    public List<String> selecttraitid(String trait_id) {
        return associationQtlMapper.selecttraitid(trait_id);
    }

    //查找chr
    @Override
    public List<String> selectchr() {
        return associationQtlMapper.selectchr();
    }


    //大查询
    @Override
    public List<AssociationQtl> selectassociation_qtl(String accession, String version, String omics, String xot_uid, String chr, long start, long end,  Double log_min, Double log_max) {
        return associationQtlMapper.selectassociation_qtl(accession, version, omics, xot_uid, chr, start, end, log_min, log_max);

    }
}