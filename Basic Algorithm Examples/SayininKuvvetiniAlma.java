/*Girilen sayýnýn istenilen kuvvetini while döngüsü ile alan C programý*/

import java.util.Scanner;
public class SayininKuvvetiniAlma {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int sayi,kuvvet;
		
		System.out.print("Sayiyi giriniz:");
		sayi = s.nextInt();
		
		System.out.print("Kuvveti giriniz:");
		kuvvet = s.nextInt();

		int sayac=0;
		int sonuc =1;
		while(sayac<kuvvet)
		{
			sonuc *=sayi;
			sayac++;
		}
		System.out.println(sayi+" ^ "+kuvvet+" = "+sonuc);

	}

}