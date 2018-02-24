/*Yarýçapý verilen çemberin çapý, çevresi ve alanýný hesaplayan c programý*/

import java.util.Scanner;
public class CemberHesaplama {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int yaricap,cap;
		double piSayisi=3.14159, cevre,alan;
		System.out.print("Cemberin yaricapini giriniz:");
		yaricap = s.nextInt();
		
		cap= 2*yaricap;
		cevre=2*piSayisi*yaricap;
		alan = piSayisi*Math.pow(yaricap,2);
		
		System.out.println("Cemberin capi : "+cap);
		System.out.println("Cemberin cevresi : "+cevre);
		System.out.println("Cemberin alani : "+alan);

	}

}
