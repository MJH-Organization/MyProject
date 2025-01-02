
/**
 * 1. 변수 = 한개만 저장하는 공간, 변경이 가능
 * 			=> 1. 메모리 저장, 2. 값읽기, 3. 수정이 가능
 *    ---
 *    1) 지역변수
 *    2) 멤버변수
 *    3) 공유변수
 *    
 *    ----------------------------------------------
 *    => 변수를 저장하기 위해서는 반드시 필요한 내용
 *       --------------------------------
 *       메모리 크기 결정 / 클래스 (JVM에서 크기를 모른다)
 *       					 ------------------
 *       					 | new => 새로운 메모리 생성
 *       기본형
 *       ----
 *       정수: byte(1 byte), ***int(4 byte), long(8 byte)
 *       	-128~127		-21억4천~21익4천
 *       실수: ***double (8 byte) => 소수점 15 자리이상
 *       논리: ***boolean (1 byte) = true/false
 *       문자: char (2 byte)	=> 0~65535
 *       --------------
 *       참조형: 배열, 클래스(***String, Integer, ArrayList)
 *       	오라클 : Connection / Statement / ResultSet
 *       *** 변경이 되는 값
 *       	누적 / 루프
 *       	*** 가독성
 *       		i/j => a/b, m/n 
 *       	입력값
 *       	난수값
 *       
 *    메모리 저장
 *    ----------------------------------------------
 *    MethodArea : Method / static (공유변수)
 *    ----------------------------------------------
 *    Stack : 메모리 자체에서 관리 => 지역변수
 *    		{}이 종료되면 사라진다
 *    ----------------------------------------------
 *    Heap : 실제 데이터 공간 : 클래스 / 배열
 *    		자동으로 해제되지 않는다 => 개발자가 처리
 *    		new / delete => 가비지컬렉션
 *    						자동 메모리 회수
 *    		=> 메모리 저장
 *    		-------------- 확인 int malloc() => new
 *    					   해제 free() = > delete
 *    ----------------------------------------------
 *    
 *    ==> 사용자 요청에 따른 데이터 처리
 *    1) 연산자
 *    	단항연산자 (++, --, !, (type))
 *                           ----- 강제 형변환=> 클래스형변환
 *                           				  클래스의 크기
 *                           				  
 *    	a++ 나중에 증가 ++a 증가를 먼저
 *    	이항연산자 (+,-,*,/,% => == != < > <= >= => && ||)
 *    		1. 모든 연산자는 같은 데이터형만 연산이 가능
 *    			10+10.5 => 10.0+10.5(자동형변환)
 *    			* 산술규칙
 *    			= 같은 데이터 형만 연산이 가능
 *    			= int 이하(byte, short, char) => 결과값이 int
 *    		% : 남는 부호 => 왼쪽 부호
 *    		&&, || 앞의 조건이 만족되면 (false, true) 이면 뒤 조건은 수행하지 않는다
 *    	삼항연산자 (?:) => JSP에서 주로 사용
 *    	(조건)?값1:값2
 *    
 *    
 *    2) 제어문
 *    ---- 묶어서 처리 => 메서드
 *    1. 입력
 *    2. 처리 => 세분화
 *    3. 출력
 *    
 *    ----------------------------------------------
 */
import java.util.Scanner;
public class 자바1_3_정리 {
	
	static int userInt(String s)
	{
		int result=0;
		Scanner scan = new Scanner(System.in);
		System.out.println(s+" 입력:");
		result = scan.nextInt();
		scan.close();
		return result;
	}
	
	// 멤버변수 => 자동초기화 int a; => a=0
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 지역변수 : 초기화가 안됨 int a;
//		Scanner scan = new Scanner(System.in);
//		System.out.println("년도 입력:");
//		int year = scan.nextInt();
//		System.out.println("월 입력: ");
//		int month = scan.nextInt();
//		System.out.println("일 입력: ");
//		int day = scan.nextInt();
		int year = userInt("년도");
		int month = userInt("월");
		int day = userInt("일");
		
		System.out.println(year+"년도"+month+"월"+day+"일");
	}
}
