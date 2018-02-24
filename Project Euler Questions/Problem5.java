/*
 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
*/

public class Problem5 {
	public static void main(String[] args) {
		boolean flag = true;
		for (int i = 10;i<Integer.MAX_VALUE; i++) {
			for (int j = 1; j <= 20; j++) {
				if(i % j != 0) {
					flag = false;
					break;
				}
				else {
					flag = true;
				}
			}
			if(flag)
			{
				System.out.println("Sayý : "+i);
				break;
			}
		}
		System.out.print("Bitti");
	}

}
