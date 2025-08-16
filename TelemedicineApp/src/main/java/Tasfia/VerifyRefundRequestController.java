package Tasfia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class VerifyRefundRequestController {

    @FXML
    private TableView<RefundRecord> verifyTableView;

    @FXML
    private TableColumn<RefundRecord, String> patientNameCol;

    @FXML
    private TableColumn<RefundRecord, Double> amountCol;

    @FXML
    private TableColumn<RefundRecord, LocalDate> dateCol;

    @FXML
    private TableColumn<RefundRecord, String> reasonCol;

    @FXML
    private TableColumn<RefundRecord, String> statusCol;

    @FXML
    private TextArea detailsTextArea;

    @FXML
    private Label refundApproveLabel;

    private ObservableList<RefundRecord> refundRecords;

    @FXML
    public void initialize() {
        // TableColumn setup
        patientNameCol.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        reasonCol.setCellValueFactory(new PropertyValueFactory<>("reason"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Sample refund records
        refundRecords = FXCollections.observableArrayList(
                new RefundRecord("Alice", 500, LocalDate.of(2025, 8, 1), "Duplicate payment", "Pending"),
                new RefundRecord("Bob", 300, LocalDate.of(2025, 8, 2), "Service not rendered", "Pending"),
                new RefundRecord("Charlie", 400, LocalDate.of(2025, 8, 3), "Overcharged", "Pending")
        );

        verifyTableView.setItems(refundRecords);

        // Show details when row is selected
        verifyTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                detailsTextArea.setText("Patient: " + newSelection.getPatientName() +
                        "\nAmount: " + newSelection.getAmount() +
                        "\nDate: " + newSelection.getDate() +
                        "\nReason: " + newSelection.getReason() +
                        "\nStatus: " + newSelection.getStatus());
            }
        });
    }

    @FXML
    public void approveButtonOnAction(ActionEvent actionEvent) {
        RefundRecord selected = verifyTableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("Approved");
            verifyTableView.refresh();
            refundApproveLabel.setText("Refund approved for " + selected.getPatientName());
        }
    }

    @FXML
    public void rejectButtonOnAction(ActionEvent actionEvent) {
        RefundRecord selected = verifyTableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("Rejected");
            verifyTableView.refresh();
            refundApproveLabel.setText("Refund rejected for " + selected.getPatientName());
        }
    }
}
