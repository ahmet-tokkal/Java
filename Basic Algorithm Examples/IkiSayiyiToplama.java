/*Ýki Sayýyý toplayan java programý*/

import java.util.Scanner;//Kullanýcýdan girdi almak için Scanner sýnýfý projeye eklendi
public class IkiSayiyiToplama {
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int sayi1, sayi2,  toplam;
		
		System.out.print("1.Sayiyi Giriniz :");
		sayi1=s.nextInt();
		System.out.print("2.Sayiyi Giriniz :");
		sayi2=s.nextInt();
		toplam=sayi1+sayi2;
		
		System.out.println(sayi1+" + "+sayi2+" = "+toplam);

	}

}
