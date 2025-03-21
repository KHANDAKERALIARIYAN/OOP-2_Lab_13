import java.util.List;

public interface DisplayClass {
    void displayFlightsRegisteredByOneUser(Passenger passenger);
    void displayRegisteredUsersForAllFlight(List<Flight> flightList);
    void displayHeaderForUsers(Flight flight, List<Passenger> passengers);
    void displayRegisteredUsersForASpecificFlight(Flight flight);
}
