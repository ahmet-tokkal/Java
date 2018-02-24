/*Kullanýcýdan kaç litre benzin ve kaç km yol aldýðýný alýp her litre için kaç km yol aldýðýný hesaplayan ve 
 * girilen tüm bilgilerden sonra toplam gidilen km için harcanan benzin miktarýný bulan c programý*/

import java.util.Scanner;
public class KmdeHarcananBenzin {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		float harcananBenzin=0,alinanYol,oran,toplamOran=0;
		int sayac=0;
		while(harcananBenzin>=0)
		{
			System.out.print("Kaç litre benzin harcandý (Cýkýs icin -1) :");
			harcananBenzin = s.nextFloat();
			if(harcananBenzin==-1)
			{
				break;
			}
			else{
				System.out.print("Kaç km yol alindi :");
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
