package Imtia;

public class PharmacistShareUpdateToDoctorModel {
    private String doctorName;
    private String notes;

    public PharmacistShareUpdateToDoctorModel(String doctorName, String notes) {
        this.doctorName = doctorName;
        this.notes = notes;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
