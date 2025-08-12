package Poran.Doctor;

import Imtia.Appointment;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class AppointmentHistoryController
{
    @javafx.fxml.FXML
    private TableColumn<Prescription, String> nameTCOfPendingAppointments;
    @javafx.fxml.FXML
    private TableColumn<Prescription, LocalTime> timeTCOfPendingAppointments;
    @javafx.fxml.FXML
    private DatePicker dateOfThePendingAppointmentDP;
    @javafx.fxml.FXML
    private TableColumn<Prescription, Integer> ageTCOfPendingAppointments;
    @javafx.fxml.FXML
    private TableColumn<Prescription, LocalDate> dateTCOfPendingAppointments;
    @javafx.fxml.FXML
    private TextField fromTimeTF;
    @javafx.fxml.FXML
    private TextField toTimeTF;
    @javafx.fxml.FXML
    private TableView<Prescription> pendingAppointmentsTableView;
    @javafx.fxml.FXML
    private Label successMeassageLabel;
    @javafx.fxml.FXML
    private Label errorMeassageLabel;
    @javafx.fxml.FXML
    private TableColumn<Prescription, String> diagnosisTCOfPendingAppointments;

    @javafx.fxml.FXML
    public void initialize() {
        nameTCOfPendingAppointments.setCellValueFactory(new PropertyValueFactory<>("name"));
        timeTCOfPendingAppointments.setCellValueFactory(new PropertyValueFactory<>("timeO"));
        ageTCOfPendingAppointments.setCellValueFactory(new PropertyValueFactory<>("age"));
        dateTCOfPendingAppointments.setCellValueFactory(new PropertyValueFactory<>("date"));
        diagnosisTCOfPendingAppointments.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
    }

    @javafx.fxml.FXML
    public void loadPreviousAppointmentsButtonOA(ActionEvent actionEvent) {

        boolean found = false;
        ArrayList<Prescription> appointmentList = new ArrayList<>();
        LocalTime fromTime = LocalTime.parse(fromTimeTF.getText());
        LocalTime toTime = LocalTime.parse(toTimeTF.getText());

        try{
            FileInputStream fis = new FileInputStream("Prescription.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true){
                Prescription p = (Prescription) ois.readObject();
                if(p.getDate().equals(dateOfThePendingAppointmentDP.getValue()) && ((p.getTime().equals(fromTime) || p.getTime().isAfter(fromTime)) && (p.getTime().equals(toTime) || p.getTime().isBefore(toTime)))) {
                    pendingAppointmentsTableView.getItems().add(p);
                    found = true;
                }

            }

        }
        catch (EOFException e1){
            if (found){
                successMeassageLabel.setText("Appointments Loaded");
            }
            else{
                errorMeassageLabel.setText("No appointments to show");
            }
        }
        catch (Exception e){
            errorMeassageLabel.setText("Error reading file");
        }

    }
}