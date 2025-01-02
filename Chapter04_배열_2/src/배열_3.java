import java.util.Arrays;

/**
 *	10개의 정수를 임의로 추출 (1~100) => max, min
 *=> max의 위치 / min의 위치 확인
 */
public class 배열_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 선언
		int[] arr = new int[10];
		// 임의의 수를 초기화
		// 인덱스 번호
		for (int i=0; i<arr.length; i++)
		{
			arr[i]=(int)(Math.random()*100)+1;
		}
		System.out.println(Arrays.toString(arr));
		int max=arr[0];
		int min=arr[0];
		int addrMax=0, addrMin=0;
		for (int i=1; i<arr.length; i++)
		{
			if (max<arr[i])
			{
				max=arr[i];
				addrMax=i;
			}
			if (min>arr[i])
			{
				min=arr[i];
				addrMin=i;
			}
		}
		String result = String.format("최대값:%d, Index:%d\n", max, addrMax);
		result += String.format("최소값:%d, Index:%d\n", min, addrMin);
		System.out.println(result);
	}

}
