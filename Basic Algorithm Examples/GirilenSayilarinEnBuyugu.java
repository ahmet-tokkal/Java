/*Girilen 10 sayýdan dizisiz en büyüðünü bulan C programý*/
import java.util.Scanner;
public class GirilenSayilarinEnBuyugu {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int sayi,enBuyukSayi=0;
		for (int i = 0; i < 10; i++) {
			System.out.print((i+1)+". sayiyi giriniz :");
			sayi = s.nextInt();
			if(sayi>enBuyukSayi)
			{
				enBuyukSayi=sayi;
			}
		}
		System.out.print("En buyuk sayi : "+enBuyukSayi);

	}

}
