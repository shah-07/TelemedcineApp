package Poran;

import Imtia.Appointment;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class CancelAppointment
{
    @javafx.fxml.FXML
    private TableColumn<Appointment, LocalDate> dateTCOfCancelAppointments;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> genderTCOfCancelAppointments;
    @javafx.fxml.FXML
    private TableColumn<Appointment, Integer> ageTCOfCancelAppointments;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> nameTCOfCancelAppointments;
    @javafx.fxml.FXML
    private TableColumn<Appointment, LocalTime> timeTCOfCancelAppointments;
    @javafx.fxml.FXML
    private TableView<Appointment> pendingAppointmentsTableView;
    @javafx.fxml.FXML
    private DatePicker chooseDateDP;
    @javafx.fxml.FXML
    private TextField toTimeTF;
    @javafx.fxml.FXML
    private TextField fromTimeTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void requestForCancellationOfAppointmentButtonOA (ActionEvent actionEvent) throws IOException {

    }

    @javafx.fxml.FXML
    public void loadAppointmentsButtonOA(ActionEvent actionEvent) {
    }
}