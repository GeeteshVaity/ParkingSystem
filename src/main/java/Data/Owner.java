package Data;

public class Owner {
    int ownerId;
    public String firstname;
    public String lastname;
    public String phone;
    public String email;


    public Owner(int ownerId) {
        this.ownerId = ownerId;
    }

    public Owner(String firstname, String lastname, String phone, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
    }


    public Owner(int ownerId, String firstname, String lastname, String phone, String email) {
        this.ownerId = ownerId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
    }


}