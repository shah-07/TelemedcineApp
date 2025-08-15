package Poran.LabTechnician;

import Poran.Doctor.GenericFileManager;
import Poran.Doctor.LabTestForm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.LocalTime;
import java.util.ArrayList;

public class ManageBookingController
{
    @javafx.fxml.FXML
    private TableColumn<LabTestForm, LocalTime> timeTC;
    @javafx.fxml.FXML
    private TextField fromTimeTF;
    @javafx.fxml.FXML
    private TableColumn<LabTestForm, String> nameTC;
    @javafx.fxml.FXML
    private Label errorMessageLabel;
    @javafx.fxml.FXML
    private TextField toTimeTF;
    @javafx.fxml.FXML
    private TableColumn<LabTestForm, String> doctorNameTC;
    @javafx.fxml.FXML
    private DatePicker dateDP;
    @javafx.fxml.FXML
    private Label successMessageLabel;
    @javafx.fxml.FXML
    private TableView<LabTestForm> labTestTV;
    @javafx.fxml.FXML
    private TableColumn<LabTestForm, ArrayList<String>> testTypeTC;

    ObservableList<LabTestForm> labTestList = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private TextField newTime;
    @javafx.fxml.FXML
    private DatePicker newDate;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void rescheduleButtonOA(ActionEvent actionEvent) {

        LabTestForm selectedOne = labTestTV.getSelectionModel().getSelectedItem();
        if(selectedOne == null){
            errorMessageLabel.setText("Please select a test request to reschedule");
            return;
        }

        if(newDate.getValue() == null || newTime.getText().isEmpty()){
            errorMessageLabel.setText("Please select new date and time to reschedule");
            return;
        }

        for(LabTestForm l : labTestList){
            if (selectedOne.equals(l)){
                Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Press confirm to reschedule the test request");
                if(a.showAndWait().isPresent()){
                    l.setDate(newDate.getValue());
                    l.setTime(LocalTime.parse(newTime.getText()));
                    successMessageLabel.setText("Test rescheduled successfully");
                    return;

                }
            }
        }
        GenericFileManager.writeAll(labTestList, "LabTestForm.bin");

    }

    @javafx.fxml.FXML
    public void loadReportsButtonOA(ActionEvent actionEvent) {

        successMessageLabel.setText("");
        errorMessageLabel.setText("");
        labTestTV.getItems().clear();
        boolean found = false;
        LocalTime fromTime = LocalTime.parse(fromTimeTF.getText());
        LocalTime toTime = LocalTime.parse(toTimeTF.getText());

        if (dateDP.getValue() == null || fromTimeTF.getText().isEmpty() || toTimeTF.getText().isEmpty()){
            errorMessageLabel.setText("Please select date and time");
            return;
        }
        labTestList = GenericFileManager.readAll(LabTestForm.class, "LabTestForm.bin");

        for(LabTestForm l : labTestList) {
            if (dateDP.getValue().equals(l.getDate()) && ((l.getTime().equals(fromTime) || l.getTime().isAfter(fromTime)) && (l.getTime().equals(toTime) || l.getTime().isBefore(toTime)))) {
                labTestTV.getItems().add(l);
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