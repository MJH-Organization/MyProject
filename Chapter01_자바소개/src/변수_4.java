/* 
 *   문자열 결합 
 *   =========
 *   문자열 => ""
 *   3+""+4 ==> 34
 *   
 *   3+"7"+7  => "777"
 *   =====
 *     "37"+7
 *     ======= "377"
 *   7+7+"3"+7+7
 *   ---
 *    14+"3"
 *    ======
 *    "143"+7
 *    ========
 *      "1437"+7
 *      "14377"
 *    
 *    논리형 : boolean (30page)
 *           => 반드시 : true/false만 사용이 가능 
 *                     =========== 소문자만 가능 
 *                     TRUE / True(python)
 *           => 비교연산자 
 *              boolean b=6<7 => true
 *              if(boolean) 
 *           => 로그인 / 아이디중복체크 / 검색어 / 장바구니 / 댓글 
 *    byte => 네트워크 전송 => 바이트 , 파일 전송 
 *    short => C언어 호환 => 사용 빈도가 없다 
 *    일반 정수 : int 
 *    일반 실수 : double 
 *    문자 : 값 설정 '문자한개'
 *          => '홍' => 한글은 1글자당 2byte
 *    실수 =>  double => 데이터형중에 가장 큰 데이터형 
 *            => boolean은 숫자가 아니다 
 *    
 *    // final => 상수
 *    
 *    값 교환 
 *    
 *    int a=10;
 *    int b=20;
 *    
 *    a=b; a=20
 *    b=a; b=20
 *    
 *    a=?
 *    b=?
 *    
 *    int a=10;
 *    int b=20;
 *    
 *    int temp=a;
 *    a=b
 *    b=temp
 *    
 */
public class 변수_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int a=10;
        a=20;
        
	}

}
