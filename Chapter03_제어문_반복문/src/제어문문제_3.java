import java.util.Scanner;
public class 제어문문제_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0,result=0;
		for (int i=2; i<=100; i+=2)
		{
			sum += i;
		}
		System.out.println("2+4+...+100의 합: "+ sum);
		
		for (int i=5; i<=50; i+=5)
		{
			System.out.print(i+"	");
		}
		System.out.println("");

		for (char c='B'; c<='N'; c+=2)
		{
			System.out.print(c+"	");
		}
		System.out.println("");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력: ");
		int num = scan.nextInt();
		scan.close();
		sum = 0;
		
		for (int i = 1; i<=num; i++)
		{
			sum += i;
		}
		System.out.println("1~"+num+"까지의 합: " + sum);
		
		for (int i=2; i<=30; i+=2)
		{
			System.out.print(i + " ");
			if (i%3==0) System.out.println("");
			
		}
		result = 0;
		for (int i=1; i<=10; i++)
		{
			if (i%2==0) result -= i; 
			else result += i;
		}
		System.out.println("1-2+3...-10까지의 합: "+	result);

		for (int i=1; i<=10; i++)
		{
			if (i%3!=0) System.out.print(i + " ");
			
		}
		System.out.println("");

	}

}
