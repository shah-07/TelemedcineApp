package Ashik;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class TrackSystemUptimeAndMajorIssuesController {

    @FXML
    private TextField uptimePercentageTextField;

    @FXML
    private TextArea issueDetailsTextArea;

    @FXML
    private TableColumn<TrackSystemUptimeAndMajorIssues, LocalDate> dateCol;

    @FXML
    private TableColumn<TrackSystemUptimeAndMajorIssues, String> issueSummaryCol;

    @FXML
    private TableColumn<TrackSystemUptimeAndMajorIssues, String> detailsCol;

    @FXML
    private TableView<TrackSystemUptimeAndMajorIssues> majorIssuesTableView;

    private ObservableList<TrackSystemUptimeAndMajorIssues> issuesList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        issueSummaryCol.setCellValueFactory(new PropertyValueFactory<>("issueSummary"));
        detailsCol.setCellValueFactory(new PropertyValueFactory<>("details"));

        issuesList.add(new TrackSystemUptimeAndMajorIssues(LocalDate.of(2025, 8, 10), "Server Down", "Server was down for 2 hours"));
        issuesList.add(new TrackSystemUptimeAndMajorIssues(LocalDate.of(2025, 8, 12), "Database Lag", "Database response was slow"));

        majorIssuesTableView.setItems(issuesList);

        uptimePercentageTextField.setText("99.8%");

        majorIssuesTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                issueDetailsTextArea.setText(newSelection.getDetails());
            }
        });
    }
}
