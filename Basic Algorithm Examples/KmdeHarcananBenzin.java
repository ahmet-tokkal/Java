/*Kullan�c�dan ka� litre benzin ve ka� km yol ald���n� al�p her litre i�in ka� km yol ald���n� hesaplayan ve 
 * girilen t�m bilgilerden sonra toplam gidilen km i�in harcanan benzin miktar�n� bulan c program�*/

import java.util.Scanner;
public class KmdeHarcananBenzin {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		float harcananBenzin=0,alinanYol,oran,toplamOran=0;
		int sayac=0;
		while(harcananBenzin>=0)
		{
			System.out.print("Ka� litre benzin harcand� (C�k�s icin -1) :");
			harcananBenzin = s.nextFloat();
			if(harcananBenzin==-1)
			{
				break;
			}
			else{
				System.out.print("Ka� km yol alindi :");
				alinanYol = s.nextFloat();
				oran=harcananBenzin/alinanYol;
				System.out.println("1lt benzin ile alinan yol : "+oran);
				toplamOran+=oran;
				sayac++;
			}
			
		}
		System.out.println("Toplam ortalama km/litre :"+(toplamOran / sayac));
		
	}

}
