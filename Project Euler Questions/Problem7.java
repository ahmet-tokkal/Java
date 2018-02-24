
public class Problem7 {
	public static void main(String[] args) {
		boolean flag=false;
		long temp=0;
		long limit = Long.MAX_VALUE ;
		int sayac = 0;
		for (long i = 2; i <limit ; i++) 
		{
			flag = false;
			for (long j = 2; j < i; j++) {
				if(i % j == 0 && flag==false)
				{
					flag = true;
					break;
				}
			}
			if(flag == false)
			{
					sayac++;
			}
			if(sayac == 10001) {
				System.out.println(i);
				break;
			}
		}
		
	}

}
