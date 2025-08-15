package Poran.LabTechnician;

import Poran.Doctor.GenericFileManager;
import Poran.Doctor.LabTestForm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.LocalTime;

public class LabTestRequestController
{

    @javafx.fxml.FXML
    private DatePicker chooseDateDP;
    @javafx.fxml.FXML
    private TableView<LabTestForm> testTV;
    @javafx.fxml.FXML
    private TableColumn<LabTestForm, Integer> ageTV;
    @javafx.fxml.FXML
    private TableColumn<LabTestForm, LocalDate> dateTC;
    @javafx.fxml.FXML
    private TableColumn<LabTestForm, LocalTime> timeTC;
    @javafx.fxml.FXML
    private Label errorMessageLabel;
    @javafx.fxml.FXML
    private TextField fromTimeTF;
    @javafx.fxml.FXML
    private TextField patientNameTF;
    @javafx.fxml.FXML
    private TableColumn<LabTestForm, String> diagnosisTC;
    @javafx.fxml.FXML
    private Label successMessageLabel;
    @javafx.fxml.FXML
    private TextField toTimeTF;
    @javafx.fxml.FXML
    private TextField doctorNameTF;
    @javafx.fxml.FXML
    private TableColumn<LabTestForm, String> patientNameTC;
    @javafx.fxml.FXML
    private TableColumn<LabTestForm, String> doctorNameTC;


    private ObservableList<LabTestForm> labTestFormList = FXCollections.observableArrayList();



    @javafx.fxml.FXML
    public void initialize() {

        patientNameTC.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        doctorNameTC.setCellValueFactory(new PropertyValueFactory<>("doctorName"));
        ageTV.setCellValueFactory(new PropertyValueFactory<>("age"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeTC.setCellValueFactory(new PropertyValueFactory<>("time"));

    }

    @javafx.fxml.FXML
    public void loadTestButtonOA(ActionEvent actionEvent) {

        successMessageLabel.setText("");
        errorMessageLabel.setText("");
        testTV.getItems().clear();
        boolean found = false;
        LocalTime fromTime = LocalTime.parse(fromTimeTF.getText());
        LocalTime toTime = LocalTime.parse(toTimeTF.getText());

        labTestFormList = GenericFileManager.readAll(LabTestForm.class, "LabTestForm.bin");
        if (chooseDateDP.getValue() == null || fromTimeTF.getText().isEmpty() || toTimeTF.getText().isEmpty()) {
            errorMessageLabel.setText("Please select Data and TIme");
            return;
        }
        for (LabTestForm l : labTestFormList) {
            if (chooseDateDP.getValue().equals(l.getDate()) && ((l.getTime().equals(fromTime) || l.getTime().isAfter(fromTime)) && (l.getTime().equals(toTime) || l.getTime().isBefore(toTime)))) {
                testTV.getItems().add(l);
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

    @javafx.fxml.FXML
    public void showFullInfoButtonOA(ActionEvent actionEvent) {

        errorMessageLabel.setText("");
        successMessageLabel.setText("");
        LabTestForm selectedOne = testTV.getSelectionModel().getSelectedItem();
        if(selectedOne == null){
            errorMessageLabel.setText("Please select a test request to show full information");
            return;
        }
        Alert a = new Alert(Alert.AlertType.INFORMATION, selectedOne.toString());
        a.showAndWait();

    }
}