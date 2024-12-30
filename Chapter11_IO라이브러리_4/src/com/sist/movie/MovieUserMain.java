package com.sist.movie;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/*
 *      자바 정리
 *      => 2장 / 3장 / 4장
 *          |    |    |
 *                  배열(1차원0
 *            연산자/제어문
 *        변수/데이터형  
 *      => 5장/ 6장 / 7장 / 8장
 *                         | 예외처리 => try, throws
 *                   | 인터페이스
 *              | 상속
 *          | 객체/클래스/멤버변수/메서드
 *      => 9장 / 10장 / 11장
 *                      java.io
 *                          => File / FileInpuStream / FileOutputStream
 *                             FileReader / FileWriter
 *                             BufferedReader / BufferedWriter
 *               java.util
 *                  => StringTokenizer / Random / Date / Calendar
 *                  => List (ArrayList) / Set (HashSet) / Map (HashMap)
 *         java.lang => Object / String / System / Math /Wrapper    
 *             
 */
public class MovieUserMain {
    public static void main(String[] args) {
        MovieSystem ms=new MovieSystem();
        try
        {
            BufferedReader in=
                    new BufferedReader(new InputStreamReader(System.in));
            // 
            while(true)
            {
                System.out.println("======= Menu ========");
                System.out.println("1. 영화 목록");
                System.out.println("2. 영화 상세");
                System.out.println("3. 영화 검색");
                System.out.println("9. 종료");
                System.out.println("=====================");
                System.out.print("메뉴 선택: ");
                String menu=in.readLine();
                int m=Integer.parseInt(menu);
                // BufferedReader => 값을 읽을 때 문자열로 가지고 온다
                // 필요한 데이터형으로 변환 => Wrapper
                if (m==9)
                {
                    System.out.println("프로그램 종료!!");
                    break;
                }
                else if(m==1)
                {
                    List<Movie> list=ms.movieListData();
                    for(Movie mo:list)
                    {
                        System.out.println(mo.getMno()+"."+mo.getTitle());
                    }
                }
                else if(m==2)
                {
                    System.out.print("영화 번호 선택: ");
                    int mno=Integer.parseInt(in.readLine());
                    Movie movie=ms.movieDetailData(mno);
                    System.out.println("영화번호: "+movie.getMno()
                                +"\n영화명:"+movie.getTitle()
                                +"\n출연:"+movie.getActor()
                                +"\n감독:"+movie.getDirector()
                                +"\n등급:"+movie.getGrade()
                                +"\n장르:"+movie.getGenre()
                                );
                }
                else if(m==3)
                {
                    System.out.print("검색어 입력:");
                    String fd=in.readLine();
                    List<Movie> list=ms.movieFindData(fd);
                    System.out.println("검색결과: "+list.size() + "건");
                    for(Movie mo:list)
                    {
                        System.out.println(mo.getMno()+"."+mo.getTitle());
                    }
                    
                    
                }
                else {
                    System.out.println("없는 메뉴입니다!!");
                }
               
            }
        }catch(Exception ex)
        {
            
        }
        
    }
}
