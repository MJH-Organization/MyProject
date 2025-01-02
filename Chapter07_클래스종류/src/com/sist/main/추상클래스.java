package com.sist.main;

/**
 *      추상클래스
 *      = 주목적
 *        관련된 클래스를 모아서 한개의 객체명으로 관리
 *        (서로 다른 클래스를 연결해서 사용)
 *      예)
 *          게시판
 *          ----- 글쓰기, 목록, 수정, 상세보기, 삭제, 검색 
 *          | 묻고답하기 : 답하기
 *          | 자료실 : 다운로드/업로드
 *          | 댓글형게시판 : 댓글
 *          | 갤러리게시판 : 이미지
 *          
 *          => 요구사항 분석 / 설계
 *      = 단점
 *          = 단일 상속만 가능
 *          = 미완성 (메서드 구현이 안된 경우)
 *            new 를 이용해서 객체를 생성할 수 없다
 *          = 상속을 받아서 메서드를 구현 후에 사용
 *            new 구현된 클래스의 생성자()
 *            ----------------------> 오버라이딩
 *          = 선언된 메서드 + 선언이 안된 메서드  
 *      = 형식)
 *          => 유지보수가 어려운 프로그램
 *          => 설계
 *          public abstract class ClassName
 *          {
 *              -------------------------
 *              변수 : 멤버변수
 *              -------------------------
 *              생성자
 *              -------------------------
 *              메서드 : 구현 메서드
 *              -------------------------
 *              메서드 : 구현 메서드 선언 => 상속받는 클래스의 공통적인 부분
 *              -------------------------
 *          }
 *          public abstract class A
 *          public class B extends B
 *          {
 *          }
 *          A a=new B();
 *          
 *          추상클래스   => 공통점을 가지고 있는 클래스
 *                       --------------------
 *          추상클래스의 대표적
 *          동물
 *          --- 먹는다 / 걷는다 / 말한다 .....
 *          
 *          사람 : 먹는다 / 걷는다 / 말한다
 *          개 : 먹는다 / 걷는다 / 말한다
 *          소 : 먹는다 / 걷는다 / 말한다
 *          돼지 : 먹는다 / 걷는다 / 말한다
 *          말...
 *          
 *          => 관련된 클래스를 묶어서 처리 
 *             학생 => 초등학생 / 중학생 / 고등학생 / 대학생 ....
 *          => 설계   => 프로그램에 맞게 구현    
 *             --- 예약    
 *                 영화예약 / 맛집예약 / 항공사 예약 ....    
 *          예)
 *              버튼 클릭() => 선언
 *              더블 클릭() => 
 *              ------------------- 개발자 => 상황에 맞게 처리
 *              로그린 버튼 => 버튼 클릭()
 *              계산기 버튼
 *              검색 버튼
 *              
 *         -------------------------------- 추상클래스 => 인터페이스     
 *         => 다중 상속     
 *         => 구현이 안된 메서드만 사용     
 *         => 변수 = 상수
 *         => 다른 영향이 없게
 *         --------------------------------     
 */
import java.util.Scanner;
abstract class 도형
{
    public abstract void draw();    // 추상메서드
    // 상속받는 클래스는 무조건 구현해서 사용
    // default
    public void colorSelect()
    {
        System.out.println("검정색을 사용한다!!");
    }
}
class 네모 extends 도형
{
    @Override
    public void draw() {
         System.out.println("사각형을 그린다!!");
    }
}
// abstract 메서드가 있는 경우에는 상속시에 무조건 구현후에 사용
// 문법이다
class 삼각형 extends 도형
{
    @Override
    public void draw() {
        System.out.println("삼각형을 그린다!!");
    }
}
class 원 extends 도형
{
    // 선언된 메서드는 필수
    @Override
    public void draw() {
        System.out.println("원을 그린다!!");
    }
    // 선택 사항
    public void colorSelect()
    {
        System.out.println("파랑색을 사용한다!!");
    }
}
public class 추상클래스 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 관련된 클래스를 모아서 한개의 객체명으로 제어
//        도형 a = new 네모();
        //      --------- 상속받아서 메서드를 구현한 클래스
        // 오버라이딩 : 기능을 변경해서 사용
        /*
         *      오버라이딩
         *      1) 상속   => 익명의 클래스(상속없이 사용)
         *      2) 메서드명, 매개변수, 리턴형이 동일
         *      3) 접근지정어는 확대만 가능 ....
         *      4) 유지보수에서 주로 사용
         *      5) 웹 => 유사한 기능이 많다
         *         회원가입 / 로그인 / 로그아웃
         *         게시판 / 공지사항 / 목록  => 상세보기
         *         댓글 ...
         *         예약 / 추천 / 결제 .... 
         *         여행 => 코스
         *      => 재사용    
         */
//        a.draw();
//        a.colorSelect();
//        
//        a=new 삼각형();
//        a.draw();
//        a.colorSelect();
//        
//        a=new 원();
//        a.draw();
//        a.colorSelect();
        Scanner scan=new Scanner(System.in);
        System.out.print("도형 선택 (네모(1), 삼각형(2), 원(3)): ");
        int mode=scan.nextInt();
        
//        if (mode==1)
//        {
//            네모 a=new 네모();
//            a.colorSelect();
//            a.draw();
//        }
//        else if (mode==2)
//        {
//            삼각형 a=new 삼각형();
//            a.colorSelect();
//            a.draw();
//        }
//        else if (mode==3)
//        {
//            원  a=new 원();
//            a.colorSelect();
//            a.draw();
//        }
//        도형 a=null;
//        if (mode==1)
//            a=new 네모();
//        else if (mode==2)
//            a=new 삼각형();
//        else if (mode==3)
//            a=new 원();
//        
//        a.colorSelect();
//        a.draw();
        도형[] a= {null, new 네모(), new 삼각형(), new 원()};
        a[mode].colorSelect();
        a[mode].draw();
    }

}
