/**
 *		3개의 정수를 받아서 평균/총점을 전송하는 메소드
 *		1. 입력
 *		2. 처리	=> 평균 / 총점
 *			=> 세분화
 *		3. 출력 
 *
 *		=> 객체지향	=> 1)메서드,	2)변수
 */
import java.util.Scanner;
public class 메서드_5 {
	// 절차적언어	=> 한번 사용후 폐기
	static int userInput(int a)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println(a+" 정수입력:");
		int c=scan.nextInt();
		return c;
	}
	static int total(int a, int b, int c)
	{
		return a+b+c;
	}
	static double div(int total)
	{
		return total/3.0;
	}
	static void print(int total, double avg)
	{
		System.out.println("총점: "+total);
		System.out.println("평균: "+avg);
	}
	static void process()
	{
		int a=userInput(1);
		int b=userInput(2);
		int c=userInput(3);
		
		int total=total(a,b,c);
		double avg=div(total);
		print(total, avg);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 3개의 정수받기
//		Scanner scan = new Scanner(System.in);
//		System.out.println("1' 정수입력: ");
//		int a =scan.nextInt();
//		
//		System.out.println("2' 정수입력: ");
//		int b =scan.nextInt();
//		
//		System.out.println("3' 정수입력: ");
//		int c =scan.nextInt();
//		
//		// 총점
//		int total = a+b+c;
//		// 평균
//		double avg = total/3.0;
//		// 출력
//		System.out.println("평균: "+avg);
//		System.out.println("총점: "+total);
		process();
	}

}
