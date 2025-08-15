package Tasfia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class ExportTransactionDataController {

    @FXML
    private TableColumn<TransactionRecord, Double> amountTableCol;

    @FXML
    private TableColumn<TransactionRecord, String> TypeTableCol;

    @FXML
    private TableColumn<TransactionRecord, String> IdTableCol;

    @FXML
    private TableColumn<TransactionRecord, LocalDate> dateTableCol;

    @FXML
    private ComboBox<String> chooseComboBox;

    @FXML
    private TableView<TransactionRecord> transactionDataTableView;

    private ObservableList<TransactionRecord> transactionRecords;

    @FXML
    public void initialize() {
        // TableColumn setup
        IdTableCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TypeTableCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        amountTableCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateTableCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Sample data
        transactionRecords = FXCollections.observableArrayList(
                new TransactionRecord("T001", "Income", 1000, LocalDate.of(2025, 8, 1)),
                new TransactionRecord("T002", "Expense", 500, LocalDate.of(2025, 8, 2)),
                new TransactionRecord("T003", "Income", 1500, LocalDate.of(2025, 8, 3))
        );

        // Load data into TableView
        transactionDataTableView.setItems(transactionRecords);

        // ComboBox setup (filter options)
        chooseComboBox.setItems(FXCollections.observableArrayList("All", "Income", "Expense"));
        chooseComboBox.getSelectionModel().selectFirst();
    }

    @FXML
    public void downloadReadyButtonOnAction(ActionEvent actionEvent) {
        // CSV download
        try (FileWriter writer = new FileWriter("transaction_data.csv")) {
            writer.write("ID,Type,Amount,Date\n");
            for (TransactionRecord record : transactionRecords) {
                writer.write(record.getId() + "," + record.getType() + "," + record.getAmount() + "," + record.getDate() + "\n");
            }
            System.out.println("CSV file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void exportButtonOnAction(ActionEvent actionEvent) {
        // Filter by ComboBox selection
        String filter = chooseComboBox.getSelectionModel().getSelectedItem();
        if (filter.equals("All")) {
            transactionDataTableView.setItems(transactionRecords);
        } else {
            ObservableList<TransactionRecord> filtered = FXCollections.observableArrayList(
                    transactionRecords.filtered(r -> r.getType().equalsIgnoreCase(filter))
            );
            transactionDataTableView.setItems(filtered);
        }
    }
}
