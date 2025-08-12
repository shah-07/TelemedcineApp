package Poran.Doctor;

import Imtia.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.LocalTime;

public class CancelAppointmentController
{
    @javafx.fxml.FXML
    private TableColumn<Appointment, LocalDate> dateTCOfCancelAppointments;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> genderTCOfCancelAppointments;
    @javafx.fxml.FXML
    private TableColumn<Appointment, Integer> ageTCOfCancelAppointments;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> nameTCOfCancelAppointments;
    @javafx.fxml.FXML
    private TableColumn<Appointment, LocalTime> timeTCOfCancelAppointments;
    @javafx.fxml.FXML
    private TableView<Appointment> pendingAppointmentsTableView;
    @javafx.fxml.FXML
    private DatePicker chooseDateDP;
    @javafx.fxml.FXML
    private TextField toTimeTF;
    @javafx.fxml.FXML
    private TextField fromTimeTF;
    @javafx.fxml.FXML
    private Button requestForCancellationButton;
    @javafx.fxml.FXML
    private AnchorPane anchorPane;
    @javafx.fxml.FXML
    private Label successMessageLabel;
    @javafx.fxml.FXML
    private Label errorMessageLabel;

    private ObservableList<Appointment> appointmentList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        dateTCOfCancelAppointments.setCellValueFactory(new PropertyValueFactory<>("dateOfAppointment"));
        genderTCOfCancelAppointments.setCellValueFactory(new PropertyValueFactory<>("gender"));
        ageTCOfCancelAppointments.setCellValueFactory(new PropertyValueFactory<>("age"));
        nameTCOfCancelAppointments.setCellValueFactory(new PropertyValueFactory<>("name"));
        timeTCOfCancelAppointments.setCellValueFactory(new PropertyValueFactory<>("timeOfAppointment"));
        pendingAppointmentsTableView.setItems(appointmentList);

    }


    @javafx.fxml.FXML
    public void loadAppointmentsButtonOA(ActionEvent actionEvent) {

        appointmentList.clear();
        pendingAppointmentsTableView.getItems().clear();
        boolean found = false;
        LocalTime fromTime = LocalTime.parse(fromTimeTF.getText());
        LocalTime toTime = LocalTime.parse(toTimeTF.getText());

        try{
            FileInputStream fis = new FileInputStream("Appointment.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true){
                Appointment s = (Appointment) ois.readObject();
                if (chooseDateDP.getValue().equals(s.getDateOfAppointment()) && ((s.getTimeOfAppointment().equals(fromTime) || s.getTimeOfAppointment().isAfter(fromTime)) && (s.getTimeOfAppointment().equals(toTime) || s.getTimeOfAppointment().isBefore(toTime)))) {
                    appointmentList.add(s);
                    found = true;
                }
            }
        }

        catch (EOFException eof) {
            if (found){
                successMessageLabel.setText("Appointment Loaded");
            }
            else {
                errorMessageLabel.setText("No appointments to show");
            }
        }
        catch (Exception e) {
            e.printStackTrace(); // Helpful for debugging
            errorMessageLabel.setText("Error reading appointment file.");
        }


    }

    @javafx.fxml.FXML
    public void goToWriteReasonAndCancelAppointmentButtonOA(ActionEvent actionEvent) {

        Appointment selectedAppointment = pendingAppointmentsTableView.getSelectionModel().getSelectedItem();

        if (selectedAppointment != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Poran/Doctor/cancelAppointmentView2.fxml"));
                Node node = loader.load();
                CancelAppointment2Controller nextController = loader.getController();
                nextController.setAppointmentToDelete(selectedAppointment);
                nextController.setParentController(this);
                anchorPane.getChildren().setAll(node);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            errorMessageLabel.setText("Please select an appointment first");
        }

    }

    public void refreshAppointments() {
        appointmentList.clear();
        loadAppointmentsButtonOA(null);
    }

}

