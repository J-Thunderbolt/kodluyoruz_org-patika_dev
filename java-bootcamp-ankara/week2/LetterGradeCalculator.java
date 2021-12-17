import java.util.Scanner;

/*
 * This program calculates the final score and letter grade of a student 
 * based on the midterm and final score entered by user. 
 * Program prints the grade based on this logic: 
 * If the average of marks is >= 70 then prints Grade ‘AA’ 
 * If the average is <70 and>=50 then prints Grade ‘BB’ 
 * If the average is <50 and >=20 then prints Grade ‘CB’ 
 * else prints Grade ‘FF’
 */
public class LetterGradeCalculator {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        double midtermGrade;
        double finalGrade;
        double semesterGrade;
        String letterGrade;

        // Get midterm and final grade from user
        midtermGrade = getGrade("Midterm grade: ", scanner);
        finalGrade = getGrade("Final grade: ", scanner);

        // Calculate and print semester grade
        semesterGrade = calculateSemesterGrade(midtermGrade, finalGrade);
        System.out.println("Semester Grade : " + semesterGrade);

        // Calculate and print letter grade
        letterGrade = calculateLetterGrade(semesterGrade);
        System.out.println("Letter Grade : " + letterGrade);

    }

    /**
     * input1: a message to ask the grade for a particular exam 
     * input2: a scanner instance to get value
     * output: grade of the particular exam entered by user
     */
    public static double getGrade(String message, Scanner scanner) {
        System.out.print(message);

        while (!scanner.hasNextDouble()) {
            System.out.println("Grade must be a number");
            System.out.print(message);
            scanner.next();
        }

        return scanner.nextDouble();
    }

    /**
     * input1: midterm exam grade
     * input2: final exam grade
     * output: calculated semester grade based on given midterm and final exam (30% midterm + 70% final)
     */
    public static double calculateSemesterGrade(double midtermGrade, double finalGrade) {
        return midtermGrade * 0.3 + finalGrade * 0.7;
    }

    /**
     * input1: semester grade
     * output: semester letter grade
     */
    public static String calculateLetterGrade(double semesterGrade) {

        String letterGrade;

        if (semesterGrade > 70) {
            letterGrade = "AA";
        } else if (semesterGrade > 50 && semesterGrade < 71) {
            letterGrade = "BB";
        } else if (semesterGrade > 20 && semesterGrade < 51) {
            letterGrade = "CB";
        } else {
            letterGrade = "FF";
        }

        return letterGrade;
    }

}