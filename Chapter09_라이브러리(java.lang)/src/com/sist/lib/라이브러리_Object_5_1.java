package com.sist.lib;

import java.util.ArrayList;
class Movie
{
    private int no;
    private String title;
    
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public Movie(int no, String title) {
        this.no = no;
        this.title = title;
    }
    
}
//  getClass() => 클래스 타입 (패키지명 클래스명을 찾는 경우)
// => 객체 생성 => 복제 => 소멸 => 비교
public class 라이브러리_Object_5_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Movie m1=new Movie(1, "홍길동전");
        System.out.println(m1.getClass());  // 데이터형
        String s="";
        System.out.println(s.getClass());
        Movie m2=new Movie(2, "심청전");
    }

}
