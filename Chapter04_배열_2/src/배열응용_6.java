/**
 * 
 */
import java.util.*;
public class 배열응용_6 {

	public static void main(String[] args) {
		
		int[] arr=new int[5];
		for (int i=0; i<arr.length; i++)
		{
			arr[i]=(int)(Math.random()*100)+1;
		}
		System.out.println("정렬 전");
		for (int i : arr)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("정렬 후");

		배열응용_4.sort(arr);
		System.out.println(Arrays.toString(arr));

	}

}
