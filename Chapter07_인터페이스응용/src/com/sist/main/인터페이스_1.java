package com.sist.main;

/**
 *      1. 인터페이스 사용 목적
 *          = 서로 다른 클래스를 묶어서 한개의 인터페이스명으로 연결 
 *            리모콘의 역할
 *          = 결합성이 낮은 프로그램
 *            --------- 수정시에 다른 클래스가 오류 ... (영향이 없는 프로그램)
 *            ===> 스프링 (로드존슨)
 *          = 개발자들이 같은 메서드를 사용 : 표준화
 *          = 독립적으로 사용이 가능
 *          = 확장이 가능
 *            -------- JDK 1.8
 *            default / static => 구현된 메서드 처리가 가능
 *            => 추상 클래스 대체 인터페이스를 많이 사용
 *      2. 여러개의 기능을 동시에 상속이 가능
 *         ------------------------- 다중 상속
 *      3. 인터페이스는 자신이 메모리 할당이 불가능하다
 *         상속 후에 상속받은 클래스가 미구현된 메서드 구현 후 사용
 *         인터페이스 객체 = new 상속받은 클래스 생성자()
 *         => 오버라이딩 기법을 사용
 *      4. 인터페이스에서는 반드시 상속받는 클래스가 동일한 기능을 가지고 있어야 한다. 
 *      -------------------------------------------------------------
 *      문법
 *      1. 구성요소
 *          = 변수 ====> 상수형 변수만 사용
 *                      -------- 초기값을 반드시 지정
 *                      int a=100;
 *          = 메서드 : 구현이 안된 메서드 (추상메서드)
 *                     
 *          --------- 변수/메서드는 only public
 *          
 *            = default / static 메서드는 구현이 가능
 *      ---------------------------------------------
 *      2. 구현 후 객체 생성
 *         interface A
 *         class B implements A
 *             하위클래스      상위클래스
 *               => A a=new B();
 *               => 확인 : instatnceOf
 */
interface A
{
    public void aaa();
    public void bbb();
    public void ddd();
    public void ccc();
    public void eee();
}
public class 인터페이스_1{

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        A a=new A() {                   // 익명의 클래스
//
//            @Override
//            public void aaa() {
//                // TODO Auto-generated method stub
//                
//            }
//
//            @Override
//            public void bbb() {
//                // TODO Auto-generated method stub
//                
//            }
//
//            @Override
//            public void ddd() {
//                // TODO Auto-generated method stub
//                
//            }
//
//            @Override
//            public void ccc() {
//                // TODO Auto-generated method stub
//                
//            }
//
//            @Override
//            public void eee() {
//                // TODO Auto-generated method stub
//                
//            }
//            
//        };
        // 쉽게 구현    => 람다식  ->

    }

}
