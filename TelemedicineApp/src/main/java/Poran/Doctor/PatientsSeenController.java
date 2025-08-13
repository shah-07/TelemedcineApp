package Poran.Doctor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class PatientsSeenController
{
    @javafx.fxml.FXML
    private TableView<Prescription> patientsTV;
    @javafx.fxml.FXML
    private TableColumn<Prescription, String> genderTC;
    @javafx.fxml.FXML
    private TableColumn<Prescription, String> nameTC;
    @javafx.fxml.FXML
    private Label errorMessageLabel;
    @javafx.fxml.FXML
    private TableColumn<Prescription, Integer> ageTC;
    @javafx.fxml.FXML
    private TableColumn<Prescription, String> notesTC;
    @javafx.fxml.FXML
    private Label successMessageLabel;
    @javafx.fxml.FXML
    private Button loadPatientButton;


    ObservableList<Prescription> prescriptionList = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {

        genderTC.setCellValueFactory(new PropertyValueFactory<>("gender"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageTC.setCellValueFactory(new PropertyValueFactory<>("age"));
        notesTC.setCellValueFactory(new PropertyValueFactory<>("notes"));

        patientsTV.setItems(prescriptionList);

    }

    @javafx.fxml.FXML
    public void prescribeMedicineOA(ActionEvent actionEvent) throws IOException {

        Prescription selectedPrescription = patientsTV.getSelectionModel().getSelectedItem();
        if (selectedPrescription == null){
            errorMessageLabel.setText("Please select a Patient");
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Poran/Doctor/prescriptionView.fxml"));
        Parent root = loader.load();
        PrescriptionController nextController = loader.getController();
        nextController.setPrescriptionList(prescriptionList);
        nextController.setPrescriptionToEdit(selectedPrescription);
        loadPatientButton.getScene().setRoot(root);

    }

    @javafx.fxml.FXML
    public void referToLabOA(ActionEvent actionEvent) throws IOException{

        Prescription selectedPrescription = patientsTV.getSelectionModel().getSelectedItem();
        if (selectedPrescription == null){
            errorMessageLabel.setText("Please select a Patient");
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Poran/Doctor/sendLabTestView.fxml"));
        Parent root = loader.load();
        PrescriptionController nextController = loader.getController();
        nextController.setPrescriptionList(prescriptionList);
        nextController.setPrescriptionToEdit(selectedPrescription);
        loadPatientButton.getScene().setRoot(root);
    }

    @javafx.fxml.FXML
    public void loadPatientButtonOA(ActionEvent actionEvent) {

        errorMessageLabel.setText("");
        successMessageLabel.setText("");

        prescriptionList = GenericFileManager.readAll(Prescription.class, "Prescription.bin");
        for (Prescription p : prescriptionList){
            if (!p.isPrescribed()){
                patientsTV.getItems().add(p);
            }
        }
        if(patientsTV.getItems().isEmpty()){
            errorMessageLabel.setText("No patients to load");
        }
        else {
            successMessageLabel.setText("Patients Loaded");
        }
    }
}