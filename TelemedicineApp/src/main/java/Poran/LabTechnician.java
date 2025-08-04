package Poran;

import mainpackage.telemedicineapp.User;

import java.time.LocalDate;

public class LabTechnician extends User {
    private String position;

    public LabTechnician(String name, int id, LocalDate dateOfBirth, String position) {
        super(name, id, dateOfBirth);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}