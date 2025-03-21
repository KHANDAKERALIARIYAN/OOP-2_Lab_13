import java.util.ArrayList;
import java.util.List;

/**
 * Handles the scheduling and management of flights in the airline system.
 * Allows adding, removing, and displaying flights.
 */
public class FlightScheduler {
    private List<Flight> flightList; // List of scheduled flights

    /**
     * Constructor to initialize the FlightScheduler.
     */
    public FlightScheduler() {
        this.flightList = new ArrayList<>();
    }

    /**
     * Schedules a new flight and adds it to the flight list.
     *
     * @param flight The flight to be scheduled.
     * @return true if the flight was added successfully, false otherwise.
     */
    public boolean scheduleFlight(Flight flight) {
        if (flight != null && !flightList.contains(flight)) {
            flightList.add(flight);
            System.out.println("Flight scheduled successfully: " + flight.getFlightNumber());
            return true;
        } else {
            System.out.println("Flight already exists or is invalid.");
            return false;
        }
    }

    /**
     * Removes a flight from the flight list.
     *
     * @param flightNumber The flight number of the flight to be removed.
     * @return true if the flight was removed successfully, false otherwise.
     */
    public boolean removeFlight(String flightNumber) {
        if (flightNumber == null || flightNumber.trim().isEmpty()) {
            System.out.println("Invalid flight number.");
            return false;
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
            return true;
        } else {
            System.out.println("Flight not found: " + flightNumber);
            return false;
        }
    }

    /**
     * Displays all scheduled flights.
     */
    public void displayAllFlights() {
        if (flightList.isEmpty()) {
            System.out.println("No flights scheduled.");
        } else {
            System.out.println("List of Scheduled Flights:");
            for (Flight flight : flightList) {
                System.out.println(flight);
            }
        }
    }

    /**
     * Finds a flight by its flight number.
     *
     * @param flightNumber The flight number to search for.
     * @return The flight object if found, null otherwise.
     */
    public Flight findFlightByNumber(String flightNumber) {
        if (flightNumber == null || flightNumber.trim().isEmpty()) {
            System.out.println("Invalid flight number.");
            return null;
        }

        for (Flight flight : flightList) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                return flight;
            }
        }

        System.out.println("Flight not found: " + flightNumber);
        return null;
    }

    /**
     * Gets the list of all scheduled flights.
     *
     * @return The list of scheduled flights.
     */
    public List<Flight> getFlightList() {
        return flightList;
    }
}