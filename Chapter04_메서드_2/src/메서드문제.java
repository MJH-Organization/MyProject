import java.text.ChoiceFormat;
import java.util.Calendar;
import java.util.Scanner;
public class 메서드문제 {

	static void print1(int s, int e)
	{
		for (int i=s; i<=e; i++)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}
	static int sum(int s, int e)
	{
		int sum=0;
		for (int i=s; i<=e; i++)
		{
			sum+=i;
		}
		return sum;
	}
	static double div(int a, int b)
	{
		return (a / (double)b);
	}
	static int inputInt(String str)
	{
		Scanner scan=new Scanner(System.in);
		System.out.print(str);
		int num=scan.nextInt();
//		scan.close();
		return num;
	}
	static String inputStr(String str)
	{
		Scanner scan=new Scanner(System.in);
		System.out.print(str);
		return scan.next();
	}
	static boolean checkSymmetry(String s)
	{
		boolean result=true;
		if (s.length()%2==0)
			for(int i=0; i<s.length()/2; i++)
			{
				if (s.charAt(i)!=s.charAt(s.length()-1-i))
				{
					result=false;
					break;
				}
			}
		else
		{
			result=false;	
		}
		return result;
	}
	static String toUpper(String s)
	{
		return s.toUpperCase();
	}
	static String reverse(String s)
	{
		String result="";
		for (int i=0; i<s.length(); i++)
		{
			result+=s.charAt(s.length()-1-i);
		}
		return result;
	}
	static String reverseNum(int num)
	{
		while (true)
		{
			if (num%10==0)
				num /= 10;
			else
				break;
		}
		return reverse(String.valueOf(num));
	}
	static char grade(int score)
	{
        switch (score/10)
		{
		case 10: case 9:
			return 'A';
		case 8: 
			return 'B';
		case 7: 
			return 'C';
		case 6: 
			return 'D';
		default: 
			return 'F';
		}
	}
	
	static boolean checkYunneon(int a)
	{
		if ((a%4==0 && a%100!=0) || a%400==0)
			return true;
		else 
			return false;
	}
	static void checkWeek(int year, int month, int day)
	{
		String[] weekName = {"","일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
		Calendar cal = Calendar.getInstance(); 
		cal.set(year,month-1,day);
		System.out.printf("%d년% d월 %d일은 %s입니다.\n",year,month,day,weekName[cal.get(Calendar.DAY_OF_WEEK)]);
	}
	static boolean checkEven(int a)
	{
		if (a%2==0)
			return true;
		else 
			return false;
	}
	static boolean checkTimes3(int a)
	{
		if (a%3==0)
			return true;
		else 
			return false;
	}
	static int max(int a, int b)
	{
		if (a<b)
			return b;
		else
			return a;
	}
	static void process()
	{
		System.out.printf("\n메서드문제_%d\n",1);
		print1(1, 10);
		System.out.printf("\n메서드문제_%d\n",2);
		int sum=sum(1, 10);
		System.out.println("1~10의 합: "+sum);
		
		System.out.printf("\n메서드문제_%d\n",3);
		int num=inputInt("1~N의 합, N을 입력하세요: ");
		System.out.printf("1~%d까지의 합: %d\n",num,sum(1,num));
		
		System.out.printf("\n메서드문제_%d\n",4);
		int num1=inputInt("첫번째 정수를 입력하세요: ");
		int num2=0;
		while(true)
		{
			num2=inputInt("두번째 정수를 입력하세요: ");
			if (num2==0)
			{
				System.out.println("0으로 나눌 수 없습니다"); 
				continue;
			}
			break;
		}
		System.out.printf("%d / %d = %.2f\n",num1,num2,div(num1,num2));

		System.out.printf("\n메서드문제_%d\n",5);
		char c = (char)((Math.random()*26)+97);
		System.out.println(c+"의 대문자: "+ toUpper(String.valueOf(c)));
		
		System.out.printf("\n메서드문제_%d\n",6);
		String str=inputStr("문자열을 입력하세요: ");
		System.out.println(str+"은 대칭"+(checkSymmetry(str)?"입니다":"이 아닙니다"));
		
		System.out.printf("\n메서드문제_%d\n",7);
		System.out.println(str+" => "+reverse(str));
		
		System.out.printf("\n메서드문제_%d\n",8);
		int score=0;
		while (true)
		{
			score=inputInt("점수를 입력하세요");
			if (score<0 || score>100)
				System.out.println("0~100 사이의 점수를 입력해주세요!!" );
			else
				break;
		}
		System.out.println(score+"점은 "+grade(score)+"등급입니다.");
		
		System.out.printf("\n메서드문제_%d\n",9);
		int year=0;
		while (true)
		{
			year=inputInt("년도를 입력하세요: ");
			if (year<0 || year>9999)
				System.out.println("1~9999 사이의 년도를 입력해주세요!!" );
			else
				break;
		}
		System.out.println(year+" 년도는 윤년"+(checkYunneon(year)?"입니다":"이 아닙니다"));
		
		System.out.printf("\n메서드문제_%d\n",10);
		num1=inputInt("첫번째 숫자를 입력하세요: ");
		num2=inputInt("두번째 숫자를 입력하세요: ");
		System.out.printf("%d와 %d 중에서 큰 수는 %d입니다. \n",num1,num2,max(num1,num2));

		System.out.printf("\n메서드문제_%d\n",11);
		System.out.println(num1+"는(은) "+(checkEven(num1)?"짝수":"홀수")+"입니다.");

		System.out.printf("\n메서드문제_%d\n",12);
		System.out.println(num1+"는(은) 3의 배수"+(checkTimes3(num1)?"입니다.":"가 아닙니다."));

		System.out.printf("\n메서드문제_%d\n",13);
		year=inputInt("년도를 입력하세요: ");
		int month=inputInt("월을 입력하세요: ");
		int day=inputInt("날짜를 입력하세요: ");
		checkWeek(year, month, day);
		System.out.printf("\n메서드문제_%d\n",14);
		System.out.println(num1+" => "+reverseNum(num1));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process();
	}

}
