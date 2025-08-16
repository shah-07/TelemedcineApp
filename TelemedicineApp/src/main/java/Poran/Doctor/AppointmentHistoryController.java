package Poran.Doctor;

import Imtia.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentHistoryController
{
    @javafx.fxml.FXML
    private TableColumn<Prescription, LocalTime> timeTC;
    @javafx.fxml.FXML
    private TableColumn<Prescription, String> nameTC;
    @javafx.fxml.FXML
    private TextField toTimeTF;
    @javafx.fxml.FXML
    private TableColumn<Prescription, Integer> ageTC;
    @javafx.fxml.FXML
    private TableColumn<Prescription, String> diagnosisTC;
    @javafx.fxml.FXML
    private DatePicker dateDP;
    @javafx.fxml.FXML
    private TableColumn<Prescription, LocalDate> dateTC;
    @javafx.fxml.FXML
    private TableView<Prescription> appointmentTV;
    @javafx.fxml.FXML
    private TextField fromTimeTF;

    @javafx.fxml.FXML
    private Label errorMessageLabel;
    @javafx.fxml.FXML
    private Label successMessageLabel;

    @javafx.fxml.FXML
    public void initialize() {

        timeTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageTC.setCellValueFactory(new PropertyValueFactory<>("age"));
        diagnosisTC.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));

    }

    @javafx.fxml.FXML
    public void loadAppointmentButtonOA(ActionEvent actionEvent) {

        if (dateDP.getValue() == null || fromTimeTF.getText().isEmpty() || toTimeTF.getText().isEmpty()) {
            errorMessageLabel.setText("Please select Data and TIme");
            return;
        }

        successMessageLabel.setText("");
        errorMessageLabel.setText("");
        appointmentTV.getItems().clear();
        boolean found = false;
        LocalTime fromTime = LocalTime.parse(fromTimeTF.getText());
        LocalTime toTime = LocalTime.parse(toTimeTF.getText());

        ObservableList<Prescription> prescriptionList = GenericFileManager.readAll(Prescription.class, "Prescription.bin");

        if(fromTime.isAfter(toTime)){
            errorMessageLabel.setText("From time cannot be greater than To time");
            return;
        }

        for (Prescription a : prescriptionList) {
            if ((dateDP.getValue().equals(a.getDate()) && ((a.getTime().equals(fromTime) || a.getTime().isAfter(fromTime)) && (a.getTime().equals(toTime) || a.getTime().isBefore(toTime)))) && a.isPrescribed()) {
                appointmentTV.getItems().add(a);
                found = true;
            }
        }
        if (found){
            successMessageLabel.setText("Test Requests Loaded");
        }
        else {
            errorMessageLabel.setText("No test requests to show");
        }
    }
}