import java.util.List;

/**
 * Handles flight booking and cancellation for passengers.
 * Ensures that flight seats are managed correctly and passengers are registered or unregistered from flights.
 */
public class FlightReservation {

    /**
     * Books a flight for a passenger with the specified number of tickets.
     *
     * @param flight       The flight to be booked.
     * @param passenger    The passenger booking the flight.
     * @param numOfTickets The number of tickets to book.
     */
    public void bookFlight(Flight flight, Passenger passenger, int numOfTickets) {
        if (flight == null || passenger == null || numOfTickets <= 0) {
            System.out.println("Invalid input. Flight, passenger, and number of tickets must be valid.");
            return;
        }

        if (flight.getNumOfSeatsInTheFlight() >= numOfTickets) {
            // Update available seats in the flight
            flight.setNumOfSeatsInTheFlight(flight.getNumOfSeatsInTheFlight() - numOfTickets);

            // Add the flight to the passenger's list of registered flights
            passenger.getFlightsRegisteredByUser().add(flight);

            // Add the number of tickets to the passenger's list of booked tickets
            passenger.getNumOfTicketsBookedByUser().add(numOfTickets);

            // Add the passenger to the flight's list of registered passengers
            flight.addPassenger(passenger);

            System.out.printf("Successfully booked %d tickets for flight %s for passenger %s.%n",
                    numOfTickets, flight.getFlightNumber(), passenger.getName());
        } else {
            System.out.println("Not enough seats available for flight " + flight.getFlightNumber());
        }
    }

    /**
     * Cancels a flight booking for a passenger and returns the tickets to the flight's available seats.
     *
     * @param flight       The flight to be canceled.
     * @param passenger    The passenger canceling the flight.
     * @param numOfTickets The number of tickets to cancel.
     */
    public void cancelFlight(Flight flight, Passenger passenger, int numOfTickets) {
        if (flight == null || passenger == null || numOfTickets <= 0) {
            System.out.println("Invalid input. Flight, passenger, and number of tickets must be valid.");
            return;
        }

        // Get the index of the flight in the passenger's list of registered flights
        int index = passenger.getFlightsRegisteredByUser().indexOf(flight);

        if (index != -1) {
            // Get the number of tickets booked for this flight
            int bookedTickets = passenger.getNumOfTicketsBookedByUser().get(index);

            if (bookedTickets >= numOfTickets) {
                // Update the number of available seats in the flight
                flight.setNumOfSeatsInTheFlight(flight.getNumOfSeatsInTheFlight() + numOfTickets);

                // Update the number of tickets booked by the passenger
                passenger.getNumOfTicketsBookedByUser().set(index, bookedTickets - numOfTickets);

                // If no tickets are left, remove the flight from the passenger's list
                if (passenger.getNumOfTicketsBookedByUser().get(index) == 0) {
                    passenger.getFlightsRegisteredByUser().remove(index);
                    passenger.getNumOfTicketsBookedByUser().remove(index);
                    flight.removePassenger(passenger); // Remove the passenger from the flight's list
                }

                System.out.printf("Successfully canceled %d tickets for flight %s for passenger %s.%n",
                        numOfTickets, flight.getFlightNumber(), passenger.getName());
            } else {
                System.out.println("Cannot cancel more tickets than booked for flight " + flight.getFlightNumber());
            }
        } else {
            System.out.println("Flight " + flight.getFlightNumber() + " not found in passenger's bookings.");
        }
    }

    /**
     * Displays all flights registered by a passenger.
     *
     * @param passenger The passenger whose flights are to be displayed.
     */
    public void displayFlightsRegisteredByPassenger(Passenger passenger) {
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
            for (int i = 0; i < flights.size(); i++) {
                System.out.printf("Flight: %s, Tickets Booked: %d%n",
                        flights.get(i).getFlightNumber(), tickets.get(i));
            }
        }
    }
}