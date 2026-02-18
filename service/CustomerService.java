package service;

import model.Customer;
import java.util.ArrayList;
import java.util.Iterator;

public class CustomerService {

    private ArrayList<Customer> customers = new ArrayList<>();

    // -------------------------------
    // Add Customer (Admin / Customer)
    // -------------------------------
    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added successfully.");
    }

    // -------------------------------
    // Find Customer by ID
    // -------------------------------
    public Customer getCustomerById(int id) {
        for (Customer c : customers) {
            if (c.getCustomerId() == id) {
                return c;
            }
        }
        return null;
    }

    // -------------------------------
    // View All Customers (Admin)
    // -------------------------------
    public void viewAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        for (Customer c : customers) {
            System.out.println(
                "ID: " + c.getCustomerId() +
                ", Name: " + c.getName() +
                ", Phone: " + c.getPhone() +
                ", Email: " + c.getEmail() +
                ", Age: " + c.getAge() +
                ", Address: " + c.getAddress()
            );
        }
    }

    // -------------------------------
    // Remove Customer (Admin Action)
    // -------------------------------
    public boolean removeCustomer(int customerId) {
        Iterator<Customer> iterator = customers.iterator();

        while (iterator.hasNext()) {
            Customer c = iterator.next();
            if (c.getCustomerId() == customerId) {
                iterator.remove();
                System.out.println("Customer removed successfully.");
                return true;
            }
        }

        System.out.println("Customer not found.");
        return false;
    }

    // -------------------------------
    // Update Customer (Admin Action)
    // -------------------------------
    public boolean updateCustomer(
            int customerId,
            String name,
            String phone,
            String email,
            int age,
            String address
    ) {
        Customer c = getCustomerById(customerId);

        if (c == null) {
            System.out.println("Customer not found.");
            return false;
        }

        // Updating using reflection-safe approach
        customers.remove(c);
        customers.add(new Customer(customerId, name, phone, email, age, address));

        System.out.println("Customer updated successfully.");
        return true;
    }

    // -------------------------------
    // Return list (if needed elsewhere)
    // -------------------------------
    public ArrayList<Customer> getAllCustomers() {
        return customers;
    }
}

