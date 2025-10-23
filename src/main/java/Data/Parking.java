package Data;

/**
 * Represents a Parking entity, mapped directly to the 'Parking' SQL table.
 * It includes the unique ID for the parking location and its descriptive name.
 */
public class Parking {
    // Attributes mapped from the SQL table columns:

    /** Primary Key: Parking ID (P_id) */
    private int id;

    /** Parking Area Name (P_name) */
    private String name;

    /**
     * Full constructor for the Parking entity.
     *
     * @param id The unique identifier for the parking area (Primary Key).
     * @param name The descriptive name of the parking area (e.g., "Level 1 A-Block").
     */
    public Parking(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // --- Getters ---

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // --- Setters ---

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
