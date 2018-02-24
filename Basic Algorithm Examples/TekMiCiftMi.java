import java.util.Scanner;
/*Girilen sayinin tek mi çift mi olduðunu bulma */

public class TekMiCiftMi {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int sayi1;
		
		System.out.print("1.Sayiyi Giriniz :");
		sayi1=s.nextInt();
		
		if(sayi1%2==1)
		{
			System.out.println("Girilen sayi tektir");
		}
		else
		{
			System.out.println("Girilen sayi cifttir");
		}
	}

}
