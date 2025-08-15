package Imtia;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

public class PatientCreateAppointmentController
{
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TextField timeTF;
    @javafx.fxml.FXML
    private TextField ageTF;
    @javafx.fxml.FXML
    private DatePicker dateDP;
    @javafx.fxml.FXML
    private ComboBox<String> genderCB;
    @javafx.fxml.FXML
    private ComboBox<String> doctorNameCB;

    @javafx.fxml.FXML
    public void initialize() {
        genderCB.getItems().addAll("Male", "Female", "Other");
        doctorNameCB.getItems().addAll("Dr. Nisha", "Dr. Imtia", "Dr. Amir");
    }

    @javafx.fxml.FXML
    public void bookAppointmentOA(ActionEvent actionEvent) throws IOException {
        String name = nameTF.getText();
        String gender = genderCB.getValue();
        LocalDate date = dateDP.getValue();
        String time = timeTF.getText();
        int age = Integer.parseInt(ageTF.getText());
        String doctorName = doctorNameCB.getValue();

        if (name.isEmpty() || gender == null || date == null || time.isEmpty() || age <= 0 || doctorName == null) {
            showAlert("Please fill in all fields correctly.");
            return;
        }

        CreateAppointmentModel appointment = new CreateAppointmentModel(name, gender, date, time, age, doctorName);
        showAlert("Appointment booked successfully for " + name + " with " + doctorName);
    }
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }

    }


