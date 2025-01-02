package com.sist.movie;
import java.util.*;

public class MovieUserName {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        MovieSystem ms=new MovieSystem();
        while(true)
        {
            System.out.println("================ Menu ==============");
            System.out.println("1. 전체 영화 목록");
            System.out.println("2. 상세 보기");
            System.out.println("3. 검색(영화명)");
            System.out.println("4. 검색(출연진)");
            System.out.println("5. 검색(장르)");
            System.out.println("6. 프로그램 종료)");
            System.out.println("====================================");
            
            System.out.print("메뉴 선택: ");
            int menu=scan.nextInt();
            
            if(menu==6)
            {
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            }
            else if(menu==1)
            {
                ArrayList<Movie> list=ms.movieListData();
                for(Movie m:list) {
                    System.out.println(m.getMno()+"."+m.getTitle());
                }
            }
            else if(menu==2)
            {
                System.out.print("1~1938까지 영화 번호 입력: ");
                int mno=scan.nextInt();
                
                Movie m=ms.movieDetail(mno);
                System.out.println("=== " + m.getTitle() + "상세 보기");
                System.out.println("영화명 : "+m.getTitle());
                System.out.println("출연 : "+m.getActor());
                System.out.println("감독 : "+m.getDirector());
                System.out.println("장르 : "+m.getGenre());
                System.out.println("개봉일 : "+m.getRegdate());
                System.out.println("등급 : "+m.getGrade());
            }
            else if(menu==3)
            {
                System.out.print("검색어 입력: ");
                String title=scan.next();
                ArrayList<Movie> list=ms.movieFindTitle(title);
                System.out.println("검색결과: "+list.size()+"건");
                for(Movie m:list)
                {
                    System.out.println(m.getMno()+"."+m.getTitle());
                }
            }
            else if(menu==4)
            {
                System.out.print("검색어 입력: ");
                String actor=scan.next();
                ArrayList<Movie> list=ms.movieFindActor(actor);
                System.out.println("검색결과: "+list.size()+"건");
                for(Movie m:list)
                {
                    System.out.println(m.getMno()+"."+m.getTitle()+" "+m.getActor());
                }
            }
            else if(menu==5)
            {
                System.out.print("검색어 입력: ");
                String genre=scan.next();
                ArrayList<Movie> list=ms.movieFindGenre(genre);
                System.out.println("검색결과: "+list.size()+"건");
                for(Movie m:list)
                {
                    System.out.println(m.getMno()+"."+m.getTitle()+" "+m.getGenre());
                }
            }
            
        }
    }

}
