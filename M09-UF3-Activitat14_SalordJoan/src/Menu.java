import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {
	
	private static ProcessBuilder builder = new ProcessBuilder ("java", "-jar", "Offices.jar");
	private static Process p;
	private static InputStream officeResponseInput = null; 
	private static BufferedReader officeResponse;
	
	private static ArrayList<int[]> lottoPlays = new ArrayList<>();
	private static ArrayList<String> lottoName = new ArrayList<>();
	
	public static void main (String args[]) throws IOException {
		// Offices program start-up
		p = builder.start();
		officeResponseInput = p.getInputStream();
		officeResponse = new BufferedReader(new InputStreamReader(officeResponseInput));
		
		menu();
	}
	
	public static void menu () throws IOException {
		System.out.println("------ LOTTO EXPRESS ------");
		System.out.println("1. Add office");
		System.out.println("2. Winners"); //Add winners on .txt
		System.out.println("3. Exit");
		
		readEntry();
	}
	
	public static void readEntry () throws IOException {
		Scanner sc = new Scanner(System.in);
		String entry = sc.nextLine();
		
		if (entry.equals("1")) {
			System.out.println("Entry office name: ");
			entry = sc.nextLine();
			// Add argument - Creates an office with the given name.
			PrintWriter pw = new PrintWriter(p.getOutputStream());
			pw.println(entry);
			pw.flush();
			
			fill(officeResponse);
		}
		menu();
	}
	
	public static void fill (BufferedReader entry) throws IOException {
		String officeEntry = entry.readLine();
		System.out.println(officeEntry);
		String[] play  = officeEntry.split(" ");
		//System.out.println(play[0] + "--- " + play[2]);
		String officeName = play[0];
		lottoName.add(officeName);
		
		String numberString = play[1];
		//System.out.println("+asdf" + numberString);
		int[] numberInt = new int[7];
		for (int i = 0; i<numberString.length(); i++) {
			//numberInt[i] = Integer.parseInt(numberString[i]);
		}
		lottoPlays.add(numberInt);
		
		for (int i = 0; i<lottoName.size(); i++) {
			//System.out.println(lottoName.get(i));
			//System.out.println(Arrays.toString(lottoPlays.get(i)));
		}
	}
}