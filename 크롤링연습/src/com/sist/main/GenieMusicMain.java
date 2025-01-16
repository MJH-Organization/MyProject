package com.sist.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sist.dao.MusicDAO;
import com.sist.vo.MusicVO;

public class GenieMusicMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] url= {
                "https://www.genie.co.kr/chart/top200",
                "https://www.genie.co.kr/chart/genre?ditc=D&ymd=20250113&genrecode=M0100",
                "https://www.genie.co.kr/chart/genre?ditc=D&ymd=20250113&genrecode=M0200",
                "https://www.genie.co.kr/chart/genre?ditc=D&ymd=20250113&genrecode=M0300",
                "https://www.genie.co.kr/chart/genre?ditc=D&ymd=20250113&genrecode=M0107",
                "https://www.genie.co.kr/chart/genre?ditc=D&ymd=20250113&genrecode=M0500",
                "https://www.genie.co.kr/chart/genre?ditc=D&ymd=20250113&genrecode=M0600"
        };
        
        for(int i=0; i<url.length; i++)
        {
            try
            {
                Document doc=Jsoup.connect(url[i]).get();
//                System.out.println(doc);
//                System.out.println("============================================");
                Elements title=doc.select("table.list-wrap a.title");
                Elements singer=doc.select("table.list-wrap a.artist");
                Elements album=doc.select("table.list-wrap a.albumtitle");
                Elements poster=doc.select("table.list-wrap a.cover img");
                Elements etc=doc.select("table.list-wrap span.rank");
                
                System.out.println(url[i]);
                
                MusicDAO dao=MusicDAO.newInstance();
                for(int j=0; j<title.size(); j++)
                {
                    try
                    {
                        System.out.println(title.get(j).text());
                        System.out.println(singer.get(j).text());
                        System.out.println(album.get(j).text());
                        System.out.println(poster.get(j).attr("src"));
                        //System.out.println(etc.get(j).text());
                        String s=etc.get(j).text();
                        String state="";
                        String id="";
                        if(s.equals("유지"))
                        {
                            state="유지";
                            id="0";
                        }
                        else
                        {
                            //  1상승
                            state=s.replaceAll("[^가-힣]", "");
                            // 숫자 제거
                            id=s.replaceAll("[^0-9]", "");
                            // 한글 제외
                        }
                        System.out.println(state);
                        System.out.println(id);
                        System.out.println("=======================================================");
                        
                        MusicVO vo=new MusicVO();
                        vo.setCno(i+1);
                        vo.setTitle(title.get(j).text());
                        vo.setSinger(singer.get(j).text());
                        vo.setAlbum(album.get(j).text());
                        vo.setPoster(poster.get(j).attr("src"));
                        vo.setState(state);
                        vo.setIdcrement(Integer.parseInt(id));
                        vo.setKey("");
                        dao.genieMusicInsert(vo);
                    }catch(Exception ex) {}
                }
            }catch(Exception ex) {}
        }
        System.out.println("데이터 저장 완료!!");
        
    }

}
