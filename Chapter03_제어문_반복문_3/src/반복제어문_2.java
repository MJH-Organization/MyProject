
/**
 * 	
 */
public class 반복제어문_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for (int i = 1; i<=3; i++)
//		{
//			for (int j=1; j<=3;j++)
//			{
//				if (j==2)
//					break; //2차 for 제어
//				System.out.printf("i=%d, j=%d\n", i, j);
//			}
//			break; 	// 1차 for 제어
//		}
		
		// 이름이 있는 break => 많이 사용하지 않는다
		outer:for (int i=1; i<=3; i++)
		{
			for (int j=1; j<=3; j++)
			{
				if (j==2)
					break outer;
				System.out.printf("i=%d, j=%d\n",i,j);
			}
		}

	}

}
