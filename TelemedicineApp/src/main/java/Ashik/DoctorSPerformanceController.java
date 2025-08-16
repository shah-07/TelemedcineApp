package Ashik;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class DoctorSPerformanceController {

    @FXML
    private TableView<DoctorPerformance> doctorTableView;
    @FXML
    private TableColumn<DoctorPerformance, String> doctorsNameCol;
    @FXML
    private TableColumn<DoctorPerformance, Double> avgRatingCol;
    @FXML
    private TableColumn<DoctorPerformance, Integer> feedbackCountCol;
    @FXML
    private TableColumn<DoctorPerformance, Integer> consultationFeeCol;
    @FXML
    private TextField statusTextField;


    private final ObservableList<DoctorPerformance> allDoctors = FXCollections.observableArrayList(
            new DoctorPerformance("Dr. Ashik Hossain", 4.5, 25, 120),
            new DoctorPerformance("Dr. Tasfia Rahman", 4.7, 30, 150),
            new DoctorPerformance("Dr. X", 4.2, 20, 100)
    );

    @FXML
    public void initialize() {
        // Bind table columns to DoctorPerformance properties
        doctorsNameCol.setCellValueFactory (new PropertyValueFactory<>("getValue().getDoctorName()"));
        avgRatingCol.setCellValueFactory( new PropertyValueFactory<>("getValue().getAvgRating()"));
        feedbackCountCol.setCellValueFactory( new PropertyValueFactory<>("getValue().getFeedbackCount()"));
        consultationFeeCol.setCellValueFactory(new PropertyValueFactory<>("getValue().getConsultationCount()"));

        doctorTableView.setItems(allDoctors);
    }

    @FXML
    public void searchReportButton(ActionEvent actionEvent) {
        String searchText = statusTextField.getText().trim().toLowerCase();

        if (searchText.isEmpty()) {
            doctorTableView.setItems(allDoctors);
            return;
        }

        ObservableList<DoctorPerformance> filteredList = FXCollections.observableArrayList();
        for (DoctorPerformance doc : allDoctors) {
            if (doc.getDoctorName().toLowerCase().contains(searchText)) {
                filteredList.add(doc);
            }
        }

        doctorTableView.setItems(filteredList);
    }
}
