package Ashik;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import jdk.internal.icu.text.UnicodeSet;

import java.time.LocalDate;

public class DoctorSPerformanceController {
    @FXML
    private TableColumn <DoctorPerformance, Float> avgRatingCol;
    @FXML
    private TableColumn <DoctorPerformance, Integer> feedbackCountCol;
    @FXML
    private TableColumn <DoctorPerformance, Integer> consultationFeeCol;
    @FXML
    private TextField statusTextField;
    @FXML
    private TableColumn <DoctorPerformance, String> doctorsNameCol;
    @FXML
    private TableView < DoctorPerformance> doctorsPerformanceTableView;
    @FXML
    private DatePicker toDateDP;
    @FXML
    private DatePicker fromDateDP;
    private UnicodeSet doctorData;

    @FXML
    public void initialize() {
        doctorsNameCol.setCellValueFactory(new PropertyValueFactory<>("doctorName"));
        avgRatingCol.setCellValueFactory(new PropertyValueFactory<>("avgRating"));
        feedbackCountCol.setCellValueFactory(new PropertyValueFactory<>("feedbackCount"));
        consultationFeeCol.setCellValueFactory(new PropertyValueFactory<>("consultationCount"));

        ObservableList<DoctorPerformance> doctorData = null;
        doctorsPerformanceTableView.setItems(doctorData);
        loadSampleData();
    }
    private void loadSampleData() {

        doctorData.add((CharSequence) new DoctorPerformance("Dr. abc", 4.5, 20, 50));
        doctorData.add((CharSequence) new DoctorPerformance("Dr. def", 4.8, 15, 45));
    }

    @FXML
    public void searchReportButton(ActionEvent actionEvent) {
            LocalDate fromDate = fromDateDP.getValue();
            LocalDate toDate = toDateDP.getValue();
            String status = statusTextField.getText();

            System.out.println("Searching reports from " + fromDate + " to " + toDate + " with status: " + status);
        }
}
