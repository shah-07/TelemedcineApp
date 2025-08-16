package Ashik;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BackupAndRestoreDataController {

    @FXML
    private TextField lastBackupTextField;
    @FXML
    private Label statusLabel;
    @FXML
    private Label confirmLabel;

    private boolean isRestoreAction = false;
    private BackupAndRestoreData backupData;

    @FXML
    public void initialize() {
        // initialize with a dummy previous backup
        backupData = new BackupAndRestoreData(LocalDateTime.now().minusDays(3), "Success");
        updateLastBackupField();
        statusLabel.setText("");
        confirmLabel.setText("");
    }

    @FXML
    public void startBackupButtonOnAction(ActionEvent event) {
        isRestoreAction = false;
        confirmLabel.setText("Are you sure you want to start a backup?");
        statusLabel.setText("");
    }

    @FXML
    public void restoreBackupButtonOnAction(ActionEvent event) {
        isRestoreAction = true;
        confirmLabel.setText("Are you sure you want to restore the system?");
        statusLabel.setText("");
    }

    @FXML
    public void confirmButtonOnAction(ActionEvent event) {
        if (isRestoreAction) {
            runRestore();
        } else {
            runBackup();
        }
    }

    @FXML
    public void cancelButtonOnAction(ActionEvent event) {
        confirmLabel.setText("Action cancelled.");
        statusLabel.setText("");
    }

    private void runBackup() {
        try {
            Thread.sleep(1000);

            backupData.setLastBackupDateTime(LocalDateTime.now());
            backupData.setStatus("Success");

            updateLastBackupField();
            statusLabel.setText("Backup completed successfully!");
            showAlert("Backup", "Backup completed successfully!", Alert.AlertType.INFORMATION);

        } catch (InterruptedException e) {
            backupData.setStatus("Failed");
            statusLabel.setText("Backup failed!");
            showAlert("Backup", "Backup failed!", Alert.AlertType.ERROR);
            Thread.currentThread().interrupt();
        }
    }

    private void runRestore() {
        try {
            Thread.sleep(1000);

            backupData.setStatus("Success");
            statusLabel.setText("System restored successfully!");
            showAlert("Restore", "System restored successfully!", Alert.AlertType.INFORMATION);

        } catch (InterruptedException e) {
            backupData.setStatus("Failed");
            statusLabel.setText("Restore failed!");
            showAlert("Restore", "System restore failed!", Alert.AlertType.ERROR);
            Thread.currentThread().interrupt();
        }
    }

    private void updateLastBackupField() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        lastBackupTextField.setText(backupData.getLastBackupDateTime().format(formatter));
    }

    private void showAlert(String title, String content, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
