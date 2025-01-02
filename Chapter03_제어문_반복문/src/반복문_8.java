// 10개의 정수를 추출해서 최소값, 최대값을 구하는 프로그램
public class 반복문_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max=1, min=100;
		int cnt=0;
		for (int i =1; i<=10; i++)
		{
			int num=(int)(Math.random()*100)+1;	// 1~100
			System.out.println(num+" ");
			
			if (max < num) max = num;
			if (min > num) min = num;
			if ((num%3) == 0) 
			{
				cnt++;
				System.out.println(cnt + ": " + num);
			}
		}
		
		System.out.println("max: " + max+" ");
		System.out.println("min: " + min+" ");
		System.out.println("3의 배수: " + cnt+" ");
		

	}

}
