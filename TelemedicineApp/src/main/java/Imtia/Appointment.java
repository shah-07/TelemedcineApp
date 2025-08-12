package Imtia;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Appointment implements Serializable {
    private final String name, gender;
    private final int id;
    private int age, bill;
    private LocalDate dateOfAppointment;
    private LocalTime timeOfAppointment;

    public Appointment(String name, String gender, int id, int age, int bill, LocalDate dateOfAppointment, LocalTime timeOfAppointment) {
        this.name = name;
        this.gender = gender;
        this.id = id;
        this.age = age;
        this.bill = bill;
        this.dateOfAppointment = dateOfAppointment;
        this.timeOfAppointment = timeOfAppointment;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Appointment other = (Appointment) obj;
        return age == other.age &&
                Objects.equals(name, other.name) &&
                Objects.equals(gender, other.gender) &&
                Objects.equals(dateOfAppointment, other.dateOfAppointment) &&
                Objects.equals(timeOfAppointment, other.timeOfAppointment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, age, dateOfAppointment, timeOfAppointment);
    }

}