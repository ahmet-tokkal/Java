/*
	Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
	1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
	By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 */
public class Problem2 {
	public static void main(String[] args) {
		int birinci = 0;
		int ikinci = 1;
		int gecici;
		int toplam =0;
		while(ikinci< 4000000) {
			gecici = ikinci;
			ikinci += birinci;
			birinci = gecici;
			if(birinci % 2 == 0 )
			{
				toplam+=birinci;
			}
			System.out.print(birinci+", ");
		}
		System.out.println("toplam :"+ toplam);
	}

}
