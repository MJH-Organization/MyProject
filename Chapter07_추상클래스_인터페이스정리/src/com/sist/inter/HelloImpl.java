package com.sist.inter;
/*
 *      => Service 구현
 *      
 *      사용자요청   => Controller   ==> Service => ServiceImpl
 *      
 *      MainClass ===> Hello ===> HelloImpl
 */
public class HelloImpl implements Hello{

//    @Override
    public void sayHello(String name) {
        // TODO Auto-generated method stub
        System.out.println(name+" 님 환영합니다!!");
    }
    

}
