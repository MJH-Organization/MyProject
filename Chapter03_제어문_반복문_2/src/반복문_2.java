
public class 반복문_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=1; i<=9; i++)
		{
			for (int j=2; j<=9; j++)
			{
//				System.out.print(j+"*"+i+"="+(j*i)+"	");
				System.out.printf("%d*%d=%2d\t", j, i, (j*i));
			}
			System.out.println();
		}

	}

}
