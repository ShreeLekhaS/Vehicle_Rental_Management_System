package service;

import model.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class BookingService {

    private ArrayList<Booking> bookings = new ArrayList<>();
    private int bookingCounter = 1;

    // ---------------------------------
    // Create Booking (Customer)
    // ---------------------------------
    public Booking createBooking(Customer customer,
                                 Vehicle vehicle,
                                 LocalDate startDate,
                                 LocalDate endDate) {

        if (!vehicle.isAvailable()) {
            System.out.println("Vehicle is not available.");
            return null;
        }

        Booking booking = new Booking(
                bookingCounter++,
                customer,
                vehicle,
                startDate,
                endDate
        );

        bookings.add(booking);
        System.out.println("Booking created successfully.");
        return booking;
    }

    // ---------------------------------
    // Get Active Booking by ID
    // ---------------------------------
    public Booking getActiveBookingById(int bookingId) {
        for (Booking b : bookings) {
            if (b.getBookingId() == bookingId
                    && b.getStatus().equals("ACTIVE")) {
                return b;
            }
        }
        return null;
    }

    // ---------------------------------
    // Complete Booking (Admin)
    // ---------------------------------
    public boolean completeBooking(int bookingId) {
        Booking booking = getActiveBookingById(bookingId);

        if (booking != null) {
            booking.complete();
            System.out.println("Booking completed successfully.");
            return true;
        }

        System.out.println("Active booking not found.");
        return false;
    }

    // ---------------------------------
    // Cancel Booking (Admin)
    // ---------------------------------
    public boolean cancelBooking(int bookingId) {
        for (Booking b : bookings) {
            if (b.getBookingId() == bookingId
                    && b.getStatus().equals("ACTIVE")) {

                b.getVehicle().setAvailable(true);
                setStatusCancelled(b);
                System.out.println("Booking cancelled successfully.");
                return true;
            }
        }

        System.out.println("Active booking not found.");
        return false;
    }

    // helper method
    private void setStatusCancelled(Booking booking) {
        try {
            java.lang.reflect.Field status =
                    Booking.class.getDeclaredField("status");
            status.setAccessible(true);
            status.set(booking, "CANCELLED");
        } catch (Exception e) {
            System.out.println("Error cancelling booking.");
        }
    }

    // ---------------------------------
    // View All Bookings (Admin)
    // ---------------------------------
    public void viewAllBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }

        for (Booking b : bookings) {
            printBooking(b);
        }
    }

    // ---------------------------------
    // View Bookings by Customer (Admin)
    // ---------------------------------
    public void viewBookingsByCustomer(int customerId) {
        boolean found = false;

        for (Booking b : bookings) {
            if (b.getCustomer().getCustomerId() == customerId) {
                printBooking(b);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No bookings found for this customer.");
        }
    }

    // ---------------------------------
    // View Active Bookings
    // ---------------------------------
    public void viewActiveBookings() {
        for (Booking b : bookings) {
            if (b.getStatus().equals("ACTIVE")) {
                printBooking(b);
            }
        }
    }

    // ---------------------------------
    // View Bookings by Status
    // ---------------------------------
    public void viewBookingsByStatus(String status) {
        for (Booking b : bookings) {
            if (b.getStatus().equalsIgnoreCase(status)) {
                printBooking(b);
            }
        }
    }

    // ---------------------------------
    // Print Booking Details
    // ---------------------------------
    private void printBooking(Booking b) {
        System.out.println(
                "Booking ID: " + b.getBookingId() +
                ", Customer: " + b.getCustomer().getName() +
                ", Vehicle: " + b.getVehicle().getVehicleNumber() +
                ", From: " + b.getStartDate() +
                ", To: " + b.getEndDate() +
                ", Days: " + b.getDuration() +
                ", Total: ₹ " + b.getTotalPrice() +
                ", Status: " + b.getStatus()
        );
    }

    // ---------------------------------
    // Return list (optional)
    // ---------------------------------
    public ArrayList<Booking> getAllBookings() {
        return bookings;
    }
}
