package Data;

public class Vehicle {
    public String licenseplate;
    public int vehicleId;
    public String licensePlate;
    public String type;
    public Owner owner;


    public Vehicle(int vehicleId, String licensePlate, String type, Owner owner) {
        this.vehicleId = vehicleId;
        this.licensePlate = licensePlate;
        this.type = type;
        this.owner = owner;
    }

    public Vehicle(String licensePlate, String type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    // Getters and setters would go here.
}