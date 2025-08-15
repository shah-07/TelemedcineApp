package Ashik;

import java.io.Serializable;

public class UserSOverview implements Serializable {
    private String username;
    private String password;
    private int activeDoctors;
    private int activePatients;

    public UserSOverview(String username, String password, int activeDoctors, int activePatients) {
        this.username = username;
        this.password = password;
        this.activeDoctors = activeDoctors;
        this.activePatients = activePatients;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActiveDoctors() {
        return activeDoctors;
    }

    public void setActiveDoctors(int activeDoctors) {
        this.activeDoctors = activeDoctors;
    }

    public int getActivePatients() {
        return activePatients;
    }

    public void setActivePatients(int activePatients) {
        this.activePatients = activePatients;
    }
}
