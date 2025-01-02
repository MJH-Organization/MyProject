import java.util.Scanner;
public class 제어문문제_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("정수입력 :");
		int score = scan.nextInt();
		int divScore = score / 10;
		char grade = ' ';
		
		switch (divScore) {
		case (10) :
		case (9):	grade = 'A';
					break;
		case (8):	grade = 'B';
					break;
		case (7):	grade = 'C';
					break;
		case (6):	grade = 'D';
		break;
		default:	grade = 'F';
					break;
		
		}
		
		System.out.println(grade+"학점입니다");

		scan.close();
	}

}
