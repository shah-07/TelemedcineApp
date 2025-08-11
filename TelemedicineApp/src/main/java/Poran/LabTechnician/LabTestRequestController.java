package Poran.LabTechnician;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class LabTestRequestController
{
    @javafx.fxml.FXML
    private TableColumn nameTCOfPendingAppointments;
    @javafx.fxml.FXML
    private TableColumn timeTCOfPendingAppointments1;
    @javafx.fxml.FXML
    private TableColumn timeTCOfPendingAppointments;
    @javafx.fxml.FXML
    private DatePicker dateOfThePendingAppointmentDP;
    @javafx.fxml.FXML
    private TableColumn ageTCOfPendingAppointments;
    @javafx.fxml.FXML
    private TableColumn dateTCOfPendingAppointments;
    @javafx.fxml.FXML
    private TextField fromDateOfPendAppointmentTF;
    @javafx.fxml.FXML
    private TextField toDateOfPendAppointmentTF;
    @javafx.fxml.FXML
    private TableView pendingAppointmentsTableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loadPreviousAppointmentsButtonOA(ActionEvent actionEvent) {
    }
}