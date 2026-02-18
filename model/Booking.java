package model;

import java.time.LocalDate;

public class Booking {

    private int bookingId;
    private Customer customer;
    private Vehicle vehicle;

    private LocalDate startDate;
    private LocalDate endDate;

    private int duration;        // number of days
    private double totalPrice;   // calculated price
    private String status;       // ACTIVE / COMPLETED / CANCELLED

    public Booking(int bookingId, Customer customer, Vehicle vehicle,
                   LocalDate startDate, LocalDate endDate) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;

        this.duration = (int) (endDate.toEpochDay() - startDate.toEpochDay());
        this.totalPrice = duration * vehicle.getPricePerDay();
        this.status = "ACTIVE";

        vehicle.setAvailable(false);
    }

    public int getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getDuration() {
        return duration;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void complete() {
        status = "COMPLETED";
        vehicle.setAvailable(true);
    }
}

