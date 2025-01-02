package com.sist.map;

public class UserMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Container c=new Container();
        Model model=c.getBean("food");
        model.execute();
        System.out.println(model);
        model=c.getBean("food");
        model.execute();
        System.out.println(model);  // 메모리 절약 => 싱글턴
    }

}
