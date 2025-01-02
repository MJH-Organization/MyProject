
/**
 * 	1~10까지 난수 => 10개를 발생 => 평균
 */
public class 반복문_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double avg=0;
		int sum=0;
		
		int i=1;
		while (i<=10)
		{
			int num = (int)(Math.random()*100)+1;
			System.out.print(num+" ");
			sum += num;
			i++;
		}
		System.out.println("\n난수의 평균: "+(sum/10.0));

	}

}
