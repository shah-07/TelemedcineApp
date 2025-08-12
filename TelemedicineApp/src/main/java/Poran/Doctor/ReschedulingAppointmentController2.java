package Poran.Doctor;

import Imtia.Appointment;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;

public class ReschedulingAppointmentController2
{
    @javafx.fxml.FXML
    private Label successMessageLabel;
    @javafx.fxml.FXML
    private Label errorMessageLabel;
    @javafx.fxml.FXML
    private DatePicker newDateDP;
    @javafx.fxml.FXML
    private TextArea reasonTA;
    @javafx.fxml.FXML
    private TextField newTimeTF;


    private Appointment appointmentToReschedule;
    private RescheduleAppointmentController parentController;


    public void setParentController(RescheduleAppointmentController parentController) {
        this.parentController = parentController;
    }

    public void setAppointmentToReschedule (Appointment appointment) {
        this.appointmentToReschedule = appointment;
    }


    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void confirmRescheduleButtonOA(ActionEvent actionEvent) {
        errorMessageLabel.setText("");
        successMessageLabel.setText("");

        if (reasonTA.getText().length()>200){
            errorMessageLabel.setText("Reason cannot exceed 200 characters");
            return;
        }

        if(newDateDP.getValue()==null){
            errorMessageLabel.setText("Please select a date");
            return;
        }

        if(newTimeTF.getText().isEmpty()){
            errorMessageLabel.setText("Please select a time in 24 hours format");
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

            for (Appointment a : allAppointments) {

                if (a.equals(appointmentToReschedule)) {
                    a.setDateOfAppointment(newDateDP.getValue());
                    a.setTimeOfAppointment(LocalTime.parse(newTimeTF.getText().trim()));
                    break;
                }
            }

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