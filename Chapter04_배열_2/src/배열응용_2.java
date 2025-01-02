
/**
 * 	=> 달력
 * 		1. 사용자 정의
 * 			=> 달력 : 1일자의 요일 확인
 * 						   -------
 * 			=> 1년도 1월 1일	=> 월요일
 * 			1) 1/1/1 ~ 2023/12/31 => 총날수 계산
 * 			2) 2024/11/30 => 총날수 계산
 * 			3) -------------------------------- +1
 * 			1)+2)+3) / 7 ===> 요일을 구한다
 * 			0~6 => 0일 => 6 => xh
 * 			=> 예약 / 일정 관리
 * 			=> 
 * 		2. 라이브러리	Calendar
 */
import java.util.Scanner;
public class 배열응용_2 {

	public static void main(String[] args) {
		// 입력 받기 => year/month/day => 요일
		Scanner scan=new Scanner(System.in);
		System.out.print("년도 입력: ");
		int year=scan.nextInt();
		System.out.print("월 입력: ");
		int month=scan.nextInt();
//		System.out.print("일 입력: ");
//		int day=scan.nextInt();
		// 전년도까지 날 수
		int total = (year-1)*365
					+ (year-1) / 4
					- (year-1) / 100
					+ (year-1) / 400;	// 윤년 처리
		// 전달까지 날 수
		int[] lastday = {
				31,28,31,30,31,30,
				31,31,30,31,30,31
		};
				
		// 모든 언어에서 사용되는 윤년 계산 => 로마시대
		if ((year%4==0 && year%100!=0) || (year%400==0))
			// 윤년 조건
			lastday[1] = 29;
		else
			lastday[1] = 28;
		
		for (int i=0; i<month-1; i++)
		{
			total += lastday[i];
		}
		
		// 입력 날 +
//		total += day;
		total++;
		
		// 요일 구하기
		// => switch 대신
		char[] strWeek= {'일', '월', '화', '수', '목', '금', '토'};
		int week = total%7;
//		System.out.println(year + "년 " + month + "월 " + day+ "일은 " 
//						+ strWeek[week] + "요일입니다.");
		System.out.println(year + "년 " + month + "월 ");
		for (int i=0; i<strWeek.length; i++)
			System.out.print(strWeek[i]+"\t");
		System.out.println();
		int day = 1;
		for (int i=0; i<strWeek.length;i++)
		{
			if (i<week)
				System.out.print("\t");
			else
				System.out.printf("%2d\t",day++);
		}
		System.out.println();
		while (true)
		{
			for (int i=0; i<strWeek.length; i++)
			{
				System.out.printf("%2d\t",day++);
				if (day>lastday[month-1])
					break;
			}
			System.out.println();
			if (day>lastday[month-1])
				break;
		}
		scan.close();
	}

}
