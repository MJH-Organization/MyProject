
/**
 *		어떤 데이터를 모아서 관리
 *		--------
 *		데이터형
 *		몇개 저장
 *		[10]
 *		==
 *		데이터형[] 관리변수(배열명) = new 데이터형[10]
 *
 *		정수: int[], long[]
 *		실수:	
 *		논리:
 *		문자열:
 *		문자:
 */									
 
public class 배열_생성_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 가위 바위 보
		int com=(int)(Math.random()*3);
		System.out.println("컴류터: ");
//		if (com==0)
//			System.out.println("가위");
//		else if (com==1)
//			System.out.println("바위");
//		else if (com==2)
//			System.out.println("보");
		String[] arr = {"가위", "바위", "보"};
		System.out.println(arr[com]);
	}

}

