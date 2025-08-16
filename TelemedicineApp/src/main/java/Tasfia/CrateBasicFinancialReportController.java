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

public class CrateBasicFinancialReportController {

    @FXML
    private ComboBox<String> timeRangeComboBox;

    @FXML
    private TableView<FinancialRecord> financialReportTableView;

    @FXML
    private TableColumn<FinancialRecord, String> dateTableColumn;

    @FXML
    private TableColumn<FinancialRecord, Double> totalIncomeTableColumn;

    @FXML
    private TableColumn<FinancialRecord, Double> payoutTableColumn;

    @FXML
    private TableColumn<FinancialRecord, Double> refundTableColumn;

    // ✅ Class-level variable to store financial data
    private ObservableList<FinancialRecord> financialReport;


    @javafx.fxml.FXML
    public void initialize() {

        // TableColumn setup
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        totalIncomeTableColumn.setCellValueFactory(new PropertyValueFactory<>("totalIncome"));
        payoutTableColumn.setCellValueFactory(new PropertyValueFactory<>("payout"));
        refundTableColumn.setCellValueFactory(new PropertyValueFactory<>("refund"));

        // Initialize class-level list
        financialReport = FXCollections.observableArrayList();
        financialReport.add(new FinancialRecord("2025-08-01", 1000, 200, 50));
        financialReport.add(new FinancialRecord("2025-08-02", 1500, 300, 100));
        financialReport.add(new FinancialRecord("2025-08-03", 2000, 500, 150));

        // Load data into TableView
        financialReportTableView.setItems(financialReport);

        // ComboBox setup
        timeRangeComboBox.setItems(FXCollections.observableArrayList("Today", "Last 7 Days", "This Month"));
        timeRangeComboBox.getSelectionModel().selectFirst();
    }

    @javafx.fxml.FXML
    public void downloadAsCvButtonOnAction(ActionEvent actionEvent) {

        try (FileWriter writer = new FileWriter("financial_report.csv")) {
            // CSV header
            writer.write("Date,Total Income,Payout,Refund\n");

            // Write data
            for (FinancialRecord record : financialReport) {
                writer.write(record.getDate() + "," + record.getTotalIncome() + "," + record.getPayout() + "," + record.getRefund() + "\n");
            }
            System.out.println("CSV file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @javafx.fxml.FXML
    public void downloadAsPdfButtonOnAction(ActionEvent actionEvent) {

        System.out.println("PDF download feature not implemented yet.");


    }
}