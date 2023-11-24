package com.ruoyi.zeamap.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GenoViewerMapper {
    //分组TST
    public List<String> selectTst();
    //分组Mixed
    public List<String> selectMix();
    //分组NSS
    public List<String> selectNss();
    //分组SS
    public List<String> selectSS();
    //文件位置
    public String selectFile(Long analysis_id);
}
