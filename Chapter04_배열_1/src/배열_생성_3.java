
/**
 *		=> 변수 => 배열
 *		=> 연산처리 / 제어문 처리 => 사용자 요청 => 메서드
 *		-----------------------------------------	클래스 구성요소
 *		객체지향언어 => 자바 시작	(5장)
 *		사용자 정의 데이터형 
 *		1. 정수를 입력을 받아서 ==> 2진법 출력  10==> 0000 0000 0000 1010
 *		16 bit => 2byte => 32767								
 */									
import java.util.Scanner;
public class 배열_생성_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num=0;
		while (true)
		{
			System.out.print("0~32767 사이의 숫자를 입력하세요: ");
			num = scan.nextInt();
			if (num>=0 && num <=32767)
			{
				break;
			}
		}
		System.out.println(Integer.toBinaryString(num));
		// 저장 공간 0,1 => 16개
		int[] binary = new int[16];
		// 앞에서 => index=0, 뒤에서 부터 => index=15
		// index=0 ==> 0부터 출력		FIFO => Queue
		// index=15 ==> 0부터 출력	 	LIFO => Stack
		// 요청 처리 => 제어문 / 연산자
		for (int index=binary.length-1; index>=0; index--)
		{
			binary[index] = num % 2;
			System.out.printf("num=%5d => %1d\n", num,binary[index]);
			num = num/2;
			if (num == 0)
				break;
		}
//		int index = 15;
//		do 
//		{
//			binary[index] = num % 2;
//			System.out.printf("num=%5d => %1d\n", num,binary[index]);
//			num = num/2;
//			index--;
//		} while (num>0);
		System.out.println();
		// 출력
		for (int i=0; i<binary.length; i++)
//						|배열의 갯수 
		{
			if(i!=0 && i%4==0)
				System.out.print(" ");
			System.out.print(binary[i]);
		}
		
		scan.close();
	}

}

