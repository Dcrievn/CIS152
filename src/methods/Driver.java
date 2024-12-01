package methods;

import classes.Activity;
import classes.Trip;

/**
 * @author Eric Dam
 * @version 1.0
 * @since 1.0
 */
public class Driver {
	public static void main(String[] args) {
		Trip trip = new Trip("Paris", "2024-05-01", "2024-05-10");

		trip.addActivity(new Activity("Visit Louvre", "09:00", 120, 15.00));
		trip.addActivity(new Activity("Eiffel Tower Climb", "14:00", 90, 25.00));
		trip.addActivity(new Activity("Seine River Cruise", "11:00", 60, 20.00));

		System.out.println("Activities before sorting:");
		for (Activity activity : trip.getActivities()) {
			System.out.println(activity);
		}

		trip.sortActivitiesByStartTime();

		System.out.println("\nActivities after sorting:");
		for (Activity activity : trip.getActivities()) {
			System.out.println(activity);
		}
	}
}
