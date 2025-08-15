package Imtia;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private final String name, reason;
    private int age, bill;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;

    public Appointment(String name, String reason, int age, int bill, LocalDate appointmentDate, LocalTime appointmentTime) {
        this.name = name;
        this.reason = reason;
        this.age = age;
        this.bill = bill;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    public String getName() {
        return name;
    }

    public String getReason() {
        return reason;
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

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}
