
/**
 * 문자의 위치 찾기
 * indexOf(문자) => 문자열 처음부터 -- 지정된 문자를 찾는다
 * lastIndexOf(문자) =>문자열 뒤에서부터  -- 경로찾기
 * *** 없는 경우 -1
 * => 확장자?
 * https://www.daum.net/index.html
 * Hello Java
 * a.b.c.txt
 */
import java.util.Scanner;
public class 문자열_5 { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data="Hello Java";
		//           0123456789
		int a=data.indexOf("a");		// 7
		int b=data.lastIndexOf("a");	// 9
		int c=data.indexOf("c");		// -1
		
		System.out.printf("a= %2d\n",a);
		System.out.printf("b= %2d\n",b);
		System.out.printf("c= %2d\n",c);
	}

}
