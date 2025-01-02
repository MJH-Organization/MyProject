package com.sist.manager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.vo.*;
// 같은 패키지에 존재 => import를 사용하지 않는다
// 다른 패키지에 있는 클래스 사용 => import 사용
// => import : 사용자 정의, 라이브러리 클래스 로드
// => import java.lang.*;   => 자동 추가
public class GenieMusicSystem {
    public MusicVO[] musics=new MusicVO[50];    // 객체 Array의 초기값은 null
    public String title="지니뮤직 Top50";
    // 인스턴스 초기화 블럭 => 호출(X), 상속(X)
    {
        // 예외처리 => 파일관련, 네트워크 관련, 데이터베이스 관련
        // URL  => 웹 네트워크   ==> 8wkd
        /*
         *  예외 복구
         *  예외 회피
         *  예외 임의로 발생 => 견고성
         *  
         *  = 가독성
         *  = 최적화
         *  = 견고성
         *  ------
         */
        try
        {
            // 정상적으로 수행하는 문장
            // int a=10/0;
            // https://www.genie.co.kr/chart/top200 -> table.list-wrap a.title, a.artist, a.albumtitle
            // https://www.melon.com/chart/index.htm -> table.width:100%
            
            Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
            Elements title=doc.select("table.list-wrap a.title");
            Elements singer=doc.select("table.list-wrap a.artist");
            Elements album=doc.select("table.list-wrap a.albumtitle");
            
            for (int i=0; i<50; i++)
            {
//                System.out.println(title.get(i).text());
//                System.out.println(singer.get(i).text());
//                System.out.println(album.get(i).text());
//                System.out.println("=========================================");
                musics[i]=new MusicVO() ;   // 객체 Array에 메모리 공간 확보를 위해...
                
                musics[i].setNo(i+1);
                musics[i].setTitle(title.get(i).text());
                musics[i].setSinger(singer.get(i).text());
                musics[i].setAlbum(album.get(i).text());
            }
        }catch(Exception ex) {
            // 에러 발생시에 복구 / 에러출력
            // 에러를 건너뛴다
        }
    }
    // => 웹/윈도우 => 리턴형으로 데이터 전송
    public MusicVO[] musicAllData()
    {
        return musics;
    }
    public MusicVO[]   musicFindData(String fd)
    {
        int count=0;
        for(MusicVO vo:musics)
        {
            if(vo.getTitle().contains(fd))
            {
                count++;
            }
        }
        // 동적 배열 생성 => 가변 Collection
        MusicVO[] music = new MusicVO[count];
        // 배열의 단점 => 메모리 갯수를 고정한다
        int i=0;
        for (MusicVO vo:musics)
        {
            if(vo.getTitle().contains(fd))
            {
                music[i]=vo;
                // 클래스는 주소값을 대입
                i++;
            }
        }
        
        return music;
    }
}
