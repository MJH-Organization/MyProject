package com.sist.io;
import java.io.*;
public class IO_4 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try
        {
            FileOutputStream fos=new FileOutputStream("c:\\java_data\\student.txt",true);
            String msg="ABCDEF";
            fos.write(msg.getBytes());
            fos.close();
            System.out.println("저장완료");
            // 파일이 없는 경우에는 자동으로 생성
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

}
