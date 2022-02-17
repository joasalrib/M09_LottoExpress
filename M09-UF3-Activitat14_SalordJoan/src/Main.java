import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int player = 0;
    static int cash = 0;
    //static int[] winner = new int[7];
    static int[] winner = {1,2,3,4,5,6,7};

    static ArrayList<int[]> firstCategory = new ArrayList<>();
    static ArrayList<int[]> secondCategory = new ArrayList<>();
    static ArrayList<int[]> thirdCategory = new ArrayList<>();
    static ArrayList<int[]> fourthCategory = new ArrayList<>();
    static ArrayList<int[]> fifthCategory = new ArrayList<>();
    static ArrayList<int[]> sixthCategory = new ArrayList<>();

    static ArrayList<ArrayList<int[]>> tets = new ArrayList<>();

    public static void main (String args[]) {

        /* This is a brief program to check on the lotto's logic given all
          6 different cases.

          The main program is really an infinite menu, to be able to quit the
          program or generate a new office.
          Each office works as a processor. ? Either way it must return a
          string, which then can be converted to an array for easier management.
          If an office only sustains one play, when the message is collected
          it can be added to an ArrayList<int[]> to make it space dynamic and
          more accessible.

          The lotto logic works as a thread that executes every 30 secs
          with the plays generated, taking them from the ArrayList<int[]>
          mentioned before.
        */

        ArrayList<int[]> plays = new ArrayList<>();

        // Automatism commented for test purposes.
        /* generateRandom();

        for (int i = 0; i < 5; i++) {
            plays.add(generatePlays());
        } */
        
        // Adding all categories to another ArrayList to clear them faster. Is it worth though?
        tets.add(firstCategory);
        tets.add(secondCategory);
        tets.add(thirdCategory);
        tets.add(fourthCategory);
        tets.add(fifthCategory);
        tets.add(sixthCategory);


        int[] second = {0,2,3,4,5,6,7};
        int[] third = {0,2,3,4,5,6,5};
        int[] fourth = {0,1,3,4,5,6,7};
        int[] fifth = {0,1,1,4,5,6,7};
        int[] sixth = {0,1,1,1,5,6,7};

        plays.add(winner);
        plays.add(second);
        plays.add(third);
        plays.add(fourth);
        plays.add(fifth);
        plays.add(sixth);

        count(plays);

        showResults();
        
        resetLotto();

    }

    // Shows results when the lotto is done.
    public static void showResults () {
        System.out.println("\n----- PRIZES ----- for " + Arrays.toString(winner));
        System.out.println("Pool prize: " + cash + "$\n");

        System.out.println("First category: ");
        for (int[] play : firstCategory) {
            System.out.println(Arrays.toString(play));
        }

        System.out.println("Second category: ");
        for (int[] play : secondCategory) {
            System.out.println(Arrays.toString(play));
        }

        System.out.println("Third category: ");
        for (int[] play : thirdCategory) {
            System.out.println(Arrays.toString(play));
        }

        System.out.println("Fourth category: ");
        for (int[] play : fourthCategory) {
            System.out.println(Arrays.toString(play));
        }

        System.out.println("Fifth category: ");
        for (int[] play : fifthCategory) {
            System.out.println(Arrays.toString(play));
        }

        System.out.println("Sixth category: ");
        for (int[] play : sixthCategory) {
            System.out.println(Arrays.toString(play));
        } 
    }
    
    // Resets all the categories and the cash count.
    public static void resetLotto() {
    	cash = 0;
    	for(ArrayList<int[]> e : tets) {
        	e.clear();
        }
    	showResults();
    }

    // Comparasion between the winner number and the plays.
    public static void count (ArrayList<int[]> plays) {
        // Complementary number is always the last number on the
        // winner int[]. Therefore position 6.
        int complementary = winner[6];

        for (int[] play : plays) {
            int correct = 0;
            for (int e = 0; e < 6; e++) {
                if (play[e] == winner[e] ) {
                    correct++;
                }
            }

            // Relocate plays into correct category
            // Check complementary on category 2
            switch (correct) {
                case 6:
                    firstCategory.add(play);
                    break;
                case 5:
                    if (play[6] == complementary) {
                        secondCategory.add(play);
                        break;
                    }
                    thirdCategory.add(play);
                    break;
                case 4:
                    fourthCategory.add(play);
                    break;
                case 3:
                    fifthCategory.add(play);
                    break;
                default:
                    sixthCategory.add(play);
                    break;
            }
        }
    }

    //Generates winner number.
    public static void generateRandom() {
        for (int i = 0; i < 7; i++) {
            winner[i] = (int) ((Math.random() * (49 - 0)) + 0);
        }
        System.out.println("Winner number: " + Arrays.toString(winner));
    }

    //Generates entries.
    public static int[] generatePlays () {

        int[] number = new int[7];
        for (int i = 0; i < number.length; i++) {
            number [i] = (int) ((Math.random() * (49 - 0)) + 0);

        }
        player++;
        cash++;
        System.out.println("Play nº " + player + ": " + Arrays.toString(number));

        return number;
    }
}
