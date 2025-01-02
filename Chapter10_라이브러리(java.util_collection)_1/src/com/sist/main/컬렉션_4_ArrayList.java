package com.sist.main;
import java.util.*;
public class 컬렉션_4_ArrayList {

    /*
     *  List => 인터페이스
     *  ----
     *  | ***ArrayList => 데이터베이스 (오라클)
     *      => 단순한 목록
     *      => 크롤링 데이터
     *  | Vector    => 네트워크
     *      => 채팅 => 사용자 정보 저장
     *  | LinkedList => 수정 / 삭제 / 추가가 많은 경우
     *      => 게시판 / 댓글
     *  ------------ 동일 메서드를 구현하고 있다
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        for (int i:list)
        {
            System.out.print(i+" ");
        }
        System.out.println("\n");
        
        Vector<Integer> vec=new Vector<Integer>();
        vec.add(1);
        vec.add(2);
        vec.add(3);
        vec.add(4);
        vec.add(5);
        for (int i:vec)
        {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        
        LinkedList<Integer> vec2=new LinkedList<Integer>();
        vec2.add(1);
        vec2.add(2);
        vec2.add(3);
        vec2.add(4);
        vec2.add(5);
        for (int i:vec2)
        {
            System.out.print(i + " ");
        }
    }

}
