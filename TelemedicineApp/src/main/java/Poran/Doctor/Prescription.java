package Poran.Doctor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Prescription implements Serializable {
    private String name, gender, notes, diagnosis;
    private ArrayList<String> medicines;
    private int age;
    private LocalDate date;
    private LocalTime time;
    private boolean prescribed = false;

    public Prescription(String name, String gender, int age, ArrayList<String> medicines, String diagnosis, LocalDate date, LocalTime time, String notes) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.medicines = new ArrayList<String>(medicines);
        this.diagnosis = diagnosis;
        this.date = date;
        this.time = time;
        this.notes = notes;
    }

    public ArrayList<String> getMedicines() {
        return medicines;
    }

    public void setMedicines(ArrayList<String> medicines) {
        this.medicines = medicines;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isPrescribed() {
        return prescribed;
    }

    public void setPrescribed(boolean prescribed) {
        this.prescribed = prescribed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotesString (String notes) {
        this.notes = notes;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
