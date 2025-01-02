/*
 *      1. 자바에서 변수에 대한 설명 중 틀린 것은 무엇입니까?
         ① 변수는 하나의 값만 저장할 수 있다.
         ② 변수는 선언 시에 사용한 타입의 값만 저장할 수 있다.
         ③ 변수는 변수가 선언된 중괄호 {} 안에서만 사용 가능하다.
         ④ 지역변수는 초기값이 저장되지 않은 상태에서 읽을 수 있다
         
         변수 => 한개의 데이터만 저장할 수 메모리공간의 이름 
             = 선언된 데이터형에 맞게 저장 
               ====================
               double d=10
               int a='A'
             => {}
             변수의 위치
             public class A
             {
                변수 선언 
                int a; => 자동 초기화 0 => 멤버변수 
                public static void main(String[] arg)
                {
                   변수 선언 
                   int b; ==> 지역변수 : 무조건 초기화 후 사용 
                     => int a=10;
                     => int b=random()
                     => int c=scan.nextInt()
                
                }
             }
         
         
        2. 변수의 이름으로 사용 가능한 것을 모두 선택하세요.
           변수 문법 
            1) 알파벳 , 한글로 시작한다 
               알파벳은 대소문자 구분 
            2) 숫자사용이 가능 => 앞에 사용 금지 
            3) 특수 문자는 => _ , $ ==> 어떤 위치든 사용이 가능
            4) 공백이 있으면 안된다 
            5) 키워드(예약어) 사용 금지 
         
         1,4,5
         
         ① modelName => 정상 => 헝거리언식 표기법 
         ② class => 키워드 
         ③ 6hour => 숫자가 앞에오면 안된다 
         ④ $value=> $,_
         ⑤ _age
         ⑥ int => 키워드 
         
         => 1. 데이터형 
            2. 변수의 선언 방법 
               데이터형 변수명 
            3. 변수의 초기화 
            4. 변수를 만드는 문법사항 
            
        3. 다음 표의 빈칸에 자바의 기본타입(Primitive Type) 8개를 적어보세요
           =================================
                1byte   2byte  4byte  8byte
           =================================
           정수  **byte    short  **int   **long
                       정수는 default => int
                System.out.println(100000) 1000L
           =================================
           실수                 float  **double
                       실수는 default double
                       10.5 => 10.5F
           =================================
           문자          char
           =================================
           논리  **boolean
           =================================
        4. 다음 코드에서 타입, 변수 이름, 리터럴에 해당하는 것을 적어보세요.

			int age;
			
			age=10;
			
			double price=3.14;
			====== ===== ====
			데이터형  변수명  리터럴
			
			타입(데이터형) (  int  ),(  double      )
			변수명 (  age   ) ( price       )
			리터럴 (   10   ) (   3.14    )
         5. 변수를 잘못 초기화한 것은 무엇입니까?
         
            ① int var1 = 10;
            ② long var2 = 10000000000L;
            ③ char var3 = '';
              => '' : null 
                 ' ' ==> 한개의 문자 첨부 
            ④ double var4 = 10;
            ⑤ float var5 = 10;

            연산자 
             1. 단항연산자 
                증감연산자 (++,--) 1증가 , 1감소
                  => 반복문에서 주로 사용 
                  => 전치연산 : ++a => 바로 적용 
                     후치연산 : a++ => 다음 문장에서 적용 
                     
                 int a=10;
                 int b=a++; 
                     ===
                        ++ 
                     a=11 , b=10
                 int a=10
                 int b=++a;
                       ===
                     b=a; a=11 b=11
         6. 다음 코드를 실행했을 때 출력 결과는 무엇입니까?
            
			public class Exercise02{
			     public static void main(String[] args) {
			         int x = 10;
			         int y = 20;
			         int z = (++x) + (y--);
			                 =====   ===== 다음줄에서 적용
			                           y=20
			                 바로 적용 => x=11
			         System.out.println(z); ==> z=31
			     }
			 }
			 !=> 부정연산자 => true=>false , false => true 
	      7. 다음 코드를 실행했을 때 출력 결과는 무엇입니까?
			public class Exercise03 {
			     public static void main(String[] args) {
			         int score = 85;
			         String result = (!(score<90))? "가":"나";
			                          => 삼항연산자 
			                          
			                          (조건) ? 값1 : 값2 
			                            |      |     |
			                            -------      |
			                              true
			                            -------------
			                                 false
			                           ==========
			                            ! false
			                            => true
			         System.out.println(result); 가
			     }
			 }
			 
			 int a=10;
			 a%2!=0?"짝수":"홀수"
			 if()
			 {
			 }
			 else
			 {
			 }

          8. 534자루의 연필을 30명의 학생들에게 똑같은 개수로 나누어 줄 때 학생당 몇 개를 가질 수 있고, 최종적으로 몇 개가 남는지를 구하는 코드입니다. ( #1 ) ( #2 )에 들어갈 알맞은 코드를 작성하세요

			public class Exercise04{
			     puvlic static void main(String[] args) {
			         int pencils = 534;
			         int students = 30;
			 
			         //학생 한 명이 가지는 연필 수 
			         pencils/students
			         int pencilsPerStudent = ( #1 );
			         System.out.println(perncilsPerStudent);
			         pencils%students
			         //남은 연필 수
			         int pencilsLeft = ( #2 );
			         System.out.println(pencilsLeft);
			     }
			 }
		9. 다음은 십의 자리 이하를 버리는 코드입니다. 
		   변수 value의 값이 356이라면 300이 나올 수 있도록 ( #1 ) 에 알맞은 코드를 작성하세요 
		   (산술 연산자만 사용하세요.
			public class Exercise05{
			     public  static void main(String[] args) {
			         int value = 356;
			         System.out.println( #1 );
			         value-(value%100)
			               ---------
			         ------
			         
			         + , - < /,*,%
			         value-56
			         
			         7+"7"+7+5 ==> 7775
			         7+"7"+7*5 ==> 7735
			               ---
			               35
			         7+"7"+35 ==> 7735
			         
			          && > ||
			     }
			 }
	    10. 사용자로부터 세 개의 정수를 입력받은 다음에 곱과 합을 
	    순서대로 진행해서 그 결과를 출력하는 프로그램을 작성해 보 자. 
	    예를 들어 사용자로부터 순서대로 입력받은 세 개의 정수가 
	    1, 2, 3 이라면 1  * 2 + 3의 계산 결과를 출혁해야 한다. 
	    단 출력 양식은 다음과 같아야 한다.
	    
	    출력 양식 => 서식 => printf

        11. 두 개의 정수를 입력 받아서 첫째 수를 둘째 수로 나눈 
        나머지를 출력하는 프로그램을 작성해 보자.




 */
import java.util.Scanner;
public class 문제풀이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//        Scanner scan=new Scanner(System.in);
//        System.out.print("세개의 정수 입력(1 2 3):");
//        int a=scan.nextInt();
//        int b=scan.nextInt();
//        int c=scan.nextInt();
//        
//        System.out.printf("%d * %d + %d = %d",a,b,c,(a*b+c));
		Scanner scan=new Scanner(System.in);
		System.out.print("두개 정수 입력(10 20):");
		int a=scan.nextInt();
		int b=scan.nextInt();
		System.out.printf("%d %% %d = %d",a,b,a%b);
		// 
		
		scan.close();
	}

}
