import java.util.Arrays;

/**
 * 	알고리즘 => 정렬 알고리즘 => 108 page
 * 	
 * 	선택정렬 : 한개의 데이터를 선택한 후에 기준점으로 변경
 * 	------------------ 1 round
 * 	10 	30 	50 	20 	40
 * 	30	10	
 * 	50		30
 * 	50			20
 * 	50				40
 * 	------------------ 2 round
 * 	50 	30	10
 * 	50	30		20
 * 	50	40			30
 * 	------------------ 3 round
 * 	50	40	20	10	
 * 	50	40	30		20
 * 	------------------ 4 round
 * 	50	40	30	20	10
 * 
 */
public class 배열응용_4 {
	static void sort(int[] arr) {
		int temp=0;
		for (int i=0; i<arr.length-1; i++)
		{
			for (int j=i+1; j<arr.length; j++)
			{
				if (arr[i]<arr[j])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[5];
		// 초기화
		for (int i=0; i<arr.length; i++)
		{
			arr[i]=(int)(Math.random()*100)+1;
		}
		System.out.println("정렬 전");
		System.out.println(Arrays.toString(arr));
		
		// 정렬
		int temp=0;
		for (int i=0; i<arr.length-1; i++)
		{
			for (int j=i+1; j<arr.length; j++)
			{
				if (arr[i]<arr[j])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println("정렬 후");
		System.out.println(Arrays.toString(arr));
	}

}
