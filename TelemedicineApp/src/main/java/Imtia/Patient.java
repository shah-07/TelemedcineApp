package Imtia;


import mainpackage.telemedicineapp.User;

import java.time.LocalDate;

public class Patient extends User {
    private int age;

    public Patient(String name, int id, String password, LocalDate dateOfBirth, int age) {
        super(name, id, password, dateOfBirth);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}















