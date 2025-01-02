
/**
 *	 
 */
import java.util.*;
import com.sist.data.*;
public class 문자열배열_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String movie = "1|쇼생크 탈출|드라마|https://movie-phinf.pstatic.net/20160119_278/14531650465287bcuk_JPEG/movie_image.jpg?type=m77_110_2|팀 로빈스(앤디 듀프레인), 모건 프리먼(엘리스 보이드 레드 레딩)|2016 .02.24 재개봉, 1995 .01.28 개봉|15세 관람가|프랭크 다라본트\r\n";
		String[] info=movie.split("\\|");
		//	=> 오라클
		// StringTokenizer
		//System.out.println(Arrays.toString(info));
		/*
		 * 	split는 정규식
		 * 			--- 사용하는 기호
		 * 			|, ?, ., +, *...
		 * 			-------------------
		 * 			실제 데이터를 읽기
		 * 			\\|	===> 문자열
		 */
		System.out.println("순위: "+info[0]);
		System.out.println("영화명: "+info[1]);
		System.out.println("장르: "+info[2]);
		// info[3] => poster
		System.out.println("출연: "+info[4]);
		System.out.println("개봉일: "+info[5]);
		System.out.println("등급: "+info[6]);
		System.out.println("감독: "+info[7]);
	}

}
