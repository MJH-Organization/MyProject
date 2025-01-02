import java.util.Arrays;

/**
 *	6개의 난수 발생 => 중복이 없는 데이터 출력 (1~45사이의 난수)
 */
public class 배열_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 선언
		int[] lotto = new int[6];
		// 임의의 수를 초기화
		// 인덱스 번호
		for (int i=0; i<lotto.length; i++)
		{
			lotto[i]=(int)(Math.random()*45)+1;
			for (int j=1; j<=i; j++) {
				if (lotto[i]==lotto[j-1])
				{
					i--;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(lotto));
	}
}
