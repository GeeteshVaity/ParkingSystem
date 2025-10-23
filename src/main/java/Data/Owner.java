package Data;

/**
 * Represents the owner's personal contact information.
 */
public class Owner {
    private String firstName;
    private String lastName;
    private String address;
    private String phone;

    /**
     * Constructor for the Owner object.
     */
    public Owner(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = email;
        this.phone = phone;
    }

    // --- Getters ---

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    // --- Setters ---

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
