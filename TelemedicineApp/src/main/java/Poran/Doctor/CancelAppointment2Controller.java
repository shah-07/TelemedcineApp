package Poran.Doctor;

import Imtia.Appointment;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.*;
import java.util.ArrayList;

public class CancelAppointment2Controller
{
    @javafx.fxml.FXML
    private TextArea reasonTA;
    @javafx.fxml.FXML
    private Label errorMessageLabel;
    @javafx.fxml.FXML
    private Label successMessageLabel;


    private Appointment appointmentToDelete;
    private CancelAppointmentController parentController;

    @javafx.fxml.FXML
    public void initialize() {
    }

    public void setParentController(CancelAppointmentController parentController) {
        this.parentController = parentController;
    }

    public void setAppointmentToDelete (Appointment appointment) {
        this.appointmentToDelete = appointment;
    }

    @javafx.fxml.FXML
    public void confirmCancelButtonOA(ActionEvent actionEvent) {
        errorMessageLabel.setText("");
        successMessageLabel.setText("");

        if (reasonTA.getText().length()>250){
            errorMessageLabel.setText("Reason cannot exceed 250 characters");
            return;
        }

        try {
            ArrayList<Appointment> allAppointments = new ArrayList<>();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Appointment.bin"))) {
                while (true) {
                    try {
                        allAppointments.add((Appointment) ois.readObject());
                    }
                    catch (EOFException eof) {
                        break;
                    }
                }
            }

            allAppointments.remove(appointmentToDelete);

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Appointment.bin"))) {
                for (Appointment a : allAppointments) {
                    oos.writeObject(a);
                }
            }
            successMessageLabel.setText("Appointment deleted successfully");
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("Success");
            a.setContentText("Appointment deleted successfully");
            a.showAndWait();
            if (parentController != null) {
                parentController.refreshAppointments();
            }
        }


        catch (Exception e) {
            errorMessageLabel.setText("Error deleting appointment.");
        }
    }
}