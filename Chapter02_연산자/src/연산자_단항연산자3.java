/*
 *   형변환연산자 
 *   =====  long => int , char => int , byte => int 
 *          int => double , double => int 
 *          
 *   숫자/문자(정수인식) => boolean은 제외 '
 *   
 *   데이터형의 크기 
 *          <====        ========> 
 *        DownCasting     Upcasting 
 *        :데이터형을 작게    : 데이터형을 크게
 *        => 강제          => 자동
 *   byte < short < int < long < float < double
 *          char
 *          
 *   byte b=10;
 *   int i=b;
 *        --- int로 변경
 *        
 *   int a=10;
 *   double d=a; ==> 10.0
 *   
 *     10 + 10.5 ==> 20.5 => 연산은 같은 데이터형만 처리가 가능 
 *     int  double
 *      |
 *     10.0 + 10.5 
 *     
 *   *** 가장 큰 데이터형으로 변경 
 *   *** int이하 데이터형(byte,char,short)은 연산 결과는 int
 *       byte + byte 
 *        100    50  => 150 => int
 *       char + char = int
 *       short + byte + char = int
 *       byte + int = int
 *       double + float = double 
 *       
 *   *** 필요시에는 강제로 변환 
 *               ========== 형변환 연산자 
 *               
 *       (int)10.5 + (int)20.5  
 *       =========   ==========
 *         10            20  ===> 30
 *         
 *       (int)(10.5+20.5) => 31 
 *            -----------
 *              31.0
 *              
 *       => 연산자 => () 최우선순위 연산자 
 *       => (3+5)*2 = 13
 *       
 *       
 *       (데이터형)변수
 *       
 *       => 10/3.0 => 3 (정수/정수=정수)
 */
public class 연산자_단항연산자3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*int a=10;
        double d=a;
        System.out.println(d);
        
        char c='A';
        int e=c;
        System.out.println(e);*/
		/*byte b1=100;
		byte b2=27;
		int b3=b1+b2;*/
		/*int a=10;
		int b=3;
		System.out.println(a/b);
		System.out.println(a/(double)b);*/
		int a=123456;
		float d=123456.78f;
		int res= (int)((d-a)*100);
		System.out.println(res);
	}

}
