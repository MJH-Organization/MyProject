package com.sist.win;

/**
 *		자바의 기본 형식 
 *		package 
 *		import 
 *		public class ClassName 
 *		{ 
 *			멤버변수 / 정적변수 => X, 여러개....
 *			생성자 =>	필요시에 사용
 *			메서드 =>	필요시에 사용
 *			main() {} =>	반드시 한개가 필요 =>	프로그램 시작
 *		} 
 *
 *		=> 	제어어
 *			static :	공통적인
 *			final :	마지막인 =>	상수	/ 변경하지 않는 메서드
 *			abstract :	추상적인 =>	공통 기반
 *			syschronized :	동기적인 =>	쓰레드
 *			---------
 *			async
 *			sync
 *			--------- 	자바 스크립트	=> Ajax	=>	web2.0	=>	web3.0
 *			--------- 	jquery(ajax)	3 => react	=> vue	=>	react	= next
 *						jquery	=> 4,5
 *			-----------------------------------------------
 *			[접근지정어][제어어]	=>	메서드, 멤버변수, 생성자, 클래스
 *
 *			*** 객체의 생명주기
 *			설계				저장						활용					소멸
 *			class Movie		Movie m=new Movie()		m.메서드(), m.변수		m=null
 *																		------
 *																		System.gc()
 *
 *
 *			6장	=> 194 page
 *
 *			상속 (웹, 스프링	=> 사용빈도 거의 없다)
 *			---------------------------------
 *			상속 :	목적 / 형식 / 메모리 구조
 *			=> 목적
 *			기존의 클래스(이미 만들어져 있는 클래스) => 신뢰성이 뛰어나다
 *				= 라이브러리 클래스
 *				= 사용자정의 클래스
 *			재사용 할때 / 변경 사용, 추가 사용
 *			=> 반복 제거 / 소스를 줄이는 경우
 *			=> 상속에서는 예외조건
 *				1. 생성자, 2. static,	3. 초기화 블럭
 *
 *				** 상속은되는데 사용을 못하는 것	=> private (protected)
 *			=> 형식 
 *				class A 
 *				class B extends A
 *						------- A 클래스를 확장해서 사용 
 *				=> 상속을 내리는 클래스 
 *					부모클래스, 슈퍼클래스, 베이스 클래스 
 *				=> 상속을 받는 클래스 
 *					자식클래스, 서브클래스, 파생클래스
 * 
 *				=> 클래스의 크기가 결정 => 형변환  
 *					---------  
 *					상속을 내리는 클래스 > 상속받는 클래스  
 *				=> 자바에서 상속은 단일상속 지원한다
 *
 *  			class A
 *  			{
 *  				★	○	▲
 *  			}
 *  			class B extends A
 *  			{
 *  				//★	○	▲ => 따로 설정할 필요가 없다
 *  			}
 *  
 *  			Object
 *  			↑
 *  			A :	super
 *  			↑
 *  			B : sub	=> this, super
 *  
 *  			*** 상속을 내리는 클래스	=> 상속받은 클래스의 변수, 메서드제어가 불가능
 *  				--------------- this
 *  				super => 자바의 모든 클래스는 Object 상속을 받는다
 *  			*** 상속을 받은 클래스는 상속내린 클래스 제어가 가능
 *  				------------- this, super
 *			---------------------------------
 *
 *			자동추가 되는 것들
 *			import java.lang.*	=> String, System..
 *			class A extends Object
 *					---------------
 *			 class A
 *			{
 *				// A() {}
 *			}
 *			 class B
 *			{
 *				void display() {
 *					// return;
 *				}
 *			}
 *
 *			자바의 모든 라이브러리는 예외처리를 가지고 있다
  *			 class A
 *			{
 *				int a;
 *				int b;
 *			}
 *
 *			 class B extends A
 *			{
 *				// int a,b;
 *				int c,d;
 *			}
 *
 *			// 메모리 할당
 *			B bb=new (B)
 *
 *
 *			=> 201  page
 *			1) 단일 상속 : 수정 가능 (오버라이딩, 오버로딩)
 *			2) 상속
 *			3) 상속을 두개 이상 받는 경우
 *				class A
 *				class B
 *				class C extends A,B	=> 오류
 *				class A
 *				class B extens A	=> A,B
 *				class C extends B	=> C, A, B
 *
 *				=> 여러개를 받는 방법	=> 클래스는 기존
 *					------------- 인터페이스
 *
 *				생물		=> 위로 올라갈수록 클래스가 커진다
 *				|		=> 공통점이 많다 (추상화)
 *			---------	=> 위로 올라가면 추상화, 밑으로 가면 구체화
 *			|		|
 *			동물		식물
 *						상속을 받아서 메모리 할당
 *						1) 상위 클래스 (상속 내린 클래스)
 *						2) 하위 클래스 (상속을 받은 클래스)
 *						=> 속도가 느려진다
 *						=> 영향력이 많이 존재
 *						=> 공통점을 추출
 *							----
 *							사람 : 이름/ 나이 / 주소 / 전화
 *						회사원 extends 사람	사번
 *						학생	extends 사람		학번
 */
class Sawon // extends Object
{
	public Sawon()
	{
		System.out.println("Sawon 객체 생성!!");
//		this.
	}
	
	public void display()
	{
		System.out.println("사원 객체 활용");
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		// 소멸자 함수
		System.out.println("객체 소멸!!");
	}
	
	
}
public class 재사용_1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sawon sa = new Sawon();
		sa.display();
		sa=null;
		System.gc();	// 메모리를 회수해라....

	}


}
