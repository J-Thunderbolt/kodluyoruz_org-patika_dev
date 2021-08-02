import java.util.Scanner;

public class ConsoleUI {
    public static void main(String[] args) {
        THYBookingManager thyBookingManager = new THYBookingManager();
        PegasusBookingManager pegasusBookingManager = new PegasusBookingManager();
        final Scanner scanner = new Scanner(System.in);
        int airlineDecision = 1;

        try (scanner) {
            while (airlineDecision > 0 && airlineDecision < 3) {
                System.out.println("Select Airline:\n1. Turkish Airlines\n2. Pegasus Airlines");
                airlineDecision = scanner.nextInt();
                if (airlineDecision == 1) {
                    thyBookingManager.bookAFlight();
                } else {
                    pegasusBookingManager.bookAFlight();

                }
            }
        }
    }
}
