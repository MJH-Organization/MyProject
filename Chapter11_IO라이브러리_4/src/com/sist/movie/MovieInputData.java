package com.sist.movie;

import java.io.*;
import java.util.*;

// 데이터 크롤링
// 객체 단위로 저장한 파일을 만든다
// ObjectOurputStream
public class MovieInputData {
    static final String DATAFILE="c:\\javaDev\\movie.txt";

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ObjectOutputStream oos=null;
        BufferedReader br=null;

        try
        {
            List<Movie> list=new ArrayList<>();
            FileReader fr = new FileReader(new File(DATAFILE));
            int i=0;
            StringBuffer sb=new StringBuffer();
            while((i=fr.read())!=-1)
            {
                sb.append((char)i);
            }
            String data=sb.toString();
            String[] mdata=data.split("\n");
            for (String m:mdata)
            {
                String[] mm=m.split("\\|");
                Movie movie=new Movie();
                movie.setMno(Integer.parseInt(mm[0]));
                movie.setTitle(mm[1]);
                movie.setGenre(mm[2]);
                movie.setPoster(mm[3]);
                movie.setActor(mm[4]);
                movie.setRegdate(mm[5]);
                movie.setGrade(mm[6]);
                movie.setDirector(mm[7]);
                list.add(movie);
            }
            
            FileOutputStream fos=
                    new FileOutputStream("c:\\java_data\\movie_info.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            System.out.println("영화 객체 단위 저장완료");
            
        }catch (Exception ex)
        {
            
        }
        finally
        {
            try
            {
                oos.close();
            }catch(Exception ex) {}
        }
       
    }

}
