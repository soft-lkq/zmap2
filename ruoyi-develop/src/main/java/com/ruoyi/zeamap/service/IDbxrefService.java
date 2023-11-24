package com.ruoyi.zeamap.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-03-15
 */
@Service
public interface IDbxrefService
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
