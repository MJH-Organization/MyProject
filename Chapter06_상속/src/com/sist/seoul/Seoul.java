package com.sist.seoul;
import java.io.FileReader;

import com.sist.vo.*;
public class Seoul {
//    public static SeoulVo[] seoulData=new SeoulVo[];
    public String getFileData(String path)
    {
        StringBuffer sb=new StringBuffer();
        try
        {
            FileReader fr=new FileReader(path);
            int i=0;    // 문자 1개 읽기
            while ((i=fr.read())!=-1)
            {
                sb.append((char)i);
            }
            fr.close();
        }catch(Exception ex) {}
        return sb.toString();
    }
    public SeoulVO[] seoulAllData(int type)
    {
        SeoulVO[] datas=null;
        String data="";
        if (type==1)    // location
        {
            data=getFileData("c:\\javaDev\\seoul_location.txt");
        }
        else
        {
            data=getFileData("c:\\javaDev\\seoul_nature.txt");
        }
        String[]   seoul=data.split("\n");
        datas=new SeoulVO[seoul.length];
        int i=0;
        for (String s:seoul)
        {
            String[] ss=s.split("\\|");
            datas[i]=new SeoulVO();
            datas[i].setNo(ss[0]);
            datas[i].setName(ss[1]);
            i++;
        }
        
        return datas;
    }
//    public SeoulVo[] seoulListData(int page)
//    {
//        SeoulVo[] seoul=new SeoulVo[];
//        return seoul;
//    }
//    public SeoulVo[] seoulFindData(int type, String findData)
//    {
//        
//    }
}
