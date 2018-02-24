/*İki sayıyı karşılaştıran java programı*/

import java.util.Scanner;
public class Karsilastirma {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		int sayi1,sayi2;
		System.out.print("1.Sayiyi giriniz :");
		sayi1=s.nextInt();
		System.out.print("2.Sayiyi giriniz :");
		sayi2=s.nextInt();
		
		if(sayi1>sayi2)
		{
			System.out.println("1.Sayi daha buyuktur.");
		}
		else if(sayi2>sayi1)
		{
			System.out.println("2.Sayi daha buyuktur.");
		}
		else {
			System.out.println("Sayilar esittir.");
		}
	}

}
