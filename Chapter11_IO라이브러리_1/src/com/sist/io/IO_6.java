package com.sist.io;
import java.io.*;
// 삭제 => delete()
/*
 *  1. 파일 읽기
 *      new File("경로명\\파일명")
 *  2. 폴더 읽기
 *      new File("경로명\\폴더명")
 *      
 *      웹에서 계속 나온다 => 이미지 올리기 / 업로드 / 다운로드
 *                       ------------------------
 *                       => 자료실
 *                       => 댓글
 *  3. 주요메서드
 *      getName() : 파일명
 *      getPath() : 경로명 ~ 파일명
 *      length() : 파일 크기
 *      
 *      listFiles() : 폴더 내의 파일 목록을 가져옴
 *      mkdir() : 폴더 제작
 *      createNewFile() : 파일 생성
 *      delete() : 삭제
 *      exists() : 존재여부 확인        
 */
public class IO_6 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File dir=new File("c:\\java_data");
        // rm 파일명 => rm -rf 폴더명
        //dir.delete();
        File[] files=dir.listFiles();
        for (File f:files)
        {
            f.delete(); // 폴더 안에 파일이 존재하면 삭제가 안된다
        }
        dir.delete();   // 폴더를 삭제
        System.out.println("삭제 완료!!");
    }

}
