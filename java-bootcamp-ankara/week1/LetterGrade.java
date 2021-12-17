import java.util.Random;

/**
 * The program that prints the letter equivalent of the given average score according to below.
 * 00 - 35  -> FF
 * 35 - 50  -> DC
 * 50 - 70  -> BB
 * 70 - 100 -> AA
*/
public class LetterGrade {
    public static void main(String[] args) {
        String letter;
        // Create instance of Random class
        Random rand = new Random();
        // Generate a random integer in range 0 to 100
        int score = rand.nextInt(101);
        // Print generated score
        System.out.println("Harith's score: " + score);

        if (score >= 70) {
            letter = "AA";
        } else if (score >= 50) {
            letter = "BB";
        } else if (score >= 35) {
            letter = "DC";
        } else {
            letter = "FF";
        }

        System.out.print("Harith's letter grade: " + letter);
    }
}
