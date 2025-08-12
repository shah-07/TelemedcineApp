package Poran.Doctor;

import java.time.LocalDate;
import java.time.LocalTime;

public class Prescription {
    private final String name, gender;
    private int age;
    private String medicines, diagnosis;
    private LocalDate date;
    private LocalTime time;

    public Prescription(String name, String gender, int age, String medicines, String diagnosis, LocalDate date) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.medicines = medicines;
        this.diagnosis = diagnosis;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
