package Data;

import java.time.LocalDateTime;

/**
 * Represents a ParkingArea entity, mapped to the 'ParkingArea' SQL table.
 * This tracks specific parking slots, their location block, and the last time
 * they were updated or occupied/freed.
 */
public class ParkingArea {
    // Attributes mapped from the SQL table columns:

    /** Primary Key: Parking Slot Number (Slot_No) */
    private int slotNo;

    /** Parking Block Identifier (P_block) */
    private String block;

    /** Timestamp of the last action/status change (Date_time) */
    private LocalDateTime dateTime;

    /** Foreign Key: Reference to the Parking location ID (P_id) */
    private int parkingId;

    /**
     * Full constructor for the ParkingArea entity.
     *
     * @param slotNo The unique number of the parking slot (Primary Key).
     * @param block The block or section where the slot is located (e.g., 'A', 'B1').
     * @param dateTime The date and time associated with the slot's current status.
     * @param parkingId The ID linking this slot to a larger Parking location.
     */
    public ParkingArea(int slotNo, String block, LocalDateTime dateTime, int parkingId) {
        this.slotNo = slotNo;
        this.block = block;
        this.dateTime = dateTime;
        this.parkingId = parkingId;
    }

    // --- Getters ---

    public int getSlotNo() {
        return slotNo;
    }

    public String getBlock() {
        return block;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getParkingId() {
        return parkingId;
    }

    // --- Setters ---

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setParkingId(int parkingId) {
        this.parkingId = parkingId;
    }
}
