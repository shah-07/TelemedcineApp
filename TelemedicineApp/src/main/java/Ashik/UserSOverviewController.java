package Ashik;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UserSOverviewController {

    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField activeDoctorTextField;
    @FXML
    private TextField activePatientTextField;

    private UserSOverview overview;

    @FXML
    public void initialize() {
        activeDoctorTextField.setEditable(false);
        activePatientTextField.setEditable(false);
    }

    @FXML
    public void loginButtonOnAction(ActionEvent actionEvent) {
        String username = usernameTextField.getText().trim();
        String password = passwordTextField.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            activeDoctorTextField.setText("");
            activePatientTextField.setText("");
            System.out.println("Please enter username and password.");
            return;
        }

        if (!authenticateCEO(username, password)) {
            activeDoctorTextField.setText("");
            activePatientTextField.setText("");
            System.out.println("Invalid username or password.");
            return;
        }

        int activeDoctors = fetchActiveDoctorsCount();
        int activePatients = fetchActivePatientsCount();

        overview = new UserSOverview(username, password, activeDoctors, activePatients);

        activeDoctorTextField.setText(String.valueOf(activeDoctors));
        activePatientTextField.setText(String.valueOf(activePatients));
        System.out.println("Login successful!! Active user counts displayed.");
    }

    // Dummy CEO authentication
    private boolean authenticateCEO(String username, String password) {
        return username.equals("ceo") && password.equals("ceo123");
    }

    // Dummy fetch methods (replace with DB logic)
    private int fetchActiveDoctorsCount() {
        return 15; // Example value
    }

    private int fetchActivePatientsCount() {
        return 120; // Example value
    }
}
