package Imtia;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
<<<<<<< HEAD
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
=======
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
>>>>>>> 3dd83f01c10ba8edd438b797916d1ab4a665a423
    }

    public String getName() {
        return name;
    }

<<<<<<< HEAD
=======
    public String getReason() {
        return reason;
    }

>>>>>>> 3dd83f01c10ba8edd438b797916d1ab4a665a423
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
<<<<<<< HEAD
=======
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
>>>>>>> 3dd83f01c10ba8edd438b797916d1ab4a665a423
    }
}
