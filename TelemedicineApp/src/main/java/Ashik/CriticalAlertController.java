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
    private DatePicker alertDatePicker;
    @FXML
    private TableView<CriticalAlert> alertTableView;
    @FXML
    private TableColumn<CriticalAlert, LocalDate> dateCol;
    @FXML
    private TableColumn<CriticalAlert, String> typeCol;
    @FXML
    private TableColumn<CriticalAlert, String> summaryCol;
    @FXML
    private TextArea alertDetailsTextArea;

    private final ObservableList<CriticalAlert> allAlerts = FXCollections.observableArrayList(
            new CriticalAlert(LocalDate.of(2025, 8, 10), "System Failure", "Database connection lost", "Full description: Database connection failed at 3:45 PM due to network outage."),
            new CriticalAlert(LocalDate.of(2025, 8, 12), "Complaint", "Patient complained about late response", "Full description: A patient reported late response from the doctor in telemedicine system."),
            new CriticalAlert(LocalDate.of(2025, 8, 16), "System Warning", "High server CPU usage", "Full description: CPU usage exceeded 90% for more than 15 minutes on main server.")
    );

    @FXML
    public void initialize() {
        dateCol.setCellValueFactory(new PropertyValueFactory<>("getValue().getDate()"));
        typeCol.setCellValueFactory( new PropertyValueFactory<>("getValue().getAlertType()"));
        summaryCol.setCellValueFactory( new PropertyValueFactory<>("getValue().getDescriptionSummary()"));

        alertTableView.setItems(allAlerts);
    }


    @FXML
    public void searchButton(ActionEvent actionEvent) {
        LocalDate selectedDate = alertDatePicker.getValue();
        if (selectedDate == null) {
            showWarning("Please select a date first.");
            return;
        }


        ObservableList<CriticalAlert> filtered = FXCollections.observableArrayList();
        for (CriticalAlert alert : allAlerts) {
            if (alert.getDate().equals(selectedDate)) {
                filtered.add(alert);
            }
        }

        alertTableView.setItems(filtered);

        if (filtered.isEmpty()) {
            showInfo("No alerts found for " + selectedDate);
        }
    }


    @FXML
    public void viewDetailsButton(ActionEvent actionEvent) {
        CriticalAlert selectedAlert = alertTableView.getSelectionModel().getSelectedItem();
        if (selectedAlert == null) {
            showWarning("Please select an alert from the table.");
            return;
        }
        alertDetailsTextArea.setText(selectedAlert.getFullDescription());
    }


    private void showInfo(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    private void showWarning(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
