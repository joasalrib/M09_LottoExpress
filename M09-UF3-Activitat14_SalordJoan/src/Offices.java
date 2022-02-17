import java.util.Scanner;

public class Offices {

	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		String officeName = null;
		
		while (sc.hasNext()) {
			officeName = sc.nextLine();
			System.out.println("Office name: " + officeName);
		}
	}
}
