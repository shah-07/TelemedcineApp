package Poran.Doctor;

import Imtia.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;
import java.time.LocalTime;

public class RescheduleAppointmentController
{
    @javafx.fxml.FXML
    private DatePicker newDateDP;
    @javafx.fxml.FXML
    private DatePicker chooseDateDP;
    @javafx.fxml.FXML
    private TextField newTimeTF;
    @javafx.fxml.FXML
    private Label errorMessageLabel;
    @javafx.fxml.FXML
    private TextField toTimeTF;
    @javafx.fxml.FXML
    private Label successMessageLabel;
    @javafx.fxml.FXML
    private TextField fromTimeTF;
    @javafx.fxml.FXML
    private TableView<Appointment> appointmentsTV;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> genderTC;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> nameTC;
    @javafx.fxml.FXML
    private TableColumn<Appointment, Integer> ageTC;
    @javafx.fxml.FXML
    private TableColumn<Appointment, LocalDate> dateTC;
    @javafx.fxml.FXML
    private TableColumn<Appointment, LocalTime> timeTC;

    ObservableList<Appointment> appointmentList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        ageTC.setCellValueFactory(new PropertyValueFactory<>("age"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        genderTC.setCellValueFactory(new PropertyValueFactory<>("gender"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
        timeTC.setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));

        appointmentsTV.setItems(appointmentList);

    }


    @javafx.fxml.FXML
    public void loadAppointmentsButtonOA(ActionEvent actionEvent) {

        successMessageLabel.setText("");
        errorMessageLabel.setText("");

        if(chooseDateDP.getValue() == null || fromTimeTF.getText().isEmpty() || toTimeTF.getText().isEmpty()){
            errorMessageLabel.setText("Please select a date and time");
            return;
        }

        LocalDate date = chooseDateDP.getValue();
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

        appointmentsTV.getItems().clear();
        appointmentList = GenericFileManager.readAll(Appointment.class, "Appointment.bin");

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

    @javafx.fxml.FXML
    public void rescheduleAppointmentButtonOA(ActionEvent actionEvent) {

        successMessageLabel.setText("");
        errorMessageLabel.setText("");

        Appointment selectedAppointment = appointmentsTV.getSelectionModel().getSelectedItem();
        if (selectedAppointment == null) {
            errorMessageLabel.setText("Please select an appointment to reschedule");
            return;
        }

        if (newDateDP.getValue() == null || newTimeTF.getText().isEmpty()) {
            errorMessageLabel.setText("Please enter new date and time");
            return;
        }

        LocalDate newDate = newDateDP.getValue();
        LocalTime newTime = LocalTime.parse(newTimeTF.getText());

        if (newDate.isBefore(LocalDate.now()) || (newDate.isEqual(LocalDate.now()) && newTime.isBefore(LocalTime.now()))) {
            errorMessageLabel.setText("New date/time cannot be in the past");
            return;
        }

        for (Appointment a: appointmentList){
            if (a.equals(selectedAppointment)){
                a.setAppointmentTime(LocalTime.parse(newTimeTF.getText()));
                a.setAppointmentDate(newDateDP.getValue());
            }
        }

        GenericFileManager.writeAll(appointmentList, "Appointment.bin");

        appointmentsTV.refresh();
        appointmentsTV.getItems().clear();
        successMessageLabel.setText("Appointment successfully rescheduled");
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("Success");
        a.setContentText("Successfully rescheduled appointment");
        a.showAndWait();

    }


}