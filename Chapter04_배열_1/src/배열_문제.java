import java.util.Arrays;
import java.util.Scanner;
public class 배열_문제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("배열문제_%d\n",1);
		int[] kor = new int[5];
		int[] grade = new int[5];
		for (int i=0; i<kor.length; i++)
		{
			kor[i]=(int)(Math.random()*101);
		}
		System.out.println(Arrays.toString(kor));
		for (int i=0; i<grade.length; i++)
		{
			grade[i]=1;
			for (int j=0; j<kor.length; j++)
			{
				if (kor[i]<kor[j])
					grade[i]++;
			}
		}
		System.out.println(Arrays.toString(grade));
		
		System.out.printf("\n배열문제_%d\n",2);
		int[] num = new int[10];
		int max=0, min=99999;
		for (int i=0; i<num.length; i++)
		{
			num[i]=(int)(Math.random()*100000);
		}
		System.out.println(Arrays.toString(num));
		for (int i=0; i<num.length; i++)
		{
			if(num[i]>max)
				max=num[i];
			if(num[i]<min)
				min=num[i];
		}
		System.out.printf("최대값: %5d, 최소값: %5d\n", max, min);
		
		System.out.printf("\n배열문제_%d\n",3);
		int[] arr2 = new int[10];
		int num2=0;
		for (int i=0; i<100; i++)
		{
			num2=(int)(Math.random()*10);
			arr2[num2]++;
			System.out.print(num2+" ");
		}
		System.out.println();
		for (int i=0; i<arr2.length; i++)
		{
			System.out.printf("arr2[%d]: %d개\n",i,arr2[i]);
		}
		System.out.println();
		
		System.out.printf("\n배열문제_%d,%d\n",4,5);
		int[] arr3 = new int[10];
		for (int i=0; i<arr3.length; i++)
		{
			arr3[i]=(int)(Math.random()*100000);
			System.out.print(arr3[i]+" ");
		}
		System.out.println("\n인덱스가 1인 곳: "+arr3[1]);
		max=0;
		int index=0;
		for (int i=0; i<arr3.length; i++)
		{
			if (max<arr3[i])
			{
				max=arr3[i];
				index=i;
			}
		}
		System.out.println("최대값의 인덱스: "+index);
		
		System.out.printf("\n배열문제_%d\n",6);
		int sum=0;
		double avg=0.0;
		for (int i=0;i<arr3.length; i++)
		{
			sum += arr3[i];
		}
		avg = sum / 10.0;
		System.out.printf("총합: %10d, 평균:%10.1f\n",sum,avg);
		
		System.out.printf("\n배열문제_%d\n",7);
		for (int i=0;i<arr3.length; i++)
		{
			if (i!=3)
				System.out.print(arr3[i]+" ");
		}

		System.out.printf("\n배열문제_%d\n",13);
		int[] kor2 = new int[3];
		int[] eng2 = new int[3];
		int[] math2 = new int[3];
		int[] sum2 = new int[3];
		double[] avg2 = new double[3];
		int[] grade2 = new int[3];
		int sumKor=0, sumEng=0, sumMath=0;
	
		
		for (int i=0; i<kor2.length; i++)
		{
			kor2[i]=(int)(Math.random()*101);
			sumKor += kor2[i];
			eng2[i]=(int)(Math.random()*101);
			sumEng += eng2[i];
			math2[i]=(int)(Math.random()*101);
			sumMath += math2[i];
			
			sum2[i]=kor2[i]+eng2[i]+math2[i];
			avg2[i]= sum2[i]/3.0;
		}
		for (int i=0; i<grade2.length; i++)
		{
			grade2[i]=1;
			for (int j=0; j<grade2.length; j++ )
				if (sum2[i]<sum2[j])
					grade2[i]++;
			System.out.printf("%1d번째 국어:%3d, 영어:%3d, 수학:%3d, 총점:%3d, 평균:%.2f, 순위:%1d\n", i+1, kor2[i],eng2[i],math2[i],sum2[i],avg2[i],grade2[i]);

		}
		
	}

}
