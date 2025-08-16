package Poran.Doctor;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;


public class GeneratePrescriptionController {

    @javafx.fxml.FXML
    private TableColumn<Prescription, LocalTime> timeTC;
    @javafx.fxml.FXML
    private DatePicker chooseDateDP;
    @javafx.fxml.FXML
    private TableColumn<Prescription, String> nameTC;
    @javafx.fxml.FXML
    private Label errorMessageLabel;
    @javafx.fxml.FXML
    private TextField toTimeTF;
    @javafx.fxml.FXML
    private TableColumn<Prescription, LocalDate> dateTC;
    @javafx.fxml.FXML
    private TableColumn<Prescription, String> medicinesTC;
    @javafx.fxml.FXML
    private Label successMessageLabel;
    @javafx.fxml.FXML
    private TextField fromTimeTF;
    @javafx.fxml.FXML
    private TableView<Prescription> prescriptionTV;

    @javafx.fxml.FXML
    public void initialize() {

        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        timeTC.setCellValueFactory(new PropertyValueFactory<>("time"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        medicinesTC.setCellValueFactory(new PropertyValueFactory<>("medicines"));

    }

    @javafx.fxml.FXML
    public void saveAsPdfButtonOA(ActionEvent actionEvent) {

        successMessageLabel.setText("");

        Prescription selectedOne = prescriptionTV.getSelectionModel().getSelectedItem();

        if (selectedOne != null) {
            pdfGenerator (selectedOne);
            successMessageLabel.setText("PDF Generated Successfully");
        }
        else{
            errorMessageLabel.setText("Please select a prescription");
        }


    }

    @javafx.fxml.FXML
    public void loadTestsButtonOA(ActionEvent actionEvent) {

        ObservableList<Prescription> prescriptionList = GenericFileManager.readAll(Prescription.class, "Prescription.bin");
        if (chooseDateDP.getValue() == null || fromTimeTF.getText().isEmpty() || toTimeTF.getText().isEmpty()) {
            errorMessageLabel.setText("Please select Data and TIme");
            return;
        }

        successMessageLabel.setText("");
        errorMessageLabel.setText("");
        prescriptionTV.getItems().clear();
        boolean found = false;
        LocalTime fromTime = LocalTime.parse(fromTimeTF.getText());
        LocalTime toTime = LocalTime.parse(toTimeTF.getText());

        if (fromTime.isAfter(toTime)) {
            errorMessageLabel.setText("From time cannot be greater than To time");
            return;
        }

        for (Prescription a : prescriptionList) {
            if ((chooseDateDP.getValue().equals(a.getDate()) && ((a.getTime().equals(fromTime) || a.getTime().isAfter(fromTime)) && (a.getTime().equals(toTime) || a.getTime().isBefore(toTime)))) && a.isPrescribed()) {
                prescriptionTV.getItems().add(a);
                found = true;
            }
        }
        if (found) {
            successMessageLabel.setText("Prescription Loaded");
        } else {
            errorMessageLabel.setText("No Prescription to show");
        }
    }


        public void pdfGenerator (Prescription prescription){

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Prescription");
            fileChooser.setInitialFileName(prescription.getName() + "_Prescription.pdf");
            File file = fileChooser.showSaveDialog(new Stage());

            if (file != null) {
                try {
                    PdfWriter writer = new PdfWriter(file.getAbsolutePath());
                    PdfDocument pdf = new PdfDocument(writer);
                    Document document = new Document(pdf);

                    document.add(new Paragraph("Prescription"));
                    document.add(new Paragraph("Patient: " + prescription.getName()));
                    document.add(new Paragraph("Age: " + prescription.getAge()));
                    document.add(new Paragraph("Gender: " + prescription.getGender()));
                    document.add(new Paragraph("Medicines: " + prescription.getMedicines()));
                    document.add(new Paragraph("Diagnosis: " + prescription.getDiagnosis()));
                    document.add(new Paragraph("Date: " + prescription.getDate()));
                    document.add(new Paragraph("Time: " + prescription.getTime()));

                    document.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
}