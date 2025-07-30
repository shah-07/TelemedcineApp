package Poran_2420181;

import mainpackage.telemedicineapp.User;

import java.time.LocalDate;

public class Doctor extends User {
    private String specialized;

    public Doctor(String name, int id, LocalDate dateOfBirth, String specialized) {
        super(name, id, dateOfBirth);
        this.specialized = specialized;
    }

    public String getSpecialized() {
        return specialized;
    }

    public void setSpecialized(String specialized) {
        this.specialized = specialized;
    }
}
