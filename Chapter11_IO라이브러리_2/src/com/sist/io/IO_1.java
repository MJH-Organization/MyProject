package com.sist.io;
import java.io.*;

/**
 *      라이브러리 => 9장~12장
 *      -------
 *      | 이해하는 것은 아니다 : 암기
 *        -------------- 
 *        1. 클래스명: 사용처
 *        2. 주요메서드 => 역할 / 리턴형 / 매개변수
 *        3. 자바에서 지원 => 오버라이딩은 거의 없다
 *           ---------> 실무에서 동일하게 사용 (표준화)
 *            
 *      1. 입출력
 *          => 메모리 입출력 (Scanner)    ==> 358 page
 *              => System.out.println()
 *              => System.in.read() => int / 반드시 예외처리
 *                 ---------------- Scanner     
 *          => 파일입출력
 *              InputStream          OutputStream
 *                  (읽기)                  (쓰기)
 *              ** 특징
 *                  1) 단방향 통신 (읽기/쓰기를 동시에 처리할 수 없다)
 *                  2) Stream : 데이터 이동 통로
 *                  3) 1byte 입출력
 *                      => 브라우저 / 한글이 없는 파일
 *                  4) read() : 한글자씩 읽어온다
 *                     write() : 한글자씩 저장
 *                     close() : 닫기
 *              Reader          Writer  => 2byte => 한글 읽기에 적합
 *                읽기            쓰기
 *                read()        write()     close()
 *                
 *             => 바이트스트림
 *                : 1byte전송 / 1byte수신   => 다운로드, 업로드  
 *                ***FileInputStream / FileOutputStream
 *             => 문자스트림
 *                : 2byte전송 / 2byte수신   => 한글파일 제어
 *                ***FileReader / FileWriter
 *                    ------       ------  
 *             => 필터스트림
 *             => 데이터를 메모리에 모아서 한번에 처리 : 속도
 *                ***BufferedInputStream / BufferedOutputStream
 *                ***BufferedReader / BufferedWriter
 *                
 *                ObjectInputStream / ObjectOutputStream
 *             ----------------------------------------------------                     
 *          => 네트워크입출력
 *          
 *          입출력
 *                  입력스트림                       출력스트림
 *          키보드 =================> 자바프로그램 ===============> 모니터
 *                  ~InputStream                ~OutputStream
 *                  ~Reader                     ~Writer
 *          ~InputStream / ~OutputStream
 *              => 이미지나 동영상 같은 바이트 형태의 데이터 입출력
 *              => 업로드 / 다운로드
 *          ~Reader/~Writer
 *              => 16bit(2byte) 문자 데이터를 입출력
 *              => 파일에 글쓰기 / 파일 읽어 온다
 *          
 *          메모리에 모아서 한번에 처리 => Buffered~
 *          
 *          => 객체단위로 저장
 *             ---------- 파일 프로그램
 *          => 파일 => 데이터베이스 변경
 *          => 파일에 저장
 *             ------- Open API => 파싱
 *             ------- 크롤링  => 임시 저장 저장 장소
 *             
 *             1. 데이터 종류
 *                  1) 정형화된 데이터 : 데이터베이스 안 저장 => 공유
 *                      => 웹/윈도우에 출력할 데이터만
 *                  2) 반정형화된 데이터 : 구분만 된 데이터
 *                                    HTML/XML/JSON/CSV
 *                                    => API
 *                  3) 비정형화된 데이터 : 구분이 없는 데이터
 *                                    뉴스 / 줄거리 / 댓글
 *                                    => 분석해서 필요한 데이터를 
 *                                      가지고 와서 정형화된 데이터
 *                                      --------------------
 *                                      빅데이터 => AI
 *                                      => 정규식
 *          FileInputStream / FileOutputStream => 이미지/zip
 *          => CheckException   => 예외처리가 필요
 */
public class IO_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
//        FileInputStream fis=null;
        FileReader fis=null;
        try
        {
            // 파일 읽기 => 358 page
//            fis=new FileInputStream("C:\\javaDev\\javaStudy\\Chapter11_IO라이브러리_2\\src\\com\\sist\\io\\IO_1.java");
            fis=new FileReader("C:\\javaDev\\javaStudy\\Chapter11_IO라이브러리_2\\src\\com\\sist\\io\\IO_1.java");
            int i=0;    // read() => int => char로 변환
            // 'A' => 65
            while((i=fis.read())!=-1)   // -1 파일이 끝나기 전까지 읽어라
            {
                System.out.print((char)i);
            }
            System.out.println();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                fis.close();
            }catch (Exception ex) {}
        }
    }

}
