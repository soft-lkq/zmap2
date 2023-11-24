package com.ruoyi.zeamap.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2023-03-15
 */
@Mapper
public interface DbxrefMapper
{
    /**
     * 在dbxref表里查询accession
     *
     * @return accession的list
     */
    public List<String> selectAccession();

    /**
     * 通过accession在dbxref表里查询version
     *
     * @param accession
     * @return version的list
     */
    public List<String> selectVersionByAccession(String accession);
}
