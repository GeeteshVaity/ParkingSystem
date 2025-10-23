package Data;

import java.time.LocalDateTime;

/**
 * Represents a ParkingTime entity, mapped to the 'ParkingTime' SQL table.
 * This tracks the temporal details of a parking session, including entry and exit times,
 * and foreign keys linking to the Member, Vehicle, and ParkingArea.
 */
public class ParkingTime {
    // Attributes mapped from the SQL table columns:

    /** Primary Key: Parking Time ID (Pt_id) */
    private int id;

    /** Foreign Key: Reference to the Member ID (M_id) */
    private int memberId;

    /** Foreign Key: Reference to the Vehicle Registration Number (V_regNo) */
    private String vehicleRegNo;

    /** Foreign Key: Reference to the Parking Slot Number (Slot_No) */
    private int slotNo;

    /** Entry Time of the vehicle (InTime) - Cannot be null */
    private LocalDateTime inTime;

    /** Exit Time of the vehicle (OutTime) - Can be null */
    private LocalDateTime outTime;

    /**
     * Full constructor for the ParkingTime entity.
     *
     * @param id The unique identifier for this parking session (Primary Key).
     * @param memberId The ID of the member associated with this session.
     * @param vehicleRegNo The registration number of the vehicle.
     * @param slotNo The number of the parking slot used.
     * @param inTime The exact date and time the vehicle entered the spot.
     * @param outTime The exact date and time the vehicle left the spot (can be null for active sessions).
     */
    public ParkingTime(int id, int memberId, String vehicleRegNo, int slotNo, LocalDateTime inTime, LocalDateTime outTime) {
        this.id = id;
        this.memberId = memberId;
        this.vehicleRegNo = vehicleRegNo;
        this.slotNo = slotNo;
        this.inTime = inTime;
        this.outTime = outTime;
    }

    /**
     * Constructor for an active parking session (when OutTime is not yet known).
     *
     * @param id The unique identifier for this parking session (Primary Key).
     * @param memberId The ID of the member associated with this session.
     * @param vehicleRegNo The registration number of the vehicle.
     * @param slotNo The number of the parking slot used.
     * @param inTime The exact date and time the vehicle entered the spot.
     */
    public ParkingTime(int id, int memberId, String vehicleRegNo, int slotNo, LocalDateTime inTime) {
        this(id, memberId, vehicleRegNo, slotNo, inTime, null);
    }

    // --- Getters ---

    public int getId() {
        return id;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getVehicleRegNo() {
        return vehicleRegNo;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public LocalDateTime getInTime() {
        return inTime;
    }

    public LocalDateTime getOutTime() {
        return outTime;
    }

    // --- Setters ---

    public void setId(int id) {
        this.id = id;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setVehicleRegNo(String vehicleRegNo) {
        this.vehicleRegNo = vehicleRegNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }

    public void setInTime(LocalDateTime inTime) {
        this.inTime = inTime;
    }

    public void setOutTime(LocalDateTime outTime) {
        this.outTime = outTime;
    }
}
