package Imtia;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private final String name;
    private final int id;
    private int age;
    private LocalDate dateOfAppointment;
    private LocalTime timeOfAppointment;

    public Appointment(String name, int id, int age, LocalTime timeOfAppointment, LocalDate dateOfAppointment) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.timeOfAppointment = timeOfAppointment;
        this.dateOfAppointment = dateOfAppointment;
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
