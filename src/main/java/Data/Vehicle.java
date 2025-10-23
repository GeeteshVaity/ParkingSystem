package Data;

/**
 * Represents a Vehicle entity, mapped directly to the 'Vehicle' SQL table.
 * It includes details like registration, engine number, model, and a reference to a parking session.
 */
public class Vehicle {
    // Attributes mapped from the SQL table columns:

    /** Primary Key: Vehicle Registration Number (V_regNo) */
    private String regNo;

    /** Engine Number (V_engNo) */
    private String engineNo;

    /** Vehicle Make/Name (V_name) */
    private String name;

    /** Vehicle Model (V_model) */
    private String model;

    /** Foreign Key: Reference to the Parking table ID (P_id) */
    private int parkingId;

    /**
     * Full constructor for the Vehicle entity.
     *
     * @param regNo The vehicle's registration number (Primary Key).
     * @param engineNo The vehicle's engine number (required).
     * @param name The manufacturer's name or vehicle make.
     * @param model The specific model of the vehicle.
     * @param parkingId The ID linking this vehicle to a specific parking session.
     */
    public Vehicle(String regNo, String engineNo, String name, String model, int parkingId) {
        this.regNo = regNo;
        this.engineNo = engineNo;
        this.name = name;
        this.model = model;
        this.parkingId = parkingId;
    }

    // --- Getters ---

    public String getRegNo() {
        return regNo;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public int getParkingId() {
        return parkingId;
    }

    // --- Setters ---

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setParkingId(int parkingId) {
        this.parkingId = parkingId;
    }
}
