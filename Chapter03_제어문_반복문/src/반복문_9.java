
public class 반복문_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 대부분은 0초기화
		for (int i=1; i<=10; i++)
		{
			char c='A';
			int no = (int)(Math.random()*2); // 0,1
			if (no==0)
				c=(char)((Math.random()*26)+65); // 대문자 추출
			else
				c=(char)((Math.random()*26)+97); // 소문자 추출
			
			System.out.println("no="+no+",c="+c);
				
		}
		
	}

}
