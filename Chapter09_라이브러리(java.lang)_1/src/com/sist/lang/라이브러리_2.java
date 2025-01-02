package com.sist.lang;

/**
 *      java.lang
 *          1. Object
 *             : 최상위 클래스 => 모든 클래스의 상위클래스
 *               ---------- 
 *               관리하는 기능 : 객체와 관련
 *               객체 소멸 / 객체 복제 / 객체 비교 / 객체 생성
 *               -------   ------   -------   -------
 *                                            getClass()
 *                                  **equals()
 *                         **clone()
 *               finalize()
 *          2. String : 문자열을 관리하는 클래스
 *             => 웹에서 3대 클래스
 *                String / ArrayList / Integer
 *             => 오라클 연동 3대 클래스
 *                Connection / ResultSet / Statement
 *                
 *             기능
 *              1) trim() : 공백 제거(좌우)
 *              2) length() : 문자 갯수
 *              3) substirng() : 문자를 자르는 경우
 *              4) indexOf/lastIndexOf => 문자위치 찾기
 *              5) equals() : 문자비교
 *                 ----------------- 로그인
 *              6) contain() : 포함 문자열
 *              7) startsWith() : 시작 문자열 => 방문한 맛집
 *                 food_1 food_2
 *              **8) valueOf() => 다른 데이터형 문자열 변환
 *                   윈도우 프로그램 => Cookie
 *                                  ------ 저장값이 String
 *              9) replace() / replaceAll()
 *              10) split()
 *              ---------------------------------------------   
 *          3. StringBuffer
 *          4. Math : random() / ceil()
 *              => 모든 메서드가 static으로 만들어짐
 *              => Math.random() Math.ceil()
 *          5. System : println() / print() / printf()
 *                      gc(), exit(0) => 윈도우
 *          6. Wrapper 
 *             : 기본형(데이터형)을 클래스화 시켜서 사용이 편리하게 만든
 *               byte ===> Byte
 *               short ===> Short
 *               ***int ===> Integer
 *               ***long ===> Long
 *               float ===> Float
 *               ***double ===> Double
 *               char ===> Character
 *               ***boolean ===> Boolean
 *               ------------------------ 기능 (메서드)
 *          
 *          10장
 *              날짜 / 문자열 자르기 / 문자열 변환
 *              --------------------------
 */
import java.io.*;
public class 라이브러리_2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try
        {
            // log 파일 만들때
            long start=System.currentTimeMillis();
            FileReader fr=new FileReader("c:\\javaDev\\movie.txt");
            int i=0;    // 문자를 받는 경우
//            String data="";     // 문자열 결합
            StringBuffer sb=new StringBuffer();
            while ((i=fr.read())!=-1)
            {
                sb.append((char)i);
//                data+=(char)i;
            }
            fr.close();
//            System.out.println(data);
            String data=sb.toString();
            System.out.println(data);
            // 문자열 제어는 String
            // 문자열 결합 => StringBuffer (비동기적) 데이터 크롤링 => 쓰레드
            //             StringBuilder (동기적)
            long end=System.currentTimeMillis();
            System.out.println("걸린시간:" + (end-start));
        }catch(Exception ex) {}
    }

}
