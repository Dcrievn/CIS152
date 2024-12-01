package classes;
import java.util.ArrayList;

/**
 * @author Eric Dam
 * @version 1.0
 * @since 1.0
 */
public class Trip {
    private String destination;
    private String startDate;
    private String endDate;
    private ArrayList<Flight> flights;
    private ArrayList<Accommodation> accommodations;
    private ArrayList<Activity> activities;

    public Trip(String destination, String startDate, String endDate) {
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.flights = new ArrayList<>();
        this.accommodations = new ArrayList<>();
        this.activities = new ArrayList<>();
    }

    // Getters
    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public ArrayList<Accommodation> getAccommodations() {
        return accommodations;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    // Adding flight with validation
    public boolean addFlight(Flight flight) {
        if (flight.getAirline() == null || flight.getAirline().isEmpty()) return false;
        if (flight.getFlightNumber() == null || flight.getFlightNumber().isEmpty()) return false;
        if (flight.getDepartureTime() == null || flight.getDepartureTime().isEmpty()) return false;
        if (flight.getArrivalTime() == null || flight.getArrivalTime().isEmpty()) return false;

        flights.add(flight);
        return true;
    }

    // Adding accommodation with validation
    public boolean addAccommodation(Accommodation accommodation) {
        if (accommodation.getName() == null || accommodation.getName().isEmpty()) return false;
        if (accommodation.getLocation() == null || accommodation.getLocation().isEmpty()) return false;
        if (accommodation.getPricePerNight() < 0) return false;

        accommodations.add(accommodation);
        return true;
    }

    // Adding activity with validation
    public boolean addActivity(Activity activity) {
        if (activity.getName() == null || activity.getName().isEmpty()) return false;
        if (activity.getStartTime() == null || activity.getStartTime().isEmpty()) return false;
        if (activity.getDuration() <= 0) return false;
        if (activity.getCost() < 0) return false;

        activities.add(activity);
        return true;
    }

    // Sorting activities by start time using insertion sort
    public void sortActivitiesByStartTime() {
        int n = activities.size();

        for (int i = 1; i < n; i++) {
            Activity key = activities.get(i);
            int j = i - 1;

            while (j >= 0 && activities.get(j).getStartTime().compareTo(key.getStartTime()) > 0) {
                activities.set(j + 1, activities.get(j));
                j = j - 1;
            }
            activities.set(j + 1, key);
        }
    }

    public String displayTripDetails() {
        return "Destination: " + destination + "\nStart Date: " + startDate + "\nEnd Date: " + endDate;
    }
}
