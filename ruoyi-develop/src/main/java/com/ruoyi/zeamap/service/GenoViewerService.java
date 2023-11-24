package com.ruoyi.zeamap.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


public interface GenoViewerService {
    //分组TST
    public List<String> selectTst();
    //分组Mixed
    public List<String> selectMix();
    //分组NSS
    public List<String> selectNss();
    //分组SS
    public List<String> selectSS();
    //查询文件位置
    public String selectFile(Long analysis_id);
    //查询文件选择chorm
    public List<String> selectChorm(String path) throws IOException;
    //查询数据
    public List<String> selectData(String path,String[] choose,String chorm,int start,int end) throws IOException;
}
