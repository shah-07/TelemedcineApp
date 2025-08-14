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

public class CompletedTestTypeView
{
    @javafx.fxml.FXML
    private TableColumn<LabTestForm, LocalTime> timeTC;
    @javafx.fxml.FXML
    private DatePicker chooseDateDP;
    @javafx.fxml.FXML
    private TableColumn<LabTestForm, String> nameTC;
    @javafx.fxml.FXML
    private TableColumn<LabTestForm, LocalDate> dateTC;
    @javafx.fxml.FXML
    private TextField fromTimeTF;
    @javafx.fxml.FXML
    private TableView<LabTestForm> labTestRequestsTV;
    @javafx.fxml.FXML
    private TableColumn<LabTestForm, String> testTypeTC;
    @javafx.fxml.FXML
    private TextField patientsNameTF;
    @javafx.fxml.FXML
    private Label errorMessageLabel;
    @javafx.fxml.FXML
    private Label successMessageLabel;




    private ObservableList<LabTestForm> labTestFormList = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private TextField toTimeTF;

    @javafx.fxml.FXML
    public void initialize() {

        timeTC.setCellValueFactory(new PropertyValueFactory<>("time"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        testTypeTC.setCellValueFactory(new PropertyValueFactory<>("testList"));

    }

    @javafx.fxml.FXML
    public void labTestRequestsButtonOA(ActionEvent actionEvent) {

        successMessageLabel.setText("");
        errorMessageLabel.setText("");
        labTestRequestsTV.getItems().clear();
        boolean found = false;
        LocalTime fromTime = LocalTime.parse(fromTimeTF.getText());
        LocalTime toTime = LocalTime.parse(toTimeTF.getText());

        labTestFormList = GenericFileManager.readAll(LabTestForm.class, "LabTestForm.bin");
        if (chooseDateDP.getValue() == null || fromTimeTF.getText().isEmpty() || toTimeTF.getText().isEmpty()) {
            errorMessageLabel.setText("Please select Data and TIme");
            return;
        }
        for (LabTestForm l : labTestFormList) {
            if ((chooseDateDP.getValue().equals(l.getDate()) && ((l.getTime().equals(fromTime) || l.getTime().isAfter(fromTime)) && (l.getTime().equals(toTime) || l.getTime().isBefore(toTime)))) && !l.isCompleted()) {
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

    @javafx.fxml.FXML
    public void markAsCompletedButtonOA(ActionEvent actionEvent) {

        labTestRequestsTV.getItems().clear();
        errorMessageLabel.setText("");
        successMessageLabel.setText("");
        LabTestForm selectedOne = labTestRequestsTV.getSelectionModel().getSelectedItem();
        if(selectedOne == null){
            errorMessageLabel.setText("Please select a test request to show full information");
            return;
        }
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Press confirm to mark the test as completed");
        if(a.showAndWait().isPresent()){
            selectedOne.setCompleted(true);
            successMessageLabel.setText("Test completion successfully");
        }
        GenericFileManager.writeAll(labTestFormList, "LabTestForm.bin");
    }
}