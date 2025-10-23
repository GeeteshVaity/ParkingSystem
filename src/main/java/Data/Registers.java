package Data;

/**
 * Represents the Registers junction entity, mapped to the 'Registers' SQL table.
 * This table manages the many-to-many relationship between a Member and a Vehicle,
 * where the composite primary key consists of the two foreign keys.
 */
public class Registers {
    // Attributes mapped from the SQL table columns (Composite Primary Key):

    /** Foreign Key: Reference to the Member ID (M_id) */
    private int memberId;

    /** Foreign Key: Reference to the Vehicle Registration Number (V_regNo) */
    private String vehicleRegNo;

    /**
     * Full constructor for the Registers entity.
     *
     * @param memberId The ID of the member.
     * @param vehicleRegNo The registration number of the vehicle.
     */
    public Registers(int memberId, String vehicleRegNo) {
        this.memberId = memberId;
        this.vehicleRegNo = vehicleRegNo;
    }

    // --- Getters ---

    public int getMemberId() {
        return memberId;
    }

    public String getVehicleRegNo() {
        return vehicleRegNo;
    }

    // --- Setters ---

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setVehicleRegNo(String vehicleRegNo) {
        this.vehicleRegNo = vehicleRegNo;
    }
}
