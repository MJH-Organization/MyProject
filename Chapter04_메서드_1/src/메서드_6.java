
/**
 *		메서드 호출	=> 매개변수
 *		1) Call By Value
 *			=> 값만 전송
 *		2) Call By Reference	(메모리 주소	=> 주소를 전소	=> 동시에 변경)
 *		   -------------------
 *			주소: 배열 / 클래스
 *			------------------
 *			 클래스 중에 제외	: String (일반 데이터형)
 *			=>  
 */
public class 메서드_6 {
	static void swap(int a, int b)
	{
		System.out.println("swap 메서드에 진입.... => 2");
		System.out.println("사용자가 요청한 값 => 3");
		System.out.println("swap => 변경 전:");
		System.out.println("a="+a);	//4
		System.out.println("b="+b);	//5
		int temp=a;
		a=b;
		b=temp;
		System.out.println("swap => 변경 후:");
		System.out.println("a="+a);	//4
		System.out.println("b="+b);	//5
		System.out.println("swap 메서드 요청 완료 .... => 6");
	}
	//	시작= 종료	= 자동호출
	// 사용자 정의는 자동 호출이 안된다
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("main 시작=> 1");
		int a=10, b=20;
		System.out.println("main => 변경 전:");
		System.out.println("a="+a);	//4
		System.out.println("b="+b);	//5
		swap(a,b);
		System.out.println("main => 변경 후:");
		System.out.println("a="+a);	//4
		System.out.println("b="+b);	//5
		System.out.println("main 종료 => 프로그램 종료 => 7");
	}

}
