/*
 *   윤년 (********)  달력 / 일정표 
 *   ----
 *    윤년 조건 
 *    1. 4년마다 
 *    2. 100년마다 제외 
 *    3. 400년마다 
 *    ------------- 로마시대  ABC ==> DEF 
 *    
 *    year%4==0  year%100!=0  year%400==0
 *    
 *    윤년 처리 공식 
 *    (year%4==0 && year%100!=0)||(year%400==0)
 */
// 년도 입력을 받아서 윤년여부 확인 
import java.util.Scanner;
public class 자바제어문_단일조건문4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("년도 입력:");
        int year=scan.nextInt();
        
        // 결과 출력 
        if((year%4==0 && year%100!=0)||(year%400==0))
        {
        	System.out.println(year+"는(은) 윤년입니다!!");
        }
        //else
        if(!((year%4==0 && year%100!=0)||(year%400==0)))
        {
        	System.out.println(year+"는(은) 윤년아닙니다!!");
        }
        
	}

}
