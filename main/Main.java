package main;

import model.*;
import service.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // -------------------------------
        // Services
        // -------------------------------
        AdminService adminService = new AdminService();
        CustomerService customerService = new CustomerService();
        VehicleService vehicleService = new VehicleService();
        BookingService bookingService = new BookingService();
        PaymentService paymentService = new PaymentService();

        System.out.println("==================================");
        System.out.println(" VEHICLE RENTAL MANAGEMENT SYSTEM ");
        System.out.println("==================================");

        while (true) {
            System.out.println("\n1. Admin Login");
            System.out.println("2. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Username: ");
                String username = sc.next();
                System.out.print("Password: ");
                String password = sc.next();

                Admin admin = adminService.login(username, password);

                if (admin == null) {
                    System.out.println("Invalid credentials!");
                    continue;
                }

                System.out.println("Welcome, " + admin.getName());

                // -------------------------------
                // Admin Menu
                // -------------------------------
                boolean adminLoop = true;
                while (adminLoop) {

                    System.out.println("\n--- ADMIN MENU ---");
                    System.out.println("1. Add Vehicle");
                    System.out.println("2. View Vehicles");
                    System.out.println("3. Add Customer");
                    System.out.println("4. View Customers");
                    System.out.println("5. Create Booking");
                    System.out.println("6. Complete Booking");
                    System.out.println("7. Cancel Booking");
                    System.out.println("8. View All Bookings");
                    System.out.println("9. Make Payment");
                    System.out.println("10. View All Payments");
                    System.out.println("11. Logout");
                    System.out.print("Choose: ");

                    int adminChoice = sc.nextInt();

                    switch (adminChoice) {

                        case 1: // Add Vehicle
                            System.out.print("Vehicle ID: ");
                            int vid = sc.nextInt();
                            System.out.print("Vehicle Number: ");
                            String vno = sc.next();
                            System.out.print("Type (Car/Bike): ");
                            String type = sc.next();
                            System.out.print("Brand: ");
                            String brand = sc.next();
                            System.out.print("Model: ");
                            String model = sc.next();
                            System.out.print("Price per day: ");
                            double price = sc.nextDouble();

                            vehicleService.addVehicle(
                                    new Vehicle(vid, vno, type, brand, model, price)
                            );
                            break;

                        case 2: // View Vehicles
                            vehicleService.viewAllVehicles();
                            break;

                        case 3: // Add Customer
                            System.out.print("Customer ID: ");
                            int cid = sc.nextInt();
                            System.out.print("Name: ");
                            String cname = sc.next();
                            System.out.print("Phone: ");
                            String phone = sc.next();
                            System.out.print("Email: ");
                            String email = sc.next();
                            System.out.print("Age: ");
                            int age = sc.nextInt();
                            System.out.print("Address: ");
                            String address = sc.next();

                            customerService.addCustomer(
                                    new Customer(cid, cname, phone, email, age, address)
                            );
                            break;

                        case 4: // View Customers
                            customerService.viewAllCustomers();
                            break;

                        case 5: // Create Booking
                            System.out.print("Customer ID: ");
                            int bcustId = sc.nextInt();
                            Customer customer = customerService.getCustomerById(bcustId);

                            if (customer == null) {
                                System.out.println("Customer not found.");
                                break;
                            }

                            System.out.print("Vehicle ID: ");
                            int bvid = sc.nextInt();
                            Vehicle vehicle = vehicleService.getAvailableVehicleById(bvid);

                            if (vehicle == null) {
                                System.out.println("Vehicle not available.");
                                break;
                            }

                            System.out.print("Start Date (YYYY-MM-DD): ");
                            LocalDate start = LocalDate.parse(sc.next());
                            System.out.print("End Date (YYYY-MM-DD): ");
                            LocalDate end = LocalDate.parse(sc.next());

                            bookingService.createBooking(customer, vehicle, start, end);
                            break;

                        case 6: // Complete Booking
                            System.out.print("Booking ID: ");
                            int cbid = sc.nextInt();
                            bookingService.completeBooking(cbid);
                            break;

                        case 7: // Cancel Booking
                            System.out.print("Booking ID: ");
                            int cancelId = sc.nextInt();
                            bookingService.cancelBooking(cancelId);
                            break;

                        case 8: // View Bookings
                            bookingService.viewAllBookings();
                            break;

                        case 9: // Make Payment
                            System.out.print("Booking ID: ");
                            int pbid = sc.nextInt();
                            Booking booking = bookingService.getActiveBookingById(pbid);

                            if (booking == null) {
                                System.out.println("Active booking not found.");
                                break;
                            }

                            System.out.print("Payment Mode (CASH/CARD/UPI): ");
                            String mode = sc.next();

                            paymentService.makePayment(booking, mode);
                            break;

                        case 10: // View Payments
                            paymentService.viewAllPayments();
                            break;

                        case 11:
                            adminLoop = false;
                            System.out.println("Logged out.");
                            break;

                        default:
                            System.out.println("Invalid option.");
                    }
                }

            } else if (choice == 2) {
                System.out.println("Thank you for using the system!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
