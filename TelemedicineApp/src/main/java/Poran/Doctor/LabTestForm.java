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
    private LocalDate date;
    private LocalTime time;


    public LabTestForm(String patientName, String doctorName, String gender, String diagnosis, ArrayList<String> testList, String notes, int age, LocalDate date, LocalTime time) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.gender = gender;
        this.diagnosis = diagnosis;
        this.testList = new ArrayList<>(testList);
        this.notes = notes;
        this.age = age;
        this.date = date;
        this.time = time;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
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

    @Override
    public String toString() {
        return
                "Patient Name: " + patientName + '\n' +
                "Doctor Name: " + doctorName + '\n' +
                "Gender: " + gender + '\n' +
                "Age: " + age +'\n' +
                "Diagnosis: " + diagnosis + '\n' +
                "Test List: " + testList + '\n'+
                "Time: " + time + '\n'+
                "Date: " + date +'\n';
    }
}
