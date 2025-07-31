package Imtia;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class PatientController
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
    private ComboBox genderCB;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void bookAppointmentOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewDoctorOA(ActionEvent actionEvent) {
    }
}