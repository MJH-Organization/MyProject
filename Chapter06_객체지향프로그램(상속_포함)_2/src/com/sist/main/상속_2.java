package com.sist.main;

/**
 *		메서드 오버라이딩	=> 	메서드의 기능변경	=> 유지보수 
 *		--------------------------------------------- 
 *		오버라이딩의 조건 ******* 인터페이스
 *		1. 상속 =>	상속받은 메서드를 변경해서 사용 
 *		2. 메서드명이 동일하다 
 *		3. 매개변수가 동일하다 
 *		4. 리턴형이 동일 
 *		5. 접근지정어가 확대 가능, 축소 불가능
 *
 *		=> 실무 (입사)
 *			--------
 *			1) 변수
 *			2) 연산자
 *			3) 제어문
 *			4) 메서드
 *			5) 멤버변수
 *			6) 생성자?
 *			***7) 오버라이딩
 *			***8) 인터페이스
 *			***9) 예외처리
 * 				
 */
class Animal
{
	int a=10;
	public void run()
	{
		System.out.println("걷는다");
	}
	
}
class Dog extends Animal
{
	int a=20;
	public void run()
	{
		System.out.println("4발로 걷는다");
	}
	
}
class Human extends Animal
{
	int a=30;
	public void run()
	{
		System.out.println("2발로 걷는다");
	}
	
}
/*
 * 		-----		-------
 * 		run()		0x100	=> 0x200
 * 		-----		-------
 * 
 * 		new Dog()	===> 0x100
 * 		new Human()	===> 0x200
 * 
 * 		==> 정적 바인딩 => 한개의 주소를 유지
 * 		==> 동적 바인딩 => new 주소변경	*** 자바
 * 		==> 가상함수
 */
public class 상속_2 {
	//	카페
	//	Model / DAO

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 관련 클래스가 여러개 있는 경우 => 상위 클래스로 이용
		// 객체를 한개만 생성해서 사용

		Animal ani=new Dog();
		System.out.println(ani.a);
		ani.run();
		ani = new Human();
		System.out.println(ani.a);
		ani.run();
		/*
		 * 	변수 찾기
		 * 	------- 선언되는 클래스형
		 * 	메서드 찾기
		 * 	------- 생성자
		 */
	}

}
