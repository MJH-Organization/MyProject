package com.sist.main;
/*
 *     상속을 받아서 구현해서 사용
 *     --------------------
 *     오버라이딩
 *      = 메서드명 동일
 *      = 매개변수 동일
 *      = 리턴형 동일
 *      = 접근지정어는 확대할 수 있다, 축소하면 오류
 *                              ----------
 *        private < default < protected < public
 *        
 *        interface A
 *        {
 *              void display();
 *              
 *        }
 *        
 *        class B implements A
 *                ---------- 상속
 *        {
 *              void display() {}   => 오류
 *        }
 *        
 *        상속
 *                     extends
 *        interface ===========> interface
 *                   implements
 *        interface ===========> class
 *        
 *        interface A
 *        interface B extends A => A, B
 *        interface C extends B => A, B, C
 *        
 *        interface A
 *        interface B
 *        interface C extends B, A
 *                            ----- 다중 상속        
 *        
 *        interface A
 *        interface B
 *        class C   implements B, A
 *                  -----------
 *      
 *        interface A
 *        interface B
 *        class C  
 *        class D extends C implements B, A
 *        class Window extends JFrame implements KeyListener, MouseListener
 *                  
 *        인터페이스
 *        -------          
 *          1) 윈도우 : 이벤트 관련
 *          2) 쓰레드 : 동작을 개발자
 *          3) 데이터베이스 연결
 *          4) 웹 연동
 *          -------------------- 메서드는 제공
 *                               프로그램에 맞게 구현
 *      -----------------------------------------
 *      
 *              | 아이템 => 기획
 *      = 설계 (요구사항) : 아키텍처  => 사이버다임
 *      = 데이터베이스 설계 : DBA
 *      = 화면 UI : HTML/CSS/JavaScript => 퍼블리셔                         
 *      ***= 구현 : 웹 개발자
 *      = 테스트 : 테스터
 *      = 배포 : 웹 개발자
 *      -----------------------------------------    
 *                           
 */
interface AA
{
    /*(public static final)*/ int d=100;
    /*(public abstract)*/ void aaa();   // 선언만 하는 메서드
    /*(public)*/ default void bbb()
    {
        
    }
    /*(public)*/ static void ccc()
    {
        
    }
    
}

class BB implements AA
{
    BB b = new BB();
    public void aaa()
    {
        
    }
    
}
public class 인터페이스_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
