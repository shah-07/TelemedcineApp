package Poran.Doctor;

import Imtia.CreateAppointmentModel;
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
    private TableColumn<CreateAppointmentModel, String> nameTCOfPendingAppointments;
    @javafx.fxml.FXML
    private TableColumn<CreateAppointmentModel, LocalTime> timeTCOfPendingAppointments1;
    @javafx.fxml.FXML
    private TableColumn<CreateAppointmentModel, LocalTime> timeTCOfPendingAppointments;
    @javafx.fxml.FXML
    private DatePicker dateOfThePendingAppointmentDP;
    @javafx.fxml.FXML
    private TableColumn<CreateAppointmentModel, Integer> ageTCOfPendingAppointments;
    @javafx.fxml.FXML
    private TableColumn<CreateAppointmentModel, LocalDate> dateTCOfPendingAppointments;
    @javafx.fxml.FXML
    private TextField fromDateOfPendAppointmentTF;
    @javafx.fxml.FXML
    private TextField toDateOfPendAppointmentTF;
    @javafx.fxml.FXML
    private TableView<CreateAppointmentModel> pendingAppointmentsTableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loadPreviousAppointmentsButtonOA(ActionEvent actionEvent) {
    }
}