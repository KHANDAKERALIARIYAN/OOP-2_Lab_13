import java.util.ArrayList;
import java.util.List;

/**
 * Represents a flight in the airline management system.
 * Encapsulates flight details and behavior, such as managing passengers and seats.
 */
public class Flight {
    private String flightNumber; // Unique identifier for the flight
    private String fromWhichCity; // Departure city
    private String toWhichCity; // Destination city
    private String gate; // Boarding gate
    private double distanceInMiles; // Distance in miles
    private double distanceInKm; // Distance in kilometers
    private String flightTime; // Estimated flight time
    private int numOfSeatsInTheFlight; // Total number of seats available
    private List<Passenger> listOfRegisteredPassengers; // List of passengers registered for the flight
    private String destination; // Destination
    private String departureTime; // Departure time

    /**
     * Constructor to initialize a Flight object.
     *
     * @param flightNumber         Unique identifier for the flight.
     * @param fromWhichCity        Departure city.
     * @param toWhichCity          Destination city.
     * @param gate                 Boarding gate.
     * @param distanceInMiles      Distance in miles.
     * @param distanceInKm         Distance in kilometers.
     * @param flightTime           Estimated flight time.
     * @param numOfSeatsInTheFlight Total number of seats available.
     */
    public Flight(String flightNumber, String fromWhichCity, String toWhichCity, String gate,
                  double distanceInMiles, double distanceInKm, String flightTime, int numOfSeatsInTheFlight) {
        this.flightNumber = flightNumber;
        this.fromWhichCity = fromWhichCity;
        this.toWhichCity = toWhichCity;
        this.gate = gate;
        this.distanceInMiles = distanceInMiles;
        this.distanceInKm = distanceInKm;
        this.flightTime = flightTime;
        this.numOfSeatsInTheFlight = numOfSeatsInTheFlight;
        this.listOfRegisteredPassengers = new ArrayList<>();
    }

    public Flight(String flightNumber, String destination, String departureTime) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    // Getters and Setters
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFromWhichCity() {
        return fromWhichCity;
    }

    public void setFromWhichCity(String fromWhichCity) {
        this.fromWhichCity = fromWhichCity;
    }

    public String getToWhichCity() {
        return toWhichCity;
    }

    public void setToWhichCity(String toWhichCity) {
        this.toWhichCity = toWhichCity;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public double getDistanceInMiles() {
        return distanceInMiles;
    }

    public void setDistanceInMiles(double distanceInMiles) {
        this.distanceInMiles = distanceInMiles;
    }

    public double getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(double distanceInKm) {
        this.distanceInKm = distanceInKm;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public int getNumOfSeatsInTheFlight() {
        return numOfSeatsInTheFlight;
    }

    public void setNumOfSeatsInTheFlight(int numOfSeatsInTheFlight) {
        this.numOfSeatsInTheFlight = numOfSeatsInTheFlight;
    }

    public List<Passenger> getListOfRegisteredPassengers() {
        return listOfRegisteredPassengers;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * Adds a passenger to the flight.
     *
     * @param passenger The passenger to be added.
     * @return true if the passenger was added successfully, false otherwise.
     */
    public boolean addPassenger(Passenger passenger) {
        if (passenger != null && !listOfRegisteredPassengers.contains(passenger)) {
            listOfRegisteredPassengers.add(passenger);
            return true;
        }
        return false;
    }

    /**
     * Removes a passenger from the flight.
     *
     * @param passenger The passenger to be removed.
     * @return true if the passenger was removed successfully, false otherwise.
     */
    public boolean removePassenger(Passenger passenger) {
        return listOfRegisteredPassengers.remove(passenger);
    }

    /**
     * Checks if a passenger is registered for the flight.
     *
     * @param passenger The passenger to check.
     * @return true if the passenger is registered, false otherwise.
     */
    public boolean isPassengerRegistered(Passenger passenger) {
        return listOfRegisteredPassengers.contains(passenger);
    }

    /**
     * Displays the list of registered passengers for the flight.
     */
    public void displayRegisteredPassengers() {
        if (listOfRegisteredPassengers.isEmpty()) {
            System.out.println("No passengers registered for flight " + flightNumber);
        } else {
            System.out.println("Passengers registered for flight " + flightNumber + ":");
            for (Passenger passenger : listOfRegisteredPassengers) {
                System.out.println(passenger);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return flightNumber.equalsIgnoreCase(flight.flightNumber);
    }

    @Override
    public int hashCode() {
        return flightNumber.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return String.format("Flight Number: %s, From: %s, To: %s, Gate: %s, Distance: %.2f miles (%.2f km), Flight Time: %s, Available Seats: %d",
                flightNumber, fromWhichCity, toWhichCity, gate, distanceInMiles, distanceInKm, flightTime, numOfSeatsInTheFlight);
    }
}