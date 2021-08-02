import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * THYBookingSystemManager
 */
public class THYBookingManager extends FlightBookingBase {
    final Scanner scanner = new Scanner(System.in);
    final String seatSelectMessage = "Select a seat:";
    List<String> welcomeMessageList = new ArrayList<String>() {
        {
            add("TURKISH AIRLINES");
            // add("Where do you want to explore?");
            add("Please Select Cabin Class:");
            add("1. Business Class");
            add("2. Economy Class");
        }
    };

    @Override
    public void bookAFlight() {
        String welcomeMessage = welcomeMessageList.stream().map(Object::toString).collect(Collectors.joining("\n"));
        boolean isFull = isAirlinerFull();
        int decision;

        if (!isFull) {
            decision = getDecision(welcomeMessage, 1, 2, scanner);
            if (decision == 1) {
                bookBusinessFlight();
            } else {
                bookEconomyFlight();
            }
        } else {
            System.out.println("The airliner is full.");
        }

    }

    @Override
    public void bookBusinessFlight() {
        int selectedSeat;
        // String businessSeatsInverval = "[0-" + this.BUSINESS_SEAT_CAPACITY + "]";
        String businessSelectMessage = seatSelectMessage + getAirlinerStatus();
        boolean isBusinessFull = isBusinessFull();

        if (!isBusinessFull) {
            do {
                selectedSeat = getDecision(businessSelectMessage, 1, BUSINESS_SEAT_CAPACITY, scanner) - 1;
            } while (pickASeat(selectedSeat));
            System.out.println(getAirlinerStatus());
        } else {
            System.out.println("Bussiness cabin is full.");
            bookAFlight();
        }
    }

    @Override
    public void bookEconomyFlight() {
        int selectedSeat;
        // String economySeatsInverval = "(" + "[" + BUSINESS_SEAT_CAPACITY + "-" + 9 +
        // "]" + ")";
        String businessSelectMessage = seatSelectMessage + getAirlinerStatus();
        boolean isEconomyFull = isEconomyFull();
        if (!isEconomyFull) {
            do {
                selectedSeat = getDecision(businessSelectMessage, 6, seatingCapacity, scanner) - 1;
            } while (pickASeat(selectedSeat));
            System.out.println(getAirlinerStatus());
        } else {
            System.out.println("Economy cabin is full.");
            bookAFlight();
        }
    }
}