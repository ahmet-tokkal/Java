/*Girilen say� kadar * dan olu�an i�i dolu d�rtgen �izen C program�*/
import java.util.Scanner;
public class IciDoluKare {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Sayiyi Giriniz :");
		int sayi = s.nextInt();
		
		for (int i = 0; i < sayi; i++) 
		{
			for (int j = 0; j < sayi; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
