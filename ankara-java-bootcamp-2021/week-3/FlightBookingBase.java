import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public abstract class FlightBookingBase {
    final int MIN_SEATING_CAPACITY = 10;
    final int BUSINESS_SEAT_CAPACITY = 5;

    int seatingCapacity;
    boolean[] seats;

    // will be edited!!!!
    public FlightBookingBase() {
        // set seating capacity based on doc
        this.setSeatingCapacity(MIN_SEATING_CAPACITY);
        // inıt seats
        initSeats();
    }

    // will be edited!!!!
    public FlightBookingBase(int seatingCapacity) {
        // set seating capacity based on doc
        this.setSeatingCapacity(seatingCapacity);
        // init seats
        initSeats();
    }

    public void initSeats() {
        // Init array of seats by seating capacity
        this.seats = new boolean[this.seatingCapacity];
        // Fill array of seats with false means free
        Arrays.fill(this.seats, false);
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity < MIN_SEATING_CAPACITY ? MIN_SEATING_CAPACITY : seatingCapacity;
    }

    public int getSeatingCapacity() {
        return this.seatingCapacity;
    }

    public boolean isAirlinerFull() {
        boolean isFull = IntStream.range(0, this.seatingCapacity).allMatch(i -> seats[i]);
        return isFull;
    }

    public boolean isBusinessFull() {
        boolean isFull = IntStream.range(0, BUSINESS_SEAT_CAPACITY).allMatch(i -> seats[i]);
        return isFull;
    }

    public boolean isEconomyFull() {
        boolean isFull = IntStream.range(BUSINESS_SEAT_CAPACITY, this.seatingCapacity).allMatch(i -> seats[i]);
        return isFull;
    }

    public int getDecision(String message, int min, int max, Scanner scanner) {
        int decision = 1;
        System.out.println(message);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                decision = scanner.nextInt();
                if (decision >= min && decision <= max) {
                    return decision;
                }
                System.out.println("\n***\nEntered value must be in range!!!\n***");
                System.out.println(message);
                scanner.nextLine();

            } else {
                System.out.println("\n***\nEntered value must be a number!!!\n***");
                System.out.println(message);
                scanner.next();
            }
        }

        return decision;

    }

    public String getAirlinerStatus() {
        String message = Arrays.toString(seats).replace("true", "TAKEN").replace("false", "EMPTY");
        return message;
    }

    public String getAirlinerStatus(int decision) {
        int startIndex, endIndex;
        boolean[] seatsSliced;
        String message;

        if (decision == 1) {
            message = "Business Cabin: \n";
            startIndex = 0;
            endIndex = BUSINESS_SEAT_CAPACITY;
        } else {
            message = "Economy Cabin: \n";
            startIndex = BUSINESS_SEAT_CAPACITY;
            endIndex = this.seatingCapacity;
        }
        seatsSliced = Arrays.copyOfRange(seats, startIndex, endIndex);

        message = message + Arrays.toString(seatsSliced).replace("true", "TAKEN").replace("false", "EMPTY");

        return message;
    }

    public boolean pickASeat(int selectedSeat) {
        String purchasedSeat = getOrdinal(selectedSeat + 1);
        if (seats[selectedSeat] == false) {
            seats[selectedSeat] = true;
            System.out.println(purchasedSeat + " seat has been purchased. Have a nice trip!");
            return false;
        } else {
            System.out.println(purchasedSeat + " seat is taken.");
            return true;
        }
    }

    public static String getOrdinal(int i) {
        String[] suffixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
        switch (i % 100) {
            case 11:
            case 12:
            case 13:
                return i + "th";
            default:
                return i + suffixes[i % 10];

        }
    }

    public abstract void bookAFlight();

    public abstract void bookBusinessFlight();

    public abstract void bookEconomyFlight();
}
