package Poran.Doctor;

import java.util.ArrayList;

public class LabTestForm {

    private final String name, gender;
    private int age;
    private String notes;
    private ArrayList<String> testList;

    public LabTestForm(String name, String gender, ArrayList<String> testList, String notes, int age) {
        this.name = name;
        this.gender = gender;
        this.testList = new ArrayList<>(testList);
        this.notes = notes;
        this.age = age;
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
