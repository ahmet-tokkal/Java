/*Girilen sayý kadar * dan oluþan içi bos dörtgen çizen C programý*/

import java.util.Scanner;
public class IciBosKare {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Sayiyi Giriniz :");
		int sayi = s.nextInt();
		
		for (int i = 0; i < sayi; i++) 
		{
			if(i==0 || i==sayi-1)
			{
				for (int j = 0; j < sayi; j++) {
					System.out.print("* ");
				}
				System.out.println();
			}
			else {
				System.out.print("* ");
				for (int j = 0; j < sayi-2; j++) {
					System.out.print("  ");
				}
				System.out.print("* ");
				System.out.println();
			}
		}

	}

}
