/*Girilen ikilim sistemdeki sayýyý onluk sisteme çeviren c programý*/

import java.util.Scanner;
public class BinaryToDecimal {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Binary Sayiyi Giriniz :");
		int sayi = s.nextInt();
		int temp,sonuc=0,i=0;
		
		while(sayi > 0)
		{
			temp = sayi % 10;
			if(temp > 1)
			{
				System.out.print("Girilen sayi binary deðildir");
				System.exit(0);
			}
			sayi /= 10;
			temp *=  Math.pow(2,i);
			i++;
			sonuc += temp;
		}
		System.out.print("Sayýnýn decimal hali : "+sonuc);
	}

}
