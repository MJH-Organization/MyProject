// => 점수 입력 => 학점 A~D F
/*
 *   A  => score>=90 && score<=100
 *         score>=80 && score<90
 *                70          80
 *                60          70
 *         score<60 F
 */
import java.util.Scanner;
public class 연산자_삼항연산자3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        //System.in :키보드로부터 입력값을 받는다 
        System.out.print("점수입력(0~100):");
        int score=scan.nextInt();// 정수값
        // || => 범위에 없는 경우 => 다시 입력을 요구 
        // && => 범위안에 포함 => 정상 수행 
        /*
         *    알파벳 => 대문자 조건 
         *       c>='A' && c<='Z' => A~Z사이에 존재
         *            소문자 조건 
         *       c>='a' && c<='z' => a~z사이에 존재 
         *    => 알파벳 
         *    c>='A' && c<='Z' || c>='a' && c<='z'
         */
        System.out.println(score<0 || score>100?"비정상입력":"정상입력");
        // nextDouble():실수 , nextBoolean():true/false , next():문자열
        System.out.println("===== 결과값 =====");
        System.out.print(score>=90 && score<=100?"A학점":"");
        System.out.print(score>=80 && score<90?"B학점":"");
        System.out.print(score>=70 && score<80?"C학점":"");
        System.out.print(score>=60 && score<70?"D학점":"");
        System.out.print(score>=0 && score<60?"F학점":"");
		scan.close();
	}

}
