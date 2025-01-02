/*
 *  10개의 알파벳을 추출
 *  사용자가 입력 => 몇번째 위치하고 있는지 확인
 *  
 */

import java.util.Scanner;
public class 반복문_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("알파벳을 입력(대문자)");
		char c = scan.next().charAt(0);
		
		System.out.println("c="+c);
		
		// 확인
		//System.out.println("몇번째 위치:" + (c-64));
		int index=1;
		for (char ch='A'; ch<='Z'; ch++)
		{
			if (ch==c)
				break; // 종료 => 반복문을 중단
			index++;
		}
		System.out.println(c+"는(은) "+index+"번째 위치하고 있습니다");
		scan.close();
	}

}
