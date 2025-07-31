package Poran_2420181;

import Imtia.Appointment;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private DatePicker dateOfThePendingAppointmentDP;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> genderTCOfCancelAppointments;
    @javafx.fxml.FXML
    private TextField fromDateOfPendAppointmentTF;
    @javafx.fxml.FXML
    private TableColumn<Appointment, Integer> ageTCOfCancelAppointments;
    @javafx.fxml.FXML
    private TextField toDateOfPendAppointmentTF;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> nameTCOfCancelAppointments;
    @javafx.fxml.FXML
    private TableColumn<Appointment, LocalTime> timeTCOfCancelAppointments;
    @javafx.fxml.FXML
    private TableView<Appointment> pendingAppointmentsTableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void requestForCancellationOfAppointmentButtonOA (ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("cancelAppointmentView2.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void loadAppointmentsButtonOA(ActionEvent actionEvent) {
    }
}