import java.util.Arrays;

public class 문자열문제_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("\n문자열문제_%d\n",2);
		int[] arr= {50,45,35,12,7};
		int sum=0, max=arr[0], min=arr[0], maxIdx=0, minIdx=0;
		
		for (int i=0; i<arr.length; i++)
		{
			System.out.printf("사원(%d):%d, ",i,arr[i]);
			sum += arr[i];
			if (max<arr[i])
				maxIdx=i;
			if (min>arr[i])
				minIdx=i;
		}
		System.out.println();
		System.out.println("실적 합계: "+sum);
		System.out.println("실적 평규: "+sum/5.0);
		System.out.printf("최고 실적: 사원(%d) %d, 최하 실적: 사원(%d) %d",maxIdx, max,minIdx, min);
		System.out.println();

		System.out.printf("\n문자열문제_%d\n",5);
		int[] arr5 = new int[10];
		int evenTotal=0, oddTotal=0;
		String even="", odd="";
		for (int i=0; i<arr5.length; i++)
		{
			arr5[i]=(int)(Math.random()*100)+1;
			if (arr5[i]%2==0)
			{
				evenTotal+=arr5[i];
				even+=arr5[i]+", ";
			}
			else
			{
				oddTotal+=arr5[i];
				odd+=arr5[i]+", ";
			}
		}
		System.out.println(Arrays.toString(arr5));
		System.out.printf("짝수[%s] 합: %d\n",even,evenTotal);
		System.out.printf("홀수[%s] 합: %d\n",odd,oddTotal);
		
		System.out.printf("\n문자열문제_%d\n",6);
		int[] arr6 = new int[100];
		int[] cnt = new int[10];
		for (int i=0; i<arr6.length; i++)
		{
			arr6[i]=(int)(Math.random()*10);
			cnt[arr6[i]]++;
		}
		System.out.println(Arrays.toString(arr6));
		for (int i=0; i<cnt.length; i++)
		{
			System.out.printf("'%d'의 개수: %d\n", i, cnt[i]);
		}

		System.out.printf("\n문자열문제_%d\n",7);
		char[] c = new char[5];
		for (int i=0; i<c.length; i++)
		{
			c[i]=(char)((Math.random()*26)+65);
			for (int j=0; j<i; j++)
			{
				if (c[i]==c[j])
				{
					i--;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(c));
		char temp = ' ';
		for (int i=1; i<c.length; i++)
		{
			for (int j=0; j<5-i; j++)
			{
				if(c[j]>c[j+1])
				{
					temp=c[j];
					c[j]=c[j+1];
					c[j+1]=temp;
				}
			}
			System.out.println("→"+Arrays.toString(c));
		}
		
	}


}
