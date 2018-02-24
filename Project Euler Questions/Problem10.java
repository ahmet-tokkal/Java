/*
 	The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
	Find the sum of all the primes below two million.
 */
public class Problem10 {

	public static void main(String[] args) {
		boolean flag=false;
		long toplam=0;
		int limit = 2000000;
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
				System.out.println(i);
				toplam += i;

			}
		}
		System.out.println("Toplam : "+toplam);
	}

}
