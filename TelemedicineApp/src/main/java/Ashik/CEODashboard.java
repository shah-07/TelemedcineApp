package Ashik;

import mainpackage.telemedicineapp.User;
import java.io.Serializable;
import java.time.LocalDate;

public class CEODashboard extends User implements Serializable {
    private String designation;

    public CEODashboard(String name, int id, String password, LocalDate dateOfBirth, String designation) {
        super(name, id, password, dateOfBirth);
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

}
