import java.util.Scanner;
public class 자바반복문문제_while {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.printf("<자바반복문문제_while%2d>\n",1);
		int num=0,num2=2;
		while (true)
		{
			System.out.print("숫자를 입력하세요: ");
			String str = scan.next();
			if (str.matches(".*[^0-9].*"))
				continue;
			num = Integer.parseInt(str);
			if (num<2||num>9)
			{
				System.out.println("2~9까지의 정수를 입력해 주세요!!");
			}
			else
			{
				break;
			}
			
		}
		while (num2<=9)
		{
			System.out.printf("%2d *%2d =%2d\n",num,num2,num*num2);
			num2++;
		}

		System.out.printf("<자바반복문문제_while%2d>\n",2);
		num=1;
		while ((num*8)<100)
		{
			System.out.printf("%2d ",num*8);
			num++;
		} 
		System.out.println();

		System.out.printf("<자바반복문문제_while%2d>\n",3);
		int cnt=1;
		while (cnt <=100)
		{
			if (cnt%4==0)
				System.out.print(cnt+" ");
			if (cnt%7==0)
				System.out.print(cnt+" ");
			cnt++;
		}
		System.out.println();

		System.out.printf("<자바반복문문제_while%2d>\n",4);
		cnt=1;
		while (cnt <=100)
		{
			int val = cnt % 10;
			if (val%3==0 && val!=0)
				System.out.print(cnt+" ");
			cnt++;
		}
		System.out.println();

		System.out.printf("<자바반복문문제_while%2d>\n",5);
		System.out.print("문자열을 입력하세요: ");
		String data=scan.next();
		int i=0;
		int a=0,e=0,o=0,u=0;
		i=0;
		while (i<data.length())
		{
			switch (data.charAt(i))
			{
			case 'a': 
				a++;
				break;
			case 'e': 
				e++;
				break;
			case 'i': 
				i++;
				break;
			case 'o': 
				o++;
				break;
			case 'u':
				u++;
				break;
			}
			i++;
		}
		System.out.println(data + "의 모음의 갯수 : " + (a+e+i+o+u));
		
		System.out.printf("<자바반복문문제_while%2d>\n",6);
		num=0;
		num2=10;
		while (true)
		{
			System.out.print("숫자를 입력하세요: ");
			num = scan.nextInt();
			if (num<1||num>9)
			{
				System.out.println("1~9까지의 정수를 입력해 주세요!!");
			}
			else
			{
				break;
			}
			
		}
		while (num2<=99)
		{
			if ((num2%10+num2/10)==num)
				System.out.print(num2+" ");
			num2++;
		}
		System.out.println();

		System.out.printf("<자바반복문문제_while%2d>\n",7);
		num2=10;
		while (num2<=20) 
		{
			System.out.print(num2+" ");
			num2++;
		}
		System.out.println();
		
		System.out.printf("<자바반복문문제_while%2d>\n",8);
		num2=20;
		while (num2>=10) 
		{
			System.out.print(num2+" ");
			num2--;
		}
		System.out.println();
		
		System.out.printf("<자바반복문문제_while%2d>\n",9);
		int max=0;
		i=1;
		while (i<=5)
		{
			System.out.println(i+"번째 숫자를 입력하세요: ");
			num = scan.nextInt();
			if (max<num)
				max=num;
			i++;
		}
		System.out.println("입력한 숫자 중 최대값은 : " + max);
		
		System.out.printf("<자바반복문문제_while%2d>\n",10);
		int sum=0,len=0;
		String maxStr="";
		i=1;
		while (i<=3)
		{
			System.out.println(i+"번째 문자열 입력하세요: ");
			data = scan.next();
			len = data.length();
			sum += len;
			if (maxStr.length()<len)
				maxStr=data;
			i++;
		}
		System.out.println("입력한 문자열의 길이의 합은 : " + sum);
		System.out.println("입력한 문자열 중 최대길이는 : " + maxStr);
	}

}
