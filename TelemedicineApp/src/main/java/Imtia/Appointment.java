package Imtia;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Appointment implements Serializable {
    private final String name, gender;
    private String reason, notes = null;
    private final int id;
    private int age, bill;
    private LocalDate dateOfAppointment;
    private LocalTime timeOfAppointment;
    private boolean prescribedMedicine = false, seen = false;


    public Appointment(String name, String gender, String reason, int id, int age, int bill, LocalDate dateOfAppointment, LocalTime timeOfAppointment) {
        this.name = name;
        this.gender = gender;
        this.reason = reason;
        this.id = id;
        this.age = age;
        this.bill = bill;
        this.dateOfAppointment = dateOfAppointment;
        this.timeOfAppointment = timeOfAppointment;
    }

    public boolean isPrescribedMedicine() {
        return prescribedMedicine;
    }


    public void setPrescribedMedicine(boolean prescribedMedicine) {
        this.prescribedMedicine = prescribedMedicine;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public String getGender() {
        return gender;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Appointment other = (Appointment) obj;
        return age == other.age &&
                Objects.equals(name, other.name) &&
                Objects.equals(gender, other.gender) &&
                Objects.equals(dateOfAppointment, other.dateOfAppointment) &&
                Objects.equals(timeOfAppointment, other.timeOfAppointment) &&
                Objects.equals(reason, other.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, age, dateOfAppointment, timeOfAppointment, reason);
    }

}