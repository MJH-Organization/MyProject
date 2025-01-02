
/**
 * 문자열 분리 / 자르기 /변경 / 찾기
 * = charAt(int index)
 * Hello Java
 * 0123456789
 * charAt(6) == 'J'
 */
// 사용자의 문자열을 입력값을 받아서 => a,A가 몇개인지 확인
import java.util.Scanner;
// 사용자의 문자열 입력을 받아서 좌우 대칭 여부 확인
public class 문자열_4 { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String data = "Hello Java";
//		System.out.println("첫번째 문자: "+ data.charAt(0));
//		System.out.println("마지막 문자: "+ data.charAt(data.length()-1));
		Scanner scan = new Scanner(System.in);
//		int cnt = 0;
//		for (int i=0; i<str.length(); i++)
//		{
//			char ch = str.charAt(i);
//			if (ch=='A' || ch=='a')
//			{
//				cnt++;
//			}
//		}
//		// 지역변수 => {}변수 => {}이 종료하면 사라지는 변수
//		System.out.println("a나 A의 갯수: "+cnt);
		String str="";
		while (true) {
			System.out.println("문자열 입력: ");
			str = scan.nextLine();
			if (str.length()%2 == 0)
				break;
			else
				System.out.println("문자 갯수가 짝수여야 합니다.");
		}
		boolean b = true;
		int j = str.length()-1;
		for (int i=0; i<str.length()/2; i++)
		{
			char s = str.charAt(i);
			char e = str.charAt(j--);
			System.out.printf("start=%c, end=%c\n",s,e);
			if (s!=e) 
			{
				b = false;
				break;
			}
		}
		if(b==true)
			System.out.println("문자열이 대칭입니다. ");
		else
			System.out.println("문자열이 대칭이 아닙니다. ");
	}

}
