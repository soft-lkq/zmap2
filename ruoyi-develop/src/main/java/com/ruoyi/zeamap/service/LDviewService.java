package com.ruoyi.zeamap.service;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface LDviewService {

    //查找dbxref表里面的accession
    public List<String> selectaccession();

    //后缀带-GFF和选取accession的db_id
    public Long selectDbid(String accession);

    /**
     * 查询accession
     * @return accession
     */
    public List<String> selectAccesion();

    /**
     * 取交集
     */
    public List<String> selectSame(List<String> dbname,List<String> accession);

    //锁定id
    public Long selectDbxrefIdByAll(String accession,String version,Long db_id);

    /**
     * 根据Accession查version
     */
    public  List<String> selectVersionByAccesion(String accession);

    public List<String> selectDbName();

    //查询alias
    public List<String> selectAlias();

    //锁定population_id
    public Long selectPopulationId(String alias);

    //查询description
    public List<String> selectDescription(Long population_id,Long dbxref_id);

    //查询analysis_id
    public Long selectAnalysisId(Long population_id,Long dbxref_id,String description);

    //查询chorm
    public String selectLoadByAnalysisId(Long analysis_id);

    //查询文件选择chorm
    public List<String> selectChorm(String path) throws IOException;

    //查询符合条件的数据
    public List<String> selectData(String path,String chorm,int start,int end) throws IOException;
}
