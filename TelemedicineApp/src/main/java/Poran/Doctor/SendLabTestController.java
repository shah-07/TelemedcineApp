package Poran.Doctor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class SendLabTestController
{
    @javafx.fxml.FXML
    private Label notesLabel;
    @javafx.fxml.FXML
    private Label showNameLabel;
    @javafx.fxml.FXML
    private Label showAgeLabel;
    @javafx.fxml.FXML
    private Label errorMessageLabel;
    @javafx.fxml.FXML
    private Label showGenderLabel;
    @javafx.fxml.FXML
    private Label successMessageLabel;
    @javafx.fxml.FXML
    private TextField labTestTF;


    private ObservableList<Prescription> prescriptionList;
    private ObservableList<LabTestForm> labTestList = FXCollections.observableArrayList();
    private Prescription prescriptionToEdit;
    private ArrayList<String> testList;
    @javafx.fxml.FXML
    private TextField diagnosisTF;


    public Prescription getPrescriptionToEdit() {
        return prescriptionToEdit;
    }

    public void setPrescriptionToEdit(Prescription prescriptionToEdit) {
        this.prescriptionToEdit = prescriptionToEdit;
    }

    public ObservableList<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    public void setPrescriptionList(ObservableList<Prescription> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }
    private String doctorName;

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    @javafx.fxml.FXML
    public void initialize() {

        testList = new ArrayList<>();

    }

    public void populateFields(){
        showAgeLabel.setText(Integer.toString(prescriptionToEdit.getAge()));
        showNameLabel.setText(prescriptionToEdit.getName());
        showGenderLabel.setText(prescriptionToEdit.getGender());
        notesLabel.setText(prescriptionToEdit.getNotes());
    }

    @javafx.fxml.FXML
    public void addTestsToTestList(ActionEvent actionEvent) {

        successMessageLabel.setText("");
        errorMessageLabel.setText("");

        if(labTestTF.getText().isEmpty()){
            errorMessageLabel.setText("Please enter a test name to add");
            return;
        }

        successMessageLabel.setText("");
        testList.add(labTestTF.getText());
        labTestTF.clear();
        successMessageLabel.setText("Test added to test List");

    }

    @javafx.fxml.FXML
    public void sendTestRequestButtonOA(ActionEvent actionEvent) {

        if (diagnosisTF.getText().isEmpty() || testList.isEmpty()){
            errorMessageLabel.setText("Please enter diagnosis and tests");
            return;
        }

        labTestList.add( new LabTestForm(
                prescriptionToEdit.getName(),
                prescriptionToEdit.getGender(),
                doctorName,
                diagnosisTF.getText(),
                testList,
                prescriptionToEdit.getNotes(),
                prescriptionToEdit.getAge(),
                LocalDate.now(),
                LocalTime.now()
                    )
        );
        GenericFileManager.writeAll(labTestList, "LabTestForm.bin");
        diagnosisTF.clear();
        labTestTF.clear();
        showNameLabel.setText("");
        showAgeLabel.setText("");
        showGenderLabel.setText("");
        notesLabel.setText("");
    }


}