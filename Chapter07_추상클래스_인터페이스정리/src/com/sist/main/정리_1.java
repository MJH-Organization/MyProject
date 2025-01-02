package com.sist.main;

/**
 *      7장 => 클래스 종류 (추상클래스/인터페이스)
 *              => 형식, 사용처
 *      추상클래스
 *          => 구현이 안된 메서드를 가지고 있다
 *          => 객체를 직접 생성이 불가능
 *          => 사용시에는 상속을 받은 하위클래스에서 확장해서 사용
 *          => 역할 / 필요성
 *             상속을 통해서 코드를 재사용  => 강제로 메서드 구현을 하는 역할
 *                                      -------------
 *                                      확장성 / 유지보수가 용이         
 *             확장성 => 상속을 받아서 오버라이딩 기법을 사용한다
 *                                ------- 
 *                                기능 변경 => 메서드를 변경
 *          => 형식)
 *             public abstract class ClassName
 *             {
 *                  ----------------------------------------------------
 *                  변수
 *                      멤버변수 (인스턴스변수)
 *                      정적변수 (static 변수)
 *                  ----------------------------------------------------
 *                  생성자 : 변수 초기화
 *                  ----------------------------------------------------
 *                  구현된 메서드 : 필요시에만 오버라이딩
 *                               => 있는 그대로 사용이 가능
 *                  ----------------------------------------------------
 *                  미구현된 메서드 : 상속시에 강제로 구현
 *                  ----------------------------------------------------
 *             }
 *             ==> 관련이 있는 클래스 여러개를 모아서 관리
 *                 -------------------
 *                 기능이 비숫한 클래스
 *                 --------------- 웹(Medel)
 *                  ** Model    => 사용자 요청처리 => 결과값을 부라우저로 전송
 *                 => 소스가 간결하다 (조건문 없이 사용이 가능)
 *                 => Map클래스를 이용해서  클래스를 싱글턴으로 처리
 *                    -------- 메모리 절약
 *      인터페이스 : 추상클래스의 단점을 보완한 클래스의 일종
 *      ------- 자바에서 객체가 어떻게 행동해야 (동작) 정의한 타입
 *              => 주로 메서드만 사용한다
 *              => 이런 기능을 가지고 있다 (기능 설계)
 *              => 사전적 의미 : 결합성, 접속기
 *                            ----- ----- 리모콘
 *                            서로 다른 클래스 연결해서 사용
 *                 => 컴퓨터와 사용자간 통신
 *                    API(Application Program Interface
 *              => 장점
 *                 1) 코드의 표준화 : 같은 메서드를 사용
 *                                 => 내용 구현은 다를 수 있다                 
 *                 2) 설계만 되어 있다 => 구현은 프로그래머가 
 *                    ------------ 프로그램에 맞춰서 구현
 *                 3) 다른 클래스와 연결시에 편리
 *                 4) 결합성을 낮게 만든다
 *                 5) 다중 상속이 가능하다
 *                 6) ************ 소스의 통일화  => 분석이 쉽다
 *                                 --------- 
 *                                 FrameWork (형식이 동일)
 *                                 | 스프링 / Jquery / VueJS / React    
 *                 7) 독립적으로 사용이 가능 (원격) : ServerSocket / Socket
 *                 8) 유지보수가 쉽다
 *                 9) 여러개 클래스를 모아서 관리 (한개의 객체명으로 제어)
 *              형식) => 모든 구성요소가 only public
 *                   => 수정없이 고정해야 된다
 *                      (보완)
 *                  public interface interface명
 *                  {
 *                          --------------------------------------------
 *                          변수  => 상수형 변수만 사용이 가능
 *                          (public static final)   데이터형 변수명 = 값;
 *                              사용할 수도 있고 생략도 가능
 *                          --------------------------------------------
 *                          구현이 안된 메서드
 *                          (public abstract)   리턴형 메서드명(매개변수...);
 *                           ---------------
 *                          --------------------------------------------
 *                          JDK 1.5 추가   => 개발자가 요청
 *                          구현이 된 메서드
 *                          default 리턴형 메서드(매개변수)
 *                          {
 *                          }
 *                          --------------------------------------------
 *                          static 리턴형 메서드(매개변수)
 *                          {
 *                          }
 *                          --------------------------------------------
 *                          
 *                  }
 *              
 *      ***
 *          컴파일러가 자동 추가하는 소스
 *          1) import java.lang.*;  => 생략
 *                    ----------- String, System ...
 *          2) 모든 클래스는 Object 상속이다
 *             --------
 *             => 사용자 정의
 *             => 라이브러리
 *             public class ClassName extends Object
 *                                    --------------
 *          3) 메서드 => void => return을 생략 시에
 *             public void display()
 *             {
 *                  return; => 생략
 *                  ------- 메서드의 종료
 *             }                      
 *          4) 인터페이스
 *             변수 => (public static final)
 *             메서드 =>  (public abstract)
 *             default => (public)
 *             static => (public)    
 *             
 *      추상클래스
 *          상속 => 단일 상속만 가능 => 확장 (extends)
 *      인터페이스
 *          상속 => 다중 상속이 가능 => 메서드 구현 (implements)
 *          
 *                 extends
 *      => 인터페이스 ===> 인터페이스
 *                 implements
 *         인터페이스 ===> 클래스
 *         (클래스 ===> 인터페이스) => 사용이 불가능
 *      => 다중상속 => 윈도우 / 네트워크
 *         => 웹에서는 주로 단일 상속
 *         interface A
 *         interface B
 *         
 *         class C implements A,B
 *                            ---- 다중상속 ,
 *         *** 관련된 클래스 여러개를 묶어서 인터페이스 1개 제어
 *             => 소스 간결하게 만든다                      
 */
interface I
{
    public void aaa();  // 강제성
    public void bbb();
    default void ccc()
    {
    }
    static void ddd()
    {
        
    }
}
class A implements I
{

    @Override
    public void aaa() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void bbb() {
        // TODO Auto-generated method stub
        
    }
    
    
}
class B implements I
{

    @Override
    public void aaa() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void bbb() {
        // TODO Auto-generated method stub
        
    }
}
class C implements I
{

    @Override
    public void aaa() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void bbb() {
        // TODO Auto-generated method stub
        
    }
    
    public void ccc() {
        
    }
}

public class 정리_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
