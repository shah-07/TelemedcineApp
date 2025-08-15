package Ashik;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CeoDashboardController {

    @FXML
    private TextField nameTextField;
    @FXML
    private Label welcomeLabel;

    @FXML
    private Button appointmentStatisticsButton;
    @FXML
    private Button activeUserButton;
    @FXML
    private Button revenueFromConsultationButton;
    @FXML
    private Button doctorsPerfomanceButton;
    @FXML
    private Button systemAndMajorIssuesButton;
    @FXML
    private Button growthTrendButton;
    @FXML
    private Button alertAndComplaintButton;
    @FXML
    private Button auditButton;
    @FXML
    private Button logOutButton;

    @FXML
    public void initialize() {
        // Example: set welcome text using CEO name
        welcomeLabel.setText("WELCOME CEO");
    }

    @FXML
    public void appointmentStatisticsButtonOnAction(ActionEvent event) throws IOException {
        // Goal-1: Open appointment statistics view
        openView("/Ashik/AppointmentStatisticsView.fxml", "Appointment Statistics");
    }

    @FXML
    public void activeUserButtonOnAction(ActionEvent event) throws IOException {
        // Goal-2: Open active user summary view
        openView("/Ashik/ActiveUserSummaryView.fxml", "Active Users Summary");
    }

    @FXML
    public void revenueFromConsultationButtonOnAction(ActionEvent event) throws IOException {
        // Goal-3: Open revenue from consultation view
        openView("/Ashik/RevenueFromConsultationView.fxml", "Revenue from Consultations");
    }

    @FXML
    public void doctorsPerfomanceButtonOnAction(ActionEvent event) throws IOException {
        // Goal-4: Open doctors performance report view
        openView("/Ashik/DoctorsPerformanceView.fxml", "Doctors Performance");
    }

    @FXML
    public void systemAndMajorIssuesButtonOnAction(ActionEvent event) throws IOException {
        // Goal-5: Open system uptime & issues view
        openView("/Ashik/TrackSystemUptimeAndMajorIssuesView.fxml", "System Uptime & Major Issues");
    }

    @FXML
    public void growthTrendButtonOnAction(ActionEvent event) throws IOException {
        // Goal-6: Open user growth trends view
        openView("/Ashik/UserGrowthTrendsView.fxml", "User Growth Trends");
    }

    @FXML
    public void alertAndComplaintButtonOnAction(ActionEvent event) throws IOException {
        // Goal-7: Open alerts & complaints view
        openView("/Ashik/CriticalSystemAlertsView.fxml", "Critical Alerts & Complaints");
    }

    @FXML
    public void auditButtonOnAction(ActionEvent event) throws IOException {
        openView("/Ashik/AuditLogsView.fxml", "Audit Logs");
    }

    @FXML
    public void logOutButtonOnAction(ActionEvent event) throws IOException {
        // Handle log out: close current stage and open login view
        Stage stage = (Stage) logOutButton.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Ashik/LoginView.fxml"));
        Stage loginStage = new Stage();
        loginStage.setScene(new Scene(fxmlLoader.load()));
        loginStage.setTitle("Login");
        loginStage.show();
    }


    private void openView(String fxmlPath, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
        Stage stage = new Stage();
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.setTitle(title);
        stage.show();
    }
}
