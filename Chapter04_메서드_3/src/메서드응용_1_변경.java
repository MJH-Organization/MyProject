//	메서드형 숫자야구 게임
import java.util.Arrays;
import java.util.Scanner;
public class 메서드응용_1_변경 {

	// 중복없는 난수 (3개의 정수)
	static int[] rand()
	{
		int[] com=new int[3];
		for (int i=0; i<com.length; i++)
		{
			com[i]=(int)(Math.random()*9)+1;
			for (int j=0; j<i; j++)
				if(com[i]==com[j])
				{
					i--;
					break;
				}
		}
//		System.out.println(Arrays.toString(com));
		return com;
	}
	//	사용자 입력	=> 유효성 검사
	static int[] userInput()
	{
		Scanner scan=new Scanner(System.in);
		int[] user = new int[3];
		while(true)
		{
			System.out.print("세자리 정수를 입력하세요: ");
			int input=scan.nextInt();
			// 오류처리
			if (input < 100|| input > 999)
			{
				System.out.println("세자리 정수만 입력해야 됩니다!!");
				// 처음으로 이동
				continue;
			}
			/*
			 * 	continue 사용시에
			 * 	for		= 증가식으로 이동
			 * 	while	= 조건식으로 이동
			 * 	=> 특정 부분을 제외
			 * 	=> 웹에서는 사용빈도가 적다
			 */
			// 3자리 정수를 잘라서 	=> 배열에 저장
			user[0]=input/100;			// 369/100=3
			user[1]=(input%100)/10;		// 369%100	=> 69/10=6
			user[2]=input%10;			// 369%10=9
			//	=> 코딩테스트	=> 화폐매수 구하기 14850
			
			// 오류 처리	==> 중복된 수가 없어야 된다, 0을 사용하면 안된다
			if (user[0]==user[1] || user[1]==user[2] ||user[2]==user[0])
			{
				System.out.println("중복된 숫자는 사용할 수 없습니다!! ");
				continue;
			}
			if (user[0]==0 || user[1]==0 ||user[2]==0 )
			{
				System.out.println("0은 사용할 수 없습니다!! ");
				continue;
			}
			
			return user;
		}
	}
	// 비교
	static int compare(int[] com, int[] user)
	{
		int s=0, b=0;
		/*
		 * 	i=0	=> j=0, j=1, j=2
		 * 	i=1	=> j=0, j=1, j=2
		 * 	i=2	=> j=0, j=1, j=2
		 */
		for (int i=0; i<3; i++)
		{
			for (int j=0; j<3; j++)
			{
				if(com[i]==user[j])
				{
					if(i==j)		// 같은 자리수
						s++;
					else		// 다른 자리에 존재
						b++;
				}
			}
		}
		hint(s,b,user);
		return s;
	}
	// 힌트를 제공
	static void hint(int s, int b, int[] user)
	{
		StringBuilder sb=new StringBuilder();
		for (int i=0; i<user.length; i++)
		{
			sb.append(user[i]);
		}
		System.out.println("Input Number: "+ sb.toString());
		System.out.println("======  전광판  ======");
		System.out.print("S: ");
		for (int i=0; i<s; i++)
		{
			System.out.print("●");
		}
		System.out.println();
		System.out.print("B: ");
		for (int i=0; i<b; i++)
		{
			System.out.print("○");
		}
		System.out.println();
		
	}
	// 종료 여부
	static boolean isEnd(int s)
	{
		boolean bCheck=false;
		if(s==3)
		{
			bCheck=true;
		}
		return bCheck;
	}
	// 전체 조립 => 새로운 게임여부 확인
	static void process()
	{
		Scanner scan=new Scanner(System.in);
		int[] com=rand();
		int[] user=new int[3];
		while (true)
		{
			user=userInput();
			int s=compare(com, user);
			if(isEnd(s))
			{
				
				System.out.print("새 게임을 할까요?(y/n): ");
				char c=scan.next().charAt(0);
				if(c=='y'||c=='Y')
				{
					System.out.println("★★★★★ 새 게임을 시작합니다 ★★★★★");
					process();
				}
				else
				{
					System.out.println("Game Over!!");
					System.exit(0);
				}
			}
		}
//		int[] sb=compare(com, user);
//		hint(input, sb[0], sb[1]);
	}
	//
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process();
	}

}
