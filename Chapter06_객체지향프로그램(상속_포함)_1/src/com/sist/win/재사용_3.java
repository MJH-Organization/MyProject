package com.sist.win;

/**
 * 		194 page
 * 		상속 :	이미 만들어진 클래스를 재사용
 * 				-------------- 기존의 클래스 (사용자 정의, 라이브러리)
 * 		포함 :	재사용
 * 				상속 / 포함
 * 				---	  ---
 * 						| 있는 그래도 사용
 * 				| 변경해서 사용
 * 				| 상속이 안되는 클래스 :	final class
 * 									-----------
 * 									String, System, Scanner...
 * 		상속	:	상속을 내리는 클래스 :	공통으로 적용되는 내용
 * 				상속을 받는 클래스 
 * 					=> 유지보수가 편리하다 
 * 					=> 반복 제거 
 * 					=> 관리 용이 
 * 					=> 속도가 느리다 
 * 					=> 변경이 어렵다 
 * 					=> 소스를 볼 수 없기 때문에 가독성이 낮다 
 * 					=> 1) 가독성	2) 최적화 
 * 					=> 가급적으면 상속을 하지 않는다 
 * 						=> 웹, 모바일 
 * 		=> 클래스를 상속받아서	=> 새로운 클래스 (기존의 클래스+새로운 추가)
 * 
 * 			예)
 * 				공통 기능
 * 				------- 게시판
 * 					글쓰기
 * 					상세보기
 * 					목록
 * 					수정
 * 					삭제
 * 					검색
 *  
 * 				묻고 답하기 
 *  				게시판 a=new 게시판()	=> 고정 (게시판 기능 수정 불가능)
 * 				묻고 답하기 extends 게시판	(게시판 기능 수정 가능)
 * 					답하기
 * 				답변 게시판 extends 게시판
 * 					답변하기
 * 				자유게시판 extends 게시판
 * 
 * 				자료실 extends 게시판
 * 					다운로드 / 업로드
 * 			--------------------------------
 * 				뮤직
 * 					= 목록
 * 					= 검색
 * 					= 동영상 실행
 * 					= 상세보기
 * 					= 댓글
 * 					= 구매하기
 * 
 * 				멜론 extends 뮤직
 * 		
 * 				지니뮤직 extends 뮤직
 * 		
 * 				===> 반복 제거		
 * 			===> 소스를 줄일 수 있다		
 * 			===> 여러개 클래스 적용이 가능		
 * 			===> 필요시에는 변경해서 사용이 가능		
 * 			===> 윈도우 :	 기존의 클래스 사용 =>	JFrame		
 * 				----- ERP		
 * 				===> 스프링	=> 자바기반 / 코틀린 기반		
 * 										---- 자바JVM
 * 
 * 			*** 자바에서 가장 큰 클래스가 있다
 * 				Object	=> 최상위 클래스
 * 				=> 리턴형 Object
 * 					----------	클래스 리턴형	=> Object
 * 		*** 어떤 클래스로 저장
 * 			-------------
 *			
 *	 	
 * 	  
 * 
 */
import java.util.*;
public class 재사용_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList<>();
		list.add("홍길동");	// 'A' 100
		
		Object name=(String)list.get(0);

	}

}
