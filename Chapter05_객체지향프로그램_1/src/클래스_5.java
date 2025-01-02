// 3명의 학생	국어/영어/수학	=> 총점, 평균, 학점출력
import java.util.Scanner;
/*
 * 	int[] kore=new int[3];
 */
class Student	// 데이터형	=> 배열이 가능	=> Collection
{
	String name;
	int kor,eng,math;
	int total;
	double avg;
	char score;
	
	String school_name;		// 범위에 따라 다르다 (학원명: static, 출신학교명: instance)
}
// int[] arr=new int[3]; 0 0 0
public class 클래스_5 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] std=new Student[3];
		
		// 초기화
		Scanner scan=new Scanner(System.in);
		for (int i=1; i<=std.length; i++)
		{
			std[i]=new Student();	// 학생이 가지고 있는 데이터 저장을 위한 메모리 공간확보
			System.out.print((i+1)+"번째 국어 입력: ");
			std[i].kor=scan.nextInt();
			System.out.print((i+1)+"번째 영어 입력: ");
			std[i].eng=scan.nextInt();
			System.out.print((i+1)+"번째 수학 입력: ");
			std[i].math=scan.nextInt();
			
			std[i].total=std[i].kor+std[i].eng+std[i].math;
			std[i].avg=std[i].total / 3.0;
			switch (std[i].total/30)
			{
			case 10: case 9:
				std[i].score='A';
				break;
			case 8:
				std[i].score='B';
				break;
			case 7:
				std[i].score='C';
				break;
			case 6:
				std[i].score='D';
				break;
			default:
				std[i].score='F';
			}
			
			System.out.printf("%d번째 학생의 성적: 국어(%d), 영어(%d), 수학(%d) 총점(%d) 평균(%.2f) 학점(%c)",
							i+1,std[i].kor,std[i].eng,std[i].math,std[i].total,std[i].avg,std[i].score );
			System.out.println();
		}
	}

}
