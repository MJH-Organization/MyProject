
/**
 * 로그인 처리 ID/PWD
 */
import java.util.Scanner;
public class 문자열_1 { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String ID="admin";
		final String PWD="1234";
		
		Scanner scan = new Scanner(System.in);
		// equals() => 같으면 true, 다르면 false
		while(true)
		{
			System.out.println("ID를 입력하세요: ");
			String id = scan.next();
			System.out.println("Password를 입력하세요: ");
			String pwd = scan.next();
			if(ID.equalsIgnoreCase(id)&& PWD.equals(pwd))
			{
				System.out.println("로그인되었습니다!!");
				System.out.println("메인 페이지로 이동합니다.");
				break; // while 종료
			}
			else
			{
				System.out.println("ID나 Password가 틀립니다.");
				System.out.println("다시 입력하세요...");
			}
		}
	}

}
