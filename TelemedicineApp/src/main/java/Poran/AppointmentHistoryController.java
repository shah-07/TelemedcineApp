package Poran;

import Imtia.Appointment;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentHistoryController
{
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> nameTCOfPendingAppointments;
    @javafx.fxml.FXML
    private TableColumn<Appointment, LocalTime> timeTCOfPendingAppointments1;
    @javafx.fxml.FXML
    private TableColumn<Appointment, LocalTime> timeTCOfPendingAppointments;
    @javafx.fxml.FXML
    private DatePicker dateOfThePendingAppointmentDP;
    @javafx.fxml.FXML
    private TableColumn<Appointment, Integer> ageTCOfPendingAppointments;
    @javafx.fxml.FXML
    private TableColumn<Appointment, LocalDate> dateTCOfPendingAppointments;
    @javafx.fxml.FXML
    private TextField fromDateOfPendAppointmentTF;
    @javafx.fxml.FXML
    private TextField toDateOfPendAppointmentTF;
    @javafx.fxml.FXML
    private TableView<Appointment> pendingAppointmentsTableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loadPreviousAppointmentsButtonOA(ActionEvent actionEvent) {
    }
}