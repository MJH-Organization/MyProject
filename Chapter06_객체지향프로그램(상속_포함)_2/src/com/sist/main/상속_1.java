package com.sist.main;

/**
 *		변경 (수정) 
 *		-------- 오버라이딩 
 *		=> 변수 오버라이딩 
 *		=> 메서드 오버라이딩 
 */
/*
 * 		Sub sub=new Sub();
 * 
 * 		---sub---
 * 
 * 		---------	------------------
 * 						---super---
 * 
 * 
 * 						-----------
 * 					-------------------
 * 		메서드 오버라이딩	=> 기능을 변경해서
 */
class Super	// 상속을 내리는 클래스
{
	String name;
	int age;
	//  초기화
	public Super()
	{
		name="홍길동";
		age=25;
	}
}
class Sub extends Super	// 상속받는 클래스
{
	/*
	 * 	String name;
		int age;
	 */
	String name;	// 변수 오버라이딩
	int age;
	
	public Sub()
	{
		name="심청이";
		age=27;
	}
	
	public void display() 
	{
		System.out.println("Super:name= "+super.name);
		// super: 상속을 내린 클래스
		System.out.println("Super:age= "+super.age);
		System.out.println("Sub:name= "+this.name);
		System.out.println("Sub:age= "+this.age);
	}
}
public class 상속_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sub a=new Sub();
		a.display();
	}

}
