package mainpackage.telemedicineapp;

import java.time.LocalDate;
public abstract class User {
    protected final String name;
    protected final int id;
    protected final LocalDate dateOfBirth;

    public User(String name, int id, LocalDate dateOfBirth) {
        this.name = name;
        this.id = id;
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

    protected abstract boolean updateProfile();

    public static boolean verifyLogin(String enteredId, String enteredPassword) {
        int id = Integer.parseInt(enteredId);
        return database.getPassword.equals(enteredPassword) && database.getId() == id;
    }

    public static User login(String enteredId, String enteredPassword) {
        if (verifyLogin(enteredId, enteredPassword)) {
            return user.get(Integer.parseInt(enteredId));
        } else {
            return null;
        }
    }
}