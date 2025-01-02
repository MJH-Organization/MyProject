// => 정수 2개 => 사용자 요청 => 계산 
//               + , - , * , / 
// 간단한 계산기 (사칙연산 사용)
import java.util.Scanner;

import javax.swing.JOptionPane;
public class 자바제어문_단일조건문2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("첫번째 정수 입력:");
        int num1=scan.nextInt();
        System.out.print("두번째 정수 입력:");
        int num2=scan.nextInt();
        // String op=scan.next()
        // char opp=op.charAt(0)
        System.out.print("연산자 입력(+(43),-(45),*(42),/(47)):");
		char op=(char)scan.nextInt();
		//System.out.println(num1);
		//System.out.println(num2);
		//System.out.println(op);
		if(op=='+')
		{
			System.out.printf("%d + %d = %d\n",num1,num2,num1+num2);
		}
		if(op=='-')
		{
			/*JOptionPane.showMessageDialog(null, 
					num1+"-"+num2+"="+(num1-num2));*/
			System.out.printf("%d - %d = %d\n",num1,num2,num1-num2);
		}
		if(op=='*')
		{
			/*JOptionPane.showMessageDialog(null, 
					num1+"-"+num2+"="+(num1-num2));*/
			System.out.printf("%d * %d = %d\n",num1,num2,num1*num2);
		}
		if(op=='/')
		{
			/*JOptionPane.showMessageDialog(null, 
					num1+"-"+num2+"="+(num1-num2));*/
			// 중첩 조건문 => 이중 if 
			if(num2==0)
				System.out.println("0으로 나눌 수 없다");
			if(num2!=0)
			    System.out.printf("%d / %d = %d\n",
			    		num1,num2,num1/num2);
		}
        
	}

}
