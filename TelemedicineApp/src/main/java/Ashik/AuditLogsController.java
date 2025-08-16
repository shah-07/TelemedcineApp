package Ashik;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class AuditLogsController {

    @FXML
    private ComboBox<String> userComboBox;
    @FXML
    private ComboBox<String> typeComboBox;
    @FXML
    private TableView<AuditLog> auditLogsTableView;
    @FXML
    private TableColumn<AuditLog, LocalDate> dateCol;
    @FXML
    private TableColumn<AuditLog, String> actionTypeCol;
    @FXML
    private TableColumn<AuditLog, String> userCol;
    @FXML
    private TableColumn<AuditLog, String> descriptionCol;

    private ObservableList<AuditLog> allLogs = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Initialize TableView columns
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        actionTypeCol.setCellValueFactory(new PropertyValueFactory<>("actionType"));
        userCol.setCellValueFactory(new PropertyValueFactory<>("user"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        // Sample data
        allLogs.addAll(
                new AuditLog(LocalDate.of(2025, 8, 1), "Login", "CEO", "Logged into system"),
                new AuditLog(LocalDate.of(2025, 8, 2), "Backup", "IT Admin", "System backup completed"),
                new AuditLog(LocalDate.of(2025, 8, 3), "Password Reset", "IT Admin", "Reset doctor password")
        );

        auditLogsTableView.setItems(allLogs);

        // Initialize combo boxes
        userComboBox.setItems(FXCollections.observableArrayList("All", "CEO", "IT Admin", "Doctor", "Patient"));
        typeComboBox.setItems(FXCollections.observableArrayList("All", "Login", "Backup", "Password Reset"));
        userComboBox.setValue("All");
        typeComboBox.setValue("All");
    }

    @FXML
    public void filterButton(ActionEvent actionEvent) {
        String selectedUser = userComboBox.getValue();
        String selectedType = typeComboBox.getValue();

        List<AuditLog> filteredLogs = allLogs.stream()
                .filter(log -> (selectedUser.equals("All") || log.getUser().equals(selectedUser)) &&
                        (selectedType.equals("All") || log.getActionType().equals(selectedType)))
                .collect(Collectors.toList());

        auditLogsTableView.setItems(FXCollections.observableArrayList(filteredLogs));
    }

    @FXML
    public void csvButton(ActionEvent actionEvent) {
        try (FileWriter writer = new FileWriter("audit_logs.csv")) {
            writer.append("Date,Action Type,User,Description\n");
            for (AuditLog log : auditLogsTableView.getItems()) {
                writer.append(log.getDate() + "," + log.getActionType() + "," + log.getUser() + "," + log.getDescription() + "\n");
            }
            showAlert(Alert.AlertType.INFORMATION, "CSV Export", "Audit logs exported to audit_logs.csv successfully!");
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "CSV Export Error", "Failed to export audit logs.");
            e.printStackTrace();
        }
    }

    @FXML
    public void pdfButton(ActionEvent actionEvent) {
        showAlert(Alert.AlertType.INFORMATION, "PDF Export", "PDF export feature is not implemented in this demo.");
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}