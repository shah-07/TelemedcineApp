package Imtia;

import java.time.LocalDate;
import java.time.LocalTime;

public class CreateAppointmentModel {
    private String name;
    private String gender;
    private LocalDate date;
    private String time;
    private int age;
    private String doctorName;

    public CreateAppointmentModel(String name, String gender, LocalDate date, String time, int age, String doctorName) {
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.time = time;
        this.age = age;
        this.doctorName = doctorName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
