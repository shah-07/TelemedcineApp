package Poran;

import Imtia.Appointment;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mainpackage.telemedicineapp.MainApplicationClass;

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
    private Button requestForCancellationButton;
    @javafx.fxml.FXML
    private AnchorPane anchorPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void requestForCancellationOfAppointmentButtonOA (ActionEvent actionEvent) throws IOException{
        Node node = FXMLLoader.load(getClass().getResource("/Poran/cancelAppointmentView2.fxml"));
        anchorPane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void loadAppointmentsButtonOA(ActionEvent actionEvent) {
    }
}