/*
  		The prime factors of 13195 are 5, 7, 13 and 29.
		What is the largest prime factor of the number 600851475143 ?
*/

public class Problem3 {

	public static void main(String[] args) {
		boolean flag=false;
		long temp=0;
		long limit = 600851475143L ;
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
				if(limit % i == 0 && i > temp)
				{
					System.out.print(i+",");
					temp = i;
				}
			}
		}
		System.out.println();
		System.out.println("-> "+temp);
	}

}
