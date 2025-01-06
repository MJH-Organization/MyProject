package com.sist.movie;

import java.util.*;
import java.io.*;
public class MovieSystem {
	// 영화 전체 정보	=> 모든 사용자가 공유
	static Movie[]	movies= new Movie[1938];
	
	// 초기화
	static
	{
		try
		{
			FileReader	fr=new FileReader("c:\\javaDev\\movie.txt");
			int i=0;	// 한글자씩 읽어 온다	=> 정수
			StringBuffer sb=new StringBuffer();
			// 문자열 결합의 최적화	=> 데이터가 많은 경우
			while((i=fr.read())!=-1)
			{
				sb.append((char)i);
			}
			fr.close();
			//System.out.println(sb.toString());
			String data = sb.toString();
			String[] temp=data.split("\n");
			int j=0;
			for (String s:temp)
			{
				movies[j]=new Movie();
				String[] ss=s.split("\\|");
				movies[j].no=ss[0];
				movies[j].title=ss[1];
				movies[j].genre=ss[2];
				movies[j].poster=ss[3];
				movies[j].actor=ss[4];
				movies[j].regdate=ss[5];
				movies[j].grade=ss[6];
				movies[j++].director=ss[7];
				
			}
			
			
		}catch(Exception ex) {}	// ㅑㅐ => 파일 입력 출력	=> 반드시 예외처리
	}
	// 목록
	public Movie[] movieListData(int page)
	{
		final int ROWSIZE=20;
		//int pagecnt=(ROWSIZE*page)-ROWSIZE;
		int start = (page-1)*ROWSIZE; //	=> 시작위치
		int end = page*ROWSIZE;
		int totalpage=(int)(Math.ceil(movies.length/20.0));
		int ARRSIZE=20;
		if(page==totalpage)
		{
			end=page*ROWSIZE-2;
			ARRSIZE=18;
		}
		//						올림함수
		//	17 => 10	=> 2	17/10.0 => 1.7	=> 2
		//	11 => 10	=> 2	11/10.0 => 1.1	=> 2
		/*
		 * 1page	=> 0~19
		 * 2page	=> 20~39
		 * 3page	=> 40~59
		 * 
		 * 마지막	=> 1938	=> 18
		 */
		Movie[]	result=new Movie[ARRSIZE];
		int j=0;
		for (int i=start; i<end; i++)
		{
			result[j++]=movies[i];
		}
		return result;
	}
	// 상세보기
	public Movie movieDetail(int no)
	{
		return movies[no];
	}
	// 검색
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MovieSystem ms=new MovieSystem();
		Scanner scan=new Scanner(System.in);
		while(true)
		{
			System.out.println("=================  메뉴 =================");
			System.out.println("1. 영화 목록");
			System.out.println("2. 영화 상세보기");
			System.out.println("3. 영화 검색(영화명)");
			System.out.println("4. 영화 검색(출연진)");
			System.out.println("5. 종료");
			System.out.println("========================================");
			System.out.print("메뉴 선택: ");
			int menu=scan.nextInt();
			if (menu==5)
			{
				System.out.println("프로그램 종료");
				break;
			}
			else if (menu==1)
			{
				System.out.print("페이지 선택: ");
				int page=scan.nextInt();
				Movie[] movies=ms.movieListData(page);
				for (Movie m:movies)
				{
					System.out.println(m.no+"."+m.title);
				}
			}
			else if (menu==2)
			{
				System.out.print("영화번호 선택(1~1938): ");
				int no = scan.nextInt();
				Movie m=ms.movieDetail(no-1);
				System.out.println("영화명: "+m.title);
				System.out.println("출연진: "+m.actor);
				System.out.println("감독: "+m.director);
				System.out.println("장르: "+m.genre);
				System.out.println("등급: "+m.grade);
				System.out.println("개봉일: "+m.regdate);
			}
		}

	}


}
