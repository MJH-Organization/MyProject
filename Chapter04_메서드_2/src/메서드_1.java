
/**
 *		웹 개발
 *		자바	: 변수/연산자/제어문/메서드/예외처리	=> 라이브러리
 *		오라클 : JDBC	=> DBCP	=> MyBatis	=> JPA
 *
 * 		HTML / CSS	=> 태크 / CSS 속성
 * 		JavaScript	=> Jquery(Ajax) => VueJS => ReactJS => NextJS
 * 					   ------------ NodeJS
 * 		SpringFramework => Spring-Boot => Spring Security
 * 		Python => Numpy, Pandas, MatplotLib, 머신러닝, 딥러닝
 * 		-----------------------------------
 * 		ElasticSearch	: CRUD => NoSQL
 * 		-----------------------------------
 * 		AWS
 * 		-----------------------------------
 * 		
 *		메서드
 *		----
 *			=> 객체지향
 *				=> 구성요소		 		
 *				=> 메서드	=> 동작, 행위	=> 동적
 *				** 변수	=> 메서드 : 메뉴, 버튼, 마우스, 키보드 입력
 *				** 다른 클래스와 연결
 *				   ------------- 메세지	=> 통신
 *				** 유지보수 (메서드를 변경), 재사용
 *				   ------------------ 오버라이딩, 오버로딩(기능 추가)
 *				** String : 웹/모바일
 *
 *		메서드 형식
 *		[접근지정어][옵션]	리턴형 메서드명(매개변수....)
 *									=> 갯수와 상관이 없다
 *									=> 3개 이상이면 배열/클래스를 이용한다
 *						-----------------------
 *									| 사용자 요청값
 *									| 아이디 중복체크 => id
 *									| 로그인 => id,pwd, boolean
 *									  remember-me						
 *									| 회원가입 => id,pwd,name,gender...
 *							=> 변수 식별자
 *							=> 소문자
 *						1. 기본형
 *						2. 클래스(String)
 *						3. 배열
 *			static: 공유	=> 자동 메모리 할당		 		
 *			final: 	종단	=> 확장 불가능(변경이 불가능)
 *			abstract: 추상	=> 공통적인 ....	=> 구현은 없고 선언
 *	
 *		1. 리턴형	/ 매개변수		=> 기본형
 *			int	plus(int a, int b)
 *			=> 사용자로부터 2개의 정수를 받아서 더한 값을 보내준다
 *		2. 리턴형이 배열
 *			int[] getData();
 *			{
 *				int[] arr = new int[3]
 *				return arr;	// 배열명만 전송
 *			}
 *		3. 리턴형/매개변수	=> 배열
 *			int[] getData(int[] arr)
 *			{
 *				return arr;
 *			}
 *		4. 클래스
 *			String getData(String s)
 *			{
 *				return s;
 *			}
 *		5. 경우의 수가 많은 경우
 *			=> 로그인
 *				= 아이디가 없는 경우
 *				= 비밀번호가 틀린 경우
 *				= 로그인
 *			=> String / int	=> 상수	=> NOID/NOPWD/LOGIN
 *
 *	=> 메서드 호출
 *	리턴형이 없는 경우
 *	void print(int a)
 *	{
 *		
 *	}
 *	=> print()	=> 매개변수가 있는 경우에 값을 채워서 처리
 *		print(100) => a=100
 * 
 */
public class 메서드_1 {

	static long diplay()
	{
		return 10;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a=diplay();

	}

}
