package Poran.Doctor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class LabTestForm implements Serializable {

    private final String patientName, doctorName, gender;
    private int age;
    private String notes, diagnosis;
    private ArrayList<String> testList;
    private boolean completed = false;
    private final LocalDate date = LocalDate.now();
    private final LocalTime time = LocalTime.now();

    public LabTestForm(String patientName, String doctorName, String gender,String diagnosis, ArrayList<String> testList, String notes, int age) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.gender = gender;
        this.diagnosis = diagnosis;
        this.testList = new ArrayList<>(testList);
        this.notes = notes;
        this.age = age;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getTestList() {
        return testList;
    }

    public void setTestList(ArrayList<String> testList) {
        this.testList = testList;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }
}
