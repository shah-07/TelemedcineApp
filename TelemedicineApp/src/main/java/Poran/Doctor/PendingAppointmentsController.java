package Poran.Doctor;

import Imtia.Appointment;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.LocalTime;

public class PendingAppointmentsController
{
    @javafx.fxml.FXML
    private TableColumn<Appointment, LocalTime> timeTC;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> nameTC;
    @javafx.fxml.FXML
    private Label errorMessageLabel;
    @javafx.fxml.FXML
    private TextField toTimeTF;
    @javafx.fxml.FXML
    private TableColumn<Appointment, Integer> ageTC;
    @javafx.fxml.FXML
    private DatePicker dateDP;
    @javafx.fxml.FXML
    private TableColumn<Appointment, LocalDate> dateTC;
    @javafx.fxml.FXML
    private Label successMessageLabel;
    @javafx.fxml.FXML
    private TextField fromTimeTF;
    @javafx.fxml.FXML
    private TableView<Appointment> appointmentsTV;


    @javafx.fxml.FXML
    public void initialize() {

        timeTC.setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageTC.setCellValueFactory(new PropertyValueFactory<>("age"));

    }


    @javafx.fxml.FXML
    public void loadAppointmentButtonOA(ActionEvent actionEvent) {

        ObservableList<Appointment> appointmentList = GenericFileManager.readAll(Appointment.class, "Appointment.bin");
        successMessageLabel.setText("");
        errorMessageLabel.setText("");
        appointmentsTV.getItems().clear();

        if(dateDP.getValue() == null || fromTimeTF.getText().isEmpty() || toTimeTF.getText().isEmpty()){
            errorMessageLabel.setText("Please select a date and time");
            return;
        }

        LocalDate date = dateDP.getValue();
        LocalTime fromTime = LocalTime.parse(fromTimeTF.getText());
        LocalTime toTime = LocalTime.parse(toTimeTF.getText());

        if(date.isBefore(LocalDate.now())){
            errorMessageLabel.setText("Previous date cannot be selected");
            return;
        }

        if (date.isEqual(LocalDate.now()) && fromTime.isBefore(LocalTime.now())){
            errorMessageLabel.setText("Previous time cannot be selected");
            return;
        }

        for (Appointment a : appointmentList) {
            if ((a.getAppointmentDate().equals(date) &&
                    !a.getAppointmentTime().isBefore(fromTime) &&
                    !a.getAppointmentTime().isAfter(toTime)) && !a.isSeen()) {
                appointmentsTV.getItems().add(a);
            }

        }

        if(appointmentsTV.getItems().isEmpty()){
            errorMessageLabel.setText("No appointments to show");
        }
        else{
            successMessageLabel.setText("Appointments loaded");
        }

    }
}