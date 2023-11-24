package com.ruoyi.zeamap.service.impl;

import com.ruoyi.zeamap.mapper.DbxrefMapper;
import com.ruoyi.zeamap.service.IDbxrefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-15
 */
@Service
public class DbxrefServiceImpl implements IDbxrefService
{
    @Autowired
    private DbxrefMapper dbxrefMapper;

    /**
     * 在dbxref表里查询accession
     *
     * @return accession的list
     */
    public List<String> selectAccession() {
        return dbxrefMapper.selectAccession();
    }

    /**
     * 通过accession在dbxref表里查询version
     *
     * @param accession
     * @return version的list
     */
    public List<String> selectVersionByAccession(String accession){
        return dbxrefMapper.selectVersionByAccession(accession);
    }
}
