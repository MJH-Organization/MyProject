import java.util.Calendar;
import java.util.Scanner;

/**
 * 		년도를 입력받아서 윤년인지 여부를 확인하는 메소드를 구현하시오
 * 		------ 매개변수		-------- boolean (리턴형)
 */
public class 메서드_3 {
	// 사용빈도가 많을 수 있다 => 예약 / 개인 일정 .....
	// => 재사용

	static boolean isYear(int year)
	{
		boolean bCheck=false;
		if((year%4==0 && year%100!=0) || (year%400==0))
			bCheck=true;
		return bCheck;
	}
	static void maxPrint(int a, int b)
	{
		System.out.println(a>b?a:b);	// 삼항연산자
	}
	static char weekData(int year, int month, int day)
	{
		char[] strWeek= {'일','월','화','수','목','금','토'};
		Calendar c = Calendar.getInstance();
		c.set(year, month-1, day);
		
		return strWeek[c.get(Calendar.DAY_OF_WEEK)];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
//		System.out.print("년도 입력: ");
//		int year = scan.nextInt();
//		
//		boolean bCheck=isYear(year);
//		if(bCheck==true)
//			System.out.println(year+"는 윤년입니다");
//		else
//			System.out.println(year+"는 윤년이 아닙니다");
		System.out.print("두개 정수 입력(10 20):");
		int a=scan.nextInt();
		int b=scan.nextInt();
		maxPrint(a,b);

	}

}
