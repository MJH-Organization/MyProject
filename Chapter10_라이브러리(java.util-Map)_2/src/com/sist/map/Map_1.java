package com.sist.map;

/**
 *      => 중복 데이터 => 목록 => ArrayList
 *         웹에서 검색데이터 / 전체 목록
 *         ---------------------> 데이터를 모아서 브라우저
 *      => 중복 없는 데이터를 만든다  => HashSet
 *         ---------------------> 웹 채팅
 *      => 두개를 동시에 저장 (key,value) => HashMap
 *         ---------------------> 방문한 맛집 / 장바구니
 *                                아이디 저장 ...
 *      Map (인터페이스 => 349 page) 
 *      ---
 *                          Map
 *                          ---
 *                           |
 *           -----------------------------------
 *           |                                  |
 *         HashMap => 비동기                 HashTable => 동기 => 쓰레드 기반
 *          => 웹 : AJAX / VUE / React
 *          
 *         동기 => 한개가 완전히 저장 후에 다른 데이터를 저장(속도가 늦다, 안정적)
 *         /비동기 => 동시에 저장 (속도가 빠르다)    
 *         
 *         특징)
 *              두개를 동시에 저장
 *              key / value
 *              => key는 중복이 불가능
 *              => value는 중복이 가능
 *              => 예) ("id", "admin")   
 *              => 주요사용처
 *                 웹 => 90% 정도가 Map 형식을 사용
 *                 -- 
 *                 사용자가 보내준 데이터 정보 
 *                 => HttpServletRequest
 *                 => request.setAttribute("key",Object)
 *                      => ?id=admin
 *                 브라우저로 보내는 정보 
 *                 => HttpServleResponse
 *                 => response.setAttribute("key",Object)
 *                 브라우저에 저장하는 정보 
 *                 => Cookie
 *                 => new Cookie(key, value)
 *                 서버에 저장하는 정보 
 *                 => HttpSession    
 *                 => session.setAttribute("id","hong")        
 *         => 스프링
 *              key, 객체 => Factory 패턴
 *              => 클래스 관리자 (생명주기)
 *         => MyBatis
 *              key, SQL => 
 *      => 주요 메서드
 *          clear() : 전체 삭제 
 *          get(): 데이터 읽기 => get(key)
 *          put(): 데이터 저장
 *          isEmpty() : 데이터 존재여부 확인
 *          size() : 저장 갯수
 *          keySet() : 키값 전체를 가지고 온다
 *          values() : 값 전체를 가지고 온다
 */
// 간단한 장바구니
import java.util.*;

public class Map_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] data= {"사과", "배", "수박", "귤", "참외", "메론", "바나나"};
        Map<String, Integer> cart = new HashMap<String, Integer>();
        Scanner scan=new Scanner(System.in);
        while(true)
        {
            System.out.println("========== 과일 목록 ===========");
            System.out.println("1.사과");
            System.out.println("2.배");
            System.out.println("3.수박");
            System.out.println("4.귤");
            System.out.println("5.참외");
            System.out.println("6.메론");
            System.out.println("7.바나나");
            System.out.println("9. 종료");
            System.out.println("=============================");
            System.out.print("과일 선택:");
            
            int f=scan.nextInt();
            if(f==9)
            {
               break;
            }
            cart.put("f_"+f, f);
            //       ------ 중복이 안되게 만든다
                        
        }
        // 장바구니가 종료
        if(cart.isEmpty())
        {
            System.out.println("장바구니에 과일이 없습니다");
        }
        else
        {
            System.out.println("과일 구매 총 "+cart.size()+"건");
            for(String key:cart.keySet())
            {
                int value=cart.get(key);
                System.out.println(data[value-1]);  // 실제 구매 과일번호와 data상 과일을 index의 차이반영
            }
        }
    }

}
