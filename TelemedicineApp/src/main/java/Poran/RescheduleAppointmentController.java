package Poran;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class RescheduleAppointmentController
{
    @javafx.fxml.FXML
    private TableColumn dateTCOfCancelAppointments;
    @javafx.fxml.FXML
    private TableColumn genderTCOfCancelAppointments;
    @javafx.fxml.FXML
    private TextField toDateOfAppointmentTF;
    @javafx.fxml.FXML
    private TextField fromDateOfAppointmentTF;
    @javafx.fxml.FXML
    private TableView appointmentsTableView;
    @javafx.fxml.FXML
    private TableColumn ageTCOfCancelAppointments;
    @javafx.fxml.FXML
    private TableColumn nameTCOfCancelAppointments;
    @javafx.fxml.FXML
    private TableColumn timeTCOfCancelAppointments;
    @javafx.fxml.FXML
    private DatePicker dateOfTheAppointmentToShowDP;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void requestForReschedulingOfAppointmentButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadAppointmentsButtonOA(ActionEvent actionEvent) {
    }
}