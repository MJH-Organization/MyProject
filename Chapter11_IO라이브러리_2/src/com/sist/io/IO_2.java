package com.sist.io;
import java.io.*;
public class IO_2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try
        {
            // 파일 복사 => 파일 전송
            // 파일 자체 제어 => Reader / Writer
            fis=new FileInputStream("c:\\javaDev\\movie.txt");
            fos=new FileOutputStream("c:\\java_data\\movie.txt");
            //                      => 파일이 없는 경우에 자동으로 생성
            /*
             *      mode
             *          r => read
             *          w => write => create
             *          fos=new FileOutputStream("c:\\java_data\\movie.txt");
             *          a => append    
             *          fos=new FileOutputStream("c:\\java_data\\movie.txt", true);                            
             */
            int i=0; // i => 글자 한글자
            // 읽은 바이트 수
            byte[] buffer=new byte[1024];   // TCP(1024) / UDP(512) => 제일 빠른 buffer 길이
            // i=read() / i=read(byte[], start, end)
            //  1글자      읽은 바이트 수
            while((i=fis.read(buffer,0,1024))!=-1)
            {
                fos.write(buffer,0,i);  // 1024byte 보다 작은 경우를 write 하기 위해
            }
            System.out.println("복사완료!!");
            
        }catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                fis.close();
                fos.close();

            }catch(Exception ex) {}
        }
    }

}
