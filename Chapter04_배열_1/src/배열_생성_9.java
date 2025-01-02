import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *	1~10까지 난수를 발생	=> 배열[10] 	=> 중복없이 저장	
 */									

public class 배열_생성_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[10];
		for (int i=0; i<=arr.length-1; i++)
		{
			arr[i] = (int)(Math.random()*10)+1;	// 재실행
			for (int j=0;j<i; j++)
			{
				if(arr[i]==arr[j])
				{
					i--;	// 0 ==> 다시 난수 발생
					break;
				}
				
			}
		}
		System.out.println(Arrays.toString(arr));
		
		// Set을 사용 중복 제거 가능
		HashSet<Integer> sArr = new HashSet<>();
		do
		{
			sArr.add((int)(Math.random()*10)+1);
		} while(sArr.size()<10);
		System.out.println(Arrays.toString(sArr.toArray()));
	}

}

