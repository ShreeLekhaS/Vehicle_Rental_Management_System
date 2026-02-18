package model;

public class Vehicle {

    private int vehicleId;
    private String vehicleNumber;
    private String type;        // Car / Bike
    private String brand;
    private String model;
    private double pricePerDay;
    private boolean available = true;

    public Vehicle(int vehicleId, String vehicleNumber, String type,
                   String brand, String model, double pricePerDay) {
        this.vehicleId = vehicleId;
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

