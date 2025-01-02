package com.sist.lib;

/**
 *      객체 복제
 *      = 같은 메모리 주소 사용 (같이 사용)  => 얕은 복사
 *      A a=new A()
 *      A b=a   ==> 주소 참조 (Call by Reference)
 *      = 다른 메모리 주소 사용 (따로 사용)  => 깊은 복사
 *      A a=new A()
 *      A b=a.clone()   => 새로운 메모리 생성 
 */
class Member implements Cloneable
{
    private int mno;
    private String name;
    public int getMno() {
        return mno;
    }
    public void setMno(int mno) {
        this.mno = mno;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    // 초기화
    public Member(int mno, String name) {
        this.mno = mno;
        this.name = name;
        // 지역변수 우선순위 => 멤버변수와 구분하기 위해서 THIS.
        // 모든 클래스는 this를 가지고 있다 => 클래스 자신의 객체표현
        // static => this를 사용할 수 없다 => 공유
    }
    
    // 오버라이딩 => clone() => 재정의
    // 메모리를 통째로 복사해서 새로운 메모리에 저장
    // 스프링 => prototype
    // 디자인패턴 => prototype 패턴
    // GOF 패턴 => 23가지 MV, MVC, MVVM, Factory, Singleton
    // 8 => 컴바운드 패턴
    // => C/C++ => 프로그램(라이브러리) => 구조는 변경 안됨
    //                                ---
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }
    
    public void print()
    {
        System.out.println("회원번호: "+mno);
        System.out.println("이름: "+name);
    }
    
}
public class 라이브러리_Object_3 {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        // 얕은 복사 => 두개의 객체를 한개의 주소에서 처리
        Member m1=new Member(1, "홍길동");
//        Member m2=m1;
//        m1.print();
//        m2.print();
//        m2.setMno(3);
//        m2.setName("박문수");
//        m2.print();
//        m1.print();
//        // 객체가 가지고 있는 주소가 같으면 => 같은 메모리를 제어
//        System.out.println("m1: "+m1);
//        System.out.println("m2: "+m2);
      
        Member m2=(Member)m1.clone();   // 복제   => 게임 (아바타 복제)
        m1.print();
        m2.print();
        System.out.println("m1: "+m1);
        System.out.println("m2: "+m2);
        m2.setMno(3);
        m2.setName("박문수");
        m1.print();
        m2.print();
        
    }

}
