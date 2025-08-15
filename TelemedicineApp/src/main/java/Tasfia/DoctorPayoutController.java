package Tasfia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.stream.Collectors;

public class DoctorPayoutController {

    @FXML
    private TableView<DoctorPayoutRecord> payoutManagementTableView;

    @FXML
    private TextField doctorNameTextField;

    @FXML
    private TableColumn<DoctorPayoutRecord, String> statusTableColumn;

    @FXML
    private TableColumn<DoctorPayoutRecord, Double> amountTableColumn;

    @FXML
    private TableColumn<DoctorPayoutRecord, String> doctorsNameTableColumn;

    @FXML
    private TableColumn<DoctorPayoutRecord, LocalDate> dateTableColumn;

    private ObservableList<DoctorPayoutRecord> payoutRecords;

    @FXML
    public void initialize() {
        // TableColumn setup
        doctorsNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("doctorName"));
        amountTableColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Sample data
        payoutRecords = FXCollections.observableArrayList(
                new DoctorPayoutRecord("Dr. Tasfia", 5000, "Paid", LocalDate.of(2025,8,1)),
                new DoctorPayoutRecord("Dr. Rahman", 3000, "Pending", LocalDate.of(2025,8,2)),
                new DoctorPayoutRecord("Dr. Karim", 4000, "Paid", LocalDate.of(2025,8,3))
        );

        payoutManagementTableView.setItems(payoutRecords);
    }

    @FXML
    public void searchButtonOnAction(ActionEvent actionEvent) {
        String searchText = doctorNameTextField.getText().trim().toLowerCase();
        if (searchText.isEmpty()) {
            payoutManagementTableView.setItems(payoutRecords);
        } else {
            ObservableList<DoctorPayoutRecord> filtered = FXCollections.observableArrayList(
                    payoutRecords.stream()
                            .filter(r -> r.getDoctorName().toLowerCase().contains(searchText))
                            .collect(Collectors.toList())
            );
            payoutManagementTableView.setItems(filtered);
        }
    }
}
