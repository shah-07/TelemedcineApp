package Poran.Doctor;

import Imtia.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.util.ArrayList;

public class NotesForPrescriptionController
{
    @javafx.fxml.FXML
    private Label errorMessageLabel;
    @javafx.fxml.FXML
    private TextArea notesTA;
    @javafx.fxml.FXML
    private Label successMessageLabel;


    private Appointment appointmentToMarkAsSeen;
    private ObservableList<Appointment> appointmentList = FXCollections.observableArrayList();
    private ObservableList<Prescription> prescriptionList = FXCollections.observableArrayList();
    private ArrayList<String> medicineList;

    @javafx.fxml.FXML
    public void initialize() {
    }

    public ObservableList<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    public void setPrescriptionList(ObservableList<Prescription> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }

    public ObservableList<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public Appointment getAppointmentToMarkAsSeen() {
        return appointmentToMarkAsSeen;
    }

    public void setAppointmentToMarkAsSeen(Appointment appointmentToMarkAsSeen) {
        this.appointmentToMarkAsSeen = appointmentToMarkAsSeen;
    }

    public void setAppointmentList(ObservableList<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    @javafx.fxml.FXML
    public void addNotesToPrescriptionAndMarkPatientAsSeenButtonOA (ActionEvent actionEvent) {

        if (medicineList == null) {
            medicineList = new ArrayList<>();
        }


        if (notesTA.getText().isEmpty()) {
            errorMessageLabel.setText("Please enter note");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Confirm");
        alert.setContentText("Press Confirm to mark Patient as Seen and Save Notes");
        if(alert.showAndWait().isPresent()) {

            for (Appointment a : appointmentList) {
                if (a.equals(appointmentToMarkAsSeen)) {
                    a.setSeen(true);
                    AppointmentFileManager.writeAll(appointmentList);
                    prescriptionList.add( new Prescription(
                            a.getName(),
                            a.getGender(),
                            a.getAge(),
                            medicineList,
                            "TBA",
                            LocalDate.now(),
                            notesTA.getText()
                            )
                    );
                    GenericFileManager.writeAll(prescriptionList, "Prescription.bin");
                    successMessageLabel.setText("Patient seen and Notes saved");
                }

            }
        }

    }
}