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
    private TableColumn<LabTestForm, String> nameTC;
    @javafx.fxml.FXML
    private TableColumn<LabTestForm, Integer> ageTV;
    @javafx.fxml.FXML
    private TableColumn<LabTestForm, LocalDate> dateTC;
    @javafx.fxml.FXML
    private TableColumn<LabTestForm, LocalTime> timeTC;
    @javafx.fxml.FXML
    private Label errorMessageLabel;
    @javafx.fxml.FXML
    private TextField fromTime;
    @javafx.fxml.FXML
    private TextField patientNameTF;
    @javafx.fxml.FXML
    private TableColumn<LabTestForm, String> diagnosisTC;
    @javafx.fxml.FXML
    private Label successMessageLabel;
    @javafx.fxml.FXML
    private TextField toTime;
    @javafx.fxml.FXML
    private TextField doctorNameTF;



    private ObservableList<LabTestForm> labTestFormList = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {

        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageTV.setCellValueFactory(new PropertyValueFactory<>("age"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeTC.setCellValueFactory(new PropertyValueFactory<>("time"));

    }

    @javafx.fxml.FXML
    public void loadTestButtonOA(ActionEvent actionEvent) {

        labTestFormList = GenericFileManager.readAll(LabTestForm.class, "LabTestForm.bin");
        if (!doctorNameTF.getText().isEmpty()){
            //
        }

    }
}