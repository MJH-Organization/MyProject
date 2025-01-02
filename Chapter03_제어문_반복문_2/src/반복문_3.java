/**
 * 
 */
public class 반복문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=1; i<=4; i++)
		{
			char c ='A';
			for (int j=1; j<=4; j++)
			{
//				System.out.print(c++);
				System.out.printf("%c", (char)c++);
			}
			System.out.println();
		}
		
		char c ='A';
		for (int i=1; i<=4; i++)
		{
			for (int j=1; j<=4; j++)
			{
//				System.out.print(c);
				System.out.printf("%c", (char)c);
			}
			c++;
			System.out.println();
		}

		int num=0;
		for (int i=1; i<=4; i++)
		{
			num=1;
			for (int j=1; j<=4; j++)
			{
				if (i==j) 
					System.out.print("#");
				else
					System.out.print(num++);
			}
			System.out.println();
		}

		System.out.println("[★ - > ★★★★]");
		for (int i=1; i<=4; i++)
		{
			for (int j=1; j<=i; j++)
			{
				System.out.print("★");
			}
			System.out.println();
		}

		System.out.println("[★★★★ - > ★]");
		for (int i=1; i<=4; i++)
		{
			for (int j=1; j<=5-i; j++)
			{
				System.out.print("★");
			}
			System.out.println();
		}
		
		System.out.println("[주사위 합이 6인 경우의 수]");
		for (int i=1; i<=6; i++)
		{
			for (int j=1; j<=6; j++)
			{
				if((i+j)==6) 
//					System.out.println(i+","+j);
					System.out.printf("[%d,%d]\n",i,j);
			}
		}

		System.out.println("[   ★ - > ★★★★]");
		for (int i=1; i<=4; i++)
		{
			for (int j=1; j<=4-i; j++)
			{
				System.out.print(' ');
			}
			for (int j=1; j<=i; j++)
			{
				System.out.print('★');
			}
			System.out.println();
		}

		System.out.println("[★★★★ - >    ★]");
		for (int i=1; i<=4; i++)
		{
			for (int j=1; j<=i-1; j++)
			{
				System.out.print(' ');
			}
			for (int j=1; j<=5-i; j++)
			{
				System.out.print('★');
			}
			System.out.println();
		}
	}

}
