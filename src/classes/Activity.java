package classes;

/**
 * @author Eric Dam
 * @version 1.0
 * @since 1.0
 */
public class Activity {
	private String name;
	private String startTime;
	private int duration; // duration in minutes
	private double cost;

	public Activity(String name, String startTime, int duration, double cost) {
		this.name = name;
		this.startTime = startTime;
		this.duration = duration;
		this.cost = cost;
	}

	// Getters for the Activity attributes
	public String getName() {
		return name;
	}

	public String getStartTime() {
		return startTime;
	}

	public int getDuration() {
		return duration;
	}

	public double getCost() {
		return cost;
	}

	@Override
	public String toString() {
		return "Activity: " + name + "\nStart Time: " + startTime + "\nDuration: " + duration + " mins" + "\nCost: $"
				+ String.format("%.2f", cost);
	}
}
