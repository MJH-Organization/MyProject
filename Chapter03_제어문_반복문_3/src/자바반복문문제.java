import java.util.Scanner;
public class 자바반복문문제 {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.out.printf("<자바반복문문제%2d>\n",1);
//		System.out.printf("if (x>10 && x<20)\n");
//		
//		System.out.printf("<자바반복문문제%2d>\n",2);
//		System.out.printf("if (c==' ' && c!='\t')\n");
//		
//		System.out.printf("<자바반복문문제%2d>\n",3);
//		System.out.printf("if (c=='c' || c!='C')\n");
//		
//		System.out.printf("<자바반복문문제%2d>\n",4);
//		System.out.printf("if (c>='0' || c<='9')\n");
//	
//		System.out.printf("<자바반복문문제%2d>\n",5);
//		for (int i=1; i<=6; i++)
//		{
//			for (int j=1; j<=6; j++) 
//			{
//				if (i+j==6) 
//					System.out.printf("[%d, %d]\n", i, j);
//			}
//		}
//
//		System.out.printf("<자바반복문문제%2d>\n",6);
//
//		Scanner scan = new Scanner(System.in);
//		System.out.print("시작 숫자를 입력하세요: ");
//		int start = scan.nextInt();
//		int end=0;
//		while(true)
//		{
//			System.out.print("끝 숫자를 입력하세요: ");
//			end = scan.nextInt();
//			if (end<start)
//				System.out.println("끝 숫자가 시작 숫자보다 작습니다.!!");
//			else
//				break;
//		}
//		int result = 1;
//		for (int i=start; i<=end; i++)
//		{
//			result *= i;
//			
//			if (i!=end)
//			{
//				System.out.printf("%d*",i);
//			}
//			else
//			{
//				System.out.printf("%d=%d\n",i,result);
//			}
//		}
//		
//		System.out.printf("<자바반복문문제%2d>\n",7);
//		result = 0;
//		for (int i=5; i<=16; i++)
//		{
//			result += i;
//		}
//		System.out.printf("5~16까지의 합: %d\n",result);
//
//		System.out.printf("<자바반복문문제%2d>\n",8);
//		result = 0;
//		for (int i=3; i<=4462; i++)
//		{
//			if(i%2==0)
//				result += i;
//		}
//		System.out.printf("3~4462까지의 짝수의 합: %d\n",result);
//
//		System.out.printf("<자바반복문문제%2d>\n",9);
//		int result1 = 0, result2=0;
//		for (int i=1; i<=12; i++)
//		{
//			if(i%2==0)
//				result1 += i;
//			if(i%3==0)
//				result2 += i;
//		}
//		System.out.printf("0~12까지 2의 배수의 합: %d\n",result1);
//		System.out.printf("0~12까지 3의 배수의 합: %d\n",result2);
//
//		System.out.printf("<자바반복문문제%2d>\n",10);
//		int idx=1, sum=0;
//		while ((idx*4)<=100)
//		{
//			sum = sum+(idx*4);
//			idx++;
//		}
//		System.out.printf("0~100까지 4의 배수의 합: %d\n",sum);
//
//		System.out.printf("<자바반복문문제%2d,%2d>\n",11,12);
//		int cnt2=0,cnt3=0,cnt5=0;
//		for (int i=1; i<=10; i++)
//		{
//			System.out.printf("%d번째 정수를 입력하세요: ",i);
//			int num = scan.nextInt();
//			if (num%2==0)
//			{
//				cnt2++;
////				System.out.printf("입력받은 %d번째 짝수: %d\n",cnt2, num);
//			}
//			if (num%3==0)
//			{
//				cnt3++;
////				System.out.printf("입력받은 %d번째 짝수: %d\n",cnt2, num);
//			}
//			if (num%5==0)
//			{
//				cnt5++;
////				System.out.printf("입력받은 %d번째 짝수: %d\n",cnt2, num);
//			}
//		}
//		System.out.printf("입력받은 짝수의 갯수: %d\n",cnt2);
//		System.out.printf("입력받은 3의 배수의 갯수: %d\n",cnt3);
//		System.out.printf("입력받은 5의 배수의 갯수: %d\n",cnt5);
//		
//		System.out.printf("<자바반복문문제%2d>\n",13);
//		for (int i=1;i<=5;i++)
//		{
//			for (int j=1; j<=10; j++)
//			{
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//
//		System.out.printf("<자바반복문문제%2d>\n",14);
//		for (int i=1;i<=5;i++)
//		{
//			for (int j=1; j<=5; j++)
//			{
//				System.out.printf("%d ",i);
//			}
//			System.out.println();
//		}
//
//		System.out.printf("<자바반복문문제%2d>\n",15);
//		for (int i=1;i<=5;i++)
//		{
//			for (int j=1; j<=5; j++)
//			{
//				System.out.printf("%d ",j);
//			}
//			System.out.println();
//		}
//
//		System.out.printf("<자바반복문문제%2d>\n",16);
//		for (int i=1;i<=5;i++)
//		{
//			for (int j=1; j<=5; j++)
//			{
//				if (j==i)
//					System.out.print(j);
//				else
//					System.out.print("#");
//			}
//			System.out.println();
//		}
//
//		System.out.printf("<자바반복문문제%2d>\n",17);
//		char c = 'A'-1;
//		for (int i=1;i<=5;i++)
//		{
//			for (int j=1; j<=5; j++)
//			{
//				System.out.print((char)(c+i));
//			}
//			System.out.println();
//		}
//
//		System.out.printf("<자바반복문문제%2d>\n",18);
//		for (int i=1;i<=5;i++)
//		{
//			c = 'A'-1;
//			for (int j=1; j<=5; j++)
//			{
//				System.out.print((char)(c+j));
//			}
//			System.out.println();
//		}
//		
		/*
		 * ★☆☆☆★
		 * ☆★☆★☆
		 * ☆☆★☆☆
		 * ☆★☆★☆
		 * ★☆☆☆★
		 */
		System.out.printf("<자바반복문문제%2d>\n",19);
		for (int i=1;i<=5;i++)
		{
			for (int j=1; j<=5; j++)
			{
				if(i==j || 6-j==i)
					System.out.print('★');
				else
					System.out.print('☆');
					
			}
			System.out.println();
		}
		
		/*
		 * ★☆☆☆★
		 * ☆☆☆☆☆
		 * ☆☆☆☆☆
		 * ☆☆☆☆☆
		 * ★☆☆☆★
		 */
		System.out.printf("<자바반복문문제%2d>\n",20);
		for (int i=1;i<=5;i++)
		{
			for (int j=1; j<=5; j++)
			{
				if(i+j==6 || i==j)
					System.out.print('★');
				else
					System.out.print('☆');
					
			}
			System.out.println();
		}
	}
}
