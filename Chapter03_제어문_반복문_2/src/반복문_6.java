/**
 * 
 */
public class 반복문_6 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a=(int)(Math.random()*100)+1;
//		int b=(int)(Math.random()*100)+1;
//		int c=(int)(Math.random()*100)+1;
//		int d=(int)(Math.random()*100)+1;
//		int e=(int)(Math.random()*100)+1;
//	
//		int max=a;
//		int min=a;
//		
//		if(max<a)
//			max=a;
//		if(max<b)
//			max=b;
//		if(max<c)
//			max=c;
//		if(max<d)
//			max=d;
//		if(max<e)
//			max=e;
//			
//		if(min>a)
//			min=a;
//		if(min>b)
//			min=b;
//		if(min>c)
//			min=c;
//		if(min>d)
//			min=d;
//		if(min>e)
//			min=e;
//		
//		System.out.printf("%d,%d,%d,%d,%d\n",a,b,c,d,e);
//		System.out.println("최대값:" +max);
//		System.out.println("최소값:" +min);
		
		int i=1;
		int max=1;
		int min=100;
		while (i<=5) 
		{
			int a=(int)(Math.random()*100)+1;
			System.out.print(a+" ");
			
			if(max<a)
				max=a;
			if(min>a)
				min=a;
			i++;
		}
		System.out.println();
		System.out.println("최대값:" +max);
		System.out.println("최소값:" +min);

	}

}
