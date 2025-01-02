package com.sist.execute;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // => A=1, B=2, C=3, D=4
        Scanner scan=new Scanner(System.in);
        System.out.println("A(1), B(2), C(3), D(4): ");
        int select=scan.nextInt();
//        if (select==1)
//        {
//            A a=new A();
//            a.execute();
//        }
//        else if (select==2)
//        {
//            B b=new B();
//            b.execute();
//        }
//        else if (select==3)
//        {
//            C c=new C();
//            c.execute();
//        }
//        else if (select==4)
//        {
//            D d=new D();
//            d.execute();
//        }
// => 상위클래스 I의 메서드 execute()를 오버라이딩 하여 각각 수행할 수 있다. 
        I[] i= {null, new A(), new B(), new C(), new D()};
        i[select].execute();
        // 데이터 혼합   => Object : 모든 데이터형을 받을 수 있다. 
        Object[] obj={"", 0, 0.0, false};
    }

}
