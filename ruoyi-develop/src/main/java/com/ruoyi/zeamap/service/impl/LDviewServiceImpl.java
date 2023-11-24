package com.ruoyi.zeamap.service.impl;


import com.ruoyi.zeamap.mapper.LDviewMapper;
import com.ruoyi.zeamap.service.LDviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class LDviewServiceImpl implements LDviewService {
    @Autowired
    private LDviewMapper lDviewMapper;

    //查找dbxref表里面的accession
    @Override
    public List<String> selectaccession() {
        return lDviewMapper.selectaccession();
    }

    @Override
    public Long selectDbid(String accession) {
        return lDviewMapper.selectDbid(accession);
    }

    @Override
    public List<String> selectAccesion() {
        return lDviewMapper.selectAccesion();
    }

    @Override
    public List<String> selectSame(List<String> dbname, List<String> accession) {
        dbname.retainAll(accession);
        return dbname;
    }

    @Override
    public Long selectDbxrefIdByAll(String accession, String version,Long db_id) {
        return lDviewMapper.selectDbxrefIdByAll(accession,version,db_id);
    }

    @Override
    public List<String> selectVersionByAccesion(String accession) {
        return lDviewMapper.selectVersionByAccesion(accession);
    }

    @Override
    public List<String> selectDbName() {
        return lDviewMapper.selectDbName();
    }

    @Override
    public List<String> selectAlias() {
        return lDviewMapper.selectAlias();
    }

    @Override
    public Long selectPopulationId(String alias) {
        return lDviewMapper.selectPopulationId(alias);
    }

    @Override
    public List<String> selectDescription(Long population_id,Long dbxref_id) {
        return lDviewMapper.selectDescription(population_id,dbxref_id);
    }

    @Override
    public Long selectAnalysisId(Long population_id, Long dbxref_id,String description) {
        return lDviewMapper.selectAnalysisId(population_id,dbxref_id,description);
    }

    @Override
    public String selectLoadByAnalysisId(Long analysis_id) {
        return lDviewMapper.selectLoadByAnalysisId(analysis_id);
    }


    @Override
    public List<String> selectChorm(String path) throws IOException {
        File file = new File(path);
        if (!file.exists())
            throw new RuntimeException("Not File!");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        List<String[]> list = new ArrayList<String[]>();
        while ((str = br.readLine()) != null) {
            int s = 0;
            String[] arr = str.split("\t");
            String[] dArr = new String[arr.length];
            for (String ss : arr) {
                if (ss != null) {
                    dArr[s++] = ss;
                }
            }
            list.add(dArr);
        }
        int max = 0;
        for (String[] strings : list) {
            if (max < strings.length)
                max = strings.length;
        }
        String[][] array = new String[list.size()][max];
        for (int i = 0; i < array.length; i++) {
            System.arraycopy(list.get(i), 0, array[i], 0, list.get(i).length);
        }
        List<String> chorm = new ArrayList<String>();
        chorm.add(array[0][0]);
        for(int u=1;u<list.size();u++){
            if(!array[u][0].equals(array[u-1][0])) {
                chorm.add(array[u][0]);
            }
        }
        return chorm;
    }

    @Override
    public List<String> selectData(String path,String chorm, int start, int end) throws IOException {
        File file = new File(path);
        if (!file.exists())
            throw new RuntimeException("Not File!");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        List<String[]> list = new ArrayList<String[]>();
        while ((str = br.readLine()) != null) {
            int s = 0;
            String[] arr = str.split("\t");
            String[] dArr = new String[arr.length];
            for (String ss : arr) {
                if (ss != null) {
                    dArr[s++] = ss;
                }
            }
            list.add(dArr);
        }
        int max = 0;
        for (String[] strings : list) {
            if (max < strings.length)
                max = strings.length;
        }
        String[][] array = new String[list.size()][max];
        for (int i = 0; i < array.length; i++) {
            System.arraycopy(list.get(i), 0, array[i], 0, list.get(i).length);
        }
        List<String> Data = new ArrayList<>();
        for(int m=0;m<list.size();m++){
            if(chorm.equals(array[m][0])){
                int num1=Integer.parseInt(array[m][1]);
                int num2=Integer.parseInt(array[m][2]);
                if(start<num1&&end>num2){
                    String temp = array[m][3]+" "+array[m][4]+" "+array[m][5];
                    Data.add(temp);
                }
            }
        }
        return Data;
    }
}

