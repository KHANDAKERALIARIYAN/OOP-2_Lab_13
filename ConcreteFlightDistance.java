class ConcreteFlightDistance extends FlightDistance {
    @Override
    public String toString(int i) {
        return "Flight Distance Object #" + i;
    }

    @Override
    public String[] calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double earthRadius = 6371.0; // Radius of the Earth in kilometers
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = earthRadius * c;

        String[] result = {
            "Approximate Distance: " + distance + " km",
            "Note: Actual distance may vary due to flight paths."
        };
        return result;
    }
}