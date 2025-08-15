package Ashik;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.stream.Collectors;

public class ViewAndExportSystemLogsViewController {

    @FXML
    private DatePicker startingDateDP;
    @FXML
    private DatePicker endingDateDP;
    @FXML
    private ComboBox<String> typeComboBox;
    @FXML
    private TextField usernameTextField;
    @FXML
    private Label successfulLabel;
    @FXML
    private TableView<ViewAndExportSystemLogsView> exportSystemTableView;
    @FXML
    private TableColumn<ViewAndExportSystemLogsView, LocalDate> dateCol;
    @FXML
    private TableColumn<ViewAndExportSystemLogsView, String> actiontypeCol;
    @FXML
    private TableColumn<ViewAndExportSystemLogsView, String> userCol;
    @FXML
    private TableColumn<ViewAndExportSystemLogsView, String> descriptionCol;

    private ObservableList<ViewAndExportSystemLogsView> allLogs;

    @FXML
    public void initialize() {
        // Setup table columns
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        actiontypeCol.setCellValueFactory(new PropertyValueFactory<>("actionType"));
        userCol.setCellValueFactory(new PropertyValueFactory<>("user"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        // Type options
        typeComboBox.setItems(FXCollections.observableArrayList("Login", "Error", "Transaction"));

        // Dummy logs
        allLogs = FXCollections.observableArrayList(
                new ViewAndExportSystemLogsView(LocalDate.now().minusDays(1), "Login", "ceo", "CEO logged in"),
                new ViewAndExportSystemLogsView(LocalDate.now(), "Transaction", "doctor1", "Consultation completed"),
                new ViewAndExportSystemLogsView(LocalDate.now().minusDays(2), "Error", "system", "Database error")
        );

        exportSystemTableView.setItems(allLogs);
    }

    @FXML
    public void applyFilterButtonOnAction(ActionEvent actionEvent) {
        LocalDate startDate = startingDateDP.getValue();
        LocalDate endDate = endingDateDP.getValue();
        String typeFilter = typeComboBox.getValue();
        String usernameFilter = usernameTextField.getText().trim().toLowerCase();

        ObservableList<ViewAndExportSystemLogsView> filteredLogs = allLogs.stream()
                .filter(log -> (startDate == null || !log.getDate().isBefore(startDate)) &&
                        (endDate == null || !log.getDate().isAfter(endDate)) &&
                        (typeFilter == null || log.getActionType().equals(typeFilter)) &&
                        (usernameFilter.isEmpty() || log.getUser().toLowerCase().contains(usernameFilter)))
                .collect(Collectors.toCollection(FXCollections::observableArrayList));

        exportSystemTableView.setItems(filteredLogs);
        successfulLabel.setText("Filter applied: " + filteredLogs.size() + " logs found");
    }

    @FXML
    public void exportCsvButtonOnAction(ActionEvent actionEvent) {
        // Dummy CSV export simulation
        successfulLabel.setText("CSV file generated successfully (simulation)");
    }

    @FXML
    public void exportPdfButtonOnAction(ActionEvent actionEvent) {
        // Dummy PDF export simulation
        successfulLabel.setText("PDF file generated successfully (simulation)");
    }
}
