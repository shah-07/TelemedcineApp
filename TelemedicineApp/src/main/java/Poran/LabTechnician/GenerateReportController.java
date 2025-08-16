package Poran.LabTechnician;

import Poran.Doctor.GenericFileManager;
import Poran.Doctor.LabTestForm;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Paragraph;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.*;
import com.itextpdf.layout.Document;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class GenerateReportController
{
    @javafx.fxml.FXML
    private TableColumn<LabTestForm, LocalTime> timeTC;
    @javafx.fxml.FXML
    private TableColumn<LabTestForm, String> resultTC;
    @javafx.fxml.FXML
    private DatePicker chooseDateDP;
    @javafx.fxml.FXML
    private TableColumn<LabTestForm, String> nameTC;
    @javafx.fxml.FXML
    private Label errorMessageLabel;
    @javafx.fxml.FXML
    private TextField toTimeTF;
    @javafx.fxml.FXML
    private TableColumn<LabTestForm, LocalDate> dateTC;
    @javafx.fxml.FXML
    private Label successMessageLabel;
    @javafx.fxml.FXML
    private TextField fromTimeTF;
    @javafx.fxml.FXML
    private TableView<LabTestForm> labTestRequestsTV;
    @javafx.fxml.FXML
    private TableColumn<LabTestForm, ArrayList<String>> testTypeTC;

    @javafx.fxml.FXML
    public void initialize() {

        timeTC.setCellValueFactory(new PropertyValueFactory<>("time"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        testTypeTC.setCellValueFactory(new PropertyValueFactory<>("testList"));
        resultTC.setCellValueFactory(new PropertyValueFactory<>("result"));

    }

    @javafx.fxml.FXML
    public void saveAsPdfButtonOA(ActionEvent actionEvent) {

        successMessageLabel.setText("");

        LabTestForm selectedTest = labTestRequestsTV.getSelectionModel().getSelectedItem();

        if (selectedTest != null) {
            pdfGenerator (selectedTest);
            successMessageLabel.setText("PDF Generated Successfully");
        }
        else{
            errorMessageLabel.setText("Please select an Test report");
        }


    }

    @javafx.fxml.FXML
    public void loadTestsButtonOA(ActionEvent actionEvent) {

        labTestRequestsTV.getItems().clear();
        successMessageLabel.setText("");
        errorMessageLabel.setText("");
        if (chooseDateDP.getValue() == null || fromTimeTF.getText().isEmpty() || toTimeTF.getText().isEmpty()) {
            errorMessageLabel.setText("Please select Data and TIme");
            return;
        }

        boolean found = false;
        LocalTime fromTime = LocalTime.parse(fromTimeTF.getText());
        LocalTime toTime = LocalTime.parse(toTimeTF.getText());

        ObservableList<LabTestForm> labTestFormList = GenericFileManager.readAll(LabTestForm.class, "LabTestForm.bin");

        if (fromTime.isAfter(toTime)) {
            errorMessageLabel.setText("From time cannot be greater than To time");
            return;
        }
        for (LabTestForm l : labTestFormList) {
            if ((chooseDateDP.getValue().equals(l.getDate()) && ((l.getTime().equals(fromTime) || l.getTime().isAfter(fromTime)) && (l.getTime().equals(toTime) || l.getTime().isBefore(toTime)))) && l.isCompleted()) {
                labTestRequestsTV.getItems().add(l);
                found = true;
            }
        }
        if (found){
            successMessageLabel.setText("Test Requests Loaded");
        }
        else {
            errorMessageLabel.setText("No test requests to show");
        }
    }

    public void pdfGenerator (LabTestForm test){

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Lab Test Report");
        fileChooser.setInitialFileName(test.getPatientName() + "_Report.pdf");
        File file = fileChooser.showSaveDialog(new Stage());

        if (file != null) {
            try {
                PdfWriter writer = new PdfWriter(file.getAbsolutePath());
                PdfDocument pdf = new PdfDocument(writer);
                Document document = new Document(pdf);

                document.add(new Paragraph("Lab Test Report"));
                document.add(new Paragraph("Patient: " + test.getPatientName()));
                document.add(new Paragraph("Doctor: " + test.getDoctorName()));
                document.add(new Paragraph("Test: " + test.getTestList()));
                document.add(new Paragraph("Result: " + test.getResult()));
                document.add(new Paragraph("Date: " + test.getDate()));
                document.add(new Paragraph("Technician: " + test.getTechnicianName()));

                document.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}