import java.util.Scanner;

public class Menu {
	public static void main (String args[]) {
		menu();
	}
	
	public static void menu () {
		System.out.println("------ LOTTO EXPRESS ------");
		System.out.println("1. Add office");
		System.out.println("2. Winners"); //Add winners on .txt
		System.out.println("3. Exit");
		
		Scanner sc = new Scanner(System.in);
		String entry = sc.nextLine();
		
	}
}
