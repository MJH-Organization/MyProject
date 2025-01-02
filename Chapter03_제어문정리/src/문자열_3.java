
/**
 * 문자열 정보
 * => length() : 문자의 갯수 (비밀번호가 8자 이상인가? 확인)
 */
import java.util.Scanner;
// 사용자가 입력한 문자의 갯수 확인 => 공백포함
// " Hello Java " (12자)
public class 문자열_3 { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("문자열 입력: ");
		
		String str1 = scan.next();		// 공백/enter 전까지 읽는다
		String str2 = scan.next();		
		String str3 = scan.next();		
//		String str = scan.nextLine();	// enter 입력 전까지 읽는다
		System.out.println("==== 결과값 =====");
		System.out.println("문자의 갯수: "+str1.length());
		System.out.println("문자의 갯수: "+str2.length());
		System.out.println("문자의 갯수: "+str3.length());
	}

}
