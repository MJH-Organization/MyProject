class Rand
{
	int[] arr=new int[5];	// 저장이 안됨
	static int[] arr2=new int[5];	// 이미 저장
	
	// 인스턴스 초기화 블럭
	{
		for (int i=0; i<arr.length; i++)
		{
			arr[i]=(int)(Math.random()*100)+1;
		}
	}
	
	// 생성자	=> 인스턴스 변수의 초기화는 보통	=> 생성자
	// static의 초기화		=> static 블럭에서 주로 사용
	Rand()
	{
		for (int i=0; i<arr.length; i++)
		{
			arr[i]=(int)(Math.random()*100)+1;
		}
		
	}
	// 자동으로 처리
	static
	{
		for (int i=0; i<arr2.length; i++)
		{
			arr2[i]=(int)(Math.random()*100)+1;
		}
	}
	
}
public class 클래스_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rand r=new Rand();	// arr이 저장되는 상태
		// r => arr	=> 메모리가 따로 따로 저장
		for (int i=0; i< r.arr.length; i++)
		{
			System.out.println(r.arr[i]);
		}
		
		for (int i=0; i< Rand.arr2.length; i++)
		{
			System.out.println(Rand.arr2[i]);
		}
	}

}
