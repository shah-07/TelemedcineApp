package Tasfia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.stream.Collectors;

public class ViewPaymentHistoryController {

    @FXML
    private TableColumn<PaymentHistoryRecord, Integer> patientIdTableCol;

    @FXML
    private TableColumn<PaymentHistoryRecord, String> patientNameTableCol;

    @FXML
    private TableColumn<PaymentHistoryRecord, Double> AmountCol;

    @FXML
    private TableColumn<PaymentHistoryRecord, String> statusCol;

    @FXML
    private TableColumn<PaymentHistoryRecord, LocalDate> dateCol;

    @FXML
    private TableView<PaymentHistoryRecord> paymentHistoryTableView;

    @FXML
    private TextField patientNameTextField;

    @FXML
    private TextField idTextField;

    @FXML
    private Text recordLabel;

    private ObservableList<PaymentHistoryRecord> paymentRecords;

    @FXML
    public void initialize() {
        // TableColumn setup
        patientIdTableCol.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        patientNameTableCol.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        AmountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Sample data
        paymentRecords = FXCollections.observableArrayList(
                new PaymentHistoryRecord(1, "Alice", 500, "Paid", LocalDate.of(2025, 8, 1)),
                new PaymentHistoryRecord(2, "Bob", 300, "Pending", LocalDate.of(2025, 8, 2)),
                new PaymentHistoryRecord(3, "Charlie", 400, "Paid", LocalDate.of(2025, 8, 3))
        );

        paymentHistoryTableView.setItems(paymentRecords);

        recordLabel.setText("Total Records: " + paymentRecords.size());
    }

    @FXML
    public void searchButtonOnAction(ActionEvent actionEvent) {
        String nameFilter = patientNameTextField.getText().trim().toLowerCase();
        String idFilter = idTextField.getText().trim();

        ObservableList<PaymentHistoryRecord> filtered = FXCollections.observableArrayList(
                paymentRecords.stream()
                        .filter(r -> (nameFilter.isEmpty() || r.getPatientName().toLowerCase().contains(nameFilter)) &&
                                (idFilter.isEmpty() || Integer.toString(r.getPatientId()).equals(idFilter)))
                        .collect(Collectors.toList())
        );

        paymentHistoryTableView.setItems(filtered);
        recordLabel.setText("Total Records: " + filtered.size());
    }
}
