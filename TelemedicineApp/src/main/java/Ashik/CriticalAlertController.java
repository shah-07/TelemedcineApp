package Ashik;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class CriticalAlertController {

    @FXML
    private TextArea alertDetailsTextArea;
    @FXML
    private DatePicker alertDateDP;
    @FXML
    private TableView<CriticalAlert> criticalAlertTableView;
    @FXML
    private TableColumn<CriticalAlert, LocalDate> dateCol;
    @FXML
    private TableColumn<CriticalAlert, String> alertTypeCol;
    @FXML
    private TableColumn<CriticalAlert, String> descriptionSummaryCol;

    private ObservableList<CriticalAlert> allAlerts = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Bind columns to model fields
        dateCol.setCellValueFactory ( new PropertyValueFactory<>( "cellData.getValue().getDate()"));
        alertTypeCol.setCellValueFactory( new PropertyValueFactory<>("cellData.getValue().getAlertType()"));
        descriptionSummaryCol.setCellValueFactory( new PropertyValueFactory<>("cellData.getValue().getDescriptionSummary()"));

        // Sample data
        allAlerts.addAll(
                new CriticalAlert(LocalDate.of(2025, 8, 12), "System Failure", "Database crashed", "Full details: Database server was down for 2 hours."),
                new CriticalAlert(LocalDate.of(2025, 8, 13), "Complaint", "Late report submission", "Full details: Multiple doctors submitted reports late."),
                new CriticalAlert(LocalDate.of(2025, 8, 15), "Error", "Payment issue", "Full details: Payment gateway timed out for some users.")
        );
    }

    @FXML
    public void searchButtonOnAction(ActionEvent actionEvent) {
        LocalDate selectedDate = alertDateDP.getValue();
        if (selectedDate == null) {
            showAlert("Please select a date before searching.");
            return;
        }

        ObservableList<CriticalAlert> filteredAlerts = FXCollections.observableArrayList();
        for (CriticalAlert alert : allAlerts) {
            if (alert.getDate().equals(selectedDate)) {
                filteredAlerts.add(alert);
            }
        }

        criticalAlertTableView.setItems(filteredAlerts);

        if (filteredAlerts.isEmpty()) {
            showAlert("No alerts found for the selected date.");
        }
    }

    @FXML
    public void viewDetailsButtonOnAction(ActionEvent actionEvent) {
        CriticalAlert selectedAlert = criticalAlertTableView.getSelectionModel().getSelectedItem();
        if (selectedAlert == null) {
            showAlert("Please select an alert from the table.");
            return;
        }
        alertDetailsTextArea.setText(selectedAlert.getFullDescription());
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
