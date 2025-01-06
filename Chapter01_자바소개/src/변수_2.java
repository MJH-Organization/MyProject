// 초기값 => 데이터를 저장하는 방법 
/*
 *   자바에서 사용하는 표현법 
 *   
 *   1. 정수 
 *      byte/short/int => 숫자 사용 (범위만 초과하지 않는다)
 *      숫자표현 
 *        10  ==> 10진법
 *        *** 012 ==> 8진법 
 *        날짜 
 *          => 2024-09-20 (시간) 
 *                  === 8진법 => error
 *        0x12 ==> 16진법 
 *      long표현 
 *        10L , 10l
 *        ---------
 *    실수형 
 *      10.5 => double 
 *      10.5F 10.5f 
 *      
 *    문자형 
 *      한글자만 저장이 가능 
 *      'A'  ""=>문자열 => 여러개문자 사용이 가능 "ABCD...."
 *      
 *    논리형 
 *      true/false 
 *      
 *    데이터 저장 방법 
 *    1) 명시적 초기화 
 *       int a=10;
 *    2) 입력을 받아서 초기화 
 *    3) 난수발생 
 *    
 *    변수 선언
 *    선언과 동시에 값을 저장 
 *    데이터형 변수명=값 (사용빈도가 많다)
 *    
 *    선언 
 *    데이터형 변수명;
 *    값을 저장 
 *    변수명=값 
 *    
 *    *** 변수 선언만 하고 사용하면 => error발생 
 *    
 */
public class 변수_2 {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 정수 
		byte byteVal=127; // -128~127
		/*
		 *    =======
		 *      127 ==> byteVal
		 *    ======= 1byte
		 */
		short shortVal=32767; // -32768~32767
		/*
		 *     ========
		 *     
		 *       32767   ==> 별칭 => shortVal
		 *     ======== 2byte
		 */
		//shortVal=30000;
		//System.out.println(32767);
		
		int intVal=21400000;
		/*
		 *   int
		 *   4byte 메모리 공간을 만들어라 명령
		 *   => 21400000을 저장해라...
		 *   => 이 메모리를 사용한다면 intVal를 이용한다 
		 *   => 수정이 가능  ...
		 */
		
		long longVal=30000000000L;//long표현 
		/* 
		 *   8byte 메모리 공간을 만들어라 
		 *   =>30000000000 명령
		 *   => 사용시에는  longVal
		 *   
		 *   => 변수 
		 *      1) 저장 
		 *      2) 값읽기 
		 *      3) 수정 
		 *  
		 */
		// 수정 
		longVal=100L;
		// 값읽기
		System.out.println(longVal);
		// 큰데이터형에는 작은 값을 저장이 가능 
		long a=100;// 100L
		System.out.println(a);
		
		int b='A';
		System.out.println(b);
		
		char c=65;
		// 'A'=65 , 'a'=97 , '0'=48
		//System.out.println((int)'홍');
		
		boolean boo=false;
		System.out.println(boo);// 조건문 ==> 제어문 
		
		float f=10.5f;
		System.out.println(f);
		double d=10.5D;
		// 왼쪽에 있는 데이터형이 크거나 같아서 저장이 가능 
		/*
		 *    데이터는 선언된 데이터형을 따라 간다 
		 *    
		 *    byte = byte
		 *    short = short,byte
		 *    int = byte,short,char,int 
		 *    
		 *    long = byte,short,char,int ,long
		 *    float = byte,short,char,int ,long,float
		 *    double = byte,short,char,int ,long,float, double
		 *    
		 *    자동 형변환 
		 *    
		 *    (int)10.5  => 10
		 *    (double)10 => 10.0
		 *    (int)'A' => 65
		 *    (char)65 => 'A'
		 *    (double)'A' => 65.o
		 *    (float)'A' => 65.0F
		 */
		// 10/(double)3 = 3.333333
		System.out.println(10/3);
		System.out.println(10/(double)3);
		
		// int / long / double / char / boolean 
	}

}
