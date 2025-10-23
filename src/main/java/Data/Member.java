package Data;

/**
 * Represents a Member entity, mapped directly to the 'Member' SQL table.
 * This class matches your database schema.
 */
public class Member {
    // Attributes mapped from the SQL table columns:

    /** Primary Key: Member ID (M_id) */
    private int id;

    /** Member First Name (M_Fname) */
    private String firstName;

    /** Member Last Name (M_Lname) */
    private String lastName;

    /** Member Contact Number (M_contactNo) */
    private String contactNo;

    /** Member Address (M_address) */
    private String address;

    /** Member Password (password) - Your schema showed this as an INT */
    private int password;

    /**
     * Full constructor for the Member entity.
     */
    public Member(int id, String firstName, String lastName, String contactNo, String address, int password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNo = contactNo;
        this.address = address;
        this.password = password;
    }

    /**
     * Constructor without ID (for creating new members where ID might be auto-incremented)
     */
    public Member(String firstName, String lastName, String contactNo, String address, int password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNo = contactNo;
        this.address = address;
        this.password = password;
    }

    // --- Getters ---

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getAddress() {
        return address;
    }

    public int getPassword() {
        return password;
    }

    // --- Setters ---

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
