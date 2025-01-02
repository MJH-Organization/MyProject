package com.sist.music;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class MusicMain {
    // 지니 뮤직
    // 멜론
    // => 공통 (교집합), 차집합 / 합집합
    public Set<String> ginieMusic()
    {
        Set<String> set=new HashSet<>();
        try
        {
            Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
            // 웹서버에 접근
            Elements title=doc.select("table.list-wrap a.title");
//            System.out.println(title);
            for (int i=0;i<title.size(); i++)
            {
                set.add(title.get(i).text());
            }
        }catch (Exception ex) {}
        return set;
    }
    public Set<String> melonMusic()
    {
        Set<String> set=new HashSet<>();
        try
        {
            Document doc=Jsoup.connect("https://www.melon.com/chart/index.htm").get();
            // 웹서버에 접근
            Elements title=doc.select("div.wrap_song_info div.rank01 a");
//            System.out.println(title);
            for (int i=0;i<title.size(); i++)
            {
                set.add(title.get(i).text());
            }
        }catch (Exception ex) {}
        return set;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MusicMain mm=new MusicMain();
        Set<String> ginie=mm.ginieMusic();
        for (String music:ginie)
        {
            System.out.println(music);
        }
        System.out.println("===============================");
        Set<String> melon=mm.melonMusic();
        for (String music:melon)
        {
            System.out.println(music);
        }
        System.out.println("============== 차집합 =================");
        // 오라클 => MINUS removeAll()
        // [1,2,3,4,5] - [4,5,6,7,8] => 1,2,3
        /*ginie.removeAll(melon);
        for (String music:ginie)
        {
            System.out.println(music);
        }*/
        System.out.println("============== 동일곡 출력(교집합) =================");
        // [1,2,3,4,5] , [4,5,6,7,8] => 4,5
        // retainAll => INTERSECT => JOIN
        /*ginie.retainAll(melon);
        System.out.println("동일 곡: "+ginie.size());
        for (String music:ginie)
        {
            System.out.println(music);
        }*/
        
        System.out.println("============== 멜론+지니 =================");
        // UNION => addAll
        // => 중복된 경우에 1개만 첨부
        List<String> list = new ArrayList<String>();
        list.addAll(ginie);
        list.addAll(melon);
        // UNION ALL => 중복된 데이터 포함
        System.out.println("데이터 갯수: "+list.size());
        for (String music:list)
        {
            System.out.println(music);
        }
        // 중복 제거
        Set<String> hap=new HashSet<String>();
        hap.addAll(list);
        System.out.println("============== 중복없는 곡 =================");
        for (String music:hap)
        {
            System.out.println(music);
        }
         System.out.println("중복 없는 데이터 갯수: "+hap.size());
         
        // addAll(): 모든 데이터(합) / removeAll():차집합 / retainAll(): 교집합
        // => JOIN
    }

}
