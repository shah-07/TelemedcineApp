package Poran.Doctor;

import Imtia.CreateAppointmentModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class CancelAppointment
{
    @javafx.fxml.FXML
    private TableColumn<CreateAppointmentModel, LocalDate> dateTCOfCancelAppointments;
    @javafx.fxml.FXML
    private TableColumn<CreateAppointmentModel, String> genderTCOfCancelAppointments;
    @javafx.fxml.FXML
    private TableColumn<CreateAppointmentModel, Integer> ageTCOfCancelAppointments;
    @javafx.fxml.FXML
    private TableColumn<CreateAppointmentModel, String> nameTCOfCancelAppointments;
    @javafx.fxml.FXML
    private TableColumn<CreateAppointmentModel, LocalTime> timeTCOfCancelAppointments;
    @javafx.fxml.FXML
    private TableView<CreateAppointmentModel> pendingAppointmentsTableView;
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
        Node node = FXMLLoader.load(getClass().getResource("/Poran/Doctor/cancelAppointmentView2.fxml"));
        anchorPane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void loadAppointmentsButtonOA(ActionEvent actionEvent) {
    }
}