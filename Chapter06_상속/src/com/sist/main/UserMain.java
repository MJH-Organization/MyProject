package com.sist.main;
import java.util.*;
import com.sist.seoul.*;
import com.sist.vo.*;

/*
 *      1. 클래스
 *         멤버변수 / 메서드 / 생성자
 *      2. 캡슐화 : getter / setter
 *      3. 상속   => 포함
 *      4. 추상클래스    / 인터페이스
 *                      => 추상 클래스 보완
 *      5. 예외처리
 *      
 *      => 형식
 *      => 개념
 *      => 프로그램의 흐름 => 순서
 *          ------------------
 *      ----------------------
 *      => 변수 설정
 *      => 기능 catch => 메서드
 *      ----------------------
 * 
 */
public class UserMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Seoul seoul=null;
        // 동일한 클래스가 많은 경우 주로    => 사위클래스를 이용한다
        //  상위클래스    => 인터페이스
        // 클래스를 모아서 처리  => 인터페이스    => 스프링
        Scanner scan=new Scanner(System.in);
        System.out.print("명소(1),자연(2): ");
        int type=scan.nextInt() ;
        if (type==1)
        {
            seoul=new SeoulLocation();
        }
        else
        {
            seoul=new SeoulNature();
        }
        
        while(true )
        {
            System.out.println("=========== Menu ==============");
            System.out.println("1. 전체 목록");
            System.out.println("2. 상세 보기");
            System.out.println("3. 검색(명칭,주소)");
            System.out.println("4. 종료");
            System.out.println("===============================");
            System.out.print("메뉴 선택: ");
            int menu=scan.nextInt();
            if(menu==4)
            {
                System.out.println("프로그램 종료");
                break;
            }
            else if(menu==1)
            {
                SeoulVO[] datas=seoul.seoulAllData(type);
                for (SeoulVO vo:datas)
                {
                    System.out.println(vo.getNo()+"."+vo.getName());
                }
            }
        }

    }

}
