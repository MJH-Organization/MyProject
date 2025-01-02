
/**
 * 	1차 for
 */
public class 반복제어문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i<=3; i++)
		{
			for (int j=1; j<=3; j++)
			{
				if (j==2)
					continue;	// while 에서 가끔 잘못된 입력이 있는 경우
				System.out.printf("i=%d, j=%d\n",i,j);
			}

		}

	}

}
