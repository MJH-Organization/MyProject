
/**
 *		중복없는 난수 => 3개 발생(1~9)
 *		===============================
 *		사용자 입력
 *		3자리 입력 => 맞추는 프로그램 : 숫자 야구게임
 *		힌트
 *			369
 *			123	=> 0S-1B
 *			346 => 1S-1B
 */											
 
import java.util.Arrays;
import java.util.Scanner;
public class 배열_생성_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 컴퓨터 중복없는 나수 3자리 발생
		int[] com=new int[3];	// 0,0,0
		// 사용자 입력
		int[] user = new int[3];	// 0,0,0
		
		// 초기화
		for (int i=0; i<com.length; i++)
		{
			com[i]=(int)(Math.random()*9)+1;
			for (int j=0; j<i; j++)
			{
				if (com[i]==com[j])
				{
					i--;
					break;
				}
			}
		}
		Scanner scan = new Scanner(System.in);
		int num=0;
		while(true)
		{
			System.out.println("3자리 숫자를 입력하세요. :");
			num=scan.nextInt();
			if (num<123 || num>999)
			{
				System.out.println("잘못된 입력입니다!!");
				continue;
			}
			// 세자리 정수가 입력 => 356/100 => 3
			user[0]=num/100;
			user[1]=(num%100)/10;
			user[2]=num%10;
			if(user[0]==user[1]||user[1]==user[2]||user[2]==user[0])
			{
				System.out.println("중복된 수는 사용할 수 없습니다.");
				continue;
			}
			if(user[0]==0||user[1]==0||user[2]==0)
			{
				System.out.println("0은 사용할 수 없습니다.");
				continue;
			}
			// 오류처리 => 조건문 역할 : 오류를 방지 => if를 사용한다
			int s=0, b=0;
			for (int i=0; i<3; i++)	// com
			{
				for (int j=0; j<3; j++)	// user
				{
					if(com[i]==user[j])	// 같은 수가 있다면
					{
						if (i==j)	// 같은 자리인지
							s++;
						else		// 다른 자리인지
							b++;	
					}
				}
			}
			System.out.printf("Number: %d, Result: %dS-%dB\n", num, s,b);
			if(s==3)
			{
				System.out.println("Game Over!!");
				break;
			}
		}
		scan.close();

	}

}

