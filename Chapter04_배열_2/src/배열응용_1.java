
/**
 * 	3명의 학생
 * 		=> 국어/영어/수학 점수를 입력을 받아서
 * 		=> 총점 / 평균 / 학점 / 등수를 출력한다.
 */
import java.util.Scanner;
public class 배열응용_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] kor=new int[3];
		int[] eng=new int[3];	// 1번 / 2번 / 3번 => 인덱스 번호 일치
		int[] math=new int[3];
		
		int[] total=new int[3];
		double[] avg=new double[3];	// 0.0, 0.0, 0.0...
		char[] score=new char[3];	// '\0'
		int[] rank=new int[3];
		
		// 점수입력을 받아서 => 초기화 ===> avg
		Scanner scan = new Scanner(System.in);
		for (int i=0; i<kor.length; i++)
		{
			System.out.print((i+1)+"' 국어입력:");
			kor[i]=scan.nextInt();

			System.out.print((i+1)+"' 영어입력:");
			eng[i]=scan.nextInt();

			System.out.print((i+1)+"' 수학입력:");
			math[i]=scan.nextInt();
			
			total[i] = kor[i]+eng[i]+math[i];
			avg[i]= total[i]/3.0;
		}
		// 학점 계산
		for (int i=0; i<kor.length; i++)
		{
			switch ((int)(avg[i]/10))	// 정수, 문자, 문자열
			{
			case 10:	case 9:
				score[i]='A';
				break;
			case 8:
				score[i]='B';
				break;
			case 7:
				score[i]='C';
				break;
			case 6:
				score[i]='D';
				break;
			default:
				score[i]='F';
			}
		}
		// 등수 계산
		for (int i=0; i<kor.length; i++)
		{
			rank[i]=1;
			for (int j=0; j<kor.length; j++)
				if (total[i]<total[j])
					rank[i]++;
		}
		// 출력
		for (int i=0; i<kor.length; i++)
		{
			// 출력 서식을 만드는 메서드 => 원하는 스타일로 출력
			// -5d ==> 왼쪽 정력 => 공백을 출력 => 3자리
			// JDK 1.5 이상에서만 사용이 가능 =>
			// C언어와 동일하게 => exe 파일 => C언어에서 도입
			// 썬 => 순수하게 자바로만 라이브러리 추가
			// 오라클에서 자바인수 => C언어 => C언어로 변경이 되는 경향
			// 람다식 (함수 포인터), NIO ... => 호환성 이슈 발생
			System.out.printf("%-5d%-5d%-5d%-7d%-7.2f%-3c%-5d\n",
					kor[i],eng[i],math[i],total[i],avg[i],score[i],rank[i]);
		}
		scan.close();

	}

}
