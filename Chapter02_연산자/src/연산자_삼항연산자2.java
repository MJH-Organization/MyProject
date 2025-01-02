// 사용자로부터 값을 받아서 => 합격 => 60점이상 
import java.util.Scanner;
public class 연산자_삼항연산자2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in); // 클래스 저장 
        // 클래스 객체명  |저장할 메모리를 만들어 준다  생성자 
        System.out.print("0~100사이의 점수 입력:");
        int score=scan.nextInt();
        System.out.println(score>=60?"합격":"불합격");
		scan.close();
	}

}
