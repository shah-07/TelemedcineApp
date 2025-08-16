package mainpackage.telemedicineapp;

import java.io.Serializable;
import java.time.LocalDate;
public abstract class User implements Serializable {
    private final String name;
    private String password;
    private final int id;
    private final LocalDate dateOfBirth;

    public User(String name, int id, String password, LocalDate dateOfBirth) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}