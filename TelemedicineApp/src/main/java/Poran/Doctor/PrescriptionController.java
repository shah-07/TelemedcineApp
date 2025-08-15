package Poran.Doctor;

import Imtia.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class PrescriptionController
{
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
    private Label notesLabel;
    @javafx.fxml.FXML
    private TextField diagnosisTF;
    @javafx.fxml.FXML
    private TextField medicineTF;

    private ObservableList<Prescription> prescriptionList;
    private Prescription prescriptionToEdit;
    private ArrayList<String> medicineList;


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

    public void populateField(){
        showAgeLabel.setText(Integer.toString(prescriptionToEdit.getAge()));
        showNameLabel.setText(prescriptionToEdit.getName());
        showGenderLabel.setText(prescriptionToEdit.getGender());
        notesLabel.setText(prescriptionToEdit.getNotes());
    }

    @javafx.fxml.FXML
    public void initialize() {

        medicineList = new ArrayList<>();

    }

    @javafx.fxml.FXML
    public void sendPrescriptionButtonOA(ActionEvent actionEvent) {

        errorMessageLabel.setText("");
        successMessageLabel.setText("");

        if (diagnosisTF.getText().isEmpty() || medicineList.isEmpty()){
            errorMessageLabel.setText("Please enter medicine and diagnosis correctly");
            return;
        }

        for(Prescription p : prescriptionList){
            if (p.equals(prescriptionToEdit)){
                Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Press confirm to send prescription to patient");
                if (a.showAndWait().isPresent()){
                prescriptionToEdit.setPrescribed(true);
                prescriptionToEdit.setDiagnosis(diagnosisTF.getText());
                prescriptionToEdit.setMedicines(medicineList);
                }
            }
        }

        GenericFileManager.writeAll(prescriptionList, "Prescription.bin");
        successMessageLabel.setText("Prescribed medicine successfully");
        medicineList.clear();

    }

    @javafx.fxml.FXML
    public void addMedicineToMedicineList(ActionEvent actionEvent) {

        successMessageLabel.setText("");
        medicineList.add(medicineTF.getText());
        medicineTF.clear();
        successMessageLabel.setText("Medicine added to medicne List");

    }
}