package service;

import model.*;
import java.util.ArrayList;

public class PaymentService {

    private ArrayList<Payment> payments = new ArrayList<>();
    private int paymentCounter = 1;

    // ---------------------------------
    // Make Payment (Customer)
    // ---------------------------------
    public Payment makePayment(Booking booking, String paymentMode) {

        if (!booking.getStatus().equals("ACTIVE")) {
            System.out.println("Payment allowed only for ACTIVE bookings.");
            return null;
        }

        Payment payment = new Payment(
                paymentCounter++,
                booking,
                booking.getTotalPrice(),
                paymentMode
        );

        payments.add(payment);
        System.out.println("Payment successful.");
        return payment;
    }

    // ---------------------------------
    // View All Payments (Admin)
    // ---------------------------------
    public void viewAllPayments() {
        if (payments.isEmpty()) {
            System.out.println("No payments available.");
            return;
        }

        for (Payment p : payments) {
            printPayment(p);
        }
    }

    // ---------------------------------
    // View Payments by Booking ID
    // ---------------------------------
    public void viewPaymentsByBooking(int bookingId) {
        boolean found = false;

        for (Payment p : payments) {
            if (p.getBooking().getBookingId() == bookingId) {
                printPayment(p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No payments found for this booking.");
        }
    }

    // ---------------------------------
    // View Payments by Customer ID
    // ---------------------------------
    public void viewPaymentsByCustomer(int customerId) {
        boolean found = false;

        for (Payment p : payments) {
            if (p.getBooking()
                 .getCustomer()
                 .getCustomerId() == customerId) {

                printPayment(p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No payments found for this customer.");
        }
    }

    // ---------------------------------
    // Helper Method
    // ---------------------------------
    private void printPayment(Payment p) {
        System.out.println(
                "Payment ID: " + p.getPaymentId() +
                ", Booking ID: " + p.getBooking().getBookingId() +
                ", Customer: " + p.getBooking().getCustomer().getName() +
                ", Amount: ₹" + p.getAmount() +
                ", Mode: " + p.getPaymentMode() +
                ", Status: " + p.getStatus() +
                ", Date: " + p.getPaymentDate()
        );
    }

    // ---------------------------------
    // Return list (optional)
    // ---------------------------------
    public ArrayList<Payment> getAllPayments() {
        return payments;
    }
}
