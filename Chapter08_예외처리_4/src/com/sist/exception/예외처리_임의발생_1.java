package com.sist.exception;
// 임의 발생은 한개만 사용 => if 문
import java.util.Scanner;
/*
 *      웹 => 무조건 전송받은 데이터형 String
 *      
 *      a.jsp?no=1
 *      IllegalArgumentException 발생
 *      
 *      public void display(String no) => String no
 *      {
 *          => 정수형 변환 Integer.parseInt(no)
 *                      -------- 데이터형 클래스 => Wrapper
 *      }
 * 
 */
public class 예외처리_임의발생_1 {
    public static void main(String[] args) {
        try
        {
            Scanner scan = new Scanner(System.in);
            System.out.print("국어 점수 입력: ");
            int kor = scan.nextInt();
            if (kor<0 || kor>100)
            {
                // 잘못된 입력 => 직접 처리
                // catch를 불러올 수 있다
                // throw => 예외발생을 알려준다
                // 테스트 (배포)
                throw new IllegalArgumentException("점수는 0이상 100이하만 가능합니다");
                // throw => 필요시에 의해 catch를 호출할 수 있다
                // 아래는 코딩이 불가능하다
            }
        }catch(IllegalArgumentException e)
        {
            // 매개변수에 전송값이 다른 경우
            System.out.println(e.getMessage());
        }
        
    }
}
