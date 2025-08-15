package Tasfia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.stream.Collectors;

public class TrackPendingPaymentController {

    @FXML
    private TableColumn<PaymentRecord, String> patientNameTableCol;

    @FXML
    private TableColumn<PaymentRecord, Double> amountTableCol;

    @FXML
    private TableColumn<PaymentRecord, String> statusTableCol;

    @FXML
    private TableColumn<PaymentRecord, LocalDate> dateTableCol;

    @FXML
    private TableView<PaymentRecord> trackPaymentTableView;

    @FXML
    private TextField patientNameTextField;

    @FXML
    private ComboBox<String> paymentStatusComboBox;

    private ObservableList<PaymentRecord> paymentRecords;

    @FXML
    public void initialize() {
        // TableColumn setup
        patientNameTableCol.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        amountTableCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusTableCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        dateTableCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Sample payment records
        paymentRecords = FXCollections.observableArrayList(
                new PaymentRecord("Alice", 500, "Pending", LocalDate.of(2025, 8, 1)),
                new PaymentRecord("Bob", 300, "Paid", LocalDate.of(2025, 8, 2)),
                new PaymentRecord("Charlie", 400, "Pending", LocalDate.of(2025, 8, 3))
        );

        trackPaymentTableView.setItems(paymentRecords);

        // ComboBox setup
        paymentStatusComboBox.setItems(FXCollections.observableArrayList("All", "Paid", "Pending"));
        paymentStatusComboBox.getSelectionModel().selectFirst();
    }

    @FXML
    public void searchButtonOnAction(ActionEvent actionEvent) {
        String nameFilter = patientNameTextField.getText().trim().toLowerCase();
        String statusFilter = paymentStatusComboBox.getSelectionModel().getSelectedItem();

        ObservableList<PaymentRecord> filtered = FXCollections.observableArrayList(
                paymentRecords.stream()
                        .filter(r -> (nameFilter.isEmpty() || r.getPatientName().toLowerCase().contains(nameFilter)) &&
                                (statusFilter.equals("All") || r.getStatus().equalsIgnoreCase(statusFilter)))
                        .collect(Collectors.toList())
        );

        trackPaymentTableView.setItems(filtered);
    }
}
