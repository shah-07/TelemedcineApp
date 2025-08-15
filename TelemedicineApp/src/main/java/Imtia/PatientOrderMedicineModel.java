package Imtia;

public class PatientOrderMedicineModel {
    private String medicineName;
    private String address;
    private String phoneNumber;

    public PatientOrderMedicineModel(String medicineName, String address, String phoneNumber) {
        this.medicineName = medicineName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
