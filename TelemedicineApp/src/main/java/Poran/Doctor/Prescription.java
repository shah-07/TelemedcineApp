package Poran.Doctor;

public class Prescription {
    private final String name, gender;
    private final int age;
    private String medicines;

    public Prescription(String name, String gender, int age, String medicines) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.medicines = medicines;
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

    public String getGender() {
        return gender;
    }
}
