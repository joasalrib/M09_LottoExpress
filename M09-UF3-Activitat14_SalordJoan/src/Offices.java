import java.util.Arrays;
import java.util.Scanner;

public class Offices {
	
	private static int[] play = new int[7];
	private static String officeName = null;

	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			officeName = sc.nextLine();
			generateRandom();
		}
		sc.close();
	}
	
	 //Generates play number.
    public static void generateRandom() {
    	int[] numArray = new int[7];
        for (int i = 0; i < 7; i++) {
            int e = (int) ((Math.random() * (49 - 0)) + 0);
            for (int j = 0 ; j < i; j++) {
            	if (numArray[j] == e) {
            		i--;
            	} else {
            		numArray[i] = e;
            	}
            }
        }
        //String t1 = Arrays.toString(numArray);
        String t1 = "";
        for (int  i = 0; i<numArray.length; i++) {
        	t1 += ","+numArray[i];
        }
        //t1 = t1.substring(1, t1.length()-1);
        System.out.println(officeName + " " + t1);
    }
}
