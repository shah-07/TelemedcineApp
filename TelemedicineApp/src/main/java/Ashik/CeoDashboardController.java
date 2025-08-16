package Ashik;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CeoDashboardController {

    @FXML
    private TextField nameTextField;
    @FXML
    private Label welcomeLabel;

    @FXML
    public void initialize() {
        welcomeLabel.setText("WELCOME CEO");
    }

    @FXML
    public void appointmentStatisticButton(ActionEvent actionEvent) {
        showInfo("Appointment Statistics", "Showing overall appointment statistics.");
    }

    @FXML
    public void activeUserButton(ActionEvent actionEvent) {
        showInfo("Active Users", "Monitoring active doctors and patients.");
    }

    @FXML
    public void revenueButton(ActionEvent actionEvent) {
        showInfo("Revenue Report", "Displaying revenue generated from consultations.");
    }

    @FXML
    public void doctorPerfomanceButton(ActionEvent actionEvent) {
        showInfo("Doctors' Performance", "Showing doctors' performance reports.");
    }

    @FXML
    public void systemandMajorIssuesButton(ActionEvent actionEvent) {
        showInfo("System & Issues", "Tracking system uptime and major issues.");
    }

    @FXML
    public void growthTrendButton(ActionEvent actionEvent) {
        showInfo("Growth Trends", "Displaying user growth trends.");
    }

    @FXML
    public void alertAndComplaintButton(ActionEvent actionEvent) {
        showInfo("Alerts & Complaints", "Showing alerts about system failures or complaints.");
    }

    @FXML
    public void auditButton(ActionEvent actionEvent) {
        showInfo("Audit Logs", "Viewing and downloading audit logs.");
    }

    private void showInfo(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
