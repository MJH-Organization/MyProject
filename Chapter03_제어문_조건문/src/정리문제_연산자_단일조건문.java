/*
 *   산술연산자
 *   ======== 형변환 
 *            => 연산 규칙 : 같은 데이터형만 연산처리가 가능 
 *            => 큰 데이터형으로 변경해서 연산 
 *               int + int = int
 *               long + int 
 *                      ===
 *                      long => 자동 (자동형변환)
 *               => long+long=long
 *            => int이하 데이터형 (byte,short,char) 
 *               => 계산 결과가 int 
 *                  byte+byte = int 
 *                  char+char = int 
 *            => 작은 데이터형 ==> 큰데이터형 
 *               ----------------------- 자동 
 *               큰데이터형 ===> 작은데이터형 변경 
 *               ----------------------- 강제 (int)
 *               (int)(Math.random()*100) 0~0
 *                     =============
 *                     0.0 ~ 0.99
 *                    () => 최우선 연산자 
 *            데이터형 크기 
 *            byte < char < int < long < float < double
 *                   short
 *            => 51페이지
 *            묵시적 => 자동 형변환
 *             변수의 값을 대입 
 *             long a=10;  10(int) => long
 *             double b=20; 20(int) => double => 10.0 
 *             int a=(int)10.0;
 *            명시적 => 강제 형변환 (int) (double)
 *     + : 더하기 , 문자열 결합 
 *                 10+"10" => 1010
 *                 "10"+10 => 1010
 *                 System.out.println("a="+a)
 *         실제 산술연산 10+10=20 
 *     / : 0의 나눌 수 없다 => 조건 
 *         정수/정수=정수 
 *         ----------- 소수점 : 정수/실수 
 *     % : 배수 , => 부호는 항상 왼쪽 부호를 따라간다
 *               - % -  -
 *               - % +  -
 *               + % -  +  ==> 5%-2=1
 *               + % +  + => 생략
 *   1. 다음 결과값을 작성하시오

		public static void main(String[] arg) 
		{  
		    int a, b;  
		    a = 6;  
		    b = 2;   
		    System.out.printf("덧셈 연산 결과: %d \n", a+b);   6+2 = 8
		    System.out.printf("뺄셈 연산 결과: %d \n", a-b);   6-2 = 4
		    System.out.printf("곱셈 연산 결과: %d \n", a*b);   6*2 = 12
		    System.out.printf("나누기 연산 결과: %d \n", a/b);  6/2 = 3
		    System.out.printf("나머지 연산 결과: %d \n", a%b);  6%2 = 0
		    
		    => 산술연산자 
		}
	 2. 다음 결과값을 작성하시오

		public static void main(String[] arg) 
		{  
		      int num1, num2;   
		      num1 = 10/3; => 3 => 정수/정수=정수
		       // '몫' 출력   
		      num2 = 10%3; => 1
		       // '나머지' 출력
		   System.out.printf("      몫: %d \n", num1);   
		   System.out.printf("나머지: %d \n", num2); 
		}
	 3. 다음 결과값을 작성하시오
        복합 대입연산자 
        +=
        -=
        *=
        /=
        %=
		public static void main(String[] arg) 
		{
		     int num1=1, num2=2, num3=3, num4=4, num5=5;     
		     num1 = num1 +    num2; => 3
		     ***=> num1+=num2 => 3 => 누적합
		     num2 = num2 - 2;   => 0 
		     => ***num2-=2 => 0  => 누적차
		     num3 = num3 * 2;  
		     num3*=2 ==> 6  
		     num4 = num4 / 2;  => 2
		     num4/=2   => 2
		     num5 = num5 % 2;  = 1
		     num5%=2   = 1 
		     System.out.printf( "%d, %d, %d, %d, %d   \n",num1,num2,num3,num4,num5);   
		}
	 4. 다음 결과값을 작성하시오
        증감연산자 (단항연산자)
          ++ , -- => 1씩 증가 , 1씩 감소 
          전치연산자 => 먼저 증가 => 다른 연산 수행
            ++a
          후치연산자 => 다른 연산 수행 => 나중에 증가 
            a++ ==> 정수,문자에서만 사용이 가능  
            
          int a=10;
          int b = ++a
               -----  증가후에 대입
              a=a+1
              b=a
          int a=10;
          int b = a++
              ---- --
              대입후에 증가 
              b=a
              a=a+1
		public static void main(String[] arg) 
		{
		      int num1=10;   
		      System.out.printf("%d \n", num1); 10
		      num1++; => 1+
		      System.out.printf("%d \n", num1); 11
		      ++num1; => 1+
		      System.out.printf("%d \n", num1); 12
		      --num1; => 1-
		      System.out.printf("%d \n", num1); 11
		      num1--; => 1- 
		      System.out.printf("%d \n", num1); 10
		}
     5. 다음 결과값을 작성하시오

		public static void main(String[] arg) 
		{
		       int num1=10, num2=10;   
		       int a, b;   
		       a = ++num1;  ==> a=11 num1=11
		       b = num2++;  ==> b=10 num2=11
		
		       System.out.printf("%d, %d \n", b, num2);
		}
     6. 다음 결과값을 작성하시오

		public static void main(String[] arg) 
		{
		        int num1=10, num2=10;   
		        int a, b;   
		        num1 = num1 + 1;  => num1+=1
		        => int a=++num1
		        a = num1; 
		             11  ==> a=11
		        System.out.printf("%d, %d \n", a, num1);
		        b = num2; ==> 10 int b=num2++
		        num2 = num2 + 1; num2=11
		        System.out.printf("%d, %d \n", b, num2);
		}
	7. 다음 결과값을 작성하시오

		public static void main(String[] arg) 
		{
		    int num1=10, num2=10;
		    System.out.printf("%d \n", ++num1); => 11
		    // 출력 | 증가  => 증가후에 출력 
		    System.out.printf("%d \n", num1); // 11
		    System.out.printf("%d \n", num2++); // 10
		         출력후에 증가 
		    System.out.printf("%d \n", num2); //11
		}
    8. 다음 괄호안에 맞는 연산자를 작성하시오
        비교연산자 (문자,숫자(정수/실수) , 논리(==,!=))
        => 
           == 같다 
           != 같지않다 
           < 작다 
           > 크다 
           <= 작거나 같다
           >= 크거나 같다 
           ===============> 조건문 / 반복문 => 제어문에서 주로 사용
		public class Main {
		       public static void main(String[] args) {
		             
		             int a = 5;
		             int b = 5;
		             
		             System.out.println("a와 b가 같은가요?" + ( a==b   ));
		             System.out.println("a가 b보다 큰가요?" + (  a>b  ));
		             System.out.println("a가 b보다 작은 가요 ?" + (  a<b  ));
		             System.out.println("a가 b와 같은면서 3보다 큰가요?" +   
		                    (  a==b && a>3       ));
		             System.out.println("a가 50이 아닌가요? " + 
		               ( a!=50        ));
		             
		       }
		}
		
		&& => 로그인 : 아이디 && 비밀번호 (포함) 
		  조건 두개가 동시에 true일때만 => true 
		  BETWEEN 1 AND 10
		|| => 비포함 => 오류 처리
		  IN(값....)
		  
		=> 자바 변수에 저장 => 프로그램 종료시 사라진다 
		   파일 / 오라클 => 영구적인 저장 장치 
		  조건 둘중에 한개 이상 true => true 
    9. Scanner 클래스를 이용하여 한 개의 정수를 입력 받아 
       양수인지 음수인지 판별하여 출력하라
    10. 한 개의 정수를 입력 받아 3의 배수인지 판별하여 출력하라
    11. Scanner 클래스를 이용하여 2자리의 정수(10~99사이)를 입력받고,십의 자리와 1의 자리가 같은 지 판별하여 출력하는 프로그램을 작성하라.
 
		결과)
		2자리수정수입력(10~99) >> 77 
		10의자리와 1의자리가같습니다.
		
		
		12. 숫자를 입력받아 3~5는 봄, 6~8은 여름, 9~11은 가을, 12,1,2는 겨울, 그 외의 숫자를 입력한 경우 잘못입력을 출력하는 프로그램을 작성하라. 
		 
		결과)달을입력하세요(1~12) >> 9
		가을

 */
import java.util.Scanner;
public class 정리문제_연산자_단일조건문 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("달 입력(1~12):");// 음수/양수
        int month=scan.nextInt();
        // int => -21억 4천 ~ 21억 4천
//        if(num<0)
//        {
//        	System.out.println(num+"는(은) 음수입니다");
//        }
//        if(num>=0)
//        {
//        	System.out.println(num+"는(은) 양수입니다");
//        }
        
//          if(num%3==0)
//        	  System.out.println(num+"는(은) 3의 배수입니다");
//          if(num%3!=0)
//        	  System.out.println(num+"는(은) 3의 배수아닙니다");
        /*
         *    int a=num/10;
         *    int b=num%10;
         *    if(a==b)
         *    
         *    *** 요구한 결과값을 출력 
         *    => 가독성 
         *    => 최적화 
         */
//        if(num%11==0)
//        	System.out.println("10의자리와 1의자리가 같습니다.");
//        if(num%11!=0)
//        	System.out.println("10의자리와 1의자리가 다릅니다.");
          
          if(month>=3 && month<=5)
        	  System.out.println("봄입니다");
          if(month>=6 && month<=8)
        	  System.out.println("여름입니다");
          if(month>=9 && month<=11)
        	  System.out.println("가을입니다");
          if(month==1||month==2||month==12)
        	  System.out.println("겨울입니다");
        
	}

}
