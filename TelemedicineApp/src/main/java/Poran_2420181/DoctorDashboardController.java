package Poran_2420181;

import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class DoctorDashboardController {

    @javafx.fxml.FXML
    private ImageView doctorProfileImage;
    @javafx.fxml.FXML
    private Button patientsSeenButton;
    @javafx.fxml.FXML
    private Button referToLabButton;
    @javafx.fxml.FXML
    private Button rescheduleAppointmentButton;
    @javafx.fxml.FXML
    private Button dashBoardButton;
    @javafx.fxml.FXML
    private Button labReportsButton;
    @javafx.fxml.FXML
    private Label doctorNameLabel;
    @javafx.fxml.FXML
    private Button appointmentHistoryButton;
    @javafx.fxml.FXML
    private Button cancelAppointmentButton;
    @javafx.fxml.FXML
    private Button pendingAppointmentsButton;
    @javafx.fxml.FXML
    private Label doctorIdLabel;
    @javafx.fxml.FXML
    private Button startAnAppointmentButton;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void appointmentHistoryButtonOMExited(Event event) {
        appointmentHistoryButton.setStyle("-fx-background-color: transparent; -fx-text-fill: black;");
    }

    @javafx.fxml.FXML
    public void referToLabButtonOMEntered(Event event) {
        referToLabButton.setStyle("-fx-background-color: transparent; -fx-text-fill: grey;");
    }

    @javafx.fxml.FXML
    public void cancelAppointmentButtonOMExited(Event event) {
        cancelAppointmentButton.setStyle("-fx-background-color: transparent; -fx-text-fill: black;");
    }

    @javafx.fxml.FXML
    public void labReportButtonOMExited(Event event) {
        labReportsButton.setStyle("-fx-background-color: transparent; -fx-text-fill: black;");
    }

    @javafx.fxml.FXML
    public void cancelAppointmentButtonOMEntered(Event event) {
        cancelAppointmentButton.setStyle("-fx-background-color: transparent; -fx-text-fill: grey;");
    }

    @javafx.fxml.FXML
    public void dashBoardButtonOMExited(Event event) {
        dashBoardButton.setStyle("-fx-background-color: transparent; -fx-text-fill: black;");
    }

    @javafx.fxml.FXML
    public void patientsSeenButtonOMEntered(Event event) {
        patientsSeenButton.setStyle("-fx-background-color: transparent; -fx-text-fill: grey;");
    }

    @javafx.fxml.FXML
    public void pendingAppointmentsButtonOMExited(Event event) {
        pendingAppointmentsButton.setStyle("-fx-background-color: transparent; -fx-text-fill: black;");
    }


    @javafx.fxml.FXML
    public void patientsSeenButtonOMExited(Event event) {
        patientsSeenButton.setStyle("-fx-background-color: transparent; -fx-text-fill: black;");
    }

    @javafx.fxml.FXML
    public void startAnAppointmentButtonOMEntered(Event event) {
        startAnAppointmentButton.setStyle("-fx-background-color: transparent; -fx-text-fill: grey;");
    }


    @javafx.fxml.FXML
    public void referToLabButtonOMExited(Event event) {
        referToLabButton.setStyle("-fx-background-color: transparent; -fx-text-fill: black;");
    }

    @javafx.fxml.FXML
    public void startAnAppointmentButtonOMExited(Event event) {
        startAnAppointmentButton.setStyle("-fx-background-color: transparent; -fx-text-fill: black;");
    }

    @javafx.fxml.FXML
    public void appointmentHistoryButtonOMEntered(Event event) {
        appointmentHistoryButton.setStyle("-fx-background-color: transparent; -fx-text-fill: grey;");
    }

    @javafx.fxml.FXML
    public void labReportButtonOMEntered(Event event) {
        labReportsButton.setStyle("-fx-background-color: transparent; -fx-text-fill: grey;");
    }


    @javafx.fxml.FXML
    public void pendingAppointmentsButtonOMEntered(Event event) {
        pendingAppointmentsButton.setStyle("-fx-background-color: transparent; -fx-text-fill: grey;");
    }

    @javafx.fxml.FXML
    public void dashBoardButtonOMEntered(Event event) {
        dashBoardButton.setStyle("-fx-background-color: transparent; -fx-text-fill: grey;");
    }

    @javafx.fxml.FXML
    public void rescheduleAppointmentButtonOMEntered(Event event) {
        rescheduleAppointmentButton.setStyle("-fx-background-color: transparent; -fx-text-fill: grey;");
    }

    @javafx.fxml.FXML
    public void rescheduleAppointmentButtonOMExited(Event event) {
        rescheduleAppointmentButton.setStyle("-fx-background-color: transparent; -fx-text-fill: black;");
    }
}