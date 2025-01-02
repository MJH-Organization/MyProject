package com.sist.main;
import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// 제네릭 / 어노테이션 / 열거형 / 리플렉션
//        ---------------------- JSP (웹)
@Data
@AllArgsConstructor
@NoArgsConstructor
class Member
{
    private int mno;
    private String name;
    private String gender;
    private String address;
    private String phone;
    
}
public class 제네릭_Collection_2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /*ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (int i=0; i<list.size(); i++)
        {
            System.out.println(list.get(i));
        }*/
        
//        ArrayList<String> list=new ArrayList<String>();
        // => ArrayList 안에 문자열만 저장한 후 관리
//        list.add("홍길동");
//        list.add("박문수");
//        list.add("이순신");
//        for (int i=0; i<list.size(); i++)
//        {
//            System.out.println(list.get(i));
//        }
        // 사용자 정의 데이터형을 이용한 데이터 추가
        ArrayList<Member> list=new ArrayList<Member>();
        list.add(new Member(1, "홍길동", "남자", "서울", "010-1111-1111"));
        list.add(new Member(2, "심청이", "여자", "경기", "010-2222-2222"));
        list.add(new Member(3, "박문수", "남자", "경기", "010-3333-3333"));
        list.add(new Member(4, "이순신", "남자", "인천", "010-4444-4444"));
        list.add(new Member(5, "강감찬", "남자", "서울", "010-5555-5555"));
        
        // 회원 => 인원 수 파악
        System.out.println("회원 인원수 : "+list.size());
        // 회원목록 출력
        for (Member m:list)
        {
           System.out.println(m.getMno()+"."+m.getName());
        }
        System.out.println("서울에 사는 회원 목록");
        for (Member m:list)
        {
            if(m.getAddress().equals("서울"))
            {
                System.out.println(m.getName()+" "+m.getAddress());
            }
        }
    }

}
