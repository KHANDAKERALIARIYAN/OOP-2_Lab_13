import java.util.List;

/**
 * Implements the DisplayClass interface to display flight and passenger information.
 */
public class FlightDisplay implements DisplayClass {

    /**
     * Displays all flights registered by a specific passenger.
     *
     * @param passenger The passenger whose flights are to be displayed.
     */
    @Override
    public void displayFlightsRegisteredByOneUser(Passenger passenger) {
        if (passenger == null) {
            System.out.println("Invalid passenger.");
            return;
        }

        List<Flight> flights = passenger.getFlightsRegisteredByUser();
        List<Integer> tickets = passenger.getNumOfTicketsBookedByUser();

        if (flights.isEmpty()) {
            System.out.println("No flights registered for passenger " + passenger.getName());
        } else {
            System.out.println("Flights registered by passenger " + passenger.getName() + ":");
            System.out.println("+------+-------------------+-------------------+-------------------+-------------------+");
            System.out.println("| Num  | Flight Number     | Departure City    | Destination City  | Tickets Booked    |");
            System.out.println("+------+-------------------+-------------------+-------------------+-------------------+");
            for (int i = 0; i < flights.size(); i++) {
                Flight flight = flights.get(i);
                System.out.printf("| %-4d | %-17s | %-17s | %-17s | %-17d |%n",
                        (i + 1), flight.getFlightNumber(), flight.getFromWhichCity(), flight.getToWhichCity(), tickets.get(i));
            }
            System.out.println("+------+-------------------+-------------------+-------------------+-------------------+");
        }
    }

    /**
     * Displays all registered passengers for all flights.
     *
     * @param flightList The list of flights to display registered passengers for.
     */
    @Override
    public void displayRegisteredUsersForAllFlight(List<Flight> flightList) {
        if (flightList == null || flightList.isEmpty()) {
            System.out.println("No flights available.");
            return;
        }

        for (Flight flight : flightList) {
            displayRegisteredUsersForASpecificFlight(flight);
        }
    }

    /**
     * Displays the header for the list of registered passengers for a flight.
     *
     * @param flight     The flight for which the header is displayed.
     * @param passengers The list of passengers registered for the flight.
     */
    @Override
    public void displayHeaderForUsers(Flight flight, List<Passenger> passengers) {
        if (flight == null || passengers == null) {
            System.out.println("Invalid flight or passenger list.");
            return;
        }

        System.out.printf("%n%65s Displaying Registered Customers for Flight No. \"%-6s\" %s %n%n",
                "+++++++++++++", flight.getFlightNumber(), "+++++++++++++");
        System.out.println("+------+------------+------------+----------------------------------+---------+-----------------------------+-------------------------------------+-------------------------+----------------+");
        System.out.println("| Num  | UserID     | Name       | Email                            | Age     | Phone Number                | Address                             | Tickets Booked          |");
        System.out.println("+------+------------+------------+----------------------------------+---------+-----------------------------+-------------------------------------+-------------------------+----------------+");
    }

    /**
     * Displays all registered passengers for a specific flight.
     *
     * @param flight The flight for which registered passengers are displayed.
     */
    @Override
    public void displayRegisteredUsersForASpecificFlight(Flight flight) {
        if (flight == null) {
            System.out.println("Invalid flight.");
            return;
        }

        List<Passenger> passengers = flight.getListOfRegisteredPassengers();
        if (passengers.isEmpty()) {
            System.out.println("No passengers registered for flight " + flight.getFlightNumber());
        } else {
            displayHeaderForUsers(flight, passengers);
            for (int i = 0; i < passengers.size(); i++) {
                Passenger passenger = passengers.get(i);
                System.out.printf("| %-4d | %-10s | %-10s | %-32s | %-7d | %-27s | %-35s | %-23d |%n",
                        (i + 1), passenger.getUserID(), passenger.getName(), passenger.getEmail(),
                        passenger.getAge(), passenger.getPhone(), passenger.getAddress(), passenger.getNumOfTicketsBookedByUser().get(i));
            }
            System.out.println("+------+------------+------------+----------------------------------+---------+-----------------------------+-------------------------------------+-------------------------+----------------+");
        }
    }
}