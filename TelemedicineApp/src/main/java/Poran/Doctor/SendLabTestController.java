package Poran.Doctor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

    @javafx.fxml.FXML
    public void initialize() {
        showAgeLabel.setText(Integer.toString(prescriptionToEdit.getAge()));
        showNameLabel.setText(prescriptionToEdit.getName());
        showGenderLabel.setText(prescriptionToEdit.getGender());
        notesLabel.setText(prescriptionToEdit.getNotes());
        testList = new ArrayList<>();

    }

    @javafx.fxml.FXML
    public void addTestsToTestList(ActionEvent actionEvent) {

        successMessageLabel.setText("");
        testList.add(labTestTF.getText());
        labTestTF.clear();
        successMessageLabel.setText("Test added to test List");

    }

    @javafx.fxml.FXML
    public void sendTestRequestButtonOA(ActionEvent actionEvent) {

        labTestList.add( new LabTestForm(
                prescriptionToEdit.getName(),
                prescriptionToEdit.getGender(),
                testList,
                prescriptionToEdit.getNotes(),
                prescriptionToEdit.getAge()
                    )
        );
        GenericFileManager.writeAll(labTestList, "LabTestForm.bin");
    }


}