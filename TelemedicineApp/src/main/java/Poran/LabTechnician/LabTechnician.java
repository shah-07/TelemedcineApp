package Poran.LabTechnician;

import mainpackage.telemedicineapp.User;

import java.io.Serializable;
import java.time.LocalDate;

public class LabTechnician extends User implements Serializable {
    private String position;

    public LabTechnician(String name, int id, String password, LocalDate dateOfBirth, String position) {
        super(name, id, password, dateOfBirth);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}