
/**
 * 	3명의 학생의 점수 (국어, 영어, 수학) => 평균, 총점, 학점
 */
import java.util.Scanner;
public class 반복문_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int i = 1;
		while (i<=3)
		{
			System.out.print(i+"번째 국어 점수 입력:");
			int kor = scan.nextInt();
			System.out.print(i+"번째 영어 점수 입력:");
			int eng = scan.nextInt();
			System.out.print(i+"번째 수학 점수 입력:");
			int math = scan.nextInt();
			
			int total = kor+eng+math;
			double avg = total/3.0;
			
			char grade='A';
			switch (total/30) 
			{
			case 10: case 9:
				grade='A';
				break;
			case 8: 
				grade='B';
				break;
			case 7: 
				grade='C';
				break;
			case 6: 
				grade='D';
				break;
			default:
				grade='F';
			}
			System.out.println("국어점수: "+kor);
			System.out.println("영어점수: "+eng);
			System.out.println("수학점수: "+math);
			System.out.println("총점: "+total);
			System.out.printf("평균: %.2f\n",avg);
			System.out.println("학점: "+grade);
			i++;
		}

	}

}
