package service;

import model.Vehicle;
import java.util.ArrayList;
import java.util.Iterator;

public class VehicleService {

    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    // -------------------------------
    // Add Vehicle (Admin)
    // -------------------------------
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println("Vehicle added successfully.");
    }

    // -------------------------------
    // View All Vehicles (Admin)
    // -------------------------------
    public void viewAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.");
            return;
        }

        for (Vehicle v : vehicles) {
            System.out.println(
                "ID: " + v.getVehicleId() +
                ", Number: " + v.getVehicleNumber() +
                ", Type: " + v.getType() +
                ", Brand: " + v.getBrand() +
                ", Model: " + v.getModel() +
                ", Price/Day: " + v.getPricePerDay() +
                ", Available: " + v.isAvailable()
            );
        }
    }

    // -------------------------------
    // Get Available Vehicles
    // -------------------------------
    public ArrayList<Vehicle> getAvailableVehicles() {
        ArrayList<Vehicle> availableList = new ArrayList<>();

        for (Vehicle v : vehicles) {
            if (v.isAvailable()) {
                availableList.add(v);
            }
        }
        return availableList;
    }

    // -------------------------------
    // Find Vehicle by ID
    // -------------------------------
    public Vehicle getVehicleById(int id) {
        for (Vehicle v : vehicles) {
            if (v.getVehicleId() == id) {
                return v;
            }
        }
        return null;
    }

    // -------------------------------
    // Find Available Vehicle by ID
    // -------------------------------
    public Vehicle getAvailableVehicleById(int id) {
        for (Vehicle v : vehicles) {
            if (v.getVehicleId() == id && v.isAvailable()) {
                return v;
            }
        }
        return null;
    }

    // -------------------------------
    // Update Vehicle (Admin)
    // -------------------------------
    public boolean updateVehicle(
            int vehicleId,
            String vehicleNumber,
            String type,
            String brand,
            String model,
            double pricePerDay
    ) {
        Vehicle v = getVehicleById(vehicleId);

        if (v == null) {
            System.out.println("Vehicle not found.");
            return false;
        }

        vehicles.remove(v);
        vehicles.add(new Vehicle(
                vehicleId,
                vehicleNumber,
                type,
                brand,
                model,
                pricePerDay
        ));

        System.out.println("Vehicle updated successfully.");
        return true;
    }

    // -------------------------------
    // Remove Vehicle (Admin)
    // -------------------------------
    public boolean removeVehicle(int vehicleId) {
        Iterator<Vehicle> iterator = vehicles.iterator();

        while (iterator.hasNext()) {
            Vehicle v = iterator.next();
            if (v.getVehicleId() == vehicleId) {
                iterator.remove();
                System.out.println("Vehicle removed successfully.");
                return true;
            }
        }

        System.out.println("Vehicle not found.");
        return false;
    }

    // -------------------------------
    // Return list (optional use)
    // -------------------------------
    public ArrayList<Vehicle> getAllVehicles() {
        return vehicles;
    }
}

