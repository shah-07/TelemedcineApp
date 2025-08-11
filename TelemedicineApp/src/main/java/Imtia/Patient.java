package Imtia;


import mainpackage.telemedicineapp.User;

import java.time.LocalDate;

public class Patient extends User {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Patient(String name, int id, LocalDate dateOfBirth, int age) {
        super(name, id, dateOfBirth);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "age=" + age +
                '}';
    }
}















