package Tasfia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class GenerateInvoiceController {

    @FXML
    private DatePicker startDateDatePicker;

    @FXML
    private DatePicker endDateDatePicker;

    @FXML
    private TextField doctorNameTextField;

    @FXML
    private TextArea showInvoiceTextArea;

    private ObservableList<DoctorInvoiceRecord> invoiceRecords;

    @FXML
    public void initialize() {
        // Sample invoice records
        invoiceRecords = FXCollections.observableArrayList(
                new DoctorInvoiceRecord("Dr. Tasfia", LocalDate.of(2025, 8, 1), 5000),
                new DoctorInvoiceRecord("Dr. Rahman", LocalDate.of(2025, 8, 2), 3000),
                new DoctorInvoiceRecord("Dr. Karim", LocalDate.of(2025, 8, 3), 4000)
        );
    }

    @FXML
    public void generateButtonOnAction(ActionEvent actionEvent) {
        String doctorNameFilter = doctorNameTextField.getText().trim().toLowerCase();
        LocalDate startDate = startDateDatePicker.getValue();
        LocalDate endDate = endDateDatePicker.getValue();

        StringBuilder invoiceText = new StringBuilder();
        double totalAmount = 0;

        for (DoctorInvoiceRecord record : invoiceRecords) {
            boolean matchesDoctor = doctorNameFilter.isEmpty() || record.getDoctorName().toLowerCase().contains(doctorNameFilter);
            boolean matchesDate = (startDate == null || !record.getDate().isBefore(startDate)) &&
                    (endDate == null || !record.getDate().isAfter(endDate));
            if (matchesDoctor && matchesDate) {
                invoiceText.append(record.getDoctorName())
                        .append(" | ")
                        .append(record.getDate())
                        .append(" | ")
                        .append(record.getAmount())
                        .append("\n");
                totalAmount += record.getAmount();
            }
        }

        invoiceText.append("\nTotal Amount: ").append(totalAmount);
        showInvoiceTextArea.setText(invoiceText.toString());
    }

    @FXML
    public void downloadPdfButtonOnAction(ActionEvent actionEvent) {
        // Placeholder: PDF export requires library like iText or PDFBox
        System.out.println("PDF download not implemented yet.");
    }
}
