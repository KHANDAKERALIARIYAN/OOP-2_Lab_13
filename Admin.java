import java.util.List;

/**
 * Represents an admin user in the system.
 * Admins have additional privileges to manage flights and passengers.
 */
public class Admin extends User {
    private static final String ADMIN_ROLE = "ADMIN"; // Role of the admin

    /**
     * Constructor to initialize an Admin object.
     *
     * @param userID   Unique identifier for the admin.
     * @param email    Email address of the admin.
     * @param password Password for authentication.
     */
    public Admin(String userID, String email, String password) {
        super(userID, email, password);
    }

    /**
     * Adds a new flight to the system.
     *
     * @param flight The flight to be added.
     * @param flightList The list of flights in the system.
     */
    public void addFlight(Flight flight, List<Flight> flightList) {
        if (flight == null) {
            System.out.println("Invalid flight. Cannot add null flight.");
            return;
        }
        if (flightList == null) {
            System.out.println("Flight list is null. Cannot add flight.");
            return;
        }
        if (!flightList.contains(flight)) {
            flightList.add(flight);
            System.out.println("Flight added successfully: " + flight.getFlightNumber());
        } else {
            System.out.println("Flight already exists.");
        }
    }

    /**
     * Removes a flight from the system.
     *
     * @param flightNumber The flight number of the flight to be removed.
     * @param flightList The list of flights in the system.
     */
    public void removeFlight(String flightNumber, List<Flight> flightList) {
        if (flightNumber == null || flightNumber.isEmpty()) {
            System.out.println("Invalid flight number. Cannot remove flight.");
            return;
        }
        if (flightList == null) {
            System.out.println("Flight list is null. Cannot remove flight.");
            return;
        }
        Flight flightToRemove = null;
        for (Flight flight : flightList) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                flightToRemove = flight;
                break;
            }
        }
        if (flightToRemove != null) {
            flightList.remove(flightToRemove);
            System.out.println("Flight removed successfully: " + flightNumber);
        } else {
            System.out.println("Flight not found: " + flightNumber);
        }
    }

    /**
     * Displays all flights in the system.
     *
     * @param flightList The list of flights in the system.
     */
    public void displayAllFlights(List<Flight> flightList) {
        if (flightList == null) {
            System.out.println("Flight list is null. Cannot display flights.");
            return;
        }
        if (flightList.isEmpty()) {
            System.out.println("No flights available.");
        } else {
            System.out.println("List of Flights:");
            for (Flight flight : flightList) {
                System.out.println(flight);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Admin: %s, Role: %s", super.toString(), ADMIN_ROLE);
    }
}