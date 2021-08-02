import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Main Class
 */
public class BoxOffice {

    private MovieTheater moviesDB;
    private Map<Integer, Movie> movies;
    // private Map<Integer, Genre> genres;
    List<Ticket> tickets;

    public BoxOffice() {
        this.moviesDB = new MovieTheater();
        this.movies = moviesDB.getMovies();
        // this.genres = moviesDB.getGenres();
        this.tickets = new ArrayList<Ticket>();

    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        BoxOffice boxOffice = new BoxOffice();

        try (scanner) {
            boxOffice.sellTickets(scanner);
        }
        boxOffice.printTotalCost();
    }

    private void printTotalCost() {
        String ticketCosts = "\n" + tickets.stream().map(Object::toString).collect(Collectors.joining("\n"));
        double totalCost = tickets.stream().map(ticket -> ticket.getCost()).reduce(Double::sum).get();
                

        System.out.println(ticketCosts);
        System.out.println("\n Total cost: " + totalCost);
    }

    private void sellTickets(Scanner scanner) {
        int selectedMovie;
        int currentCustomerAge;

        int bookingCount = getIntValue("How many tickets: ", "([0-9]|[1-9][0-9])", scanner);

        String movies2String = movies.entrySet().stream().map(Object::toString).collect(Collectors.joining("\n"));
        String selectFilmMessage = "\n" + movies2String + "\n\nSelect a film: ";

        for (int i = 0; i < bookingCount; i++) {
            currentCustomerAge = getIntValue("\nAge: ", "([0-9]|[1-9][0-9]|[1][0-9][0-9])", scanner);
            selectedMovie = getIntValue(selectFilmMessage, "([0-4])", scanner);
            tickets.add(new Ticket(currentCustomerAge, movies.get(selectedMovie)));
        }
    }

    public static int getIntValue(String message, String interval, Scanner scanner) {
        System.out.print(message);

        while (!scanner.hasNextInt() || !scanner.hasNext(interval)) {
            System.out.println("Entered value must be a number or valid");
            System.out.print(message);
            scanner.next();
        }

        return scanner.nextInt();
    }

    /*
     * public static Customer getCustomerInfo(Scanner scanner) { String name; int
     * age;
     * 
     * System.out.println("Name: "); name = scanner.nextLine();
     * 
     * age = getIntValue("Age: ", scanner);
     * 
     * return new Customer(name, age); }
     */
}

class MovieTheater {

    Map<Integer, Genre> genres;
    Map<Integer, Movie> movies;
    final double TICKET_BASE_PRICE = 25.0;

    public MovieTheater() {
        setGenres();
        setMovies();
    }

    public void setGenres() {
        this.genres = new HashMap<>() {
            {
                put(0, new Genre(0, "Action"));
                put(1, new Genre(1, "Comedy"));
                put(2, new Genre(2, "Drama"));
                put(3, new Genre(3, "Horror"));
                put(4, new Genre(4, "Mystery"));
            }
        };
    }

    public void setMovies() {
        this.movies = new HashMap<>() {
            {
                put(0, new Movie(0, 3, "Psycho (1960)", TICKET_BASE_PRICE));
                put(1, new Movie(1, 0, "The Road Warrior (1982)", TICKET_BASE_PRICE));
                put(2, new Movie(2, 1, "Duck Soup (1933)", TICKET_BASE_PRICE));
                put(3, new Movie(3, 4, "Memento (2002)", TICKET_BASE_PRICE));
                put(4, new Movie(4, 2, "The Shawshank Redemption (1994)", TICKET_BASE_PRICE));
            }
        };

    }

    public Map<Integer, Genre> getGenres() {
        return genres;
    }

    public Map<Integer, Movie> getMovies() {
        return movies;
    }

}

/*
 * class Customer { int id; String name; int age;
 * 
 * public Customer(String name, int age) { this.name = name; this.age = age; }
 * 
 * public int getId() { return id; }
 * 
 * public void setId(int id) { this.id = id; }
 * 
 * public String getName() { return name; }
 * 
 * public void setName(String name) { this.name = name; }
 * 
 * public int getAge() { return age; }
 * 
 * public void setAge(int age) { this.age = age; } }
 */

class Ticket {
    private int id;
    private double cost;
    private double moviePrice;

    public Ticket(int customerAge, Movie movie) {
        this.moviePrice = movie.getPrice();
        this.cost = this.setCost(customerAge, movie);
    }

    public int getId() {
        return this.id;
    }

    public double getCost() {
        return this.cost;
    }

    private double setCost(int customerAge, Movie movie) {
        double discount = 0;
        double costAfterDiscount;
        double discountAmount;

        if (customerAge < 18) {
            discount += 10;
        }

        if (customerAge >= 18 && customerAge < 25) {
            discount += 5;
        }

        if (movie.getGenreId() == 3) {
            discount += 10;
        }

        discountAmount = moviePrice * discount / 100;
        costAfterDiscount = moviePrice - discountAmount;

        return costAfterDiscount;
    }

    @Override
    public String toString() {
        return "Ticket [cost after discount(s): " + cost + ", movie base price: " + moviePrice + "]";
    }
}

class Genre {
    private int id;
    private String name;

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Movie {
    private int id;
    private int genreId;
    private String name;
    private double price;

    public Movie(int id, int genreId, String name, double price) {
        this.id = id;
        this.genreId = genreId;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return " " + name + ", Base Price: " + price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
