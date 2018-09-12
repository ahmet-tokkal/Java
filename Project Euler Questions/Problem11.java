import java.io.File;
import java.util.Scanner;
/*What is the greatest product of four adjacent numbers in the same direction (up, down, left, right,
 or diagonally) in the 20×20 grid?*/
public class Problem11 {

	public static void main(String[] args) {
		int array[][] = new int[20][20];
        try {
            Scanner s = new Scanner(new File("data.txt"));
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    array[i][j] = s.nextInt();
                }
            }
            s.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        int biggestMultiply = 0;
        for(int i=0; i<20;i++){
            for(int j=0; j<20; j++) {
                int multiplyRight = 0,multiplyDown = 0,multiplyDiagRight = 0,multiplyDiagLeft = 0;
                if (j < 17) {
                    multiplyRight = array[i][j] * array[i][j + 1] * array[i][j + 2] * array[i][j + 3];
                    multiplyDown = array[j][i] * array[j + 1][i] * array[j + 2][i] * array[j + 3][i];

                }
                if (i < 17 && j < 17)
                    multiplyDiagRight = array[i][j] * array[i + 1][j + 1] * array[i + 2][j + 2] * array[i + 3][j + 3];
                if (i > 2 && j < 17)
                    multiplyDiagLeft = array[i][j] * array[i - 1][j + 1] * array[i - 2][j + 2] * array[i - 3][j+3];
                if(multiplyDown>biggestMultiply)
                    biggestMultiply = multiplyDown;
                if(multiplyRight>biggestMultiply)
                    biggestMultiply = multiplyRight;
                if(multiplyDiagRight>biggestMultiply)
                    biggestMultiply = multiplyDiagRight;
                if(multiplyDiagLeft>biggestMultiply)
                    biggestMultiply = multiplyDiagLeft;
            }
        }
        System.out.println("Biggest Multiply = "+biggestMultiply);

	}

}
