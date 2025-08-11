package Imtia;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private final String name;
    private final int id;
    private int age, bill;
    private LocalDate dateOfAppointment;
    private LocalTime timeOfAppointment;

    public Appointment(String name, int id, int age, int bill, LocalDate dateOfAppointment, LocalTime timeOfAppointment) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.bill = bill;
        this.dateOfAppointment = dateOfAppointment;
        this.timeOfAppointment = timeOfAppointment;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public LocalDate getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(LocalDate dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    public LocalTime getTimeOfAppointment() {
        return timeOfAppointment;
    }

    public void setTimeOfAppointment(LocalTime timeOfAppointment) {
        this.timeOfAppointment = timeOfAppointment;
    }
}