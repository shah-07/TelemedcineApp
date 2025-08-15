package Poran.LabTechnician;

import Poran.Doctor.GenericFileManager;
import Poran.Doctor.LabTestForm;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class CompletedTestsController
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
    private TextField patientsNameTF;

    @javafx.fxml.FXML
    public void initialize() {

        timeTC.setCellValueFactory(new PropertyValueFactory<>("time"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        testTypeTC.setCellValueFactory(new PropertyValueFactory<>("testList"));
        resultTC.setCellValueFactory(new PropertyValueFactory<>("result"));

    }

    @javafx.fxml.FXML
    public void loadTestsButtonOA(ActionEvent actionEvent) {

        successMessageLabel.setText("");
        errorMessageLabel.setText("");
        labTestRequestsTV.getItems().clear();
        boolean found = false;
        LocalTime fromTime = LocalTime.parse(fromTimeTF.getText());
        LocalTime toTime = LocalTime.parse(toTimeTF.getText());

        ObservableList<LabTestForm> labTestFormList = GenericFileManager.readAll(LabTestForm.class, "LabTestForm.bin");
        if (chooseDateDP.getValue() == null || fromTimeTF.getText().isEmpty() || toTimeTF.getText().isEmpty()) {
            errorMessageLabel.setText("Please select Data and TIme");
            return;
        }

        if(fromTime.isAfter(toTime)){
            errorMessageLabel.setText("From time cannot be greater than To time");
            return;
        }

        if(!patientsNameTF.getText().isEmpty()){
            for (LabTestForm l : labTestFormList) {
                if ((chooseDateDP.getValue().equals(l.getDate()) && ((l.getTime().equals(fromTime) || l.getTime().isAfter(fromTime)) && (l.getTime().equals(toTime) || l.getTime().isBefore(toTime)))) && l.isCompleted() && l.getPatientName().equals(patientsNameTF.getText())) {
                    labTestRequestsTV.getItems().add(l);
                    found = true;
                }
            }

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
}