import java.util.Scanner;

/**
 * Kullanıcıların manavdan almış oldukları ürünlerin ağırlık değerlerini alıp,
 * bu değerlere göre toplam tutarı ekrana yazdıran program.
 * 
 * Fiyat listesi: 
 * Armut : 2,14 TL 
 * Elma : 3,67 TL 
 * Domates : 1,11 TL 
 * Muz: 0,95 TL
 * Patlıcan : 5,00 TL
 */
public class GreenGrocer {
    public static void main(String[] args) {
        final double PEAR = 2.14;
        final double APPLE = 3.67;
        final double TOMATO = 1.11;
        final double BANANA = 0.95;
        final double EGGPLANT = 5;
        final Scanner scanner = new Scanner(System.in);
        double total = 0;
        double weight;
        double prices[] = { PEAR, APPLE, TOMATO, BANANA, EGGPLANT };
        String[] messages = { 
            "Weight of pear in kgs: ", 
            "Weight of apple in kgs: ", 
            "Weight of tomato in kgs: ",
            "Weight of banana in kgs: ", 
            "Weight of eggplant in kgs: " 
        };

        try (scanner) {
            for (int i = 0; i < messages.length; i++) {
                weight = getWeight(messages[i], scanner);
                total += weight * prices[i];
            }
        }

        System.out.printf("Total price %.2f", total);
    }

    /**
     * input1: a message to ask the weight value for a particular product
     * input2: a scanner instance to get value
     * output: weight value of the particular product
     */
    public static double getWeight(String message, Scanner scan) {
        System.out.print(message);

        while (!scan.hasNextDouble()) {
            System.out.println("Weight value must be a number");
            System.out.print(message);
            scan.next();
        }

        return scan.nextDouble();
    }
}