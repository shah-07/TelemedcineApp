package Poran.Doctor;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DoctorDashBoardController {

    @javafx.fxml.FXML
    private ImageView doctorProfileImage;
    @javafx.fxml.FXML
    private Button patientsSeenButton;
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
    private AnchorPane dashBoardAnchorPane;
    @javafx.fxml.FXML
    private AnchorPane anchorPaneForPartialWindows;
    @javafx.fxml.FXML
    private Button logOutButton;
    @javafx.fxml.FXML
    private Label welcomeDoctorLabel;
    @javafx.fxml.FXML
    private Label appointmentTextLabel;
    @javafx.fxml.FXML
    private Label appointmentNumberLabel;

    @javafx.fxml.FXML
    public void initialize() {

        setupHoverEffect(dashBoardButton);
        setupHoverEffect(appointmentHistoryButton);
        setupHoverEffect(cancelAppointmentButton);
        setupHoverEffect(labReportsButton);
        setupHoverEffect(pendingAppointmentsButton);
        setupHoverEffect(startAnAppointmentButton);
        setupHoverEffect(patientsSeenButton);
        setupHoverEffect(rescheduleAppointmentButton);
        setupHoverEffect(logOutButton);

    }

    private void setupHoverEffect(Button button) {
        if (button == null) return; // in case any button wasn't properly injected

        button.setStyle("-fx-background-color: transparent; -fx-text-fill: black;");

        button.setOnMouseEntered(e ->
                button.setStyle("-fx-background-color: transparent; -fx-text-fill: grey;")
        );

        button.setOnMouseExited(e ->
                button.setStyle("-fx-background-color: transparent; -fx-text-fill: black;")
        );
    }

    public void setDoctorNameAndID (String name, String specialized){
        doctorNameLabel.setText(name);
        doctorIdLabel.setText(specialized);
    }

    @javafx.fxml.FXML
    public void pendingAppointmentsButtonOA(ActionEvent actionEvent) throws IOException{
        Node node = FXMLLoader.load(getClass().getResource("/Poran/Doctor/pendingAppointmentsView.fxml"));
        anchorPaneForPartialWindows.getChildren().setAll(node);

    }

    @javafx.fxml.FXML
    public void cancelAppointmentButtonOA(ActionEvent actionEvent) throws IOException{
        Node node = FXMLLoader.load(getClass().getResource("/Poran/Doctor/cancelAppointmentView.fxml"));
        anchorPaneForPartialWindows.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void rescheduleAppointmentButtonOA(ActionEvent actionEvent) throws IOException{
        Node node = FXMLLoader.load(getClass().getResource("/Poran/Doctor/rescheduleAppointmentView.fxml"));
        anchorPaneForPartialWindows.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void appointmentHistoryButtonOA(ActionEvent actionEvent) throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("/Poran/Doctor/appointmentHistoryView.fxml"));
        anchorPaneForPartialWindows.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void patientsSeenButtonOA(ActionEvent actionEvent) throws IOException{
        Node node = FXMLLoader.load(getClass().getResource("/Poran/Doctor/patientsSeenView.fxml"));
        anchorPaneForPartialWindows.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void startAnAppointmentButtonOA(ActionEvent actionEvent) throws IOException{
        Node node = FXMLLoader.load(getClass().getResource("/Poran/Doctor/startAppointmentView.fxml"));
        anchorPaneForPartialWindows.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void labReportsButtonOA(ActionEvent actionEvent) throws IOException{
        Node node = FXMLLoader.load(getClass().getResource("/Poran/LabTechnician/labReportsView.fxml"));
        anchorPaneForPartialWindows.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void dashBoardButtonOA(ActionEvent actionEvent){

        anchorPaneForPartialWindows.getChildren().setAll(welcomeDoctorLabel, appointmentTextLabel, appointmentNumberLabel);
    }

    @javafx.fxml.FXML
    public void logOutButtonOA(ActionEvent actionEvent) throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("/mainpackage.telemedicineapp/loginView.fxml"));
        dashBoardAnchorPane.getChildren().setAll(node);
    }
}