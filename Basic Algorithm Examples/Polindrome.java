/*Kullan�c�n�n girdi�i say�n�n polindrome(tersi ayn�) olup olmad���n� bulan c program�*/
import java.util.Scanner;
public class Polindrome {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Sayiyi Giriniz :");
		int sayi = s.nextInt();
		int cSayi = sayi;
		int temp,polindrome=0;
		
		while(cSayi > 10)
		{
			temp = cSayi % 10;
			cSayi /= 10;
			polindrome += temp;
			polindrome *= 10;
		}
		polindrome += cSayi;
		if(polindrome == sayi)
		{
			System.out.print("Girilen sayi polindrome bir sayidir.");
		}
		else
		{
			System.out.print("Girilen sayi polindrome bir sayi de�ildir.");
		}
	}

}
