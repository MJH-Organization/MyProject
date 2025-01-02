// 무한루프
/*
 * 	컴퓨터 
 * 
 */

import java.util.Scanner;
public class 반복문_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 임의의 수를 추출
		int com=(int)(Math.random()*100)+1;
		
		// 사용자 입력
		Scanner scan = new Scanner(System.in);
		for (;;) //for 문의 무한루프
		{
			System.out.println("1~100사이의 정수 입력: ");
			int user = scan.nextInt();
			
			// 힌트
			if(com>user)
			{
				System.out.println("높은 정수 입력!!");
			}
			else if(com<user)
			{
				System.out.println("작은 정수 입력!!");
			}
			else 
			{
				System.out.println("정답입니다!!");
				System.exit(0); // 프로그램 종료
			}
			scan.close();
		}

	}

}
