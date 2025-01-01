package com.sist.io;
import java.io.*;
// 폴더 / 파일 / (폴더/파일 존재여부 확인) => 삭제
// 

public class IO_5 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File file=new File("c:\\java_data\\sawon.txt");
//        if (!dir.exists())   // 폴더 => 존재하지 않는 경우 생성
        if(!file.exists())
        {
//          dir.mkdir();
            try
            {
                file.createNewFile();
            } catch (Exception ex) {}
        }
        else
        {
//            System.out.println("이미 존재하는 폴더입니다");
            System.out.println("이미 존재하는 파일입니다");
        }
    }

}
