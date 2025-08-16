package Imtia;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment implements Serializable {
    private final String name, gender;
    private String reason;
    private int age, bill, id;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private boolean seen = false, prescribed = false, completed = false;

    public Appointment(String name,String gender,String reason,int id ,int age, int bill, LocalDate appointmentDate, LocalTime appointmentTime) {
        this.name = name;
        this.gender = gender;
        this.reason = reason;
        this.id = id;
        this.age = age;
        this.bill = bill;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    public String getGender() {
        return gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isPrescribed() {
        return prescribed;
    }

    public void setPrescribed(boolean prescribed) {
        this.prescribed = prescribed;
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
