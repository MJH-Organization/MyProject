package com.sist.exception;

/**
 *      263 page
 *      예외 : 수정이 가능한 에러(가벼운 에러)
 *          = 사전적 의미 : 일반적이지 않은 상황
 *              => 프로그램에서 문제 발생
 *              => 사용자의 입력이나 제어 => 유효성 검사
 *                                     ---------
 *                                     자바스크립트
 *                                     => 자바 : if
 *                                     => 스프링 : validation
 *              => 개발자의 실수
 *                 ----------
 *                 본인이 에러 => 찾기가 어렵다
 *                 ----------------------
 *                 => 소스를 비교 (X)
 *                 => Output 창 => 디버깅
 *                 => 실무에서 에러처리 (퇴근) 
 *              ---------------- 비정상 종료 : 방지하는 프로그램
 *                               -----------------------
 *                               예외처리 => 정상 종료를 할 수 있게 만든다
 *                  
 *      에러 : 수정이 불가능 (치명적인 에러) => 메모리 부족, 인터넷 문제
 *  -------------------------------------------------------
 *      자바 : 
 *           javac : 컴파일, java : 인터프리터 (런타임)
 *           컴파일에러 : 컴파일시에 에러 => 문법에러
 *           런타임에러 : 실행시에 에러 => 사용자 입력 / 출력 => 배열범위 초과
 *           ------- 에러가 발생, 발생하지 않을 수 있다
 *           논리적에러 : 웹에서 발생
 *                     --------
 *                     실행은 된다   => 프로그램과 다르게 동작
 *           프로그램에서 가장 중요
 *           => 다른 개발자가 분석 => 가독성 (개발 / 유지보수)
 *           => 속도 => 최적화 
 *           => 견고성 : 에러 발생시 종료하지 않고 정상 수행이 가능하게 만든다
 *              =====
 *              1) 에러를 사전에 방지하는 방법
 *                 --------------------
 *                 우선시 => if문 => 처리가 어려운 문장
 *              2) 예외처리가 등장
 *                 *** 변수 초기값
 *                 우선시 : 명시적 초기화
 *                 => 명시적 초기화가 안되는 경우 => 외부에서 읽어서 데이터 대입
 *                 => 생성자 / 초기화블럭
 *                 => 
 *              => 가벼운 에러 => 수정이 가능한 에러
 *                 예)
 *                      FileReader fr=new FileReader("경로명/파일명")
 *                                                    --------- 수정
 *                      Document doc=Jsoup.connect("URL주소").get();
 *                                                 ------- 수정
 *                      Socket socket=new Socket("서버주소", port)
 *                                              ---------------- 수정
 *                      웹에서 번호로 표시 (브라우저)
 *                      -------------
 *                          웹 => URL주소 => 마지막에 파일명을 지정
 *                                         ----------------
 *                                         | 없는 경우 => 명령어 (MVC)
 *                          404 / 500 / 400 / 412 / 403
 *                                                  --- 스프링 보안 (접근거부)
 *                                            --- GET/POST/PUT/DELETE
 *                                      --- Bad Request
 *                                --- 자바소스가 오류
 *                          --- 요청한 파일이 없는 경우     
 *              => 0으로 나눈 경우 / 정수변환 / 배열범위 초과
 *                 NumberFormatException
 *                 ArrayIndexOutOfBoundsException
 *              => 메모리 할당   => 주소가 없는 경우
 *                 NullPointerException
 *              => 매개변수에 값 전송 (다른 값을 전송)
 *              => 클래스 형변환 ...
 *                 ClassCastException => 264 page
 *           265 page
 *           예외처리의 종류
 *              예외복구 : try ~ catch ~ finally => 가급적이면 예외처리로 주로 사용
 *                  : 예외가 발생하면 복구해서 다시 수행이 가능
 *                  *** 예외나 에러가 없게 프로그램을 제작
 *                  형식)
 *                      try
 *                      {
 *                              정상 수행 문장
 *                              => 예외가 발생할 수 있다
 *                              => main => 평상시 코딩
 *                              예외 발생
 *                                   | catch 이동
 *                      }catch(예외클래스)
 *                      {
 *                              에러가 발생시에 복구 / 에러 확인
 *                              => 에러 확인
 *                                 ------
 *                                 에러메세지 출력 getMessage()
 *                                 에러위치 확인 printStackTrace()
 *                                 ---------------------------
 *                                 권장 사항
 *                      }
 *                      finally
 *                      {
 *                          try / catch 상관없이 무조건 수행하는 문장이 있는 경우
 *                          => 서버 연결 해제
 *                          => 오라클 닫기 (**********)
 *                          => 파일 닫기
 *                          => 생략이 가능
 *                      }
 *                      
 *                      catch => 멀티 (여러개 동시에 사용)
 *                      
 *                      예상되는 에러를 따로 잡아서 복구
 *                      try
 *                      {
 *                      }catch(ArrayIndexOutOfBoundsException e)
 *                      {
 *                      }catch(NumberFormatException e)
 *                      {
 *                      }catch(NullPointerException e)
 *                      {
 *                      }
 *                      
 *                      예상 에러를 확인
 *                      try
 *                      {
 *                      }catch(RuntimeException e)
 *                      {
 *                      }
 *                      
 *                      예외를 동시에 처리
 *                      try
 *                      {
 *                      }catch(ArrayIndexOutOfBoundsException e|NullPointerException e)
 *                      {
 *                      }
 *                      
 *                      일반적으로 사용
 *                      try
 *                      {
 *                      }catch(Exception e)
 *                      {           |
 *                              모든 예외를 처리
 *                      }
 *                      
 *              => 서버/오라클 연동
 *              try
 *              {
 *                      오라클 연결
 *                      SQL문장 전송    => SQL
 *                      결과값 받기
 *              }catch(Exception e)
 *              {
 *                      오류발생 => 확인
 *              }
 *              finally
 *              {       
 *                      오라클 닫기
 *              }    
 *              
 *              => 266 page
 *                 자바에서 지원하는 클래스 (라이브러리)
 *                 = CheckException : 컴파일시에 예외처리여부 확인
 *                  => 반드시 예외처리를 해야 사용이 가능
 *                  => java.io / java.sql / java.net
 *                     : IOException
 *                     : SQLException
 *                     : MalformedURLException
 *                  => java.lang    => 리플렉션
 *                     : ClassNotFoundException
 *                     : InterruptedException : 쓰레드 => 충돌방지
 *                  => javax.http.* => JSP => (X)
 *                  => jakarata.http
 *                     -------------
 *                     이클립스 => 톰캣   => 
 *                     ------ 최신    => 10버전 => 스프링에서 (스프링부트)
 *                     => 스프링 편집기 => JDK / 톰캣
 *                      
 *                 = UnCheckException : 예외처리여부 확인이 없다
 *                  => 필요시에만 예외처리
 *                  => NullPointException : 클래스를 메모리 할당이 없는 
 *                     선언만 한 경우 => 윈도우
 *                  => NumberFormatException : 문자열 => 정수 변환
 *                  => ArrayIndexOutOfBoundsException
 *                  => ClassCastException
 *                  => ArithmeticException : 0으로 나눈 경우 처리
 *                     => if
 *                  => 한번에 처리가 가능 : RuntimeException
 *              ---------------------------------- Exception          
 *                 계층구조         
 *                                  Object => 최상위 클래스 (모든 클래스는 Object로 상속)
 *                                     |
 *                                Throwable
 *                                     |
 *                     ---------------------------------
 *                     |                                |
 *                   Error                          Exception
 *                                      Check           |           UnCheck
 *                                      --------------------------------   
 *                                      |                               |
 *                                  IOException                  RuntimeException
 *                                  SQLException                        |
 *                                  ...                         NullPointerException
 *                                  ...                         ...                                              
 *                                                              ...
 *                     => 상위클래스일수록 예외처리 범위가 커진다
 *                     => 267 page
 *              ------------------------------ 면접                                                
 *              => 5장 ~ 8장 사이에서 면접     
 *                  => Collection                          
 *              => 정의 : 사전에 에러를 방지 프로그램
 *              => 목적 : 프로그램의 비정상 종료를 방지하고 정상상태 유지
 *       
 *       => try ~ catch 동작
 *          
 *          try
 *          {
 *              문장1
 *              문장2
 *              문장3
 *          }catch(예외처리클래스)
 *          {
 *              문장 4
 *          }
 *          
 *          => 문장 1, 문장 2, 문장 3만 수행
 *          => 오류가 없는 경우에는 try 안에 있는 문장만 수행
 *             -------------- 정상
 *             
 *              try
 *          {
 *              문장1
 *              문장2 => 오류 발생 => catch 를 수행
 *              문장3
 *              => 오류발생위치부터 try에 있는 문장 스킵
 *          }catch(예외처리클래스)
 *          {
 *              문장 4
 *          }
 *          
 *          => 문장 1, 문장 4 => 종료
 *              
 *              예외회피 : throws => 메서드 선언 뒤에 서술
 *                       => 예약, 떠맡기기 => 다음에 사용시에 예외처리를 해서 사용해라
 *                       => 라이브러리에서 주로 제공
 *              임의로 발생 : 테스트, 배포 전에 확인 => throw
 *                         정상상태 유지
 *                         throw new Exception();
 *              사용자 정의 예외 : 자바에서 지원하지 않는 예외처리가 있는 경우
 *                             class MyException extends Exception
 *                             {
 *                             }
 *                             => if문으로 사용이 가능
 *                             => 비밀번호 => 대소문자 + 특수문자 + 8자이상
 *                                       => length() + 정규식   
 *           예외처리 크기 (계층)   => catch    => 순서지정
 *           
 */
public class 예외처리_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
