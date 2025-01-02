
/**
 *		=> 정수 => 0~9 사이의 난수 발생 => 30개 빈도수 구한다
 */									
 
public class 배열_생성_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int COUNT=30;
		int[] arr = new int[10];
		// 아이디 마다 => 장바구니에 추가한 갯수
		int num = 0;
		for (int i=1; i<=COUNT; i++)
		{
			num=(int)(Math.random()*10);
			System.out.print(num+" ");
			arr[num]++;
		}
		System.out.println();
		for (int i=0; i<arr.length; i++)
		{
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
		}
	}

}

