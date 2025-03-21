import java.util.ArrayList;
import java.util.List;

/**
 * Represents a passenger user in the system.
 * Passengers can book and cancel flights.
 */
public class Passenger extends User {
    private String name; // Full name of the passenger
    private String phone; // Phone number of the passenger
    private String address; // Address of the passenger
    private int age; // Age of the passenger
    private List<Flight> flightsRegisteredByUser; // List of flights booked by the passenger
    private List<Integer> numOfTicketsBookedByUser; // List of tickets booked for each flight

    /**
     * Constructor to initialize a Passenger object.
     *
     * @param userID   Unique identifier for the passenger.
     * @param email    Email address of the passenger.
     * @param password Password for authentication.
     * @param name     Full name of the passenger.
     * @param phone    Phone number of the passenger.
     * @param address  Address of the passenger.
     * @param age      Age of the passenger.
     */
    public Passenger(String userID, String email, String password, String name, String phone, String address, int age) {
        super(userID, email, password);
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.age = age;
        this.flightsRegisteredByUser = new ArrayList<>();
        this.numOfTicketsBookedByUser = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Flight> getFlightsRegisteredByUser() {
        return flightsRegisteredByUser;
    }

    public List<Integer> getNumOfTicketsBookedByUser() {
        return numOfTicketsBookedByUser;
    }

    /**
     * Books a flight for the passenger.
     *
     * @param flight       The flight to be booked.
     * @param numOfTickets The number of tickets to book.
     */
    public void bookFlight(Flight flight, int numOfTickets) {
        if (flight != null && numOfTickets > 0) {
            flightsRegisteredByUser.add(flight);
            numOfTicketsBookedByUser.add(numOfTickets);
            System.out.println("Flight booked successfully: " + flight.getFlightNumber());
        } else {
            System.out.println("Invalid flight or number of tickets.");
        }
    }

    /**
     * Cancels a flight for the passenger.
     *
     * @param flight The flight to be canceled.
     */
    public void cancelFlight(Flight flight) {
        int index = flightsRegisteredByUser.indexOf(flight);
        if (index != -1) {
            flightsRegisteredByUser.remove(index);
            numOfTicketsBookedByUser.remove(index);
            System.out.println("Flight canceled successfully: " + flight.getFlightNumber());
        } else {
            System.out.println("Flight not found in bookings.");
        }
    }

    @Override
    public String toString() {
        return String.format("Passenger: %s, Name: %s, Phone: %s, Address: %s, Age: %d",
                super.toString(), name, phone, address, age);
    }
}