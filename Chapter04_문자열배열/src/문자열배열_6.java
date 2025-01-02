
/**
 *	연산자	/ 제어문
 *	문자열	/ 정수	/ 실수
 *	-----------------------	배열	/ 메서드	/ 클래스
 *	=> 주석	=> 교재 정리
 *	감	=> 형식	=> 약간 응용
 *	----------------------
 *	1|
 *	도봉산|
 *	하늘을 깎아세운 만길 봉우리도봉(道峰)산은 이름 그대로 봉우리가 길인 산|
 *	132-010 서울특별시 도봉구 도봉동 경기 의정부시, 양주시 장흥면 일대
 */

import java.util.*;
import com.sist.data.*;
public class 문자열배열_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String seoul_nature="1|도봉산|하늘을 깎아세운 만길 봉우리도봉(道峰)산은 이름 그대로 봉우리가 길인 산|132-010 서울특별시 도봉구 도봉동 경기 의정부시, 양주시 장흥면 일대";
		String seoul=ArrayData.arrayData("seoul_location.txt");
		String[] seoul_data=seoul.split("\n");
		// 입력값 => 주소 / 명소명
		int count=0;
		for (String s:seoul_data)
		{
			String[] data=s.split("\\|");
			if(data[3].contains("마포"))
			{
				System.out.println("번호: "+data[0]);
				System.out.println("명소명: "+data[1]);
				System.out.println("주소: "+data[3]);
				System.out.println("소개: "+data[2]);
				System.out.println("===================================================================================");
				count++;
			}
		}
		System.out.println("검색 결과: "+count+"건");
	}

}
