package com.sist.lib;

import java.util.Objects;
/*
 * 
 *      hashCode()  => 객체의 구분자
 *      
 *      toString()  => 오버라이딩 => 객체의 주소값을 출력
 *      clone() => 복제해서 새로운 메모리에 저장
 *      
 *      hashCode()  => 객체마다 구분 번호를 가지고 있다
 */
class Member2
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
    
    public void print()
    {
        System.out.println("회원번호 :"+mno);
        System.out.println("이름 :"+name);
    }
    
    public Member2(int mno, String name) {
        super();
        this.mno = mno;
        this.name = name;
    }
    
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return Objects.hash(mno, name);
    }
    
    
}
/**
 * 
 */
public class 라이브러리_Object_5
{
    public static void main(String[] args) {
        Member2 m1=new Member2(1, "박문수");
        Member2 m2=new Member2(1, "박문수"); 
        System.out.println("m1.hashCode() : "+m1.hashCode());
        System.out.println("m2.hashCode() : "+m2.hashCode());
        m1.setMno(2);
        m1.setName("박문수");
        
        m2.setMno(3);
        m2.setName("홍길동");
        System.out.println("m1.hashCode() : "+m1.hashCode());
        System.out.println("m2.hashCode() : "+m2.hashCode());
        m2.setMno(2);
        m2.setName("박문수");
        
        if(m1==m2)
        {
            System.out.println(m1.hashCode()+" == "+m2.hashCode());
        }
        else
        {
            System.out.println(m1.hashCode()+" != "+m2.hashCode());
        }
        
    }
}
