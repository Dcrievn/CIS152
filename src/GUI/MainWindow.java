package GUI;

import javax.swing.*;

import classes.Accommodation;
import classes.Activity;
import classes.Flight;
import classes.Trip;

import java.awt.*;

/**
 * @author Eric Dam
 * @version 1.0
 * @since 1.0
 */
public class MainWindow extends JFrame {
	private Trip trip;
	private JTextArea itineraryDisplay;

	public MainWindow() {
		// Initialize the main window
		setTitle("Travel Itinerary Planner");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Create the Trip object
		trip = new Trip("Default Destination", "2024-01-01", "2024-01-07");

		// Create a panel for buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());

		// Add buttons for different actions
		JButton addFlightButton = new JButton("Add Flight");
		JButton addAccommodationButton = new JButton("Add Accommodation");
		JButton addActivityButton = new JButton("Add Activity");
		JButton viewItineraryButton = new JButton("View Itinerary");

		// Add listeners for button actions
		addFlightButton.addActionListener(e -> addFlight());
		addAccommodationButton.addActionListener(e -> addAccommodation());
		addActivityButton.addActionListener(e -> addActivity());
		viewItineraryButton.addActionListener(e -> viewItinerary());

		// Add buttons to the panel
		buttonPanel.add(addFlightButton);
		buttonPanel.add(addAccommodationButton);
		buttonPanel.add(addActivityButton);
		buttonPanel.add(viewItineraryButton);

		// Create a text area to display the itinerary
		itineraryDisplay = new JTextArea();
		itineraryDisplay.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(itineraryDisplay);

		// Add components to the frame
		add(buttonPanel, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
	}

	private void addFlight() {
		String airline = JOptionPane.showInputDialog(this, "Enter Airline:");
		String flightNumber = JOptionPane.showInputDialog(this, "Enter Flight Number:");
		String departureTime = JOptionPane.showInputDialog(this, "Enter Departure Time:");
		String arrivalTime = JOptionPane.showInputDialog(this, "Enter Arrival Time:");

		if (airline != null && flightNumber != null && departureTime != null && arrivalTime != null) {
			Flight flight = new Flight(airline, flightNumber, departureTime, arrivalTime);
			if (trip.addFlight(flight)) {
				JOptionPane.showMessageDialog(this, "Flight added successfully!");
			} else {
				JOptionPane.showMessageDialog(this, "Invalid input! Flight not added.");
			}
		}
	}

	private void addAccommodation() {
		String name = JOptionPane.showInputDialog(this, "Enter Accommodation Name:");
		String location = JOptionPane.showInputDialog(this, "Enter Location:");
		String pricePerNightStr = JOptionPane.showInputDialog(this, "Enter Price Per Night:");

		try {
			double pricePerNight = Double.parseDouble(pricePerNightStr);
			if (name != null && location != null) {
				Accommodation accommodation = new Accommodation(name, location, pricePerNight);
				if (trip.addAccommodation(accommodation)) {
					JOptionPane.showMessageDialog(this, "Accommodation added successfully!");
				} else {
					JOptionPane.showMessageDialog(this, "Invalid input! Accommodation not added.");
				}
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Invalid price. Please enter a number.");
		}
	}

	private void addActivity() {
		String name = JOptionPane.showInputDialog(this, "Enter Activity Name:");
		String startTime = JOptionPane.showInputDialog(this, "Enter Start Time:");
		String durationStr = JOptionPane.showInputDialog(this, "Enter Duration (in minutes):");
		String costStr = JOptionPane.showInputDialog(this, "Enter Cost:");

		try {
			int duration = Integer.parseInt(durationStr);
			double cost = Double.parseDouble(costStr);
			if (name != null && startTime != null) {
				Activity activity = new Activity(name, startTime, duration, cost);
				if (trip.addActivity(activity)) {
					JOptionPane.showMessageDialog(this, "Activity added successfully!");
				} else {
					JOptionPane.showMessageDialog(this, "Invalid input! Activity not added.");
				}
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers for duration and cost.");
		}
	}

	private void viewItinerary() {
		// Sort activities before displaying
		trip.sortActivitiesByStartTime();

		StringBuilder itinerary = new StringBuilder();
		itinerary.append(trip.displayTripDetails()).append("\n\nFlights:\n");
		for (Flight flight : trip.getFlights()) {
			itinerary.append(flight.displayFlightDetails()).append("\n");
		}

		itinerary.append("\nAccommodations:\n");
		for (Accommodation accommodation : trip.getAccommodations()) {
			itinerary.append(accommodation.displayAccommodationDetails()).append("\n");
		}

		itinerary.append("\nActivities:\n");
		for (Activity activity : trip.getActivities()) {
			itinerary.append(activity).append("\n");
		}

		// Display itinerary in the text area
		itineraryDisplay.setText(itinerary.toString());
	}
	
	public static void main(String[] args) {
		// Launch the GUI
		SwingUtilities.invokeLater(() -> {
			MainWindow mainWindow = new MainWindow();
			mainWindow.setVisible(true);
		});
	}
}
