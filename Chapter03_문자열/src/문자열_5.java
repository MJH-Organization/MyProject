
/**
 * 1.대소문자 변환하여 출력하기
 * 2.문자를 역순으로 출력하기
 */
import java.util.Scanner;
public class 문자열_5 { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("문자열을 입력해 주세요: ");
		String str = scan.next();
		int a=0;
		System.out.print("대소문자 변환: ");
		while (a<str.length())
		{
			char ch = str.charAt(a);
			
			if (ch>='A' && ch<='Z')
				System.out.print(String.valueOf(ch).toLowerCase());
			else if (ch>='a' && ch<='z')
				System.out.print(String.valueOf(ch).toUpperCase());
			else
				System.out.print(ch);
			a++;
		}
		System.out.println();
		System.out.print("문자 역순 출력: ");
		for (int i=str.length()-1; i>=0; i--)
		{
			char c = str.charAt(i);
			System.out.print(c);
		}
		System.out.println();
		scan.close();
	}

}
