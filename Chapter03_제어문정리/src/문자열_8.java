
/**
 * 대문자 변환 => toUpperCase()
 */
import java.util.Scanner;
/*
 * 함수	: function
 * 메서드	: method
 * ============================== 기능상으로는 동일
 * class 종속
 * 
 * C/C++/Python/ => function (함수)
 * Java / Kotlin => method
 * 
 * replace(문자, 문자)
 *         ---  ---
 *         old  new
 * replace(문자열, 문자열)
 *         ---   ---
 *         old   new
 */
public class 문자열_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String name = "HONG GIL DONG";
		//System.out.println(name.toLowerCase());
		// Upper / Lower => 오라클
		// 데이터 관리 => 자바+오라클 => JSP에서 HTML로 변환
		String data = "Hello Java";
		System.out.println(data.replace('a', 'k'));
		System.out.println(data.replace("Java", "Oracle"));
		// 오라클 연동시 주로 사용
		// 이미지, 줄거리, 내용
		// |, &, '' => 오라클에서 첨부할 수 없다
		// & => Scanner
		// || => 문자열 결합
		// 문자열 => ''
	}

}
