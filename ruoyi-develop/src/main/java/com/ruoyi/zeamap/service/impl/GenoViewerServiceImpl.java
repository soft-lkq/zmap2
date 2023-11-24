package com.ruoyi.zeamap.service.impl;

import com.ruoyi.zeamap.mapper.GenoViewerMapper;
import com.ruoyi.zeamap.service.GenoViewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GenoViewerServiceImpl implements GenoViewerService {
    @Autowired
    private GenoViewerMapper genoViewerMapper;


    @Override
    public List<String> selectTst() {
        return genoViewerMapper.selectTst();
    }

    @Override
    public List<String> selectMix() {
        return genoViewerMapper.selectMix();
    }

    @Override
    public List<String> selectNss() {
        return genoViewerMapper.selectNss();
    }

    @Override
    public List<String> selectSS() {
        return genoViewerMapper.selectSS();
    }

    @Override
    public String selectFile(Long analysis_id) {
        return genoViewerMapper.selectFile(analysis_id);
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
        int pos=0;
        while(!array[pos][0].equals("chr1")){
            pos++;
        }
        List<String> chorm = new ArrayList<String>();
        chorm.add(array[pos][0]);
        for(int u=pos+1;u<list.size();u++){
            if(!array[u][0].equals(array[u-1][0])) {
                chorm.add(array[u][0]);
            }
        }
        return chorm;
    }

    @Override
    public List<String> selectData(String path,String[] choose, String chorm, int start, int end) throws IOException {
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
        int pos=0;
        while(!array[pos][0].equals("chr1")){
            pos++;
        }
        List<String> Data = new ArrayList<>();
        int[] ns = new int[choose.length+1];
        int tp=0;
//        for(int k=0;k<max;k++){
//            if (choose[tp].equals(array[pos-1][k])){
//                System.out.println(choose[tp]);
//                ns[tp]=k;
//                tp++;
//                if(tp>choose.length-1){
//                    break;
//                }
//            }
//        }
        while(tp<=choose.length-1){
            for(int k=0;k<max;k++){
                if(choose[tp].equals(array[pos-1][k])){
                    ns[tp]=k;
                    tp++;
                    break;
                }
            }
        }


        for(int m=pos;m<list.size();m++){
            if(chorm.equals(array[m][0])){
                int num1=Integer.parseInt(array[m][1]);
                if(start<num1&&end>num1){
                    StringBuilder temp = new StringBuilder(array[m][1] + " " + array[m][2] +" ");
                    for(int y=0;y<choose.length;y++){
                        int d=ns[y];
                        temp.append(array[m][d]).append(" ");
                    }
                    Data.add(temp.toString());
                }
            }
        }

        return Data;
    }
}
