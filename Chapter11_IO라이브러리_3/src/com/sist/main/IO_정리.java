package com.sist.main;
/*
 *      IO => java.io => CheckException => 예외처리 후 사용
 *                       -------------- 
 *                       | java.sql / java.net / java.lang.Thread
 *      1) 특징
 *          = 단방향 => Input / Output (빨대)
 *              => 읽기/쓰기 => 쓰레드 이용해서 처리
 *              => 네트워크 : 전송(쓰기)    => 수신(읽기)
 *                         --------       ------- Thread
 *              => Thread는 프로그램 안에서 다른 프로그램 여러개를 동시에 수행
 *              => 예) 비행기 / 총알 => 시분할 (시간을 나눠서 처리)
 *          = 데이터 이동하는 통로 : Stream
 *          = Queue 방식이다 => FIFO (먼저 들어간 것이 먼저 나오게)
 *      2) 종류
 *          = 바이트 송수신 = 바이트 스트림
 *              => 1byte 읽기/ 1byte 쓰기
 *              => 동영상 / 이미지 / zip....
 *              => ~InputStream / ~OutputStream
 *              => 웹) 업로드 / 다운로드 / 웹 데이터 읽기
 *                 네트워크에서 주로 사용
 *          = 문자 송수신 = 문자 스트림  
 *              => 2byte 읽기 / 2byte 쓰기
 *              => 한글을 포함한 한글제어
 *              => ~Reader / ~Writer
 *          = ~InputStream / ~OutputStream
 *              => FileInputStream / FileOutputStream
 *              => ObjectInputStream / ObjectOutputStream                                        
 *          = ~Reader / ~Writer
 *              => FileReader / FileWriter
 *          = 속도를 최적화 => 필터스트림
 *              => BufferedInputStream / BufferedOutputStream
 *              => BufferedReader / BufferedWriter
 *      3) 사용되는 곳
 *                  입력스트림                               출력스트림
 *          사용자 ======================== 자바프로그램 ===================== 화면
 *          (키보드, 마우스)                  응용프로그램                      모니터 / 브라우저
 *          
 *          메모리에서 입출력 : BufferedReader => readLine()
 *          파일에서 입출력 
 *              바이트 스트림 (~InputStream, ~OutputStream)
 *                  => read()   => 한글자씩 읽어온다
 *                      => int  => 글자의  코드번호(ASCII)
 *                  => read(byte[], int off, int len)
 *                      => int  => 읽은 글자수
 *                  => write(int)
 *                  => write(byte[]) => String을 byte[] 로 변환
 *                                      => getBytes()
 *                  => byte를 읽어서 출력 => 이미지 등 전송에 사용
 *              문자 스트림 (~Reader, ~Writer)
 *                  => read()   => int
 *                  => read(char[], int, int)
 *                  => write(int)
 *                  => write(char[])
 *                  => *****write(String)
 *                  => 파일 제어 => 읽기/쓰기
 *          네트워크 입출력
 *          --------------- 스트림을 이용한다
 *          스트림 => 안전성
 *           | 메모리에 저장된 데이터를 읽어 온다 => 절대 잊어버리지 않는다
 *           | 소켓프로그램 => 신뢰성이 좋다
 *              | 이메일(smtp) 파일업로드(FTP), TELNET
 *          
 *          표준 입출력
 *          = System.in / System.out
 *          public final class System
 *          {
 *              public static InputStream in;
 *                            => read()
 *              public static OubputStream out;
 *                            => print()
 *          }    
 *      4) 파일 모드
 *          r => ~InputStream/~Reader => 읽기 전요 
 *          w => ~OutputStream/~Writer => Create
 *              => 덮어쓴다
 *          a => new FileWriter("파일명", true)
 *                                      ----
 *      5) 객체 단위 저장
 *         ----------
 *         ObjectInputStream / ObjectOutputStream
 *         --------------------------------------
 *         | 읽기 / 쓰기 / 수정 / 삭제 / 검색
 *         | 제어는 ArrayList => 저장 (ArrayList를 통으로 저장)
 *         | 직렬화 / 역직렬화
 *           ------------
 *           
 *      6) XML, CSV, JSON, JSONP
 *         ---  ---  ----
 *                   자바 = 자바스크립트 연동
 *              데이터베이스 백업용
 *          스프링(클래스 등록)
 *         --------------
 *         
 *      7) 독립적인 클래스 (.properties) => Map (키=값)
 *         ----------
 *         File : 파일정보 / 디렉토리(폴더) 정보
 *         생성
 *          new File("경로명\\폴더명")
 *          new File("경로명\\파일명")
 *         주요 기능
 *          getName() : 파일명만
 *          getPath() : 경로+파일명
 *          isFile() : 파일여부 확인
 *          length() : 파일 크기 => long
 *          --------------------------
 *          listFiles() : File[] => 폴더 안에 있는 모든 정보
 *          mkdir() : 폴더 만들기
 *          creadNewFile() : 파일 만들기
 *          delete() : 파일 삭제
 *          exists() : 존재여부 확인
 *          
 *         read() / write()
 *         => BufferedReader => readLine()
 *         => 파일은 반드시 닫기를 한다   
 *    --------------------------------------------------------
 *    웹 => 자바에서 주로 사용
 *       데이터 관리 : 오라클 / 파일 => 영구적인 저장 장치
 *                          | 노출 => 보안 취약
 *                   | SQL
 *           | 오라클: 90%, 파일: 10%
 *           --------------------- 12장
 *    
 *    라이브러리 공부는...                       
 *    => 클래스명
 *          => 역할
 *          => 메서드 => 리턴형 / 매개변수
 *                     -------------       
 */
// 키보드로 입력을 받아서 처리
import java.util.*;
import java.io.*;
public class IO_정리 {
    
    public static void main(String[] args) {
        try
        {
            /*
            // 웹 => 데이터/HTML
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            // Scanner => 가장 단순한 입력클래스
            System.out.print("문자열 입력:");
            String msg=in.readLine();   // enter => 메모리에 저장
            System.out.println(msg);
            
            // 명령프롬프트(X) => 입력창 / 출력창
            //               브라우저 (윈도우)
             */
            
            System.out.print("입력:");
            int data=System.in.read();
            System.out.println((char)data);
            
        }catch(Exception ex) {}
    }

}
