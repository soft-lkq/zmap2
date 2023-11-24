package com.ruoyi.zeamap.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

@Mapper
public interface LDviewMapper {

    //查找dbxref表里面的accession
    public List<String> selectaccession();

    //后缀带-GFF和选取accession的db_id
    public Long selectDbid(String accession);

    /**
     * 查询db_name(-GFF)
     *
     * @return db_name
     */
    public List<String> selectDbName();

    /**
     * 查询accession
     *
     * @return accession
     */
    public List<String> selectAccesion();

    /**
     * 根据reference查询version
     *
     * @return version
     */
    public List<String> selectVersionByAccesion(String assession);

    //锁定id
    public Long selectDbxrefIdByAll(@Param("accession") String accession,@Param("version") String version,@Param("db_id")Long db_id);

    //查询alias
    public List<String> selectAlias();

    //锁定population_id
    public Long selectPopulationId(String alias);

    //查询description
    public List<String> selectDescription(@Param("population_id") Long population_id,@Param("dbxref_id") Long dbxref_id);

    /**
     * 查询Analysis
     *
     * @return analysis_id
     */
    public Long selectAnalysisId(@Param("population_id") Long population_id,@Param("dbxref_id") Long dbxref_id, @Param("description") String description);

    //查询符合analysis_id条件的chorm
    public String selectLoadByAnalysisId(Long analysis_id);


}
