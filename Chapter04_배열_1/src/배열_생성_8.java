
/**
 *	
 */									
 
public class 배열_생성_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {100,200,300,400,500};
		System.out.println("==== 일반 for문 : index번호 =======");
		for (int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		// int a~z => 26개 변수 arr[0]~arr[25]
		arr[0]=10000;
	}

}

