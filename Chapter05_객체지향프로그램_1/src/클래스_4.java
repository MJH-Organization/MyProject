// 사용자 정의 데이터
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class Recipe {

	int	rno;	// 구분자
	String title;
	String chef;
	String poster;
	
}
class RecipeSite
{
	static Recipe[] recipes=new Recipe[40];		// 값이 null 인 40개의 Recipe 생성 
	// 사용자 정의 데이터는 일반 데이터형과 사용하는 방법이 유사
	// 시작과 동시에 recipes의 초기화
	static // 초기화 블록
	{
		try
		{
			Document doc=Jsoup.connect("https://www.10000recipe.com/recipe/list.html").get();
			Elements title=doc.select("ul.common_sp_list_ul div.common_sp_caption_tit");
			Elements chef=doc.select("ul.common_sp_list_ul div.common_sp_caption_rv_name");
			int j=0;
			for (int i=0; i<title.size(); i++)
			{
//				System.out.println(title.get(i).text());
//				System.out.println(chef.get(i).text());
				recipes[j]=new Recipe();
				recipes[j].title=title.get(i).text();
				recipes[j].chef=chef.get(i).text();
				j++;
			}
		}catch(Exception ex) {}
	}
}
public class 클래스_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecipeSite	rs=new RecipeSite();
		System.out.println("========= 레시피 목록 ==============");
		for (Recipe r:rs.recipes)
		{
			System.out.println(r.title);
		}

	}

}
