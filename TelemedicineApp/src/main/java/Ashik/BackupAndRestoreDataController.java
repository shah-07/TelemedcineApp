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
    private Label successfulLabel;
    @FXML
    private Label continueLabel;

    private boolean isRestoreAction = false;

    @FXML
    public void initialize() {
        lastBackupTextField.setText("2025-08-01 14:35:00");
        successfulLabel.setText("");
        continueLabel.setText("");
    }

    @FXML
    public void startBackupButtonOnAction(ActionEvent actionEvent) {
        isRestoreAction = false;
        continueLabel.setText("Are you sure you want to start a backup?");
    }

    @FXML
    public void restoreBackupButtonOnAction(ActionEvent actionEvent) {
        isRestoreAction = true;
        continueLabel.setText("Are you sure you want to restore the system?");
    }

    @FXML
    public void confirmButtonOnAction(ActionEvent actionEvent) {
        if (isRestoreAction) {
            runRestore();
        } else {
            runBackup();
        }
    }

    @FXML
    public void cancelButtonOnAction(ActionEvent actionEvent) {
        continueLabel.setText("Action cancelled.");
        successfulLabel.setText("");
    }

    private void runBackup() {
        try {
            Thread.sleep(1000); // Simulating process delay
            String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            lastBackupTextField.setText(now);
            successfulLabel.setText("Backup completed successfully!");
        } catch (InterruptedException e) {
            successfulLabel.setText("Backup failed!");
            e.printStackTrace();
        }
    }

    private void runRestore() {
        try {
            Thread.sleep(1000); // Simulating process delay
            successfulLabel.setText("System restored successfully!");
        } catch (InterruptedException e) {
            successfulLabel.setText("Restore failed!");
            e.printStackTrace();
        }
    }
}
