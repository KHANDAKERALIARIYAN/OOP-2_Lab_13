import java.util.List;

// Ensure the Passenger and Flight classes are defined in your project
// or import them if they are in a different package.

public interface DisplayClass {
    void displayFlightsRegisteredByOneUser(Passenger passenger);
    void displayRegisteredUsersForAllFlight(List<Flight> flightList);
    void displayHeaderForUsers(Flight flight, List<Passenger> passengers);
    void displayRegisteredUsersForASpecificFlight(Flight flight);
}
