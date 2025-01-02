package com.sist.execute2;
class Sub // extends Object 생략
{
    // Object => 모든 메서드 사용이 가능
    // Sub sub=new Sub(), Object obj=new Sub()
    int a=10;

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        System.out.println("Sub...");
        return "";
    }
    
}

public class MainClass {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Object obj=new Sub();
        // 묶어서 한개로 관리
        obj.toString();
        /*
         * 상위클래스는 하위클래스의 추가된 메서드나 변수에 접근이 불가능 
         */

    }

}
