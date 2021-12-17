/**
 * FlightBookingService
 */
public interface FlightBookingService {

    final int MIN_SEATING_CAPACITY = 10;
    final int BUSINESS_SEAT_CAPACITY = 5;
    final int ECONOMY_START_FROM = 5;

    void setSeatingCapacity(int seatsCount);

    int getSeatingCapacity();

    boolean isAirlinerFull();

    boolean isEconomyFull();

    boolean isBusinessFull();

    void bookSeat();

}