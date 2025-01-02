import java.util.Arrays;

public class 자바배열문제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("배열문제_%2d\n",4);
		int[] arr= new int[10];
		for (int i=0; i<arr.length;	i++)
		{
			arr[i]=(int)(Math.random()*100)+1;
		}
		System.out.print("입력값: ");
		String result="";
		for (int i:arr) 
		{
			System.out.print(i+" ");
			if (i%3==0)
				result+=i+" ";
		}
		System.out.println("\n3의 배수: "+result.substring(0,result.length()-1));
		
		System.out.printf("배열문제_%2d\n",5);
		int[] arr5= new int[10];
		for (int i=0; i<arr.length;	i++)
		{
			arr5[i]=(int)(Math.random()*10)+1;
		}
		System.out.print("입력값: ");
		int sum=0;
		for (int i:arr5) 
		{
			System.out.print(i+" ");
			sum+=i;
		}
		System.out.printf(", 평균: %5.2f\n", sum/10.0);
		
		System.out.printf("배열문제_%2d\n",6);
		int[] num = { 94, 85, 95, 88, 90 };
		int min=num[0], max=num[0];
		for (int i : num) {
			if (min>i)
				min=i;
			if (max<i)
				max=i;
		}
		System.out.println("최대값: "+max+", 최소값: "+min);

		System.out.printf("배열문제_%2d\n",8);
		int[] arr8 = {10,20,30,50,3,60,-3};
		System.out.println(Arrays.toString(arr8));
		System.out.println("arr[1]: "+arr8[1]);

		System.out.printf("배열문제_%2d\n",9);
		int[] arr9 = {10,20,30,50,3,60,-3};
		System.out.println(Arrays.toString(arr9));
		for (int i=0; i<arr9.length; i++)
			if(arr9[i]==60)
			{
				System.out.println("index: "+i);
				break;
			}


	}

}
