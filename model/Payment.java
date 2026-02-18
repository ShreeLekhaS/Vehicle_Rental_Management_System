package model;

import java.time.LocalDate;

public class Payment {

    private int paymentId;
    private Booking booking;
    private double amount;
    private String paymentMode;     // CASH / CARD / UPI
    private String status;          // PAID / FAILED
    private LocalDate paymentDate;

    public Payment(int paymentId,
                   Booking booking,
                   double amount,
                   String paymentMode) {

        this.paymentId = paymentId;
        this.booking = booking;
        this.amount = amount;
        this.paymentMode = paymentMode;
        this.status = "PAID";              // default success
        this.paymentDate = LocalDate.now();
    }

    public int getPaymentId() {
        return paymentId;
    }

    public Booking getBooking() {
        return booking;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }
}

