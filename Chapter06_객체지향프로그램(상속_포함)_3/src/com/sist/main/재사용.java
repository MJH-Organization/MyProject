package com.sist.main;

/**
 *      논리적 관계
 *      1.  상속: is-a
 *          동물 ani=new 개()  =>   개는 동물이다
 *          
 *          동물
 *           |
 *   ----------------
 *   |      |       |
 *   개      소       말   위로 올라간다 | is-a
 *           
 *      2. 포함 : has-a   : 클래스안에 클래스를 포함
 *      ------------------------------------- 클래스 크기
 *      객체 전체가 4byte를 가지고 있다 
 *      =>  형변환
 *          ----
 *          자동 형변환 (묵시적 형변환) 
 *          상위클래스 객체=new 하위클래스생성자() 
 *          double d=10 => 10.0 
 *          강제 형변환 
 *          int a=(int)10.5
 *          하위클래스 객체=(하위클래스)new 상위클래스()    => 오류
 *          ----------------------------------
 *              => 라이브러리는 클래스를 리턴할 경우
 *                 ------------------------
 *                          | Object / 매개변수가 Object
 *                          | Collection
 */
import java.util.*;

class Sawon
{
    String name;
    String dept;
    String loc;
    
    public void display()
    {
        System.out.println("이름: "+name);
        System.out.println("부서: "+dept);
        System.out.println("근무지: "+loc);
    }
}
public class 재사용 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        ArrayList list=new ArrayList();
        ArrayList<Sawon> list=new ArrayList<Sawon>();
        Sawon s1=new Sawon();
        s1.name="홍길동";
        s1.dept="개발부";
        s1.loc="서울";
        list.add(s1);
        
        // Object obj=list.get(0);  => obj.display() (X)
//        Sawon s=(Sawon)list.get(0);
        Sawon s=list.get(0);
        s.display();
    }

}
