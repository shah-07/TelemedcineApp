package Poran.Doctor;

import Imtia.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.LocalTime;

public class CancelAppointmentController
{
    @javafx.fxml.FXML
    private DatePicker chooseDateDP;
    @javafx.fxml.FXML
    private TableColumn<Appointment, Integer> ageTC;
    @javafx.fxml.FXML
    private Label errorMessageLabel;
    @javafx.fxml.FXML
    private TextField toTimeTF;
    @javafx.fxml.FXML
    private Label successMessageLabel;
    @javafx.fxml.FXML
    private TextField fromTimeTF;
    @javafx.fxml.FXML
    private TableColumn<Appointment, LocalTime> timeTC;
    @javafx.fxml.FXML
    private TableView<Appointment> appointmentsTV;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> genderTC;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> nameTC;
    @javafx.fxml.FXML
    private TableColumn<Appointment, LocalDate> dateTC;

    ObservableList<Appointment> appointmentList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        ageTC.setCellValueFactory(new PropertyValueFactory<>("age"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        genderTC.setCellValueFactory(new PropertyValueFactory<>("gender"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("dateOfAppointment"));
        timeTC.setCellValueFactory(new PropertyValueFactory<>("timeOfAppointment"));

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
            if (a.getAppointmentDate().equals(date) &&
                    !a.getAppointmentTime().isBefore(fromTime) &&
                    !a.getAppointmentTime().isAfter(toTime)) {
                appointmentsTV.getItems().add(a);
            }
        }
    }

    @javafx.fxml.FXML
    public void cancelAppointmentButtonOA(ActionEvent actionEvent) {

        successMessageLabel.setText("");
        errorMessageLabel.setText("");

        Appointment selectedAppointment = appointmentsTV.getSelectionModel().getSelectedItem();
        if (selectedAppointment == null) {
            errorMessageLabel.setText("Please select an appointment to cancel");
            return;
        }

        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Press confirm to cancel the appointment");
        a.setHeaderText("Success");
        if (a.showAndWait().isPresent()) {
            appointmentList.remove(selectedAppointment);
            appointmentsTV.getItems().remove(selectedAppointment);
            successMessageLabel.setText("Appointment cancel successfully");
            GenericFileManager.writeAll(appointmentList, "Appointment.bin");
            return;
        }
    }
}