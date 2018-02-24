/*Alýnan 3 sayýyý toplayan,çarpan ortalamasýný,en küçüðünü ve en büyüðünü bulan java programý.*/

import java.util.Scanner;
public class KarisikIslemler {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		int a,b,c;
		System.out.print("1.Sayiyi giriniz :");
		a=s.nextInt();
		System.out.print("2.Sayiyi giriniz :");
		b=s.nextInt();
		System.out.print("3.Sayiyi giriniz :");
		c=s.nextInt();
		
		int toplam = a+b+c;
		int carpim = a*b*c;
		int ortalama = toplam/3;
		
		if(a>=b && a>=c)
		{
			System.out.println("En buyuk sayi : "+a);
			if(b<=c) {
				System.out.println("En kucuk sayi : "+b);
			}
			else {
				System.out.println("En kucuk sayi : "+c);
			}
		}
		else if(b>=c && b>=a)
		{
			System.out.println("En buyuk sayi : "+b);
			if(a<=c) {
				System.out.println("En kucuk sayi : "+a);
			}
			else {
				System.out.println("En kucuk sayi : "+c);
			}
		}
		else if(c>=a && c>=b)
		{
			System.out.println("En buyuk sayi : "+c);
			if(a<=b) {
				System.out.println("En kucuk sayi : "+a);
			}
			else {
				System.out.println("En kucuk sayi : "+b);
			}
		}
	}
}