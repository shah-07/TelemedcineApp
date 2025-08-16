package Ashik;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ItAdminDashboardController {

    @FXML
    private TextField nameTextField;

    @FXML
    public void initialize() {
        nameTextField.setText("WELCOME IT ADMIN");
    }


    @FXML
    public void createProfileButton(ActionEvent actionEvent) {
        showInfo("Open 'Create Profile' page for doctors, pharmacists, and lab technicians.");
    }

    @FXML
    public void accountStatusButton(ActionEvent actionEvent) {
        showInfo("Open 'User Account Status' management page.");
    }

    @FXML
    public void faqButton(ActionEvent actionEvent) {
        showInfo("Open 'Reply to FAQs' page.");
    }

    @FXML
    public void accessControllerButton(ActionEvent actionEvent) {
        showInfo("Open 'Access Control Settings' page.");
    }

    @FXML
    public void systemPerformanceButton(ActionEvent actionEvent) {
        showInfo("Open 'System Performance and Uptime' dashboard.");
    }

    @FXML
    public void resetPasswordButton(ActionEvent actionEvent) {
        showInfo("Open 'Reset User Password' page.");
    }

    @FXML
    public void systemDataButton(ActionEvent actionEvent) {
        showInfo("Open 'Backup and Restore System Data' page.");
    }

    @FXML
    public void systemLogsButton(ActionEvent actionEvent) {
        showInfo("Open 'View and Export System Logs' page.");
    }

    private void showInfo(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
