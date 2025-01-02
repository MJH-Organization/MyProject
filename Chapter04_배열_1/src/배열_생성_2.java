
/**
 *	가급적 +> 같은 기능의 변수가 3개 이상이면 => 배열
 *			다른 기능의 변수가 3개 이상이면 => 클래스
 *	int kor1, kor2, kor3; int[3] kor
 *	int eng1, eng2, eng3;
 *	
 *	==========================================
 *	1. 배열 생성
 *		배열 : 연속적인 메모리 구조를 가지고 있다
 *				---------- 번호
 *		인덱스 : => 항상 0번부터 순차적으로 
 *					---------------
 *					for (int i=0; i<8; i++)
 *		배열 선언
 *			데이터형[] 배열명; => 권장
 *			데이터형	배열명[]; => C/C++ 호환
 *		배열 초기화 ==> 데이터 메모리에 저장 : 저장하는 값
 *									   --------- 초기화
 *			1) 정수형
 *				int[] arr={1,2,3,4,5}
 *							============== 5개의 메모리 공간을 연속적으로 배치
 *				int[] arr=new int[5]; => 정수를 저장할 수 있는 공간을 5개를 모아 달라
 *						============== 자동 초기화
 *						int ==>		0
 *						long ==>	0
 *						char ==>	''
 *						float ==>	0.0
 *						boolean ==> false(0)	
 *						String ==>	""
 *
 *						[I@6f2b958e => 베열
 *
 *				int[] arr
 *				-----------
 *				주소를 참조해서 데이터를 관리 => 참조변수
 *				stack 공간에 저장		실제 데이터 저장 공간 (Heap)
 *				     arr			[I@6f2b958e => 배열명은 실제 저장되어 있는 주소를 참조 => 참조변수
 *				------------		------------------------------------------
 *				[I@6f2b958e				0	|	0	|	0	|	0	|	0	|
 *				------------		-----------------------------------------
 *									arr[0]	arr[1]	arr[2]	arr[3]	arr[4]
 *									=> 인덱스번호
 *									arr+0*4	arr+1*4 arr+2*4 arr+3*4 arr+4*4
 *									100		104		108		112
 *									long => *8
 *									double => *8
 *									char => *2
 *				int a=10 ==> arr[0](변수)
 *				arr[0]=10;
 *				arr[1]=100;
 *					
 *				=> 연속적으로 메모리 구조
 *					--------------
 *					인텍스 번호를 이용해서 접근
 *				1. 배치 => 인덱스 번호 부여 (0=> 요청한 갯수)
 *				2. 인덱스 번호를 이용해서 데이터 값 수정 / 읽기 / 첨부
 *				3. 0부터 순차적이기 때문에 ===> 반복문으로 처리가 가능
 *
 *				=> 종류 => 배열에 저장되는 데이터의 종류 (점수: int, 이름: String, 평균: double, 학점: char, 통계: long, 예약여부: boolean)
 *				1. 정수 : int[]
 *				2. char : char[]
 *				3. 실수 : double[]
 *				4. 논리 : boolean[]
 *				5. 문자열 : String[]
 *				=> 생성 => 86 page
 *				  new 데이터형[배열크기]
 *							=======> 고정적 메모리
 *				=> 배열의 갯수 확인 => 배열명.length
 */									
 
import java.util.Scanner;
public class 배열_생성_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[5];
		System.out.println(arr);	// 배열명은 실제 저장되어 있는 주소를 참조 => 참조변수
		
		for (int i=0; i<arr.length; i++)
		{
			arr[i]= (int)(Math.random()*100+1);
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
		}
		
		// for each 구문
		// Web Front 의 핵심
		//  => 배열의 값을 변경이 불가능, 추가 불가능
		int[] arr2 = {1,2,3,4,5};	
		int a=0;
		for (int value : arr2)		// 동일하거나 큰 데이터형(long, double)을 사용 
		{
			System.out.println("arr2["+a+"]="+value);
			a++;
		}
		for (double value : arr2)		// 동일하거나 큰 데이터형(long, double)을 사용 
		{
			System.out.println("arr2["+a+"]="+value);
			a++;
		}
		
		int[] kor = new int[3];
		int[] eng = new int[3];
		int[] math = new int[3];
		int[] total = new int[3];
		double[] avg = new double[3];
		int len = total.length;

		Scanner scan =  new Scanner(System.in);
		for (int i=1; i<len; i++)
		{
			System.out.print(i+"번째 국어 점수를 입력하세요: ");
			kor[i] = scan.nextInt();
			System.out.print(i+"번째 영어 점수를 입력하세요: ");
			eng[i] = scan.nextInt();
			System.out.print(i+"번째 수학 점수를 입력하세요: ");
			math[i] = scan.nextInt();
			
			total[i] = kor[i]+eng[i]+math[i];
			avg[i] = total[i] / 3.0;
			System.out.printf("국어: %2d, 영어: %2d, 수학: %2d, 총점: %3d, 평균: %.2f\n", kor[i], eng[i], math[i], total[i], avg[i]);
		}
		
		scan.close();
	}

}

