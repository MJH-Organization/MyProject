import java.util.Scanner;
public class 제어문문제_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("정수 입력: ");
		int val1 = scan.nextInt();
		System.out.println("+,-,*,/ 입력: ");
		char operator = scan.next().charAt(0);
		System.out.println("정수 입력: ");
		int val2 = scan.nextInt();
		int result=0;
		
		System.out.println("operator: " + operator);
		
		switch (operator) {
		case '+': 
			result = val1 + val2;
			break;
		case '-': 
			result = val1 - val2;
			break;
		case '*': 
			result = val1 * val2;
			break;
		case '/': 
			result = val1 / val2;
			break;
		default : 
			System.out.println("잘못된 연산자!!!");
			System.exit(0);
		}
		System.out.println(val1 +" "+ operator +" "+ val2 +" = " + result);
		
		scan.close();
	}

}
