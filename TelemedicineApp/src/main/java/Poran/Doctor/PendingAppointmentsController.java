package Poran.Doctor;

import Imtia.Appointment;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class PendingAppointmentsController
{
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> nameTCOfPendingAppointments;
    @javafx.fxml.FXML
    private TableColumn<Appointment, LocalTime> timeTCOfPendingAppointments;
    @javafx.fxml.FXML
    private TableColumn<Appointment, Integer> ageTCOfPendingAppointments;
    @javafx.fxml.FXML
    private TableColumn<Appointment, LocalDate> dateTCOfPendingAppointments;
    @javafx.fxml.FXML
    private DatePicker dateOfThePendingAppointmentDP;
    @javafx.fxml.FXML
    private TableView<Appointment> pendingAppointmentsTableView;
    @javafx.fxml.FXML
    private Label errorMessageLabel;
    @javafx.fxml.FXML
    private Label successMessageLabel;
    @javafx.fxml.FXML
    private TextField fromTimeOfAppointment;
    @javafx.fxml.FXML
    private TextField toTimeOfAppointment;

    @javafx.fxml.FXML
    public void initialize() {
        nameTCOfPendingAppointments.setCellValueFactory(new PropertyValueFactory<>("name"));
        timeTCOfPendingAppointments.setCellValueFactory(new PropertyValueFactory<>("timeOfAppointment"));
        dateTCOfPendingAppointments.setCellValueFactory(new PropertyValueFactory<>("dateOfAppointment"));
        ageTCOfPendingAppointments.setCellValueFactory(new PropertyValueFactory<>("age"));
    }

    @javafx.fxml.FXML
    public void loadPendingAppointmentsButtonOA(ActionEvent actionEvent) {
        successMessageLabel.setText("");
        errorMessageLabel.setText("");
        pendingAppointmentsTableView.getItems().clear();
        boolean found = false;
        LocalTime fromTime = LocalTime.parse(fromTimeOfAppointment.getText());
        LocalTime toTime = LocalTime.parse(toTimeOfAppointment.getText());

        try{
            FileInputStream fis = new FileInputStream("Appointment.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true){
                Appointment s = (Appointment) ois.readObject();
                if (dateOfThePendingAppointmentDP.getValue().equals(s.getDateOfAppointment()) && ((s.getTimeOfAppointment().equals(fromTime) || s.getTimeOfAppointment().isAfter(fromTime)) && (s.getTimeOfAppointment().equals(toTime) || s.getTimeOfAppointment().isBefore(toTime)))) {
                    pendingAppointmentsTableView.getItems().add(s);
                    found = true;
                }
            }
        }

        catch (EOFException eof) {
            if (found){
                successMessageLabel.setText("Appointment Loaded");
            }
            else {
                errorMessageLabel.setText("No appointments to show");
            }
        }
        catch (Exception e) {
            e.printStackTrace(); // Helpful for debugging
            errorMessageLabel.setText("Error reading appointment file.");
        }

    }
}