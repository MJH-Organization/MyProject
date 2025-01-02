
/**
 * contains : 포함된 문자열 => web 데이터 읽기 => 크롤링
 * Jsoup => 크롤링 라이브러리
 * => 데이터가 필요 => 데이터를 읽어온다 => 자바 기능...
 */
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class 문자열_2 { 

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("검색어 입력: ");
		String fd = scan.next();
		
		int listNum=1;
		for (int i=1; i<=4;i++)
		{
			Document doc = Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20241127&hh=11&rtm=Y&pg="+i).get();
			// 곡명 읽기
			Elements title = doc.select("table.list-wrap a.title");
			for (int j=0; j<title.size(); j++)
			{
//				if (title.get(j).text().contains(fd))
//				if (title.get(j).text().startsWith(fd))
				if (title.get(j).text().endsWith(fd))
				{
					System.out.println((listNum++)+"."+title.get(j).text());
//					Thread.sleep(2000);
				}
			}
		}
		
	}

}
