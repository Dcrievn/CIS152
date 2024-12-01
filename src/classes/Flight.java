package classes;

/**
 * @author Eric Dam
 * @version 1.0
 * @since 1.0
 */
public class Flight {
	private String airline;
	private String flightNumber;
	private String departureTime;
	private String arrivalTime;

	public Flight(String airline, String flightNumber, String departureTime, String arrivalTime) {
		this.airline = airline;
		this.flightNumber = flightNumber;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	// Getters for the Flight attributes
	public String getAirline() {
		return airline;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	// Display flight details
	public String displayFlightDetails() {
		return "Flight: " + airline + " " + flightNumber + "\nDeparture: " + departureTime + "\nArrival: "
				+ arrivalTime;
	}
}