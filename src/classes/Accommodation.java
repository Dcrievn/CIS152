package classes;

/**
 * @author Eric Dam
 * @version 1.0
 * @since 1.0
 */
public class Accommodation {
	private String name;
	private String location;
	private double pricePerNight;

	public Accommodation(String name, String location, double pricePerNight) {
	        this.name = name;
	        this.location = location;
	        this.pricePerNight = pricePerNight;
	    }

	// Getters for the Accommodation attributes
	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	// Display accommodation details
	public String displayAccommodationDetails() {
		return "Accommodation: " + name + "\nLocation: " + location + "\nPrice per Night: $" + pricePerNight;
	}
}
