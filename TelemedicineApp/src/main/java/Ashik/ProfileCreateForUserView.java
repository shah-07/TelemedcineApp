package Ashik;

public class ProfileCreateForUserView {
    private String name ;
    private String email;
    private String role ;
    private String specialist ;
    private float fees;
    private String contactNumber;
    private String licenseNumber;
    private String status;

    public ProfileCreateForUserView(String name, String email, String role, String specialist, float fees, String contactNumber) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.specialist = specialist;
        this.fees = fees;
        this.contactNumber = contactNumber;
        this.licenseNumber = licenseNumber;
        this.status = status;
    }

    public ProfileCreateForUserView(String name, String mail, String doctor, String cardiologist, int fees, String pending) {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getSpecialist() {
        return specialist;
    }

    public float getFees() {
        return fees;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
