/*
 	A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
	Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem4 {

	public static void main(String[] args) {
		int maxPol = 0;
		for(int i=100; i<1000; i++)
		{
			for(int j=100; j<1000; j++)
			{
				if(isPolindrome(i*j) && (i*j)>maxPol)
				{
					maxPol = i*j;
				}
			}
		}
		System.out.println("Largest Polindrome = "+maxPol);
	}
	public static boolean isPolindrome(int n) {
		int temp = n;
		int polindrome = 0;
		while(temp>=10)
		{
			polindrome += temp % 10;
			polindrome *= 10;
			temp = temp / 10;
		}
		polindrome += temp;
		if(polindrome == n)
		{
			return true;
		}
		else{
			return false;
		}
	}

}
