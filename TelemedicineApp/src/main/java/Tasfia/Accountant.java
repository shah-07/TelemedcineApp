package Tasfia;


import mainpackage.telemedicineapp.User;

import java.io.Serializable;
import java.time.LocalDate;

public class Accountant extends User implements Serializable {
        private String department;

        public Accountant(String name, int id, String password, LocalDate dateOfBirth, String department) {
            super(name, id, password, dateOfBirth);
            this.department = department;


        }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Accountant{" +
                "department='" + department + '\'' +
                '}';
    }
}
