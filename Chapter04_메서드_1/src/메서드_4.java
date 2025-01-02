
/**
 *	사용자로부터 단을 입력을 받아서 해당 구구단을 출력
 *	----------------			---------
 *		매개변수 						리턴형	=> 자체 void
 *									리턴형	=> String
 */
import java.util.Scanner;
// 프로그램	=> 정답이 없다	=> 요구사항에 맞게 출력
public class 메서드_4 {

//	static void gugudan(int dan)
//	{
//		for (int i=1; i<=9; i++)
//		{
//			System.out.println(dan+"*"+i+"="+(dan*i));
//		}
//	}
	
	static String gugudan(int dan)
	{
		String result="";
		for (int i=1; i<=9; i++)
		{
			result+=dan+"*"+i+"="+(dan*i)+"\n";
		}
		
		return result;
	}
	static void process()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("단 입력(2~9): ");
		int dan=scan.nextInt();
		
		// 메서드 호출
		String g=gugudan(dan);
		System.out.println(g);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process();
	}

}
