package com.sist.io;
// listFiles => 현재 폴더에 존재하는 파일의 확장자
import java.io.*;
public class IO_3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File dir = new File("c:\\javaDev");
        File[] list = dir.listFiles();
        for (File f: list)
        {
            if(f.isFile())
            {
                String name=f.getName();
                String ext=name.substring(name.lastIndexOf(".")+1);
                System.out.println(name+" "+ext);
            }
        }
    }

}
