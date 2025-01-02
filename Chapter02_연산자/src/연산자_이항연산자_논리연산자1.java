/*
 *      &&  ||
 *      
 *      (조건) && (조건)  ==> 범위,기간안에 있는 경우 
 *      -----    -----      a>=1 && a<=100 ====> 직렬연산자
 *        |        |
 *        ----------
 *            |
 *          결과값 => true/false 
 *          
 *      (조건) || (조건)  ==> 범위밖에 있는 경우 =====> 병렬연산자
 *      -----    -----      a<1 || a>100
 *        |        |
 *        ----------
 *            |
 *          결과값 => true/false 
 *          
 *     조건   &&   조건
 *     ---------------------
 *     true      true ========= true
 *     ---------------------
 *     true      false   false
 *     ---------------------
 *     false     true    false
 *     ---------------------
 *     false     false   false
 *     ---------------------
 *     
 *     조건   ||   조건
 *     ---------------------
 *     true      true ========= true
 *     ---------------------
 *     true      false   true
 *     ---------------------
 *     false     true    true
 *     ---------------------
 *     false     false   false
 *     ---------------------
 *     
 *     int x=10;
 *     int y=9;
 *     
 *     && => 앞에 조건 ==> false
 *     
 *     x<y && x==++y  == false
 *            ====== 연산(X) => 효율적인 연산 
 *     x=? => 10
 *     y=? => 9
 *     
 *     || => 앞에 조건 ==> true
 *     x<y || x==++y  == true
 *            ====== 연산(O) 
 *     x=? => 10
 *     y=? => 10
 *     
 *     => 연산자 : 산술연산자 
 *        38page 
 *        41page => 증가연산자 ++
 *        43page => 감소연산자 --
 *        44page => 비교연산자 == , != , < , > , <= , >=
 *        45page => 논리연산자 &&
 *        47page => ||
 *     
 */
public class 연산자_이항연산자_논리연산자1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int x=10;
        int y=9;
        
        /*boolean bCheck= x>y && x==++y;
        // true ==> true확인 
        // false ==> 
         * 
         */
        boolean bCheck = x<y || x==++y;
        
        System.out.println(bCheck);
        System.out.println(x);
        System.out.println(y);
        
        // && => 예약일 , 체크인 
        // || => 유효성 검사 
        /*
         *   국어 , 영어 수학 입력 => 총점 , 평균 
         *   => int kor=입력
         *      int eng=입력
         *      int math=입력
         *      
         *      int total=kor+eng+math
         *      double avg=total/3.0
         *      
         *   문자열 입력 
         *   => ABKBA  5/2  2
         *  
         */
        

	}

}
