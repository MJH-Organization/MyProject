import java.util.*;
import com.sist.data.*;
public class 문자열배열_3 {
	/*
	 * 클래스 => 한개에 대한 정보
	 * class Music
	 * {
	 * 		String	title, singer, album, state;
	 * 		int 	modify
	 * }
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 데이터 읽기
		String[] title=ArrayData.title;
		String[] singer=ArrayData.singer;
		String[] album=ArrayData.album;
		String[] state=ArrayData.state;
		int[] modify=ArrayData.modify;
		// => String[][] music=new String[50][5];
		// => Music[] music=new Music[50]; 	// 사용자 정의 데이터형
		// 뮤직 목록
		System.out.println("Music Top50");
		for (int i=0;i<title.length; i++)
		{
			String s=state[i];
			String m="";
			if(s.equals("유지"))
			{
				m="-";
			}
			else if(s.equals("상승"))
			{
				m="▲ "+modify[i];
			}
			else if(s.equals("하강"))
			{
				m="▼ "+modify[i];
			}
			
			System.out.println(
					(i+1)+"."+m+" "+title[i]+" "+singer[i]+" "+album[i]+" "
					);
		}
		System.out.println("=============================================");
		// 검색
//		Scanner scan = new Scanner(System.in);
//		System.out.print("카테고리 선택(곡명(1), 가수명(2)): ");
//		int menu = scan.nextInt();
//		int count=0;
//		if (menu==1) 	// 제목
//		{
//			System.out.print("제목 입력: ");
//			String name=scan.next();
//			for(int i=0; i<title.length; i++)
//			{
//				if(title[i].contains(name))
//				{
//					System.out.println("노래명: "+title[i]);
//					System.out.println("가수명: "+singer[i]);
//					System.out.println("앨범: "+album[i]);
//					System.out.println("등폭: "+(state[i].equals("유지")?"유지":state[i])+" "+modify[i]);
//					count++;
//					System.out.println("--------------------------------");
//				}
//			}
//		}
//		else if (menu==2)	// 가수명
//		{
//			System.out.print("가수명 입력: ");
//			String name=scan.next();
//			for(int i=0; i<singer.length; i++)
//			{
//				if(singer[i].contains(name))
//				{
//					System.out.println("노래명: "+title[i]);
//					System.out.println("가수명: "+singer[i]);
//					System.out.println("앨범: "+album[i]);
//					System.out.println("등폭: "+(state[i].equals("유지")?"유지":state[i])+" "+modify[i]);
//					count++;
//					System.out.println("--------------------------------");
//				
//				}
//			}
//		}
//		System.out.println("총 "+count+"건 검색");
		
//		등폭이 가장 많은 노래명과 가수명을 출력
		
//		scan.close();
		int maxModify=modify[0];
		for(int i=1; i<50; i++)
		{
			if (maxModify<modify[i])
			{
				maxModify=modify[i];
			}
		}
		int count=0;
		for(int i=1; i<50; i++)
		{
			if (maxModify==modify[i])
			{
				count++;
			}
		}
		System.out.println("배열 갯수: "+count);
		// 동적 배열 생성
		int[] index=new int[count];
		
		int j=0;
		for (int i=0; i< 50; i++)
		{
			if (maxModify==modify[i])
			{
				index[j++]=i;
			}
		}
		for (int i=0; i<count; i++)
		{
			System.out.println("등폭이 가장 많은 노래: "+(index[i]+1)+"."+title[index[i]]+", 가수: "+singer[index[i]]);
		}
	}

}

